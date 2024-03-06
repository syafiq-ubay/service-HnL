/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author SyafiqUbai
 */
public class model_detailSupply {
    
    private model_supply Supply;
    private model_onderdil Onderdil;
    private Integer jmh_supply;
    private Long subtotal_detailsupply;

    public model_supply getSupply() {
        return Supply;
    }

    public void setSupply(model_supply Supply) {
        this.Supply = Supply;
    }

    public model_onderdil getOnderdil() {
        return Onderdil;
    }

    public void setOnderdil(model_onderdil Onderdil) {
        this.Onderdil = Onderdil;
    }

    public Integer getJmh_supply() {
        return jmh_supply;
    }

    public void setJmh_supply(Integer jmh_supply) {
        this.jmh_supply = jmh_supply;
    }

    public Long getSubtotal_detailsupply() {
        return subtotal_detailsupply;
    }

    public void setSubtotal_detailsupply(Long subtotal_detailsupply) {
        this.subtotal_detailsupply = subtotal_detailsupply;
    }
}
