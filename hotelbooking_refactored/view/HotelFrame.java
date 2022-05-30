/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking_refactored.view;

import hotelbooking_refactored.controller.HotelController;
import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class HotelFrame extends JFrame {
    
    private final static int WIDTH = 500;
    private final static int HEIGHT = 500;
    
    public LoginPanel loginPanel;
    public MenuPanel menuPanel;
    
    
    public HotelFrame(HotelController controller)
    {
        loginPanel = new LoginPanel(controller);
        menuPanel = new MenuPanel(controller);
        setupFrame(this.loginPanel);  
        
    }
    
    public void setnew()
    {
        
        changePanel(menuPanel);
    }
    
    //Method which changes Panel, controlled through HotelController
    public void changePanel(javax.swing.JPanel panel)
    {
        this.setContentPane(panel);
    }
    
    private void setupFrame(javax.swing.JPanel panel)
    {
        this.setContentPane(panel);
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
    }
    
}
