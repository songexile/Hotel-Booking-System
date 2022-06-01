/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking_refactored.controller;

import hotelbooking_refactored.model.Login;
import hotelbooking_refactored.view.HotelFrame;
import hotelbooking_refactored.view.MenuPanel;


/**
 *
 * @author PC
 */
public class HotelLoginController {
    private HotelController controller;
    private boolean correct = false;
   
    
    public HotelLoginController(HotelController controller)
    {
        this.controller = controller;    
    }
    
    public void openMenu()
    {
        controller.getHotelFrame().loginPanel.setVisible(false);
        controller.changePanel(controller.getHotelFrame().menuPanel);
    }
    
 
    public void validateLogin(String name, String password)
    {
        Login login = new Login();
        correct = login.checkLoginCorrect(name, password);
        
        if(correct)
        {
            openMenu();
            
           
        }
        else
        {
            System.out.println("Incorrect login");
                    
        }
    }

  
    
    
}
