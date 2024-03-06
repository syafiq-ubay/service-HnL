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
public class model_pembayaranSupply {
    private String id_pembayaransupply;
    private model_supply modSupply;
    private Date tgl_pembayaransupply;

    public String getId_pembayaransupply() {
        return id_pembayaransupply;
    }

    public void setId_pembayaransupply(String id_pembayaransupply) {
        this.id_pembayaransupply = id_pembayaransupply;
    }

    public model_supply getModSupply() {
        return modSupply;
    }

    public void setModSupply(model_supply modSupply) {
        this.modSupply = modSupply;
    }

    public Date getTgl_pembayaransupply() {
        return tgl_pembayaransupply;
    }

    public void setTgl_pembayaransupply(Date tgl_pembayaransupply) {
        this.tgl_pembayaransupply = tgl_pembayaransupply;
    }
}
