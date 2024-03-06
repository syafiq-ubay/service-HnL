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
import model.model_kasir;
import service.service_kasir;

/**
 *
 * @author SyafiqUbai
 */
public class DAO_kasir implements service_kasir{
    
    private Connection conn;
    
    public DAO_kasir(){
        conn = koneksi.getConnection();
    }
    @Override
    public void tambahData(model_kasir modKas) {
        PreparedStatement st = null;
        String sql = "INSERT INTO public.kasir(id_kasir, nama_kasir, telp_kasir, email_kasir, alamat_kasir)VALUES (?, ?, ?, ?, ?);";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, modKas.getId_kasir());
            st.setString(2, modKas.getNama_kasir());
            st.setString(3, modKas.getTelp_kasir());
            st.setString(4, modKas.getEmail_kasir());
            st.setString(5, modKas.getAlamat_kasir());

            
            st.executeUpdate();
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_kasir.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_kasir.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }}

    @Override
    public void hapusData(model_kasir modKas) {
        PreparedStatement st = null;
        String sql = "DELETE FROM kasir WHERE id_kasir = ?";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, modKas.getId_kasir());
            
            st.executeUpdate();
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_kasir.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_kasir.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }}

    @Override
    public void ubahData(model_kasir modKas) {
        PreparedStatement st = null;
        String sql = "UPDATE kasir SET nama_kasir = ?, telp_kasir =?, email_kasir = ?, alamat_kasir = ? "
                +"WHERE id_kasir = '"+modKas.getId_kasir()+"'";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, modKas.getNama_kasir());
            st.setString(2, modKas.getTelp_kasir());
            st.setString(3, modKas.getEmail_kasir());
            st.setString(4, modKas.getAlamat_kasir());
            
            st.executeUpdate();
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_kasir.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_kasir.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
    }

    @Override
    public model_kasir getByID(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        model_kasir mod = new model_kasir();
        String sql = "SELECT * FROM kasir WHERE id_kasir LIKE '"+id+"%' LIMIT 1";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                mod.setId_kasir(rs.getString("id_kasir"));
                mod.setNama_kasir(rs.getString("nama_kasir"));
                mod.setTelp_kasir(rs.getString("telp_kasir"));
                mod.setEmail_kasir(rs.getString("email_ksir"));
                mod.setAlamat_kasir(rs.getString("alamat_kasir"));
   
            }
            return mod;
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_kasir.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_kasir.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }}

    @Override
    public List<model_kasir> ambilData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM kasir ORDER BY id_kasir ASC";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                model_kasir mod = new model_kasir();
                
                mod.setId_kasir(rs.getString("id_kasir"));
                mod.setNama_kasir(rs.getString("nama_kasir"));
                mod.setTelp_kasir(rs.getString("telp_kasir"));
                mod.setEmail_kasir(rs.getString("email_kasir"));
                mod.setAlamat_kasir(rs.getString("alamat_kasir"));
                
                list.add(mod);
            }
            return list;
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_kasir.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_kasir.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }}

    @Override
    public List<model_kasir> pencarianData(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM kasir WHERE (LOWER(id_kasir) LIKE LOWER('"+id+"%') OR LOWER(nama_kasir) LIKE LOWER('"+id+"%') OR LOWER(telp_kasir) LIKE LOWER('"+id+"%') OR LOWER(email_kasir) LIKE LOWER('"+id+"%'))";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                model_kasir mod = new model_kasir();
                
                mod.setId_kasir(rs.getString("id_kasir"));
                mod.setNama_kasir(rs.getString("nama_kasir"));
                mod.setTelp_kasir(rs.getString("telp_kasir"));
                mod.setEmail_kasir(rs.getString("email_kasir"));
                mod.setAlamat_kasir(rs.getString("alamat_kasir"));
                
                list.add(mod);
            }
            return list;
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_kasir.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_kasir.class.getName()).log(Level.SEVERE,null,ex);
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
        
        String sql = "SELECT RIGHT (id_kasir, 3) AS nomor "
                +"FROM kasir "
                +"WHERE id_kasir LIKE 'KS"+no+"%' "
                +"ORDER BY id_kasir DESC LIMIT 1";
        
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                int nomor1 = Integer.parseInt(rs.getString("nomor"));
                nomor1++;
                urutan = "KS"+no+String.format("%03d", nomor1);
            } else {
                urutan = "KS"+no+"001";
            }
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_kasir.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_kasir.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
        return urutan;
    }
}    
