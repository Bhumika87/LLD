public class WithdrawTransaction extends Transaction {
    private double amount;

    public WithdrawTransaction(Account account, double amount) {
        super(account);
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.debit(amount);
        System.out.println("Please collect cash: " + amount);
    }
}
