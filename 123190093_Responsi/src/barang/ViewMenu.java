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
public class ViewMenu extends JFrame implements ActionListener{
   private JLabel lJudul;
   private JButton bTambah, bLihat;
    
    public ViewMenu(){
       setTitle("Menu Utama");
       lJudul = new JLabel("Main Menu");
       bTambah = new JButton("Tambah Barang");
       bLihat = new JButton("Lihat Barang");
       setLayout(new GridLayout(3,1));
       
       add(lJudul);
       lJudul.setHorizontalAlignment(SwingConstants.CENTER);
       add(bTambah);
       add(bLihat);
       
       bTambah.addActionListener(this);
       bLihat.addActionListener(this);
       bTambah.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       bLihat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
       pack();
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
       setLocationRelativeTo(null);
     
   }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bTambah){
            ControllerBarang tambah = new ControllerBarang();
            tambah.tambahBarang();
            dispose();
        }
        else if(e.getSource() == bLihat){
            ControllerBarang lihat = new ControllerBarang();
            lihat.lihatBarang();
            dispose();
        }
    }
}
