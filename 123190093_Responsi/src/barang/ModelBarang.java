/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barang;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author ASUS
 */
public class ModelBarang {
    
    Connector connect = new Connector();
    
    public void tambahBarang(String[] data){
        try{
            String query = "INSERT INTO barang (nama, massa, harga) VALUES ('"+data[0]+"', '"+data[1]+"', '"+data[2]+"')";
            connect.statement = connect.koneksi.createStatement();
            connect.statement.executeUpdate(query);
            
            connect.statement.close();
            connect.koneksi.close();
            JOptionPane.showMessageDialog(null, "Input Berhasil");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public String[][] lihatBarang(){
        try{
            int c = 0;
            int numb = numRows("barang");
            if(numb==0){
                return null;
            }
            String[][] data = new String[numb][4];
            String query = "SELECT * FROM barang";
            ResultSet resultSet = connect.statement.executeQuery(query);
            while (resultSet.next()){
                data[c][0] = resultSet.getString("id");
                data[c][1] = resultSet.getString("nama");
                data[c][2] = resultSet.getString("massa");
                data[c][3] = resultSet.getString("harga");
                c++;
            }
            return data;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    private int numRows(String barang) {
        
        int jml = 0;
        try{
            connect.statement = connect.koneksi.createStatement();
            String query = "SELECT * FROM barang";
            ResultSet resultSet = connect.statement.executeQuery(query);
            while (resultSet.next()){
                jml++;
            }
            return jml;

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }
    
    public String[] lihatBarang(String select){
        try{
            String[] data = new String[4];
            connect.statement = connect.koneksi.createStatement();
            String query = "SELECT * FROM barang WHERE id = '"+select+"'";
            ResultSet resultSet = connect.statement.executeQuery(query);
            while (resultSet.next()){
                data[0] = resultSet.getString("id");
                data[1] = resultSet.getString("nama");
                data[2] = resultSet.getString("massa");
                data[3] = resultSet.getString("harga");
            }
            return data;         
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public void editBarang(String[] data){
       try{
            String query = "UPDATE barang SET nama = '"+data[0]+"', massa = '"+data[1]+"', harga='"+data[2]+"' WHERE id = '"+data[3]+"'";
            connect.statement = connect.koneksi.createStatement();
            connect.statement.executeUpdate(query);
            
            connect.statement.close();
            connect.koneksi.close();
            JOptionPane.showMessageDialog(null, "Berhasil");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public String getData(String column, String table, String where, String value){
        try{
            String data = new String();
            connect.statement = connect.koneksi.createStatement();
            String query = "select "+column+" from "+table+" where "+where+" = '" + value + "'";
            ResultSet resultSet = connect.statement.executeQuery(query);
            while (resultSet.next()){
                data = resultSet.getString(column);
            }
            return data;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
        public void deleteBarang(String id){
        try {
            String query = "DELETE FROM barang WHERE id = '"+id+"'";
            connect.statement = connect.koneksi.createStatement();
            connect.statement.executeUpdate(query);
            
            connect.statement.close();
            connect.koneksi.close();
            JOptionPane.showMessageDialog(null, "Hapus Berhasil");
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal! Hapus dulu data status orang dengan id = " + id);
        }
      }
    
}
