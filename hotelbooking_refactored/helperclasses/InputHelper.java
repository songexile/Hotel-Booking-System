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
public class InputHelper {

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
    
    public static boolean checkName(String name)
    {
        boolean flag = true;
        
        flag = isAlphabetical(name);
        flag = checkLength(2,30,name);
        
        return flag;
    }
    
    public static boolean checkNumber(String number)
    {
        boolean flag = true;
        
        flag = isNumerical(number);
        flag = checkLength(5,15,number);
        
        return flag;
    }
}
