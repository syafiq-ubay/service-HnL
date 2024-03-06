/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.model_detailService;

/**
 *
 * @author SyafiqUbai
 */
public interface service_detailService {
    void tambahData(model_detailService mod_det);
    List<model_detailService> getByID(String id);
    List<model_detailService> ambilData();
}
