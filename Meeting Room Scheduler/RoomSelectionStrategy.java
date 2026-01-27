import entity.TimeSlot;

import java.util.List;

public interface RoomSelectionStrategy {
    MeetingRoom selectRoom(List<MeetingRoom> rooms, TimeSlot slot, int participantsCount);
}

