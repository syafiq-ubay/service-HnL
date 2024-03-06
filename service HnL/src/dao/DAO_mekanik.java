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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import model.model_mekanik;
import service.service_mekanik;

/**
 *
 * @author SyafiqUbai
 */
public class DAO_mekanik implements service_mekanik{
    
    private Connection conn;
    
    public DAO_mekanik(){
        conn = koneksi.getConnection();
    }
    @Override
    public void tambahData(model_mekanik modMek) {
        PreparedStatement st = null;
        String sql = "INSERT INTO public.mekanik(id_mekanik, nama_mekanik, telp_mekanik, email_mekanik, alamat_mekanik)VALUES (?, ?, ?, ?, ?);";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, modMek.getId_mekanik());
            st.setString(2, modMek.getNama_mekanik());
            st.setString(3, modMek.getTelp_mekanik());
            st.setString(4, modMek.getEmail_mekanik());
            st.setString(5, modMek.getAlamat_mekanik());

            
            st.executeUpdate();
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_mekanik.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_mekanik.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }}

    @Override
    public void hapusData(model_mekanik modMek) {
        PreparedStatement st = null;
        String sql = "DELETE FROM mekanik WHERE id_mekanik = ?";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, modMek.getId_mekanik());
            
            st.executeUpdate();
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_mekanik.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_mekanik.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }}

    @Override
    public void ubahData(model_mekanik modMek) {
        PreparedStatement st = null;
        String sql = "UPDATE mekanik SET nama_mekanik = ?, telp_mekanik =?, email_mekanik = ?, alamat_mekanik = ? "
                +"WHERE id_mekanik = '"+modMek.getId_mekanik()+"'";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, modMek.getNama_mekanik());
            st.setString(2, modMek.getTelp_mekanik());
            st.setString(3, modMek.getEmail_mekanik());
            st.setString(4, modMek.getAlamat_mekanik());
            
            st.executeUpdate();
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_mekanik.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_mekanik.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
    }

    @Override
    public model_mekanik getByID(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        model_mekanik mod = new model_mekanik();
        String sql = "SELECT * FROM mekanik WHERE id_mekanik LIKE '"+id+"%' LIMIT 1";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                mod.setId_mekanik(rs.getString("id_mekanik"));
                mod.setNama_mekanik(rs.getString("nama_mekanik"));
                mod.setTelp_mekanik(rs.getString("telp_mekanik"));
                mod.setEmail_mekanik(rs.getString("email_mekanik"));
                mod.setAlamat_mekanik(rs.getString("alamat_mekanik"));
   
            }
            return mod;
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_mekanik.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_mekanik.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }}

    @Override
    public List<model_mekanik> ambilData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM mekanik ORDER BY id_mekanik ASC";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                model_mekanik mod = new model_mekanik();
                
                mod.setId_mekanik(rs.getString("id_mekanik"));
                mod.setNama_mekanik(rs.getString("nama_mekanik"));
                mod.setTelp_mekanik(rs.getString("telp_mekanik"));
                mod.setEmail_mekanik(rs.getString("email_mekanik"));
                mod.setAlamat_mekanik(rs.getString("alamat_mekanik"));
                
                list.add(mod);
            }
            return list;
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_mekanik.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_mekanik.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }}

    @Override
    public List<model_mekanik> pencarianData(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM mekanik WHERE (LOWER(id_mekanik) LIKE LOWER('"+id+"%') OR LOWER(nama_mekanik) LIKE LOWER('"+id+"%') OR LOWER(telp_mekanik) LIKE LOWER('"+id+"%') OR LOWER(email_mekanik) LIKE LOWER('"+id+"%'))";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                model_mekanik mod = new model_mekanik();
                
                mod.setId_mekanik(rs.getString("id_mekanik"));
                mod.setNama_mekanik(rs.getString("nama_mekanik"));
                mod.setTelp_mekanik(rs.getString("telp_mekanik"));
                mod.setEmail_mekanik(rs.getString("email_mekanik"));
                mod.setAlamat_mekanik(rs.getString("alamat_mekanik"));
                
                list.add(mod);
            }
            return list;
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_mekanik.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_mekanik.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }}

    @Override
    public String nomor() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String urutan = null;
        
        Date now = new Date();
        SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat nonformat = new SimpleDateFormat("MM");
        String tgl = tanggal.format(now);
        String no = nonformat.format(now);
        
        String sql = "SELECT RIGHT (id_mekanik, 3) AS nomor "
                +"FROM mekanik "
                +"WHERE id_mekanik LIKE 'MK"+no+"%' "
                +"ORDER BY id_mekanik DESC LIMIT 1";
        
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                int nomor1 = Integer.parseInt(rs.getString("nomor"));
                nomor1++;
                urutan = "MK"+no+String.format("%03d", nomor1);
            } else {
                urutan = "MK"+no+"001";
            }
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_mekanik.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_mekanik.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
        return urutan;
    }
}    
