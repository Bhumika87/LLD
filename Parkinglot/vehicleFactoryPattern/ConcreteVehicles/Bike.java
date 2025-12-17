package vehicleFactoryPattern.ConcreteVehicles;

import vehicleFactoryPattern.Vehicle;
import vehicleFactoryPattern.VehicleType;

public class Bike extends Vehicle {
    public Bike(int vehicleNumber) {
        super(vehicleNumber, VehicleType.BIKE);
    }

}