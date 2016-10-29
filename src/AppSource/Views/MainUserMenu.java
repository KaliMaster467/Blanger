/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppSource.Views;

import Core.View;
import Public.Wnd;

/**
 *
 * @author alb
 */
public class MainUserMenu extends View implements Runnable{
    
    private final Wnd hInstance;
    public MainUserMenu(Wnd hInstance)
    {
        this.hInstance = hInstance;
        setLayout(null);
        setBounds(0, 60, View.VWIDTH, View.VHEIGHT);
        this.setBackground(java.awt.Color.black);
    }
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
