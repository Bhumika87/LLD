package paymentStrategy.Concrete;

public class CarFees implements paymentStrategy.FeeStrategy {
    private static final int RATE_PER_HOUR = 30; // Example rate for car parking

    @Override
    public int CalculateFee(int hoursParked) {
        return RATE_PER_HOUR * hoursParked;
    }

}

