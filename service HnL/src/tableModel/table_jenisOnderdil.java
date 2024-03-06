/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_jenisOnderdil;

/**
 *
 * @author Asus
 */
public class table_jenisOnderdil extends AbstractTableModel{
    private List<model_jenisOnderdil> list = new ArrayList<>();
    
    public void tambahData(model_jenisOnderdil mod){
        list.add(mod);
        fireTableRowsInserted(list.size()-1, list.size()-1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }
    public void perbaruiData(model_jenisOnderdil mod){
        list.add(mod);
        fireTableDataChanged();
        JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
    }
    public void hapusData(int index){
        list.remove(index);
        fireTableRowsDeleted(index, index);
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
    }
    public void clear(){
        list.clear();
        fireTableDataChanged();
    }
    public void setData(List<model_jenisOnderdil>list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    public void setData(int index, model_jenisOnderdil mod){
        list.set(index, mod);
        fireTableRowsUpdated(index, index);
    }
    public model_jenisOnderdil getData(int index){
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
       return list.size();
    }

    @Override
    public int getColumnCount() {
       return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0 : return list.get(rowIndex).getKode_jenis();
            case 1 : return list.get(rowIndex).getType_jenis();
            case 2 : return list.get(rowIndex).getNama_jenis();   
            default : return null;
        }
       
    }
    
    public String getColumnName(int column){
        switch (column){
            case 0 : return "Kode Jenis";
            case 1 : return "type_jenis";
            case 2 : return "Nama Jenis"; 
            default : return null;        
        }
    } 
    
}
