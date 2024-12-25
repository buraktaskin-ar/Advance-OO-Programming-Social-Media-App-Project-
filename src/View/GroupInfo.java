/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Model.Database;
import Model.User;
import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.Font;



import javax.swing.BorderFactory;


import javax.swing.JPanel;
public class GroupInfo extends JPanel{
    public GroupInfo (User mainUser,Database database,Model.Group g){
        
        setLayout(new BorderLayout());
        
        setBackground(GUIConstants.white);
        setBorder(BorderFactory.createEmptyBorder(10,15,10,15));



        JLabel content = new JLabel("Our Group Members!",20, GUIConstants.post,Font.BOLD);
        add(content,BorderLayout.CENTER);
 

        Dimension dimension = new Dimension(500,67);
        setPreferredSize(dimension);
        setMaximumSize(dimension);
        setMinimumSize(dimension);

        
    }   
}
