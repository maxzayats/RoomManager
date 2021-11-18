package net.maks.service;

import net.maks.model.Room;

import java.util.List;

public interface RoomService {
    public void addRoom(Room room);
    public List<Room> getRooms();
    public Room getRoom(int id);
    public void editRoom(int id,Room room);
    public void deleteRoom(int id);
}
