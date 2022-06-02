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
public class HotelController implements MainControllerInterface {
    //Main controller class
    //This sets up Database, Frame and important things
    
    private HotelFrame hotelFrame;
    private DatabaseScripts db;
    private initSQL precheckDb;
    
    @Override
    public void start() //This will be the entry point into the program
    {
        db = new DatabaseScripts();
        precheckDb = new initSQL(); //Does precheck to see if database exisit     
        hotelFrame = new HotelFrame(this);   
        
      //  changePanel(hotelFrame.menuPanel);
    }
    
    @Override
    public void exit() //Exit point from program
    {
        db.closeConnection();
        System.exit(0);
    }
    
    @Override
    public void openPanel(javax.swing.JPanel openPanel, javax.swing.JPanel panelToOpen ) //This is used to change panels
    {
        openPanel.setVisible(false); //Set current panel to close
        panelToOpen.setVisible(true); //Set panel that will be opened to true
        changePanel(panelToOpen); //Change panel
    }
    
    public HotelFrame getHotelFrame()
    {
        return this.hotelFrame; //To get reference to hotel frame, this is used to access the Panels
    }
    
    public void changePanel(javax.swing.JPanel panel)
    {
        hotelFrame.changePanel(panel);
    }
    
    public void initViewRoomsPanel() //This will initlize the the text in viewrooms, there isnt a controlling class for ViewRooms as it is small
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
