/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking_refactored.model;

import hotelbooking_refactored.database.DatabaseScripts;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Discount {
    private int discountAmount = 0;
    private String discountField;
    
    private String confirmation = "";

    public String getConfirmation() {
        return confirmation;
    }
    
    
    
    public Discount(String discountField, String discountAmount)
    {
        this.discountAmount = checkDiscountAmount(discountAmount); //parse string to int
        this.discountField = discountField;
        confirmation = insertDiscount(this.discountField, this.discountAmount);
    }
    
    public int checkDiscountAmount(String s)
    {
        int num = 0;
        try{
            num = Integer.parseInt(s);
            
            if(num >=100 || num < 0)
                num = 0; //if user goes over boundries make number 0
           
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        return num;
    }
    
    public String insertDiscount(String discountText, int discountAmount) //inserts discount into db
    {
        DatabaseScripts scripts = new DatabaseScripts();
        scripts.discountStatement(discountText, discountAmount);
        
        String s = "Discount added : "+discountText+ " Amount: "+discountAmount;
       return s;
    }
    
    public static int retrieveDiscount(String discountCode)
    {
        int amount = 0;
        String sequenceHelper = "'\''"; //helps with sql single quote
        String sql = "SELECT DISCOUNTAMOUNT FROM DISCOUNT WHERE DISCOUNTCODE ="+sequenceHelper+discountCode+sequenceHelper;
        DatabaseScripts scripts = new DatabaseScripts();
        ResultSet rs = null;
        rs = scripts.getResultSet(sql);
        
        try{
            while(rs.next())
            {
                amount+= rs.getInt("DISCOUNTAMOUNT");
                System.out.println(amount);
            }
            rs.close();
            
        
        
          } catch (SQLException ex) {
            Logger.getLogger(Discount.class.getName()).log(Level.SEVERE, null, ex); 
       }
     return amount;   
    }
}
   

    


        

        

    

