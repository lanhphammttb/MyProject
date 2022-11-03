/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CHoaDon;
import Model.HoaDon;
import static View.ThongKe.conn;
//import static groovy.ui.text.FindReplaceUtility.dispose;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PanelTKDoanhThuNgayThangNam extends javax.swing.JPanel {
    DefaultTableModel tblDanhSach;
    java.util.List<HoaDon> arr = new ArrayList<>();
    public static String sMaHoaDonTim, NgayLapHoaDon;
	public PanelTKDoanhThuNgayThangNam() {
		initComponents();
                tblDanhSach = (DefaultTableModel) dgDanhSach.getModel();
                sMaHoaDonTim="";
	}
    public void LayNguonHD(){
        arr = CHoaDon.LayNguonHD(sMaHoaDonTim);
        
        tblDanhSach.setRowCount(0); // xóa trắng danh sách
        arr.forEach(p->{
            tblDanhSach.addRow(new Object[] {
                p.getMaHoaDon(),p.getMaKhachHang(),p.getMaNhanVien(),p.getNgayLapHoaDon(),p.getKhuyenMai(),p.getTongTien()
            });
        });
    }
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmdTim = new javax.swing.JButton();
        cmdHien = new javax.swing.JButton();
        txtDate = new javax.swing.JTextField();
        btIn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgDanhSach = new javax.swing.JTable();
        lblTong = new javax.swing.JLabel();
        lblTongDoanhThu = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(102, 255, 153));
        jPanel1.setOpaque(false);

        jPanel2.setPreferredSize(new java.awt.Dimension(1366, 738));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Thống kê doanh thu");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Tìm kiếm theo ngày");

        cmdTim.setText("Tìm kiếm");
        cmdTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTimActionPerformed(evt);
            }
        });

        cmdHien.setText("Xem");
        cmdHien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdHienActionPerformed(evt);
            }
        });

        txtDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDateKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDateKeyReleased(evt);
            }
        });

        btIn.setText("In");
        btIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(383, 383, 383)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdTim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdHien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btIn)
                .addContainerGap(455, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmdTim, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmdHien)
                        .addComponent(btIn))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        dgDanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Mã Khách Hàng", "Mã Nhân Viên", "Ngày Lập Hóa Đơn", "Khuyến Mại", "Tổng Tiền", "Ghi Chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(dgDanhSach);

        lblTong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTong.setText("Tổng doanh thu");

        lblTongDoanhThu.setText("jLabel3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(493, 493, 493)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTong, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(lblTongDoanhThu)
                        .addGap(354, 354, 354))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTong)
                    .addComponent(lblTongDoanhThu))
                .addContainerGap(141, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTimActionPerformed
        NgayLapHoaDon = txtDate.getText();
        arr = CHoaDon.findByDate(NgayLapHoaDon);
        tblDanhSach.setRowCount(0); // xóa trắng danh sách
        arr.forEach(p->{
            tblDanhSach.addRow(new Object[] {
                p.getMaHoaDon(),p.getMaKhachHang(),p.getMaNhanVien(),p.getNgayLapHoaDon(), p.getKhuyenMai(),p.getTongTien() 
            });
        });
        Tong();

    }//GEN-LAST:event_cmdTimActionPerformed

    private void cmdHienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdHienActionPerformed
        NgayLapHoaDon="";
        LayNguonHD();
        Tong();
    }//GEN-LAST:event_cmdHienActionPerformed

    private void txtDateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDateKeyPressed

    }//GEN-LAST:event_txtDateKeyPressed

    private void txtDateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDateKeyReleased

    }//GEN-LAST:event_txtDateKeyReleased

    private void btInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInActionPerformed
        File file = new File("ThongKe.txt");
        file.delete();
        //Viết vào file txt
        try {
            Date now = new Date();
            Writer b = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("ThongKe.txt"), "UTF8"));
            b.write("\t\t\t\t\t\tCỬA HÀNG TRÀ SỮA\r\n\r\n");
            b.write("--------------------------------------------------------------------------------------------------------------------------------\r\n");
            b.write("\t\tMã HÐ\tMã KH\tMã NV\t\tNgày Lập Hóa Đơn\t\tKhuyến Mại\t\tTổng Tiền\r\n");
            b.write("--------------------------------------------------------------------------------------------------------------------------------\r\n");

            int line = dgDanhSach.getRowCount();
            for (int i = 0; i < line; i++) {
                String s1 = (String) dgDanhSach.getValueAt(i, 0);
                String s2 = (String) dgDanhSach.getValueAt(i, 1);
                String s3 = (String) dgDanhSach.getValueAt(i, 2);
                String s4 = (String) dgDanhSach.getValueAt(i, 3);
                String s5 = (String) dgDanhSach.getValueAt(i, 4);
                String s6 = (String) dgDanhSach.getValueAt(i, 5);
                b.write("\t\t" + s1 + "\t" + s2 + "\t" + s3 + "\t\t" + s4 + "\t\t" + s5+ "\t\t\t" + s6 + "\t" + "\r\n");
            }
            b.write("--------------------------------------------------------------------------------------------------------------------------------\r\n");
            b.write("\t\t\t\t\t\t\t\t\t\tTổng doang thu: " + lblTongDoanhThu.getText());
            b.close();
        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        //Mở file txt
        Runtime run = Runtime.getRuntime();
        try {
            run.exec("notepad ThongKe.txt");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btInActionPerformed
    private void Tong(){
        DecimalFormat x = new DecimalFormat("###,###,###");
        int Tong =0;
        for (int i = 0; i < dgDanhSach.getRowCount(); i++) {
            Tong +=Integer.parseInt(dgDanhSach.getValueAt(i, 5).toString());           
        }
        lblTongDoanhThu.setText(x.format(Tong)+ " "+"VNĐ");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIn;
    private javax.swing.JButton cmdHien;
    private javax.swing.JButton cmdTim;
    private javax.swing.JTable dgDanhSach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTong;
    private javax.swing.JLabel lblTongDoanhThu;
    private javax.swing.JTextField txtDate;
    // End of variables declaration//GEN-END:variables

}
