/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppSource.Controllers;

import Core.Controller;
import Services.ObjectFactory;
import Core.Security;
import Public.ErrWnd;
import Public.OkWnd;
import Public.Wnd;
import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
        
    public void InsertUser(String nombre, String fnombre, String snombre, int tel, String mail, String pass) throws NoSuchAlgorithmException{

        
        /*if(Register.getInfo(in).equals("OK")){
            System.out.println("OK");
        }else{
            System.out.println("nel");
        }*/
        
            if(nombre.equals("")|| fnombre.equals("") || snombre.equals("")
                    || mail.equals("") || pass.equals("") || tel == 0){

                //JOptionPane.showMessageDialog(null, "Llene los campos");
                ErrWnd err = new ErrWnd("Llene los camposo");
                
            }else{
                if(emailCorrecto(mail)){
                    Services.Input in = new Services.Input();
                    ObjectFactory factory = new ObjectFactory();
                    JAXBElement<String> createInputEmail = factory.createInputEmail(mail);
                    JAXBElement<String> createInputDirection = factory.createInputDirection("del");
                    JAXBElement<String> createInputDelegation = factory.createInputDelegation("dir");
                    JAXBElement<String> createInputFLastName = factory.createInputFLastName(fnombre);
                    JAXBElement<String> createInputSLastName = factory.createInputSLastName(snombre);
                    JAXBElement<String> createInputName = factory.createInputName(nombre);
                    JAXBElement<String> createInputPassw = factory.createInputPassw(Security.md5(pass));


                    in.setTelephone(tel);
                    in.setDelegation(createInputDelegation);
                    in.setDirection(createInputDirection);
                    in.setFLastName(createInputFLastName);
                    in.setEmail(createInputEmail);
                    in.setSLastName(createInputSLastName);
                    in.setPassw(createInputPassw);
                    in.setName(createInputName);   
                    
                    String ls = Register.getInfo(in);
                    //System.out.println(Register.getInfo(in));
                    
                    if(ls.equals("OK")){
                        OkWnd ex = new OkWnd("Se registro con éxito");
                        try {
                            hInstance.addController("AppSource.Controllers.StartLauncher");
                        } catch (ClassNotFoundException ex1) {
                            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex1);
                        } catch (NoSuchMethodException ex1) {
                            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex1);
                        } catch (InstantiationException ex1) {
                            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex1);
                        } catch (IllegalAccessException ex1) {
                            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex1);
                        } catch (IllegalArgumentException ex1) {
                            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex1);
                        } catch (InvocationTargetException ex1) {
                            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex1);
                        }
                    }else{
                        ErrWnd err = new ErrWnd("Intente de nuevo");
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Email incorrecto");
                }                
            }    

    }

    private static String getInfo(Services.Input insert) {
        Services.CrearAlumno service = new Services.CrearAlumno();
        Services.CrearAlumnoPortType port = service.getCrearAlumno();
        return port.getInfo(insert);
    }
    public boolean emailCorrecto(String email) {
        int lugarArroba = 0;//Posicion donde esta el arroba
        for (int i = 0; i < email.length(); ++i) {//revisa que tenga el @
            if (email.charAt(i) == '@') {//para cada char de el email revisa si hay un @
                lugarArroba = i;//guarda la pos de la @
                break;//rompe el for
            }
        }
        for (int i = 0; i < email.length(); ++i) {//Si tiene espacios
            if (email.charAt(i) == ' ') {//Lo invalida automaticamente
                System.out.println("**ERROR** tiene espacios");
                return false;
            }
        }
        if (lugarArroba == 0) {//si no hay @
            System.out.println("**ERROR** no hay arroba");
            return false;//regresa falso (el correo es invalido
        } else {//si hay una @
            String resto = email.substring(lugarArroba, email.length());//le da lo restante a otra String
            int lugarPunto = 0;//Posicion del punto
            for (int i = 0; i < resto.length(); ++i) {//revisa para los espacios restantes
                if (resto.charAt(i) == '.') {//Si hay un punto
                    lugarPunto = i;//Da el lugar del punto
                    break;//Rompe el for
                }
            }
            if (lugarPunto == 0) {//Si no hay punto
                System.out.println("**ERROR** no hay punto");
                return false;//regresa que es feik
            }
            String tipoCorreo = resto.substring(1, lugarPunto);//Tipo de correo (outlook, yahoo, hotmail, etc...)
            String comLugar = resto.substring(lugarPunto + 1, resto.length());//Para el com y el .mx u cualquier otro lugar
            if (tipoCorreo.equalsIgnoreCase("outlook") || tipoCorreo.equalsIgnoreCase("yahoo") || tipoCorreo.equalsIgnoreCase("hotmail")
                    || tipoCorreo.equalsIgnoreCase("gmail")) {//El tipoCorreo es validado ******AGREGAR MAS SI ES NECESARIO******
                if (comLugar.charAt(0) == 'c' && comLugar.charAt(1) == 'o' && comLugar.charAt(2) == 'm') {//ver si tiene el com
                    if (comLugar.length() >= 4) {
                        if (comLugar.charAt(3) == '.') {//Si tiene un punto en la pos 3
                            if (comLugar.length() >= 6) {//Aqui en vez de esto se podria usar algo como esto para cada uno de los lugares (mx, us, etc)
                                /*
                                ******AGREGAR MAS SI ES NECESARIO******
                                if(comLugar.substring(4, comLugar.length).equals("mx")){
                                    return true;
                                }
                                */
                                return true;
                            } else {//Si no tiene almenos 2 espacios despues del 2do punto
                                System.out.println("**ERROR** No tiene almenos 2 despues del .");
                                return false;
                            }
                        } else {//si no tiene el punto en esa pos signfiica que tiene otro caracter despues del com por tanto
                            System.out.println("**ERROR** Despues del com no hay un punto");
                            return false;//el correo es invalido
                        }
                    } else {//No tiene mas despues del .com
                        return true;
                    }
                } else {//si no tiene el com
                    System.out.println("**ERROR** No hay com");
                    return false;//regresa que el correo es invalido
                }
            } else {
                System.out.println("**ERROR** el correo no es outlook, yahoo, gmail o hotmail");
                return false;
            }
        }

    }    
}
