package Entity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Agent {
    private final String email;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Set<IssueType> getExpertise() {
        return expertise;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    private final String name;
    private final Set<IssueType> expertise;
    private final List<Issue> workedIssues = new ArrayList<>();

    private boolean available = true;

    public Agent(String email, String name, List<IssueType> expertise) {
        this.email = email;
        this.name = name;
        this.expertise = new HashSet<>(expertise);
    }

    public boolean canHandle(IssueType type) {
        return expertise.contains(type) && available;
    }

    public void assignIssue(Issue issue) {
        available = false;
        workedIssues.add(issue);
    }

    public void resolveIssue() {
        available = true;
    }

    public List<Issue> getWorkedIssues() {
        return workedIssues;
    }
}

