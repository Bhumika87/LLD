import java.util.Arrays;
import java.util.List;

public class ElevatorController {

    public static void main(String[] args) {

        Floor f0 = new Floor(0);
        Floor f1 = new Floor(1);
        Floor f2 = new Floor(2);
        Floor f3 = new Floor(3);
        Floor f4 = new Floor(4);
        Floor f5 = new Floor(5);
        Floor f6 = new Floor(6);
        Floor f7 = new Floor(7);
        Floor f8 = new Floor(8);
        Floor f9 = new Floor(9);

        List<Floor> floors = Arrays.asList(f0, f1, f2, f3,f4,f5,f6,f7,f8,f9);


        Elevator e1 = new Elevator(1);
        Elevator e2 = new Elevator(2);

        List<Elevator> elevators = Arrays.asList(e1, e2);

        Building building = new Building(floors, elevators);
        //PRINT HOW MANY FLOORS and elevators are there
        System.out.println("Building has " + floors.size() + " floors.");
        System.out.println("Building has " + elevators.size() + " elevators.");


        Scheduler scheduler = new Scheduler();

        HallRequest req1 = new HallRequest(2, Direction.UP);
        System.out.println("\n---- Hall Request: Floor 2 UP ---");
        Elevator assigned1 = scheduler.assignElevator(req1, building.getElevators());
        System.out.println("\n----- Request at Floor: " + req1.getFloor() + " Direction: " + req1.getDirection());

        System.out.println("\n---- Assigned Elevator = " + assigned1.getId());
        // Inside elevator user presses floor 5
        System.out.println("\n--- Car Request: Floor 5 ---");

        assigned1.addCarRequest(8);
        assigned1.step();


        HallRequest requestRandom = new HallRequest(2, Direction.UP);
        System.out.println("Request at Floor: " + req1.getFloor() + " Direction: " + req1.getDirection());
        Elevator assignedLifttt = scheduler.assignElevator(requestRandom, building.getElevators());
        // Inside elevator user presses floor 2
        assignedLifttt.addCarRequest(9);
        assignedLifttt.step();


        HallRequest req2 = new HallRequest(6, Direction.DOWN);

        System.out.println("Request at Floor: " + req1.getFloor() + " Direction: " + req1.getDirection());

        Elevator assigned2 = scheduler.assignElevator(req2, building.getElevators());
        System.out.println("Assigned Elevator = " + assigned2.getId());
        // Inside elevator user presses floor 2
        assigned2.addCarRequest(2);
        assigned2.step();

        // 3rd Request: Floor 1, UP
        HallRequest req3 = new HallRequest(1, Direction.UP);
        Elevator assigned3 = scheduler.assignElevator(req3, building.getElevators());
        System.out.println("Assigned Elevator = " + assigned3.getId());
        // Inside elevator user presses floor 6
        assigned3.addCarRequest(6);
        assigned3.step();

        // 4th Request: Floor 7, DOWN
        HallRequest req4 = new HallRequest(7, Direction.DOWN);
        Elevator assigned4 = scheduler.assignElevator(req4, building.getElevators());
        System.out.println("Assigned Elevator = " + assigned4.getId());
        // Inside elevator user presses floor 1
        assigned4.addCarRequest(1);
        assigned4.step();


    }

}
