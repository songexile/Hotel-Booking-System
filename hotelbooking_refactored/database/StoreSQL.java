/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbooking_refactored.database;

import hotelbookinggui.*;

/**
 *
 * @author PC
 */
public class StoreSQL { //Stores SQL scripts
    public static final String loginUserName = "pdc"; //these will be the login into the GUI, change these if desire.
    public static final String loginPassword = "pdc";
    
//CREATE TABLES
    public static final String createGuest = "CREATE TABLE GUESTS (FIRSTNAME VARCHAR(30) NOT NULL, LASTNAME VARCHAR(30) NOT NULL, PHONE VARCHAR(15) NOT NULL, ROOMNUM INT, GUESTID INT)";
    public static final String roomTable = "CREATE TABLE ROOMS (ROOMNUM INT NOT NULL, PRICE INT NOT NULL, ISRESERVED SMALLINT NOT NULL, GUESTID INT, CHECKIN DATE, CHECKOUT DATE)";
    public static final String loginUserTable = "CREATE TABLE USERLOGIN (USERNAME VARCHAR(30) NOT NULL, PASSWORD VARCHAR(30) NOT NULL)";
    public static final String discountTable = "CREATE TABLE DISCOUNT (DISCOUNTCODE VARCHAR(30) NOT NULL, DISCOUNTAMOUNT INT NOT NULL)";

    //INSERT INTO
    public static final String insertLogin2 = "INSERT INTO USERLOGIN VALUES (" +loginUserName+", "+loginPassword+")"; //This inserts the login
        public static final String insertLogin = "INSERT INTO USERLOGIN VALUES ('pdc', 'pdc')"; //This inserts the login (did this way temp)
    
    
}
