/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import view.supply;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;
import model.Model_Login;
import view.Laporan;
import view.barang_customer;
import view.kasir;
import view.jenis_onderdil;
import view.mekanik;
import view.onderdil;
import view.pembayaran_service;
import view.pembayaran_supply;
import view.service;
import view.supplier;

/**
 *
 * @author SyafiqUbai
 */
public class Menu_Utama extends javax.swing.JFrame {

    private Timer timer;
    
    public Menu_Utama(Model_Login ml) {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        execute();
        lb_nama.setText(ml.getNama());
        //timer dengan delay 1000 ms
        timer = new Timer(1000,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDayDateTime();
            }
        });
        
        timer.start();
    }
    
    private void showDayDateTime() {
        Calendar calender = Calendar.getInstance();
        Date now = new Date();
        SimpleDateFormat formatHari = new SimpleDateFormat("EEEE", new Locale("in","ID"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String hari = formatHari.format(calender.getTime());
        String dateTime = dateFormat.format(now);
        lb_tanggal.setText(hari+", "+dateTime);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelGradient1 = new jpanelgradient.JPanelGradient();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lb_tanggal = new javax.swing.JLabel();
        lb_nama = new javax.swing.JLabel();
        pn_sidebar = new javax.swing.JPanel();
        scrollPaneWin111 = new custom.ScrollPaneWin11();
        pn_menu = new javax.swing.JPanel();
        pn_content = new javax.swing.JPanel();
        pn_utama = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanelGradient1.setColorEnd(new java.awt.Color(102, 255, 204));
        jPanelGradient1.setColorStart(new java.awt.Color(0, 102, 102));
        jPanelGradient1.setPreferredSize(new java.awt.Dimension(955, 80));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MY SERVICE");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/service (2).png"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(88, 80));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Jl. Joyo Boyo Majapahit");

        lb_tanggal.setFont(new java.awt.Font("Palatino Linotype", 0, 14)); // NOI18N
        lb_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_tanggal.setText("Tanggal dan Waktu");

        lb_nama.setFont(new java.awt.Font("Palatino Linotype", 0, 12)); // NOI18N
        lb_nama.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_nama.setText("Login");

        javax.swing.GroupLayout jPanelGradient1Layout = new javax.swing.GroupLayout(jPanelGradient1);
        jPanelGradient1.setLayout(jPanelGradient1Layout);
        jPanelGradient1Layout.setHorizontalGroup(
            jPanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGradient1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 818, Short.MAX_VALUE)
                .addGroup(jPanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addComponent(lb_nama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        jPanelGradient1Layout.setVerticalGroup(
            jPanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGradient1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelGradient1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelGradient1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel3))
                            .addGroup(jPanelGradient1Layout.createSequentialGroup()
                                .addComponent(lb_nama)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelGradient1, java.awt.BorderLayout.PAGE_START);

        pn_sidebar.setPreferredSize(new java.awt.Dimension(250, 275));

        scrollPaneWin111.setBackground(new java.awt.Color(255, 255, 255));
        scrollPaneWin111.setBorder(null);

        pn_menu.setBackground(new java.awt.Color(255, 255, 255));
        pn_menu.setLayout(new javax.swing.BoxLayout(pn_menu, javax.swing.BoxLayout.Y_AXIS));
        scrollPaneWin111.setViewportView(pn_menu);

        javax.swing.GroupLayout pn_sidebarLayout = new javax.swing.GroupLayout(pn_sidebar);
        pn_sidebar.setLayout(pn_sidebarLayout);
        pn_sidebarLayout.setHorizontalGroup(
            pn_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneWin111, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        pn_sidebarLayout.setVerticalGroup(
            pn_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneWin111, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        );

        getContentPane().add(pn_sidebar, java.awt.BorderLayout.LINE_START);

        pn_utama.setBackground(new java.awt.Color(255, 255, 255));
        pn_utama.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pn_contentLayout = new javax.swing.GroupLayout(pn_content);
        pn_content.setLayout(pn_contentLayout);
        pn_contentLayout.setHorizontalGroup(
            pn_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_utama, javax.swing.GroupLayout.DEFAULT_SIZE, 1094, Short.MAX_VALUE)
        );
        pn_contentLayout.setVerticalGroup(
            pn_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_utama, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        );

        getContentPane().add(pn_content, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1360, 581));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        pn_utama.add(new dashboard());
        pn_utama.repaint();
        pn_utama.revalidate();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Model_Login ml = null;
                new Menu_Utama(ml).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private jpanelgradient.JPanelGradient jPanelGradient1;
    private javax.swing.JLabel lb_nama;
    private javax.swing.JLabel lb_tanggal;
    private javax.swing.JPanel pn_content;
    private javax.swing.JPanel pn_menu;
    private javax.swing.JPanel pn_sidebar;
    private javax.swing.JPanel pn_utama;
    private custom.ScrollPaneWin11 scrollPaneWin111;
    // End of variables declaration//GEN-END:variables

    private void execute() {
        //ICON MENU
        ImageIcon iconHome = new ImageIcon(getClass().getResource("/img/home (2).png"));
        ImageIcon iconMaster = new ImageIcon(getClass().getResource("/img/computer.png"));
        ImageIcon iconService = new ImageIcon(getClass().getResource("/img/repair-tool.png"));
        ImageIcon iconGudang = new ImageIcon(getClass().getResource("/img/warehouse.png"));
        ImageIcon iconTransaksi = new ImageIcon(getClass().getResource("/img/file.png"));
        ImageIcon iconRepport = new ImageIcon(getClass().getResource("/img/reload.png"));
        ImageIcon iconLogout = new ImageIcon(getClass().getResource("/img/exit.png"));
        
        //ICON DATA MASTEER   
        ImageIcon iconjenisOnderdil = new ImageIcon(getClass().getResource("/img/postal.png"));
        ImageIcon iconCustomer = new ImageIcon(getClass().getResource("/img/customer.png"));
        ImageIcon iconSupplier = new ImageIcon(getClass().getResource("/img/delivery-man.png"));
        ImageIcon iconKasir = new ImageIcon(getClass().getResource("/img/cashier.png"));
        ImageIcon iconMekanik = new ImageIcon(getClass().getResource("/img/mechanic.png"));
        
        //ICON GUDANG
        ImageIcon iconOnderdil = new ImageIcon(getClass().getResource("/img/goods.png"));
        ImageIcon iconProsesSuppy = new ImageIcon(getClass().getResource("/img/value-chain.png"));
        
        //ICON TRANSAKSI
        ImageIcon iconBM = new ImageIcon(getClass().getResource("/img/transaction (2).png"));
        ImageIcon iconBK = new ImageIcon(getClass().getResource("/img/transaction (1).png"));
        
        //ICON REPPORT
        ImageIcon iconLpOnderdil = new ImageIcon(getClass().getResource("/img/add-file.png"));
//        ImageIcon iconLpTransaksi = new ImageIcon(getClass().getResource("/img/transaction (1).png"));
        
        //MENU DATA MASTER
        MenuItem menuMekanik = new MenuItem(null, true, iconMekanik, "Mekanik", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pn_utama.removeAll();
                pn_utama.add(new mekanik());
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });
        MenuItem menuJenisOnderdil = new MenuItem(null, true, iconjenisOnderdil, "Jenis Onderdil", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pn_utama.removeAll();
                pn_utama.add(new jenis_onderdil());
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });
        
        MenuItem menuCustomer = new MenuItem(null, true, iconCustomer, "Barang Customer", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pn_utama.removeAll();
                pn_utama.add(new barang_customer());
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });
        MenuItem menuKasir = new MenuItem(null, true, iconKasir, "Kasir", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                pn_utama.removeAll();
                pn_utama.add(new kasir());
                pn_utama.repaint();
                pn_utama.revalidate();
            }
            
        });
        MenuItem menuSupplier = new MenuItem(null, true, iconSupplier, "Supplier", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pn_utama.removeAll();
                pn_utama.add(new supplier());
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });
        //MENU GUDANG
        MenuItem menuOnderdil = new MenuItem(null, true, iconOnderdil, "Onderdil", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pn_utama.removeAll();
                pn_utama.add(new onderdil());
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });
        //MENU TRANSAKSI
        MenuItem menuSupply = new MenuItem(null, true, iconProsesSuppy, "Supply", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pn_utama.removeAll();
                pn_utama.add(new supply());
                pn_utama.repaint();
                pn_utama.revalidate();
                }
        });
        MenuItem menuBM = new MenuItem(null, true, iconBM, "Pembayaran Supply", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pn_utama.removeAll();
                pn_utama.add(new pembayaran_supply());
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });
        MenuItem menuBK = new MenuItem(null, true, iconBK, "Pembayaran Service", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pn_utama.removeAll();
                pn_utama.add(new pembayaran_service());
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });
        //MENU REPPORT
        MenuItem Lp_onderdil_keluar = new MenuItem(null, true, iconLpOnderdil, "Laporan Keluar", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pn_utama.removeAll();
                pn_utama.add(new Laporan());
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });
        
        MenuItem Lp_onderdil_masuk = new MenuItem(null, true, iconLpOnderdil, "Laporan Riwayat", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pn_utama.removeAll();
                pn_utama.add(new Laporan());
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });
        
        
        //MENU HOME
        MenuItem menuHome = new MenuItem(iconHome, false,null,"Home", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pn_utama.removeAll();
                pn_utama.add(new dashboard());
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });
        MenuItem menuMaster = new MenuItem(iconMaster, false, null, "Data Master",null, menuCustomer,menuJenisOnderdil,menuOnderdil, menuSupplier,menuMekanik, menuKasir);
        MenuItem menuGudang = new MenuItem(iconGudang, false, null, "Gudang", null,menuOnderdil, menuSupply);
        MenuItem menuTransaksi = new MenuItem(iconTransaksi, false, null, "Transaksi", null,menuSupply,menuBK,menuBM);
        MenuItem menuRepport = new MenuItem(iconRepport, false, null, "Repport", null,Lp_onderdil_masuk);
        MenuItem menuService = new MenuItem(iconService, false, null, "Service", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pn_utama.removeAll();
                pn_utama.add(new service());
                pn_utama.repaint();
                pn_utama.revalidate();
            }
        });
        
        MenuItem menuLogout = new MenuItem(iconLogout, false, null, "Logout", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login l = new login();
                l.setVisible(true);
                dispose();
            }
        });

        addMenu(menuHome,menuMaster,menuService,menuTransaksi,menuRepport,menuLogout);
    }

    private void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
            pn_menu.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for (MenuItem m : subMenu) {
                addMenu(m);
            }
        }
        pn_menu.revalidate();
    }
}
