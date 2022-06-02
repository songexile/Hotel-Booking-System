/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking_refactored.model;


import hotelbooking_refactored.database.DatabaseScripts;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author PC
 */
public class Guest {

    /**
     * @return the firstName
     */

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getGuestID() {
        return guestID;
    }
    
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int roomNumber;
    private int guestID; //randomly generated guestID, used for SQL
    private Random rand;
    

    public Guest(String firstName, String lastName, String phoneNumber, int roomNumber)
    {
        rand = new Random();
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.roomNumber = roomNumber;
        this.guestID = rand.nextInt(10000); 
    }
    
    public void insertGuest() //Used to insert guest into SQL
    {
      DatabaseScripts scripts = new DatabaseScripts();
      scripts.guestStatement(firstName, lastName, phoneNumber, roomNumber, guestID); //Insert Guest into SQL
      Rooms room = new Rooms();
      room.storeGuestRoom(this);   //Store guest into room
    }
    
  
    public static String getGuestinRoom(int roomNum)
    {
         final String sql = "SELECT FIRSTNAME, LASTNAME, GUESTID FROM GUESTS WHERE ROOMNUM ="+roomNum;
        String s = "";
        DatabaseScripts scripts = new DatabaseScripts();
        ResultSet rs = null;
        rs = scripts.getResultSet(sql);
        
         try {
        while(rs.next())
        {
            
            String fName = rs.getString("FIRSTNAME");
            String lName = rs.getString("LASTNAME");
            int guestID = rs.getInt("GUESTID");
            
          s += "Guest : "+fName +" "+lName+ " "+ guestID;
                  
        }
        rs.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(Guest.class.getName()).log(Level.SEVERE, null, ex);
            }
         return s;
     
    }
    
    
    
    
    public String getReceipt() //Returns full name + roomNumber
    {
        String s = this.firstName + " "+this.lastName+" "+this.roomNumber;
        return s;
        
    }
    
    

}
