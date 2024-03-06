/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_supply;

/**
 *
 * @author SyafiqUbai
 */
public class table_supply extends AbstractTableModel {

    private List<model_supply> list = new ArrayList<>();

    public void tambahData(model_supply mod) {
        list.add(mod);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }

    public void perbaruiData(model_supply mod) {
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

    public void setData(List<model_supply> List) {
        clear();
        this.list.addAll(List);
        fireTableDataChanged();
    }

    public void setData(int index, model_supply mod) {
        list.set(index, mod);
        fireTableRowsUpdated(index, index);
    }

    public model_supply getData(int index) {
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

            case 0: return list.get(rowIndex).getKode_supply();
            case 1: return list.get(rowIndex).getTgl_supply();
            case 2: return list.get(rowIndex).getTotal_supply();
            case 3: return list.get(rowIndex).getSupplier().getId_supplier();
            case 4: return list.get(rowIndex).getStatus();

            default: return null;

        }

    }

    public String getColumnName(int column) {
        switch (column) {
            case 0 : return  "Kode Supply";
            case 1 : return  "Tanggal";
            case 2 : return  "Total Pemesanan";
            case 3 : return  "Id Supplier";
            case 4 : return  "Status";
        
            default : return null;
        }
        
    }

}
