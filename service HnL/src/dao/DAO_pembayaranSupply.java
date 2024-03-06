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
import model.model_pembayaranSupply;
import model.model_supply;
import service.service_pembayaranSupply;

/**
 *
 * @author SyafiqUbai
 */
public class DAO_pembayaranSupply implements service_pembayaranSupply{
    
    private Connection conn ;
    
    public DAO_pembayaranSupply() {
        conn =  koneksi.getConnection();
    }

    @Override
    public void tambahData(model_pembayaranSupply pemSub) {
        PreparedStatement st = null;
        String sql = "INSERT INTO public.pembayaran_supply(id_pembayaransupply, kode_supply, tgl_pembayaransupply)VALUES (?, ?, ?)";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, pemSub.getId_pembayaransupply());
            st.setString(2, pemSub.getModSupply().getKode_supply());
            // Convert java.util.Date to java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(pemSub.getTgl_pembayaransupply().getTime());
            st.setDate(3, sqlDate);
            
            st.executeUpdate();
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_pembayaranSupply.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_pembayaranSupply.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
                }
            }
        }
    }

    @Override
    public void hapusData(model_pembayaranSupply pemSub) {
        PreparedStatement st = null;
        String sql = "DELETE FROM pembayaran_supply WHERE id_pembayaransupply = ? ";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, pemSub.getId_pembayaransupply());
            
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
    public void ubahData(model_pembayaranSupply pemSub) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public model_pembayaranSupply getByID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_pembayaranSupply> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT ps.id_pembayaransupply, s.kode_supply, s.total_supply, ps.tgl_pembayaransupply, s.status "
                + "FROM pembayaran_supply ps "
                + "INNER JOIN supply s ON ps.kode_supply=s.kode_supply "
                + "WHERE s.status='Lunas'"
                + "ORDER BY id_pembayaransupply DESC";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                model_pembayaranSupply spl = new model_pembayaranSupply();
                model_supply sup = new model_supply();
                
                spl.setId_pembayaransupply(rs.getString("id_pembayaransupply"));
                sup.setKode_supply(rs.getString("kode_supply"));
                sup.setTotal_supply     (rs.getLong("total_supply"));
                
                // Retrieve the date from the ResultSet and set it in Model_BarangKeluar
                java.sql.Date sqlDate = rs.getDate("tgl_pembayaransupply");
                spl.setTgl_pembayaransupply(sqlDate);
                sup.setStatus(rs.getString("status"));
                
                spl.setModSupply(sup);

                list.add(spl);
            }
            return list;
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_pembayaranSupply.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_pembayaranSupply.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            if (rs!=null){
                try{
                    rs.close();
                }catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_pembayaranSupply.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
    }

    @Override
    public List<model_pembayaranSupply> pencarianData(String id) {
        PreparedStatement st = null;
        List<model_pembayaranSupply> list = new ArrayList<>();
        ResultSet rs = null;
        String sql = "SELECT ps.id_pembayaransupply, s.kode_supply, s.total_supply, ps.tgl_pembayaransupply, s.status "
                + "FROM pembayaran_supply ps "
                + "INNER JOIN supply s ON ps.kode_supply=s.kode_supply "
                + "WHERE s.status='Lunas' "
                + "AND (LOWER(s.kode_supply) LIKE LOWER(?) "
//                + "OR LOWER(ps.tgl_pembayaransupply) LIKE LOWER(?) "
                + "OR LOWER(s.status) LIKE LOWER(?))"
                + "ORDER BY ps.id_pembayaransupply ASC";

        try {
            st = conn.prepareStatement(sql);

            // Mengganti parameter yang akan diisi dengan nilai pencarian
            for (int i = 1; i <= 2; i++) {
                st.setString(i, ""+id+"%");
            }

            rs = st.executeQuery();

            while (rs.next()) {
                model_pembayaranSupply spl = new model_pembayaranSupply();
                model_supply sup = new model_supply();

                spl.setId_pembayaransupply(rs.getString("id_pembayaransupply"));
                sup.setKode_supply(rs.getString("kode_supply"));
                sup.setTotal_supply(rs.getLong("total_supply"));
                // Retrieve the date from the ResultSet and set it in Model_BarangKeluar
                java.sql.Date sqlDate = rs.getDate("tgl_pembayaranssupply");
                spl.setTgl_pembayaransupply(sqlDate);
                sup.setStatus(rs.getString("status"));

                spl.setModSupply(sup);

                list.add(spl);
            }
            return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_pembayaranSupply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_pembayaranSupply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        
        String sql = "SELECT RIGHT (id_pembayaransupply, 3) AS nomor "
                +"FROM pembayaran_supply "
                +"WHERE id_pembayaransupply LIKE 'PS"+no+"%' "
                +"ORDER BY id_pembayaransupply DESC LIMIT 1";
        
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                int nomor1 = Integer.parseInt(rs.getString("nomor"));
                nomor1++;
                urutan = "PS"+no+String.format("%03d", nomor1);
            } else {
                urutan = "PS"+no+"001";
            }
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_pembayaranSupply.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_pembayaranSupply.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
        return urutan;
    }
    
    
}
