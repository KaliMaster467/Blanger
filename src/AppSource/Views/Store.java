/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppSource.Views;

import Core.View;
import Core.auxil.Usuario;
import Public.Styles.BorderRadius;
import Public.Styles.Fonts.Lato;
import Public.Wnd;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author root
 */
public class Store extends View{
    private Wnd hInstance;
    private AppSource.Controllers.Store cont;
    private TopUI _topUI;
    public Store(Wnd hInstanc2, AppSource.Controllers.Store cont){
      
            init();    
        
    }
    public void init(){
        this.hInstance = hInstance;
        this.cont = cont;
        setLayout(new BorderLayout());
        setBounds(0, 60, View.VWIDTH, View.VHEIGHT);    
        this.setBackground(Color.white);
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
        
        /*if(Usuario.getNombre() == null){
            
            JPanel block = new JPanel();
            block.setLayout(new BorderLayout());
            block.setPreferredSize(new Dimension(this.getWidth(), this.getHeight() + 100));
            block.setBackground(Color.white);

            add(block, BorderLayout.CENTER);   

            _topUI = new TopUI();
            //start.setBackground(Color.red);
            _topUI.setPreferredSize(new Dimension(this.getWidth(), 350));

            add(_topUI, BorderLayout.PAGE_START);    
            this.setComponentZOrder(block, 1);
            this.setComponentZOrder(_topUI, 0);
            
            
  
        }*/
        MainStoreGUI gui = new MainStoreGUI();
        JScrollPane scroll = new JScrollPane(gui);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.setBorder(new BorderRadius(Color.BLACK, 1, 0, 0));
        add(scroll);
        
    }
    private class MainStoreGUI extends JPanel{
        public MainStoreGUI(){
        setLayout(new BorderLayout());
        setBounds(0, 60, View.VWIDTH, View.VHEIGHT + 200);    
        this.setBackground(Color.white);
            JPanel block = new JPanel();
            block.setLayout(new BorderLayout());
            block.setPreferredSize(new Dimension(this.getWidth(), this.getHeight() + 100));
            block.setBackground(Color.white);

            add(block, BorderLayout.CENTER);   

            _topUI = new TopUI();
            //start.setBackground(Color.red);
            _topUI.setPreferredSize(new Dimension(this.getWidth(), 350));

            add(_topUI, BorderLayout.PAGE_START);    
            this.setComponentZOrder(block, 1);
            this.setComponentZOrder(_topUI, 0);        
        }

    }
    private class TopUI extends JPanel{
        
        public TopUI(){
            
            Lato lat = new Lato();
            
            setLayout(new BorderLayout());
            
            JLabel title = new JLabel("BlackOS", SwingConstants.CENTER);
            title.setPreferredSize(new Dimension(100, 30));
            title.setForeground(Color.white);
            title.setFont(lat.getTit());
            add(title, BorderLayout.CENTER);
        }
        
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);


            ImageIcon imgb = new ImageIcon(getClass().getResource("/res/city.jpg"));

            g.drawImage(imgb.getImage(), 0, 0, getWidth(), getHeight(), this);
            this.setOpaque(true);
            //super.paint(g);

        }
        
    }
    
}
