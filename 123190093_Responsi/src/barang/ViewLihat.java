/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barang;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author ASUS
 */
public class ViewLihat extends JFrame implements ActionListener {
    private JTable table;
    private JButton bBack;
    private String kode;
    
    public ViewLihat(String[][] data){
        try{
            kode = data[0][0];
            final String[] tableTitle = {"Id", "Nama", "Massa", "Harga"};
            setTitle("Data Barang");
            
            bBack = new JButton("Kembali");
            table = new JTable(data,tableTitle);
            JScrollPane scroll = new JScrollPane(table);
            this.getContentPane().add(BorderLayout.CENTER, scroll);
            this.getContentPane().add(BorderLayout.SOUTH, bBack);
            bBack.addActionListener(this);
            bBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            table.setCursor((Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)));
            
            table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                
                public void valueChanged(ListSelectionEvent event) {
                    dispose();
                    kode = table.getValueAt(table.getSelectedRow(), 0).toString();
                    ControllerBarang c = new ControllerBarang();
                    System.out.println(kode);
                    c.lihatBarang(kode);
                }
            });
            
            setSize(560,380);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
        }
        catch (Exception e){
            System.out.println("Error : " + e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bBack){
            ControllerMenu menu = new ControllerMenu();
            menu.viewMenu();
            dispose();
        }
    }
}