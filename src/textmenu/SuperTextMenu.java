/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textmenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author koxmoz
 */
public class SuperTextMenu implements Runnable {
    private HashMap<String, ArrayList> menu;
    private boolean loop;
    private String menuName;
    
    public SuperTextMenu(){
        menu = new HashMap<>();
        loop = true;
        menuName = "Menu: ";
    }

    public SuperTextMenu(String name, boolean isSubmenu){
        menu = new HashMap<>();
        loop = true;
        menuName = name;
        if (isSubmenu) {
            menu.put("b", new ArrayList(Arrays.asList("Go Back", (Runnable) this::goBack)));
        }
    }
    
    public void setItem(String key, ArrayList item){
        menu.put(key, item);
    }
    
    public void setNameMenu(String name) {
        menuName = name;
    }
    
    @Override
    public void run() {
        String menuList = getMenu();
        while(loop){
            System.out.println(menuList);
            System.out.print("Option: ");
            String option = new Scanner(System.in).nextLine();
            
            if(menu.containsKey(option)){
                Runnable item = (Runnable) menu.get(option).get(1);
                item.run();
            }
            else {
                System.out.println("Wrong option.\n");
            }
        }
    }

    private String getMenu() {
        String menuList = "\n" + menuName + "\n";
        for (Map.Entry<String, ArrayList> item : menu.entrySet()) {
            String key = item.getKey();
            ArrayList value = item.getValue();
            menuList = menuList + "[" + key + "] : " + value.get(0) + "\n";
        }
        return menuList;
    }
    
    private void goBack() {
        loop = false;
    }
}