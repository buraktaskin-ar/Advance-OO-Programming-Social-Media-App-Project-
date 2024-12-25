
package View;

import java.awt.Font;
import java.awt.Color;


@SuppressWarnings("serial")
public class JLabel extends javax.swing.JLabel {
    
    public JLabel(String text, int textSize, Color color, int style){
        setFont(new Font("Segoe UI",style,textSize));
        setText(text);
        setForeground(color);
    }



}
