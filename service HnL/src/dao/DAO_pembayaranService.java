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
import model.model_pembayaranService;
import model.model_service;
import service.service_pembayaranService;

/**
 *
 * @author SyafiqUbai
 */
public class DAO_pembayaranService implements service_pembayaranService {

    private Connection conn;

    public DAO_pembayaranService() {
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(model_pembayaranService pemSer) {
        PreparedStatement st = null;
        String sql = "INSERT INTO public.pembayaran_service(id_pembayaranservice, kode_service, id_kasir, tgl_pembayaranservice, kurang_bayar, status, sudah_bayar)VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            st = conn.prepareStatement(sql);

            st.setString(1, pemSer.getId_pembayaranservice());
            st.setString(2, pemSer.getModService().getKode_service());
            st.setString(3, pemSer.getModKa().getId_kasir());
            // Convert java.util.Date to java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(pemSer.getTgl_pembayaranservice().getTime());
            st.setDate(4, sqlDate);
            st.setLong(5, pemSer.getKurang_bayar());
            st.setString(6, pemSer.getStatus_pembayaran());
            st.setLong(7, pemSer.getSudah_bayar());

            st.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_pembayaranService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_pembayaranService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void hapusData(model_pembayaranService pemSer) {
        PreparedStatement st = null;
        String sql = "DELETE FROM pembayaran_service WHERE id_pembayaranservice = ? ";
        try {
            st = conn.prepareStatement(sql);

            st.setString(1, pemSer.getId_pembayaranservice());

            st.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_pembayaranService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_pembayaranService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void ubahData(model_pembayaranService pemSer) {
        PreparedStatement st = null;
        String updateSql = "UPDATE public.pembayaran_service SET kode_service = ?, id_kasir = ?, tgl_pembayaranservice = ?, kurang_bayar = ?, status = ?, sudah_bayar = ? WHERE id_pembayaranservice = ?";

        try {
            st = conn.prepareStatement(updateSql);

            st.setString(1, pemSer.getModService().getKode_service());
            st.setString(2, pemSer.getModKa().getId_kasir());
            // Convert java.util.Date to java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(pemSer.getTgl_pembayaranservice().getTime());
            st.setDate(3, sqlDate);
            st.setLong(4, pemSer.getKurang_bayar());
            st.setString(5, pemSer.getStatus_pembayaran());
            st.setLong(6, pemSer.getSudah_bayar());
            st.setString(7, pemSer.getId_pembayaranservice());

            st.executeUpdate();

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_pembayaranService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_pembayaranService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        }

    }

    @Override
    public model_pembayaranService getByID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_pembayaranService> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT ps.id_pembayaranservice, s.kode_service, ks.id_kasir, ks.nama_kasir, s.total_service, ps.kurang_bayar, ps.sudah_bayar, ps.tgl_pembayaranservice, ps.status "
                + "FROM pembayaran_service ps "
                + "INNER JOIN service s ON s.kode_service=ps.kode_service "
                + "INNER JOIN kasir ks ON ks.id_kasir=ps.id_kasir "
                + "ORDER BY id_pembayaranservice DESC";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                model_pembayaranService ps = new model_pembayaranService();
                model_service sv = new model_service();
                model_kasir ks = new model_kasir();

                ps.setId_pembayaranservice(rs.getString("id_pembayaranservice"));
                sv.setKode_service(rs.getString("kode_service"));
                ks.setId_kasir(rs.getString("id_kasir"));
                ks.setNama_kasir(rs.getString("nama_kasir"));
                sv.setTotal(rs.getLong("total_service"));
                ps.setKurang_bayar(rs.getLong("kurang_bayar"));
                ps.setSudah_bayar(rs.getLong("sudah_bayar"));
                // Retrieve the date from the ResultSet and set it in Model_BarangKeluar
                java.sql.Date sqlDate = rs.getDate("tgl_pembayaranservice");
                ps.setTgl_pembayaranservice(sqlDate);
            
                ps.setStatus_pembayaran(rs.getString("status"));

                ps.setModService(sv);
                ps.setModKa(ks);

                list.add(ps);
            }
            return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_pembayaranService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_pembayaranService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_pembayaranService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<model_pembayaranService> pencarianData(String id) {
        PreparedStatement st = null;
        List<model_pembayaranService> list = new ArrayList<>();
        ResultSet rs = null;
        String sql = "SELECT ps.id_pembayaranservice, s.kode_service, ks.id_kasir, ks.nama_kasir, s.total_service, ps.sudah_bayar, ps.kurang_bayar, ps.tgl_pembayaranservice, ps.status "
                + "FROM pembayaran_service ps "
                + "INNER JOIN service s ON s.kode_service=ps.kode_service "
                + "INNER JOIN kasir ks ON ks.id_kasir=ps.id_kasir "
                + "WHERE LOWER(ps.kode_service) LIKE LOWER(?) "
                + "OR LOWER(ks.nama_kasir) LIKE LOWER(?) "
                + "OR LOWER(ps.status) LIKE LOWER(?) "
                + "ORDER BY ps.id_pembayaranservice ASC";

        try {
            st = conn.prepareStatement(sql);

            // Mengganti parameter yang akan diisi dengan nilai pencarian
            for (int i = 1; i <= 3; i++) {
                st.setString(i, "" + id + "%");
            }

            rs = st.executeQuery();

            while (rs.next()) {
                model_pembayaranService ps = new model_pembayaranService();
                model_service sv = new model_service();
                model_kasir ks = new model_kasir();

                ps.setId_pembayaranservice(rs.getString("id_pembayaranservice"));
                sv.setKode_service(rs.getString("kode_service"));
                ks.setId_kasir(rs.getString("id_kasir"));
                ks.setNama_kasir(rs.getString("nama_kasir"));
                sv.setTotal(rs.getLong("total_service"));
                ps.setKurang_bayar(rs.getLong("kurang_bayar"));
                ps.setSudah_bayar(rs.getLong("sudah_bayar"));
                // Retrieve the date from the ResultSet and set it in Model_BarangKeluar
                java.sql.Date sqlDate = rs.getDate("tgl_pembayaranservice");
                ps.setTgl_pembayaranservice(sqlDate);
                ps.setStatus_pembayaran(rs.getString("status"));

                ps.setModService(sv);
                ps.setModKa(ks);

                list.add(ps);
            }
            return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_pembayaranService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_pembayaranService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_pembayaranService.class.getName()).log(Level.SEVERE, null, ex);
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

        String sql = "SELECT RIGHT (id_pembayaranservice, 3) AS nomor "
                + "FROM pembayaran_service "
                + "WHERE id_pembayaranservice LIKE 'PV" + no + "%' "
                + "ORDER BY id_pembayaranservice DESC LIMIT 1";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if (rs.next()) {
                int nomor1 = Integer.parseInt(rs.getString("nomor"));
                nomor1++;
                urutan = "PV" + no + String.format("%03d", nomor1);
            } else {
                urutan = "PV" + no + "001";
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_pembayaranService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_pembayaranService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return urutan;
    }
}
