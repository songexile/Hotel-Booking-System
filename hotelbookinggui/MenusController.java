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
public  class MenusController { //Class to control the menus
    
    private static DatabaseScripts db;
    private static initSQL precheckDb;
    
    private static MenusHelper helper;

    private static LoginForm loginMenu;
    private static AddDiscountCodeForm discountForm;
    private static BookGuestRoomForm bookGuestForm;
    private static CheckoutGuestForm checkoutGuestForm;
    private static Menu mainMenu;
    private static SearchGuestForm searchGuestForm;
    private static ViewRoomsForm viewRoomsForm;
    
    MenusController()
    {
        db = new DatabaseScripts();
        precheckDb = new initSQL(); //Does precheck to see if database exisit
        helper = new MenusHelper();
        initLoginWindow();
        
    }
    

    public void initLoginWindow()
    {
        loginMenu = new LoginForm();
        loginMenu.show(true);
   
        helper.closeMenu(loginMenu);
 
           // mainMenu = new Menu();
          //  mainMenu.show(true);

    }
    
    public void initMainMenu()
    {
        mainMenu = new Menu();
        mainMenu.show(true);
        
    }
    
    public static void main(String[] args) {
        MenusController controller = new MenusController();
    }
    


 
    
}
