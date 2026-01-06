public class DepositTransaction extends Transaction {
    private double amount;

    public DepositTransaction(Account account, double amount) {
        super(account);
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.credit(amount);
        System.out.println("Amount deposited: " + amount);
    }
}

