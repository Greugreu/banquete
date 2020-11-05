/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.nfactory.crudmysql.gui;

import fr.nfactory.crudmysql.beans.Alcool;
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
    
    private ArrayList<Alcool> alcools;
    private JPanel panel;
    private JButton addAlcoolBtn;
    private DefaultListModel model = new DefaultListModel();
    
    public MainFrame(ArrayList<Alcool> alcools ){
        super();
        setVisible(true);
        setTitle("La carte");
        setBounds(100, 100, 450, 600);
        setMinimumSize(new Dimension(200,200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.alcools = alcools;
        initComponent();
    }
    
    private void initComponent(){
        this.panel = new JPanel(new BorderLayout());
        for(Alcool a : alcools){
            model.addElement(a);
        }
        JList list = new JList(model);
        panel.add(list,BorderLayout.NORTH);
        this.addAlcoolBtn = new JButton("Ajouter un alcool");
        panel.add(this.addAlcoolBtn, BorderLayout.SOUTH);
        addAlcoolBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddAlcoolFrame(getThis()).setVisible(true);
            }
        });
        getContentPane().add(panel);
    }
    
    public void refresh(){
        try {
            alcools = DaoFactory.getAlcoolDao().getAll();
            model.addElement(alcools.get(alcools.size()-1));
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
