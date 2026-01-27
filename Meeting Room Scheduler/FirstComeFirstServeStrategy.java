import entity.TimeSlot;

import java.util.List;

public class FirstComeFirstServeStrategy implements RoomSelectionStrategy {

    @Override
    public MeetingRoom selectRoom(
            List<MeetingRoom> rooms,
            TimeSlot slot,
            int participantsCount) {

        for (MeetingRoom room : rooms) {
            if (room.getCapacity() >= participantsCount &&
                    room.isAvailable(slot)) {
                return room;
            }
        }
        return null;
    }
}

