/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Morena
 */
public class Admin {
    private String username;
    private String password;
    public void setUsername(String user)
    {
        username = user;
    }
    public void setPassword(String pass)
    {
        password = pass;
    }
    public String getUsername()
    {
        return username;
    }
    public String getPassword()
    {
        return password;
    }
}
