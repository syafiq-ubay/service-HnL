/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.model_pembayaranService;

/**
 *
 * @author SyafiqUbai
 */
public interface service_pembayaranService {
    void tambahData(model_pembayaranService pemSer);
    void hapusData(model_pembayaranService pemSer);
    void ubahData(model_pembayaranService pemSer);
    
    model_pembayaranService getByID(String id);
    List<model_pembayaranService> getData();
    List<model_pembayaranService> pencarianData(String id);
    String nomor();
}
