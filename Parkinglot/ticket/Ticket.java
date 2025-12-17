package ticket;

import parking.ParkingSpot;
import vehicleFactoryPattern.Vehicle;

public class Ticket {
    public String ticketNumber;
    public Vehicle vehicle;
    public ParkingSpot parkingSpot;
    public long entryTime;

    public Ticket(String ticketNumber, Vehicle vehicle, ParkingSpot parkingSpot, long entryTime) {
        this.ticketNumber = ticketNumber;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = entryTime;
    }

}
