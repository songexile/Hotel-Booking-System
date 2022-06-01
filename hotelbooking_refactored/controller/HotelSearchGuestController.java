/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking_refactored.controller;

import hotelbooking_refactored.model.Rooms;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

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
    
    public javax.swing.JComboBox populateRoomNumBox() {
        javax.swing.JComboBox roomBox = controller.getHotelFrame().searchGuestPanel.getComboBox();

        ArrayList<String> roomsArray = new ArrayList();

        Rooms rooms = new Rooms();

        for (int i = 0; i < rooms.availableRooms(1).size(); i++) //1 for reserved
        {
            roomsArray.add(rooms.availableRooms(1).get(i).toString());

        }
        roomBox.setModel(new DefaultComboBoxModel(roomsArray.toArray()));

        return roomBox;

    }
    

   
    
    

    
}
