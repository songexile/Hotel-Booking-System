/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking_refactored.controller;

import hotelbooking_refactored.database.DatabaseScripts;
import hotelbooking_refactored.model.Guest;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author PC
 */
//Controller to help with booking of guest
public class HotelBookGuestController extends AbstractController {
    private Guest g;
    
    public void bookGuestButton(Guest g) //this handles the book guest button
    {
        this.g = g;
        g.insertGuest();     
    }
    
    public void displayConfirmation()
    {
        String displayMessage = "Congrats for booking a room "+g.getReceipt();
        this.displayError();
        showMessageDialog(null, displayMessage);
        //g.getConfirmationResultSet("John", "Doe");
        
    }


    @Override
    public void displayError() {
        super.displayError(); //To change body of generated methods, choose Tools | Templates.
    }


    //Class with get information from Panel
    //ie, Guest first name, Guest last name, guest details
    
    //
    
    //validate login
    
    
    
    
}
