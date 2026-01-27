import java.util.UUID;

public class Participant implements Observer {
    private final String id;
    private final String name;
    private final Calendar calendar;

    public Participant(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.calendar = new Calendar();
    }

    public Calendar getCalendar() {
        return calendar;
    }

    @Override
    public void notify(String message) {
        System.out.println("Notify " + name + ": " + message);
    }
}

