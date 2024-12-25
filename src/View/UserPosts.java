/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.GenerateTimeline;
import Model.Database;
import Model.User;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;

import javax.swing.JPanel;

public class UserPosts extends JPanel{
    public UserPosts(User mainUser,Database database) {
    
        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new BorderLayout());
        
        
        
        JPanel sideBar = new JPanel();
        sideBar.setBackground(GUIConstants.white);
        Dimension sideBarDim = new Dimension(182,1000);
        sideBar.setPreferredSize(sideBarDim);
        sideBar.setMaximumSize(sideBarDim);
        sideBar.setMinimumSize(sideBarDim);
        sideBar.setLayout(new BoxLayout(sideBar,BoxLayout.Y_AXIS));
        sideBar.add(Box.createVerticalStrut(10));
        
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBackground(null);
        
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(GUIConstants.white);
        Dimension dimension = new Dimension(500,159);
        header.setPreferredSize(dimension);
        header.setMinimumSize(dimension);
        header.setMaximumSize(dimension);
        header.setBorder(BorderFactory.createEmptyBorder(10,15,10,15));
        
        JPanel north  = new JPanel(new BorderLayout());
        north.setBackground(null);
        north.add(new JLabel("Home",20,GUIConstants.black,Font.BOLD),BorderLayout.WEST);
        
        
        header.add(north,BorderLayout.NORTH);
        
        
        
        ArrayList<Model.Post> posts = new GenerateTimeline(mainUser,database,mainUser).getPosts();
        for (int i = 0 ; i<posts.size();i++){
        
                panel.add(Box.createVerticalStrut(7));
                panel.add(new Post(posts.get(i)));;
        } 

        add(new JScrollPane(panel),BorderLayout.CENTER);
        frame.getContentPane().add(Box.createHorizontalStrut(182),BorderLayout.EAST);
        
        frame.setVisible(true);
        frame.requestFocus();
        
    
    }
}
