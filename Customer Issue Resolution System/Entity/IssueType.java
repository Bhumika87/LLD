package Entity;

public enum IssueType {
    PAYMENT(2),
    REFUND(24),
    LOGIN(4),
    DELIVERY(48);

    private final int slaHours;

    IssueType(int slaHours) {
        this.slaHours = slaHours;
    }

    public int getSlaHours() {
        return slaHours;
    }
}

