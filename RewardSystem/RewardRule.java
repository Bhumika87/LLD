interface RewardRule {
    boolean isApplicable(RewardRequest request);
    int calculatePoints(RewardRequest request);
}
