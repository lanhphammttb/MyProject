/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static Controller.CHoaDon.conn;
import View.ComboListener;
import Database.ConnectDB;
import static Database.ConnectDB.dbURL;
import static View.PanelHoaDon.conn;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tung
 */
public class ThongKe extends javax.swing.JFrame {

    ResultSet rs, rsTK, rsInfoEmp, rsSPBan;
    public static Connection conn;
    PreparedStatement ps, psTK, psSPBan;
    public static ConnectDB con = new ConnectDB();
    DefaultTableModel tblModel;
    Vector row, vecTK, vecSPBan;
    SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
//    SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
    NumberFormat formatter = new DecimalFormat("#,###");
    NumberFormat nft = new DecimalFormat("#,###");

    /**
     * Creates new form ThongKe
     */
    public ThongKe() {
        initComponents();
        btnPrint.setEnabled(false);
        tblModel = new DefaultTableModel();
        tblModel.addColumn("Mã hóa đơn");
        tblModel.addColumn("Tên sản phẩm");
        tblModel.addColumn("Loại sản phẩm");
        tblModel.addColumn("Size");
        tblModel.addColumn("Giá bán");
        tblModel.addColumn("Số lượng");
//        tblModel.addColumn("Thành tiền");
        tblThongKe.setModel(tblModel);
        loadBangSP();
        loadCBTK();

    }

    public void loadBangSP() {
        row = new Vector();
        try {
            conn = DriverManager.getConnection(dbURL);
            ps = conn.prepareStatement("select HoaDon.MaHoaDon, SanPham.MaSanPham, SanPham.TenSanPham, SanPham.LoaiSanPham, SanPham.Size, SanPham.GiaBan, ChiTietHoaDon.SoLuong from HoaDon, ChiTietHoaDon, SanPham where HoaDon.MaHoaDon = ChiTietHoaDon.MaHoaDon and SanPham.MaSanPham = ChiTietHoaDon.MaSanPham");
            rs = ps.executeQuery();
            int price, quantity, into;
            while (rs.next()) {               
                price = Integer.parseInt(rs.getString("GiaBan"));
                quantity = Integer.parseInt(rs.getString("SoLuong"));
                into = price * quantity;
                row.add(rs.getString("MaHoaDon"));
                row.add(rs.getString("TenSanPham"));
                row.add(rs.getString("LoaiSanPham"));
                row.add(rs.getString("Size"));
                row.add(rs.getString("GiaBan"));
                row.add(rs.getString("SoLuong"));
                tblModel.addRow(row);
            }
            tblThongKe.setModel(tblModel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi 101:: Không thể kết nối đến máy chủ");
        }
    }

//    public void loadBangSP() {
//        String cautruyvan = "";
//        int price, quantity, into;
//        cautruyvan = "select HoaDon.MaHoaDon, SanPham.MaSanPham, SanPham.TenSanPham, SanPham.LoaiSanPham, SanPham.Size, SanPham.GiaBan, ChiTietHoaDon.SoLuong\n" +
//"from HoaDon, ChiTietHoaDon, SanPham \n" +
//"where HoaDon.MaHoaDon = ChiTietHoaDon.MaHoaDon and SanPham.MaSanPham = ChiTietHoaDon.MaSanPham";
//        ResultSet rs = con.ExcuteQueryGetTable(cautruyvan);
//        Object[] obj = new Object[]{"Mã hóa đơn", "Tên sản phẩm", "Loại sản phẩm", "Size", "Giá bán","Số lượng"};
//        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
//        tblThongKe.setModel(tableModel);
//        try {
//            while (rs.next()) {
//                Object[] item = new Object[6];
//                price = Integer.parseInt(rs.getString("GiaBan"));
//                quantity = Integer.parseInt(rs.getString("SoLuong"));
//                into = price * quantity;               
//                item[0] = rs.getInt("MaHoaDon");
//                item[1] = rs.getString("TenSanPham");
//                item[2] = rs.getString("LoaiSanPham");
//                item[3] = rs.getString("Size");
//                item[4] = rs.getString("GiaBan");
//                item[5] = rs.getInt("SoLuong");
//                tableModel.addRow(item);
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.toString());
//        }
//    }   
    
    
    public void loadCBTK() {
        conn = null;
        cbTimKiemTK.removeAllItems();
        try {
            conn = DriverManager.getConnection(dbURL);
            String url = "Select DISTINCT TenSanPham from SanPham";
            ps = conn.prepareStatement(url);
            rsTK = ps.executeQuery();
            vecTK = new Vector();
            while (rsTK.next()) {//tim kiem
                vecTK.add(rsTK.getString("TenSanPham"));//tim kiem
            }
            JTextField text = (JTextField) cbTimKiemTK.getEditor().getEditorComponent();//tim kiem
            text.setText("");
            text.addKeyListener(new ComboListener(cbTimKiemTK, vecTK));//tim kiem
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi 101:: Không thể kết nối đến máy chủ");
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

        jPanel1 = new javax.swing.JPanel(){
            ImageIcon icon = new ImageIcon("image//thongke.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongKe = new javax.swing.JTable();
        cbTimKiemTK = new javax.swing.JComboBox();
        btnTimKiemTK = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        btnPrint = new javax.swing.JButton();
        txtStart = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        SPBan = new javax.swing.JButton();
        lbSPBan = new javax.swing.JLabel();
        txtdate1 = new com.toedter.calendar.JDateChooser();
        btnNgay = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thống Kê");

        tblThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblThongKe);

        cbTimKiemTK.setEditable(true);
        cbTimKiemTK.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnTimKiemTK.setText("Tìm Kiếm");
        btnTimKiemTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemTKActionPerformed(evt);
            }
        });

        btnReset.setText("Làm mới");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Tổng số lượng:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Tổng giá:");

        txtSoLuong.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtSoLuong.setEnabled(false);

        txtGia.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtGia.setEnabled(false);

        btnPrint.setText("In");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        txtStart.setDateFormatString("dd/MM/yyyy");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Sản phẩm đã bán:");

        SPBan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SPBan.setForeground(new java.awt.Color(255, 0, 255));
        SPBan.setText("Sản phẩm bán nhiều nhất");
        SPBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPBanActionPerformed(evt);
            }
        });

        txtdate1.setDateFormatString("dd/MM/yyyy");

        btnNgay.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnNgay.setForeground(new java.awt.Color(255, 0, 204));
        btnNgay.setText("Thống kê theo ngày");
        btnNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNgayActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("VNĐ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Từ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Đến");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbTimKiemTK, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtSoLuong)
                                        .addGap(74, 74, 74))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(SPBan)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(160, 160, 160)
                                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel2)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnPrint)
                                .addGap(99, 99, 99)
                                .addComponent(btnNgay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbSPBan, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(btnReset))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnTimKiemTK)
                                .addGap(47, 47, 47)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtStart, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbTimKiemTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(btnTimKiemTK)
                        .addComponent(jLabel7))
                    .addComponent(txtStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 8, Short.MAX_VALUE)
                                .addComponent(txtdate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSPBan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnNgay)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnReset)
                                    .addComponent(SPBan))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnPrint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemTKActionPerformed
        // TODO add your handling code here:
        tblModel.getDataVector().removeAllElements();
        String s1 = (String) cbTimKiemTK.getSelectedItem();
        if (cbTimKiemTK.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Tên sản phẩm không được để trống.");
            btnPrint.setEnabled(false);
        } else {
            try {

                psTK = conn.prepareStatement("select HoaDon.MaHoaDon, SanPham.MaSanPham, SanPham.TenSanPham, SanPham.LoaiSanPham, SanPham.Size, SanPham.GiaBan, ChiTietHoaDon.SoLuong from HoaDon, ChiTietHoaDon, SanPham where HoaDon.MaHoaDon = ChiTietHoaDon.MaHoaDon and SanPham.MaSanPham = ChiTietHoaDon.MaSanPham and SanPham.TenSanPham = ?");
                psTK.setString(1, (String) cbTimKiemTK.getSelectedItem());
                rsTK = psTK.executeQuery();
                if (rsTK.next()) {
                    psTK = conn.prepareStatement("select HoaDon.MaHoaDon, SanPham.MaSanPham, SanPham.TenSanPham, SanPham.LoaiSanPham, SanPham.Size, SanPham.GiaBan, ChiTietHoaDon.SoLuong from HoaDon, ChiTietHoaDon, SanPham where HoaDon.MaHoaDon = ChiTietHoaDon.MaHoaDon and SanPham.MaSanPham = ChiTietHoaDon.MaSanPham and SanPham.TenSanPham = ?");
                    psTK.setString(1, (String) cbTimKiemTK.getSelectedItem());
                    rsTK = psTK.executeQuery();
                    while (rsTK.next()) {
                        vecTK = new Vector();
                        vecTK.add(rsTK.getString("MaHoaDon"));
                        vecTK.add(rsTK.getString("TenSanPham"));
                        vecTK.add(rsTK.getString("LoaiSanPham"));
                        vecTK.add(rsTK.getString("Size"));
                        vecTK.add(rsTK.getString("GiaBan"));
                        vecTK.add(rsTK.getString("SoLuong"));                      
                        tblModel.addRow(vecTK);
                    }
                    tblThongKe.setModel(tblModel);
                } else {
                    JOptionPane.showMessageDialog(null, "Không tìm được sản phẩm");
                    loadBangSP();
                }
            } catch (Exception e) {
            }
            int line = tblThongKe.getRowCount();
            int tong = 0, tinhtien = 0, tongtien = 0;
            for (int i = 0; i < line; i++) {
//            if (tblThongKe.getValueAt(i, 1).equals(cbTimKiemTK.getSelectedItem())) {
                int SL = Integer.parseInt((String) tblThongKe.getValueAt(i, 5));
                int tien = Integer.parseInt((String) tblThongKe.getValueAt(i, 4));
                tong += SL;
                tinhtien += tien;
//                spQuantity.setValue(quanTotal);
                tongtien = tong*tien;
//            }
            }
            txtGia.setText(String.valueOf(nft.format(tongtien)));
            txtSoLuong.setText(String.valueOf(tong));
//        loadBangSP();
            cbTimKiemTK.setSelectedIndex(-1);
        }
        btnPrint.setEnabled(true);
    }//GEN-LAST:event_btnTimKiemTKActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtSoLuong.setText("");
        txtGia.setText("");
        cbTimKiemTK.setSelectedIndex(-1);
        tblModel.getDataVector().removeAllElements();
        loadBangSP();
        btnPrint.setEnabled(false);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        File file = new File("ThongKe.txt");
        file.delete();
        //Viết vào file txt
        try {
            Date now = new Date();
            Writer b = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("ThongKe.txt"), "UTF8"));
            b.write("\t\t\t\t\t\tCỬA HÀNG TRÀ SỮA\r\n\r\n");
//            b.write("\t\t\t\t\tThời gian: " + time.format(now) + "\r\n\r\n");
//            b.write("\t\t\t\t\tBẢNG THỐNG KÊ SẢN PHẨM " + ft.format(txtStart.getDate()) + "\r\n");
//            b.write("Tài khoản: " + cbTimKiemTK.getSelectedItem() + "\r\n");
            try {
                ps = conn.prepareStatement("Select DISTINCT TenSanPham from SanPham");
//                ps = con.prepareStatement("select * from OrderDetails join [Order] on OrderDetails.IDOrder=[Order].IDOrder"
//                    + " join Product on OrderDetails.IDProduct=Product.IDProduct Order by OrderDetails.IDOrder DESC");
                ps.setString(1, (String) cbTimKiemTK.getSelectedItem());
                rsInfoEmp = ps.executeQuery();
                if (rsInfoEmp.next()) {
                    b.write("Tên sản phẩm: " + rsInfoEmp.getString("TenSanPham") + "\r\n\r\n");
                }
            } catch (SQLException ex) {
            }
            b.write("--------------------------------------------------------------------------------------------------------------------------------\r\n");
            b.write("\t\tMã SP\tTên SP\t\t\t\tLoại SP\t\tSize\t\tĐơn giá (VNĐ)\t\tSố lượng\r\n");
            b.write("--------------------------------------------------------------------------------------------------------------------------------\r\n");

            int line = tblThongKe.getRowCount();
            for (int i = 0; i < line; i++) {
                String s1 = (String) tblThongKe.getValueAt(i, 0);
                String s2 = (String) tblThongKe.getValueAt(i, 1);
                String s3 = (String) tblThongKe.getValueAt(i, 2);
                String s4 = (String) tblThongKe.getValueAt(i, 3);
                String s5 = (String) tblThongKe.getValueAt(i, 4);
                String s6 = (String) tblThongKe.getValueAt(i, 5);
                b.write("\t\t" + s1 + "\t" + s2 + "\t\t\t" + s3 + "\t\t" + s4 + "\t\t" + s5+ "\t\t\t" + s6 + "\t" + "\r\n");
            }
            b.write("--------------------------------------------------------------------------------------------------------------------------------\r\n");
            b.write("\t\t\t\t\t\t\t\t\t\t\t\tTổng số lượng: " + txtSoLuong.getText() + "\r\n\r\n");
            b.write("\t\t\t\t\t\t\t\t\t\t\t\tTổng tiền: " + txtGia.getText() + "\tVNĐ");
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
        btnResetActionPerformed(evt);
    }//GEN-LAST:event_btnPrintActionPerformed

    private void SPBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPBanActionPerformed
        // TODO add your handling code here:

        tblModel.getDataVector().removeAllElements();
        try {

            psSPBan = conn.prepareStatement("select SanPham.MaSanPham, SanPham.TenSanPham, SanPham.LoaiSanPham, SanPham.Size, SanPham.GiaBan, SUM(ChiTietHoaDon.SoLuong) as Tong from SanPham, ChiTietHoaDon where SanPham.MaSanPham = ChiTietHoaDon.MaSanPham Group by SanPham.MaSanPham, SanPham.TenSanPham, SanPham.LoaiSanPham, SanPham.Size, SanPham.GiaBan order by Tong DESC");
            rsSPBan = psSPBan.executeQuery();
            while (rsSPBan.next()) {
                vecSPBan = new Vector();
                vecSPBan.add(rsSPBan.getString("MaSanPham"));
                vecSPBan.add(rsSPBan.getString("TenSanPham"));
                vecSPBan.add(rsSPBan.getString("LoaiSanPham"));
                vecSPBan.add(rsSPBan.getString("Size"));
                vecSPBan.add(rsSPBan.getString("GiaBan"));
                vecSPBan.add(rsSPBan.getString("Tong"));
                tblModel.addRow(vecSPBan);
            }
            tblThongKe.setModel(tblModel);
        } catch (Exception e) {
        }
        btnPrint.setEnabled(true);
    }//GEN-LAST:event_SPBanActionPerformed

    private void btnNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNgayActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        String start = ft.format(txtStart.getDate());
        String end = ft.format(txtdate1.getDate());
        while (true) {
            if (start.compareTo(end) >= 0) {
                JOptionPane.showMessageDialog(null, "Thời gian bắt đầu phải nhỏ hơn thời gian kết thúc.");
                return;
            } else {
                break;
            }
        }
        tblThongKe.removeAll();
        DefaultTableModel tblMD = new DefaultTableModel();
        tblMD.addColumn("Mã sản phẩm");
        tblMD.addColumn("Tên sản phẩm");
        tblMD.addColumn("Loại sản phẩm");
        tblMD.addColumn("Size");
        tblMD.addColumn("Giá bán");       
        tblMD.addColumn("Ngày");
        tblThongKe.setModel(tblMD);
        try {
            psSPBan = conn.prepareStatement("select SanPham.MaSanPham, SanPham.TenSanPham, SanPham.LoaiSanPham, SanPham.Size, SanPham.GiaBan, HoaDon.NgayLapHoaDon from SanPham, HoaDon, ChiTietHoaDon"
                    + " where HoaDon.NgayLapHoaDon >= '" + start + "'"
                    + "  and HoaDon.NgayLapHoaDon <= '" + end + "'and HoaDon.MaHoaDon = ChiTietHoaDon.MaHoaDon and SanPham.MaSanPham = ChiTietHoaDon.MaSanPham order by HoaDon.NgayLapHoaDon DESC ");
            rsSPBan = psSPBan.executeQuery();
            if (rsSPBan.next()) {
                psSPBan = conn.prepareStatement("select SanPham.MaSanPham, SanPham.TenSanPham, SanPham.LoaiSanPham, SanPham.Size, SanPham.GiaBan, HoaDon.NgayLapHoaDon from SanPham, HoaDon, ChiTietHoaDon"
                        + " where HoaDon.NgayLapHoaDon >= '" + start + "'"
                        + "  and HoaDon.NgayLapHoaDon <= '" + end + "'and HoaDon.MaHoaDon = ChiTietHoaDon.MaHoaDon and SanPham.MaSanPham = ChiTietHoaDon.MaSanPham order by HoaDon.NgayLapHoaDon DESC");
                rsSPBan = psSPBan.executeQuery();
                while (rsSPBan.next()) {
                    vecSPBan = new Vector();
                    vecSPBan.add(rsSPBan.getString("MaSanPham"));
                    vecSPBan.add(rsSPBan.getString("TenSanPham"));
                    vecSPBan.add(rsSPBan.getString("LoaiSanPham"));
                    vecSPBan.add(rsSPBan.getString("Size"));
                    vecSPBan.add(rsSPBan.getString("GiaBan"));
                    vecSPBan.add(rsSPBan.getString("NgayLapHoaDon"));
                    tblMD.addRow(vecSPBan);
                }
                tblThongKe.setModel(tblMD);
            } else {

            }
        } catch (Exception e) {
        }
        txtGia.setText("");
        txtSoLuong.setText("");
//        btnPrint.setEnabled(true);
    }//GEN-LAST:event_btnNgayActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SPBan;
    private javax.swing.JButton btnNgay;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTimKiemTK;
    private javax.swing.JComboBox cbTimKiemTK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbSPBan;
    private javax.swing.JTable tblThongKe;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtSoLuong;
    private com.toedter.calendar.JDateChooser txtStart;
    private com.toedter.calendar.JDateChooser txtdate1;
    // End of variables declaration//GEN-END:variables

}
