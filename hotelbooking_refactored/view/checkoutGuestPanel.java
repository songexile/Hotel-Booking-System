/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking_refactored.view;

import hotelbooking_refactored.controller.HotelBookGuestController;
import hotelbooking_refactored.controller.HotelCheckoutGuestController;
import hotelbooking_refactored.controller.HotelController;
import hotelbooking_refactored.controller.HotelSearchGuestController;
import hotelbooking_refactored.model.Guest;
import hotelbooking_refactored.model.Rooms;

/**
 *
 * @author PC
 */
public class CheckoutGuestPanel extends javax.swing.JPanel {
    private HotelController controller;
    private int roomNum = 0;
    /**
     * Creates new form BookGuestPanel
     */
    public CheckoutGuestPanel(HotelController controller) {
        this.controller = controller;
        initComponents();
               
    }
    
    public javax.swing.JComboBox getRoomNumBox()
    {
        return this.roomNumBox;
    }
    
    public javax.swing.JButton getGuestButton()
    {
        return this.checkOutGuestButton;
    }
    
    public int getRoomNum()
    {
        return roomNum;
    }
    
    public void setRoomNum() //resets room num to 0
    {
        this.roomNum = 0;
    }
    

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        roomNumBox = new javax.swing.JComboBox<>();
        backButton = new javax.swing.JButton();
        checkOutGuestButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Checkout Guest");

        jLabel5.setText("Room Number");

        roomNumBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomNumBoxActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        checkOutGuestButton.setText("Checkout Guest");
        checkOutGuestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutGuestButtonActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkOutGuestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(roomNumBox, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(roomNumBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(checkOutGuestButton))
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        controller.openPanel(this, controller.getHotelFrame().menuPanel); //closes current panel and opens menu
     
    }//GEN-LAST:event_backButtonActionPerformed

    private void roomNumBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomNumBoxActionPerformed
        javax.swing.JComboBox cb = (javax.swing.JComboBox)evt.getSource();
        String roomNumStr = (String) cb.getSelectedItem(); //Gets the roomNum from the combo box
        this.roomNum = Integer.parseInt(roomNumStr);

    }//GEN-LAST:event_roomNumBoxActionPerformed

    private void checkOutGuestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutGuestButtonActionPerformed
        HotelSearchGuestController guestController = new HotelSearchGuestController(controller);
        HotelCheckoutGuestController checkoutController = new HotelCheckoutGuestController(controller);
        checkoutController.pressButton();
     //   Rooms rooms = new Rooms();
     //   rooms.checkoutGuest(roomNum);
    //   backButton = guestController.changeButtonState(checkOutGuestButton, false); //changes state of button to unclickable
      //  guestController.populateRoomNumBox();
        
    }//GEN-LAST:event_checkOutGuestButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton checkOutGuestButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> roomNumBox;
    // End of variables declaration//GEN-END:variables
}
