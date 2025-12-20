import java.util.List;

public class Scheduler {

    public Elevator assignElevator(HallRequest request, List<Elevator> elevators) {

        Elevator bestElevator = null;
        int bestScore = Integer.MAX_VALUE;
        // first try to find an elevator that can serve the request in its current direction
        // then choose the closest one

        for (Elevator e : elevators) {
            if (e.canServe(request)) {
                int score = Math.abs(e.getCurrentFloor() - request.getFloor());
                if (score < bestScore) {
                    bestScore = score;
                    bestElevator = e;
                }
            }
        }
         // if none found, choose the closest idle elevator
        if (bestElevator == null) {
            for (Elevator e : elevators) {
                if (e.getDirection() == Direction.IDLE) {
                    int score = Math.abs(e.getCurrentFloor() - request.getFloor());
                    if (score < bestScore) {
                        bestScore = score;
                        bestElevator = e;
                    }
                }
            }
        }

        return bestElevator;
    }
}
