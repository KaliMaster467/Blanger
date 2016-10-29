/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppSource.Controllers;

import Core.Controller;
import Public.Wnd;

/**
 *
 * @author alb
 */
public class MainUserMenu extends Controller{
    private AppSource.Views.MainUserMenu sl;
    public MainUserMenu(Wnd hInstance) {
        super(hInstance);
        sl = new AppSource.Views.MainUserMenu(hInstance);
        super.getView().Render(sl);
    }
    
}
