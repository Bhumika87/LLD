public class ATMMain {

    public static void main(String[] args) {

        // 1️⃣ Create account
        Account savingsAccount = new SavingsAccount("ACC123", 10000.0);

        // 2️⃣ Create card
        Card card = new Card("CARD999", 1234, savingsAccount);

        // 3️⃣ Insert card
        System.out.println("Card Inserted");

        // 4️⃣ Validate PIN
        int enteredPin = 1234;
        if (!card.validatePin(enteredPin)) {
            System.out.println("Invalid PIN");
            return;
        }
        System.out.println("PIN Verified");

        // 5️⃣ Get ATM instance
        ATM atm = ATM.getInstance();

        // 6️⃣ Withdraw transaction
        Transaction withdrawTxn =
                TransactionFactory.createTransaction(
                        TransactionType.WITHDRAW,
                        card.getAccount(),
                        2000
                );
        atm.performTransaction(withdrawTxn);

        // 7️⃣ Balance inquiry
        Transaction balanceTxn =
                TransactionFactory.createTransaction(
                        TransactionType.BALANCE,
                        card.getAccount(),
                        0
                );
        atm.performTransaction(balanceTxn);

        // 8️⃣ Deposit transaction
        Transaction depositTxn =
                TransactionFactory.createTransaction(
                        TransactionType.DEPOSIT,
                        card.getAccount(),
                        1500
                );
        atm.performTransaction(depositTxn);

        // 9️⃣ Eject card
        System.out.println("Card Ejected");
    }
}
