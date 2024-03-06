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
public class model_service {
    private String kode_service;
    private model_mekanik moMek;
    private model_barangcus barangcus;
    private Date tgl_service;
    private Long harga_service;
    private Long total;
    private String keterangan;
    private String status;

    public String getKode_service() {
        return kode_service;
    }

    public void setKode_service(String kode_service) {
        this.kode_service = kode_service;
    }

    public model_mekanik getMoMek() {
        return moMek;
    }

    public void setMoMek(model_mekanik moMek) {
        this.moMek = moMek;
    }

    public model_barangcus getBarangcus() {
        return barangcus;
    }

    public void setBarangcus(model_barangcus barangcus) {
        this.barangcus = barangcus;
    }

    public Date getTgl_service() {
        return tgl_service;
    }

    public void setTgl_service(Date tgl_service) {
        this.tgl_service = tgl_service;
    }

    public Long getHarga_service() {
        return harga_service;
    }

    public void setHarga_service(Long harga_service) {
        this.harga_service = harga_service;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
