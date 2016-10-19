/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

/**
 *
 * @author root
 */
public class Controller {
    private View vista;
    public Controller()
    {
        vista = new View();
    }
    protected View getView()
    {
        return vista;
    }
    
}
