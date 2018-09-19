package control;

import dao.mysql.EventDAO;
import dao.interfaces.InterfaceEventDAO;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.Event;
import view.ConfirmWindow;
import view.EventWindow;

public class EventController {
    
    EventWindow view;
    InterfaceEventDAO model;
    File file;
    public EventController(){}
    public EventController(EventWindow x)
    {
        view = x;
        model = new EventDAO();
    }
    
    public void filter()
    {
        EventDAO event = new EventDAO();
            JComboBox type = view.getTypeSearchField();
            JComboBox city = view.getCitySearchField();
            ArrayList<Event> eventi = refreshRecordSearch(city.getSelectedItem().toString(), type.getSelectedItem().toString());
            view.refreshTableSearch(eventi);
    }
    
     public static ArrayList<Event> refreshRecord() {
        EventDAO model = new EventDAO();
        return model.getAllEvent();
    }
     
    public static ArrayList<Event> refreshRecordSearch(String x, String y) {
        EventDAO model = new EventDAO();
        return model.getEventFiltered(x, y);
    }
    
    public static ArrayList<String> getCityEvent() {
        EventDAO model = new EventDAO();
        return model.getCityEvent();
    }
    
    public void insertEvent()
    {
        //EventDAO dao = new EventDAO();
            ArrayList<Event> eventi = model.getAllEvent();
            Event evento = new Event();
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),Locale.ITALY);
            Date today = calendar.getTime();
            if(view.getDateField().getDate() != null && view.getDateField().getDate().compareTo(today) >= 0){
                evento.setId("1");
                evento.setTitle(view.getTitleField().getText());
                evento.setPosition(view.getPositionField().getText());
                evento.setCity(view.getCityField().getText());
                evento.setType(view.getTypeField().getSelectedItem().toString());
                if(view.getDateField().getDate().toString().contains("CEST"))
                    evento.setDate(view.getDateField().getDate().toString().substring(0, 10) + " " + view.getDateField().getDate().toString().substring(25, 29));
                else evento.setDate(view.getDateField().getDate().toString().substring(0, 10) + " " + view.getDateField().getDate().toString().substring(24, 28));
                evento.setHour(view.getHourField().getText());
                evento.setPrice(view.getPriceField().getText());
                evento.setTicketsAvaible(view.getTicketsAvaibleField().getText());
                evento.setDescription(view.getDescriptionField().getText());
                if(file != null) 
                {
                    evento.setImage(file);
                    model.insertEvent(evento);
                    view.getTitleField().setText("");
                    view.getPositionField().setText("");
                    view.getCityField().setText("");
                    view.getTypeField().setSelectedIndex(0);
                    view.getDateField().setDate(null);
                    view.getHourField().setText(":");
                    view.getPriceField().setText("");
                    view.getTicketsAvaibleField().setText("");
                    file = null;
                    view.getLabelFile().setText("");
                    view.getDescriptionField().setText("");
                    view.refreshTable();
                    view.refreshTableS();
                    ArrayList<String> city = getCityEvent();
                    String[] città = new String[city.size()+1];
                    città[0] = "-";  
                    for (int i=1; i<city.size()+1; i++)
                        città[i] = city.get(i-1);
                    view.getCitySearchField().setModel(new javax.swing.DefaultComboBoxModel<>(città));
                }
                else                
                {
                    JOptionPane.showMessageDialog(view, "ERRORE, DEVI CARICARE UN'IMMAGINE");
                }
            } else
            {
                if(view.getDateField().getDate() == null)
                {
                    JOptionPane.showMessageDialog(view, "DEVI INSERIRE UNA DATA");
                }else JOptionPane.showMessageDialog(view, "Non è possibile inserire eventi con data precedente alla odierna");
            }
    }
    
    public void updateEvent()
    {
        //EventDAO modello = new EventDAO();
            ArrayList<Event> eventi = model.getAllEvent();
            Event evento = new Event();
            
            evento.setId(view.getIdField().getText());
            evento.setTitle(view.getTitleField().getText());
            evento.setPosition(view.getPositionField().getText());
            evento.setCity(view.getCityField().getText());
            evento.setPrice(view.getPriceField().getText());
            evento.setTicketsAvaible(view.getTicketsAvaibleField().getText());
            evento.setDescription(view.getDescriptionField().getText());
            evento.setHour(view.getHourField().getText());
            if(view.getDateField().getDate() != null ){
                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),Locale.ITALY);
                Date today = calendar.getTime();
                if(view.getDateField().getDate().compareTo(today) >= 0){
                    if(view.getDateField().getDate().toString().contains("CEST"))
                        evento.setDate(view.getDateField().getDate().toString().substring(0, 10) + " " + view.getDateField().getDate().toString().substring(25, 29));
                    else evento.setDate(view.getDateField().getDate().toString().substring(0, 10) + " " + view.getDateField().getDate().toString().substring(24, 28));
                }else
                {
                    JOptionPane.showMessageDialog(view, "Non è possibile modificare un evento inserendo una data precedente alla data odierna");
                }
            }
            if(file != null){
                evento.setImage(file);
            }
            evento.setType(view.getTypeField().getSelectedItem().toString());
            
            
            model.updateEvent(evento);
            view.getTitleField().setText("");
            view.getPositionField().setText("");
            view.getCityField().setText("");
            view.getTypeField().setSelectedIndex(0);
            view.getDateField().setDate(null);
            view.getHourField().setText(":");
            view.getPriceField().setText("");
            view.getTicketsAvaibleField().setText("");
            view.getDescriptionField().setText("");
            file = null;
            view.getLabelFile().setText("");
            view.refreshTable();
            view.refreshTableS();
            ArrayList<String> city = getCityEvent();
            String[] città = new String[city.size()+1];
            città[0] = "-";  
            for (int i=1; i<city.size()+1; i++)
                città[i] = city.get(i-1);
            view.getCitySearchField().setModel(new javax.swing.DefaultComboBoxModel<>(città));
    }
    
    public void deleteEvent()
    {
        Event evento = new Event();
            evento.setId(view.getIdField().getText());
            evento.setTitle(view.getTitleField().getText());
            evento.setType(view.getTypeField().getSelectedItem().toString());
            evento.setHour(view.getHourField().getText());
            evento.setTicketsAvaible(view.getTicketsAvaibleField().getText());
            evento.setPrice(view.getPriceField().getText());
            evento.setCity(view.getCityField().getText());
            evento.setPosition(view.getPositionField().getText());
            ConfirmWindow dialog = new ConfirmWindow(view, true, evento);
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            dialog.setLocation(new Point((dimension.width - dialog.getSize().width) / 2, 
            (dimension.height - dialog.getSize().height) / 2 ));
            dialog.setVisible(true);
    }
    
    public int chooseFile()
    {
        JFileChooser fc = new JFileChooser();
            int returnVal = fc.showOpenDialog(view);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = fc.getSelectedFile();
                if(checkValidExtension(file.getName()) == 1)
                {
                    view.getLabelFile().setText(file.getName());
                    return 1;
                } else 
                {
                    JOptionPane.showMessageDialog(view, "ERRORE, DEVI CARICARE UN'IMMAGINE");
                }
            }
            return -1;
    }    
    
    public int checkValidExtension(String x) 
    {
        if(x.endsWith(".jpg"))
                {
                    
                    return 1;
                }
        return -1;
    }
}
