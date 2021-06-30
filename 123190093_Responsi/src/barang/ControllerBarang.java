/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barang;

import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ControllerBarang {
    public void tambahBarang(){
        ViewTambah view = new ViewTambah();
        view.ViewTambah();
    }
    
    public void tambahBarang(String[] data){
        ModelBarang model = new ModelBarang();
        model.tambahBarang(data);
    }
    
    public void lihatBarang(){
        ModelBarang model = new ModelBarang();
        String[][] data = model.lihatBarang();
        if(data == null)
            new ViewMenu();
        else
            new ViewLihat(data);
    }

    public void lihatBarang(String select){
        ModelBarang model = new ModelBarang();
        ViewDetail view = new ViewDetail();
        view.openDetail(model.lihatBarang(select));
    }
        
    public void editBarang(String id){
        ModelBarang model = new ModelBarang();
        String kode = model.getData("id", "barang", "id", id);
        ViewEdit update = new ViewEdit();
        update.ViewEdit(model.lihatBarang(kode)); 
    }
    
    public void editBarang(String[] data){
        ModelBarang model = new ModelBarang(); 
        model.editBarang(data);
    }
    
    public void deleteBarang(String id){
        ModelBarang model = new ModelBarang(); 
        model.deleteBarang(id);  
    }
    
}
