/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
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
        // for correct result wee need to do all in the swing thread
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                final Public.Wnd f = new Public.Wnd();
                System.out.println(System.currentTimeMillis() - now);
                f.setBounds(0, 0, 800, 600);
                f.setVisible(true);
            }
        });
        System.out.println(System.currentTimeMillis() - now);        
    }
    
    
}
