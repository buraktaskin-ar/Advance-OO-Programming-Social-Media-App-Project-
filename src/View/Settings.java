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
import javax.swing.Box;
import Controller.UpdateUserPrivacy;

/**
 *
 * @author grapl
 */
public class Settings extends JPanel{
     public Settings(User mainUser,Database database){
        setLayout(new BorderLayout());
        //setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBackground(GUIConstants.white);
        setBorder(BorderFactory.createEmptyBorder(10,15,10,15));



        JLabel author = new JLabel("Click to make your account private!",20, GUIConstants.post,Font.BOLD);
        add(author,BorderLayout.WEST);

        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        right.setBackground(null);
        add(right);

        JButton privacyButton = new JButton("Privacy",35,16);
        privacyButton.setPreferredSize(new Dimension(81,37));
        privacyButton.setVisible(true);



        right.add(privacyButton);

        JLabel unprivacyButton = new JLabel("Unprivacy",16,GUIConstants.blue,Font.BOLD);
        unprivacyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        unprivacyButton.setVisible(false);
        unprivacyButton.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));   
        

        
        

        unprivacyButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                privacyButton.setVisible(true);
                mainUser.setprivacyEnabled(true) ;
                new UpdateUserPrivacy(mainUser,database,"false");
                unprivacyButton.setVisible(false);
                
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

        right.add(unprivacyButton);
        if (mainUser.getprivacyEnabled()){
            unprivacyButton.setVisible(true);
            privacyButton.setVisible(false);
        }
        else {
            unprivacyButton.setVisible(false);
            privacyButton.setVisible(true);
        }
        
        privacyButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                privacyButton.setVisible(false);
                mainUser.setprivacyEnabled(false) ;
                new UpdateUserPrivacy(mainUser,database,"true");
                unprivacyButton.setVisible(true);
                
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
