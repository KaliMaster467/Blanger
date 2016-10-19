/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//StartLauncher Vista
package AppSource.Views;

import Core.Controller;
import Core.View;
import javafx.scene.paint.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author alb
 */
public class StartLauncher extends JPanel{
    
    public StartLauncher()
    {
        setLayout(null);
        setBounds(0, 100, View.VWIDTH, View.VHEIGHT);
        
        this.setBackground(java.awt.Color.black);
        this.setVisible(true);
    }
    
}
