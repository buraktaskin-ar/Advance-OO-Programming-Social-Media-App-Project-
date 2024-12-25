/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;


import Controller.CreateGroup;
import Model.Database;
import Model.User;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author grapl
 */
public class CreateGroupV extends JPanel {
    
      public CreateGroupV(Model.Group group,Database database,User mainUser){
       
        setLayout(new BorderLayout());
        
        setBackground(GUIConstants.white);
        setBorder(BorderFactory.createEmptyBorder(10,15,10,15));

        JTextField name = new JTextField("Group Name");
        add(name,BorderLayout.WEST);
        

        
        JButton createButton = new JButton("Create",35,16);
        createButton.setPreferredSize(new Dimension(20,20));
        createButton.setVisible(true);
        
        
        createButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (name.isEmpty()){
                    new Alert("Group Name cannot be empty",null);
                    return;
                }
                Model.Group g = new Model.Group();
                g.setName(name.getText());
                CreateGroup create = new CreateGroup(g,database,mainUser);
                create.create();
                
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
        add(createButton);
        Dimension dimension = new Dimension(500,67);
        setPreferredSize(dimension);
        setMaximumSize(dimension);
        setMinimumSize(dimension);

        
    }    
}
