package DAO;

import InterfaceDAO.InterfaceEventDAO;
import database.Database;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Event;

public class EventDAO implements InterfaceEventDAO {
    private final Database db = new Database();
    private final Connection conn = db.Connect();
    private Statement stm = null; 
    @Override
    public ArrayList<Event> getAllEvent() {
        ArrayList<Event> eventi = new ArrayList();
        try {
            String query = "SELECT * FROM em17.events";
            
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next())
            {
                Event evento = new Event();
                evento.setId(rs.getString("id"));
                evento.setTitle(rs.getString("title"));
                evento.setPosition(rs.getString("position"));
                evento.setCity(rs.getString("city"));
                evento.setDate(rs.getString("date"));
                evento.setHour(rs.getString("hour"));
                evento.setTicketsAvaible(rs.getString("ticketsAvaible"));
                evento.setTicketsSell(rs.getString("ticketsSell"));
                evento.setPrice(rs.getString("price"));
                evento.setType(rs.getString("type"));
                evento.setDescription(rs.getString("description"));
                
                eventi.add(evento);
            }
            
        }
        catch(SQLException e)
        {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }
        return eventi;
    
    }

    @Override
    public void insertEvent(Event e) {
        String sql = "INSERT INTO em17.events (title, position, city, date, hour, ticketsAvaible, ticketsSell, type, description, img, price) VALUES ('" + e.getTitle() + "', '" + e.getPosition() + "', '" + e.getCity() + "', '" + e.getDate() + "', '" + e.getHour() + "', '" + e.getTicketsAvaible() + "', '0', '" + e.getType() + "', '" + e.getDescription() + "', ?, '" + e.getPrice() + "')";
        PreparedStatement ps; 
        try {
            ps = conn.prepareStatement(sql);
            ps.setBytes(1, readFile(e.getImmagine()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EventDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //InputStream immagine = new FileInputStream(nome.getImg());      
    }

    @Override
    public void updateEvent(Event e) {
        if(e.getDate() == null && e.getImmagine() == null && e.getHour().substring(0, 1).equals(" ")){
            try {

                String sql = "UPDATE em17.events set title = '" + e.getTitle() + "', position = '" + e.getPosition() + "',"
                        + " city = '" + e.getCity() + "',"
                        + " ticketsAvaible = '" + e.getTicketsAvaible() + "',"
                        + " type = '" + e.getType() + "',"
                        + " description = '" + e.getDescription() + "', "
                        + " price = '" + e.getPrice() + "' where id =  '" + e.getId() + "'";
                stm.execute(sql);

            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(e.getDate() != null && e.getImmagine() != null && !(e.getHour().substring(0,1).equals(" ")))
        {
            

            String sql = "UPDATE em17.events set title = '" + e.getTitle() + "', position = '" + e.getPosition() + "',"
                    + " city = '" + e.getCity() + "',"
                    + " ticketsAvaible = '" + e.getTicketsAvaible() + "',"
                    + " type = '" + e.getType() + "',"
                    + " description = '" + e.getDescription() + "', "
                    + " price = '" + e.getPrice() + "', "
                    + " date = '" + e.getDate() + "', "
                    + " hour = '" + e.getHour() + "', "
                    + " img = ? where id =  '" + e.getId() + '"';
            PreparedStatement ps; 
            try {
                ps = conn.prepareStatement(sql);
                ps.setBytes(1, readFile(e.getImmagine()));
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(EventDAO.class.getName()).log(Level.SEVERE, null, ex);
            }   
        } else if(e.getDate() != null && e.getImmagine() == null && e.getHour().substring(0,1).equals(" "))
        {
            try {

                String sql = "UPDATE em17.events set title = '" + e.getTitle() + "', position = '" + e.getPosition() + "',"
                        + " city = '" + e.getCity() + "',"
                        + " ticketsAvaible = '" + e.getTicketsAvaible() + "',"
                        + " type = '" + e.getType() + "',"
                        + " description = '" + e.getDescription() + "', "
                        + " price = '" + e.getPrice() + "', "
                        + " date = '" + e.getDate() + "' where id =  '" + e.getId() + "'";
                stm.execute(sql);

            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(e.getDate() == null && e.getImmagine() == null && !(e.getHour().substring(0,1).equals(" ")))
        {
            try {

                String sql = "UPDATE em17.events set title = '" + e.getTitle() + "', position = '" + e.getPosition() + "',"
                        + " city = '" + e.getCity() + "',"
                        + " ticketsAvaible = '" + e.getTicketsAvaible() + "',"
                        + " type = '" + e.getType() + "',"
                        + " description = '" + e.getDescription() + "', "
                        + " price = '" + e.getPrice() + "', "
                        + " hour = '" + e.getHour() + "' where id =  '" + e.getId() + "'";
                stm.execute(sql);

            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(e.getDate() == null && e.getImmagine() != null && e.getHour().substring(0,1).equals(" "))
        {
            try {

                String sql = "UPDATE em17.events set title = '" + e.getTitle() + "', position = '" + e.getPosition() + "',"
                        + " city = '" + e.getCity() + "',"
                        + " ticketsAvaible = '" + e.getTicketsAvaible() + "',"
                        + " type = '" + e.getType() + "',"
                        + " description = '" + e.getDescription() + "', "
                        + " price = '" + e.getPrice() + "', "
                        + " img = ? where id =  '" + e.getId() + "'";
                PreparedStatement ps; 
                
                ps = conn.prepareStatement(sql);
                ps.setBytes(1, readFile(e.getImmagine()));
                ps.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(e.getDate() != null && e.getImmagine() != null && e.getHour().substring(0,1).equals(" "))
        {
            try {

                String sql = "UPDATE em17.events set title = '" + e.getTitle() + "', position = '" + e.getPosition() + "',"
                        + " city = '" + e.getCity() + "',"
                        + " ticketsAvaible = '" + e.getTicketsAvaible() + "',"
                        + " type = '" + e.getType() + "',"
                        + " description = '" + e.getDescription() + "', "
                        + " price = '" + e.getPrice() + "', "
                        + " date = '" + e.getDate() + "', "
                        + " img = ? where id =  '" + e.getId() + "'";
                PreparedStatement ps; 
                
                ps = conn.prepareStatement(sql);
                ps.setBytes(1, readFile(e.getImmagine()));
                ps.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(e.getDate() == null && e.getImmagine() != null && !(e.getHour().substring(0,1).equals(" ")))
        {
            try {

                String sql = "UPDATE em17.events set title = '" + e.getTitle() + "', position = '" + e.getPosition() + "',"
                        + " city = '" + e.getCity() + "',"
                        + " ticketsAvaible = '" + e.getTicketsAvaible() + "',"
                        + " type = '" + e.getType() + "',"
                        + " description = '" + e.getDescription() + "', "
                        + " price = '" + e.getPrice() + "', "
                        + " hour = '" + e.getHour() + "', "
                        + " img = ? where id =  '" + e.getId() + "'";
                PreparedStatement ps; 
                
                ps = conn.prepareStatement(sql);
                ps.setBytes(1, readFile(e.getImmagine()));
                ps.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(e.getDate() != null && e.getImmagine() == null && !(e.getHour().substring(0,1).equals(" ")))
        {
            try {

                String sql = "UPDATE em17.events set title = '" + e.getTitle() + "', position = '" + e.getPosition() + "',"
                        + " city = '" + e.getCity() + "',"
                        + " ticketsAvaible = '" + e.getTicketsAvaible() + "',"
                        + " type = '" + e.getType() + "',"
                        + " description = '" + e.getDescription() + "', "
                        + " price = '" + e.getPrice() + "', "
                        + " date = '" + e.getDate() + "', "
                        + " hour = '" + e.getHour() + "' where id =  '" + e.getId() + "'";
                stm.execute(sql);

            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void removeEvent(String id) {
        try {
            stm = conn.createStatement();
            String sql = "DELETE FROM em17.events where id =  '" + id + "'";
            stm.execute(sql);
            //conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Event> getEventFiltered(String city, String type) {
        ArrayList<Event> eventi = new ArrayList();
        try{
            if(city.equals("-") && type.equals("-"))
            {
                String query = "SELECT * FROM em17.events";
                stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while(rs.next())
                {
                    Event evento = new Event();
                    evento.setId(rs.getString("id"));
                    evento.setTitle(rs.getString("title"));
                    evento.setPosition(rs.getString("position"));
                    evento.setCity(rs.getString("city"));
                    evento.setDate(rs.getString("date"));
                    evento.setHour(rs.getString("hour"));
                    evento.setTicketsAvaible(rs.getString("ticketsAvaible"));
                    evento.setTicketsSell(rs.getString("ticketsSell"));
                    evento.setPrice(rs.getString("price"));
                    evento.setType(rs.getString("type"));
                    evento.setDescription(rs.getString("description"));

                    eventi.add(evento);
                }
            } else if(!(city.equals("-")) && !(type.equals("-")))
            {
                String query = "SELECT * FROM em17.events WHERE type = '" + type + "' AND city = '" + city + "'";
                stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while(rs.next())
                {
                    Event evento = new Event();
                    evento.setId(rs.getString("id"));
                    evento.setTitle(rs.getString("title"));
                    evento.setPosition(rs.getString("position"));
                    evento.setCity(rs.getString("city"));
                    evento.setDate(rs.getString("date"));
                    evento.setHour(rs.getString("hour"));
                    evento.setTicketsAvaible(rs.getString("ticketsAvaible"));
                    evento.setTicketsSell(rs.getString("ticketsSell"));
                    evento.setPrice(rs.getString("price"));
                    evento.setType(rs.getString("type"));
                    evento.setDescription(rs.getString("description"));

                    eventi.add(evento);
                }
            } else if(city.equals("-") && !(type.equals("-")))
            {
                String query = "SELECT * FROM em17.events WHERE type = '" + type + "'";
                stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while(rs.next())
                {
                    Event evento = new Event();
                    evento.setId(rs.getString("id"));
                    evento.setTitle(rs.getString("title"));
                    evento.setPosition(rs.getString("position"));
                    evento.setCity(rs.getString("city"));
                    evento.setDate(rs.getString("date"));
                    evento.setHour(rs.getString("hour"));
                    evento.setTicketsAvaible(rs.getString("ticketsAvaible"));
                    evento.setTicketsSell(rs.getString("ticketsSell"));
                    evento.setPrice(rs.getString("price"));
                    evento.setType(rs.getString("type"));
                    evento.setDescription(rs.getString("description"));

                    eventi.add(evento);
                }
            } else if(!(city.equals("-")) && type.equals("-"))
            {
                String query = "SELECT * FROM em17.events WHERE city = '" + city + "'";
                stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while(rs.next())
                {
                    Event evento = new Event();
                    evento.setId(rs.getString("id"));
                    evento.setTitle(rs.getString("title"));
                    evento.setPosition(rs.getString("position"));
                    evento.setCity(rs.getString("city"));
                    evento.setDate(rs.getString("date"));
                    evento.setHour(rs.getString("hour"));
                    evento.setTicketsAvaible(rs.getString("ticketsAvaible"));
                    evento.setTicketsSell(rs.getString("ticketsSell"));
                    evento.setPrice(rs.getString("price"));
                    evento.setType(rs.getString("type"));
                    evento.setDescription(rs.getString("description"));

                    eventi.add(evento);
                }
            }
        }
        catch(SQLException e)
        {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }
        return eventi;
    }
    
    public ArrayList<String> getCityEvent()
    {
        ArrayList<String> city = new ArrayList();
        String query = "SELECT DISTINCT city FROM em17.events";
            
        try {
            stm = conn.createStatement();
        
            ResultSet rs = stm.executeQuery(query);
            while(rs.next())
            {
                city.add(rs.getString("city"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return city;
    }
    
    //Funzione che permette di convertire il file in input in un array di byte.
    private byte[] readFile(File f) {
        ByteArrayOutputStream bos = null;
        try {
            //File f = new File(file);
            FileInputStream fis = new FileInputStream(f);
            byte[] buffer = new byte[1024];
            bos = new ByteArrayOutputStream();
            try {
                for (int len; (len = fis.read(buffer)) != -1;) {
                    bos.write(buffer, 0, len);
                }
            } catch (IOException ex) {
                Logger.getLogger(EventDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } 
        return bos != null ? bos.toByteArray() : null;
    }
    
}
