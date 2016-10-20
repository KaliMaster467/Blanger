/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Public.Styles;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import javax.swing.JButton;

/**
 *
 * @author root
 */
public class NOpButtons extends JButton{
    
    private Polygon shape;
    
    public NOpButtons()
    {
        setContentAreaFilled(false);
        initialize();
        
    }
    protected void initialize()
    {
        shape = new Polygon();
        setSize(50, 50);
        shape.addPoint(0, 0);
        shape.addPoint( 0 , 25);
        shape.addPoint( 50 ,100  );
    }
    protected void paintBorder(Graphics g)
    {
        
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.fillPolygon(shape);
    }
    public Dimension getPreferredSize()
    {
        return new Dimension(50, 50);
    }
    public boolean contains(int x, int y)
    {
        return shape.contains(x, y);
    }
   
}
