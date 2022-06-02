/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking_refactored.controller;

import hotelbooking_refactored.model.Discount;

/**
 *
 * @author PC
 */
public class HotelDiscountController extends ControllerHelper implements ControllerInterface  {
    private HotelController controller;
    
    public HotelDiscountController(HotelController controller)
    {
        this.controller = controller;
    }

    @Override
    public void openPanel() {
        controller.openPanel(controller.getHotelFrame().menuPanel, controller.getHotelFrame().discountPanel);
        controller.getHotelFrame().discountPanel.getDiscountAmount().setText("");
        controller.getHotelFrame().discountPanel.getDiscountField().setText("");
        controller.getHotelFrame().discountPanel.getAddButton().setEnabled(true);
        
    }

    @Override
    public void pressButton() {
       String discountAmount = controller.getHotelFrame().discountPanel.getDiscountAmount().getText();
       String discountField = controller.getHotelFrame().discountPanel.getDiscountField().getText();
       
       if(discountAmount.equals("") || discountField.equals(""))
           displayError("You have not entered anything");
       
       else
       {  
        Discount discount = new Discount(discountField,discountAmount);
        this.displayInformation(discount.getConfirmation());  
        controller.getHotelFrame().discountPanel.getAddButton().setEnabled(false);
        
       }
           
    }
    
}
