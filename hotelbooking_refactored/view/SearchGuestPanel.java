/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking_refactored.view;

import hotelbooking_refactored.controller.HotelBookGuestController;
import hotelbooking_refactored.controller.HotelController;
import hotelbooking_refactored.controller.HotelSearchGuestController;
import hotelbooking_refactored.model.Guest;
import hotelbooking_refactored.model.Rooms;

/**
 *
 * @author PC
 */
public class SearchGuestPanel extends javax.swing.JPanel {
    private HotelController controller;
    private int roomNum = 0;
    /**
     * Creates new form BookGuestPanel
     */
    public SearchGuestPanel(HotelController controller) {
        this.controller = controller;
        initComponents();
               
    }
    
    public void setRoomNum()
    {
        this.roomNum = 0;
    }

    public int getRoomNum() {
        return roomNum;
    }
    
    
    
    public javax.swing.JComboBox getComboBox()
    {
        return roomNumBox;
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        roomNumBox = new javax.swing.JComboBox<>();
        backButton = new javax.swing.JButton();
        searchGuest = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Search Guest");

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

        searchGuest.setText("Search Guest");
        searchGuest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchGuestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchGuest, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 249, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(80, 80, 80)
                .addComponent(roomNumBox, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(roomNumBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(searchGuest))
                .addContainerGap())
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

    private void searchGuestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchGuestActionPerformed
        HotelSearchGuestController guestController = new HotelSearchGuestController(controller);
        guestController.pressButton();
       // guestController.displayInformation(Guest.getGuestinRoom(this.roomNum));   

    }//GEN-LAST:event_searchGuestActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox<String> roomNumBox;
    private javax.swing.JButton searchGuest;
    // End of variables declaration//GEN-END:variables
}
