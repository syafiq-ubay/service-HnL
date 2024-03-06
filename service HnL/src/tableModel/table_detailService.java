/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_detailService;

/**
 *
 * @author SyafiqUbai
 */
public class table_detailService extends AbstractTableModel{
    
    private List<model_detailService> list = new ArrayList<>();
    
    public void tambahData(model_detailService mod){
        list.add(mod);
        fireTableRowsInserted(list.size()-1, list.size()-1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }
    
    public void perbaruiData (model_detailService mod){
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
    
    public void setData(List<model_detailService> List){
        clear();
        this.list.addAll(List);
        fireTableDataChanged();
    }
    public void setData(int index, model_detailService mod){
        list.set(index, mod);
        fireTableRowsUpdated(index, index);
    }
    
    public model_detailService getData(int index){
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
                    
                case 0 : return list.get(rowIndex).getModService().getKode_service();
                case 1 : return list.get(rowIndex).getModOnd().getKode_onderdil();
                case 2 : return list.get(rowIndex).getModOnd().getNama_onderdil();
                case 3 : return list.get(rowIndex).getModOnd().getHarga_onderdil();
                case 4 : return list.get(rowIndex).getJmh_service();
                case 5 : return list.get(rowIndex).getSubtotal();
                default : return null;
            
        }
    }
    
    public String getColumnName(int column){
        switch (column) {
            case 0 : return  "Kode Service";
            case 1 : return  "Kode Onderdil";
            case 2 : return  "Nama";
            case 3 : return  "Harga";
            case 4 : return  "Jumlah";
            case 5 : return  "Subtotal";
        
            default : return null;
        }
    }
    
}
