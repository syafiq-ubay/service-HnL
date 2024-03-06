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
import model.model_supplier;
import service.service_supplier;

/**
 *
 * @author SyafiqUbai
 */
public class DAO_supplier implements service_supplier{

    private Connection conn;
    
    public DAO_supplier(){
        conn = koneksi.getConnection();
    }
    
    @Override
    public void tambahData(model_supplier modSup) {
        PreparedStatement st = null;
        String sql = "INSERT INTO public.supplier(id_supplier, nama_supplier, toko_supplier, telp_supplier, alamat_supplier)VALUES (?, ?, ?, ?, ?);";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, modSup.getId_supplier());
            st.setString(2, modSup.getNama_supplier());
            st.setString(3, modSup.getToko_supplier());
            st.setString(4, modSup.getTelp_supplier());
            st.setString(5, modSup.getAlamat_supplier());

            
            st.executeUpdate();
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_supplier.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_supplier.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
    }

    @Override
    public void hapusData(model_supplier modSup) {
        PreparedStatement st = null;
        String sql = "DELETE FROM supplier WHERE id_supplier = ?";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, modSup.getId_supplier());
            
            st.executeUpdate();
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_supplier.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_supplier.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
    }

    @Override
    public void ubahData(model_supplier modSup) {
        PreparedStatement st = null;
        String sql = "UPDATE supplier SET nama_supplier = ?, toko_supplier =?, telp_supplier = ?, alamat_supplier = ? "
                +"WHERE id_supplier = '"+modSup.getId_supplier()+"'";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, modSup.getNama_supplier());
            st.setString(2, modSup.getToko_supplier());
            st.setString(3, modSup.getTelp_supplier());
            st.setString(4, modSup.getAlamat_supplier());
            
            st.executeUpdate();
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_supplier.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_supplier.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
    }

    @Override
    public model_supplier getByID(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        model_supplier mod = new model_supplier();
        String sql = "SELECT * FROM supplier WHERE id_supplier LIKE '"+id+"%' LIMIT 1";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                mod.setId_supplier(rs.getString("id_supplier"));
                mod.setNama_supplier(rs.getString("nama_supplier"));
                mod.setToko_supplier(rs.getString("toko_supplier"));
                mod.setTelp_supplier(rs.getString("telp_supplier"));
                mod.setAlamat_supplier(rs.getString("alamat_supplier"));
   
            }
            return mod;
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_supplier.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_supplier.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
    }

    @Override
    public List<model_supplier> ambilData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM supplier ORDER BY id_supplier ASC";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                model_supplier mod = new model_supplier();
                
                mod.setId_supplier      (rs.getString("id_supplier"));
                mod.setNama_supplier    (rs.getString("nama_supplier"));
                mod.setToko_supplier    (rs.getString("toko_supplier"));
                mod.setTelp_supplier    (rs.getString("telp_supplier"));
                mod.setAlamat_supplier  (rs.getString("alamat_supplier"));
                
                list.add(mod);
            }
            return list;
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_supplier.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_supplier.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
    }

    @Override
    public List<model_supplier> pencarianData(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM supplier WHERE (LOWER(id_supplier) "
                + "LIKE LOWER('"+id+"%') OR LOWER(nama_supplier) "
                + "LIKE LOWER('"+id+"%') OR LOWER(toko_supplier) "
                + "LIKE LOWER('"+id+"%') OR LOWER(alamat_supplier) ";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                model_supplier mod = new model_supplier();
                
                mod.setId_supplier(rs.getString("id_supplier"));
                mod.setNama_supplier(rs.getString("nama_supplier"));
                mod.setToko_supplier(rs.getString("toko_supplier"));
                mod.setTelp_supplier(rs.getString("telp_supplier"));
                mod.setAlamat_supplier(rs.getString("alamat_supplier"));
                
                list.add(mod);
            }
            return list;
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_supplier.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_supplier.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
    }

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
        
        String sql = "SELECT RIGHT (id_supplier, 3) AS nomor "
                +"FROM supplier "
                +"WHERE id_supplier LIKE 'SP"+no+"%' "
                +"ORDER BY id_supplier DESC LIMIT 1";
        
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                int nomor1 = Integer.parseInt(rs.getString("nomor"));
                nomor1++;
                urutan = "SP"+no+String.format("%03d", nomor1);
            } else {
                urutan = "SP"+no+"001";
            }
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_supplier.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_supplier.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
        return urutan;
    }
}
