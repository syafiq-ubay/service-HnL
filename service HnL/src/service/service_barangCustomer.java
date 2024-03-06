/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.model_barangcus;

/**
 *
 * @author SyafiqUbai
 */
public interface service_barangCustomer {
    void tambahData(model_barangcus modCus);
    void hapusData(model_barangcus modCus);
    void ubahData(model_barangcus modCus);
    
    model_barangcus getByID(String id);
    
    List<model_barangcus> ambilData();
    
    List<model_barangcus> pencarianData(String id);
    
    String nomor();
}
