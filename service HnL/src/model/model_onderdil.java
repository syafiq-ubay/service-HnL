/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Asus
 */
public class model_onderdil {
 
    private String kode_onderdil;
    private model_jenisOnderdil jns_onderdil;
    private String nama_onderdil;
    private Integer stok;
    private Long harga_onderdil;
    private model_supplier supplier;

    public model_supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(model_supplier supplier) {
        this.supplier = supplier;
    }

    public String getKode_onderdil() {
        return kode_onderdil;
    }

    public void setKode_onderdil(String kode_onderdil) {
        this.kode_onderdil = kode_onderdil;
    }

    public model_jenisOnderdil getJns_onderdil() {
        return jns_onderdil;
    }

    public void setJns_onderdil(model_jenisOnderdil jns_onderdil) {
        this.jns_onderdil = jns_onderdil;
    }

    public String getNama_onderdil() {
        return nama_onderdil;
    }

    public void setNama_onderdil(String nama_onderdil) {
        this.nama_onderdil = nama_onderdil;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public Long getHarga_onderdil() {
        return harga_onderdil;
    }

    public void setHarga_onderdil(Long harga_onderdil) {
        this.harga_onderdil = harga_onderdil;
    }
 
}