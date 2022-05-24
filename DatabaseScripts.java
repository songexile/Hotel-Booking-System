/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbookinggui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class DatabaseScripts {
    private static final String jdbcURL = "jdbc:derby:HotelDB;create=true";
    private static final String username = "pdc";
    private static final String password = "pdc";
    Connection conn;
    Statement st;
    
    public DatabaseScripts(){
        connectDB();
    }
    
       public Connection getConnection() {
        return this.conn;
    }
    
    
    public void connectDB(){
        if(this.conn == null){
            try{
                conn = DriverManager.getConnection(jdbcURL, username, password);
                System.out.println("Connection to DB");
            }
                catch(SQLException e){
                    System.out.println(e.getMessage());
            }
        }
    }
    
    public void closeConnection(){
        if(conn != null)
        {
            try{
                conn.close();
            }catch(SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public void createTable()
    {
        try{
         st=this.conn.createStatement();
        
        String newTable="cartable";
        
       // st.executeUpdate("drop table if exists "+newTable);
        
        String sqlCreateTable="CREATE TABLE "+newTable+" (ID INT, "
        + "MAKE VARCHAR(50), MODEL VARCHAR(50), PRICE INT )";
       
        st.executeUpdate(sqlCreateTable);
        }
        catch (SQLException ex) {
        System.err.println("SQLException: " + ex.getMessage());
}
    }
    
    public void insertTable(String sql)
    {
        //String sql = "Insert into cartable (id, make) values (135,'honda')";
        try {
            
            st=conn.createStatement();
            st.executeUpdate(sql);
           
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseScripts.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

    
}
