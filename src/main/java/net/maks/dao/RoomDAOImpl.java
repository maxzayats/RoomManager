package net.maks.dao;

import net.maks.model.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomDAOImpl implements RoomDAO {

    private static final Logger logger = LoggerFactory.getLogger(RoomDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void addRoom(Room room) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(room);
        logger.info("Rook successfully added, room detail" + room);
    }

    public List<Room> getRooms() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Room> roomList = session.createQuery("from Room").list();
        for(Room room: roomList){
            logger.info("Room list: " + room);
        }
        return roomList;
    }


    public Room getRoom(int id) {

        Session session = this.sessionFactory.getCurrentSession();
        Room room = (Room) session.load(Room.class, new Integer(id));
        logger.info("Room loaded. Details: " + room);
        return room;
    }



    public void editRoom(int id, Room updatedRoom) {
        Session session = this.sessionFactory.getCurrentSession();
        Room roomToBeUpdated = session.get(Room.class, id);

        roomToBeUpdated.setName(updatedRoom.getName());
        roomToBeUpdated.setSize(updatedRoom.getSize());
       roomToBeUpdated.setRentalPrice(updatedRoom.getRentalPrice());
    }


    /* public void editRoom(Room room) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(room);
        logger.info("Book edited. Room details: " + room);
    }
*/
    public void deleteRoom(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Room room = (Room) session.load(Room.class, new Integer(id));
        if (room!=null){
            session.delete(room);
        }
        logger.info("Room deleted. Details: " + room);
    }


}
