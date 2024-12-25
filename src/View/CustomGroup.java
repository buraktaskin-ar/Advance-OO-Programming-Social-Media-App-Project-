/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.JoinGroup;
import Model.Database;
import Model.User;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author grapl
 */
public class CustomGroup extends JPanel {
    public CustomGroup(Model.Group group,Database database,User user){
        
        setLayout(new BorderLayout());
        
        setBackground(GUIConstants.white);
        setBorder(BorderFactory.createEmptyBorder(10,15,10,15));



        JLabel content = new JLabel(group.getName(),20, GUIConstants.post,Font.BOLD);
        add(content,BorderLayout.WEST);

        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        right.setBackground(null);
        add(right);

        
        
        JButton joinButton = new JButton("Join",35,16);
        joinButton.setPreferredSize(new Dimension(81,37));
        joinButton.setVisible(true);
        

        joinButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {         
                if (new JoinGroup(group,database,user).isJoined()){
                    joinButton.setVisible(false);
                   
                }  
                
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
        if (new JoinGroup(group,database,user).isMember()){
                joinButton.setVisible(false);
                
        }
        JButton infoButton = new JButton("Info",35,16);
        infoButton.setPreferredSize(new Dimension(81,37));
        infoButton.setVisible(true);
        
        infoButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {         
                new CustomView(user,database,group);
                
                
                
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

        right.add(joinButton);
        right.add(infoButton);
        
        
        add(right);
        Dimension dimension = new Dimension(500,67);
        setPreferredSize(dimension);
        setMaximumSize(dimension);
        setMinimumSize(dimension);

        
    }      
}
