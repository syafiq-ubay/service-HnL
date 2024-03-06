/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import config.koneksi;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import model.model_onderdil;
import model.model_jenisOnderdil;
import model.model_supplier;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import service.service_onderdil;

/**
 *
 * @author Asus
 */
public class DAO_onderdil implements service_onderdil {

    private Connection conn;

    public DAO_onderdil() {
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(model_onderdil modOnd) {
        PreparedStatement st = null;
        String sql = "INSERT INTO public.onderdil(kode_onderdil, kode_jenis, nama_onderdil, stok, harga_onderdil, id_supplier)VALUES (?, ?, ?, ?, ?, ?)";
        try {
            st = conn.prepareStatement(sql);

            st.setString(1, modOnd.getKode_onderdil());
            st.setString(2, modOnd.getJns_onderdil().getKode_jenis());
            st.setString(3, modOnd.getNama_onderdil());
            st.setInt(4, modOnd.getStok());
            st.setLong(5, modOnd.getHarga_onderdil());
            st.setString(6, modOnd.getSupplier().getId_supplier());
            
            st.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_onderdil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_onderdil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void perbaruiData(model_onderdil modOnd) {
        PreparedStatement st = null;
        String sql = "UPDATE onderdil SET kode_jenis=?, nama_onderdil=?, stok=?, harga_onderdil=?, id_supplier=? "
                + "WHERE kode_onderdil = '" + modOnd.getKode_onderdil() + "'";
        try {
            st = conn.prepareStatement(sql);

            st.setString(1, modOnd.getJns_onderdil().getKode_jenis());
            st.setString(2, modOnd.getNama_onderdil());
            st.setInt(3, modOnd.getStok());
            st.setLong(4, modOnd.getHarga_onderdil());
            st.setString(5, modOnd.getSupplier().getId_supplier());

            st.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Perbarui data gagal!");
            java.util.logging.Logger.getLogger(DAO_onderdil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_onderdil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }

        }
    }

    @Override
    public void hapusData(model_onderdil modOnd) {
        PreparedStatement st = null;
        String sql = "DELETE FROM onderdil WHERE kode_onderdil = ?";
        try {
            st = conn.prepareStatement(sql);

            st.setString(1, modOnd.getKode_onderdil());

            st.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_onderdil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_onderdil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<model_onderdil> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT bg.kode_onderdil,jb.kode_jenis, jb.type_jenis,jb.nama_jenis, bg.nama_onderdil, bg.harga_onderdil,bg.stok, spr.id_supplier, spr.toko_supplier "
                + "FROM onderdil bg "
                + "INNER JOIN jenis_onderdil jb ON jb.kode_jenis=bg.kode_jenis "
                + "INNER JOIN supplier spr ON spr.id_supplier=bg.id_supplier "
                + "ORDER BY kode_onderdil ASC";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                model_onderdil mobar = new model_onderdil();
                model_jenisOnderdil jbr = new model_jenisOnderdil();
                model_supplier spr = new model_supplier();

                mobar.setKode_onderdil(rs.getString("kode_onderdil"));
                jbr.setKode_jenis(rs.getString("kode_jenis"));
                jbr.setType_jenis(rs.getString("type_jenis"));
                jbr.setNama_jenis(rs.getString("nama_jenis"));
                mobar.setNama_onderdil(rs.getString("nama_onderdil"));
                mobar.setStok(rs.getInt("stok"));
                mobar.setHarga_onderdil(rs.getLong("harga_onderdil"));
                spr.setId_supplier(rs.getString("id_supplier"));
                spr.setToko_supplier(rs.getString("toko_supplier"));

                mobar.setJns_onderdil(jbr);
                mobar.setSupplier(spr);

                list.add(mobar);
            }
            return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_onderdil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_onderdil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_onderdil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    @Override
    public List<model_onderdil> getDataByID(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT bg.kode_onderdil,jb.kode_jenis, jb.type_jenis,jb.nama_jenis, bg.nama_onderdil, bg.harga_onderdil,bg.stok, spr.id_supplier, spr.toko_supplier "
                + "FROM onderdil bg "
                + "INNER JOIN jenis_onderdil jb ON jb.kode_jenis=bg.kode_jenis "
                + "INNER JOIN supplier spr ON spr.id_supplier=bg.id_supplier "
                +"WHERE spr.id_supplier = '"+id+"' "
                + "ORDER BY kode_onderdil ASC";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                model_onderdil mobar = new model_onderdil();
                model_jenisOnderdil jbr = new model_jenisOnderdil();
                model_supplier spr = new model_supplier();

                mobar.setKode_onderdil(rs.getString("kode_onderdil"));
                jbr.setKode_jenis(rs.getString("kode_jenis"));
                jbr.setType_jenis(rs.getString("type_jenis"));
                jbr.setNama_jenis(rs.getString("nama_jenis"));
                mobar.setNama_onderdil(rs.getString("nama_onderdil"));
                mobar.setStok(rs.getInt("stok"));
                mobar.setHarga_onderdil(rs.getLong("harga_onderdil"));
                spr.setId_supplier(rs.getString("id_supplier"));
                spr.setToko_supplier(rs.getString("toko_supplier"));

                mobar.setJns_onderdil(jbr);
                mobar.setSupplier(spr);

                list.add(mobar);
            }
            return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_onderdil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_onderdil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_onderdil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<model_onderdil> pencarian(String id) {
    PreparedStatement st = null;
    List<model_onderdil> list = new ArrayList<>();
    ResultSet rs = null;
    String sql = "SELECT bg.kode_onderdil,jb.kode_jenis, jb.type_jenis,jb.nama_jenis, bg.nama_onderdil, bg.harga_onderdil,bg.stok, spr.id_supplier, spr.toko_supplier "
            + "FROM onderdil bg "
            + "INNER JOIN jenis_onderdil jb ON jb.kode_jenis=bg.kode_jenis "
            + "INNER JOIN supplier spr ON spr.id_supplier=bg.id_supplier "
            + "WHERE LOWER(bg.kode_onderdil) LIKE LOWER(?) "
            + "   OR LOWER(jb.kode_jenis) LIKE LOWER(?) "
            + "   OR LOWER(jb.type_jenis) LIKE LOWER(?) "
            + "   OR LOWER(jb.nama_jenis) LIKE LOWER(?) "
            + "   OR LOWER(bg.nama_onderdil) LIKE LOWER(?) "
            + "   OR LOWER(spr.toko_supplier) LIKE LOWER(?) "
            + "ORDER BY bg.kode_onderdil ASC";
    
    try {
        st = conn.prepareStatement(sql);
        // Mengganti parameter yang akan diisi dengan nilai pencarian
        for (int i = 1; i <= 6; i++) {
            st.setString(i, "%" + id + "%");
        }
        rs = st.executeQuery();

        while (rs.next()) {
            model_onderdil mobar = new model_onderdil();
            model_jenisOnderdil jbr = new model_jenisOnderdil();
            model_supplier spr = new model_supplier();

            mobar.setKode_onderdil(rs.getString("kode_onderdil"));
            jbr.setKode_jenis(rs.getString("kode_jenis"));
            jbr.setType_jenis(rs.getString("type_jenis"));
            jbr.setNama_jenis(rs.getString("nama_jenis"));
            mobar.setNama_onderdil(rs.getString("nama_onderdil"));
            mobar.setStok(rs.getInt("stok"));
            mobar.setHarga_onderdil(rs.getLong("harga_onderdil"));
            spr.setId_supplier(rs.getString("id_supplier"));
            spr.setToko_supplier(rs.getString("toko_supplier"));

            mobar.setJns_onderdil(jbr);
            mobar.setSupplier(spr);

            list.add(mobar);
        }
        return list;
    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(DAO_onderdil.class.getName()).log(Level.SEVERE, null, ex);
        return null;
    } finally {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAO_onderdil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAO_onderdil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}


    @Override
    public String nomor1() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String urutan = null;

        Date now = new Date();
        SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat nonformat = new SimpleDateFormat("yyMM");
        String tgl = tanggal.format(now);
        String no = nonformat.format(now);

        String sql = "SELECT RIGHT (kode_onderdil, 3) AS nomor "
                + "FROM onderdil "
                + "WHERE kode_onderdil LIKE 'DL" + no + "%' "
                + "ORDER BY kode_onderdil DESC LIMIT 1";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if (rs.next()) {
                int nomor1 = Integer.parseInt(rs.getString("nomor"));
                nomor1++;
                urutan = "DL" + no + String.format("%03d", nomor1);
            } else {
                urutan = "DL" + no + "001";
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_onderdil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_onderdil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        }
        return urutan;
    }

    @Override
    public void exportToExcel(List<model_onderdil> data, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Data");

            // Membuat header kolom
            Row headerRow = sheet.createRow(0);
            String[] columns = {"NO", "Kode Onderdil", "KodeJenis", "Type Jenis", "Nama Jenis", "Nama Onderdil", "Stok", "Harga", "ID supplier", "Toko Supplier"};

            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

            // Membuat baris data
            for (int i = 0; i < data.size(); i++) {
                Row row = sheet.createRow(i + 1);
                model_onderdil barang = data.get(i);

                row.createCell(0).setCellValue(i + 1);
                row.createCell(1).setCellValue(barang.getKode_onderdil());
                row.createCell(2).setCellValue(barang.getJns_onderdil().getKode_jenis());
                row.createCell(3).setCellValue(barang.getJns_onderdil().getType_jenis());
                row.createCell(4).setCellValue(barang.getJns_onderdil().getNama_jenis());
                row.createCell(5).setCellValue(barang.getNama_onderdil());
                row.createCell(6).setCellValue(barang.getStok());
                row.createCell(7).setCellValue(barang.getHarga_onderdil());
                row.createCell(8).setCellValue(barang.getSupplier().getId_supplier());
                row.createCell(9).setCellValue(barang.getSupplier().getToko_supplier());
            }

            // Menyimpan file Excel
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }

            JOptionPane.showMessageDialog(null, "Data berhasil di export ke excel");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat mengexport data ke Excel: " + e.getMessage());
        }
    }

    @Override
    public void importFromExcel(List<model_onderdil> data, String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            data.clear();

            boolean firstRowSkipped = false;
            DataFormatter dataFormatter = new DataFormatter();
            for (Row row : sheet) {
                if (!firstRowSkipped) {
                    firstRowSkipped = true;
                    continue;
                }
                model_onderdil barang = new model_onderdil();
                model_jenisOnderdil jenisBarang = new model_jenisOnderdil();
                model_supplier supplier = new model_supplier();
                for (Cell cell : row) {
                    int columnIndex = cell.getColumnIndex();

                    switch (columnIndex) {
                        case 0: 
                            barang.setKode_onderdil(dataFormatter.formatCellValue(cell));
                            break;
                        case 1: 
                            jenisBarang.setKode_jenis(dataFormatter.formatCellValue(cell));
                            break;
                        case 2:
                            jenisBarang.setType_jenis(dataFormatter.formatCellValue(cell));
                            break;
                        case 3: 
                            jenisBarang.setNama_jenis(dataFormatter.formatCellValue(cell));
                            break;
                        case 4: 
                            barang.setNama_onderdil(dataFormatter.formatCellValue(cell));
                            break;
                        case 5: 
                        try {
                            int stok = Integer.parseInt(dataFormatter.formatCellValue(cell));
                            barang.setStok(stok);
                        } catch (NumberFormatException e) {
                            System.out.println("Format stok tidak valid pada baris: " + (row.getRowNum() + 1));
                        }
                            break;
                        case 6:
                        try{
                            Long harga = Long.parseLong(dataFormatter.formatCellValue(cell));
                            barang.setHarga_onderdil(harga);
                        }catch (NumberFormatException e){
                            System.out.print("Format Harga tidak valid pada baris: " + (row.getRowNum() + 1));
                        }
                            break;
                        case 7:
                            supplier.setId_supplier(dataFormatter.formatCellValue(cell));
                            break;
                        case 8:
                            supplier.setToko_supplier(dataFormatter.formatCellValue(cell));
                            break;
                        default:
                            break;
                    }
                }
                barang.setJns_onderdil(jenisBarang);
                barang.setSupplier(supplier);
                data.add(barang);
                simpanKeDB(barang);
            }
            workbook.close();
           JOptionPane.showMessageDialog(null, "Data berhasil di impor dari excel!");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat mengimpor data dari Excel: " + e.getMessage());
        }
    }

    private void simpanKeDB(model_onderdil barang) {
        PreparedStatement st = null;
        String sql = "INSERT INTO public.onderdil(kode_onderdil, kode_jenis, nama_onderdil, stok, harga_onderdil, id_supplier)VALUES (?, ?, ?, ?, ?, ?)";
        try {
            st = conn.prepareStatement(sql);

            st.setString(1, barang.getKode_onderdil());
            st.setString(2, barang.getJns_onderdil().getKode_jenis());
            st.setString(3, barang.getNama_onderdil());
            st.setInt(4, barang.getStok());
            st.setLong(5, barang.getHarga_onderdil());
            st.setString(6, barang.getSupplier().getId_supplier());

            st.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_onderdil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

}
