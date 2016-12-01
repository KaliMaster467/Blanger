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
 * @author root
 */
public class Store extends Controller{
    private AppSource.Views.Store sl;
    public Store(Wnd hInstance) {
        super(hInstance);
        sl = new AppSource.Views.Store(hInstance, this);
        super.getView().Render(sl);
    }
    
}
