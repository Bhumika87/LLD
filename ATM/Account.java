public abstract class Account {
    protected String accountNumber;
    protected double balance;

    public double getBalance() {
        return balance;
    }

    public void debit(double amount) {
        if (balance < amount)
            throw new RuntimeException("Insufficient Balance");
        balance -= amount;
    }

    public void credit(double amount) {
        balance += amount;
    }

}
