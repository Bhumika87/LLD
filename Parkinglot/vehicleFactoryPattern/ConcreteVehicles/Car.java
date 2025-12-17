package vehicleFactoryPattern.ConcreteVehicles;

import vehicleFactoryPattern.Vehicle;
import vehicleFactoryPattern.VehicleType;

public class Car extends Vehicle {

    public Car(int vehicleNumber) {
        super(vehicleNumber, VehicleType.CAR);
    }
}
