public class VendingMachine {

    private int collectedCash;
    private State state;
    private Map<String, Set<String>> productCodeItemMap;
    private Map<String, Integer> productCodePriceMap;

    public VendingMachine() {
        this.collectedCash = 0;
        this.state = State.READY;
    }

    public void collectCash(int cash) {
        switch (state) {
            case READY:
                handleCollectCash(cash);
                break;
            case DISPENSE_CHANGE:
                throw new RuntimeException("Dispensing change. Unable to collect cash");
            case DISPENSE_ITEM:
                throw new RuntimeException("Dispensing item. Unable to collect cash");
            case TRANSACTION_CANCELLED:
                throw new RuntimeException("Transaction cancelled. Unable to collect cash");

        }
    }

    public void dispenseItem(String productCode) {
        switch (state) {
            case READY:
                throw new RuntimeException("Unable to dispense Item. Cash not collected")
            case DISPENSE_CHANGE:
                handleDispenseChange(productCode);
                break;
            case DISPENSE_ITEM:
                handleDispenseItem(productCode);
                break;
            case TRANSACTION_CANCELLED:
                throw new RuntimeException("Transaction cancelled. Unable to dispense Item");

        }
    }

    private void handleCollectCash(int cash) {
        this.collectedCash += cash;
    }

    private void handleDispenseItem(String productCode) {
        // logic to dispense item
    }

    private void handleDispenseChange(String productCode) {
        // logic to dispense Change
    }
}
