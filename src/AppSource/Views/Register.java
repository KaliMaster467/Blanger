/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppSource.Views;

import Core.View;
import Public.Styles.Fonts.Lato;
import Public.Styles.Fonts.Raleway;
import Public.Wnd;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

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
        this.setLayout(null);
        this.setBounds(0, 60, View.VWIDTH, View.VHEIGHT);
        this.setBackground(Color.white);
        
        mainPanel = new MainPanel();
        
        add(mainPanel);
        //add(mainScroll(mainPanel));
        this.setVisible(true);
    }    
 
    private JScrollPane mainScroll(MainPanel mainPanel){
        
        JScrollPane pane = new JScrollPane(mainPanel);
        
        return pane;
    }
    
    private class MainPanel extends JPanel implements Runnable{
        
        private JLabel _title;
        
        public MainPanel()
        {
            this.setBounds(0, 50, View.VWIDTH, View.VHEIGHT);
            this.setBackground(Color.white);  
            
            Lato ral = new Lato();
            
            _title = new JLabel("Registrate a la Comunidad");
            _title.setBounds(hInstance.getWidth()/16 * 4, hInstance.getHeight()/10, hInstance.getWidth() / 2, 60 );
            _title.setForeground(Color.black);
            _title.setFont(ral.getTit());
            
            add(_title);
            this.setVisible(true);
            
            Thread siz = new Thread(this);
            siz.start();
            
        }

        @Override
        public void run() {
          _title.setBounds(hInstance.getWidth()/16 * 4, hInstance.getHeight()/10, hInstance.getWidth() / 2, 60 );  
        }
        
    }
}
