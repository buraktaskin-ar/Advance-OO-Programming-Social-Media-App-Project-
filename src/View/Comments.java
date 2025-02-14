/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;


import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Comments {
    public Comments(){
        JFrame frame = new JFrame();
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBackground(null);
        
        
        //panel.add(new Post());
        //panel.add(Box.createVerticalStrut(7));
        
        JPanel newComment = new JPanel(new BorderLayout());
        newComment.setBackground(GUIConstants.white);
        Dimension dimension = new Dimension(500,58);
        newComment.setPreferredSize(dimension);
        newComment.setMaximumSize(dimension);
        newComment.setMinimumSize(dimension);
        newComment.setBorder(BorderFactory.createEmptyBorder(10,10,10,15));
        
        JTextArea commentIn = new JTextArea("Type a comment", 18,5);
        newComment.add(new JScrollPane(commentIn),BorderLayout.CENTER);
        
        JButton commentBtn = new JButton("Post",35,16);
        commentBtn.setPreferredSize(new Dimension(81,37));
        panel.add(newComment);
        panel.add(Box.createVerticalStrut(7));
        
        for(int i =0; i<10;i++){
            panel.add(new Comment());
            panel.add(Box.createVerticalStrut(7));
        }
        
        frame.getContentPane().add(new JScrollPane(panel));
        frame.setVisible(true);
        frame.requestFocus();
    }
    
}
