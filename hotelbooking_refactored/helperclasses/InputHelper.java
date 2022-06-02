/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking_refactored.helperclasses;

/**
 *
 * @author PC
 */
public class InputHelper { //This class is primarily used to help with Guest validation entries as of 1/06/2022

    public static boolean isAlphabetical(String s) {
        return s.matches("^[a-zA-Z]*$");
    }

    public static boolean isNumerical(String s) {
        return s.matches("^[0-9]*$");
    }

    public static boolean checkLength(int min, int max, String input) {

        final int MIN_NAME = min;
        final int MAX_NAME = max;

        if (input.length() > MAX_NAME || input.length() < MIN_NAME) {
            System.out.println("The length of your name is either too short or too long");
            return false;
        }

        return true;
    }
    
    public static boolean checkName(String name) //Returns true if Name is formatted ie, correct length and contains no numbers
    {
        if(isAlphabetical(name) == false)
                return false;
        if(checkLength(2,30,name) == false)
            return false;
        
        return true;
    }
    
    public static boolean checkNumber(String number) //Return true is Number is formatted and matches conditions
    {

        if(isNumerical(number) == false)
            return false;
        if(checkLength(5,15,number) == false)
            return false;
        
        return true;
    }
}
