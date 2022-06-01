/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking_refactored.controller;

import hotelbooking_refactored.view.HotelFrame;
import hotelbooking_refactored.database.DatabaseScripts;
import hotelbooking_refactored.database.initSQL;
import hotelbooking_refactored.model.Rooms;


/**
 *
 * @author PC
 */
public class HotelController {
    
    private HotelFrame hotelFrame;
    private DatabaseScripts db;
    private initSQL precheckDb;
    
    public void start()
    {
        db = new DatabaseScripts();
        precheckDb = new initSQL(); //Does precheck to see if database exisit     
        hotelFrame = new HotelFrame(this);   
        
      //  changePanel(hotelFrame.menuPanel);
    }
    
    public void openPanel(javax.swing.JPanel openPanel, javax.swing.JPanel panelToOpen ) //Open panel
    {
        openPanel.setVisible(false);
        panelToOpen.setVisible(true);
        changePanel(panelToOpen);
    }
    
    public HotelFrame getHotelFrame()
    {
        return this.hotelFrame;
    }
    
    public void changePanel(javax.swing.JPanel panel)
    {
        hotelFrame.changePanel(panel);
    }
    
    public void initViewRoomsPanel() //This will initlize the the text in viewrooms
    {
        hotelFrame.viewRoomsPanel.getTextArea().setText(""); //Resets text
        Rooms rooms = new Rooms(); //Call rooms so I can get avaible rooms to display
    
        javax.swing.JTextArea text = hotelFrame.viewRoomsPanel.getTextArea();
        text.append(rooms.viewRooms());
       // jTextArea1.append(rooms.viewRooms());
    }
    
    public void resetDb()
    {
        precheckDb.deleteTables();
        precheckDb.checkNewUser();
        
    }
    
 
    
}
