/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppSource.Views;

import Core.View;
import Core.auxil.Usuario;
import Public.Styles.BorderRadius;

import Public.Wnd;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author alb
 */
public class MainUserMenu extends View implements Runnable, ActionListener, AppSource.Views.Interfaces.ResizePath{
    
    private JPanel _sideBar;
    private Mumain _mainP;
    private JPanel _userP;
    private JPanel _footer;
    private final Wnd hInstance;
    private final AppSource.Controllers.MainUserMenu cont;
    public MainUserMenu(Wnd hInstance, AppSource.Controllers.MainUserMenu cont)
    {
        this.hInstance = hInstance;
        this.cont = cont;
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainUserMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MainUserMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MainUserMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainUserMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        setLayout(new BorderLayout());
        setBounds(0, 60, View.VWIDTH, View.VHEIGHT);
        setBackground(new Color(0,0,0, 128));
        setBorder(new BorderRadius(Color.black, 1, 0 ,0));
        _sideBar = this.sideBar();
        _mainP = new Mumain(this);
        _userP = userP();
        _footer = footer();
        add(_footer);
        add(_userP);
        add(_mainP);
        add(_sideBar);
        
        
     
    }
        public void paint(Graphics g)
    {
        Dimension dim = this.getSize();
        
        ImageIcon imgb = new ImageIcon(getClass().getResource("/res/menback.jpg"));
        
        g.drawImage(imgb.getImage(), 0, 0, dim.width, dim.height, null);
        setOpaque(false);
        
        super.paint(g);
                    
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
    private JPanel footer(){
        JPanel footer = new JPanel();
        
        footer.setLayout(new BorderLayout());
        footer.setBackground(Color.white);
        footer.setBounds(0, ((int)Wnd.getWndSize().getHeight() - 100) - 125, View.VWIDTH, 65);
        footer.setVisible(true);
        return footer;
    }
    private JPanel sideBar()
    {
        _sideBar = new JPanel();
        _sideBar.setLayout(null);
        _sideBar.setBounds(0,  0, View.VWIDTH/6, View.VHEIGHT);
        _sideBar.setBorder(new BorderRadius(Color.black, 1, 0, 0));
        _sideBar.setBackground(new Color(0,0,0,128));
        

        _sideBar.add(getBut("Mi perfil", 0, this.getLocation().y));
        _sideBar.add(getBut("Información", 0, this.getHeight()/4 + this.getHeight() / 20 + 20));
        //_sideBar.add(getBut("", 0, this.getHeight()/4 + 2*this.getHeight() / 20 + 20));
        //_sideBar.add(getBut("Mi perfil", 0, this.getHeight()/4 + 3*this.getHeight() /20 + 20));
        return _sideBar;
    }
    private JButton getBut(String option , int w, int h){
        Public.Styles.Fonts.Raleway ral = new Public.Styles.Fonts.Raleway();
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/res/arrow.png"));
        
        Image imag = icon.getImage();
        
        ImageIcon nic = new ImageIcon(MainUserMenu.getScaledImage(imag, 20, 20));
        
        JButton _personalize = new JButton(option);
        _personalize.setOpaque(true);
        _personalize.setBackground(new Color(0,0,0,200));
        _personalize.setForeground(Color.white);
        _personalize.setFocusable(false);
        _personalize.setBorder(null);
        _personalize.setFont(ral.getBtnFont());
        //_personalize.setContentAreaFilled(false);
        _personalize.addActionListener(this);
        _personalize.setBounds(30, h, _sideBar.getWidth() - 2, this.getHeight() / 20);
        _personalize.setHorizontalAlignment(SwingConstants.LEFT);
        
        return _personalize;
    }
    private JPanel userP()
    {
        Public.Styles.Fonts.Raleway ral = new Public.Styles.Fonts.Raleway();
        _userP = new JPanel();
        _userP.setLayout(null);
        _userP.setBackground(new Color(30, 32, 38, 140));
        _userP.setBorder(new BorderRadius(Color.black, 1, 0, 0));
        _userP.setBounds(_sideBar.getWidth(), this.getHeight() / 7, View.VWIDTH - _sideBar.getWidth(), View.VHEIGHT);
        _userP.setVisible(true);
        
        if(Usuario.getNombre() == null){
            JLabel ini = new JLabel("Inicia sesión para tener una mejor experiéncia");
            ini.setSize(1300, 300);
            ini.setLocation(_userP.getWidth()/3, _userP.getHeight()/7);
            ini.setForeground(Color.gray);
            ini.setFont(ral.getBtnFont());
            ini.setVisible(true);
            _userP.add(ini);
        }else{
            JLabel lnombre = new JLabel("Nombre:");
            lnombre.setSize(200, 50);
            lnombre.setLocation(200, _userP.getHeight()/8);
            lnombre.setForeground(Color.white);
            lnombre.setFont(ral.getLabelFont());
            lnombre.setVisible(true);
            
            JLabel nombre = new JLabel(Usuario.getNombre());
            nombre.setSize(200, 50);
            nombre.setLocation(350, _userP.getHeight()/8);
            nombre.setForeground(Color.white);
            nombre.setFont(ral.getForm());
            nombre.setVisible(true); 
            
            JLabel corr = new JLabel("Correo de la cuenta:");
            corr.setSize(200, 50);
            corr.setSize(300, 50);
            corr.setLocation(200, _userP.getHeight()/6 + 20);
            corr.setForeground(Color.white);
            corr.setFont(ral.getLabelFont());
            corr.setVisible(true);     
            
            JLabel corri = new JLabel(Usuario.getMail());
            corri.setSize(200, 50);
            
            corri.setLocation(520, _userP.getHeight()/6 + 20);
            corri.setForeground(Color.white);
            corri.setFont(ral.getForm());
            corri.setVisible(true);   
            
            JLabel date = new JLabel("Fecha de registro:");
            date.setSize(200, 50);
            date.setSize(300, 50);
            date.setLocation(200, _userP.getHeight()/6 + 80);
            date.setForeground(Color.white);
            date.setFont(ral.getLabelFont());
            date.setVisible(true);              
            
            JLabel idate = new JLabel(Usuario.getDate());
            
            idate.setSize(300, 50);
            idate.setLocation(500, _userP.getHeight()/6 + 80);
            idate.setForeground(Color.white);
            idate.setFont(ral.getForm());
            idate.setVisible(true);  
            
            JLabel tel = new JLabel("Telefono:");
            tel.setSize(200, 50);
            tel.setSize(300, 50);
            tel.setLocation(200, _userP.getHeight()/6 + 140);
            tel.setForeground(Color.white);
            tel.setFont(ral.getLabelFont());
            tel.setVisible(true);     
            
            JLabel itel = new JLabel(Integer.toString(Usuario.getTel()));
            itel.setSize(300, 50);
            itel.setLocation(400, _userP.getHeight()/6 + 140);
            itel.setForeground(Color.white);
            itel.setFont(ral.getForm());
            itel.setVisible(true);              
            
            _userP.add(lnombre);
            _userP.add(nombre);
            _userP.add(corr);
            _userP.add(corri);
            _userP.add(date);
            _userP.add(idate);
            _userP.add(tel);
            _userP.add(itel);
            
        }
        
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Mi perfil")){
            System.out.println("GGmi");
        }
    }

    @Override
    public void resizeMin() {
        
    }

    @Override
    public void resizeMax() {
        
    }
    public class Mumain extends JPanel{
        
    private MainUserMenu mainContainer;
    
    public Mumain(MainUserMenu mainContainer)
    {
        this.mainContainer = mainContainer;
        setLayout(null);
        this.setBorder(new BorderRadius(Color.black, 1, 0, 0));
        setBounds(mainContainer.getSidebar().getWidth(), 0, View.VWIDTH - mainContainer.getSidebar().getWidth(), View.VHEIGHT);
        this.setBackground(new Color(0,0,0,130));
        setVisible(true);
    }
    /*public void paint(Graphics g)
    {
        Dimension dim = this.getSize();
        
        ImageIcon imgb = new ImageIcon(getClass().getResource("/res/menback.jpg"));
        
        g.drawImage(imgb.getImage(), 0, 0, dim.width, dim.height, null);
        setOpaque(false);
        
        super.paint(g);
                    
    }*/
}
    
}
