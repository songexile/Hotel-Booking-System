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
public class StoreSQL { //Stores SQL scripts
    String loginUserName = "pdc"; //these will be the login into the GUI, change these if desire.
    String loginPassword = "pdc";
    
//CREATE TABLES
    String createGuest = "CREATE TABLE GUESTS (FIRSTNAME VARCHAR(30) NOT NULL, LASTNAME VARCHAR(30) NOT NULL, PHONE VARCHAR(15) NOT NULL, ROOMNUM INT)";
    String roomTable = "CREATE TABLE ROOMS (PRICE INT NOT NULL, RESERVED BIT NOT NULL, GUESTSTAYING VARCHAR(60), CHECKIN DATE, CHECKOUT DATE)";
    String loginUserTable = "CREATE TABLE USER (USERNAME VARCHAR(30) NOT NULL, PASSWORD VARCHAR(30) NOT NULL)";
    String discountTable = "CREATE TABLE DISCOUNT (DISCOUNTCODE VARCHAR(30) NOT NULL, DISCOUNTAMOUNT INT NOT NULL)";

    //INSERT INTO
    String insertLogin = "INSERT INTO USER VALUES (" +loginUserName+", "+loginPassword+");"; //This inserts the login
    
    
}
