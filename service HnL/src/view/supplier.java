/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import dao.DAO_supplier;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;
import model.model_supplier;
import service.service_supplier;
import tableModel.table_supplier;

/**
 *
 * @author SyafiqUbai
 */
public class supplier extends javax.swing.JPanel {

    private service_supplier servis = new DAO_supplier();
    table_supplier tblMod = new table_supplier();

    /**
     * Creates new form customer_master
     */
    public supplier() {
        initComponents();

        tbl_cont.setModel(tblMod);
        btn_search.requestFocus();
        setColWidht();
        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        dataBarang = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_hapus = new rojerusan.RSMaterialButtonRectangle();
        scrollPaneWin111 = new custom.ScrollPaneWin11();
        tbl_cont = new tablecustom.tablez();
        btn_tambah = new rojerusan.RSMaterialButtonRectangle();
        btn_batal = new rojerusan.RSMaterialButtonRectangle();
        jSeparator1 = new javax.swing.JSeparator();
        tf_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JLabel();
        tambahBarang = new javax.swing.JPanel();
        btn_bersih = new rojerusan.RSMaterialButtonRectangle();
        btn_simpan = new rojerusan.RSMaterialButtonRectangle();
        btn_batal1 = new rojerusan.RSMaterialButtonRectangle();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        tf_kode = new javax.swing.JTextField();
        tf_nama = new javax.swing.JTextField();
        tf_telp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tf_alamat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tf_toko = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setLayout(new java.awt.CardLayout());

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setPreferredSize(new java.awt.Dimension(1300, 720));
        mainPanel.setLayout(new java.awt.CardLayout());

        dataBarang.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setText("Data Supplier");

        btn_hapus.setBackground(new java.awt.Color(204, 0, 0));
        btn_hapus.setText("HAPUS");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        scrollPaneWin111.setBackground(new java.awt.Color(255, 255, 255));
        scrollPaneWin111.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        tbl_cont.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_cont.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tbl_cont.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_contMouseClicked(evt);
            }
        });
        scrollPaneWin111.setViewportView(tbl_cont);

        btn_tambah.setText("TAMBAH");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_batal.setBackground(new java.awt.Color(0, 153, 0));
        btn_batal.setText("BATAL");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        tf_search.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tf_search.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_search.setText("Search");
        tf_search.setBorder(null);
        tf_search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_searchFocusLost(evt);
            }
        });
        tf_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_searchMouseClicked(evt);
            }
        });
        tf_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_searchKeyPressed(evt);
            }
        });

        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search (1).png"))); // NOI18N
        btn_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_searchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout dataBarangLayout = new javax.swing.GroupLayout(dataBarang);
        dataBarang.setLayout(dataBarangLayout);
        dataBarangLayout.setHorizontalGroup(
            dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataBarangLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(scrollPaneWin111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataBarangLayout.createSequentialGroup()
                .addGroup(dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dataBarangLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dataBarangLayout.createSequentialGroup()
                                .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dataBarangLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                .addComponent(btn_search)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(dataBarangLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addGap(40, 40, 40))
        );
        dataBarangLayout.setVerticalGroup(
            dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataBarangLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_search)
                        .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollPaneWin111, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanel.add(dataBarang, "card2");

        tambahBarang.setBackground(new java.awt.Color(255, 255, 255));

        btn_bersih.setBackground(new java.awt.Color(204, 0, 0));
        btn_bersih.setText("CLEAR");
        btn_bersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bersihActionPerformed(evt);
            }
        });

        btn_simpan.setText("SIMPAN");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_batal1.setBackground(new java.awt.Color(0, 153, 0));
        btn_batal1.setText("BATAL");
        btn_batal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batal1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setText("Tambah Data Supplier");

        tf_kode.setEditable(false);
        tf_kode.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tf_kode.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        tf_kode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_kodeActionPerformed(evt);
            }
        });

        tf_nama.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tf_nama.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        tf_nama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_namaKeyTyped(evt);
            }
        });

        tf_telp.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tf_telp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        tf_telp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_telpKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Id Supplier  :");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("Nama Supplier  :");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setText("Toko Supplier  :");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel7.setText("No. Telp  :");

        tf_alamat.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tf_alamat.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        tf_alamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_alamatKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel8.setText("Alamat :");

        tf_toko.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tf_toko.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        tf_toko.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_tokoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout tambahBarangLayout = new javax.swing.GroupLayout(tambahBarang);
        tambahBarang.setLayout(tambahBarangLayout);
        tambahBarangLayout.setHorizontalGroup(
            tambahBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tambahBarangLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(tambahBarangLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(tambahBarangLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btn_bersih, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btn_batal1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(tambahBarangLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4))
            .addGroup(tambahBarangLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(tf_kode, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(tambahBarangLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel5))
            .addGroup(tambahBarangLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(tambahBarangLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6))
            .addGroup(tambahBarangLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(tf_toko, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(tambahBarangLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel7))
            .addGroup(tambahBarangLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(tf_telp, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(tambahBarangLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel8))
            .addGroup(tambahBarangLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(tf_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        tambahBarangLayout.setVerticalGroup(
            tambahBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tambahBarangLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(tambahBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_bersih, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_batal1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addComponent(tf_kode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel5)
                .addGap(11, 11, 11)
                .addComponent(tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addGap(6, 6, 6)
                .addComponent(tf_toko, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(6, 6, 6)
                .addComponent(tf_telp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(6, 6, 6)
                .addComponent(tf_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainPanel.add(tambahBarang, "card2");

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        String x = btn_tambah.getText();
        int row = tbl_cont.getSelectedRow();
        if (x.equals("TAMBAH")) {

            jLabel2.setText("Tambah Data Supplier");

            mainPanel.removeAll();
            mainPanel.repaint();
            mainPanel.revalidate();

            mainPanel.add(tambahBarang);
            mainPanel.repaint();
            mainPanel.revalidate();
            tf_kode.setText(servis.nomor());
            loadData();
        } else {
            int index = tbl_cont.getSelectedRow();
            if (index != -1) {
                model_supplier mod = tblMod.getData(tbl_cont.convertRowIndexToModel(index));

                if (x.equals("UBAH")) {
                    dataTable();
                    loadData();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Pilih dahulu data yang akan diubah");
            }
        }


    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        int index = tbl_cont.getSelectedRow();
        if (index != -1) {
            model_supplier mod = tblMod.getData(tbl_cont.convertRowIndexToModel(index));

            if (JOptionPane.showConfirmDialog(null, "Yakin Data Akan Dihapus", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                servis.hapusData(mod);
                tblMod.hapusData(index);
                loadData();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih dahulu data yang akan dihapus");
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        mainPanel.requestFocus();
        loadData();
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_bersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bersihActionPerformed
        String x = btn_bersih.getText();
        if (x.equals("CLEAR")) {
            tf_nama.setText("");
            tf_toko.setText("");
            tf_telp.setText("");
            tf_alamat.setText("");
        } else {
            clear();
            reset();

        }
        btn_bersih.setText("CLEAR");
        btn_batal1.setVisible(true);

    }//GEN-LAST:event_btn_bersihActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        String x = btn_simpan.getText();
        int row = tbl_cont.getSelectedRow();
        if (x.equals("SIMPAN")) {
            if (validasiIn()) {
                String kode = tf_kode.getText();
                String nama = tf_nama.getText();
                String toko = tf_toko.getText();
                String telp = tf_telp.getText();
                String alamat = tf_alamat.getText();

                model_supplier mod = new model_supplier();

                mod.setId_supplier(kode);
                mod.setNama_supplier(nama);
                mod.setToko_supplier(toko);
                mod.setTelp_supplier(telp);
                mod.setAlamat_supplier(alamat);

                servis.tambahData(mod);
                tblMod.tambahData(mod);
                loadData();
                reset();
                clear();
            }
        } else {
            if (validasiIn()) {
                String kode = tf_kode.getText();
                String nama = tf_nama.getText();
                String toko = tf_toko.getText();
                String telp = tf_telp.getText();
                String alamat = tf_alamat.getText();

                model_supplier mod = new model_supplier();

                mod.setId_supplier(kode);
                mod.setNama_supplier(nama);
                mod.setToko_supplier(toko);
                mod.setTelp_supplier(telp);
                mod.setAlamat_supplier(alamat);

                servis.ubahData(mod);
                tblMod.perbaruiData(mod);
                loadData();
                reset();
                clear();
                btn_bersih.setText("CLEAR");
                btn_batal1.setVisible(true);
            }
        }


    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_batal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batal1ActionPerformed
        clear();
        reset();
    }//GEN-LAST:event_btn_batal1ActionPerformed

    private void tf_kodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_kodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_kodeActionPerformed

    private void tbl_contMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_contMouseClicked
         if (btn_tambah.getText().equals("TAMBAH")) {
            btn_tambah.setText("UBAH");
        }
        btn_hapus.setVisible(true);
        btn_batal.setVisible(true);
    }//GEN-LAST:event_tbl_contMouseClicked

    private void btn_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseClicked
        String x = tf_search.getText();
        if (x.equals("Search") || x.trim().equals("")) {
            loadData();
        } else {
            List<model_supplier> list = servis.pencarianData(x);
            tblMod.setData(list);
        }
    }//GEN-LAST:event_btn_searchMouseClicked

    private void tf_namaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_namaKeyTyped

    }//GEN-LAST:event_tf_namaKeyTyped

    private void tf_alamatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_alamatKeyTyped

    }//GEN-LAST:event_tf_alamatKeyTyped

    private void tf_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyPressed
            pencarian();
    }//GEN-LAST:event_tf_searchKeyPressed

    private void tf_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_searchMouseClicked
       
    }//GEN-LAST:event_tf_searchMouseClicked

    private void tf_searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_searchFocusGained
        String username =tf_search.getText();
        if(username.equals("Search")){
            tf_search.setText("");
        }
    }//GEN-LAST:event_tf_searchFocusGained

    private void tf_searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_searchFocusLost
        String user = tf_search.getText();
        if (user.equalsIgnoreCase("Search") || user.equalsIgnoreCase("")){
            tf_search.setText("Search");
        }
    }//GEN-LAST:event_tf_searchFocusLost

    private void tf_tokoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_tokoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_tokoKeyTyped

    private void tf_telpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_telpKeyTyped
                char c = evt.getKeyChar();
        if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)))) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Masukan hanya bilangan angka !");

            evt.consume();
        }

    }//GEN-LAST:event_tf_telpKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonRectangle btn_batal;
    private rojerusan.RSMaterialButtonRectangle btn_batal1;
    private rojerusan.RSMaterialButtonRectangle btn_bersih;
    private rojerusan.RSMaterialButtonRectangle btn_hapus;
    private javax.swing.JLabel btn_search;
    private rojerusan.RSMaterialButtonRectangle btn_simpan;
    private rojerusan.RSMaterialButtonRectangle btn_tambah;
    private javax.swing.JPanel dataBarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel mainPanel;
    private custom.ScrollPaneWin11 scrollPaneWin111;
    private javax.swing.JPanel tambahBarang;
    private tablecustom.tablez tbl_cont;
    private javax.swing.JTextField tf_alamat;
    private javax.swing.JTextField tf_kode;
    private javax.swing.JTextField tf_nama;
    private javax.swing.JTextField tf_search;
    private javax.swing.JTextField tf_telp;
    private javax.swing.JTextField tf_toko;
    // End of variables declaration//GEN-END:variables

    private boolean validasiIn() {
        boolean valid = false;
        if (tf_kode.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kode tidak boleh kosong");
        } else if (tf_nama.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nama Barang tidak boleh kosong");
        } else if (tf_toko.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Toko Barang tidak boleh kosong");
        } else if (tf_telp.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No.Telp Customer tidak boleh kosong");
        } else if (tf_alamat.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Alamat tidak boleh kosong");
        } else {
            valid = true;
        }
        return valid;
    }

    private void loadData() {
        btn_hapus.setVisible(false);
        btn_batal.setVisible(false);
        List<model_supplier> list = servis.ambilData();
        tblMod.setData(list);
        if (btn_tambah.getText().equals("UBAH")) {
            btn_tambah.setText("TAMBAH");
        }
    }

    private void setColWidht() {
        int[] noCol = {0, 1, 2, 3};
        int[] noColW = {50, 90, 150, 150};

        TableColumnModel tblModel = tbl_cont.getColumnModel();
        for (int i = 0; i < noCol.length; i++) {
            tblModel.getColumn(noCol[i]).setPreferredWidth(noColW[i]);
            tblModel.getColumn(noCol[i]).setMaxWidth(noColW[i]);
            tblModel.getColumn(noCol[i]).setMinWidth(noColW[i]);
        }

    }

    private void clear() {
        btn_simpan.setText("SIMPAN");
        tf_nama.setText("");
        tf_toko.setText("");
        tf_telp.setText("");
        tf_alamat.setText("");
    }

    private void dataTable() {
        dataBarang.setVisible(false);
        tambahBarang.setVisible(true);

        int row = tbl_cont.getSelectedRow();
        jLabel2.setText("Perbarui Data Supplier");

        tf_kode.setText(tbl_cont.getModel().getValueAt(row, 1).toString());
        tf_nama.setText(tbl_cont.getModel().getValueAt(row, 2).toString());
        tf_toko.setText(tbl_cont.getModel().getValueAt(row, 3).toString());
        tf_telp.setText(tbl_cont.getModel().getValueAt(row, 4).toString());
        tf_alamat.setText(tbl_cont.getModel().getValueAt(row, 5).toString());

        aktif();
        btn_simpan.setText("PERBARUI");
        btn_bersih.setText("BATAL");
        btn_batal1.setVisible(false);

        mainPanel.removeAll();
        mainPanel.add(tambahBarang);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    private void aktif() {
        tf_kode.setEnabled(false);
        tf_nama.setEnabled(true);
        tf_toko.setEnabled(true);
        tf_telp.setEnabled(true);
        tf_alamat.setEnabled(true);
    }

    private void reset() {
        mainPanel.removeAll();
        mainPanel.add(dataBarang);
        mainPanel.repaint();
        mainPanel.revalidate();

        jLabel2.setText("Data Supplier");
        btn_simpan.setText("SIMPAN");
        btn_bersih.setEnabled(true);

    }

    private void pencarian() {
        List<model_supplier> list = servis.pencarianData(tf_search.getText().toLowerCase());
        tblMod.setData(list);
    }
}
