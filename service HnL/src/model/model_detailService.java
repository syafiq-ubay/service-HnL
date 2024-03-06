/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author SyafiqUbai
 */
public class model_detailService {
    private model_service modService;
    private model_onderdil modOnd;
    private Integer jmh_service;
    private Long subtotal;

    public model_service getModService() {
        return modService;
    }

    public void setModService(model_service modService) {
        this.modService = modService;
    }

    public model_onderdil getModOnd() {
        return modOnd;
    }

    public void setModOnd(model_onderdil modOnd) {
        this.modOnd = modOnd;
    }

    public Integer getJmh_service() {
        return jmh_service;
    }

    public void setJmh_service(Integer jmh_service) {
        this.jmh_service = jmh_service;
    }

    public Long getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Long subtotal) {
        this.subtotal = subtotal;
    }
}
