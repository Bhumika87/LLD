package vehicleFactoryPattern.ConcreteVehicles;

import vehicleFactoryPattern.Vehicle;
import vehicleFactoryPattern.VehicleType;

public class Truck extends Vehicle {
    public Truck(int vehicleNumber) {
        super(vehicleNumber, VehicleType.TRUCK);
    }

}