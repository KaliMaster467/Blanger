/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppSource.Views;

import Core.View;
import Public.Styles.BorderRadius;

import Public.Wnd;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author alb
 */
public class MainUserMenu extends View implements Runnable{
    
    private JPanel _sideBar;
    private Mumain _mainP;
    private JPanel _userP;
    private final Wnd hInstance;
    public MainUserMenu(Wnd hInstance)
    {
        this.hInstance = hInstance;
        setLayout(null);
        setBounds(0, 60, View.VWIDTH, View.VHEIGHT);
        this.setBackground(java.awt.Color.black);
        _sideBar = this.sideBar();
        _mainP = new Mumain(this);
        _userP = userP();
        
        add(_userP);
        add(_mainP);
        add(_sideBar);
    }
    @Override
    public void run() {
        
    }
    private JPanel sideBar()
    {
        _sideBar = new JPanel();
        _sideBar.setLayout(null);
        _sideBar.setBounds(0, 0, View.VWIDTH/6, View.VHEIGHT);
        _sideBar.setBorder(new BorderRadius(Color.black, 1, 0, 0));
        _sideBar.setBackground(Color.white);
        _sideBar.setVisible(true);
        
        return _sideBar;
    }
    private JPanel userP()
    {
        _userP = new JPanel();
        _userP.setLayout(null);
        _userP.setBackground(Color.white);
        _userP.setBounds(_sideBar.getWidth(), this.getHeight() / 5, View.VWIDTH - _sideBar.getWidth(), View.VHEIGHT);
        _userP.setVisible(true);
        
        return _userP;
    }
    public JPanel getSidebar()
    {
        return _sideBar;
    }
    public class Mumain extends JPanel{
        
    private MainUserMenu mainContainer;
    
    public Mumain(MainUserMenu mainContainer)
    {
        this.mainContainer = mainContainer;
        setLayout(null);
        setBounds(mainContainer.getSidebar().getWidth(), 0, View.VWIDTH - mainContainer.getSidebar().getWidth(), View.VHEIGHT);
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
    
}
