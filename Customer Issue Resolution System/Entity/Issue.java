package Entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Issue {
    private final String id;
    private final String transactionId;
    private final IssueType issueType;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getSlaDeadline() {
        return slaDeadline;
    }

    public void setSlaBreached(boolean slaBreached) {
        this.slaBreached = slaBreached;
    }

    private final String subject;
    private final String description;
    private final String customerEmail;

    private IssueStatus status;
    private Agent assignedAgent;
    private String resolution;

    private final LocalDateTime createdAt;
    private final LocalDateTime slaDeadline;

    private boolean slaBreached;

    public String getId() {
        return id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public IssueStatus getStatus() {
        return status;
    }

    public void setStatus(IssueStatus status) {
        this.status = status;
    }

    public Agent getAssignedAgent() {
        return assignedAgent;
    }

    public void setAssignedAgent(Agent assignedAgent) {
        this.assignedAgent = assignedAgent;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Issue(String transactionId, IssueType issueType,
                 String subject, String description, String customerEmail) {
        this.id = UUID.randomUUID().toString();
        this.transactionId = transactionId;
        this.issueType = issueType;
        this.subject = subject;
        this.description = description;
        this.customerEmail = customerEmail;
        this.status = IssueStatus.OPEN;
        this.createdAt = LocalDateTime.now();
        this.slaDeadline = createdAt.plusHours(issueType.getSlaHours());
        this.slaBreached = false;
    }

    public boolean isSlaBreached() {
        return LocalDateTime.now().isAfter(slaDeadline);
    }

}


