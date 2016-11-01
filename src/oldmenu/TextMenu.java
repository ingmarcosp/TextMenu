/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oldmenu;

import java.util.HashMap;
import java.util.Scanner;
import textmenu.ViewMenu;

/**
 *
 * @author koxmoz
 */
public final class TextMenu {
    
    private static HashMap<String, Runnable> principalMenu = new HashMap<>();
    private static HashMap<String, Runnable> currentMenu = new HashMap<>();
    private static HashMap<String, Runnable> activityMenu = new HashMap<>();
    private static ViewMenu view = new ViewMenu();
    private static boolean loop = true;

    public TextMenu(){
        view = new ViewMenu();
        createPrincipalMenu();
        currentMenu = principalMenu;
        run(view::principalMenu);
    }

    public TextMenu(HashMap<String, Runnable> subMenu, Runnable menu, boolean haveGoBack) {
        currentMenu = subMenu;
        if (haveGoBack) {
            activityMenu.put("b", this::goBack);
            activityMenu.put("B", this::goBack);
        }
        run(menu);
    }

    /*
    * Ugly??
    */
    public void createPrincipalMenu() {
        principalMenu.put("p", view::showProfile); //.put("p", ["Show Profile", view::showProfile])
        principalMenu.put("P", view::showProfile);
        principalMenu.put("a", this::runActivityMenu);
        principalMenu.put("A", this::runActivityMenu);
        principalMenu.put("q", (Runnable) () -> {quitProgram();});
        principalMenu.put("Q", (Runnable) () -> {quitProgram();});
    }
    
    private void createActivityMenu() {
        activityMenu.put("m", view::moreDetails);
        activityMenu.put("M", view::moreDetails);
    }
    
    private void runActivityMenu() {
        view.showActivity();
        createActivityMenu();
        TextMenu submenu = new TextMenu(activityMenu, view::activityMenu, true);
        loop = true;
        currentMenu = principalMenu;
    }
    
    
    public void run(Runnable menu) {
        while(loop){
            menu.run();
            String option = new Scanner(System.in).nextLine();
            if(currentMenu.containsKey(option)){
                currentMenu.get(option).run();
            }
            else {
                view.wrongOption();
            }
        }
    }
    
    private void quitProgram() {
        view.quit();
        System.exit(0);
    }
    private void goBack() {
        loop = false;
    }
    
}
