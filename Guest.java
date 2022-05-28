/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbookinggui;

import java.util.Random;



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
    
    
    Guest(String firstName, String lastName, String phoneNumber, int roomNumber)
    {
        rand = new Random();
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.guestID = rand.nextInt(10000);
    }
    
    public void insertGuest() //Used to insert guest into SQL
    {
      //"INSERT INTO GUESTS VALUES ("+firstName+"","+lastName+","+phoneNumber+","+roomNumber+","+guestID+")";
      Rooms room = new Rooms();
      room.storeGuestRoom(this);
        
    }
    
    

}
