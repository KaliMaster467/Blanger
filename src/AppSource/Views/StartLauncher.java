/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//StartLauncher Vista
package AppSource.Views;

import Core.Controller;
import Core.View;
import Public.Wnd;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author alb
 */
public class StartLauncher extends View implements Runnable{
    
    private final Wnd hInstance;
    private JLabel usr;
    
    public StartLauncher(Wnd hInstance)
    {
        this.hInstance = hInstance;
        setLayout(null);
        setBounds(0, 50, View.VWIDTH, View.VHEIGHT);
        
        this.setBackground(java.awt.Color.black);
        //this.add(new StartLauncher_Main_Login_Container(hInstance.getLocation().x
        //,hInstance.getLocation().y));
        ImageIcon imgus = new ImageIcon(getClass().getResource("/res/user.png"));
        
        usr = new JLabel(imgus, SwingConstants.CENTER);
    
        usr.setBounds((hInstance.getWidth() / 3) + hInstance.getWidth() / 12, 50, 256, 256 );
        usr.setLayout(null);
        usr.setVisible(true);
        this.add(usr);
        this.setVisible(true);
        Thread sizes = new Thread(this);
        sizes.start();
    }
    public void paint(Graphics g)
    {
        Dimension dim = this.getSize();
        
        ImageIcon imgb = new ImageIcon(getClass().getResource("/res/start.jpg"));
        
        g.drawImage(imgb.getImage(), 0, 0, dim.width, dim.height, null);
        setOpaque(false);
        super.paint(g);
                    
    }

    @Override
    public void run() {
        while(true)
        {
            usr.setBounds((hInstance.getWidth() / 3) + + hInstance.getWidth() / 12, 50, 256, 256 );
        }
    }
    private class StartLauncher_Main_Login_Container extends JPanel
    {       
        public StartLauncher_Main_Login_Container(int X, int Y)
        {
           setSize(200, 300);
           setLocation(X, Y);
           setLayout(null);
           AbstractBorder brdr = new Public.Styles.BorderRadius(Color.BLACK,1,20,0);       
           setBorder(brdr);
           setBackground(new Color(0, 0, 0, 50));
           
           setVisible(true);
        }
    }
    
}
