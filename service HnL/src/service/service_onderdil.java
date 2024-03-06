           /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.model_jenisOnderdil;
import model.model_onderdil;

/**
 *
 * @author Asus
 */
public interface service_onderdil {
    void tambahData(model_onderdil modOnd);
    void perbaruiData(model_onderdil modOnd);
    void hapusData(model_onderdil modOnd);
    void exportToExcel(List<model_onderdil> data, String filePath);
    void importFromExcel(List<model_onderdil> data, String filePath);
    
    List<model_onderdil> getData();
    List<model_onderdil> getDataByID(String id);
    
    List<model_onderdil> pencarian(String id);
    String nomor1();
    
    
}
