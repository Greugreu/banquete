/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.nfactory.crudmysql.gui;

import fr.nfactory.crudmysql.beans.Alcool;
import fr.nfactory.crudmysql.dao.DaoFactory;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ludivine
 */
public class AddAlcoolFrame extends JFrame {
    
    private Alcool alcool;
    private JTextField name;
    private JTextField degre;
    private JTextField volume;
    private JButton save;
    private MainFrame maman;
    
    public AddAlcoolFrame(MainFrame maman){
        super();
        setTitle("Nouvel alcoll");
        setBounds(100, 100, 200, 400);
        setMinimumSize(new Dimension(200,200));
        this.alcool = new Alcool();
        this.maman = maman;
        initComponent();
    }

    private void initComponent() {
        // lignes puis colonnes
        JPanel panel = new JPanel(new GridLayout(4, 2));
        JLabel label1 = new JLabel("Nom");
        panel.add(label1);
        name = new JTextField();
        panel.add(name);
        
        JLabel label2 = new JLabel("Degré");
        panel.add(label2);
        degre = new JTextField();
        panel.add(degre);
        
        JLabel label3 = new JLabel("Volume");
        panel.add(label3);
        volume = new JTextField();
        panel.add(volume);
        
        save = new JButton("enregistrer");
        panel.add(save);
        
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alcool.setName(name.getText());
                alcool.setDegre(Double.parseDouble(degre.getText()));                
                alcool.setVolume(Double.parseDouble(volume.getText()));
                try {
                    DaoFactory.getAlcoolDao().add(alcool);
                } catch (SQLException ex) {
                    Logger.getLogger(AddAlcoolFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                setVisible(false);
                maman.refresh();
            }
        });
        
        getContentPane().add(panel);        
    }
    
    
}
