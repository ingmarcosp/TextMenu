/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textmenu;

/**
 *
 * @author koxmoz
 */
public class Main {

    private static TextMenu menu;
    private static ViewMenu view;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu = new TextMenu();
        menu.createPrincipalMenu();
        menu.run(new Runnable() {public void run() {view.principalMenu();}});
    }
}
