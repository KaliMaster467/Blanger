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
 * @author root
 */
public class Lato {
    public Lato()
    {
        
    }
    public Font getMainWnd()
    {
        Font f = null;
        
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("/res/Fonts/Lato-Thin.ttf").openStream());
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
    public Font getTit(){
        Font f = null;
        
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("/res/Fonts/Lato-Thin.ttf").openStream());
            GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            genv.registerFont(font);
            // makesure to derive the size
            font = font.deriveFont(80f); 
            f =  font;
        } catch (IOException ex) {
            Logger.getLogger(Raleway.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FontFormatException ex) {
            Logger.getLogger(Raleway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;           
    }
}
