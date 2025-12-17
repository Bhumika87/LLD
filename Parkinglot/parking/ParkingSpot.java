package parking;

import vehicleFactoryPattern.Vehicle;
import vehicleFactoryPattern.VehicleType;

public class ParkingSpot {

    public int parkingId;
    public boolean isFree = true;

    public SpotType spotType;

    public  Vehicle vehicle;

    public boolean canFit(Vehicle vehicle){
        return ((vehicle.type == VehicleType.CAR && spotType ==SpotType.MEDIUM) ||
                (vehicle.type == VehicleType.BIKE && spotType ==SpotType.SMALL) ||
                (vehicle.type == VehicleType.TRUCK && spotType ==SpotType.LARGE));
    }

    public void occupy(Vehicle vehicle){
        this.vehicle = vehicle;
        this.isFree = false;
    }

    public void freeSpot(){
        this.vehicle =  null;
        this.isFree = true;
    }

    public boolean isFree() { return isFree; }
    public SpotType getType() { return spotType; }

}
