/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textmenu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import textmenu.ViewMenu.*;

/**
 *
 * @author koxmoz
 */
public final class TextMenu {
    
    private static HashMap<String, Runnable> principalMenu;
    private static ViewMenu view = new ViewMenu();
    private static boolean loop = true;

    public TextMenu(){
        view = new ViewMenu();
        principalMenu = new HashMap<>();
        createPrincipalMenu();
        run(new Runnable() {public void run() {view.principalMenu();}} );
    }

    public TextMenu(HashMap<String, Runnable> subMenu) {
        principalMenu = subMenu;
    }

    /*
    * Ugly??
    */
    public void createPrincipalMenu() {
        principalMenu.put("p", view::showProfile);
        principalMenu.put("P", view::showProfile);
        principalMenu.put("a", new Runnable() { public void run() { 
                view.showActivity();
                TextMenu submenu;
                HashMap<String, Runnable> menu = new HashMap<String, Runnable>();
                menu.put("m", view::moreDetails);
                menu.put("M", view::moreDetails);
                menu.put("b", (Runnable) () -> { loop = false; });
                menu.put("B", (Runnable) () -> { loop = false; });
                submenu = new TextMenu(menu);
                submenu.run(view::activityMenu);
                loop = true;
                createPrincipalMenu();
            }});
        principalMenu.put("A", new Runnable() { public void run() { 
                view.showActivity();
                TextMenu submenu;
                HashMap<String, Runnable> menu = new HashMap<>();
                menu.put("m", new Runnable() { public void run() { view.moreDetails();}});
                menu.put("M", new Runnable() { public void run() { view.moreDetails();}});
                menu.put("b", new Runnable() { public void run() { loop = false;}});
                menu.put("B", new Runnable() { public void run() { loop = false;}});
                submenu = new TextMenu(menu);
                submenu.run(new Runnable() {public void run() {view.activityMenu();}});
                loop = true;
                createPrincipalMenu();
            }});
        principalMenu.put("q", (Runnable) () -> {view.quit();
                                                 System.exit(0);
                                            });
        principalMenu.put("Q", new Runnable() { public void run() { view.quit();
                                                                    System.exit(0);}});
    }

    public void run(Runnable menu) {
        while(loop){
            menu.run();
            String option = new Scanner(System.in).nextLine();
            if(principalMenu.containsKey(option)){
                principalMenu.get(option).run();
            }
            else {
                view.wrongOption();
            }
        }
    }
}
