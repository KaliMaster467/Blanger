/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import Public.Wnd;
import javax.swing.JFrame;

/**
 *
 * @author root
 */
public class Controller {
    private View vista;
    public Controller(Wnd hInstance)
    {
        vista = new View(hInstance);
    }

 
    protected View getView()
    {
        return vista;
    }
    
}
