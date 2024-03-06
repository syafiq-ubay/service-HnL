/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_onderdil;

/**
 *
 * @author Asus
 */
 public class table_onderdil extends AbstractTableModel{

    private List<model_onderdil> list = new ArrayList<>();
    
    public void tambahData(model_onderdil mod){
        list.add(mod);
        fireTableRowsInserted(list.size()-1, list.size()-1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }
    public void perbaruiData(int row,model_onderdil mod){
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
    public void setData(List<model_onderdil>list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    public void setData(int index, model_onderdil mod){
        list.set(index, mod);
        fireTableRowsUpdated(index, index);
    }
    public model_onderdil getData(int index){
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
       return list.size();
    }
    private final String[] columnNames = {"NO", "Kode Onderdil", "KodeJenis", "Type Jenis", "Nama Jenis","Nama Onderdil","Stok","Harga","ID supplier","Toko Supplier"};

    @Override
    public int getColumnCount() {
       return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0){
            return "    " + (rowIndex + 1);
        }else{
            
        
        switch (columnIndex-1){
            case 0 : return list.get(rowIndex).getKode_onderdil();
            case 1 : return list.get(rowIndex).getJns_onderdil().getKode_jenis();
            case 2 : return list.get(rowIndex).getJns_onderdil().getType_jenis();
            case 3 : return list.get(rowIndex).getJns_onderdil().getNama_jenis();
            case 4 : return list.get(rowIndex).getNama_onderdil();
            case 5 : return list.get(rowIndex).getStok();
            case 6 : return list.get(rowIndex).getHarga_onderdil();
            case 7 : return list.get(rowIndex).getSupplier().getId_supplier();
            case 8 : return list.get(rowIndex).getSupplier().getToko_supplier();
           
            
            
            default : return null;
        }
       
    }
    }
    
    @Override
   public String getColumnName(int column){
       if(column == 0){
           return "    " + columnNames[column];
       }else{
           return columnNames[column];
       }
       }
   }
