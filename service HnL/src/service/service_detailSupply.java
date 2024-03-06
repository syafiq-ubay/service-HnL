/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.model_detailSupply;

/**
 *
 * @author fatiq
 */
public interface service_detailSupply {
    void tambahData(model_detailSupply mod_det);
    List<model_detailSupply> getByID(String id);
    List<model_detailSupply> getData();
}
