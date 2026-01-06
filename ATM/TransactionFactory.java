public class TransactionFactory {

    public static Transaction createTransaction(
            TransactionType type, Account account, double amount) {

        switch (type) {
            case WITHDRAW:
                return new WithdrawTransaction(account, amount);
            case DEPOSIT:
                return new DepositTransaction(account, amount);
            case BALANCE:
                return new BalanceInquiry(account);
            default:
                throw new IllegalArgumentException("Invalid Transaction");
        }
    }
}

