public class ElevatorRequest {

    private final int sourceFloor;
    private final int destinationFloor;

    public ElevatorRequest(int sourceFloor, int destinationFloor) {
        this.sourceFloor = sourceFloor;
        this.destinationFloor = destinationFloor;
    }

    public int getSourceFloor() {
        return sourceFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    @Override
    public String toString() {
        return "[Request: from " + sourceFloor + " → " + destinationFloor + "]";
    }
}
