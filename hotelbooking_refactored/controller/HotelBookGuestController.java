/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking_refactored.controller;

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
    
    public HotelBookGuestController(HotelController controller) 
    {
        this.controller = controller;
    }
    
    public void initGuestState() //Resets guest text, and retrieves comboBox, this is used when the panel is opened
    {
        controller.getHotelFrame().bookGuestPanel.getDiscountField().setText("");
        controller.getHotelFrame().bookGuestPanel.getFirstNameField().setText("");
        controller.getHotelFrame().bookGuestPanel.getLastNameField().setText("");
        controller.getHotelFrame().bookGuestPanel.getPhoneNumField().setText("");
        controller.getHotelFrame().bookGuestPanel.getBookGuest().setEnabled(true);
        controller.getHotelFrame().bookGuestPanel.resetRoomNum(); //this resets room num to 0
        populateRoomNumBox(controller.getHotelFrame().bookGuestPanel.getRoomNumBox(), 0);
         controller.openPanel(controller.getHotelFrame().menuPanel, controller.getHotelFrame().bookGuestPanel);
    }
    

    public void bookGuestButton(String firstName, String lastName, String phoneNum, int roomNum)
    {
        if(roomNum < 1)
        {
            displayError("Please select a room");
        }
        else
        {
        int correct = validateInformation( firstName,  lastName, phoneNum, roomNum);
            if(correct == 3)
            {
                controller.getHotelFrame().bookGuestPanel.getBookGuest().setEnabled(false);
            }
        }
        
    }
    
    
    public int validateInformation(String firstName, String lastName, String number, int roomNum) //Checks if all the information provided is valid
    {
        int correctInfo = 3; //We need firstName, lastName and number to be correct, if 3 items arent correct we will display error message
        String errors = "";
        
        if(validate(firstName,true) == false){ //checks firstName length and sees if it contains any non alphabetical chars
            errors += "Cannot validate first name ";
            correctInfo--;
        }
        if(validate(lastName,true) == false){ //Same as above
           errors += "Cannot validate last name ";
            correctInfo--;
        }
        
        if(validate(number,false) == false){ //Checks if phoneNumber is in right format ie, no letters
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
            bookGuest(g); //Call bookGuestButton which will insert Guest into Database
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
    
   
    public void bookGuest(Guest g) //this handles the book guest 
    {
        this.g = g;
        g.insertGuest(); 
        displayConfirmation();
    }
    
    public void displayConfirmation()
    {
        String displayMessage = "Congrats for booking a room we hope you will enjoy your stay "+g.getReceipt();
   
        showMessageDialog(null, displayMessage);

        
    }
    
    @Override
    public JComboBox populateRoomNumBox(JComboBox roomBox, int reserved) { //this populates room
        return super.populateRoomNumBox(roomBox, reserved); 
    }
    


    @Override
    public void displayError(String s) {
        super.displayError(s); 
    }

    
    
    
}
