import java.util.List;

class Building {
    List<Floor> floors;
    List<Elevator> elevators;

    public Building(List<Floor> floors, List<Elevator> elevators) {
        this.floors = floors;
        this.elevators = elevators;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public List<Elevator> getElevators() {
        return elevators;
    }

    public Floor getFloor(int number) {
        return floors.stream()
                .filter(f -> f.number == number)
                .findFirst()
                .orElse(null);
    }
}