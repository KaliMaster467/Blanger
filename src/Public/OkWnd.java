/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Public;

import AppSource.Views.MainUserMenu;
import Public.Styles.Fonts.Raleway;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author root
 */
public class OkWnd extends JFrame{
    private static String des;
    public OkWnd(String des){    
        OkWnd.des = des;
        SwingUtilities.invokeLater(new Runnable() {
    @Override
    public void run() {
      
        setSize(700, 300);
        setLocationRelativeTo(null);
       
        ImageIcon imgus = new ImageIcon(getClass().getResource("/res/happy.png"));
        
        Image imag = imgus.getImage();
        
        ImageIcon nic = new ImageIcon(MainUserMenu.getScaledImage(imag, 190, 190));
        
        JPanel pan = new JPanel();
        pan.setBounds(0, 0, 700, 300);
        pan.setBackground(new Color(23, 247, 61));
        pan.setLayout(null);
        pan.setVisible(true);
        
        JLabel lab = new JLabel(nic);
        lab.setBounds(20,30, 190, 190);
        lab.setVisible(true);
        pan.add(lab);
        
        Raleway lat = new Raleway();
        
        JLabel des = new JLabel(OkWnd.des);
        des.setBounds(250, 30, 400, 100);
        des.setForeground(Color.white);
        des.setFont(lat.getLabelFont());
        pan.add(des);
        
        /*JButton but = new JButton("ok");
        
        but.setBounds(30, 40, 50, 20);
        but.setVisible(true);
        pan.add(but);*/
        
        add(pan);
        
        setVisible(true);
        
    }
    });

    }    
}
