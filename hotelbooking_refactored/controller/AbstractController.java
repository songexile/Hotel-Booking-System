/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking_refactored.controller;
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
    
}
