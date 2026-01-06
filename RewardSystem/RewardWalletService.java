import java.util.UUID;

class RewardWalletService {

    private final RewardRuleEngine ruleEngine = new RewardRuleEngine();

    public synchronized void creditReward(RewardRequest request) {

        // Idempotency check
        if (InMemoryDatabase.transactionExists(request.userId, request.referenceId)) {
            System.out.println("Duplicate reward request ignored");
            return;
        }

        int points = ruleEngine.evaluate(request);
        if (points <= 0) {
            return;
        }

        RewardWallet wallet = InMemoryDatabase.walletTable
                .computeIfAbsent(request.userId, RewardWallet::new);

        // Update wallet
        wallet.totalPoints += points;

        // Create transaction
        RewardTransaction txn = new RewardTransaction(
                UUID.randomUUID().toString(),
                request.userId,
                points,
                "EARN",
                request.referenceId
        );

        InMemoryDatabase.transactionTable.put(txn.transactionId, txn);

        System.out.println("Reward credited: " + points +
                " | Total balance: " + wallet.totalPoints);
    }

    public synchronized void reverseReward(String userId, String referenceId) {

        RewardTransaction originalTxn = InMemoryDatabase.transactionTable.values()
                .stream()
                .filter(t -> t.userId.equals(userId)
                        && t.referenceId.equals(referenceId)
                        && "EARN".equals(t.type))
                .findFirst()
                .orElse(null);

        if (originalTxn == null) {
            System.out.println("No transaction found to reverse");
            return;
        }

        RewardWallet wallet = InMemoryDatabase.walletTable.get(userId);
        wallet.totalPoints -= originalTxn.points;

        RewardTransaction reversalTxn = new RewardTransaction(
                UUID.randomUUID().toString(),
                userId,
                -originalTxn.points,
                "REVERSAL",
                referenceId
        );

        InMemoryDatabase.transactionTable.put(reversalTxn.transactionId, reversalTxn);

        System.out.println("Reward reversed: " + originalTxn.points +
                " | Total balance: " + wallet.totalPoints);
    }
}
