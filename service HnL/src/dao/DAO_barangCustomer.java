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
import model.model_barangcus;
import tableModel.table_barangcus;
import service.service_barangCustomer;

/**
 *
 * @author SyafiqUbai
 */
    public class DAO_barangCustomer implements service_barangCustomer{

    private Connection conn;
    
    public DAO_barangCustomer(){
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(model_barangcus modCus) {
        PreparedStatement st = null;
        String sql = "INSERT INTO public.barang_customer(kode_barang, type_barang, nama_barang, nama_customer, telp_customer)VALUES (?, ?, ?, ?, ?)";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, modCus.getKode_barang());
            st.setString(2, modCus.getType_barang());
            st.setString(3, modCus.getNama_barang());
            st.setString(4, modCus.getNama_customer());
            st.setString(5,modCus.getTelp_customer());
            
            
            st.executeUpdate();
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_barangCustomer.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_barangCustomer.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
    }

    @Override
    public void hapusData(model_barangcus modCus) {
        PreparedStatement st = null;
        String sql = "DELETE FROM barang_customer WHERE kode_barang = ?";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, modCus.getKode_barang());
            
            st.executeUpdate();
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_barangCustomer.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_barangCustomer.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
    }

    @Override
    public void ubahData(model_barangcus modCus) {
        PreparedStatement st = null;
        String sql = "UPDATE barang_customer SET type_barang = ?, nama_barang =?, nama_customer = ?, telp_customer = ? "
                +"WHERE kode_barang = '"+modCus.getKode_barang()+"'";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, modCus.getType_barang());
            st.setString(2, modCus.getNama_barang());
            st.setString(3, modCus.getNama_customer());
            st.setString(4,modCus.getTelp_customer());
            
            st.executeUpdate();
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_barangCustomer.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_barangCustomer.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
    }

    @Override
    public model_barangcus getByID(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM barang_customer  "
                +"WHERE kode_barang LIKE '"+id+"%' LIMIT 1";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            model_barangcus mod = new model_barangcus();
            
            while(rs.next()){
                mod.setKode_barang(rs.getString("kode_barang"));
                mod.setType_barang(rs.getString("type_barang"));
                mod.setNama_barang(rs.getString("nama_barang"));
                mod.setNama_customer(rs.getString("nama_customer"));
                mod.setTelp_customer(rs.getString("telp_customer"));
            }
            return mod;
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_barangCustomer.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_barangCustomer.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
    }

    @Override
    public List<model_barangcus> ambilData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM barang_customer ORDER BY kode_barang ASC";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                model_barangcus mod = new model_barangcus();
                                
                mod.setKode_barang(rs.getString("kode_barang"));
                mod.setType_barang(rs.getString("type_barang"));
                mod.setNama_barang(rs.getString("nama_barang")) ;
                mod.setNama_customer(rs.getString("nama_customer"));
                mod.setTelp_customer(rs.getString("telp_customer"));
                list.add(mod);
            }
            return list;
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_barangCustomer.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_barangCustomer.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
    }

    @Override
    public List<model_barangcus> pencarianData(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
     
        String sql = "SELECT * FROM barang_customer WHERE (LOWER(kode_barang) LIKE LOWER('"+id+"%') OR LOWER(type_barang) LIKE LOWER('"+id+"%') OR LOWER(nama_customer) LIKE LOWER('"+id+"%') OR LOWER(nama_barang) LIKE LOWER('"+id+"%') OR LOWER(telp_customer) LIKE LOWER('"+id+"%'));";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                model_barangcus mod = new model_barangcus();
                
                mod.setKode_barang(rs.getString("kode_barang"));
                mod.setType_barang(rs.getString("type_barang"));
                mod.setNama_barang(rs.getString("nama_barang"));
                mod.setNama_customer(rs.getString("nama_customer"));
                mod.setTelp_customer(rs.getString("telp_customer"));
                
                list.add(mod);
            }
            return list;
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_barangCustomer.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_barangCustomer.class.getName()).log(Level.SEVERE,null,ex);
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
        
        String sql = "SELECT RIGHT (kode_barang, 3) AS nomor "
                +"FROM barang_customer "
                +"WHERE kode_barang LIKE 'BR"+no+"%' "
                +"ORDER BY kode_barang DESC LIMIT 1";
        
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                int nomor1 = Integer.parseInt(rs.getString("nomor"));
                nomor1++;
                urutan = "BR"+no+String.format("%03d", nomor1);
            } else {
                urutan = "BR"+no+"001";
            }
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_barangCustomer.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_barangCustomer.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
        return urutan;
    }
    } 
