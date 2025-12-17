import parking.ParkingFloor;
import parking.ParkingSpot;
import paymentStrategy.Concrete.BikeFees;
import paymentStrategy.Concrete.BusFees;
import paymentStrategy.Concrete.CarFees;
import paymentStrategy.FeeStrategy;
import ticket.Ticket;
import vehicleFactoryPattern.Vehicle;
import vehicleFactoryPattern.VehicleType;

import java.util.List;
import java.util.UUID;

public class ParkingLot {
    public static ParkingLot instance;
    public List<ParkingFloor> parkingFloorList;

    private ParkingLot(List<ParkingFloor> floors) {
        this.parkingFloorList = floors;
    }

    public static ParkingLot getInstance(List<ParkingFloor> floors) {
        if (instance == null) instance = new ParkingLot(floors);
        return instance;
    }

    public Ticket parkVehicle(Vehicle vehicle){

        for(ParkingFloor parkingFloor : parkingFloorList){
            ParkingSpot spot = parkingFloor.getFreeSpot(vehicle);
            if(spot != null) {
                spot.occupy(vehicle);
                return new Ticket(UUID.randomUUID().toString(), vehicle, spot, System.currentTimeMillis());
            }
        }
        return null;
    }

    public void UnparkVehicle(Ticket ticket){
        ParkingSpot spot = ticket.parkingSpot;
        spot.freeSpot();

        Long duration = System.currentTimeMillis() - ticket.entryTime;
        System.out.println("Vehicle Unparked. Duration: " + duration + " ms");
        FeeStrategy feeStrategy = getStrategy(ticket.vehicle.type);
        feeStrategy.CalculateFee(Math.toIntExact(duration));
    }

    private FeeStrategy getStrategy(VehicleType type) {
        return switch (type) {
            case CAR -> new CarFees();
            case BIKE -> new BikeFees();
            case BUS -> new BusFees();
        };
    }

}
