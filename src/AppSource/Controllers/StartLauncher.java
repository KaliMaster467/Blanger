/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//StarLauncher Controlador
package AppSource.Controllers;
import Core.Controller;
import Core.auxil.Usuario;
import Public.ErrWnd;
import Public.OkWnd;
import Public.Wnd;
import java.awt.BorderLayout;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.xml.bind.JAXBElement;


/**
 *
 * @author root
 */
public class StartLauncher extends Controller{
    private AppSource.Views.StartLauncher sl; 
    private JFrame loa;
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

            //javax.xml.ws.Holder<java.lang.String> date = null, fname = null, sname = null, name =null, mail = null, del = null, passw = null, dir = null;
            //javax.xml.ws.Holder<Boolean>  st = null;
            //javax.xml.ws.Holder<Integer> id = null, tel = null;

            Buscar.Usuario usu = new Buscar.Usuario();
            javax.xml.ws.Holder<java.lang.String> nom = new javax.xml.ws.Holder<java.lang.String>();
            javax.xml.ws.Holder<java.lang.String> dat = new javax.xml.ws.Holder<java.lang.String>();
            javax.xml.ws.Holder<java.lang.String> mail = new javax.xml.ws.Holder<java.lang.String>();
            javax.xml.ws.Holder<java.lang.String> fname = new javax.xml.ws.Holder<java.lang.String>();
            javax.xml.ws.Holder<java.lang.String> sname = new javax.xml.ws.Holder<java.lang.String>();
            javax.xml.ws.Holder<Integer> tel = new javax.xml.ws.Holder<Integer>();
            javax.xml.ws.Holder<Boolean> st = new javax.xml.ws.Holder<Boolean>();
            javax.xml.ws.Holder<java.lang.String> passw = new javax.xml.ws.Holder<java.lang.String>();
            javax.xml.ws.Holder<Integer>  id = new javax.xml.ws.Holder<Integer>();
            javax.xml.ws.Holder<java.lang.String> dir = new javax.xml.ws.Holder<java.lang.String>();
            javax.xml.ws.Holder<java.lang.String> del = new javax.xml.ws.Holder<java.lang.String>();

            
            SwingWorker<Void, Void> wo = new SwingWorker<Void, Void>() {
                 @Override
                public Void doInBackground() {
            try{    
            
            ImageIcon lo = new ImageIcon(getClass().getResource("/res/loo.gif"));
            
            JLabel load = new JLabel(lo);
            load.setSize(300,300);
            load.setHorizontalAlignment(SwingConstants.CENTER);
            load.setVisible(true);    
            
            /*JFrame ja = new JFrame();
            //ja.setUndecorated(true);
            ja.setSize(434, 422);
            ja.setLocationRelativeTo(null);
            ja.add(load);
            ja.setVisible(true);*/
            
            sl.addLoad(load);
            
            //loa = ja;
            Thread.sleep(2000);
            StartLauncher.getInfo(in, id, dat, fname, sname, nom, tel, mail, del, passw, dir, st);
            
            
            if(nom.value == null){

                //JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrectos","EX" , 0, null);
                ErrWnd err = new ErrWnd("Usuario o contraseña incorrecta");

            }else{
                //JOptionPane.showMessageDialog(null, "Bienvenido: " + nom.value, "Bienvenido", 0);
                OkWnd ok = new OkWnd("Bienvenido");
                Usuario.setNombre(nom.value);
                Usuario.setDate(dat.value);
                Usuario.setMail(mail.value);

                 SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                 @Override
                public Void doInBackground() {

                return null;

                }

                @Override
                 protected void done() {

                hInstance.WndDragger.optIni.setText("Salir");
                hInstance.WndDragger.regist.setText("");
                hInstance.WndDragger.regist.setEnabled(false);
                }

                }; 
                 worker.execute();
                //Usuario.setMail(mail.value);
                //Usuario.setSnombre(sname.value);
                //Usuario.setPass(passw.value);
                //Usuario.setTel(tel.value);
                try {
                    hInstance.addController("AppSource.Controllers.MainUserMenu");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(StartLauncher.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(StartLauncher.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(StartLauncher.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(StartLauncher.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(StartLauncher.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(StartLauncher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }catch(Exception e){
            System.out.println("No se connecto al servidor");
            ErrWnd err = new ErrWnd("No se conecto al servidor");
            //e.printStackTrace();
        }    
                return null;

                }

                @Override
                 protected void done() {
                     sl.removeLoad();
                
                }

                }; 
                 wo.execute();
        
    }
    private static void getInfo(Buscar.Input search, javax.xml.ws.Holder<Integer> id, javax.xml.ws.Holder<java.lang.String> date, javax.xml.ws.Holder<java.lang.String> fLastName, javax.xml.ws.Holder<java.lang.String> sLastName, javax.xml.ws.Holder<java.lang.String> name, javax.xml.ws.Holder<Integer> telephone, javax.xml.ws.Holder<java.lang.String> email, javax.xml.ws.Holder<java.lang.String> delegation, javax.xml.ws.Holder<java.lang.String> passw, javax.xml.ws.Holder<java.lang.String> direction, javax.xml.ws.Holder<Boolean> status) throws Exception{
        Buscar.BuscarAlumno service = new Buscar.BuscarAlumno();
        Buscar.BuscarAlumnoPortType port = service.getBuscarAlumno();
        
            port.getInfo(search, id, date, fLastName, sLastName, name, telephone, email, delegation, passw, direction, status);
   
        
        Buscar.Usuario user = new Buscar.Usuario();
        Buscar.ObjectFactory factory = new Buscar.ObjectFactory();
        //JAXBElement<String> createUserName = factory.createUsuarioName(name);
        
        
        //JOptionPane.showMessageDialog(null, name.value);
        
        
        
    }        
}
