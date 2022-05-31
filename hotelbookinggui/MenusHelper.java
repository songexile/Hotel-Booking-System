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
public  class MenusHelper { //Helper class

    private static boolean closeSubMenu = false; //controls menus

    public void setCloseMenu(boolean set) {
        this.closeSubMenu = set;
    }

    public void closeMenu(javax.swing.JFrame form) {
        if (closeSubMenu) {
            form.dispose(); //Closes current menu
            this.closeSubMenu = false; //Resets closeSubMenu flag to false

        }

    }

}
