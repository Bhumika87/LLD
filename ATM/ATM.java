public class ATM {
    private static ATM atm = new ATM();

    private ATM() {}

    public static ATM getInstance() {
        return atm;
    }

    public void performTransaction(Transaction transaction) {
        transaction.execute();
        printReceipt();
    }

    private void printReceipt() {
        System.out.println("Receipt Printed");
    }

}