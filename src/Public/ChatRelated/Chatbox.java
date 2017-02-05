/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Public.ChatRelated;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author root
 */
public class Chatbox extends JPanel{
    private static int messageInter = 5;
    private JLabel chatName;
    
    public Chatbox(JPanel footerInstance, String message)
    {
        this.setBounds(0,0, 280, footerInstance.getHeight() );
        this.setLayout(null);
        this.setVisible(true);
        this.setBackground(Color.GRAY);
        
        chatName = new JLabel(message);
        chatName.setBounds(this.getWidth() / 6, this.getHeight() / 8, 200, 40);
        
        this.add(chatName);
        
    }
}
