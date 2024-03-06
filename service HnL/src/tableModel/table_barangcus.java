/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_barangcus;

/**
 *
 * @author SyafiqUbai
 */
public class table_barangcus extends AbstractTableModel{

    private List<model_barangcus> list = new ArrayList<>();
    
    public void tambahData (model_barangcus modCus){
        list.add(modCus);
        fireTableRowsInserted(list.size()-1, list.size()-1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }
    
    public void perbaruiData (model_barangcus modCus){
        fireTableDataChanged();
        JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
    }
    
    public void hapusData (int index){
        list.remove(index);
        fireTableRowsDeleted(index, index);
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
    }
    
    public void clear (){
        list.clear();
        fireTableDataChanged();
    }
    
    public void setData(List<model_barangcus> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    
    public void setData(int index, model_barangcus modCus){
        list.set(index, modCus);
        fireTableRowsUpdated(index, index);
    }
    
    public model_barangcus getData (int index){
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    private final String[] numName = {"No", "Kode Barang", "Type Barang", "Nama Barang", "Nama Customer", "No.telp"};
    
    @Override
    public int getColumnCount() {
        return numName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0){
            return "   "+ (rowIndex +1);
        } else {
            switch (columnIndex-1){
                case 0 : return list.get(rowIndex).getKode_barang();
                case 1 : return list.get(rowIndex).getType_barang();
                case 2 : return list.get(rowIndex).getNama_barang();
                case 3 : return list.get(rowIndex).getNama_customer();
                case 4 : return list.get(rowIndex).getTelp_customer();
                default : return null;
            }
        }
    }
    
    @Override
    public String getColumnName(int column){
        if (column == 0){
            return "   "+numName[column];
        } else {
            return numName[column];
        }
    }
    
}
