/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking_refactored.model;


import hotelbooking_refactored.database.DatabaseScripts;
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

    public int getRoomPrice() {
        return roomPrice;
    }
    
    
   
    
    
    public void generateRooms() //This will be initlized when a new user sets up DB, generates Rooms for DB
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
    
    public ArrayList availableRooms(int reserved) //this is used to retrieve the free rooms from the SQL, 0 = free, 1 =taken
    {
        final String selectStatement = "SELECT ROOMNUM FROM ROOMS WHERE ISRESERVED = "+reserved; //gets all rooms that are free
        
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
    
    public void storeGuestRoom(Guest g) //This is used to store a guest into a room using SQL
    {
        scripts = new DatabaseScripts();
        scripts.executeSQL("UPDATE ROOMS\nSET ISRESERVED = 1, GUESTID ="+g.getGuestID()+", CHECKIN = NULL, CHECKOUT = NULL\n WHERE ROOMNUM ="+g.getRoomNumber());
        System.out.println(g.getGuestID());
        System.out.println("room"+g.getRoomNumber());
        System.out.println("Added Guest to room");
        availableRooms(0);
        scripts.closeConnection();
        
        //Get guestObject
        //Store in room
        
    }
    
    public String viewRooms() //This displays all rooms
    {
        String s = "";
        
         final String selectStatement = "SELECT ROOMNUM, ISRESERVED, PRICE FROM ROOMS"; //gets all rooms that are free
        ResultSet rs = null;
         scripts = new DatabaseScripts();
         rs = scripts.getResultSet(selectStatement);
         
          try {
            while(rs.next())
            {
                int rNum = rs.getInt("ROOMNUM");
                int iReserved = rs.getInt("ISRESERVED");
                int rPrice = rs.getInt("PRICE");
                
                s+= "Room : "+rNum + "| "+"("+iReserved+") | Price : $"+rPrice+"\n";
            }
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex); 
       }
        return s;
        
    }
    
    public void checkoutGuest(int roomNumber) //This is used to checkout a guest from a room using SQL
    {
        scripts = new DatabaseScripts();
        scripts.executeSQL("UPDATE ROOMS\nSET ISRESERVED = 0, GUESTID = 0, CHECKIN = NULL, CHECKOUT = NULL\n WHERE ROOMNUM = "+roomNumber); //Set isReserved to 0 as guest checkedout
        scripts.executeSQL("DELETE FROM GUESTS WHERE ROOMNUM ="+roomNumber);

        scripts.closeConnection();
       
    }
    

    
    
}
