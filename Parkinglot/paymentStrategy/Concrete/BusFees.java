package paymentStrategy.Concrete;

public class BusFees implements paymentStrategy.FeeStrategy {
    private static final int RATE_PER_HOUR = 50; // Example rate for bus parking

    @Override
    public int CalculateFee(int hoursParked) {
        return RATE_PER_HOUR * hoursParked;
    }
}
