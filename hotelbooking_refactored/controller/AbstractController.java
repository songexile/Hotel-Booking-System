/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking_refactored.controller;
import hotelbooking_refactored.model.Rooms;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import static javax.swing.JOptionPane.showMessageDialog;
/**
 *
 * @author PC
 */
public class AbstractController {
    
        public void displayError(String errorMessage)
    {
        showMessageDialog(null, errorMessage);
  
    }
        
        public void displayInformation(String information)
        {
            
            showMessageDialog(null, information);
        }
        
    public javax.swing.JComboBox populateRoomNumBox(javax.swing.JComboBox roomBox, int reserved) { //This is used to populate comboBox and refresh state
        ArrayList<String> roomsArray = new ArrayList();
        Rooms rooms = new Rooms();

        for (int i = 0; i < rooms.availableRooms(reserved).size(); i++) {
            roomsArray.add(rooms.availableRooms(reserved).get(i).toString());

        }
        roomBox.setModel(new DefaultComboBoxModel(roomsArray.toArray()));
   

        return roomBox;
    }
    
    public javax.swing.JButton changeButtonState(javax.swing.JButton button, boolean clickable) //This will make the button clickable or not.
    {
        button.setEnabled(clickable);
        return button;
    }
    
    public void noComboBoxSelectedError(int roomNum) //Error will be thrown when no item is selected in comboBox
    {
        if(roomNum < 1)
        {
            displayError("Please select a value from the combo box");
        }
        
    }
    

}
        
        
    

