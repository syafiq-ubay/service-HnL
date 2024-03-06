/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import javax.swing.JPanel;

/**
 *
 * @author SyafiqUbai
 */
public interface service_laporan {
    void lapTranPes (String no);
    void lapTranSup (String no);
    
    void lapDataOnderdil (JPanel jp);
    void lapTransaksiPerOnderdilan (JPanel jp, String kode);
    void lapTransaksiPesanan (JPanel jp, String date1, String date2);
    void lapTransaksiSupplay (JPanel jp, String date1, String date2);
    
    void lapTransaksiPenjual (JPanel jp, String date1, String date2);
    void lapTransaksiPerPenjual (JPanel jp, String id);
}
