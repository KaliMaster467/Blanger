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
    private Shape triangulo = createTriangulo();
    
    public void paintBorder(Graphics g)
    {
        ((Graphics2D)g).draw(triangulo);
    }
    public void paintComponent(Graphics g)
    {
        ((Graphics2D)g).fill(triangulo);
    }
    public Dimension getPreferredSize()
    {
        return new Dimension(50, 50);
    }
    public boolean contains(int x, int y)
    {
        return triangulo.contains(x, y);
    }
    private Shape createTriangulo()
    {
        Polygon p = new Polygon();
        p.addPoint(0, 100);
        p.addPoint( 100 , 0   );
        p.addPoint( 200 ,100  );
        return p;
    }
}
