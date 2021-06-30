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
public class ViewDetail extends JFrame implements ActionListener {
    private JLabel lNama, lMassa, lHarga, lBanyak, isianNama, isianMassa, isianHarga;          
    private JButton bUpdate, bDelete, bBack, bTotal;
    private JTextField fBanyak;
    private String id;

    public void openDetail(String[] data){
       this.id = data[0];
        setTitle(data[1]);
       
        lNama = new JLabel("Nama : ");
        isianNama = new JLabel(data[1]);
        lMassa = new JLabel("Massa : ");
        isianMassa = new JLabel(data[2]);
        lHarga = new JLabel("Harga : ");
        isianHarga = new JLabel(data[3]);
        lBanyak = new JLabel("Banyak : ");
        fBanyak = new JTextField(10);
        
        bUpdate = new JButton("Edit");
        bDelete = new JButton("Hapus");
        bBack = new JButton("Kembali");
        bTotal = new JButton("Total Harga");

        setLayout(null);
        add(lNama); add(isianNama);
        add(lMassa); add(isianMassa);
        add(lHarga); add(isianHarga);
        add(lBanyak); add(fBanyak);
        add(bUpdate); add(bDelete);
        add(bBack); add(bTotal);

        lNama.setBounds(15,10,120,20);
        isianNama.setBounds(85,10,190,20);
        lMassa.setBounds(15,35,120,20);
        isianMassa.setBounds(85,35,190,20);
        lHarga.setBounds(15,60,120,20);
        isianHarga.setBounds(85,60,190,20);
        lBanyak.setBounds(15,85,120,20);
        fBanyak.setBounds(85,85,190,20);
        bTotal.setBounds(80,140,120,20);
        bTotal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bTotal.addActionListener(this);
        bBack.setBounds(10,200,90,20);
        bBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bBack.addActionListener(this);
        bUpdate.setBounds(110,200,80,20);
        bUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bUpdate.setBackground(Color.blue);
        bUpdate.setForeground(Color.white);
        bUpdate.addActionListener(this);
        bDelete.setBounds(200,200,80,20);
        bDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bDelete.setBackground(Color.red);
        bDelete.setForeground(Color.white);
        bDelete.addActionListener(this);

        setSize(300,280);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bUpdate){
            ControllerBarang update = new ControllerBarang();
            update.editBarang(id);
            dispose();
        }
        else if(e.getSource()==bDelete){
            OptDialog();
        }
        else if(e.getSource()==bTotal){
            if (fBanyak.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Jumlah harus diisi");
            }
            if (Integer.valueOf(fBanyak.getText())<0) {
                JOptionPane.showMessageDialog(this, "Jumlah harus positif");
            }
            else{
            String[] data = {
                        isianNama.getText(), isianMassa.getText(), isianHarga.getText(), fBanyak.getText(),id
                };
                ViewHitung hitung = new ViewHitung();
                hitung.ViewHitung(data); 
                dispose();
            }
        }
        else{
            ControllerBarang menu = new ControllerBarang();
            menu.lihatBarang();
            dispose();
        }
    }
    
    public void OptDialog(){
        int check = JOptionPane.showOptionDialog(this, "Yakin ingin menghapus?", "Hapus", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if(check==0){
            ControllerBarang delete = new ControllerBarang();
            delete.deleteBarang(id);
            dispose();
            ControllerBarang ControllerBarang = new ControllerBarang();
            ControllerBarang.lihatBarang();
        }
    }
}
