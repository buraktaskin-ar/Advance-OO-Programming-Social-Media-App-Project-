/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Database;
import Model.User;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
public class SideButton extends JPanel {
    
    public SideButton(String text, String pic ,User user,Database database,JFrame f){
        super(new FlowLayout(FlowLayout.LEFT,10,10));
        setMaximumSize(new Dimension(182,50));
        setBackground(GUIConstants.white);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JLabel img = new JLabel(new ImageIcon("icons/"+pic+".png"));
        add(img);
        
        add(new View.JLabel(text,17,GUIConstants.textAreaHint,Font.BOLD));
    
        addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                new CustomView(text,user,database);
                f.dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(GUIConstants.hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(GUIConstants.white);
            }
        
        });
    
    }
    
}
