public class Card {
    private String cardNumber;
    private int pin;
    private Account account;

    public boolean validatePin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public Account getAccount() {
        return account;
    }
}
