/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppSource.Views.MainUserViews;

import AppSource.Views.MainUserMenu;
import Core.ConnectListener;
import Public.Styles.Fonts.Raleway;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author axkiller
 */
public class Dispositivos extends UserViews implements ActionListener{
    private DispController _controller;
    private JPanel Personaliza;
    public Dispositivos(MainUserMenu fatherMenu) {
        
        super(fatherMenu);
        setBackground(Color.white);
        setBounds(0,0 ,fatherMenu.getUserP().getWidth(), 800);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));   
        _controller = new DispController();
        Personaliza = Personaliza(this);
        add(Personaliza);
        add(Per(this));
        
    }
    private JPanel Personaliza(Dispositivos father)
    {
        JPanel personaliza = new JPanel();
        personaliza.setBounds(0,0, father.getWidth(), 400);
        personaliza.setPreferredSize(new Dimension(father.getWidth(), 400));
        personaliza.setSize(new Dimension(father.getWidth(), 400));
        personaliza.setBackground(Color.white);
        personaliza.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        Raleway ral = new Raleway();
        
        JLabel title = new JLabel("Personaliza");
        //title.setPreferredSize(new Dimension(270, 90));
        title.setForeground(Color.black);
        title.setFont(ral.getTitleFont());
        title.setLayout(null);
        title.setVisible(true);
        
       c.fill = GridBagConstraints.VERTICAL;
        c.anchor = GridBagConstraints.PAGE_START;
        c.weighty = 0;
        c.gridx = 1;
        personaliza.add(title, c);
        
      
        
        JLabel selec = new JLabel("Selecciona un color");
        //selec.setPreferredSize(new Dimension(200, 30));
        selec.setForeground(Color.gray);
        selec.setFont(ral.getMinFont());
        selec.setLayout(null);
        
        c.anchor = GridBagConstraints.CENTER;
        c.weighty = 0;
        c.gridx = 1;
        personaliza.add(selec, c);  
        
        
        JPanel color = new JPanel();
        color.setLayout(new FlowLayout(FlowLayout.CENTER));
        color.setBackground(Color.white);
        color.setPreferredSize(new Dimension(father.getWidth(), 200));
        c.anchor = GridBagConstraints.PAGE_END;
        c.weightx = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 2;
        
        JButton but = new JButton("Azul");
        but.addActionListener(this);
        
        but.setHorizontalAlignment(SwingConstants.CENTER);
        but.setSize(color.getHeight(), color.getHeight());
        but.setBackground(Color.blue);
        JButton but2 = new JButton("Rojo");
        but2.setHorizontalAlignment(SwingConstants.CENTER);
        but2.addActionListener(this);
        but2.setBackground(Color.red);
        JButton but3 = new JButton("Verde");
        but3.addActionListener(this);
        but3.setBackground(Color.green);
        but3.setHorizontalAlignment(SwingConstants.CENTER);
        JButton but4 = new JButton("Morado");
        but4.addActionListener(this);
        but4.setHorizontalAlignment(SwingConstants.CENTER);
        but4.setBackground(Color.MAGENTA);
        but4.setSize(color.getHeight(), color.getHeight());        
        color.add(but);
        color.add(but2);
        color.add(but3);
        color.add(but4);
        personaliza.add(color, c);
        //Componentes del panel
        
        return personaliza;
    }        
private JPanel Per(Dispositivos father)
    {
        JPanel personaliza = new JPanel();
        personaliza.setBounds(0,0, father.getWidth(), 400);
        personaliza.setPreferredSize(new Dimension(father.getWidth(), 400));
        personaliza.setSize(new Dimension(father.getWidth(), 400));
        personaliza.setBackground(Color.white);
        personaliza.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        Raleway ral = new Raleway();
        
        JLabel title = new JLabel("Dispositivo");
        //title.setPreferredSize(new Dimension(270, 90));
        title.setForeground(Color.black);
        title.setFont(ral.getTitleFont());
        title.setLayout(null);
        title.setVisible(true);
        
       c.fill = GridBagConstraints.VERTICAL;
        c.anchor = GridBagConstraints.PAGE_START;
        c.weighty = 0;
        c.gridx = 1;
        personaliza.add(title, c);
        
      
        
        JLabel selec = new JLabel("Selecciona un color");
        //selec.setPreferredSize(new Dimension(200, 30));
        selec.setForeground(Color.gray);
        selec.setFont(ral.getMinFont());
        selec.setLayout(null);
        
        c.anchor = GridBagConstraints.CENTER;
        c.weighty = 0;
        c.gridx = 1;
        personaliza.add(selec, c);  
        
        
        JPanel color = new JPanel();
        color.setLayout(new FlowLayout(FlowLayout.CENTER));
        color.setBackground(Color.white);
        color.setPreferredSize(new Dimension(father.getWidth(), 200));
        c.anchor = GridBagConstraints.PAGE_END;
        c.weightx = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 2;
        
        JButton but = new JButton("Azul");
        but.addActionListener(this);
        but.setHorizontalAlignment(SwingConstants.CENTER);
        but.setSize(color.getHeight(), color.getHeight());
        JButton but2 = new JButton("Rojo");
        but2.setHorizontalAlignment(SwingConstants.CENTER);
        but2.addActionListener(this);
        JButton but3 = new JButton("Verde");
        but3.addActionListener(this);
        but3.setHorizontalAlignment(SwingConstants.CENTER);
        
        color.add(but);
        color.add(but2);
        color.add(but3);
        personaliza.add(color, c);
        //Componentes del panel
        
        return personaliza;
    }        
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("Azul")){
            try {
                _controller.list.setColor("1");
            } catch (Exception ex) {
                Logger.getLogger(Dispositivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(ae.getActionCommand().equals("Rojo")){
            try {
                _controller.list.setColor("2");
            } catch (Exception ex) {
                Logger.getLogger(Dispositivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(ae.getActionCommand().equals("Verde")){
            try {
                _controller.list.setColor("3");
            } catch (Exception ex) {
                Logger.getLogger(Dispositivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(ae.getActionCommand().equals("Morado")){
            try {
                _controller.list.setColor("4");
            } catch (Exception ex) {
                Logger.getLogger(Dispositivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private class DispController
    {        
        ConnectListener list;
        public DispController()
        {
            list = new ConnectListener();
            try {
                list.initialize();
            } catch (Exception ex) {
                Logger.getLogger(Dispositivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
