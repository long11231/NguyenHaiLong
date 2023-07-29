/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package nguyenhailong_ph42034;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author H.Long
 */
public class SinhVienFame extends javax.swing.JFrame {

    DefaultTableModel model;
    SinhVienService svs = new SinhVienService();
    File file = new File("data.txt");

    /**
     * Creates new form SinhVienFame
     */
    public SinhVienFame() {
        initComponents();
        setTable();
        SinhVien sv1 = new SinhVien("Long", "PH42034", 9, 10, 8);
        SinhVien sv2 = new SinhVien("Hiếu", "PH42035", 9, 7, 8);
        SinhVien sv3 = new SinhVien("Long", "PH42036", 9, 2, 8);
        SinhVien sv4 = new SinhVien("Long", "PH42037", 9, 5, 8);
        SinhVien sv5 = new SinhVien("Long", "PH42038", 6, 7, 8);

        svs.setList(sv1);
        svs.setList(sv2);
        svs.setList(sv3);
        svs.setList(sv4);
        svs.setList(sv5);

        int row = jtbKQ.getSelectedRow();
        SinhVien sv6 = svs.getList().get(2);
        txtTen.setText(sv6.getTen());
        txtMasv.setText(sv6.getMssv());
        txtAnh.setText(sv6.getAnh() + "");
        txtToan.setText(sv6.getToan() + "");
        txtVan.setText(sv6.getVan() + "");

        fIllTable();
    }

    public void setTable() {
        model = (DefaultTableModel) jtbKQ.getModel();
        Object[] a = {"Tên", "Mã SV", "ĐTB"};
        model.setColumnIdentifiers(a);
        jtbKQ.setModel(model);
        model.setRowCount(0);
    }

    public void validateForm() {
        String ten = "";
        String msv = "";
        double toan = 0, van = 0, anh = 0;
        int demloi = 0;

        if (txtTen.getText().equals("")) {
            lbLoiTen.setText("Tên không được để trống");
            demloi++;
        } else {
            lbLoiTen.setText("");
            ten = txtTen.getText();
        }

        if (txtMasv.getText().equals("")) {
            lbLoiMa.setText("Mã sv không được để trống");
            demloi++;
        } else {
            lbLoiMa.setText("");
            msv = txtMasv.getText();
        }

        if (txtAnh.getText().equals("")) {
            lbLoiAnh.setText("Điểm anh không được để trống");
            demloi++;
        } else {
            try {
                anh = Double.valueOf(txtAnh.getText());
                if (anh < 0 || anh > 10) {
                    lbLoiAnh.setText("Điểm k được bé hơn 0 và lớn hơn 10");
                    demloi++;
                } else {
                    lbLoiAnh.setText("");
                }
            } catch (Exception e) {
                lbLoiAnh.setText("Lỗi dữ liệu");
                demloi++;
            }
        }

        if (txtToan.getText().equals("")) {
            lbLoiToan.setText("Điểm toán không được để trống");
            demloi++;
        } else {
            try {
                toan = Double.valueOf(txtToan.getText());
                if (toan < 0 || toan > 10) {
                    lbLoiToan.setText("Điểm k được bé hơn 0 và lớn hơn 10 ");
                    demloi++;
                } else {
                    lbLoiToan.setText("");
                }
            } catch (Exception e) {
                lbLoiToan.setText("Lỗi dữ liệu");
                demloi++;
            }
        }

        if (txtVan.getText().equals("")) {
            lbLoiVan.setText("Điểm văn không được để trống");
            demloi++;
        } else {
            try {
                van = Double.valueOf(txtVan.getText());
                if (van < 0 || van > 10) {
                    lbLoiVan.setText("Điểm k được bé hơn 0 và lớn hơn 10");
                    demloi++;
                } else {
                    lbLoiVan.setText("");
                }
            } catch (Exception e) {
                lbLoiVan.setText("Lỗi dữ liệu");
                demloi++;
            }
        }

        if (demloi == 0) {
            SinhVien sv = new SinhVien(ten, msv, toan, van, anh);
            svs.setList(sv);
            fIllTable();
            JOptionPane.showMessageDialog(this, "Thêm thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Thêm Thất Bại");
        }

    }

    public void fIllTable() {
        model.setRowCount(0);
        for (SinhVien sv : svs.getList()) {
            Object[] a = {sv.getTen(), sv.getMssv(), sv.dtb()};
            model.addRow(a);
        }
    }
    
    public void timdiemcao() {
    ArrayList<SinhVien> list = new ArrayList<>();
    for (SinhVien sv : svs.getList()) {
        if (sv.dtb() > 8) {
            list.add(sv);
        }
    }

    model.setRowCount(0); 

    for (SinhVien sv : list) {
        Object[] rowData = {sv.getTen(), sv.getMssv(), sv.dtb()};
        model.addRow(rowData); 
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        lbLoiTen = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMasv = new javax.swing.JTextField();
        lbLoiMa = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtToan = new javax.swing.JTextField();
        lbLoiToan = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtVan = new javax.swing.JTextField();
        lbLoiVan = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtAnh = new javax.swing.JTextField();
        lbLoiAnh = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbKQ = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnGhi = new javax.swing.JButton();
        btnMo = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tên :");

        jLabel3.setText("Mã sv :");

        jLabel5.setText("Toán");

        jLabel7.setText("Văn");

        jLabel9.setText("Anh");

        jtbKQ.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbKQ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbKQMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbKQ);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnGhi.setText("Ghi");
        btnGhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhiActionPerformed(evt);
            }
        });

        btnMo.setText("Mở");
        btnMo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoá");

        jButton1.setText("Tìm DTB cao nhat");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnThem)
                        .addGap(31, 31, 31)
                        .addComponent(btnGhi)
                        .addGap(32, 32, 32)
                        .addComponent(btnMo)
                        .addGap(34, 34, 34)
                        .addComponent(btnXoa))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbLoiTen, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbLoiAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMasv)
                                    .addComponent(txtToan)
                                    .addComponent(txtVan)
                                    .addComponent(txtAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                    .addComponent(lbLoiVan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbLoiMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbLoiToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbLoiTen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbLoiMa)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLoiToan)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtVan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbLoiVan)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbLoiAnh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnGhi)
                    .addComponent(btnMo)
                    .addComponent(btnXoa))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        validateForm();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnGhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhiActionPerformed
        try {
            GhiDoc.ghiFile(file, svs.getList());
            JOptionPane.showMessageDialog(this, "Ghi thành công");
        } catch (IOException ex) {
            Logger.getLogger(SinhVienFame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Ghi thất bại");
        }
    }//GEN-LAST:event_btnGhiActionPerformed

    private void btnMoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoActionPerformed
        ArrayList<SinhVien> list = GhiDoc.DocFile(file);
        if (list != null) {
            svs.getList().addAll(list);
            fIllTable();
        }
    }//GEN-LAST:event_btnMoActionPerformed

    private void jtbKQMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbKQMouseClicked
        int row = jtbKQ.getSelectedRow();
        SinhVien sv = svs.getList().get(row);
        txtTen.setText(sv.getTen());
        txtMasv.setText(sv.getMssv());
        txtAnh.setText(sv.getAnh() + "");
        txtToan.setText(sv.getToan() + "");
        txtVan.setText(sv.getVan() + "");

    }//GEN-LAST:event_jtbKQMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         timdiemcao();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SinhVienFame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SinhVienFame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SinhVienFame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SinhVienFame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SinhVienFame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGhi;
    private javax.swing.JButton btnMo;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbKQ;
    private javax.swing.JLabel lbLoiAnh;
    private javax.swing.JLabel lbLoiMa;
    private javax.swing.JLabel lbLoiTen;
    private javax.swing.JLabel lbLoiToan;
    private javax.swing.JLabel lbLoiVan;
    private javax.swing.JTextField txtAnh;
    private javax.swing.JTextField txtMasv;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtToan;
    private javax.swing.JTextField txtVan;
    // End of variables declaration//GEN-END:variables
}
