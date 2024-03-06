/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_service;

/**
 *
 * @author SyafiqUbai
 */
public class table_service extends AbstractTableModel{
    
    private List<model_service> list = new ArrayList<>();
    
    public void tambahData(model_service mod) {
        list.add(mod);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }

    public void perbaruiData(model_service mod) {
        fireTableDataChanged();
        JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
    }

    public void hapusData(int index) {
        list.remove(index);
        fireTableRowsDeleted(index, index);
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
    }

    public void clear() {
        list.clear();
        fireTableDataChanged();
    }

    public void setData(List<model_service> List) {
        clear();
        this.list.addAll(List);
        fireTableDataChanged();
    }

    public void setData(int index, model_service mod) {
        list.set(index, mod);
        fireTableRowsUpdated(index, index);
    }

    public model_service getData(int index) {
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {

            case 0: return list.get(rowIndex).getKode_service();
            case 1: return list.get(rowIndex).getMoMek().getId_mekanik();
            case 2: return list.get(rowIndex).getBarangcus().getKode_barang();
            case 3: return list.get(rowIndex).getBarangcus().getNama_customer();
            case 4: return list.get(rowIndex).getTgl_service();
            case 5: return list.get(rowIndex).getHarga_service();
            case 6: return list.get(rowIndex).getTotal();
            case 7: return list.get(rowIndex).getKeterangan();

            default: return null;

        }
    }
    
    public String getColumnName(int column) {
        switch (column) {
            case 0 : return  "Kode Service";
            case 1 : return  "ID Mekanik";
            case 2 : return  "Barang Customer";
            case 3 : return  "Nama Customer";
            case 4 : return  "Tgl Service";
            case 5 : return  "Harga Service";
            case 6 : return  "Total";
            case 7 : return  "Keterangan";
        
            default : return null;
        }
        
    }
}
