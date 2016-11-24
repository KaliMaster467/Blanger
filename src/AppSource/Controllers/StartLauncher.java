/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//StarLauncher Controlador
package AppSource.Controllers;
import Core.Controller;
import Public.Wnd;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBElement;


/**
 *
 * @author root
 */
public class StartLauncher extends Controller{
    private AppSource.Views.StartLauncher sl; 
    public StartLauncher(Wnd hInstance)
    {
        
        super(hInstance);
        sl = new AppSource.Views.StartLauncher(hInstance, this);
        super.getView().Render(sl);
        
    }
    public void test()
    {
        System.out.println("okoloko");
    }
        public void RetreiveUser(String user, String pass){
        Buscar.Input in = new Buscar.Input();
        Buscar.ObjectFactory factory = new Buscar.ObjectFactory();
        JAXBElement<String> createInptUser = factory.createInputUser(user);
        JAXBElement<String> createInptPass = factory.createInputPass(pass);
        
        in.setUser(createInptUser);
        in.setPass(createInptPass);
        
        javax.xml.ws.Holder<java.lang.String> date = null, fname = null, sname = null, name =null, mail = null, del = null, passw = null, dir = null;
        javax.xml.ws.Holder<Boolean>  st = null;
        javax.xml.ws.Holder<Integer> id = null, tel = null;
        
        Buscar.Usuario usu = new Buscar.Usuario();
        javax.xml.ws.Holder<java.lang.String> nom = new javax.xml.ws.Holder<java.lang.String>();
        javax.xml.ws.Holder<java.lang.String> dat = new javax.xml.ws.Holder<java.lang.String>();
              
        StartLauncher.getInfo(in, id, dat, fname, sname, nom, tel, mail, del, passw, dir, st);
        
        if(nom.value == null){
            
            JOptionPane.showMessageDialog(null, "No se encontro al Usuario");
        }else{
            JOptionPane.showMessageDialog(null, "Nombre" + nom.value + "Fecha: " + dat.value);
        }
    }
    private static void getInfo(Buscar.Input search, javax.xml.ws.Holder<Integer> id, javax.xml.ws.Holder<java.lang.String> date, javax.xml.ws.Holder<java.lang.String> fLastName, javax.xml.ws.Holder<java.lang.String> sLastName, javax.xml.ws.Holder<java.lang.String> name, javax.xml.ws.Holder<Integer> telephone, javax.xml.ws.Holder<java.lang.String> email, javax.xml.ws.Holder<java.lang.String> delegation, javax.xml.ws.Holder<java.lang.String> passw, javax.xml.ws.Holder<java.lang.String> direction, javax.xml.ws.Holder<Boolean> status) {
        Buscar.BuscarAlumno service = new Buscar.BuscarAlumno();
        Buscar.BuscarAlumnoPortType port = service.getBuscarAlumno();
        port.getInfo(search, id, date, fLastName, sLastName, name, telephone, email, delegation, passw, direction, status);
        
        
        Buscar.Usuario user = new Buscar.Usuario();
        Buscar.ObjectFactory factory = new Buscar.ObjectFactory();
        //JAXBElement<String> createUserName = factory.createUsuarioName(name);
        
        
        //JOptionPane.showMessageDialog(null, name.value);
        
        
        
    }        
}
