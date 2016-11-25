/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Public;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author root
 */
public class ErrorWnd extends JFrame implements ActionListener{
    
    public ErrorWnd(Wnd ParentWnd, String error){
        this.setUndecorated(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setSize(100, 50);
        init();
        
        
    }
    public void init(){
        JPanel pan = new JPanel();
        pan.setBackground(Color.red);
        pan.setBounds(0, 0, this.getWidth(), 100);
        JButton button = new JButton("OK");
        button.addActionListener(this);
        button.setBounds(pan.getWidth()/3, pan.getHeight()/4, 50, 25);
        button.setVisible(true);
        pan.add(button);
        pan.setVisible(true);
        
        this.add(pan);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("OK")){
            this.dispose();
        }
    }
}
