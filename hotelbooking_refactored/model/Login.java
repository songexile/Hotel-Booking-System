/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking_refactored.model;

import hotelbookinggui.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Login { //Class to seperate Database (model) with the View
    private DatabaseScripts scripts;


    public boolean checkLoginCorrect(String username, String password)
    {
        scripts = new DatabaseScripts();
        ResultSet rs = null;
       
        try {
        String queryString = "SELECT * FROM USERLOGIN";
         rs =  scripts.getResultSet(queryString); //ERROR here, result set not init properly
        while(rs.next())
        {
            if(rs.getString("username").equals(username))
                    if(rs.getString("password").equals(password)){
                        System.out.println("Login correct");
                        
                        MenusHelper helper = new MenusHelper();
                        helper.setCloseMenu(true);
         
                        return true;
                    }        
        }
        rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
        //Check if userName exist, if no user, no user exist
        //If user exist check password
  
    }
    
    public void generateLogin() //class to generate login if new table
    {
        DatabaseScripts scripts = new DatabaseScripts();
        scripts.executeSQL(StoreSQL.insertLogin);
        scripts.closeConnection();
       
    }
    
    
}
