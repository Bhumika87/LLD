import java.time.LocalDateTime;

class RewardTransaction {
    String transactionId;
    String userId;
    int points;
    String type; // EARN, REDEEM, REVERSAL
    String referenceId;
    LocalDateTime createdAt;

    RewardTransaction(String transactionId, String userId, int points,
                      String type, String referenceId) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.points = points;
        this.type = type;
        this.referenceId = referenceId;
        this.createdAt = LocalDateTime.now();
    }
}
