/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbookinggui;



/**
 *
 * @author PC
 */
public class Guest {
    
    private String firstName;
    private String lastName;
    private String phoneNumber;
    
    Guest(String firstName, String lastName, String phoneNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
  
    }
    
    public boolean isAlphabetical(String s) {
        return s.matches("^[a-zA-Z]*$");
    }
    
     public boolean isNumerical(String s) {
        return s.matches("^[0-9]*$");
    }
    
    public boolean checkName(String name)
    {
        
        final int MIN_NAME = 2;
        final int MAX_NAME = 30;
        
        if(name.length() > MAX_NAME || name.length()  < MIN_NAME)
        {
            System.out.println("The length of your name is either too short or too long");
            return false;
        }
        
        if(!isAlphabetical(name))
        {
            System.out.println("Only enter alphabetical characters");
            return false;
        }
        return true;
    
    }
    
}
