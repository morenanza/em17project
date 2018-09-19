package control;

import dao.mysql.EventDAO;
import dao.interfaces.InterfaceEventDAO;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import model.Event;
import view.ConfirmWindow;
import view.EventWindow;

public class DeleteController {
    ConfirmWindow view;
    EventWindow parent;
    Event evento;
    InterfaceEventDAO model;
    public DeleteController(EventWindow p, ConfirmWindow v, Event e)
    {
        view = v;
        parent = p;
        evento = e;
        model = new EventDAO();
    }
    
    public void confirm()
    {
            model.removeEvent(evento.getId());
            parent.getTitleField().setText("");
            parent.getPositionField().setText("");
            parent.getCityField().setText("");
            parent.getTypeField().setSelectedIndex(0);
            parent.getDateField().setDate(null);
            parent.getHourField().setText(":");
            parent.getPriceField().setText("");
            parent.getTicketsAvaibleField().setText("");
            parent.getDescriptionField().setText("");
            parent.refreshTable();
            parent.refreshTableS();
            ArrayList<String> city = EventController.getCityEvent();
            String[] città = new String[city.size()+1];
            città[0] = "-";  
            for (int i=1; i<city.size()+1; i++)
                città[i] = city.get(i-1);
            parent.getCitySearchField().setModel(new javax.swing.DefaultComboBoxModel<>(città));
            view.setVisible(false);
    }
    
    public void stop()
    {
        view.setVisible(false);
    }
}
