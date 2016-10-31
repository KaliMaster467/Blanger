/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Public.Styles;

import AppSource.Views.MainUserMenu;
import Core.View;
import Public.Wnd;
import java.awt.Dimension;
import java.awt.Graphics;
import javafx.scene.paint.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author root
 */
public class Mumain extends JPanel{
    private MainUserMenu mainContainer;
    public Mumain(MainUserMenu mainContainer)
    {
        this.mainContainer = mainContainer;
        setLayout(null);
        setBounds(mainContainer.getSidebar().getWidth(), 0, View.VWIDTH - mainContainer.getWidth(), View.VHEIGHT);
        this.setBackground(java.awt.Color.red);
        setVisible(true);
    }
    public void paint(Graphics g)
    {
        Dimension dim = this.getSize();
        
        ImageIcon imgb = new ImageIcon(getClass().getResource("/res/backIni.png"));
        
        g.drawImage(imgb.getImage(), 0, 0, dim.width, dim.height, null);
        setOpaque(false);
        super.paint(g);
                    
    }
}
