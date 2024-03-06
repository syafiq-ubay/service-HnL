/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_pembayaranService;

/**
 *
 * @author SyafiqUbai
 */
public class table_pembayaranService extends AbstractTableModel{
    private List<model_pembayaranService> list = new ArrayList<>();
    
    public void tambahData(model_pembayaranService mod) {
        list.add(mod);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }

    public void perbaruiData(model_pembayaranService mod) {
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

    public void setData(List<model_pembayaranService> List) {
        clear();
        this.list.addAll(List);
        fireTableDataChanged();
    }

    public void setData(int index, model_pembayaranService mod) {
        list.set(index, mod);
        fireTableRowsUpdated(index, index);
    }

    public model_pembayaranService getData(int index) {
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }
    
    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return list.get(rowIndex).getId_pembayaranservice();
            case 1: return list.get(rowIndex).getModService().getKode_service();
            case 2: return list.get(rowIndex).getModKa().getId_kasir();
            case 3: return list.get(rowIndex).getModKa().getNama_kasir();
            case 4: return list.get(rowIndex).getModService().getTotal();
            case 5: return list.get(rowIndex).getSudah_bayar();
            case 6: return list.get(rowIndex).getKurang_bayar();
            case 7: return list.get(rowIndex).getTgl_pembayaranservice();
            case 8: return list.get(rowIndex).getStatus_pembayaran();
            default: return null;

        }
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0 : return  "Kode Pembayaran";
            case 1 : return  "Kode Service";
            case 2 : return  "ID Kasir";
            case 3 : return  "Nama Kasir";
            case 4 : return  "Total";
            case 5 : return  "Sudah Bayar";
            case 6 : return  "Kurang Bayar";
            case 7 : return  "Tgl Pembayaran";
            case 8 : return  "Status";
        
            default : return null;
        }
        
    }
}