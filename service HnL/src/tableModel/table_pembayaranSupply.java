/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_pembayaranSupply;

/**
 *
 * @author SyafiqUbai
 */
public class table_pembayaranSupply extends AbstractTableModel{
    
    private List<model_pembayaranSupply> list = new ArrayList<>();

    public void tambahData(model_pembayaranSupply mod) {
        list.add(mod);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }

    public void perbaruiData(model_pembayaranSupply mod) {
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

    public void setData(List<model_pembayaranSupply> List) {
        clear();
        this.list.addAll(List);
        fireTableDataChanged();
    }

    public void setData(int index, model_pembayaranSupply mod) {
        list.set(index, mod);
        fireTableRowsUpdated(index, index);
    }

    public model_pembayaranSupply getData(int index) {
        return list.get(index);
    }
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return list.get(rowIndex).getId_pembayaransupply();
            case 1: return list.get(rowIndex).getModSupply().getKode_supply();
            case 2: return list.get(rowIndex).getModSupply().getTotal_supply();
            case 3: return list.get(rowIndex).getTgl_pembayaransupply();
            case 4: return list.get(rowIndex).getModSupply().getStatus();
            default: return null;

        }
    }
    
    public String getColumnName(int column) {
        switch (column) {
            case 0 : return  "Kode Pembayaran";
            case 1 : return  "Kode Supply";
            case 2 : return  "Total Supply";
            case 3 : return  "Tgl Pembayaran";
            case 4 : return  "Status";
        
            default : return null;
        }
        
    }
    
}
