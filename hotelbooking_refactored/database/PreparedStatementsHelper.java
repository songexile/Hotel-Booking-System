/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking_refactored.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
//This class helps with inserts
public class PreparedStatementsHelper {
    private  DatabaseScripts scripts;
    private Connection conn;
    
    public PreparedStatementsHelper()
    {
        scripts = new DatabaseScripts();
        conn = scripts.getConnection();
    }
    
    public void userLoginStatement(String userName, String password)
    {
        System.out.println("USER LOGIN STATEMENT");
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO USERLOGIN VALUES (?,?)");
            ps.setString(1, userName);
            ps.setString(2, password);
            int i=ps.executeUpdate();  
            ps.close();
            System.out.println(i+ "records");
        } catch (SQLException ex) {
            Logger.getLogger(PreparedStatementsHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //NOT CURRENTLY USING THESE AS THEY ARE RUNNING IN DATABASESCRIPTS INSTEAD
        public void guestStatement(String firstName, String lastName, String phoneNumber, int roomNumber, int guestID)
    {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO GUESTS VALUES (?,?,?,?,?)");
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, phoneNumber);
            ps.setInt(4, roomNumber);
            ps.setInt(5, guestID);
             int i=ps.executeUpdate();  
            ps.close();
            System.out.println(i+ "records");
            System.out.println("GUEST VALUES INSERTED [PREPARESTATEMENTHELPER]");
            
         
        } catch (SQLException ex) {
            Logger.getLogger(PreparedStatementsHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
}
