/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppSource.Views;

import Core.View;
import Public.ErrWnd;
import Public.Styles.BorderRadius;
import Public.Styles.Fonts.Lato;
import Public.Styles.Fonts.Raleway;
import Public.Wnd;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author root
 */
public class Register extends View{
    private final AppSource.Controllers.Register cont;
    private final Wnd hInstance;
    private MainPanel mainPanel;
    public Register(Wnd hInstance, AppSource.Controllers.Register cont){
        this.hInstance = hInstance;
        this.cont = cont;
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setLayout(new BorderLayout());
        this.setBounds(0, 60, View.VWIDTH, View.VHEIGHT);
        this.setBackground(Color.white);
        
        mainPanel = new MainPanel(this, hInstance, cont);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClass‌​Name());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }        
        JScrollPane scroll = new JScrollPane(mainPanel);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.setBorder(new BorderRadius(Color.black, 1, 0, 0));
        //scroll.setBorder(new BorderRadius(Color.BLACK, 1, 0, 0));
        add(scroll);
        //add(mainPanel, BorderLayout.PAGE_START);
        //add(mainScroll(mainPanel));
        //JScrollPane pane = new JScrollPane(mainPanel);
        //pane.setPreferredSize(new Dimension(400, 200));
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }       
        this.setVisible(true);
        
    }    
    private class MainPanel extends JPanel implements Runnable, ActionListener{
        
        private JLabel _title;
        private JLabel _Nombre;
        private JLabel _fname;
        private JLabel _sname;
        private JLabel _tel;
        private JLabel _correo;
        private JLabel _pass;
        private JLabel _passc;
        private JTextField _inombre;
        private JTextField _ifname;
        private JTextField _isname;
        private JTextField _itel;
        private JTextField _icorreo;
        private JPasswordField _ipass;
        private JPasswordField _ipassc;
        private Wnd hInstance;
        private JScrollPane _scroll;
        private AppSource.Controllers.Register cont;
        private JPanel mainContainer;
        private JButton but;
        
        public MainPanel(JPanel mainContainer, Wnd hInstance, AppSource.Controllers.Register cont)
        {
            this.hInstance = hInstance;
            this.cont = cont;
            this.mainContainer = mainContainer;
            this.setLayout(new BorderLayout());
            this.setPreferredSize(new Dimension(mainContainer.getWidth(), 1400));
            //this.setBackground(Color.red);
            
            /*Lato ral = new Lato();
            Raleway ra = new Raleway();
            _title = new JLabel("Registrate", SwingConstants.CENTER);
            
            _title.setForeground(Color.black);
            _title.setFont(ral.getTit());   
            add(_title, BorderLayout.PAGE_START);
            
            _Nombre = new JLabel("Nombre:");
            
            _Nombre.setForeground(Color.black);
            _Nombre.setFont(ral.getMainWnd());
            add(_Nombre, BorderLayout.PAGE_START);*/
            init();
            
            
            
        }
        private void init(){
            this.setBounds(0, 0, View.VWIDTH, 1400);
            
            this.setBackground(Color.white);  
            this.setLayout(new BorderLayout(0, 0));
            setLayout(new BorderLayout());
            
            
            Lato ral = new Lato();
            Raleway ra = new Raleway();
            _title = new JLabel("Registrate");
            
            _title.setForeground(Color.black);
            _title.setFont(ral.getTit());
           
            
            _Nombre = new JLabel("Nombre:");
            
            _Nombre.setForeground(Color.black);
            _Nombre.setFont(ral.getMainWnd());
          
            
            _inombre = new JTextField();
            _inombre.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
            _inombre.setVisible(true);
            _inombre.setFont(ra.getForm());
            
            _fname = new JLabel("Primer apellido:");
            _fname.setForeground(Color.black);
            _fname.setFont(ral.getMainWnd());
            
            _ifname = new JTextField();
            _ifname.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
            _ifname.setVisible(true);
            _ifname.setFont(ra.getForm());
            
            _sname = new JLabel("Segundo apellido:");
            _sname.setForeground(Color.black);
            _sname.setFont(ral.getMainWnd());
            
            _isname = new JTextField();
             _isname.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
            _isname.setVisible(true);
            _isname.setFont(ra.getForm());
            
            _tel = new JLabel("Teléfono:");
            _tel.setForeground(Color.black);
            _tel.setFont(ral.getMainWnd());
            
            _itel = new JTextField();
            _itel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
            _itel.setVisible(true);
            _itel.setFont(ra.getForm());
            
            _correo = new JLabel("Correo:");
            _correo.setForeground(Color.black);
            _correo.setFont(ral.getMainWnd());
            
            _icorreo = new JTextField();
            _icorreo.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
            _icorreo.setVisible(true);
            _icorreo.setFont(ra.getForm());
            
            _pass = new JLabel("Contraseña:");
            _pass.setForeground(Color.black);
            _pass.setFont(ral.getMainWnd());
            
            _ipass = new JPasswordField();
            _ipass.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
            _ipass.setVisible(true);
            _ipass.setFont(ra.getForm());
            
            _passc = new JLabel("Confirmar Contraseña:");
            _passc.setForeground(Color.black);
            _passc.setFont(ral.getMainWnd());
            
            
            _ipassc = new JPasswordField();
            _ipassc.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.black));
            _ipassc.setVisible(true);
            _ipassc.setFont(ra.getForm());
            
            
            but = new JButton("Registrate");
            but.addActionListener(this);
            but.setOpaque(true);
            but.setBackground(Color.black);
            but.setForeground(Color.white);
            but.setFont(ra.getForm());
           
            add(but);
            add(_itel);
            add(_tel);
            add(_isname);
            add(_sname);
            add(_ifname);
            add(_fname);
            add(_inombre);
            add(_title);
            add(_Nombre);
            add(_correo);
            add(_icorreo);
            add(_pass);
            add(_passc);
            add(_ipass);
            add(_ipassc);
            
            this.setVisible(true);
            
            Thread t = new Thread(this);
            t.start();
        }

        @Override
        public void run() {
            while(true){
                _title.setBounds(hInstance.getWidth()/5 *  2 + 20, this.getHeight()/15 , hInstance.getWidth(), 95);
                _Nombre.setBounds(hInstance.getWidth()/5 * 2 -10, _title.getLocation().y + 120, hInstance.getWidth() / 5 , 40);
                _inombre.setBounds(hInstance.getWidth()/5 * 2 -10, _Nombre.getLocation().y + 50, hInstance.getWidth() / 4 - 50 , 40);
                _fname.setBounds(hInstance.getWidth()/5 * 2 -10, _Nombre.getLocation().y + 150, hInstance.getWidth() / 5 , 40);
                _ifname.setBounds(hInstance.getWidth()/5 * 2 -10, _Nombre.getLocation().y + 200, hInstance.getWidth() / 4 - 50 , 40);
                _sname.setBounds(hInstance.getWidth()/5 * 2 -10, _fname.getLocation().y + 150, hInstance.getWidth() / 5 , 40);
                _isname.setBounds(hInstance.getWidth()/5 * 2 -10, _fname.getLocation().y + 200, hInstance.getWidth() / 4 - 50 , 40);
                _tel.setBounds(hInstance.getWidth()/5 * 2 -10, _sname.getLocation().y + 150, hInstance.getWidth() / 5 , 40);
                _itel.setBounds(hInstance.getWidth()/5 * 2 -10, _sname.getLocation().y + 200, hInstance.getWidth() / 4 - 50 , 40);
                _correo.setBounds(hInstance.getWidth()/5 * 2 -10, _tel.getLocation().y + 120, hInstance.getWidth() / 5 , 40);
                _icorreo.setBounds(hInstance.getWidth()/5 * 2 -10, _correo.getLocation().y + 70, hInstance.getWidth() / 4 - 50 , 40);
                _passc.setBounds(hInstance.getWidth()/5 * 2 - 10, _correo.getLocation().y + 250, hInstance.getWidth() / 5 , 40);
                _ipassc.setBounds(hInstance.getWidth()/5 * 2 -10, _correo.getLocation().y + 300, hInstance.getWidth() / 4 - 50 , 40);
                _pass.setBounds(hInstance.getWidth()/5 * 2 -10, _correo.getLocation().y + 150, hInstance.getWidth() / 5 , 40);
                _ipass.setBounds(hInstance.getWidth()/5 * 2 -10, _correo.getLocation().y + 200, hInstance.getWidth() / 4 - 50 , 40);
                but.setBounds(hInstance.getWidth()/5 * 2 -10, _ipass.getLocation().y + 200, hInstance.getWidth() / 4 - 50, 40);
            }
            
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Registrate")){
                if(_inombre.equals("")|| _ifname.equals("") || _isname.equals("")
                    || _icorreo.equals("") || _ipass.equals("")){
                        ErrWnd err = new ErrWnd("Llene los campos");
                }else
                {if(_ipass.getText().equals(_ipassc.getText())){
                                    
                    if(!_itel.getText().equals("")){
                        try {
                            cont.InsertUser(_inombre.getText(), _ifname.getText(), _isname.getText(), Integer.parseInt(_itel.getText()), _icorreo.getText(), _ipass.getText());
                            //cont.RetreiveUser("Albert", "");
                        } catch (NoSuchAlgorithmException ex) {
                            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                        }catch (NumberFormatException ex){
                            //JOptionPane.showMessageDialog(null, "Telefono incorrecto");
                            ErrWnd err = new ErrWnd("Telefono incorrecto");
                        }
                    }else if(!(_itel.getText().length() == 10)){
                        //JOptionPane.showMessageDialog(null, "Telefono incorrecto");
                        ErrWnd err = new ErrWnd("Telefono incorrecto");

                    } 
                    //JOptionPane.showMessageDialog(null, "Llene nos campos","Error", 0, null);
                }else
                {
                    ErrWnd errc = new ErrWnd("las contraseñas no coinciden") ;
                }
                }
            }
        }
    }
}
