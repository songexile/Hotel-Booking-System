/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking_refactored.controller;

import hotelbooking_refactored.model.Rooms;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author PC
 */
public class HotelSearchGuestController extends AbstractController {
 

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
    

    

}
