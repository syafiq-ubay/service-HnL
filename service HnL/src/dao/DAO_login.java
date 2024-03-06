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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import main.login;
import main.Menu_Utama;
import model.Model_Login;
import service.Service_Login;

/**
 *
 * @author SyafiqUbai
 */
public class DAO_login implements Service_Login{
    
    private Connection conn;
    
    public DAO_login() {
        conn = koneksi.getConnection();
    }
        
    @Override
    public void prosesLogin(Model_Login mod_login) {
        PreparedStatement st = null;
        ResultSet rs    = null;
        String sql = "SELECT * FROM admin "
                + "WHERE (id_admin = '"+mod_login.getId_user()+"' "
                + "OR username = '"+mod_login.getUsername()+"') "
                + "AND password = '"+Encrypt.getmd5java(mod_login.getPassword())+"'";
        
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if (rs.next()){
                Model_Login ml = new Model_Login();
                ml.setId_user(rs.getString("id_admin"));
                ml.setUsername(rs.getString("username"));
                ml.setNama(rs.getString("nama_admin"));
                ml.setPassword(rs.getString("password"));
                
//                Model_Login ml = new Model_Login();
                Menu_Utama menu = new Menu_Utama(ml);
                menu.setVisible(true);
                menu.revalidate();
                login lg = new login();
                lg.tutup = true;
                
            } else {
                JOptionPane.showMessageDialog(null, "Username atau Password Tidak terdaftar","Peringatan",JOptionPane.WARNING_MESSAGE);
                login lg = new  login();
                lg.tutup = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_login.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(st != null){
                try{
                    st.close();
                } catch(SQLException ex){
                    Logger.getLogger(DAO_login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
