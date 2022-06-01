/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking_refactored.controller;

import hotelbooking_refactored.database.DatabaseScripts;
import hotelbooking_refactored.helperclasses.InputHelper;
import hotelbooking_refactored.model.Guest;
import hotelbooking_refactored.model.Rooms;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author PC
 */
//Controller to help with booking of guest
public class HotelBookGuestController extends AbstractController {
    private Guest g;
    private HotelController controller;
    
    private static int init = 0;  //When this class hasnt been used yet it is 0
    
    public HotelBookGuestController(HotelController controller)
    {
        this.controller = controller;
    }
    
    public int validateInformation(String firstName, String lastName, String number, int roomNum) //Checks if all the information provided is valid
    {
        int correctInfo = 3; //We need firstName, lastName and number to be correct
        String errors = "";
        
        if(validate(firstName,true) == false){
            errors += "Cannot validate first name ";
            correctInfo--;
        }
        if(validate(lastName,true) == false){
           errors += "Cannot validate last name ";
            correctInfo--;
        }
        
        if(validate(number,false) == false){
            errors += "Cannot validate phone number";
            correctInfo--;
        }
        
        if(correctInfo != 3)
        {
         displayError(errors);   
        }
        else //If all information is correct we create guest object and add to system
        {
            Guest g = new Guest(firstName, lastName, number, roomNum);
            bookGuestButton(g);
        }
        return correctInfo; //return correctInfo as when it is 3 it means we can create the guest object

        
    }
    //This function will validate the input, this is used in the guest form to validate the input
    public boolean validate(String input, boolean name) //if boolean name false then does phone number
    {
        boolean flag = false;
        
        if(name)
        {
        flag = InputHelper.checkName(input);
        flag = InputHelper.isAlphabetical(input);
        }
        else{
         flag =  InputHelper.checkNumber(input);
         flag = InputHelper.isNumerical(input);
        }
     return flag;   
    }
    
   
    
    
    public void bookGuestButton(Guest g) //this handles the book guest button
    {
        this.g = g;
        g.insertGuest(); 
        displayConfirmation();
    }
    
    public void displayConfirmation()
    {
        String displayMessage = "Congrats for booking a room "+g.getReceipt();
   
        showMessageDialog(null, displayMessage);
        //g.getConfirmationResultSet("John", "Doe");
        
    }
    
    public javax.swing.JComboBox populateRoomNumBox() //This populates and updates the RoomNumBox model
    {

        javax.swing.JComboBox roomBox = controller.getHotelFrame().bookGuestPanel.getRoomNumBox();
       ArrayList <String> roomsArray = new ArrayList();
        
       Rooms rooms = new Rooms();
      
       for(int i = 0; i < rooms.availableRooms(0).size(); i++)
        {
            roomsArray.add(rooms.availableRooms(0).get(i).toString());
           
          
        } 
       roomBox.setModel(new DefaultComboBoxModel(roomsArray.toArray()));
       

       return roomBox;
        
    }
    


    @Override
    public void displayError(String s) {
        super.displayError(s); 
    }

    
    
    
}
