package net.maks.service;

import net.maks.dao.RoomDAO;
import net.maks.model.Room;
import javax.transaction.Transactional;
import java.util.List;

public class RoomServiceImpl implements RoomService{
    private RoomDAO roomDAO;

    public void setRoomDAO(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    @Transactional
    public void addRoom(Room room) {
        this.roomDAO.addRoom(room);
    }

    @Transactional
    public List<Room> getRooms() {
        return this.roomDAO.getRooms();
    }

    @Transactional
    public Room getRoom(int id) {
        return this.roomDAO.getRoom(id);
    }


    @Transactional
    public void editRoom(int id, Room room) {
        this.roomDAO.editRoom(id, room);
    }

    @Transactional
    public void deleteRoom(int id) {
        this.roomDAO.deleteRoom(id);
    }
}
