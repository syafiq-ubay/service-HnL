/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;


import model.model_admin;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface service_admin {
    
    void tambahData(model_admin mod_adm);
    void perbaruiData(model_admin mod_adm);
    void hapusData(model_admin mod_adm);
   
    model_admin getByid(String id);
    
    List<model_admin> getData();
    List<model_admin> pencarian(String id);
    
    String nomor();
}

