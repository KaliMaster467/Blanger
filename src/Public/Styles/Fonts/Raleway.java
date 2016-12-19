/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Public.Styles.Fonts;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alb
 */
public class Raleway{
    public Font getTitleFont(){
        Font f = null;
        
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("/res/Fonts/Raleway-Medium.ttf").openStream());
            GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            genv.registerFont(font);
            // makesure to derive the size
            font = font.deriveFont(50f); 
            f =  font;
        } catch (IOException ex) {
            Logger.getLogger(Raleway.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FontFormatException ex) {
            Logger.getLogger(Raleway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }    
    public Font getMinFont(){
        Font f = null;
        
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("/res/Fonts/Raleway-Medium.ttf").openStream());
            GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            genv.registerFont(font);
            // makesure to derive the size
            font = font.deriveFont(15f); 
            f =  font;
        } catch (IOException ex) {
            Logger.getLogger(Raleway.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FontFormatException ex) {
            Logger.getLogger(Raleway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    } 
        public Font getForm(){
        Font f = null;
        
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("/res/Fonts/Raleway-Medium.ttf").openStream());
            GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            genv.registerFont(font);
            // makesure to derive the size
            font = font.deriveFont(20f); 
            f =  font;
        } catch (IOException ex) {
            Logger.getLogger(Raleway.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FontFormatException ex) {
            Logger.getLogger(Raleway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    } 
    public Font getBtnFont(){
        Font f = null;
        
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("/res/Fonts/Raleway-Medium.ttf").openStream());
            GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            genv.registerFont(font);
            // makesure to derive the size
            font = font.deriveFont(20f); 
            f =  font;
        } catch (IOException ex) {
            Logger.getLogger(Raleway.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FontFormatException ex) {
            Logger.getLogger(Raleway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }   
    public Font getLabelFont(){
        Font f = null;
        
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("/res/Fonts/Raleway-Medium.ttf").openStream());
            GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            genv.registerFont(font);
            // makesure to derive the size
            font = font.deriveFont(25f); 
            f =  font;
        } catch (IOException ex) {
            Logger.getLogger(Raleway.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FontFormatException ex) {
            Logger.getLogger(Raleway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }     
}
