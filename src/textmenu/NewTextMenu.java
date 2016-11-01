/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textmenu;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author koxmoz
 */
public class NewTextMenu {
    private SuperTextMenu principalMenu;
    private SuperTextMenu activityMenu;
    private ViewMenu view;
    
    public NewTextMenu() {
        view = new ViewMenu();
        principalMenu = new SuperTextMenu();
        activityMenu = new SuperTextMenu("Activity Menu: ", true);
        createPrincipalMenu();
        createActivityMenu();
        principalMenu.run();
    }

    private void createPrincipalMenu() {
        principalMenu.setItem("p", new ArrayList(Arrays.asList("Profile", (Runnable) view::showProfile)));
        principalMenu.setItem("a", new ArrayList(Arrays.asList("Activity", 
                (Runnable) () -> {
                    view.showActivity();
                    activityMenu.run();
                })));
        principalMenu.setItem("q", new ArrayList(Arrays.asList("Quit", 
                (Runnable) () -> {
                    view.quit();
                    System.exit(0);
                })));
    }

    private void createActivityMenu() {
        activityMenu.setItem("m", new ArrayList(Arrays.asList("More Info", (Runnable) view::moreDetails)));
    }
}