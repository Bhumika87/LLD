import Entity.*;

import java.util.*;

public class IssueResolutionService {

    private final Map<String, Issue> issues = new HashMap<>();
    private final Map<String, Agent> agents = new HashMap<>();

    // Create a new issue
    public Issue createIssue(String transactionId, IssueType issueType, String subject, String description, String email) {
        Issue issue = new Issue(transactionId, issueType, subject, description, email);
        issues.put(issue.getId(), issue);
        return issue;
    }

    // Assign an issue to an available agent
    public void addAgent(String agentEmail, String agentName, List<IssueType> types) {
        agents.put(agentEmail, new Agent(agentEmail, agentName, types));
    }

    public void assignIssue(String issueId) {
        Issue issue = issues.get(issueId);

        for (Agent agent : agents.values()) {
            if (agent.canHandle(issue.getIssueType())) {
                issue.setAssignedAgent(agent);
                issue.setStatus(IssueStatus.ASSIGNED);
                agent.assignIssue(issue);
                return;
            }
        }
        throw new RuntimeException("No available agent");
    }

    public List<Issue> getIssues(IssueStatus status) {
        return issues.values()
                .stream()
                .filter(i -> i.getStatus() == status)
                .toList();
    }

    public void updateIssue(String issueId, IssueStatus status, String resolution) {
        Issue issue = issues.get(issueId);
        issue.setStatus(status);
        issue.setResolution(resolution);
    }

    public void resolveIssue(String issueId, String resolution) {
        Issue issue = issues.get(issueId);
        issue.setStatus(IssueStatus.RESOLVED);
        issue.setResolution(resolution);

        issue.getAssignedAgent().resolveIssue();
    }

    public Map<String, List<Issue>> viewAgentsWorkHistory() {
        Map<String, List<Issue>> history = new HashMap<>();
        for (Agent agent : agents.values()) {
            history.put(agent.getEmail(), agent.getWorkedIssues());
        }
        return history;
    }

    public void checkSlaBreach(Collection<Issue> issues) {
        for (Issue issue : issues) {
            if (issue.getStatus() != IssueStatus.RESOLVED && issue.isSlaBreached()) {
                issue.setSlaBreached(true);
                System.out.println("SLA breached for issue " + issue.getId());
            }
        }
    }
}
