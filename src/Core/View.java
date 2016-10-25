/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import Public.Wnd;
import java.awt.Toolkit;

import javax.swing.JPanel;

/**
 *
 * @author root
 */
public class View extends JPanel{
    public static final int VHEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 60;
    public static final int VWIDTH = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private Wnd hInstance;
    
    public View(Wnd hInstance)
    {
        this.hInstance = hInstance;
    }
    public View()
    {
        
    }
    public void Render(JPanel Frame){
        hInstance.addWndFrame(Frame);
    }
    public Wnd getHins(){
        return hInstance;
    }
}
