class RewardRequest {
    String userId;
    String actionType;
    String referenceId;
    double amount;

    RewardRequest(String userId, String actionType, String referenceId, double amount) {
        this.userId = userId;
        this.actionType = actionType;
        this.referenceId = referenceId;
        this.amount = amount;
    }
}
