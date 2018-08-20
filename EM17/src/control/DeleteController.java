package control;

import DAO.EventDAO;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import model.Event;
import view.ConfirmWindow;
import view.EventWindow;

public class DeleteController {
    ConfirmWindow view;
    EventWindow parent;
    Event evento;
    public DeleteController(EventWindow p, ConfirmWindow v)
    {
        view = v;
        parent = p;
        evento = v.getEvent();
        if(evento.getTitle() != null)
            view.getTitleLabel().setText(evento.getTitle());
        if(evento.getType() != null)
            view.getTypeLabel().setText(evento.getType());
        view.getDateLabel().setText(parent.getDateTableField().getText());
        if(evento.getHour() != null)
            view.getHourLabel().setText(evento.getHour());
        if(evento.getTicketsAvaible() != null)
            view.getTicketsLabel().setText(evento.getTicketsAvaible());
        if(evento.getPrice() != null)
            view.getPriceLabel().setText(evento.getPrice());
        if(evento.getCity() != null)
            view.getCityLabel().setText(evento.getCity());
        if(evento.getPosition() != null)
            view.getPositionLabel().setText(evento.getPosition());
        
        view.getConfirmButton().addActionListener((ActionEvent e) -> 
        {
            EventDAO dao = new EventDAO();
            ArrayList<Event> eventi = dao.getAllEvent();
            dao.removeEvent(evento.getId());
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
        });
        
        view.getStopButton().addActionListener((ActionEvent e) -> 
        {
            view.setVisible(false);
        });
    }
}
