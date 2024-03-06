/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.model_pembayaranSupply;
/**
 *
 * @author SyafiqUbai
 */
public interface service_pembayaranSupply {
    void tambahData(model_pembayaranSupply pemSub);
    void hapusData(model_pembayaranSupply pemSub);
    void ubahData(model_pembayaranSupply pemSub);
    
    model_pembayaranSupply getByID(String id);
    List<model_pembayaranSupply> getData();
    List<model_pembayaranSupply> pencarianData(String id);
    String nomor();
}
