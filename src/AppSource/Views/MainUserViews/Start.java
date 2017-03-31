/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppSource.Views.MainUserViews;

import AppSource.Views.MainUserMenu;
import AppSource.Views.Store;
import Core.View;
import Public.Styles.BorderRadius;
import Public.Styles.Fonts.Lato;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
 * @author axkiller
 */
public class Start extends UserViews{
    private MainUserMenu mainView;
    
    public Start(MainUserMenu fatherMenu) {
        super(fatherMenu);
        mainView= fatherMenu;
        setBackground(Color.white);
        setBounds(0,0 ,fatherMenu.getUserP().getWidth(), 800);
        setLayout(new BorderLayout());
        JScrollPane scroll = new JScrollPane(new StartGUI(this));
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.setBorder(new BorderRadius(Color.BLACK, 1, 0, 0));
        add(scroll);
    }
    private class StartGUI extends JPanel implements ActionListener
    {
        private UserViews viewm;
        private JTextField chat;
        public StartGUI(UserViews viewm){
            this.viewm = viewm;
        setLayout(new BorderLayout());
        setBounds(0, 60, 600, View.VHEIGHT + 200);    
        this.setBackground(Color.white);
            JPanel block = new JPanel();
            block.setLayout(new FlowLayout());
            block.setPreferredSize(new Dimension(this.getWidth(), this.getHeight() + 100));
            block.setBackground(Color.white);
            
            JPanel share = new JPanel();
            share.setLayout(new GridLayout(0,1));
            share.setSize(new Dimension(600, 300));
            share.setBackground(Color.WHITE);
            //share.setBackground(Color.yellow);
            
            
            add(block, BorderLayout.CENTER);   
                
            TopUI _topUI = new TopUI();
            //start.setBackground(Color.red);
            _topUI.setPreferredSize(new Dimension(this.getWidth(), 350));
            
            JPanel searchM = new JPanel();
            searchM.setLayout(new FlowLayout());
            searchM.setBackground(Color.white);
            //searchM.setPreferredSize(new Dimension(600, 130));
            searchM.setSize(new Dimension(600, 100));

           // block.add(searchM, BorderLayout.PAGE_START);
            
            chat = new JTextField();
            chat.setVisible(true);
            chat.setLayout(null);
            chat.setPreferredSize(new Dimension(300, 30));
            searchM.add(chat);
            
            
            
            JButton enviar = new JButton("Enviar");
            enviar.setVisible(true);
            enviar.setPreferredSize(new Dimension(150, 30));
            enviar.addActionListener(this);
            searchM.add(enviar);
            add(_topUI, BorderLayout.PAGE_START);   
            
            block.add(share);
            ImageIcon imgus = new ImageIcon(getClass().getResource("/res/fb-button.png"));
            
            
        
            Image imag = imgus.getImage();
        
            ImageIcon nic = new ImageIcon(MainUserMenu.getScaledImage(imag, 300, 70));
            JLabel fblabel = new JLabel(nic);
            fblabel.setVisible(true);
            fblabel.setPreferredSize(new Dimension(300, 70));
          
            share.add(fblabel);
            
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
           if(ae.getActionCommand().equals("Enviar"))
           {
               viewm.getSuperMenu().getCont().SendChat(chat.getText());
           }
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
