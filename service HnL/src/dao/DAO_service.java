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
import model.model_mekanik;
import model.model_service;
import model.model_supplier;
import model.model_supply;
import service.service_service;

/**
 *
 * @author SyafiqUbai
 */
public class DAO_service implements service_service{
    
    private Connection conn ;
    
    public DAO_service() {
        conn =  koneksi.getConnection();
    }
    
    @Override
    public void tambahData(model_service modSer) {
        PreparedStatement st = null;
        String sql = "INSERT INTO public.service(kode_service, id_mekanik, kode_barang, tgl_service, total_service, keterangan, harga_service)VALUES (?, ?, ?, ?, ?, ?, ?)";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, modSer.getKode_service());
            st.setString(2, modSer.getMoMek().getId_mekanik());
            st.setString(3, modSer.getBarangcus().getKode_barang());
            // Convert java.util.Date to java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(modSer.getTgl_service().getTime());
            st.setDate(4, sqlDate);
            st.setLong(5, modSer.getTotal());
            st.setString(6, modSer.getKeterangan());
            st.setLong(7, modSer.getHarga_service());
            
            st.executeUpdate();
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_service.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_service.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
                }
            }
        }
    }
    
    @Override
    public List<model_service> getByID(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT sv.kode_service, bc.kode_barang, bc.nama_customer, sv.tgl_service, sv.harga_service, sv.total_service "
                + "FROM service sv "
//                + "INNER JOIN mekanik mk ON mk.id_mekanik=sv.id_mekanik "
                + "INNER JOIN barang_customer bc ON bc.kode_barang=sv.kode_barang "
                + "WHERE sv.kode_service='"+id+"' ORDER BY kode_service DESC ";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){

                model_service sv = new model_service();
                model_barangcus bc = new model_barangcus();
                        
                sv.setKode_service(rs.getString("kode_service"));
                bc.setKode_barang(rs.getString("kode_barang"));
                bc.setNama_customer(rs.getString("nama_customer"));
                // Retrieve the date from the ResultSet and set it in Model_BarangKeluar
                java.sql.Date sqlDate = rs.getDate("tgl_service");
                sv.setTgl_service(sqlDate);
                sv.setHarga_service(rs.getLong("harga_service"));
                sv.setTotal(rs.getLong("total_service"));
//                spl.setStatus           (rs.getString("ststus"));
//                System.out.println(rs.getString("kode_supply"));
                sv.setBarangcus(bc);
                
                list.add(sv);
            }
            return list;
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_service.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_service.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(rs != null){
                try{
                    rs.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_service.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
    }
    
    @Override
    public List<model_service> ambilData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT sv.kode_service, mk.id_mekanik, bc.kode_barang, bc.nama_customer, sv.tgl_service, sv.harga_service, sv.total_service, sv.keterangan "
                + "FROM service sv "
                + "INNER JOIN mekanik mk ON mk.id_mekanik=sv.id_mekanik "
                + "INNER JOIN barang_customer bc ON bc.kode_barang=sv.kode_barang "
                + "ORDER BY kode_service DESC";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                model_service sv = new model_service();
                model_mekanik mk = new model_mekanik();
                model_barangcus brg = new model_barangcus();
                
                sv.setKode_service(rs.getString("kode_service"));
                mk.setId_mekanik(rs.getString("id_mekanik"));
                brg.setKode_barang(rs.getString("kode_barang"));
                brg.setNama_customer(rs.getString("nama_customer"));
                // Retrieve the date from the ResultSet and set it in Model_BarangKeluar
                java.sql.Date sqlDate = rs.getDate("tgl_service");
                sv.setTgl_service(sqlDate);
                sv.setHarga_service(rs.getLong("harga_service"));
                sv.setTotal(rs.getLong("total_service"));
                sv.setKeterangan(rs.getString("keterangan"));
//                sv.setStatus(rs.getString("status"));
                
//                System.out.println(rs.getString("kode_supply"));
                sv.setMoMek(mk);
                sv.setBarangcus(brg);
                
                list.add(sv);
            }
            return list;
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_service.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_service.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if (rs!=null){
                try{
                    rs.close();
                }catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_service.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
    }

    @Override
    public List<model_service> pencarianData(String id) {
        PreparedStatement st = null;
        List<model_service> list = new ArrayList<>();
        ResultSet rs = null;
        String sql = "SELECT sv.kode_service, mk.id_mekanik, bc.kode_barang, bc.nama_customer, sv.tgl_service, sv.harga_service, sv.total_service, sv.keterangan "
                + "FROM service sv "
                + "INNER JOIN mekanik mk ON mk.id_mekanik=sv.id_mekanik "
                + "INNER JOIN barang_customer bc ON bc.kode_barang=sv.kode_barang "
                + "WHERE LOWER(sv.kode_service) LIKE LOWER(?) "
                + "OR LOWER(mk.id_mekanik) LIKE LOWER(?) "
                + "OR LOWER(bc.kode_barang) LIKE LOWER(?) "
                + "OR LOWER(bc.nama_customer) LIKE LOWER(?) "
//                + "OR LOWER(sv.tgl_service) LIKE LOWER(?) "
                + "OR LOWER(sv.keterangan) LIKE LOWER(?) "
                + "ORDER BY sv.kode_service ASC";

        try {
            st = conn.prepareStatement(sql);

            // Mengganti parameter yang akan diisi dengan nilai pencarian
            for (int i = 1; i <= 5; i++) {
                st.setString(i, ""+id+"%");
            }

            rs = st.executeQuery();

            while (rs.next()) {
                model_service sv = new model_service();
                model_mekanik mk = new model_mekanik();
                model_barangcus brg = new model_barangcus();

                sv.setKode_service(rs.getString("kode_service"));
                mk.setId_mekanik(rs.getString("id_mekanik"));
                brg.setKode_barang(rs.getString("kode_barang"));
                brg.setNama_customer(rs.getString("nama_customer"));
                // Retrieve the date from the ResultSet and set it in Model_BarangKeluar
                java.sql.Date sqlDate = rs.getDate("tgl_service");
                sv.setTgl_service(sqlDate);
                sv.setHarga_service(rs.getLong("harga_service"));
                sv.setTotal(rs.getLong("total_service"));
                sv.setKeterangan(rs.getString("keterangan"));

                sv.setMoMek(mk);
                sv.setBarangcus(brg);

                list.add(sv);
            }
            return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_service.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_service.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_service.class.getName()).log(Level.SEVERE, null, ex);
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
        SimpleDateFormat nonformat = new SimpleDateFormat("MMd");
        String tgl = tanggal.format(now);
        String no = nonformat.format(now);
        
        String sql = "SELECT RIGHT (kode_service, 3) AS nomor "
                +"FROM service "
                +"WHERE kode_service LIKE 'SV"+no+"%' "
                +"ORDER BY kode_service DESC LIMIT 1";
        
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                int nomor1 = Integer.parseInt(rs.getString("nomor"));
                nomor1++;
                urutan = "SV"+no+String.format("%03d", nomor1);
            } else {
                urutan = "SV"+no+"001";
            }
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_service.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_service.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
        return urutan;
    }

    @Override
    public void hapusData(model_service modSer) {
        PreparedStatement st = null;
        String sql = "DELETE FROM service WHERE kode_service = ? ";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, modSer.getKode_service());
            
            st.executeUpdate();
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_service.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_service.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
    }

    
    }
    
