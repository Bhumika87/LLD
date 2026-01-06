public class BalanceInquiry extends Transaction {

    public BalanceInquiry(Account account) {
        super(account);
    }

    @Override
    public void execute() {
        System.out.println("Available Balance: " + account.getBalance());
    }

}

