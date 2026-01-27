import entity.MeetingStatus;
import entity.TimeSlot;

import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private final List<Meeting> meetings = new ArrayList<>();

    public boolean isAvailable(TimeSlot slot) {
        for (Meeting m : meetings) {
            if (m.getStatus() == MeetingStatus.SCHEDULED &&
                    m.getTimeSlot().overlaps(slot)) {
                return false;
            }
        }
        return true;
    }

    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
    }
}

