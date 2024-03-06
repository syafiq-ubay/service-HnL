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
public class model_pembayaranService {
    private String id_pembayaranservice;
    private model_service modService;
    private model_kasir modKa;
    private Date tgl_pembayaranservice;
    private String status_pembayaran;
    private Long kurang_bayar;
    private Long sudah_bayar;

    public String getId_pembayaranservice() {
        return id_pembayaranservice;
    }

    public void setId_pembayaranservice(String id_pembayaranservice) {
        this.id_pembayaranservice = id_pembayaranservice;
    }

    public model_service getModService() {
        return modService;
    }

    public void setModService(model_service modService) {
        this.modService = modService;
    }

    public model_kasir getModKa() {
        return modKa;
    }

    public void setModKa(model_kasir modKa) {
        this.modKa = modKa;
    }

    public Date getTgl_pembayaranservice() {
        return tgl_pembayaranservice;
    }

    public void setTgl_pembayaranservice(Date tgl_pembayaranservice) {
        this.tgl_pembayaranservice = tgl_pembayaranservice;
    }

    public String getStatus_pembayaran() {
        return status_pembayaran;
    }

    public void setStatus_pembayaran(String status_pembayaran) {
        this.status_pembayaran = status_pembayaran;
    }

    public Long getKurang_bayar() {
        return kurang_bayar;
    }

    public void setKurang_bayar(Long kurang_bayar) {
        this.kurang_bayar = kurang_bayar;
    }

    public Long getSudah_bayar() {
        return sudah_bayar;
    }

    public void setSudah_bayar(Long sudah_bayar) {
        this.sudah_bayar = sudah_bayar;
    }
}
