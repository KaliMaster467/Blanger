/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import AppSource.Controllers.*;
import Public.Wnd;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author alb
 */
public class App {
    
    public App()
    {
        System.out.println("Hola app");
        try {
            DefaultIni();
        } catch (InterruptedException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void DefaultIni() throws InterruptedException, InvocationTargetException
    {
        final long now = System.currentTimeMillis();
        
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                final Public.Wnd f = new Public.Wnd();
                System.out.println(System.currentTimeMillis() - now);
                f.setBounds(20 , 0, (int)Wnd.getWndSize().getWidth() - 200
                        , (int)Wnd.getWndSize().getHeight() - 150);
                
                f.setVisible(true);
                
                
                try {
                    //Prueba
                    f.addController("AppSource.Controllers.StartLauncher");
                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(null, "No existe");
                    try{
                        f.addController("AppSource.Controllers.StartLauncher");
                    }catch(Exception e) {
                        e.printStackTrace();
                    }  
                }   
               
            }
        });
        System.out.println(System.currentTimeMillis() - now);        
    }
    
    
}
