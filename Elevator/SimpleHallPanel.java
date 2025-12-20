class SimpleHallPanel extends HallPanel {

    @Override
    void pressUp() {
        upButton = true;
        System.out.println("Up button pressed");
    }

    @Override
    void pressDown() {
        downButton = true;
        System.out.println("Down button pressed");
    }
}
