package control;

import DAO.EventDAO;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Event;
import view.ConfirmWindow;
import view.EventWindow;

public class EventController {
    
    EventWindow view;
    EventDAO model;
    File file;
    public EventController(){}
    public EventController(EventWindow x, EventDAO y)
    {
        view = x;
        model = y;
        //Listener per il tasto di scelta della locandina
        view.getChooseImgButton().addActionListener((ActionEvent e) -> {
            JFileChooser fc = new JFileChooser();
            int returnVal = fc.showOpenDialog(view);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = fc.getSelectedFile();
                if(checkValidExtension(file.getName()) == 1)
                {
                    view.getLabelFile().setText(file.getName());
                } else 
                {
                    JOptionPane.showMessageDialog(view, "ERRORE, DEVI CARICARE UN'IMMAGINE");
                }
            }
        });
        
        //Listener per il tasto di inserimento evento
        view.getInsertButton().addActionListener((ActionEvent e) -> {
            EventDAO dao = new EventDAO();
            ArrayList<Event> eventi = dao.getAllEvent();
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
                    dao.insertEvent(evento);
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
                    ArrayList<String> city = EventController.getCityEvent();
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
        });
        
        //Listener per selezione dell'evento dalla tabella
        view.getEventTable().addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTable table = view.getEventTable();
                int row = table.rowAtPoint(e.getPoint());
                //System.out.println(table.getValueAt(row, 6).toString().length());
                view.getUpdateButton().setEnabled(true);
                if(table.getValueAt(row, 9).toString().equals("0"))
                {
                    view.getDeleteButton().setEnabled(true);
                }else 
                {
                    view.getDeleteButton().setEnabled(false);
                }
                
                view.getIdField().setText(table.getValueAt(row, 0).toString());
                
                if(table.getValueAt(row, 1) != null)
                {
                    view.getTitleField().setText(table.getValueAt(row, 1).toString());
                } else 
                {
                    view.getTitleField().setText("");
                }
                String[] type = {"Concerto", "Mostra", "Spettacolo", "Teatro"};
                for (int i = 0; i<type.length; i++)
                {
                    if (table.getValueAt(row, 2).toString().equals(type[i]))
                    view.getTypeField().setSelectedIndex(i); 
                }
                
                if(table.getValueAt(row, 3) != null)
                {
                    view.getPositionField().setText(table.getValueAt(row, 3).toString());
                } else 
                {
                    view.getPositionField().setText("");
                }
                if(table.getValueAt(row, 4) != null)
                {
                    view.getCityField().setText(table.getValueAt(row, 4).toString());
                } else 
                {
                    view.getCityField().setText("");
                }
                if(table.getValueAt(row, 5) != null)
                {
                    view.getDateTableField().setText(table.getValueAt(row, 5).toString());
                } else 
                {
                    view.getDateTableField().setText("");
                }
                if(table.getValueAt(row, 6) != null)
                {
                    view.getHourField().setText(table.getValueAt(row, 6).toString());
                } else 
                {
                    view.getHourField().setText("");
                }
                if(table.getValueAt(row, 7) != null)
                {
                    view.getPriceField().setText(table.getValueAt(row, 7).toString());
                } else 
                {
                    view.getPriceField().setText("");
                }
                if(table.getValueAt(row, 8) != null)
                {
                    view.getTicketsAvaibleField().setText(table.getValueAt(row, 8).toString());
                } else 
                {
                    view.getTicketsAvaibleField().setText("");
                }
                if(table.getValueAt(row, 10) != null)
                {
                    view.getDescriptionField().setText(table.getValueAt(row, 10).toString());
                } else 
                {
                    view.getDescriptionField().setText("");
                }
            }
            

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
               
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
            
        });
        
        view.getUpdateButton().addActionListener((ActionEvent e) -> {
            EventDAO modello = new EventDAO();
            ArrayList<Event> eventi = modello.getAllEvent();
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
            
            
            modello.updateEvent(evento);
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
            ArrayList<String> city = EventController.getCityEvent();
            String[] città = new String[city.size()+1];
            città[0] = "-";  
            for (int i=1; i<city.size()+1; i++)
                città[i] = city.get(i-1);
            view.getCitySearchField().setModel(new javax.swing.DefaultComboBoxModel<>(città));
        });
        
        view.getDeleteButton().addActionListener((ActionEvent e) -> 
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
        });
        
        view.getTypeSearchField().addActionListener((ActionEvent e) -> 
        {
            EventDAO event = new EventDAO();
            JComboBox type = view.getTypeSearchField();
            JComboBox city = view.getCitySearchField();
            ArrayList<Event> eventi = refreshRecordSearch(city.getSelectedItem().toString(), type.getSelectedItem().toString());
            view.refreshTableSearch(eventi);
        });
        
        view.getCitySearchField().addActionListener((ActionEvent e) -> 
        {
            EventDAO event = new EventDAO();
            JComboBox type = view.getTypeSearchField();
            JComboBox city = view.getCitySearchField();
            ArrayList<Event> eventi = refreshRecordSearch(city.getSelectedItem().toString(), type.getSelectedItem().toString());
            view.refreshTableSearch(eventi);
        });
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
    
    public int checkValidExtension(String namefile)
    {
        
        if(namefile.endsWith(".jpg"))
        {
            return 1;
        }
        return -1;
    }
}
