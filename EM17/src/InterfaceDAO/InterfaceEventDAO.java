/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDAO;

import java.util.ArrayList;
import model.Event;

/**
 *
 * @author Morena
 */
public interface InterfaceEventDAO {
        public ArrayList<Event> getAllEvent();
        public void insertEvent(Event e);
        public void updateEvent(Event e);
        public void removeEvent(String id);
        public ArrayList<Event> getEventFiltered(String city, String type);
}
