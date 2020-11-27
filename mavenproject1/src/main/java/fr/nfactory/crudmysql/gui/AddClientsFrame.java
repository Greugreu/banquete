/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.nfactory.crudmysql.gui;

import fr.nfactory.crudmysql.beans.Clients;
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
public class AddClientsFrame extends JFrame {
    
    private Clients clients;
    private JTextField clientsName;
    private JTextField clientsSurname;
    private JTextField birthdate;
    private JButton save;
    private MainFrame maman;
    
    public AddClientsFrame(MainFrame maman){
        super();
        setTitle("Nouveau client");
        setBounds(100, 100, 200, 400);
        setMinimumSize(new Dimension(200,200));
        this.clients = new Clients();
        this.maman = maman;
        initComponent();
    }

    private void initComponent() {
        // lignes puis colonnes
        JPanel panel = new JPanel(new GridLayout(4, 2));
        JLabel label1 = new JLabel("Nom");
        panel.add(label1);
        clientsName = new JTextField();
        panel.add(clientsName);
        
        JLabel label2 = new JLabel("Prénom");
        panel.add(label2);
        clientsSurname = new JTextField();
        panel.add(clientsSurname);
        
        JLabel label3 = new JLabel("Date de naissance");
        panel.add(label3);
        birthdate = new JTextField();
        panel.add(birthdate);
        
        save = new JButton("enregistrer");
        panel.add(save);
        
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clients.setClientsName(clientsName.getText());
                clients.setClientsSurname(clientsSurname.getText());                
                try {
                    DaoFactory.getClientsDao().add(clients);
                } catch (SQLException ex) {
                    Logger.getLogger(AddClientsFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                setVisible(false);
                maman.refresh();
            }
        });
        
        getContentPane().add(panel);        
    }
    
    
}
