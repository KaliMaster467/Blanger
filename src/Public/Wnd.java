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
import java.awt.Font;
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
public class Wnd extends JFrame{
    
    private static final int  WHEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private static final int  WWIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private DragPanel WndDragger;
    
    public Wnd()
    {
     
        this.setUndecorated(true);
        this.setResizable(true);
        WndDragger = new DragPanel(this);
        this.add(WndDragger);
    }



    private class DragPanel extends JPanel implements Runnable{
    
        private Point initialclick;  
        final JFrame hInstance;
        private JButton wndClose;
        private JButton wndMax;
        private JButton wndMin;
        
        public DragPanel(final JFrame hInstance)
        {
            this.hInstance = hInstance;
            Thread mouse = new Thread(this);
            mouse.run();
            this.setBounds(0, 0, this.getWidth(), 100);
            this.setLayout(null);
            this.setBackground(Color.black);
            this.setVisible(true);
            wndClose = getDCO();
            wndMax = getMAX();
            wndMin = getMIN();
            this.add(wndClose);  
            this.add(wndMax);
            this.add(wndMin);
            
        }
    @Override
    public void run() {
            
            
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
                int X = thisX + xMoved;
                hInstance.setLocation(X, hInstance.getLocation().y);
                int yMoved = (thisY + e.getY()) - (thisY + initialclick.y);
                int Y = thisY + yMoved;
                hInstance.setLocation(hInstance.getLocation().x, Y);

            }
            });
 
    }        
        private JButton getDCO()
        {
            JButton hclose = new JButton("X");
            hclose.setSize(30, 30);
            hclose.setLayout(null);
            hclose.addActionListener(new ActionListener(){ 
                @Override
                public void actionPerformed(ActionEvent e) {
                    hInstance.dispose();
                    System.exit(0);
                }
                
            });
            hclose.setOpaque(true);
            hclose.setBackground(Color.black);
            hclose.setForeground(Color.red);
            Font fuente = new Font("Verdana", Font.BOLD, 10);
            hclose.setFont(fuente);
            hclose.setBorder(null);
            hclose.setFocusPainted(false);
            hclose.setFocusable(false);
            hclose.setBorderPainted(false);
            hclose.setVisible(true);
    
            return hclose;
        }
        private JButton getMAX()
        {
            JButton hmax = new JButton("o");
            hmax.setBounds(hInstance.getLocation().x + 30, 0, 30, 30);
            hmax.setLayout(null);
            hmax.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    hInstance.setExtendedState(hInstance.getExtendedState() | JFrame.MAXIMIZED_BOTH);
                }
              
            });
            hmax.setOpaque(true);
            hmax.setBackground(Color.black);
            hmax.setForeground(Color.green);
            Font fuente = new Font("Verdana", Font.BOLD, 12);
            hmax.setFont(fuente);
            hmax.setBorder(null);
            hmax.setFocusPainted(false);
            hmax.setBorderPainted(false);
            hmax.setFocusable(false);
            hmax.setVisible(true);  
            
            return hmax;
        }
        public JButton getMIN()
        {
            JButton hmin = new JButton("-");
            hmin.setBounds(hInstance.getLocation().x + 60, 0, 30, 30);
            hmin.setLayout(null);
            hmin.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    hInstance.setExtendedState(JFrame.NORMAL);
                    hInstance.setBounds(200, 200, Wnd.WWIDTH - 200, Wnd.WHEIGHT - 200);
                }
              
            });
            hmin.setOpaque(true);
            hmin.setBackground(Color.black);
            hmin.setForeground(Color.orange);
            Font fuente = new Font("Verdana", Font.BOLD, 12);
            hmin.setFont(fuente);
            hmin.setBorder(null);
            hmin.setFocusPainted(false);
            hmin.setBorderPainted(false);
            hmin.setFocusable(false);
            hmin.setVisible(true);  
            
            return hmin;            
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
