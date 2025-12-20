import java.util.Collections;
import java.util.PriorityQueue;

public class Elevator {
    private int id;

    private int currentFloor = 0;

    private Direction direction = Direction.IDLE;

    private State state = State.STOPPED;

    private PriorityQueue<Integer> upQueue = new PriorityQueue<>();

    private PriorityQueue<Integer> downQueue = new PriorityQueue<>(Collections.reverseOrder());

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
    }

    //elevator k andr floor request aayega to usko up ya down queue me daal dena hai
    // for example user na 5 floor press krna to agar elevator 3 floor pe hai to up queue me daal dena hai
    public void addCarRequest(int floor) {
        if (floor > currentFloor) {
            upQueue.add(floor);
            direction = Direction.UP;
        } else {
            downQueue.add(floor);
            direction = Direction.DOWN;
        }
    }

    public void step() {
        if (direction == Direction.UP) {
            if (!upQueue.isEmpty()) {
                int target = upQueue.poll();
                goToFloor(target);
            } else if (!downQueue.isEmpty()) {
                direction = Direction.DOWN;
            }
        } else if (direction == Direction.DOWN) {
            if (!downQueue.isEmpty()) {
                int target = downQueue.poll();
                goToFloor(target);
            } else if (!upQueue.isEmpty()) {
                direction = Direction.UP;
            }
        }
        if (upQueue.isEmpty() && downQueue.isEmpty()) {
            direction = Direction.IDLE;
        }
    }

    private void goToFloor(int floor) {
        System.out.println("Elevator " + id + " going to " + floor);
        currentFloor = floor;
        openDoor();
        closeDoor();
    }


    public boolean canServe(HallRequest request) {
        int requestFloor = request.getFloor();
        Direction requestDir = request.getDirection();

        // If elevator is idle it can serve any request
        if (this.direction == Direction.IDLE) {
            return true;
        }

        // If elevator is moving UP:
        if (this.direction == Direction.UP) {
            // Elevator can serve an UP request on same or above floors
            return requestDir == Direction.UP &&
                    requestFloor >= this.currentFloor;
        }

        // If elevator is moving DOWN:
        if (this.direction == Direction.DOWN) {
            // Elevator can serve a DOWN request on same or below floors
            return requestDir == Direction.DOWN &&
                    requestFloor <= this.currentFloor;
        }

        return false;
    }


    private void openDoor() {
        System.out.println("Elevator " + id + " doors OPEN at floor " + currentFloor);
    }

    private void closeDoor() {
        System.out.println("Elevator " + id + " doors CLOSE");
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
    public Direction getDirection() {
        return direction;
    }

    public int getId() {
        return id;
    }

}
