/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import model.model_detailService;
import model.model_onderdil;
import model.model_service;
import service.service_detailService;

/**
 *
 * @author SyafiqUbai
 */
public class DAO_detailService implements service_detailService{
    
    private Connection conn;
    
    public DAO_detailService() {
        conn = koneksi.getConnection();
    }
    
    @Override
    public void tambahData(model_detailService mod_det) {
         PreparedStatement st = null;
        String sql = "INSERT INTO public.detail_service(kode_service, kode_onderdil, jmh_service, subtotal)VALUES (?, ?, ?, ?)";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, mod_det.getModService().getKode_service());
            st.setString(2, mod_det.getModOnd().getKode_onderdil());
            st.setInt(3, mod_det.getJmh_service());
            st.setLong(4, mod_det.getSubtotal());
            
            st.executeUpdate();
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_detailService.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_detailService.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
    }

    @Override
    public List<model_detailService> getByID(String id) {
         PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT det_ser.kode_service, o.kode_onderdil, o.nama_onderdil, o.harga_onderdil, det_ser.jmh_service, det_ser.subtotal " 
                       +"FROM detail_service det_ser " 
                       +"INNER JOIN service sv ON sv.kode_service=det_ser.kode_service " 
                       +"INNER JOIN onderdil o ON o.kode_onderdil=det_ser.kode_onderdil "
                       +"WHERE det_ser.kode_service = '"+id+"' ORDER BY kode_service ASC";
                       //AND det_sp.status_supply = 'Pending' 
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                model_service sv = new model_service();
                model_detailService det_ser = new model_detailService();
                model_onderdil on = new model_onderdil();
                
                sv.setKode_service              (rs.getString("kode_service"));
                on.setKode_onderdil             (rs.getString("kode_onderdil"));
                on.setNama_onderdil             (rs.getString("nama_onderdil"));
                on.setHarga_onderdil            (rs.getLong("harga_onderdil"));
                det_ser.setJmh_service          (rs.getInt("jmh_service"));
                det_ser.setSubtotal             (rs.getLong("subtotal"));

//                System.out.println(rs.getString("kode_supply"));
                det_ser.setModService(sv);
                det_ser.setModOnd(on);
                list.add(det_ser);
            }
            return list;
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_detailService.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_detailService.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(rs != null){
                try{
                    rs.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_detailService.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
    }

    @Override
    public List<model_detailService> ambilData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
