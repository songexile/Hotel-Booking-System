/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking_refactored.controller;

import hotelbooking_refactored.model.Guest;
import hotelbooking_refactored.model.Rooms;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author PC
 */
public class HotelSearchGuestController extends ControllerHelper implements ControllerInterface {
 

    private HotelController controller;
    
    public HotelSearchGuestController(HotelController controller)
    {
        this.controller = controller;
    }
    
    @Override
    public void displayInformation(String s) {
        super.displayInformation(s); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public JComboBox populateRoomNumBox(JComboBox roomBox, int reserved) {
        return super.populateRoomNumBox(roomBox, reserved); 
    }

    @Override
    public void openPanel() {
        populateRoomNumBox(controller.getHotelFrame().searchGuestPanel.getComboBox(), 1);
        controller.openPanel(controller.getHotelFrame().menuPanel, controller.getHotelFrame().searchGuestPanel);
        controller.getHotelFrame().searchGuestPanel.setRoomNum();
    }

    @Override
    public void pressButton() {
        int roomNum = controller.getHotelFrame().searchGuestPanel.getRoomNum();
        
        if(roomNum < 1)
        {
            this.displayComboboxError();
        }
        else
        {
            displayInformation(Guest.getGuestinRoom(roomNum));  
        }
    }
    

    

}
