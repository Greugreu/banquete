/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.nfactory.crudmysql.gui;

import fr.nfactory.crudmysql.beans.Clients;
import fr.nfactory.crudmysql.dao.DaoFactory;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;

/**
 *
 * @author ludivine
 */
public class MainFrame extends JFrame{
    
    private ArrayList<Clients> clients;
    private JPanel panel;
    private JButton addClientsBtn;
    private DefaultListModel model = new DefaultListModel();
    
    public MainFrame(ArrayList<Clients> clients ){
        super();
        setVisible(true);
        setTitle("Liste des clients");
        setBounds(100, 100, 450, 600);
        setMinimumSize(new Dimension(200,200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.clients = clients;
        initComponent();
    }
    
    private void initComponent(){
        this.panel = new JPanel(new BorderLayout());
        for(Clients a : clients){
            model.addElement(a);
        }
        JList list = new JList(model);
        panel.add(list,BorderLayout.NORTH);
        this.addClientsBtn = new JButton("Ajouter un client");
        panel.add(this.addClientsBtn, BorderLayout.SOUTH);
        addClientsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddClientsFrame(getThis()).setVisible(true);
            }
        });
        getContentPane().add(panel);
    }
    
    public void refresh(){
        try {
            clients = DaoFactory.getClientsDao().getAll();
            model.addElement(clients.get(clients.size()-1));
            //initComponent();
            //SwingUtilities.updateComponentTreeUI(this);
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public MainFrame getThis(){
        return this;
    }
}
