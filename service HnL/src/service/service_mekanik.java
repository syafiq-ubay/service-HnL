/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.model_mekanik;

/**
 *
 * @author SyafiqUbai
 */
public interface service_mekanik {
    void tambahData(model_mekanik modMek);
    void hapusData(model_mekanik modMek);
    void ubahData(model_mekanik modMek);
    
    model_mekanik getByID(String id);
    
    List<model_mekanik> ambilData();
    
    List<model_mekanik> pencarianData(String id);
    
    String nomor();
    
}
