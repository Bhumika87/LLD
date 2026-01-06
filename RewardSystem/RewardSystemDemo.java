public class RewardSystemDemo {

    public static void main(String[] args) {

        RewardWalletService walletService = new RewardWalletService();

        RewardRequest req = new RewardRequest(
                "user1",
                "PURCHASE",
                "order123",
                1000
        );

        walletService.creditReward(req);
        walletService.creditReward(req); // duplicate

        walletService.reverseReward("user1", "order123");
    }
}
