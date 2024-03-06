/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_detailSupply;

/**
 *
 * @author SyafiqUbai
 */
public class table_detailSupply extends AbstractTableModel{
    
    private List<model_detailSupply> list = new ArrayList<>();
    
    public void tambahData(model_detailSupply mod){
        list.add(mod);
        fireTableRowsInserted(list.size()-1, list.size()-1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }
    
    public void perbaruiData (model_detailSupply mod){
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
    
    public void setData(List<model_detailSupply> List){
        clear();
        this.list.addAll(List);
        fireTableDataChanged();
    }
    public void setData(int index, model_detailSupply mod){
        list.set(index, mod);
        fireTableRowsUpdated(index, index);
    }
    
    public model_detailSupply getData(int index){
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
                    
                case 0 : return list.get(rowIndex).getSupply().getKode_supply();
                case 1 : return list.get(rowIndex).getOnderdil().getKode_onderdil();
                case 2 : return list.get(rowIndex).getOnderdil().getNama_onderdil();
                case 3 : return list.get(rowIndex).getOnderdil().getHarga_onderdil();
                case 4 : return list.get(rowIndex).getJmh_supply();
                case 5 : return list.get(rowIndex).getSubtotal_detailsupply();

                default : return null;
            
        }
            
            
    }
    
    public String getColumnName(int column){
        switch (column) {
            case 0 : return  "Kode Supply";
            case 1 : return  "Kode Onderdil";
            case 2 : return  "Nama Onderdil";
            case 3 : return  "Harga Onderdil";
            case 4 : return  "Jumlah Supply";
            case 5 : return  "SubTotal";
        
            default : return null;
        }
    }
    
}
