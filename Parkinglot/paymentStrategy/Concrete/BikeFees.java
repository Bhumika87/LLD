package paymentStrategy.Concrete;

public class BikeFees implements paymentStrategy.FeeStrategy {
    private static final int RATE_PER_HOUR = 20; // Example rate for bike parking

    @Override
    public int CalculateFee(int hoursParked) {
        return RATE_PER_HOUR * hoursParked;
    }
}
