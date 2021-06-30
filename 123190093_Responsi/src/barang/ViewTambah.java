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
public class ViewTambah extends JFrame implements ActionListener{
    private JLabel lMenu, lNama, lMassa, lHarga;
    private JButton bSubmit, bReset, bBack; 
    private JTextField fNama, fMassa, fHarga;
    
    public void ViewTambah() {
        setTitle("Input Barang");
        lMenu = new JLabel("Input Barang");
        lNama = new JLabel("Nama");
        fNama = new JTextField(20);
        lMassa = new JLabel("Massa");
        fMassa = new JTextField(10);
        lHarga = new JLabel("Harga");
        fHarga = new JTextField(15);
        bSubmit = new JButton("Submit");
        bReset = new JButton("Reset");
        bBack = new JButton("Kembali");

        setLayout(null);
        add(lMenu);
        add(lNama); add(fNama);
        add(lMassa); add(fMassa);
        add(lHarga); add(fHarga);
        add(bSubmit);
        add(bReset);
        add(bBack);

        lMenu.setBounds(105,10,120,20);
        lNama.setBounds(20,35,120,20);
        fNama.setBounds(20,60,250,20);
        lMassa.setBounds(20,85,120,20);
        fMassa.setBounds(20,110,250,20);
        lHarga.setBounds(20,135,120,20);
        fHarga.setBounds(20,160,250,20);
        bSubmit.setBounds(20,195,120,20);
        bSubmit.setBackground(Color.blue);
        bSubmit.setForeground(Color.white);
        bSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bSubmit.addActionListener(this);
        bReset.setBounds(150,195,120,20);
        bReset.setBackground(Color.red);
        bReset.setForeground(Color.white);
        bReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bReset.addActionListener(this);
        bBack.setBounds(20,230,250,20);
        bBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bBack.addActionListener(this);
        
        setSize(300,310);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bSubmit) {
            if (fNama.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Nama harus diisi");
            }
            if (fMassa.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Massa harus diisi");
            }
            if (fHarga.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Harga harus diisi");
            }
            if(Integer.valueOf(fMassa.getText())<0){
                JOptionPane.showMessageDialog(this, "Massa harus positif");
            }
            if(Integer.valueOf(fHarga.getText())<0){
                JOptionPane.showMessageDialog(this, "Harga harus positif");
            }
            
            else {
                String[] data = {
                    fNama.getText(), fMassa.getText(), fHarga.getText()
                };
                ControllerBarang tambah = new ControllerBarang();
                tambah.tambahBarang(data);
            }
        }
        else if(e.getSource()==bReset){
            fNama.setText("");
            fMassa.setText("");
            fHarga.setText("");
        }
        else if(e.getSource()==bBack){
            dispose();
            ControllerMenu menu = new ControllerMenu();
            menu.viewMenu();
        }
    }

}