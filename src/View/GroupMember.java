/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

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

public class GroupMember extends JPanel {
    public GroupMember(User user){
        
        setLayout(new BorderLayout());
        
        setBackground(GUIConstants.white);
        setBorder(BorderFactory.createEmptyBorder(10,15,10,15));



        JLabel content = new JLabel(user.getName(),20, GUIConstants.post,Font.BOLD);
        add(content,BorderLayout.WEST);

                
        Dimension dimension = new Dimension(500,67);
        setPreferredSize(dimension);
        setMaximumSize(dimension);
        setMinimumSize(dimension);

        
    }      
}
