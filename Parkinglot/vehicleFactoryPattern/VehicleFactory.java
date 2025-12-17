package vehicleFactoryPattern;

import vehicleFactoryPattern.ConcreteVehicles.Bike;
import vehicleFactoryPattern.ConcreteVehicles.Car;
import vehicleFactoryPattern.ConcreteVehicles.Truck;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType type, int vehicleNumber){
        switch(type){
            case CAR:
                return new Car(vehicleNumber);
            case BIKE:
                return new Bike(vehicleNumber);
            case TRUCK:
                return new Truck(vehicleNumber);
            default:
                throw new IllegalArgumentException("Invalid vehicle type");
        }
    }
}