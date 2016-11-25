/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//StartLauncher Vista
package AppSource.Views;

import Core.Controller;
import Core.View;
import Public.ErrorWnd;
import Public.Styles.BorderRadius;
import Public.Styles.Fonts.Raleway;
import Public.Wnd;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import Public.Styles.RoundedButton;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;


/**
 *
 * @author alb
 */
public class StartLauncher extends View implements Runnable, ActionListener{
    
    private final Wnd hInstance;
    private JLabel usr;
    private JTextField _usrTxt;
    private JLabel _wlcTxt;
    private Raleway fon;
    private JPasswordField _pswTxt;
    private Public.Styles.RoundedButton _logIn;
    private final AppSource.Controllers.StartLauncher cont;
    
    public StartLauncher(Wnd hInstance, AppSource.Controllers.StartLauncher cont)
    {
        this.hInstance = hInstance;
        this.cont = cont;
        setLayout(null);
        setBounds(0, 60, View.VWIDTH, View.VHEIGHT);
        
        this.setBackground(java.awt.Color.black);
        
        //this.add(new StartLauncher_Main_Login_Container(hInstance.getLocation().x
        //,hInstance.getLocation().y));
        ImageIcon imgus = new ImageIcon(getClass().getResource("/res/userx.png"));
        
        Image imag = imgus.getImage();
        
        ImageIcon nic = new ImageIcon(MainUserMenu.getScaledImage(imag, 190, 190));
        
        _wlcTxt = new JLabel("Bienvenido", SwingConstants.CENTER);
        _wlcTxt.setBounds(hInstance.getWidth()/16 * 4, hInstance.getHeight()/10 - 30, hInstance.getWidth() / 2, 60 );
        _wlcTxt.setForeground(Color.white);
        fon = new Raleway();
        _wlcTxt.setFont(fon.getTitleFont());
        _wlcTxt.setBorder(BorderFactory.createCompoundBorder(_wlcTxt.getBorder(), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        _wlcTxt.setHorizontalAlignment(JLabel.CENTER);
        _wlcTxt.setVisible(true);
        this.add(_wlcTxt);
        
        usr = new JLabel(nic, SwingConstants.CENTER);
    
        usr.setBounds((hInstance.getWidth() / 3), _wlcTxt.getHeight() + 130, hInstance.getWidth() / 3, 256 );
        usr.setLayout(null);
        usr.setVisible(true);
        this.add(usr);
     
        
        _usrTxt = new JTextField(SwingConstants.CENTER);
        
        _usrTxt.setLayout(null);
        _usrTxt.setBounds(hInstance.getWidth()/5 * 2, usr.getLocation().y + 260, hInstance.getWidth() / 5 , 40);
        //_usrTxt.setOpaque(false);
        _usrTxt.setBackground(new Color(0, 0, 0, 50));
        _usrTxt.setForeground(Color.white);
        _usrTxt.setFont(fon.getForm());
        _usrTxt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
        _usrTxt.setCaretColor(Color.red);
        _usrTxt.setCaretPosition(SwingConstants.CENTER);
        _usrTxt.setVisible(true);
        
        this.add(_usrTxt);
        
        _pswTxt = new JPasswordField();
        _pswTxt.setBackground(new Color(0, 0, 0, 50));
        _pswTxt.setBounds(hInstance.getWidth()/5 * 2, _usrTxt.getLocation().y + 70, hInstance.getWidth() / 5 , 40);
        _pswTxt.setForeground(Color.white);
        _pswTxt.setFont(fon.getForm());
         _pswTxt.setCaretColor(Color.red);
        _pswTxt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
        _pswTxt.setVisible(true);
        this.add(_pswTxt);
        
        _logIn = new RoundedButton("Iniciar");
        
        _logIn.setBounds(hInstance.getWidth()/5 * 2, _pswTxt.getLocation().y + 100, hInstance.getWidth() / 5, 50);
        _logIn.setForeground(Color.white);
        _logIn.setFont(fon.getBtnFont());
        //_logIn.setOpaque(true);
        _logIn.addActionListener(this);
        _logIn.setBackground(Color.black);
        _logIn.setVisible(true);
        //_logIn.setBorder(new BorderRadius(Color.white, 1, 0, 0));
        //_logIn.setFocusPainted(false);
        //_logIn.setText("Iniciar");
        this.add(_logIn);
        this.add(reg());
        
        this.setVisible(true);
        
        Thread sizes = new Thread(this);
        sizes.start();
    }
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
       
        
        ImageIcon imgb = new ImageIcon(getClass().getResource("/res/back.gif"));
        
        g.drawImage(imgb.getImage(), 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        //super.paint(g);
                    
    }
    
    @Override
    public void run() {
        while(true)
        {
            usr.setBounds((hInstance.getWidth() / 3), _wlcTxt.getHeight() + 130, hInstance.getWidth() / 3, 256 );
            _usrTxt.setBounds(hInstance.getWidth()/5 * 2, usr.getLocation().y + 260, hInstance.getWidth() / 5, 40);
            _pswTxt.setBounds(hInstance.getWidth()/5 * 2, _usrTxt.getLocation().y + 70, hInstance.getWidth() / 5, 40);
            _wlcTxt.setBounds(hInstance.getWidth()/16 * 4, hInstance.getHeight()/8 - 30, hInstance.getWidth() / 2, 60 );     
            _logIn.setBounds(hInstance.getWidth()/5 * 2, _pswTxt.getLocation().y + 100, hInstance.getWidth() / 5, 50);
        }
    }
        private static Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
    private JPanel reg()
    {
        
        JPanel panel = new JPanel();
        panel.setBounds(0, hInstance.getHeight() - View.VHEIGHT, 300, 100);
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.setOpaque(true);
        panel.setBackground(new Color(255, 255, 255, 50));
        
        
        JButton register = new JButton("Registrate");
        register.addActionListener(this);
        panel.add(register);
        panel.setVisible(true);
        
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Registrate")){
            try {
                cont.test();
                hInstance.addController("AppSource.Controllers.Register");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StartLauncher.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(StartLauncher.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(StartLauncher.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(StartLauncher.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(StartLauncher.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(StartLauncher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getActionCommand().equals("Iniciar")){
            //ErrorWnd err = new ErrorWnd(hInstance, "gg");
            cont.RetreiveUser(_usrTxt.getText(), _pswTxt.getText()
            );
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
