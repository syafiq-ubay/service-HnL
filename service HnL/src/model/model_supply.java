/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author SyafiqUbai
 */
public class model_supply {
    
    private String kode_supply;
    private model_supplier supplier;
    private Date tgl_supply;
    private Long total_supply;
    private String status;

    public String getKode_supply() {
        return kode_supply;
    }

    public void setKode_supply(String kode_supply) {
        this.kode_supply = kode_supply;
    }

    public model_supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(model_supplier supplier) {
        this.supplier = supplier;
    }

    public Date getTgl_supply() {
        return tgl_supply;
    }

    public void setTgl_supply(Date tgl_supply) {
        this.tgl_supply = tgl_supply;
    }

    public Long getTotal_supply() {
        return total_supply;
    }

    public void setTotal_supply(Long total_supply) {
        this.total_supply = total_supply;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
