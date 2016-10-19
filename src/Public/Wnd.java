/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Public;

import Core.Controller;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import AppSource.Controllers.*;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 
 *
 * @author root
 */
public class Wnd extends JFrame {
    
    private static final int  WHEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private static final int  WWIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private DragPanel WndDragger;
    
    public Wnd()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setResizable(true);
        WndDragger = new DragPanel(this);
        this.add(WndDragger);
    }

    private class DragPanel extends JPanel{
    
        private Point initialclick;  
        final JFrame hInstance;
        private JButton wndClose;
        
        public DragPanel(final JFrame hInstance)
        {
            this.hInstance = hInstance;
            
            this.addMouseListener(new MouseAdapter(){
                
                public void mousePressed(MouseEvent e)
                {
                    
                    initialclick = e.getPoint();
                    getComponentAt(initialclick);
                }
            });
            addMouseMotionListener(new MouseMotionAdapter(){
                @Override
            public void mouseDragged(MouseEvent e) {

               
                int thisX = hInstance.getLocation().x;
                int thisY = hInstance.getLocation().y;

        
                int xMoved = (thisX + e.getX()) - (thisX + initialclick.x);
                int yMoved = (thisY + e.getY()) - (thisY + initialclick.y);

               
                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                hInstance.setLocation(X, Y);
                
                
            }
            });
            this.setBounds(0, 0, this.getWidth(), 100);
            this.setLayout(null);
            this.setBackground(Color.red);
            this.setVisible(true);
            wndClose = getDCO();
            this.add(wndClose);
        }
        
        private JButton getDCO()
        {
            JButton hclose = new JButton("X");
            hclose.setSize(50, 50);
            hclose.setLayout(null);
            hclose.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    hInstance.dispose();
                }
                
            });
            hclose.setVisible(true);
    
            return hclose;
        }
       
    }
    public void addWndFrame(JPanel hextFrame)
    {
        WndDragger.add(hextFrame);
        WndDragger.revalidate();
        WndDragger.repaint();
    }
    private JPanel DraggerInstance()
    {
        DragPanel dragPan = new DragPanel(this);
        dragPan.setBounds(0, 0, this.getWidth(), 50);
        dragPan.setBackground(Color.white);
        dragPan.setLayout(null);
        
        
        dragPan.setVisible(true);
        
        return dragPan;
    }
    public void addController(String Controller) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        /*try {
            Class  cls = Class.forName(Controller);
            Object cInstance = cls.newInstance();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Wnd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Wnd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Wnd.class.getName()).log(Level.SEVERE, null, ex);
        }
        Class myClass = Class.forName(Controller);

        Class[] types = {Double.TYPE, this.getClass()};
        Constructor constructor = myClass.getConstructor(types);

        Object[] parameters = {new Double(0), this};
        Object instanceOfMyClass = constructor.newInstance();*/
        //File root = new File(".");
        //URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { root.toURI().toURL() });
        //Class<?> cls = Class.forName(Controller, false, classLoader);
        Constructor c = Class.forName(Controller).getConstructor(Wnd.class);
        Object cls = (Object) c.newInstance(this);
    }
    public static Dimension getWndSize()
    {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }
}
