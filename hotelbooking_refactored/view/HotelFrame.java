/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking_refactored.view;

import hotelbooking_refactored.controller.HotelController;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author PC
 */
public class HotelFrame extends JFrame {

    private final static int WIDTH = 500;
    private final static int HEIGHT = 500;

    public LoginPanel loginPanel;
    public MenuPanel menuPanel;
    public BookGuestPanel bookGuestPanel;
    public SearchGuestPanel searchGuestPanel;
    public ViewRoomsPanel viewRoomsPanel;
    public CheckoutGuestPanel checkoutGuestPanel;
    public DiscountPanel discountPanel;

    public HotelFrame(HotelController controller) {
        loginPanel = new LoginPanel(controller);
        menuPanel = new MenuPanel(controller);
        bookGuestPanel = new BookGuestPanel(controller);
        searchGuestPanel = new SearchGuestPanel(controller);
        viewRoomsPanel = new ViewRoomsPanel(controller);
        checkoutGuestPanel = new CheckoutGuestPanel(controller);
        discountPanel = new DiscountPanel(controller);
        setupFrame(this.loginPanel);

    }

    public void setnew() {

        changePanel(menuPanel);
    }

    //Method which changes Panel, controlled through HotelController
    public void changePanel(javax.swing.JPanel panel) {
        this.setContentPane(panel);
    }

    private void setupFrame(javax.swing.JPanel panel) {
        this.setContentPane(panel);
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
        this.setResizable(false);

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); //Set up Frame with look and feel

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
