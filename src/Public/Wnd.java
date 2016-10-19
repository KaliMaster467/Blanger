/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Public;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author root
 */
public class Wnd extends JFrame{
    public Wnd()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        
        this.add(DraggerInstance());
    }
    private class DragPanel extends JPanel{
    
        private Point initialclick;  
        final JFrame hInstance;
        
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

                // get location of Window
                int thisX = hInstance.getLocation().x;
                int thisY = hInstance.getLocation().y;

                // Determine how much the mouse moved since the initial click
                int xMoved = (thisX + e.getX()) - (thisX + initialclick.x);
                int yMoved = (thisY + e.getY()) - (thisY + initialclick.y);

                // Move window to this position
                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                hInstance.setLocation(X, Y);
            }
            });
            this.add(getDCO());
        }
        
        public JButton getDCO()
        {
            JButton hclose = new JButton("Cerrar");
            hclose.setSize(100, 20);
            hclose.setLayout(null);
            hclose.setVisible(true);
            return hclose;
        }
    }
    public JPanel DraggerInstance()
    {
        DragPanel dragPan = new DragPanel(this);
        dragPan.setVisible(true);
        dragPan.setBackground(Color.red);
        dragPan.setLayout(null);
        
        dragPan.setSize(this.getHeight(), 50);
        dragPan.setVisible(true);
        
        return dragPan;
    }
}
