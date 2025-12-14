public class NormalDice implements Dice {
    private final int faces = 6;

    @Override
    public int roll() {
        return (int) (Math.random() * faces) + 1;
    }
}
