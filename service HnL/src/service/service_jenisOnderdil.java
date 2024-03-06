/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.model_jenisOnderdil;

/**
 *
 * @author Asus
 */
public interface service_jenisOnderdil {
    
    void tambahData(model_jenisOnderdil mod_jenbar);
    void hapusData(model_jenisOnderdil mod_jenbar);
    void ubahData(model_jenisOnderdil mod_jenbar);
    void exportToExcel(List<model_jenisOnderdil> data, String filePath);
    void importFromExcel(List<model_jenisOnderdil> data, String filePath);
   
    model_jenisOnderdil getByid(String id);
    
    public List<model_jenisOnderdil> getData();
    List<model_jenisOnderdil> pencarianData(String id);
    
    String nomor();
    
    boolean validasiNamaJenisBarang(model_jenisOnderdil mod_jenbar);

    
    
    
}
