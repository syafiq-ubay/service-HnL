    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import config.koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import model.model_detailSupply;
import model.model_onderdil;
import model.model_supply;
import service.service_detailSupply;

/**
 *
 * @author SyafiqUbai
 */
public class DAO_detailSupply implements service_detailSupply{
    
    private Connection conn;
    
    public DAO_detailSupply() {
        conn = koneksi.getConnection();
    }
    
    @Override
    public void tambahData(model_detailSupply mod_det) {
        PreparedStatement st = null;
        String sql = "INSERT INTO public.detail_supply(kode_supply, kode_onderdil, jmh_supply, subtotal_detailsupply)VALUES (?, ?, ?, ?)";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, mod_det.getSupply().getKode_supply());
            st.setString(2, mod_det.getOnderdil().getKode_onderdil());
            st.setInt(3, mod_det.getJmh_supply());
            st.setLong(4, mod_det.getSubtotal_detailsupply());
            
            st.executeUpdate();
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_detailSupply.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_detailSupply.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
    }

    @Override
    public List<model_detailSupply> getByID(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT det_sp.kode_supply, det_sp.kode_onderdil, o.nama_onderdil, "
                +"o.harga_onderdil, det_sp.jmh_supply, det_sp.subtotal_detailsupply "
                +"FROM detail_supply det_sp "
                +"INNER JOIN supply sp ON sp.kode_supply=det_sp.kode_supply "
                +"INNER JOIN onderdil o ON o.kode_onderdil=det_sp.kode_onderdil "
                +"WHERE det_sp.kode_supply = '"+id+"' ORDER BY kode_supply ASC";
//        AND det_sp.status_supply = 'Pending' 
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                model_supply spl = new model_supply();
                model_detailSupply det_sup = new model_detailSupply();
                model_onderdil on = new model_onderdil();
                
                spl.setKode_supply(rs.getString("kode_supply"));
                on.setKode_onderdil(rs.getString("kode_onderdil"));
                on.setNama_onderdil(rs.getString("nama_onderdil"));
                on.setHarga_onderdil(rs.getLong("harga_onderdil"));
                det_sup.setJmh_supply(rs.getInt("jmh_supply"));
                det_sup.setSubtotal_detailsupply(rs.getLong("subtotal_detailsupply"));

//                System.out.println(rs.getString("kode_supply"));
                det_sup.setOnderdil(on);
                det_sup.setSupply(spl);
                list.add(det_sup);
            }
            return list;
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_detailSupply.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_detailSupply.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(rs != null){
                try{
                    rs.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_detailSupply.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
    }

    @Override
    public List<model_detailSupply> getData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
