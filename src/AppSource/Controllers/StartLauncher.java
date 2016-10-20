/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//StarLauncher Controlador
package AppSource.Controllers;
import Core.Controller;
import Public.Wnd;


/**
 *
 * @author root
 */
public class StartLauncher extends Controller{
    private AppSource.Views.StartLauncher sl; 
    public StartLauncher(Wnd hInstance)
    {
        
        super(hInstance);
        sl = new AppSource.Views.StartLauncher(hInstance);
        super.getView().Render(sl);
        
    }
}
