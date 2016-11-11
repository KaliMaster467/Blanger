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
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
        /*while(true){
        _sideBar.setBounds(0, 0, View.VWIDTH/6, View.VHEIGHT);
        _mainP.setBounds(getSidebar().getWidth(), 0, View.VWIDTH - getSidebar().getWidth(), View.VHEIGHT);
        _userP.setBounds(_sideBar.getWidth(), this.getHeight() / 5, View.VWIDTH - _sideBar.getWidth(), View.VHEIGHT);
        }
        System.out.println("Se destruyo el hilo main");*/
    }
    private JPanel sideBar()
    {
        _sideBar = new JPanel();
        _sideBar.setLayout(null);
        _sideBar.setBounds(0, 0, View.VWIDTH/6, View.VHEIGHT);
        _sideBar.setBorder(new BorderRadius(Color.black, 1, 0, 0));
        _sideBar.setBackground(Color.white);
        

        _sideBar.add(getBut("Personaliza", 0, this.getHeight()/4));
        _sideBar.add(getBut("Información", 0, this.getHeight()/4 + this.getHeight() / 20));
        _sideBar.add(getBut("Contenido", 0, this.getHeight()/4 + 2*this.getHeight() / 20));
        return _sideBar;
    }
    private JButton getBut(String option , int w, int h){
        Public.Styles.Fonts.Raleway ral = new Public.Styles.Fonts.Raleway();
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/res/arrow.png"));
        
        Image imag = icon.getImage();
        
        ImageIcon nic = new ImageIcon(MainUserMenu.getScaledImage(imag, 20, 20));
        
        JButton _personalize = new JButton(option, nic);
        _personalize.setOpaque(true);
        _personalize.setBackground(Color.white);
        _personalize.setForeground(Color.BLACK);
        _personalize.setFocusable(false);
        _personalize.setBorder(null);
        _personalize.setFont(ral.getBtnFont());
        _personalize.setBounds(1, h, _sideBar.getWidth() - 2, this.getHeight() / 20);
        _personalize.setHorizontalAlignment(SwingConstants.LEFT);
        
        return _personalize;
    }
    private JPanel userP()
    {
        _userP = new JPanel();
        _userP.setLayout(null);
        _userP.setBackground(Color.white);
        _userP.setBorder(new BorderRadius(Color.black, 1, 0, 0));
        _userP.setBounds(_sideBar.getWidth(), this.getHeight() / 5, View.VWIDTH - _sideBar.getWidth(), View.VHEIGHT);
        _userP.setVisible(true);
        
        return _userP;
    }
    public JPanel getSidebar()
    {
        return _sideBar;
    }
    public static Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
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
