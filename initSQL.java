/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbookinggui;

import java.sql.Connection;

/**
 *
 * @author PC
 */
public class initSQL { //Class to help init SQL for new user
   private  DatabaseScripts scripts;
    private Connection conn;
    StoreSQL sqlScripts;
    
    
    initSQL()
    {
        scripts = new DatabaseScripts();
        conn = scripts.getConnection();
     //   scripts = new DatabaseScripts();
        // scripts = new DatabaseScripts();
      //   conn = scripts.getConnection();
         sqlScripts = new StoreSQL(); //This class just stores string text of SQL commands
         initBoot();
    }
    
    
    public boolean checkNewUser() //Checks if database tables already exisit, if number not = 4 then the user is new
    {
        boolean forceNewUser = false;
        int newUser = 0;
        
        newUser += scripts.checkTableExist("GUESTS");
       newUser += scripts.checkTableExist("ROOMS");
        newUser += scripts.checkTableExist("USERLOGIN");
       newUser += scripts.checkTableExist("DISCOUNT");
        System.out.println("Num of tables that exist :"+newUser);
        return newUser != 4 || forceNewUser == true; //Currently forcing newUser for testing. 
    }
    
    public void generateTables()
            {
                scripts.executeSQL(sqlScripts.createGuest);
                scripts.executeSQL(sqlScripts.discountTable);
                 scripts.executeSQL(sqlScripts.loginUserTable);
                 scripts.executeSQL(sqlScripts.roomTable);
                System.out.println("Table created");
            }
    
    public void generateLogin() //This inserts SQL scripts INSERT creating login for user (this is done only on first boot of database)
    {
        scripts.executeSQL(sqlScripts.insertLogin);
        System.out.println("Login created");
    }
    
    public void initBoot() //Init boot checks if database already exist, if doesnt creates it
    {
        boolean newUser = checkNewUser();
        if(newUser == true) 
            {
                // scripts.dropTable("guestTable");
                // scripts.dropTable("roomTable");
                // scripts.dropTable("discountTable");
                // scripts.dropTable("loginTable");
                // System.out.println("PRECHECK SQL: TABLES DROPPED");
                 //Drop table just incase bugs, allows user to start fresh
                 generateTables(); //Generates tables for user
                 generateLogin(); //Populates login with 1 default login
                 //generateRooms
                 System.out.println("PRECHECK SQL: TABLES GENERATED, POPULATED LOGIN");
                 
                 //TODO: Will need to populate Room database
            }
           
        
            //    Controller c = new Controller();
              //  c.checkLoginCorrect("pdc", "pdc");
           
        
        
    }
}
