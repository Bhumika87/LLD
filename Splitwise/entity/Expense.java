package entity;

import java.time.LocalDateTime;
import java.util.List;

public class Expense {
    private String id;
    private String description;
    private double amount;
    private User paidBy;
    private List<Split> splits;
    private LocalDateTime timestamp;

    public Expense(String id, String description, double amount, User paidBy, List<Split> splits, LocalDateTime timestamp) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
        this.timestamp = timestamp;
    }
    public String getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public double getAmount() {
        return amount;
    }
    public User getPaidBy() {
        return paidBy;
    }
    public List<Split> getSplits() {
        return splits;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }



}
