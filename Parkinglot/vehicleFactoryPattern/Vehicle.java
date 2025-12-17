package vehicleFactoryPattern;

public abstract class Vehicle {
    private int VehicleNumber;
    public VehicleType type;

    public Vehicle(int vehicleNumber, VehicleType type) {
        this.VehicleNumber = vehicleNumber;
        this.type = type;
    }

}