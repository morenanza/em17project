/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;

public class Event {
    private String id;
    private String title;
    private String position;
    private String city;
    private String date;
    private String hour;
    private String ticketsAvaible;
    private String ticketsSell;
    private String type;
    private String description;
    private File immagine;  
    public void setId (String x)
    {
        id = x;
    }
    public void setTitle(String x)
    {
        title = x;
    }
    public void setPosition(String x)
    {
        position = x;
    }
    public void setCity(String x)
    {
        city = x;
    }
    public void setDate(String x)
    {
        date = x;
    }
    public void setHour(String x)
    {
        hour = x;
    }
    public void setTicketsAvaible(String x)
    {
        ticketsAvaible = x;
    }
    public void setTicketsSell(String x)
    {
        ticketsSell = x;
    }
    public void setType(String x)
    {
        type = x;
    }
    public void setDescription(String x)
    {
        description = x;
    }
    public void setImage(File x)
    {
        immagine = x;
    }
    public String getId()
    {
        return id;
    }
    public String getTitle()
    {
        return title;
    }
    public String getPosition()
    {
        return position;
    }
    public String getCity()
    {
        return city;
    }
    public String getDate()
    {
        return date;
    }
    public String getHour()
    {
        return hour;
    }
    public String getTicketsAvaible()
    {
        return ticketsAvaible;
    }
    public String getTicketsSell()
    {
        return ticketsSell;
    }
    public String getType()
    {
        return type;
    }
    public String getDescription()
    {
        return description;
    }
    public File getImmagine()
    {
        return immagine;
    }
}
