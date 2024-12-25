/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SocialMedia;

import View.Welcome;
import Model.Database;
import View.Comments;
import View.CustomView;

/**
 *
 * @author grapl
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        new Welcome(new Database());
        //new CustomView();
        //new Comments();
    }
}
