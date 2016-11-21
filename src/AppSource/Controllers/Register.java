/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppSource.Controllers;

import Core.Controller;
import Core.ObjectFactory;
import Public.Wnd;
import javax.xml.bind.JAXBElement;

/**
 *
 * @author root
 */
public class Register extends Controller{
    private AppSource.Views.Register sl;
    public Register(Wnd hInstance) {
        super(hInstance);
        sl = new AppSource.Views.Register(hInstance, this);
        super.getView().Render(sl);
        
        
    }
        
    public void InsertUser(){
        Services.Input in = new Services.Input();
        ObjectFactory factory = new ObjectFactory();
        JAXBElement<String> createInputEmail = factory.createInputEmail("description");
        
       
        in.setTelephone(55745);
        in.setDelegation(createInputEmail);
        in.setDirection(createInputEmail);
        in.setFLastName(createInputEmail);
        in.setEmail(createInputEmail);
        in.setSLastName(createInputEmail);
        in.setPassw(createInputEmail);
       
       
        if(Register.getInfo(in).equals("OK")){
            System.out.println("OK");
        }else{
            System.out.println("nel");
        }
    }
    
    private static String getInfo(Services.Input insert) {
        Services.CrearAlumno service = new Services.CrearAlumno();
        Services.CrearAlumnoPortType port = service.getCrearAlumno();
        return port.getInfo(insert);
    }
   
    
}
