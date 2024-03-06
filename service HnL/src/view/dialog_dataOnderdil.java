/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;


import dao.DAO_onderdil;
import java.awt.Color;
import java.util.List;
import model.model_onderdil;
import service.service_onderdil;
import tableModel.table_onderdil;


/**
 *
 * @author SyafiqUbai
 */
public class dialog_dataOnderdil extends javax.swing.JDialog {

    int xx, xy;
    private service_onderdil servis = new DAO_onderdil();
    public table_onderdil tblMod = new table_onderdil();
    public model_onderdil jo = new model_onderdil();
    private String idSup;
    
    public dialog_dataOnderdil(java.awt.Frame parent, boolean modal, String idSup) {
        super(parent, modal);
        this.idSup=idSup;
        initComponents();
        
        //setBackground(new Color(0,0,0,0));
        
        tbl_data.setModel(tblMod);
        btn_search.requestFocus();
//        if(){
            loadDataByID();
//        }else{
            
//        }
         tf_search.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainJenis = new javax.swing.JPanel();
        scrollPaneWin111 = new custom.ScrollPaneWin11();
        tbl_data = new tablecustom.tablez();
        tf_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());

        mainJenis.setBackground(new java.awt.Color(255, 255, 255));
        mainJenis.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        scrollPaneWin111.setBackground(new java.awt.Color(255, 255, 255));
        scrollPaneWin111.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tbl_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dataMouseClicked(evt);
            }
        });
        scrollPaneWin111.setViewportView(tbl_data);

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

        btn_search.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search (1).png"))); // NOI18N
        btn_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_searchMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Data Onderdil");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout mainJenisLayout = new javax.swing.GroupLayout(mainJenis);
        mainJenis.setLayout(mainJenisLayout);
        mainJenisLayout.setHorizontalGroup(
            mainJenisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainJenisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_search)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainJenisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainJenisLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPaneWin111, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        mainJenisLayout.setVerticalGroup(
            mainJenisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainJenisLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainJenisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_search)
                    .addComponent(btn_search, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addContainerGap(336, Short.MAX_VALUE))
            .addGroup(mainJenisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainJenisLayout.createSequentialGroup()
                    .addGap(141, 141, 141)
                    .addComponent(scrollPaneWin111, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        getContentPane().add(mainJenis, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void tf_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_searchMouseClicked

    }//GEN-LAST:event_tf_searchMouseClicked

    private void tf_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyPressed
        pencarian();
    }//GEN-LAST:event_tf_searchKeyPressed

    private void btn_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseClicked
        String x = tf_search.getText();
        if (x.equals("Search") || x.trim().equals("")) {
            loadData();
        } else {
            List<model_onderdil> list = servis.pencarian(x);
            tblMod.setData( list);
        }
    }//GEN-LAST:event_btn_searchMouseClicked

    private void tbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseClicked
        pilihData();
    }//GEN-LAST:event_tbl_dataMouseClicked

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dialog_dataOnderdil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dialog_dataOnderdil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dialog_dataOnderdil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dialog_dataOnderdil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dialog_dataOnderdil dialog = new dialog_dataOnderdil(new javax.swing.JFrame(), true,"");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel mainJenis;
    private custom.ScrollPaneWin11 scrollPaneWin111;
    private tablecustom.tablez tbl_data;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables
    private void loadData() {
        List<model_onderdil> list = servis.getData();
        tblMod.setData(list);
        
    }
    private void loadDataByID() {
        List<model_onderdil> list = servis.getDataByID(idSup);
        tblMod.setData(list);
        
    }
    private void pencarian() {
        List<model_onderdil> list = servis.pencarian(tf_search.getText().toLowerCase());
        tblMod.setData(list);
    }

    private void pilihData(){
        int row = tbl_data.getSelectedRow();
        
        jo.setKode_onderdil(tbl_data.getModel().getValueAt(row, 1).toString());
        jo.setNama_onderdil(tbl_data.getModel().getValueAt(row, 5).toString());
        jo.setHarga_onderdil(Long.parseLong(tbl_data.getModel().getValueAt(row, 7).toString()));
        dispose();
    }
}
