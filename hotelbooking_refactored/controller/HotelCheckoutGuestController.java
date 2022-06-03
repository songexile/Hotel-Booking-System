/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking_refactored.controller;

import hotelbooking_refactored.model.Guest;
import hotelbooking_refactored.model.Rooms;
import javax.swing.JComboBox;

/**
 *
 * @author PC
 */
public class HotelCheckoutGuestController extends ControllerHelper implements ControllerInterface { //This class is the controller for CheckoutGuest
private HotelController controller;

public HotelCheckoutGuestController(HotelController controller)
{
    this.controller = controller;
}
    
    @Override
    public JComboBox populateRoomNumBox(JComboBox roomBox, int reserved) {
        return super.populateRoomNumBox(roomBox, reserved); 
    }
    
    public void pressButton() //When button is pressed, guest is checked out of room and button state is unclickable
    {
   
       if(controller.getHotelFrame().checkoutGuestPanel.getRoomNum() == 0)
       {
           this.displayComboboxError(); //Tells user to select item from comboBox
       }
       
       else{
        this.changeButtonState(controller.getHotelFrame().checkoutGuestPanel.getGuestButton(), false);
        Rooms rooms = new Rooms();
        
        HotelSearchGuestController guestController = new HotelSearchGuestController(controller);   
        guestController.displayInformation(Guest.getGuestinRoom(controller.getHotelFrame().checkoutGuestPanel.getRoomNum())); //This is done to get who is staying in the room
        
        rooms.checkoutGuest(controller.getHotelFrame().checkoutGuestPanel.getRoomNum());     
       }
    }
    
    public void openPanel() //This will be used to init the panel, gets the rooms that are taken and makes the button clickable
    {
        ControllerHelper abstractController = new ControllerHelper();
        abstractController.populateRoomNumBox(controller.getHotelFrame().checkoutGuestPanel.getRoomNumBox(), 1);
        controller.getHotelFrame().checkoutGuestPanel.setRoomNum(); //this makes room number 0 so it cant be selected.
        
        controller.openPanel(controller.getHotelFrame().menuPanel, controller.getHotelFrame().checkoutGuestPanel);
        this.changeButtonState(controller.getHotelFrame().checkoutGuestPanel.getGuestButton(), true);
     
    }
    
    

    
}
