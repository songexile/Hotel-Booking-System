/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking_refactored.controller;

/**
 *
 * @author PC
 */
public interface MainControllerInterface { //This handles the core respaonblities of the main controller
    //Simple inferface to help maintain core respoablities of the program.
    
    public void openPanel(javax.swing.JPanel openPanel, javax.swing.JPanel panelToOpen );
    public void start();
    public void exit();
    
    
}
