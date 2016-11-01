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
public class ViewMenu {
    
    /*
    * This will be the Principal Menu or top Menu printed Out, and the option
    * are Pp, Aa, Qq.
    * the user should type this keys
    */
    public void principalMenu() {
        System.out.println("[P]rofile - [A]ctivity - [Q]uit");
    }
    
    public void showProfile() {
        System.out.println("Your name is: Marcos");
    }
    
    public void showActivity() {
        System.out.println("Your activity is: Programmer");
    }
    
    public void quit() {
        System.out.println("GoodBye!!");
    }
    
    /*
    * The option here are Bb Mm
    */
    public void activityMenu() {
        System.out.println("[B]ack - [M]ore details");
    }
    
    public void moreDetails() {
        System.out.println("Right now you are testing.");
    }
    
    public void wrongOption() {
        System.out.println("Sorry, wrong Option. Try the in the braces '[]'");
        
    }
}
