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
import model.model_supply;
import service.service_supply;

public class DAO_supply implements service_supply {

    private Connection conn ;
    
    public DAO_supply(){
         conn =  koneksi.getConnection();
    }

    @Override
    public void tambahData(model_supply modSpl) {
            PreparedStatement st = null;
            String sql = "INSERT INTO public.supply(kode_supply, id_supplier, tgl_supply, total_supply, status)VALUES (?, ?, ?, ?, ?)";
            try{
                st = conn.prepareStatement(sql);

                st.setString(1, modSpl.getKode_supply());
                st.setString(2, modSpl.getSupplier().getId_supplier());
                // Convert java.util.Date to java.sql.Date
                java.sql.Date sqlDate = new java.sql.Date(modSpl.getTgl_supply().getTime());
                st.setDate(3, sqlDate);
                st.setLong(4, modSpl.getTotal_supply());
                st.setString(5, modSpl.getStatus());

                st.executeUpdate();
            } catch (SQLException ex){
                java.util.logging.Logger.getLogger(DAO_supply.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
            } finally {
                if(st != null){
                    try{
                        st.close();
                    } catch (SQLException ex){
                        java.util.logging.Logger.getLogger(DAO_supply.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
                    }
                }
            }
    }

    @Override
    public void hapusData(model_supply modSpl) {
        PreparedStatement st = null;
        String sql = "DELETE FROM supply WHERE kode_supply = ? ";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, modSpl.getKode_supply());
            
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
    public void ubahData(model_supply modSpl) {
        PreparedStatement st = null;
        String sql = "UPDATE supply SET status = ? "
                +"WHERE kode_supply = '"+modSpl.getKode_supply()+"'";
        try{
            st = conn.prepareStatement(sql);

            st.setString(1, modSpl.getStatus());
            
            st.executeUpdate();
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_supply.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_supply.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
    }
    
    @Override
    public List<model_supply> getByID(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT sp.kode_supply, spr.id_supplier, spr.toko_supplier, sp.tgl_supply, sp.total_supply, sp.status "
                    +"FROM supply sp "
                    +"INNER JOIN supplier spr ON spr.id_supplier=sp.id_supplier "
                    +"WHERE sp.kode_supply='"+id+"' ORDER BY kode_supply DESC";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){

                model_supply spl = new model_supply();
                model_supplier spr = new model_supplier();
                        
                spl.setKode_supply      (rs.getString("kode_supply"));
                spr.setId_supplier      (rs.getString("id_supplier"));
                spr.setToko_supplier    (rs.getString("toko_supplier"));
                // Retrieve the date from the ResultSet and set it in Model_BarangKeluar
                java.sql.Date sqlDate = rs.getDate("tgl_supply");
                spl.setTgl_supply(sqlDate);
                spl.setTotal_supply     (rs.getLong("total_supply"));
                spl.setStatus           (rs.getString("status"));
//                System.out.println(rs.getString("kode_supply"));
                spl.setSupplier(spr);
                
                list.add(spl);
            }
            return list;
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_supply.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_supply.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if(rs != null){
                try{
                    rs.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_supply.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
    }
    
    @Override
    public List<model_supply> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT sp.kode_supply, sp.tgl_supply, sp.total_supply, spr.id_supplier, sp.status "
                    +"FROM supply sp "
                    +"INNER JOIN supplier spr ON spr.id_supplier=sp.id_supplier "
                    +"WHERE sp.status='Pending' "
                    +"ORDER BY sp.kode_supply DESC";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                model_supply spl = new model_supply();
                model_supplier sup = new model_supplier();
                
                spl.setKode_supply      (rs.getString("kode_supply"));
                // Retrieve the date from the ResultSet and set it in Model_BarangKeluar
                java.sql.Date sqlDate = rs.getDate("tgl_supply");
                spl.setTgl_supply(sqlDate);
                spl.setTotal_supply     (rs.getLong("total_supply"));
                sup.setId_supplier      (rs.getString("id_supplier"));
                spl.setStatus(rs.getString("status"));
                
//                System.out.println(rs.getString("kode_supply"));
                spl.setSupplier(sup);
                
                list.add(spl);
            }
            return list;
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_supply.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_supply.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if (rs!=null){
                try{
                    rs.close();
                }catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_supply.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
    }

    @Override
    public List<model_supply> pencarianData(String id) {
        PreparedStatement st = null;
        List<model_supply> list = new ArrayList<>();
        ResultSet rs = null;
        String sql = "SELECT sp.kode_supply, sp.tgl_supply, sp.total_supply, spr.id_supplier, sp.status "
                + "FROM supply sp "
                + "INNER JOIN supplier spr ON spr.id_supplier=sp.id_supplier "
                + "WHERE sp.status='Pending' "
                + "AND LOWER(sp.kode_supply) LIKE LOWER(?) "
//                + "OR LOWER(sp.tgl_supply) LIKE LOWER(?) "
                + "OR LOWER(spr.id_supplier) LIKE LOWER(?) "
                + "OR LOWER(sp.status) LIKE LOWER(?)"
                + "ORDER BY sp.kode_supply ASC";

        try {
            st = conn.prepareStatement(sql);
            // Mengganti parameter yang akan diisi dengan nilai id
            for (int i = 1; i <= 3; i++) {
                st.setString(i, "" + id + "%");
            }
            rs = st.executeQuery();

            while (rs.next()) {
                model_supply spl = new model_supply();
                model_supplier sup = new model_supplier();

                spl.setKode_supply(rs.getString("kode_supply"));
                // Retrieve the date from the ResultSet and set it in Model_BarangKeluar
                java.sql.Date sqlDate = rs.getDate("tgl_supply");
                spl.setTgl_supply(sqlDate);
                spl.setTotal_supply(rs.getLong("total_supply"));
                sup.setId_supplier(rs.getString("id_supplier"));
                spl.setStatus(rs.getString("status"));

                spl.setSupplier(sup);

                list.add(spl);
            }
            return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_supply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_supply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        
        String sql = "SELECT RIGHT (kode_supply, 3) AS nomor "
                +"FROM supply "
                +"WHERE kode_supply LIKE 'S"+no+"%' "
                +"ORDER BY kode_supply DESC LIMIT 1";
        
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                int nomor1 = Integer.parseInt(rs.getString("nomor"));
                nomor1++;
                urutan = "S"+no+String.format("%03d", nomor1);
            } else {
                urutan = "S"+no+"001";
            }
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_supply.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_supply.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
        return urutan;
    }

    

    
}
