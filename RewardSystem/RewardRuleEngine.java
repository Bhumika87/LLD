import java.util.*;

class RewardRuleEngine {

    private final List<RewardRule> rules = new ArrayList<>();

    public RewardRuleEngine() {
        rules.add(new PurchaseRewardRule());
    }

    public int evaluate(RewardRequest request) {
        for (RewardRule rule : rules) {
            if (rule.isApplicable(request)) {
                return rule.calculatePoints(request);
            }
        }
        return 0;
    }
}
