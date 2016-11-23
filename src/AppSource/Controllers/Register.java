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
        
    public void InsertUser(String nombre, String fnombre, String snombre, int tel){
        Services.Input in = new Services.Input();
        ObjectFactory factory = new ObjectFactory();
        JAXBElement<String> createInputEmail = factory.createInputEmail("description");
        JAXBElement<String> createInputDirection = factory.createInputDirection("description");
        JAXBElement<String> createInputDelegation = factory.createInputDelegation("description");
        JAXBElement<String> createInputFLastName = factory.createInputFLastName("description");
        JAXBElement<String> createInputSLastName = factory.createInputSLastName("description");
        JAXBElement<String> createInputName = factory.createInputName(nombre);
        JAXBElement<String> createInputPassw = factory.createInputPassw("description");
        
       
        in.setTelephone(tel);
        in.setDelegation(createInputDelegation);
        in.setDirection(createInputDirection);
        in.setFLastName(createInputFLastName);
        in.setEmail(createInputEmail);
        in.setSLastName(createInputSLastName);
        in.setPassw(createInputPassw);
        in.setName(createInputName);
       
       
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
