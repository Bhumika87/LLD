import entity.MeetingStatus;
import entity.TimeSlot;

import java.util.List;
import java.util.UUID;

public class Meeting {
    private final String id;
    private final MeetingRoom room;
    private final TimeSlot timeSlot;
    private final List<Participant> participants;
    private MeetingStatus status;

    public Meeting(MeetingRoom room, TimeSlot timeSlot, List<Participant> participants) {
        this.id = UUID.randomUUID().toString();
        this.room = room;
        this.timeSlot = timeSlot;
        this.participants = participants;
        this.status = MeetingStatus.SCHEDULED;
        notifyAllParticipants("Meeting scheduled");
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public MeetingStatus getStatus() {
        return status;
    }

    public void cancel() {
        status = MeetingStatus.CANCELLED;
        notifyAllParticipants("Meeting cancelled");
    }

    private void notifyAllParticipants(String message) {
        participants.forEach(p -> p.notify(message));
    }
}

