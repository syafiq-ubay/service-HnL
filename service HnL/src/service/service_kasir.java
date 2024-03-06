/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.model_kasir;

/**
 *
 * @author SyafiqUbai
 */
public interface service_kasir {
    void tambahData(model_kasir modKas);
    void hapusData(model_kasir modKas);
    void ubahData(model_kasir modKas);
    
    model_kasir getByID(String id);
    
    List<model_kasir> ambilData();
    
    List<model_kasir> pencarianData(String id);
    
    String nomor();
}
