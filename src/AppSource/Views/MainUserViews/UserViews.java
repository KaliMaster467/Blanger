/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppSource.Views.MainUserViews;

import AppSource.Views.MainUserMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author axkiller
 */
public class UserViews extends JPanel {
    private MainUserMenu superMenu;
    public UserViews(MainUserMenu fatherMenu)
    {
        superMenu = fatherMenu;
    }
    protected MainUserMenu getSuperMenu()
    {
        return superMenu;
    }
  
}
