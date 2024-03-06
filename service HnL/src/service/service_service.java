/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.model_service;

/**
 *
 * @author SyafiqUbai
 */
public interface service_service {
    void tambahData(model_service modSer);
    void hapusData(model_service modSer);
    
    List<model_service> getByID(String id);
    List<model_service> ambilData();
    List<model_service> pencarianData(String id);
    String nomor();
}
