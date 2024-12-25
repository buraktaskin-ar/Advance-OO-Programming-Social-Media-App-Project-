/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.AddFriend;
import Controller.RemoveFriend;
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

@SuppressWarnings("serial")
public class Friend  extends JPanel{
    
    public Friend(User mainUser,Database database ,User u){
        setLayout(new BorderLayout());
        //setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBackground(GUIConstants.white);
        setBorder(BorderFactory.createEmptyBorder(10,15,10,15));
        

        
        JLabel author = new JLabel(u.getName(),20, GUIConstants.post,Font.BOLD);
        add(author,BorderLayout.WEST);
        
        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        right.setBackground(null);
        add(right);
        
        JButton addFriend = new JButton("Add",35,16);
        addFriend.setPreferredSize(new Dimension(81,37));
        addFriend.setVisible(false);
        

        
        right.add(addFriend);
        
        JLabel remove = new JLabel("Remove",16,GUIConstants.blue,Font.BOLD);
        remove.setCursor(new Cursor(Cursor.HAND_CURSOR));
        remove.setVisible(false);
        remove.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));      
        remove.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if (new RemoveFriend(mainUser,database,u).isRemoved()){
                    mainUser.removeFriend(u);
                    remove.setVisible(false);
                    addFriend.setVisible(true);
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
        
        right.add(remove);
        
        if (mainUser.isFriend(u)){
            addFriend.setVisible(false);
            remove.setVisible(true);
        }
        else {
            addFriend.setVisible(true);
            remove.setVisible(false);
        }
        addFriend.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if (new AddFriend(mainUser,database,u).isAdded()){
                    mainUser.addFriend(u);
                    addFriend.setVisible(false);
                    remove.setVisible(true);
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
        add(right);
        
        Dimension dimension = new Dimension(500,67);
        setPreferredSize(dimension);
        setMaximumSize(dimension);
        setMinimumSize(dimension);
        
        
        
    }
}
