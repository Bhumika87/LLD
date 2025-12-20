class HallRequest {

    //hallrequest is jo hum bhar s up and down press krte hai that request go to scheduler
    // which contain ki currently request konse floor s ayi hai and direction kya hai.
    int floor;
    Direction direction;

    public HallRequest(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }
    public int getFloor() {
        return floor;
    }
    public Direction getDirection() {
        return direction;
    }
}