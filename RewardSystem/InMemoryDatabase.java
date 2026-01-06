import java.util.*;

class InMemoryDatabase {

    static Map<String, RewardWallet> walletTable = new HashMap<>();
    static Map<String, RewardTransaction> transactionTable = new HashMap<>();

    static boolean transactionExists(String userId, String referenceId) {
        return transactionTable.values().stream()
                .anyMatch(t -> t.userId.equals(userId)
                        && t.referenceId.equals(referenceId));
    }
}
