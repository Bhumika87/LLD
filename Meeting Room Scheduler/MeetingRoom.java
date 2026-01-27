import entity.TimeSlot;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoom {
    private final String roomId;
    private final int capacity;
    private final List<Meeting> bookings = new ArrayList<>();

    public MeetingRoom(String roomId, int capacity) {
        this.roomId = roomId;
        this.capacity = capacity;
    }

    public boolean isAvailable(TimeSlot slot) {
        for (Meeting m : bookings) {
            if (m.getTimeSlot().overlaps(slot)) {
                return false;
            }
        }
        return true;
    }

    public int getCapacity() {
        return capacity;
    }

    public void addMeeting(Meeting meeting) {
        bookings.add(meeting);
    }
}

