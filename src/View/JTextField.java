/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import View.GUIConstants;
import java.awt.Shape;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;

public class JTextField extends javax.swing.JTextField {
    
    private Shape shape;
    private String hint;
    
    public JTextField(String hint){
        super();
        this.hint = hint;
        setFont(new Font("Segoe UI",Font.BOLD,20));
        setOpaque(false);
        setText(hint);
        setForeground(GUIConstants.textFieldHint);
        setBorder(BorderFactory.createEmptyBorder(TOP,20,BOTTOM,20));
        
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(hint)){
                    setText("");
                    setForeground(GUIConstants.black);

                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().equals("")){
                    setText(hint);
                    setForeground(GUIConstants.textFieldHint);

                }           
            }
        });
        
    }
    
    protected void paintComponent(Graphics g){
        g.setColor(GUIConstants.white);
        g.fillRoundRect(0,0,getWidth()-1,getHeight()-1,45,45);
        super.paintComponent(g);
    }
    protected void paintBorder(Graphics g){
        g.setColor(GUIConstants.white);
        g.drawRoundRect(0,0,getWidth()-1,getHeight()-1,45,45);
        
    }
    public boolean contains(int x, int y ){
        if (shape == null || !shape.getBounds().equals(getBounds())){
            shape = new RoundRectangle2D.Float(0,0,getWidth()-1,getHeight()-1,45,45);
            
        }
        return shape.contains(x,y);
        
    }
    
    public boolean isEmpty(){
    
        return getText().equals(hint)||getText().equals("");
    }
}
                

            
    

 
