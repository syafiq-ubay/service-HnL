/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.model_supply;

/**
 *
 * @author SyafiqUbai
 */
public interface service_supply {
    void tambahData(model_supply modSpl);
    void hapusData(model_supply modSpl);
    void ubahData(model_supply modSpl);
    
    List<model_supply> getByID(String id);
    List<model_supply> getData();
    List<model_supply> pencarianData(String id);
    String nomor();
}
