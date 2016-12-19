/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Public;

import AppSource.Views.MainUserMenu;
import Public.Styles.Fonts.Lato;
import Public.Styles.Fonts.Raleway;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author root
 */
public class ErrWnd extends JFrame implements ActionListener{
    private String des;
    public ErrWnd(String des){    
        this.des = des;
 
        
        
        setSize(700, 300);
        setLocationRelativeTo(null);
        setUndecorated(true);
        ImageIcon imgus = new ImageIcon(getClass().getResource("/res/sad.png"));
        
        Image imag = imgus.getImage();
        
        ImageIcon nic = new ImageIcon(MainUserMenu.getScaledImage(imag, 120, 120));
        
        JPanel pan = new JPanel();
        pan.setBounds(0, 0, 700, 300);
        pan.setBackground(Color.red);
        pan.setLayout(null);
        pan.setVisible(true);
        
        JLabel lab = new JLabel(nic);
        lab.setBounds(80,80, 120, 120);
        lab.setVisible(true);
        pan.add(lab);
        
        Raleway lat = new Raleway();
        
        JLabel dess = new JLabel(des);
        dess.setBounds(210, 90, 500, 100);
        dess.setForeground(Color.white);
        dess.setFont(lat.getLabelFont());
        pan.add(dess);
        
        JButton but = new JButton("OK");
        
        but.setLocation(0, pan.getHeight()-50);
        but.setVisible(true);
        but.setSize(pan.getWidth(), 50);
        but.addActionListener(this);
        but.setOpaque(true);
        but.setBackground(Color.black);
        but.setFocusable(false);
        but.setBorder(null);
        but.setFocusPainted(false);
        but.setBorderPainted(false);        
        but.setForeground(Color.white);
       
       
        pan.add(but);
        
        add(pan);
       
        setVisible(true);
        
        
   

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("OK")){
            this.dispose();
        }
    }
}
