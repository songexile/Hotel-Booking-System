/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbookinggui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Rooms {
    
    private int roomPrice = 100; //This is the price each room cost per night.
    private int numberOfRooms = 10; //This is the number of rooms that the hotel will store in the SQL
    DatabaseScripts scripts;
    private final int notBooked = 0; //if room is not reserved
    private final int booked = 1; //if reserved
    private final int nullGuestID = 0; //
   
    
    
    public void generateRooms() //This will be initlized when a new user sets up DB
    {
        scripts = new DatabaseScripts();
        
        for(int i = 1; i < numberOfRooms+1; i++)
        {
           // scripts.executeSQL("INSERT INTO ROOMS VALUES ("+i+","+roomPrice+","+notBooked+","+nullGuestID+",NULL,NULL)"+);
            scripts.executeSQL("INSERT INTO ROOMS VALUES ("+i+","+roomPrice+","+notBooked+","+nullGuestID+",NULL,NULL)");
        }
        scripts.closeConnection();
        //SQL SCRIPT INSERT INTO ROOMS
        
        
    }
    
    public ArrayList availableRooms() //this is used to retrieve the free rooms from the SQL
    {
        final String selectStatement = "SELECT ROOMNUM FROM ROOMS WHERE ISRESERVED = 0"; //gets all rooms that are free
        
        ResultSet rs = null;
        ArrayList<String> availableRooms = new ArrayList();
        scripts = new DatabaseScripts();
          
        rs = scripts.getResultSet(selectStatement);
        
        try {
            while(rs.next())
            {
                availableRooms.add(rs.getString("ROOMNUM"));
            }
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(availableRooms.toString());
        return availableRooms;
    }
    
    public void storeGuestRoom() //This is used to store a guest into a room using SQL
    {
        
    }
    
    public void checkoutGuest(int roomNumber) //This is used to checkout a guest from a room using SQL
    {
        scripts = new DatabaseScripts();
        scripts.executeSQL("UPDATE ROOMS\nSET ISRESERVED = 1, GUESTID = 0, CHECKIN = NULL, CHECKOUT = NULL\n WHERE ROOMNUM = "+roomNumber);
        System.out.println("Checkout guest test");
        
    }
    
    
}
