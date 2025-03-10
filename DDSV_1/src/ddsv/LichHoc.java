/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ddsv;

import Controller.LichHocController;
import DAO.databaseconect;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.lichhocmodel;

/**
 *
 * @author ADMIN
 */
public class LichHoc extends javax.swing.JFrame {

    private DefaultTableModel model;
    private LichHocController lhcontrol;

    public LichHoc() {
        initComponents();
        try {
            lhcontrol = new LichHocController();

        } catch (SQLException ex) {
            Logger.getLogger(LichHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Khởi tạo model cho JTable và gán cho JTable
        model = (DefaultTableModel) jTable1.getModel();
        // Load dữ liệu vào JTable
        loadData();

    }

    // Kết nối đến SQL Server
    // Lấy dữ liệu từ cơ sở dữ liệu và hiển thị vào JTable
    private void loadData() {

        model.setRowCount(0);

        for (lichhocmodel lh : lhcontrol.getDS()) {
            model.addRow(new Object[]{lh.getTenLop(), lh.getTenMon(), lh.getNgayHoc(), lh.getSoTiet()});
        }
    }

    private void loadData(List<lichhocmodel> ds) {

        model.setRowCount(0);

        for (lichhocmodel lh : ds) {
            model.addRow(new Object[]{lh.getTenLop(), lh.getTenMon(), lh.getNgayHoc(), lh.getSoTiet()});
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên lớp", "Tên môn học", "Ngày", "Số tiết"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Tìm kiếm");
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
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        String tenLop = (String) jTable1.getValueAt(row, 0);
        String tenMon = (String) jTable1.getValueAt(row, 1);
        String ngayHoc = (String) jTable1.getValueAt(row, 2);
        int soTiet = (int) jTable1.getValueAt(row, 3);

        D17CNPM1_CTDLGT form1 = new D17CNPM1_CTDLGT(this);
        form1.setVisible(true);
        form1.updateDataToAllRows(ngayHoc, soTiet, tenLop, tenMon);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String searchText = jTextField1.getText().toLowerCase(); // Lấy nội dung tìm kiếm và chuyển về chữ thường
        if (searchText.isEmpty()) {
            // Nếu ô tìm kiếm trống, tải lại tất cả dữ liệu
            loadData();
        } else {
            loadData(lhcontrol.getDS(searchText));
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Phương thức xóa dòng đã chọn trong bảng LichHoc
    public void deleteSelectedRowFromTable() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow >= 0) {
            // Xóa dòng khỏi model JTable

            // Sau đó, xóa dòng khỏi cơ sở dữ liệu
            String tenLop = (String) jTable1.getValueAt(selectedRow, 0);
            String tenMon = (String) jTable1.getValueAt(selectedRow, 1);
            String ngayHoc = (String) jTable1.getValueAt(selectedRow, 2);
            int soTiet = (int) jTable1.getValueAt(selectedRow, 3);

            lhcontrol.delete_lichhoc(tenLop, tenMon, ngayHoc, soTiet);
            model.removeRow(selectedRow);

        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng để xóa.");
        }
    }

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
            java.util.logging.Logger.getLogger(LichHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LichHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LichHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LichHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LichHoc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
