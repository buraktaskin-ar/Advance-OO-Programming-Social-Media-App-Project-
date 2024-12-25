/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class Post  extends JPanel{
    public Post(Model.Post post){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBackground(GUIConstants.white);
        setBorder(BorderFactory.createEmptyBorder(15,15,15,25));
        
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(null);
        
        JLabel author = new JLabel(post.getUser().getName(), 20,GUIConstants.post,Font.BOLD);
        header.add(author,BorderLayout.WEST);
        
        JLabel date = new JLabel(post.getDateToString(),15,GUIConstants.post,Font.PLAIN);
        header.add(date, BorderLayout.EAST);
        add(header);
        add(Box.createVerticalStrut(7));
        
        JPanel center = new JPanel(new FlowLayout(FlowLayout.LEADING));
        center.setBackground(null);
        JTextArea content = new JTextArea(post.getContent(),18,GUIConstants.post,Font.PLAIN);
        center.add(content);
        add(center);
        add(Box.createVerticalStrut(7));
        
        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBackground(null);
        
        JPanel likes = new JPanel(new FlowLayout(FlowLayout.LEFT,13,13));
        likes.setBackground(null);
        likes.add(new javax.swing.JLabel(new ImageIcon("icons/like.png")));
        likes.add(new JLabel("0 Likes",15,GUIConstants.textFieldHint, Font.BOLD));
        
        bottom.add(likes,BorderLayout.WEST);
        
        JLabel comments = new JLabel("0 Comments",15,GUIConstants.textFieldHint,Font.BOLD);
        bottom.add(comments,BorderLayout.EAST);
        add(bottom);
        
        int height = (int) (115+ content.getPreferredSize().getHeight());
        Dimension dimension = new Dimension(500,height);
        
        setPreferredSize(dimension);
        setMaximumSize(dimension);
        setMinimumSize(dimension);
        
        
        
    }
}
