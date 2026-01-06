class PurchaseRewardRule implements RewardRule {

    @Override
    public boolean isApplicable(RewardRequest request) {
        return "PURCHASE".equals(request.actionType);
    }

    @Override
    public int calculatePoints(RewardRequest request) {
        return (int) (request.amount * 0.05); // 5% reward
    }
}
