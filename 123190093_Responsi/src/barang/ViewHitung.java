/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barang;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author ASUS
 */
public class ViewHitung extends JFrame implements ActionListener{
     private JLabel lNama, lMassa, lHarga, lBanyak, isianNama, isianMassa, isianHarga, isianBanyak;          
     private JButton bBack;
     private String id;

    public void ViewHitung(String[] data){
        this.id = data[4];
        setTitle(data[0]);
        
        double i=Double.parseDouble(data[2]);
        double j=Double.parseDouble(data[3]);
        double total = i*j;
        
        if(j==12){
            total=total-(0.05*total);
        }
        else if(j==20){
            total=total-(0.1*total);
        }
        else if(j==144){
            total=total-(0.25*total);
        }
        
        String Total=String.valueOf(total);   
        lNama = new JLabel("Nama : ");
        isianNama = new JLabel(data[0]);
        lMassa = new JLabel("Massa : ");
        isianMassa = new JLabel(data[1]);
        lHarga = new JLabel("Harga : ");
        isianHarga = new JLabel(data[2]);
        lBanyak = new JLabel("Banyak : ");
        isianBanyak = new JLabel(Total);
        bBack = new JButton("Kembali");
       
        setLayout(null);
        add(lNama); add(isianNama);
        add(lMassa); add(isianMassa);
        add(lHarga); add(isianHarga);
        add(lBanyak); add(isianBanyak);
        add(bBack);

        lNama.setBounds(10,10,120,20);
        isianNama.setBounds(130,10,190,20);
        lMassa.setBounds(10,35,120,20);
        isianMassa.setBounds(130,35,190,20);
        lHarga.setBounds(10,60,120,20);
        isianHarga.setBounds(130,60,190,20);
        lBanyak.setBounds(10,85,120,20);
        isianBanyak.setBounds(130,85,190,20);
        bBack.setBounds(10,200,90,20);
        bBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bBack.addActionListener(this);
        
        setSize(300,280);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bBack){
            ControllerBarang menu = new ControllerBarang();
            menu.lihatBarang(id);
            dispose();
        }
    }
    
}