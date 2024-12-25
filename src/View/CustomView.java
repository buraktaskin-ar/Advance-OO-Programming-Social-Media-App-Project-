/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.ReadAllGroupMembers;
import Controller.ReadAllGroups;
import Controller.ReadAllUsers;
import Model.Database;
import Model.User;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class CustomView {
    public CustomView(String view, User user, Database database){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBackground(null);

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(GUIConstants.white);
        Dimension dimension = new Dimension(500,50);
        header.setPreferredSize(dimension);
        header.setMaximumSize(dimension);
        header.setMinimumSize(dimension);
        header.setBorder(BorderFactory.createEmptyBorder(10,15,10,15));
    
        JPanel north = new JPanel(new BorderLayout());
        north.setBackground(null);
        north.add(new JLabel(view,20,GUIConstants.black,Font.BOLD),BorderLayout.WEST);
        
        javax.swing.JLabel home = new javax.swing.JLabel(new ImageIcon("icons/home.png"));
        home.setCursor(new Cursor(Cursor.HAND_CURSOR));
        home.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                new Home(user,database);
                frame.dispose();
            }
                
                
            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        
        north.add(home,BorderLayout.EAST);
        header.add(north,BorderLayout.NORTH);
        
        panel.add(header);
        switch(view){
            case "Friends":
                ArrayList<User> users = new ReadAllUsers(database,user).getList();                
                for(User u: users){
                    if (!u.getprivacyEnabled()){
                        panel.add(Box.createVerticalStrut(7));
                        panel.add(new Friend(user,database,u));
                
                    }
                }          
                break;
            case "Settings":
                panel.add(new Settings(user,database) );
                break;
                
            case "Group":
                panel.add(new Group(user,database));
                ArrayList<Model.Group> groups = new ReadAllGroups(database).getList();
                for (Model.Group g: groups){
                    panel.add(Box.createVerticalStrut(7));
                    panel.add(new CustomGroup(g,database,user));
                }
                break;
            
            case "Create Group":
                Model.Group g = new Model.Group();
                panel.add(new CreateGroupV(g,database,user));
                break;
                
            case "Posts":
                panel.add(new UserPosts(user,database));
                
                break;
                
        }
        
        

        
        frame.getContentPane().add(new JScrollPane(panel));
        frame.setVisible(true);
        frame.requestFocus();
    }
    
    public CustomView(User user, Database database,Model.Group groupp){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBackground(null);

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(GUIConstants.white);
        Dimension dimension = new Dimension(500,50);
        header.setPreferredSize(dimension);
        header.setMaximumSize(dimension);
        header.setMinimumSize(dimension);
        header.setBorder(BorderFactory.createEmptyBorder(10,15,10,15));
    
        JPanel north = new JPanel(new BorderLayout());
        north.setBackground(null);
        north.add(new JLabel(groupp.getName(),20,GUIConstants.black,Font.BOLD),BorderLayout.WEST);
        
        javax.swing.JLabel home = new javax.swing.JLabel(new ImageIcon("icons/home.png"));
        home.setCursor(new Cursor(Cursor.HAND_CURSOR));
        home.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                new Home(user,database);
                frame.dispose();
            }
                
                
            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        
        north.add(home,BorderLayout.EAST);
        header.add(north,BorderLayout.NORTH);
        
        panel.add(header);
        
        panel.add(new GroupInfo(user,database,groupp));
        
        ArrayList<User> users = new ReadAllGroupMembers(database,groupp).getList();
        
        for (User u: users){
            panel.add(Box.createVerticalStrut(7));
            panel.add(new GroupMember(u));
            
        }
        
        
        

        
        frame.getContentPane().add(new JScrollPane(panel));
        frame.setVisible(true);
        frame.requestFocus();
    }

    
}   
