package parking;

import vehicleFactoryPattern.Vehicle;

import java.util.List;

public class ParkingFloor {
    public int floorNumber;
    public List<ParkingSpot> parkingSpots;

    public ParkingSpot getFreeSpot(Vehicle v) {
        for(ParkingSpot parkingSpot : parkingSpots){
            if(parkingSpot.isFree() && parkingSpot.canFit(v)){
                return parkingSpot;
            }
        }
        return null;
    }

}
