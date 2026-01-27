import entity.TimeSlot;

import java.util.List;

public class MeetingSchedulerService {
    private final List<MeetingRoom> rooms;
    private final RoomSelectionStrategy strategy;

    public MeetingSchedulerService(
            List<MeetingRoom> rooms,
            RoomSelectionStrategy strategy) {
        this.rooms = rooms;
        this.strategy = strategy;
    }

    public synchronized Meeting scheduleMeeting(
            TimeSlot slot,
            List<Participant> participants) {

        for (Participant p : participants) {
            if (!p.getCalendar().isAvailable(slot)) {
                throw new RuntimeException("Participant not available");
            }
        }

        MeetingRoom room = strategy.selectRoom(rooms, slot, participants.size());
        if (room == null) {
            throw new RuntimeException("No room available");
        }

        Meeting meeting = new Meeting(room, slot, participants);
        room.addMeeting(meeting);
        participants.forEach(p -> p.getCalendar().addMeeting(meeting));

        return meeting;
    }
}

