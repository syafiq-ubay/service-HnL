/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.model_supplier;

/**
 *
 * @author SyafiqUbai
 */
public interface service_supplier {
    void tambahData(model_supplier modSup);
    void hapusData(model_supplier modSup);
    void ubahData(model_supplier modSup);
    
    model_supplier getByID(String id);
    
    List<model_supplier> ambilData();
    
    List<model_supplier> pencarianData(String id);
    
    String nomor();
}
