/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppSource.Controllers;

import Core.Controller;
import Public.Wnd;
import chat.*;
import javax.xml.bind.JAXBElement;

/**
 *
 * @author alb
 */
public class MainUserMenu extends Controller{
    private AppSource.Views.MainUserMenu sl;
    public MainUserMenu(Wnd hInstance) {
        super(hInstance);
        sl = new AppSource.Views.MainUserMenu(hInstance, this);
        super.getView().Render(sl);
    }
    public void SendChat(String msg)
    {
        chat.Input in = new chat.Input();
        ObjectFactory factory = new ObjectFactory();
        JAXBElement<String> createInputMsg = factory.createInputMsg(msg);   
        in.setMsg(createInputMsg);
        in.setId(234);
        System.out.println(getInfo(in));
    }

    private String getInfo(chat.Input msg) {
        chat.Chat service = new chat.Chat();
        chat.ChatPortType port = service.getChat();
        return port.getInfo(msg);
    }
    
}
