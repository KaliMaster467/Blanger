/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppSource.Views.MainUserViews;

import AppSource.Views.MainUserMenu;
import Core.View;
import Public.Styles.BorderRadius;
import Public.Styles.Fonts.Lato;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author alb
 */
public class Friends extends UserViews{
    
    public Friends(MainUserMenu fatherMenu) {
        super(fatherMenu);
        setBackground(Color.white);
        setBounds(0,0 ,fatherMenu.getUserP().getWidth(), 775);
        setLayout(new BorderLayout());
        JScrollPane scroll = new JScrollPane(new StartGUI(this));
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.setBorder(new BorderRadius(Color.BLACK, 1, 0, 0));
        add(scroll);        
    }
    private class StartGUI extends JPanel implements ActionListener
    {
        private UserViews viewm;
        private JTextField friends;
        private JButton search;
        public StartGUI(UserViews viewm){
            this.viewm = viewm;
        setLayout(new FlowLayout());
        setBounds(0, 60, 600, View.VHEIGHT + 200);    
        this.setBackground(Color.white);
            
            friends = new JTextField();
            friends.setVisible(true);
            friends.setPreferredSize(new Dimension(250, 30));
            
            add(friends);
            
            search = new JButton("Buscar");
            search.setVisible(true);
            search.setPreferredSize(new Dimension(100, 30));
            add(search);
            
           
            
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
        
        }
    }
    private class TopUI extends JPanel{
        
        public TopUI(){
            
            Lato lat = new Lato();
            
            setLayout(new BorderLayout());
            
            JLabel title = new JLabel("Hola", SwingConstants.CENTER);
            title.setPreferredSize(new Dimension(600, 150));
            title.setForeground(Color.white);
            title.setFont(lat.getTit());
            add(title, BorderLayout.CENTER);
           
        }
        
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
       
        
        ImageIcon imgb = new ImageIcon(getClass().getResource("/res/day.gif"));
        
        g.drawImage(imgb.getImage(), 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        //super.paint(g);
                    
    }    
    }  
}
