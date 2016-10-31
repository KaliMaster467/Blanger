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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Public.Styles.Fonts.Raleway;
import java.awt.Font;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 * 
 *
 * @author root
 */
public class Wnd extends JFrame{
    
    private static final int  WHEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private static final int  WWIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private DragPanel WndDragger;
    public String control;
    
    public Wnd()
    {
     
        this.setUndecorated(true);
        this.setResizable(true);
        WndDragger = new DragPanel(this);
        this.add(WndDragger);
        
    }
    private class DragPanel extends JPanel implements Runnable, ActionListener{
    
        private Point initialclick; 
        public String control = "StartLauncher";
        final Wnd hInstance;
        private JButton wndClose;
        private JButton wndMax;
        private JButton wndMin;
        private JButton wndIni;
        private JButton wndHerr;
        private JButton wndSop;
        private Raleway fon;
        
        public DragPanel(Wnd hInstance)
        {
            fon = new Raleway();
            this.hInstance = hInstance;
            Thread mouse = new Thread(this);
            mouse.run();
            this.setBounds(0, 0, this.getWidth(), 100);
            this.setLayout(null);
            this.setBackground(Color.black);
            
            wndClose = getDCO();
            wndMax = getMAX();
            wndMin = getMIN();
            wndIni = getIni();
            wndHerr = getHerr();
            wndSop = getSop();
            addComp();
            
        }
        public void addComp(){
                        this.add(wndClose);  
            this.add(wndMax);
            this.add(wndMin);
            this.add(wndIni);
            this.add(wndHerr);
            this.add(wndSop);
            this.setVisible(true);
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
                    hInstance.setBounds(200, 200, Wnd.WWIDTH - 200, (int)Wnd.getWndSize().getHeight() - 100);
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
        public JButton getIni()
        {
            JButton ini = new JButton();
            ini.setOpaque(true);
            ini.setBackground(Color.black);
            ini.setBounds(0, wndClose.getLocation().y + wndClose.getHeight(), 60, 30);
            ini.setText("Inicio");
            ini.setForeground(Color.WHITE);
            ini.setFont(fon.getMinFont());
            ini.setBorder(null);
            ini.setFocusPainted(false);
            ini.addActionListener(this);
            ini.setVisible(true);
            
            
            return ini;
        }
        public JButton getHerr()
        {
            JButton Herr = new JButton();
            Herr.setOpaque(true);
            Herr.setBackground(Color.black);
            Herr.setBounds(wndIni.getWidth(), wndClose.getLocation().y + wndClose.getHeight(), 110, 30);
            Herr.setText("Configuracion");
            Herr.setForeground(Color.WHITE);
            Herr.setFont(fon.getMinFont());
            Herr.setBorder(null);
            Herr.setFocusPainted(false);
            Herr.setVisible(true);
            
            return Herr;
        }
        public JButton getSop()
        {
            JButton Sop = new JButton();
            Sop.setOpaque(true);
            Sop.setBackground(Color.black);
            Sop.setBounds(wndIni.getWidth() + 110, wndClose.getLocation().y + wndClose.getHeight(), 70, 30);
            Sop.setText("Soporte");
            Sop.setForeground(Color.WHITE);
            Sop.setFont(fon.getMinFont());
            Sop.setBorder(null);
            Sop.setFocusPainted(false);
            Sop.setVisible(true);
            
            return Sop;
        }        

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Inicio"))
            {
                JOptionPane.showMessageDialog(null, "Inicio");
                
                try {
                    hInstance.addController("AppSource.Controllers.MainUserMenu");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Wnd.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(Wnd.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Wnd.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Wnd.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(Wnd.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(Wnd.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }
    public void addWndFrame(JPanel hextFrame)
    {
        
        WndDragger.removeAll();
        
        WndDragger.add(hextFrame);
        WndDragger.addComp();
        
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
        Constructor c = Class.forName(Controller).getConstructor(Wnd.class);
        Object cls = (Object) c.newInstance(this);
    }
    public static Dimension getWndSize()
    {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }
}
