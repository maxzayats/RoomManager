package net.maks.dao;

import net.maks.model.Room;
import java.util.List;

public interface RoomDAO {
    public void addRoom(Room room);
    public List<Room> getRooms();
    public Room getRoom(int id);
    public void editRoom(int id, Room room);
    public void deleteRoom(int id);
}
