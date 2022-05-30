/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking_refactored.database;

import hotelbookinggui.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public  class DatabaseScripts {
    private static final String jdbcURL = "jdbc:derby:HotelDB;create=true";
    private static final String username = "pdc";
    private static final String password = "pdc";
    private static initSQL precheckSQL;
    private   Connection conn;
    private  Statement st;
    
    
    public DatabaseScripts(){
        connectDB();
       // precheckSQL = new PrecheckSQL(); //this does precheck of project, if db set up.
    }
    
       public Connection getConnection() {
        return this.conn;
    }
    
    
    public void connectDB(){
        if(this.conn == null){
            try{
                conn = DriverManager.getConnection(jdbcURL, username, password);
                 st = this.conn.createStatement();
                System.out.println("Connection to DB");
            }
                catch(SQLException e){
                    System.out.println(e.getMessage());
            }
        }
    }
    
    public int checkTableExist(String name) //Check if table exist, if exist delete.
    {
        System.out.println("Starting DATABASESCRIPTS: CHECKTABLETXIST");
              int exist = 0; //flag for if table exists
          try {
              
            DatabaseMetaData dbmd = this.conn.getMetaData();
            String[] types = {"TABLE"};
            st = this.conn.createStatement();
            ResultSet rs = dbmd.getTables(null, null, null, types);

            while (rs.next()) {
                String table_name = rs.getString("TABLE_NAME");
               System.out.println(table_name);
                if (table_name.equalsIgnoreCase(name)) {
                    exist = 1;
//                    st.executeUpdate("Drop table " + name);
//                    System.out.println("Table " + name + " has been deleted.");
                    break;
                }
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
          return exist;
    }
    
    public ResultSet getResultSet(String query) { 
        {
        ResultSet rs = null;
        try {
            rs = this.st.executeQuery(query);

           // rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
        }

    }
    
    
    public void dropTable(String table)
    {
        try {
            st.executeUpdate("Drop table "+table);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseScripts.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void executeSQL(String sql) //Blanket SQL function to execute whatever is wanted.
    {
        try{
         st=this.conn.createStatement();
        
        st.executeUpdate(sql);
        
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        System.err.println("SQLException: " + ex.getMessage());
}
    }
    

    

  
}
