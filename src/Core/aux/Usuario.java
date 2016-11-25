/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.aux;

/**
 *
 * @author root
 */
public class Usuario {
    private static String nombre;
    private static String fnombre;
    private static String snombre;
    private static String mail;
    private static String pass;
    private static String date;
    private static int tel;
    
    public Usuario(){
       
    }
    public static void setDate(String dat){
        date = dat;
    }
    public static void setNombre(String nom){
        nombre = nom;
    }
    public static void setFnombre(String fnom){
        fnombre = fnom;
    }
    public static void setSnombre(String snom){
        snombre = snom;
    }
    public static void setMail(String mai){
        mail = mai;
    }
    public static void setPass(String pas){
        pass = pas;
    }
    public static void setTel(int te){
        tel = te;
    }
    public static String getNombre(){
        return nombre;
    }
    public static String getFnombre(){
        return fnombre;
    }
    public static String getSnombre(){
        return snombre;
    }
    public static String getMail(){
        return mail;
    }
    public static String getPass(){
        return pass;
    }
    public static int getTel(){
        return tel;
    }
    public static String getDate(){
        return date;
    }
}
