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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import model.model_admin;
import service.service_admin;

/**
 *
 * @author SyafiqUbai
 */
public class DAO_admin implements service_admin{
    
    private Connection conn;
    
    public DAO_admin() {
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(model_admin mod_adm) {
    PreparedStatement st = null;
    String sql = "INSERT INTO public.admin(ID_admin, nama_admin, username, password) VALUES (?, ?, ?, ?);";
    
    try {
        st = conn.prepareStatement(sql);

        st.setString(1, mod_adm.getId_admin());
        st.setString(2, mod_adm.getNama_admin());
        st.setString(3, mod_adm.getUsername());
        st.setString(4, Encrypt.getmd5java(mod_adm.getPassword()));

        int rowsAffected = st.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Gagal menambahkan data. Silakan coba lagi.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        java.util.logging.Logger.getLogger(DAO_admin.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAO_admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}


    @Override
    public void perbaruiData(model_admin mod_adm) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void hapusData(model_admin mod_adm) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public model_admin getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_admin> getData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_admin> pencarian(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        
        String sql = "SELECT RIGHT (id_admin, 3) AS nomor "
                +"FROM admin "
                +"WHERE id_admin LIKE 'ADMIN"+no+"%' "
                +"ORDER BY id_admin DESC LIMIT 1";
        
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                int nomor1 = Integer.parseInt(rs.getString("nomor"));
                nomor1++;
                urutan = "ADMIN"+no+String.format("%03d", nomor1);
            } else {
                urutan = "ADMIN"+no+"1";
            }
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_admin.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if(st != null){
                try{
                    st.close();
                } catch (SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_admin.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
        return urutan;
    
    }
    
}
