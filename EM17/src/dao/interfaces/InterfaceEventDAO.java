package dao.interfaces;

import java.util.ArrayList;
import model.Event;

public interface InterfaceEventDAO {
        public ArrayList<Event> getAllEvent();
        public void insertEvent(Event e);
        public void updateEvent(Event e);
        public void removeEvent(String id);
        public ArrayList<Event> getEventFiltered(String city, String type);
}
