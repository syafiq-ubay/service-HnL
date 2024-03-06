/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import dao.DAO_login;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import model.Model_Login;
import service.Service_Login;
import view.dialog_register;
/**
 *
 * @author SyafiqUbai
 */
public class login extends javax.swing.JFrame {
    int xx,xy;
    
    private Service_Login servis = new DAO_login();
    
    public static boolean tutup = false;
    
    public login() {
        initComponents();
        
        pn_login.requestFocus();
        lb_hidePassword.setVisible(false);
        lb_showPassword.setVisible(true);
    }

    void bersih() {
        tf_user.setText("username");
        tf_pass.setText("password");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_login = new javax.swing.JPanel();
        lb_hidePassword = new javax.swing.JLabel();
        lb_showPassword = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_close = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tf_user = new javax.swing.JTextField();
        tf_pass = new javax.swing.JPasswordField();
        rSButtonPane1 = new rojerusan.RSButtonPane();
        btn_login = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pn_login.setBackground(new java.awt.Color(255, 255, 255));
        pn_login.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pn_login.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pn_login.setFocusCycleRoot(true);
        pn_login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_hidePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Eye.png"))); // NOI18N
        lb_hidePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_hidePasswordMouseClicked(evt);
            }
        });
        pn_login.add(lb_hidePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, -1, 40));

        lb_showPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Hide.png"))); // NOI18N
        lb_showPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_showPasswordMouseClicked(evt);
            }
        });
        pn_login.add(lb_showPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, -1, 40));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/avatar_1.png"))); // NOI18N
        pn_login.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 70, -1));

        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        btn_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_closeMouseClicked(evt);
            }
        });
        pn_login.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, -1, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lock.png"))); // NOI18N
        pn_login.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user (1).png"))); // NOI18N
        pn_login.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background.png"))); // NOI18N
        pn_login.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        tf_user.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tf_user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_user.setText("username");
        tf_user.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tf_user.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_userFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_userFocusLost(evt);
            }
        });
        tf_user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_userKeyPressed(evt);
            }
        });
        pn_login.add(tf_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 219, 40));

        tf_pass.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tf_pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_pass.setText("password");
        tf_pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tf_pass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_passFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_passFocusLost(evt);
            }
        });
        tf_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_passKeyPressed(evt);
            }
        });
        pn_login.add(tf_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 219, 40));

        rSButtonPane1.setBackground(new java.awt.Color(0, 0, 0));
        rSButtonPane1.setColorHover(new java.awt.Color(102, 102, 102));
        rSButtonPane1.setColorNormal(new java.awt.Color(0, 0, 0));
        rSButtonPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonPane1MouseClicked(evt);
            }
        });

        btn_login.setBackground(new java.awt.Color(0, 0, 0));
        btn_login.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_login.setText("LOGIN");
        btn_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_loginMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout rSButtonPane1Layout = new javax.swing.GroupLayout(rSButtonPane1);
        rSButtonPane1.setLayout(rSButtonPane1Layout);
        rSButtonPane1Layout.setHorizontalGroup(
            rSButtonPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSButtonPane1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(btn_login)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        rSButtonPane1Layout.setVerticalGroup(
            rSButtonPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSButtonPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_login)
                .addGap(21, 21, 21))
        );

        pn_login.add(rSButtonPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 219, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setText("WELCOME");
        pn_login.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("belum punya akun?");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        pn_login.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 140, -1));

        getContentPane().add(pn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 420));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_formMouseDragged

    private void btn_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseClicked
        this.dispose();
    }//GEN-LAST:event_btn_closeMouseClicked

    private void btn_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseClicked
        prosesLogin();
    }//GEN-LAST:event_btn_loginMouseClicked

    private void tf_userFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_userFocusGained
        String username =tf_user.getText();
        if(username.equals("username")){
            tf_user.setText("");
        }
    }//GEN-LAST:event_tf_userFocusGained

    private void tf_userFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_userFocusLost
       String user = tf_user.getText();
        if (user.equalsIgnoreCase("username") || user.equalsIgnoreCase("")){
            tf_user.setText("username");
        }
    }//GEN-LAST:event_tf_userFocusLost

    private void tf_passFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_passFocusGained
        String username =tf_pass.getText();
        if(username.equals("password")){
            tf_pass.setText("");
        }
    }//GEN-LAST:event_tf_passFocusGained

    private void tf_passFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_passFocusLost
        String user = tf_pass.getText();
        if (user.equalsIgnoreCase("password") || user.equalsIgnoreCase("")){
            tf_pass.setText("password");
        }
    }//GEN-LAST:event_tf_passFocusLost

    private void tf_passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_passKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            prosesLogin();
        }
    }//GEN-LAST:event_tf_passKeyPressed

    private void tf_userKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_userKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            tf_pass.requestFocus();
        }     
    }//GEN-LAST:event_tf_userKeyPressed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseMoved

    private void lb_hidePasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_hidePasswordMouseClicked
        lb_showPassword.setVisible(true);
        lb_hidePassword.setVisible(false);

        tf_pass.setEchoChar('*');
    }//GEN-LAST:event_lb_hidePasswordMouseClicked

    private void lb_showPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_showPasswordMouseClicked
        lb_showPassword.setVisible(false);
        lb_hidePassword.setVisible(true);

        tf_pass.setEchoChar((char) 0);
    }//GEN-LAST:event_lb_showPasswordMouseClicked

    private void rSButtonPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonPane1MouseClicked
        prosesLogin();
    }//GEN-LAST:event_rSButtonPane1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        boolean closable = true;
        dialog_register djb = new dialog_register(null, closable);
        djb.setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_close;
    private javax.swing.JLabel btn_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lb_hidePassword;
    private javax.swing.JLabel lb_showPassword;
    private javax.swing.JPanel pn_login;
    private rojerusan.RSButtonPane rSButtonPane1;
    private javax.swing.JPasswordField tf_pass;
    private javax.swing.JTextField tf_user;
    // End of variables declaration//GEN-END:variables
    private void prosesLogin() {
        if (validasiIn() == true) {
            String ID   = tf_user.getText();
            String User = tf_user.getText();
            String pass = tf_pass.getText();

            Model_Login mod_log = new Model_Login();

            mod_log.setId_user(ID);
            mod_log.setUsername(User);
            mod_log.setPassword(pass);

            servis.prosesLogin(mod_log);
            if (tutup) {
                dispose();
            }
        }
    }

    private boolean validasiIn() {
        boolean valid = false;
        if (tf_user.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username tidak boleh kosong");
        } else if (tf_pass.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Password tidak boleh kosong");
        } else {
            valid = true;
        }
        return valid;
    }
}