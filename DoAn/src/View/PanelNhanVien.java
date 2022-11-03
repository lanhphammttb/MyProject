/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CKhachHang;
//import Main.MainClass;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import Controller.CNhanVien;
import Controller.CUsers;
import Controller.KiemTraDuLieu_Controller;
//import Database.ConnectDB;
//import Database.PrintPDF;
import Model.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import javafx.scene.control.ComboBox;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import org.apache.xmlcommons.Version;
import org.netbeans.modules.form.InvalidComponent;
import Controller.KiemTraDuLieu_Controller;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Model.NhanVien;
import javax.swing.table.TableModel;
import Controller.CNhanVien;
import Database.ConnectDB;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static Database.ConnectDB.LayDuLieucbb;
import Model.Users;

public class PanelNhanVien extends javax.swing.JPanel {
    public static ConnectDB conn = new ConnectDB();
    DefaultTableModel tblDanhSach;
    java.util.List<NhanVien> arr = new ArrayList<>();
    String MaNhanVien, TenNhanVien, NgaySinh, GioiTinh, NgayVaoLam, ChucVu, DiaChi, SDT, CMND, sMaNhanVienTim;
    String macu;
    SimpleDateFormat sDF = new SimpleDateFormat("yyyy-MM-dd");
    Date date, date1;
    private final String[] colName = {"Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Giới tính", "Ngày vào làm", "Chức Vụ", "Địa chỉ", "Số điện thoại", "CMND"};
    private final String[] sqlName = {"MaNhanVien", "TenNhanVien", "NgaySinh", "GioiTinh","NgayVaoLam","ChucVu", "DiaChi", "SDT", "CMND"};
    Vector<String> vec = new Vector<String>(100);    
	public PanelNhanVien() {
		initComponents();
//                
//        tblDanhSach = (DefaultTableModel) tblNhanVien_NhanVien2.getModel();
//        sMaNhanVienTim="";
//        LayNguonNV();
	}

    
    public void XoaTrang(){
        txtMaNhanVien_NhanVien.setText("");
        txtTenNhanVien_NhanVien.setText("");
        txtDiaChi_NhanVien.setText(""); 
        txtSDT_NhanVien.setText("");
        txtCMND_NhanVien.setText("");
        cbGioiTinh.setSelectedIndex(0);
        cbbChucVu_NhanVien.setSelectedIndex(0);
    }
    
//    public void  LayNguonNV(){
//        arr = CNhanVien.LayNguonNV(sMaNhanVienTim);
//        tblDanhSach.setRowCount(0); // xóa trắng danh sách
//        arr.forEach(p->{
//            tblDanhSach.addRow(new Object[]{
//                p.getMaNhanVien(), p.getTenNhanVien(),p.getNgaySinh(),p.getGioiTinh(),p.getNgayVaoLam(),p.getChucVu(),p.getDiaChi(),p.getSDT(),p.getCMND()
//            });
//        });
//    } 
	private void loadDataTableS() {
		try {
			String col = sqlName[CBTK.getSelectedIndex()];
			String key = txtTimKiem.getText();
			DefaultTableModel tableModel = new DefaultTableModel();
                	Database.ConnectDB conn = new Database.ConnectDB ();
			Vector<String> colsName = new Vector<String>(10);
			colsName.add("Mã nhân viên");
			colsName.add("Tên nhân viên");
			colsName.add("Ngày sinh");
			colsName.add("Giới tính");
                        colsName.add("Ngày vào làm");
                        colsName.add("Chức vụ");
			colsName.add("Địa chỉ");
			colsName.add("Số điện thoại");
                        colsName.add("CMND");
			
			tableModel.setColumnIdentifiers(colsName);
			
			vec = conn.selectSearch("NhanVien", col, key);
			
			String[][] str = new String[vec.size()][];
			for (int i = 0; i < vec.size(); i++) {
				Vector<String> vector = new Vector<String>(100);
				str[i] = vec.get(i).split("\t");
				for (int j = 0; j < str[i].length; j++) {
					vector.add(str[i][j]);
				}
				tableModel.addRow(vector);
			}
			tblNhanVien_NhanVien2.setModel(tableModel);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không có kết quả tìm kiếm ", "Thông báo", 1);
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

        gioiTinh = new javax.swing.ButtonGroup();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblNhanVien_NhanVien = new javax.swing.JTable();
        jTabbedPaneNhanVien = new javax.swing.JTabbedPane();
        jPanelNhanVien = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tblNhanVien_NhanVien2 = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        lblTenNhanVien_NhanVien = new javax.swing.JLabel();
        lblMaNhanVien_NhanVien = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txtTenNhanVien_NhanVien = new javax.swing.JTextField();
        txtMaNhanVien_NhanVien = new javax.swing.JTextField();
        dtNgayVaoLam = new com.toedter.calendar.JDateChooser();
        cbGioiTinh = new javax.swing.JComboBox<>();
        dtNgaySinh = new com.toedter.calendar.JDateChooser();
        lblDiaChi_NhanVien = new javax.swing.JLabel();
        lblSDT_NhanVien = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        txtDiaChi_NhanVien = new javax.swing.JTextField();
        txtSDT_NhanVien = new javax.swing.JTextField();
        cbbChucVu_NhanVien = new javax.swing.JComboBox<>();
        txtCMND_NhanVien = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        CBTK = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        btThem = new javax.swing.JButton();
        btSua = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        btKhong = new javax.swing.JButton();
        jPanelTaiKhoan = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblTaiKhoan_TaiKhoan = new javax.swing.JTable();
        btnThem_TaiKhoan = new javax.swing.JButton();
        btnXoa_TaiKhoan = new javax.swing.JButton();
        btnSua_TaiKhoan = new javax.swing.JButton();
        btnReset_TaiKhoan = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtUserName_TaiKhoan = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        cbbQuyen_TaiKhoan = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtPassWord_TaiKhoan = new javax.swing.JPasswordField();
        jLabel55 = new javax.swing.JLabel();
        txtID_TaiKhoan = new javax.swing.JTextField();
        cbbTenNhanVien_TaiKhoan = new javax.swing.JComboBox<>();
        jScrollPane25 = new javax.swing.JScrollPane();
        txtChuThich_TaiKhoan = new javax.swing.JTextPane();
        jPanelChucVu = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblChucVu_ChucVu = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtTenChucVu_ChucVu = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        txtChuThich_ChucVu = new javax.swing.JTextArea();
        btnThem_ChucVu = new javax.swing.JButton();
        btnSua_ChucVu = new javax.swing.JButton();
        btnReset_ChucVu = new javax.swing.JButton();
        txtMaChucVu_ChucVu = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        btnXoaNeuRong_ChucVu = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblNhanVien_ChucVu = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        tblNhanVien_NhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Nhân Viên", "Tên Nhân Viên", "Ngày Sinh ", "Giới Tính", "Ngày Vào Làm", "Chức Vụ", "Địa Chỉ", "Số ĐT", "Ghi Chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanVien_NhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVien_NhanVienMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblNhanVien_NhanVien);

        setBackground(new java.awt.Color(204, 204, 255));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1366, 700));

        jTabbedPaneNhanVien.setBackground(new java.awt.Color(204, 204, 255));
        jTabbedPaneNhanVien.setPreferredSize(new java.awt.Dimension(1366, 738));
        jTabbedPaneNhanVien.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTabbedPaneNhanVienComponentShown(evt);
            }
        });

        jPanelNhanVien.setBackground(new java.awt.Color(204, 204, 255));
        jPanelNhanVien.setPreferredSize(new java.awt.Dimension(1366, 738));
        jPanelNhanVien.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanelNhanVienComponentShown(evt);
            }
        });

        tblNhanVien_NhanVien2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Ngày Sinh ", "Giới Tính", "Ngày Vào Làm", "Chức Vụ", "Địa Chỉ", "Số Điện Thoại", "CMND"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanVien_NhanVien2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVien_NhanVien2MouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(tblNhanVien_NhanVien2);

        jPanel15.setBackground(new java.awt.Color(204, 204, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jPanel16.setBackground(new java.awt.Color(204, 204, 255));

        lblTenNhanVien_NhanVien.setText("Tên Nhân Viên");

        lblMaNhanVien_NhanVien.setText("Mã Nhân Viên");

        jLabel45.setText("Ngày Sinh");

        jLabel46.setText("Giới Tính");

        jLabel47.setText("Ngày Vào Làm");

        txtMaNhanVien_NhanVien.setEditable(false);
        txtMaNhanVien_NhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNhanVien_NhanVienActionPerformed(evt);
            }
        });

        dtNgayVaoLam.setDateFormatString("dd/MM/yyyy");

        cbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

        dtNgaySinh.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenNhanVien_NhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(lblMaNhanVien_NhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel45)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaNhanVien_NhanVien)
                    .addComponent(txtTenNhanVien_NhanVien)
                    .addComponent(dtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(cbGioiTinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtNgayVaoLam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaNhanVien_NhanVien)
                    .addComponent(txtMaNhanVien_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenNhanVien_NhanVien)
                    .addComponent(txtTenNhanVien_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45)
                    .addComponent(dtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(cbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47)
                    .addComponent(dtNgayVaoLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        lblDiaChi_NhanVien.setText("Địa Chỉ");

        lblSDT_NhanVien.setText("Số Điện Thoại");

        jLabel51.setText("CMND");

        jLabel52.setText("Chức Vụ");

        txtDiaChi_NhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChi_NhanVienActionPerformed(evt);
            }
        });

        txtSDT_NhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDT_NhanVienActionPerformed(evt);
            }
        });

        cbbChucVu_NhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbChucVu_NhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbChucVu_NhanVienActionPerformed(evt);
            }
        });

        txtCMND_NhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCMND_NhanVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDiaChi_NhanVien)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51)
                    .addComponent(lblSDT_NhanVien))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtSDT_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbbChucVu_NhanVien, 0, 239, Short.MAX_VALUE)
                                .addComponent(txtDiaChi_NhanVien))
                            .addComponent(txtCMND_NhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(cbbChucVu_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiaChi_NhanVien)
                    .addComponent(txtDiaChi_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSDT_NhanVien)
                    .addComponent(txtSDT_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCMND_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 2), "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 0, 0))); // NOI18N

        jPanel6.setBackground(new java.awt.Color(204, 255, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel11.setText("Chọn khóa tìm kiếm :");

        jLabel12.setText("Nhập từ khóa tìm kiếm :");

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tkiemnhanvien24.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tkiemnhanvien24.png"))); // NOI18N
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        CBTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Giới tính", "Ngày vào làm", "Chức Vụ", "Địa chỉ", "Số điện thoại", "CMND" }));
        CBTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBTKActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/refresh16.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CBTK, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(btnTimKiem)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CBTK, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem)
                .addContainerGap())
        );

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/3d-building.jpg"))); // NOI18N

        btThem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/file_blank_paper_document_page_icon_196467.png"))); // NOI18N
        btThem.setText("Thêm");
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        btSua.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/settings_options_configuration_setting_system_icon_196481.png"))); // NOI18N
        btSua.setText("Sửa");
        btSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaActionPerformed(evt);
            }
        });

        btXoa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bin_trash_rubbish_dustbin_remove_icon_196490.png"))); // NOI18N
        btXoa.setText("Xóa");
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        btKhong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btKhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Close_Icon_Dark_icon-icons.com_69143.png"))); // NOI18N
        btKhong.setText("Reset");
        btKhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btThem, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btKhong, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThem)
                    .addComponent(btSua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btXoa)
                    .addComponent(btKhong))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelNhanVienLayout = new javax.swing.GroupLayout(jPanelNhanVien);
        jPanelNhanVien.setLayout(jPanelNhanVienLayout);
        jPanelNhanVienLayout.setHorizontalGroup(
            jPanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNhanVienLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelNhanVienLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 1027, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanelNhanVienLayout.setVerticalGroup(
            jPanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNhanVienLayout.createSequentialGroup()
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151))
                    .addGroup(jPanelNhanVienLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPaneNhanVien.addTab("Nhân Viên", jPanelNhanVien);

        jPanelTaiKhoan.setBackground(new java.awt.Color(204, 204, 255));
        jPanelTaiKhoan.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanelTaiKhoanComponentShown(evt);
            }
        });

        tblTaiKhoan_TaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "ID", "Tên Nhân Viên ", "UserName", "PassWord", "Quyền", "Ghi Chú"
            }
        ));
        tblTaiKhoan_TaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTaiKhoan_TaiKhoanMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblTaiKhoan_TaiKhoan);

        btnThem_TaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/file_blank_paper_document_page_icon_196467.png"))); // NOI18N
        btnThem_TaiKhoan.setText("Thêm ");
        btnThem_TaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem_TaiKhoanActionPerformed(evt);
            }
        });

        btnXoa_TaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bin_trash_rubbish_dustbin_remove_icon_196490.png"))); // NOI18N
        btnXoa_TaiKhoan.setText("Xóa");
        btnXoa_TaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa_TaiKhoanActionPerformed(evt);
            }
        });

        btnSua_TaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/settings_options_configuration_setting_system_icon_196481.png"))); // NOI18N
        btnSua_TaiKhoan.setText("Sửa");
        btnSua_TaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua_TaiKhoanActionPerformed(evt);
            }
        });

        btnReset_TaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Close_Icon_Dark_icon-icons.com_69143.png"))); // NOI18N
        btnReset_TaiKhoan.setText("Reset");
        btnReset_TaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset_TaiKhoanActionPerformed(evt);
            }
        });

        jLabel18.setText("Tên Nhân Viên");

        jLabel21.setText("User");

        jLabel22.setText("Password");

        jLabel23.setText("Quyền");

        cbbQuyen_TaiKhoan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân Viên", "Admin" }));

        jLabel24.setText("Chú Thích");

        jLabel41.setText("Tài Khoản");

        txtPassWord_TaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassWord_TaiKhoanActionPerformed(evt);
            }
        });

        jLabel55.setText("ID");

        txtID_TaiKhoan.setEditable(false);

        cbbTenNhanVien_TaiKhoan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jScrollPane25.setViewportView(txtChuThich_TaiKhoan);

        javax.swing.GroupLayout jPanelTaiKhoanLayout = new javax.swing.GroupLayout(jPanelTaiKhoan);
        jPanelTaiKhoan.setLayout(jPanelTaiKhoanLayout);
        jPanelTaiKhoanLayout.setHorizontalGroup(
            jPanelTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTaiKhoanLayout.createSequentialGroup()
                .addGroup(jPanelTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTaiKhoanLayout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(jLabel41))
                    .addGroup(jPanelTaiKhoanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanelTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelTaiKhoanLayout.createSequentialGroup()
                        .addGroup(jPanelTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanelTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbbTenNhanVien_TaiKhoan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbQuyen_TaiKhoan, javax.swing.GroupLayout.Alignment.LEADING, 0, 239, Short.MAX_VALUE)
                            .addComponent(txtID_TaiKhoan, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUserName_TaiKhoan, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassWord_TaiKhoan, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane25)))
                    .addGroup(jPanelTaiKhoanLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanelTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnXoa_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanelTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSua_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReset_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(148, 148, 148))
        );
        jPanelTaiKhoanLayout.setVerticalGroup(
            jPanelTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTaiKhoanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41)
                .addGroup(jPanelTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTaiKhoanLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(cbbTenNhanVien_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUserName_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPassWord_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(cbbQuyen_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelTaiKhoanLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24))
                            .addGroup(jPanelTaiKhoanLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36)
                        .addGroup(jPanelTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem_TaiKhoan)
                            .addComponent(btnSua_TaiKhoan))
                        .addGap(32, 32, 32)
                        .addGroup(jPanelTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoa_TaiKhoan)
                            .addComponent(btnReset_TaiKhoan))
                        .addGap(191, 191, 191))
                    .addGroup(jPanelTaiKhoanLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPaneNhanVien.addTab("Tài Khoản", jPanelTaiKhoan);

        jPanelChucVu.setBackground(new java.awt.Color(204, 204, 255));
        jPanelChucVu.setPreferredSize(new java.awt.Dimension(1030, 600));
        jPanelChucVu.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanelChucVuComponentShown(evt);
            }
        });

        tblChucVu_ChucVu.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã Chức Vụ", "Tên Chức Vụ", "Ghi Chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblChucVu_ChucVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChucVu_ChucVuMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tblChucVu_ChucVu);

        jPanel20.setBackground(new java.awt.Color(204, 204, 255));

        jLabel25.setText("Mã Chức Vụ");

        jLabel26.setText("Tên Chức Vụ");

        jLabel27.setText("Ghi Chú");

        txtChuThich_ChucVu.setColumns(20);
        txtChuThich_ChucVu.setRows(5);
        jScrollPane13.setViewportView(txtChuThich_ChucVu);

        btnThem_ChucVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/file_blank_paper_document_page_icon_196467.png"))); // NOI18N
        btnThem_ChucVu.setText("Thêm");
        btnThem_ChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem_ChucVuActionPerformed(evt);
            }
        });

        btnSua_ChucVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/settings_options_configuration_setting_system_icon_196481.png"))); // NOI18N
        btnSua_ChucVu.setText("Sửa");
        btnSua_ChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua_ChucVuActionPerformed(evt);
            }
        });

        btnReset_ChucVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Close_Icon_Dark_icon-icons.com_69143.png"))); // NOI18N
        btnReset_ChucVu.setText("Reset");
        btnReset_ChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset_ChucVuActionPerformed(evt);
            }
        });

        txtMaChucVu_ChucVu.setEditable(false);
        txtMaChucVu_ChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaChucVu_ChucVuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenChucVu_ChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(txtMaChucVu_ChucVu)))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(btnThem_ChucVu)
                        .addGap(27, 27, 27)
                        .addComponent(btnSua_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnReset_ChucVu))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtMaChucVu_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtTenChucVu_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem_ChucVu)
                    .addComponent(btnSua_ChucVu)
                    .addComponent(btnReset_ChucVu))
                .addContainerGap())
        );

        jPanel21.setBackground(new java.awt.Color(204, 204, 255));

        jLabel28.setText("Lư ý khi xóa có thể gây ra lỗi khi xóa phải nhân viên nằm trong Hóa Đơn");

        btnXoaNeuRong_ChucVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/xoa24.png"))); // NOI18N
        btnXoaNeuRong_ChucVu.setText("Xóa Nếu Rỗng");
        btnXoaNeuRong_ChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNeuRong_ChucVuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addContainerGap())
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(btnXoaNeuRong_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoaNeuRong_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(168, Short.MAX_VALUE))
        );

        tblNhanVien_ChucVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                "STT", "Mã Nhân Viên", "Tên Nhân Viên", "Chức Vụ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(tblNhanVien_ChucVu);

        jLabel7.setText("Chức Vụ");

        jLabel8.setText("Nhân Viên");

        javax.swing.GroupLayout jPanelChucVuLayout = new javax.swing.GroupLayout(jPanelChucVu);
        jPanelChucVu.setLayout(jPanelChucVuLayout);
        jPanelChucVuLayout.setHorizontalGroup(
            jPanelChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelChucVuLayout.createSequentialGroup()
                .addGroup(jPanelChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelChucVuLayout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelChucVuLayout.createSequentialGroup()
                        .addContainerGap(64, Short.MAX_VALUE)
                        .addGroup(jPanelChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
                            .addComponent(jScrollPane11))))
                .addGap(18, 18, 18)
                .addGroup(jPanelChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
            .addGroup(jPanelChucVuLayout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelChucVuLayout.setVerticalGroup(
            jPanelChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChucVuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(148, 148, 148))
        );

        jTabbedPaneNhanVien.addTab("Chức Vụ", jPanelChucVu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblNhanVien_NhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVien_NhanVienMouseClicked

    }//GEN-LAST:event_tblNhanVien_NhanVienMouseClicked

    private void tblNhanVien_NhanVien2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVien_NhanVien2MouseClicked
    try{
        int index = tblNhanVien_NhanVien2.getSelectedRow();
        TableModel model = tblNhanVien_NhanVien2.getModel();
        MaNhanVien = model.getValueAt(index, 0).toString();
        TenNhanVien = model.getValueAt(index, 1).toString();
        NgaySinh = model.getValueAt(index, 2).toString();
        GioiTinh = model.getValueAt(index, 3).toString();
        NgayVaoLam = model.getValueAt(index, 4).toString();
        ChucVu = model.getValueAt(index, 5).toString();
        DiaChi = model.getValueAt(index, 6).toString();
        SDT = model.getValueAt(index, 7).toString();
        CMND = model.getValueAt(index, 8).toString();

        txtMaNhanVien_NhanVien.setText(MaNhanVien);
        txtTenNhanVien_NhanVien.setText(TenNhanVien);
        try {
            date = sDF.parse(NgaySinh);
            dtNgaySinh.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(PanelNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }        
        cbGioiTinh.setSelectedItem(GioiTinh);       
        try {
            date1 = sDF.parse(NgayVaoLam);
            dtNgayVaoLam.setDate(date1);
        } catch (ParseException ex) {
            Logger.getLogger(PanelNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        setSelectedCombobox(ChucVu, cbbChucVu_NhanVien);
        //cbbChucVu_NhanVien.setSelectedItem(ChucVu);
        txtDiaChi_NhanVien.setText(DiaChi);
        txtSDT_NhanVien.setText(SDT);
        txtCMND_NhanVien.setText(CMND);
    } catch (NullPointerException ex) {
    System.out.println("Bắt ngoại lệ dữ liệu null:" + ex);
}     
        //manv,hoten,gioitinh,ngaysinh,sdt,usernv,passnv,email,diachi
    }//GEN-LAST:event_tblNhanVien_NhanVien2MouseClicked

    private void txtMaNhanVien_NhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNhanVien_NhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNhanVien_NhanVienActionPerformed

    private void txtDiaChi_NhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChi_NhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChi_NhanVienActionPerformed

    private void txtSDT_NhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDT_NhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDT_NhanVienActionPerformed

    private void jPanelNhanVienComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanelNhanVienComponentShown
    layDuLieuNhanVien();
    cbbChucVu_NhanVien.setModel(LayDuLieucbb("ChucVu", "TenChucVu", "MaChucVu"));
    cbbTenNhanVien_TaiKhoan.setModel(LayDuLieucbb("NhanVien", "TenNhanVien", "MaNhanVien"));
    }//GEN-LAST:event_jPanelNhanVienComponentShown

    private void tblTaiKhoan_TaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTaiKhoan_TaiKhoanMouseClicked
    try {
        int viTriDongVuaBam = tblTaiKhoan_TaiKhoan.getSelectedRow();
        txtID_TaiKhoan.setText(tblTaiKhoan_TaiKhoan.getValueAt(viTriDongVuaBam, 1).toString());
        setSelectedCombobox(tblTaiKhoan_TaiKhoan.getValueAt(viTriDongVuaBam, 2).toString(), cbbTenNhanVien_TaiKhoan);
        txtUserName_TaiKhoan.setText(tblTaiKhoan_TaiKhoan.getValueAt(viTriDongVuaBam, 3).toString());       
        txtPassWord_TaiKhoan.setText(tblTaiKhoan_TaiKhoan.getValueAt(viTriDongVuaBam, 4).toString());            
        cbbQuyen_TaiKhoan.setSelectedItem(tblTaiKhoan_TaiKhoan.getValueAt(viTriDongVuaBam, 5).toString());
        txtChuThich_TaiKhoan.setText(tblTaiKhoan_TaiKhoan.getValueAt(viTriDongVuaBam, 6).toString());
    } catch (NullPointerException ex) {
    System.out.println("Bắt ngoại lệ dữ liệu null:" + ex);
}       
    }//GEN-LAST:event_tblTaiKhoan_TaiKhoanMouseClicked

    private void btnThem_TaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem_TaiKhoanActionPerformed
        String ID, MaNhanVien, UserName, PassWord, Quyen, GhiChu;
        ID = txtID_TaiKhoan.getText();
        MaNhanVien = GetCbbSelected(cbbTenNhanVien_TaiKhoan);
        UserName= txtUserName_TaiKhoan.getText();
        PassWord = String.valueOf(txtPassWord_TaiKhoan.getPassword()).trim();
        Quyen = cbbQuyen_TaiKhoan.getSelectedItem().toString();
        GhiChu = txtChuThich_TaiKhoan.getText();
//        String cautruyvan = "insert into Users values(" + MaNhanVien
//        + " ,'" + UserName + "' , '" + PassWord + "' , N'" + Quyen
//        + "', N'" + CMND + "')";
//        System.out.println(cautruyvan);
        boolean kiemtra = true;
        Users u = new Users(ID, MaNhanVien, UserName, PassWord, Quyen, GhiChu);
        if (kiemtra) {
            CUsers.ThemMoi(u);
            System.out.println("Đã Thêm Thành Công");
        } else {
            ThongBao("Không thể Thêm tài Khoản", "lỗi", 2);
        }
        layDuLieuTaiKhoan();
    }//GEN-LAST:event_btnThem_TaiKhoanActionPerformed

    private void btnSua_TaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua_TaiKhoanActionPerformed
        String ID, MaNhanVien, UserName, PassWord, Quyen, GhiChu;
        ID = txtID_TaiKhoan.getText();
        MaNhanVien = GetCbbSelected(cbbTenNhanVien_TaiKhoan);
        UserName = txtUserName_TaiKhoan.getText();
        PassWord = String.valueOf(txtPassWord_TaiKhoan.getPassword()).trim();
        Quyen = cbbQuyen_TaiKhoan.getSelectedItem().toString();
        GhiChu = txtChuThich_TaiKhoan.getText();
        String cautruyvan = "update  Users set MaNhanVien=" + MaNhanVien
        + " ,UserName='" + UserName + "' ,PassWord= '" + PassWord + "',Quyen= N'" + Quyen +"'Where ID=" + ID;
//        Users u = new Users(ID, MaNhanVien, UserName, PassWord, Quyen, GhiChu);
        boolean kiemtra = true;
        if (kiemtra) {
//            CUsers.CapNhat(u, macu);
            conn.ExcuteQueryUpdateDB(cautruyvan);
            System.out.println("Đã Sửa Thành Công tài khoản có ID=" + ID);
        } else {
            ThongBao("Không thể Sửa tài Khoản với Tên đăng nhập là =" + UserName, "lỗi", 2);
        }
        layDuLieuTaiKhoan();
    }//GEN-LAST:event_btnSua_TaiKhoanActionPerformed

    private void txtPassWord_TaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassWord_TaiKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassWord_TaiKhoanActionPerformed

    private void jPanelTaiKhoanComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanelTaiKhoanComponentShown
        layDuLieuTaiKhoan();
        //cbbQuyen_TaiKhoan.setModel(LayDuLieucbb("Quyen", "TenQuyen", "MaQuyen"));
        cbbTenNhanVien_TaiKhoan.setModel(LayDuLieucbb("NhanVien", "TenNhanVien", "MaNhanVien"));
    }//GEN-LAST:event_jPanelTaiKhoanComponentShown

    private void tblChucVu_ChucVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChucVu_ChucVuMouseClicked
    try{
        int viTriDongVuaBam = tblChucVu_ChucVu.getSelectedRow();
        txtMaChucVu_ChucVu.setText(tblChucVu_ChucVu.getValueAt(viTriDongVuaBam, 1).toString());
        txtTenChucVu_ChucVu.setText(tblChucVu_ChucVu.getValueAt(viTriDongVuaBam, 2).toString());
        txtChuThich_ChucVu.setText(tblChucVu_ChucVu.getValueAt(viTriDongVuaBam, 3).toString());
        layDuLieuNhanVienofChucVu(txtMaChucVu_ChucVu.getText());
    } catch (NullPointerException ex) {
    System.out.println("Bắt ngoại lệ dữ liệu null:" + ex);
    }         
    }//GEN-LAST:event_tblChucVu_ChucVuMouseClicked

    private void btnThem_ChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem_ChucVuActionPerformed
        String MaChucVu, TenChucVu, DiaChi, GhiChu;
        MaChucVu = txtMaChucVu_ChucVu.getText();
        TenChucVu = txtTenChucVu_ChucVu.getText();
        GhiChu = txtChuThich_ChucVu.getText();
        String cautruyvan = "insert into ChucVu values("
        + " N'" + TenChucVu + "', N'" + GhiChu + "')";
        System.out.println(cautruyvan);
        boolean kiemtra = true;
        if (kiemtra) {
            conn.ExcuteQueryUpdateDB(cautruyvan);
            System.out.println("Đã Thêm Thành Công");
        } else {
            ThongBao("Không thể Thêm chức Vụ", "lỗi", 2);
        }
        layDuLieuChucVu();
    }//GEN-LAST:event_btnThem_ChucVuActionPerformed

    private void btnSua_ChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua_ChucVuActionPerformed
        String MaChucVu, TenChucVu, DiaChi, GhiChu;
        MaChucVu = txtMaChucVu_ChucVu.getText();
        TenChucVu = txtTenChucVu_ChucVu.getText();
        GhiChu= txtChuThich_ChucVu.getText();
        String cautruyvan = "update  ChucVu set TenChucVu="
        + " N'" + TenChucVu + "',GhiChu= N'" + GhiChu + "'Where MaChucVu=" + MaChucVu;
        System.out.println(cautruyvan);
        boolean kiemtra = true;
        if (kiemtra) {
            conn.ExcuteQueryUpdateDB(cautruyvan);
            System.out.println("Đã Sửa Thành Công");
        } else {
            ThongBao("Không thể Sửa chức Vụ", "lỗi", 2);
        }
        layDuLieuChucVu();
    }//GEN-LAST:event_btnSua_ChucVuActionPerformed

    private void btnReset_ChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset_ChucVuActionPerformed
    txtMaChucVu_ChucVu.setText("");
    txtTenChucVu_ChucVu.setText("");
    txtChuThich_ChucVu.setText("");
    }//GEN-LAST:event_btnReset_ChucVuActionPerformed

    private void txtMaChucVu_ChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaChucVu_ChucVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaChucVu_ChucVuActionPerformed

    private void btnXoaNeuRong_ChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNeuRong_ChucVuActionPerformed
        String MaChucVu= txtMaChucVu_ChucVu.getText();
        if (!MaChucVu.equals("")) {
            String cautruyvan = "delete from ChucVu where MaChucVu=" + MaChucVu;
            String ctvKiemThu = "select count(MaNhanVien) as SoNhanVien"
            + " from NhanVien,ChucVu where NhanVien.ChucVu=ChucVu.MaChucVu"
            + " and  ChucVu.MaChucVu=" + MaChucVu;
            ResultSet rs1 = conn.ExcuteQueryGetTable(ctvKiemThu);
            System.out.println(ctvKiemThu);
            int so1 = 0;
            try {
                if (rs1.next()) {
                    so1 = rs1.getInt("SoNhanVien");
                    if (rs1.getInt("SoNhanVien") == 0) {
                        conn.ExcuteQueryUpdateDB(cautruyvan);
                        System.out.println("đã xóa");
                        layDuLieuChucVu();
                    } else {
                        ThongBao("không thể xóa bởi Loại Sản Phẩm đã có " + so1 + " Sản Phẩm!", "báo lỗi", 2);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            ThongBao("bạn chưa click chuột vô bảng!", "làm ơn! hãy chứng minh bạn còn khả năng của cánh tay!!", 2);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaNeuRong_ChucVuActionPerformed

    private void jPanelChucVuComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanelChucVuComponentShown
       layDuLieuChucVu();
    }//GEN-LAST:event_jPanelChucVuComponentShown

    private void jTabbedPaneNhanVienComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPaneNhanVienComponentShown
        //rbtnNam_NhanVien.setSelected(true);
//        layDuLieuNhanVien();
        cbbChucVu_NhanVien.setModel(LayDuLieucbb("ChucVu", "TenChucVu", "MaChucVu"));
    }//GEN-LAST:event_jTabbedPaneNhanVienComponentShown

    private void cbbChucVu_NhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbChucVu_NhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbChucVu_NhanVienActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        loadDataTableS();
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        loadDataTableS();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void CBTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBTKActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //txtTimKiem.setText("");
        layDuLieuNhanVien();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        txtMaNhanVien_NhanVien.requestFocus();
        if(txtTenNhanVien_NhanVien.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập họ tên","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtTenNhanVien_NhanVien.requestFocus();
            return;
        }
//        if(sDF.format(dtNgaySinh.getDate()).length()<=0){
//            JOptionPane.showMessageDialog(this, "Bạn chưa nhập ngày sinh","Thông Báo",JOptionPane.WARNING_MESSAGE);
//            txtTenNhanVien_NhanVien.requestFocus();
//            return;
//        }       
//        if(sDF.format(dtNgayVaoLam.getDate()).length()<=0){
//            JOptionPane.showMessageDialog(this, "Bạn chưa nhập ngày vào làm","Thông Báo",JOptionPane.WARNING_MESSAGE);
//            txtTenNhanVien_NhanVien.requestFocus();
//            return;
//        }   
        if(txtDiaChi_NhanVien.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập địa chỉ","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtDiaChi_NhanVien.requestFocus();
            return;
        }
        if(txtSDT_NhanVien.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập số điện thoại","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtSDT_NhanVien.requestFocus();
            return;
        }        
        MaNhanVien=txtMaNhanVien_NhanVien.getText();
        TenNhanVien=txtTenNhanVien_NhanVien.getText();
        NgaySinh = sDF.format(dtNgaySinh.getDate());
        GioiTinh = cbGioiTinh.getSelectedItem().toString();
        NgayVaoLam = sDF.format(dtNgayVaoLam.getDate());
        ChucVu = GetCbbSelected(cbbChucVu_NhanVien);
        DiaChi = txtDiaChi_NhanVien.getText();
        SDT= txtSDT_NhanVien.getText();
        CMND =txtCMND_NhanVien.getText();

        NhanVien nv = new NhanVien(MaNhanVien, TenNhanVien, NgaySinh, GioiTinh, NgayVaoLam, ChucVu, DiaChi, SDT, CMND);
        CNhanVien.ThemMoi(nv);
        layDuLieuNhanVien();  
    }//GEN-LAST:event_btThemActionPerformed

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
        macu = txtMaNhanVien_NhanVien.getText();
        txtMaNhanVien_NhanVien.requestFocus();
        if(txtTenNhanVien_NhanVien.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập họ tên","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtTenNhanVien_NhanVien.requestFocus();
            return;
        }
        if(txtSDT_NhanVien.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập số điện thoại","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtSDT_NhanVien.requestFocus();
            return;
        }
        if(txtDiaChi_NhanVien.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập địa chỉ","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtDiaChi_NhanVien.requestFocus();
            return;
        }

        //thực hiện ghi

        MaNhanVien=txtMaNhanVien_NhanVien.getText();
        TenNhanVien=txtTenNhanVien_NhanVien.getText();
        NgaySinh = sDF.format(dtNgaySinh.getDate());
        GioiTinh = cbGioiTinh.getSelectedItem().toString();
        NgayVaoLam = sDF.format(dtNgayVaoLam.getDate());
        ChucVu = GetCbbSelected(cbbChucVu_NhanVien);
        DiaChi = txtDiaChi_NhanVien.getText();
        SDT= txtSDT_NhanVien.getText();
        CMND =txtCMND_NhanVien.getText();

        NhanVien nv = new NhanVien(MaNhanVien, TenNhanVien, NgaySinh, GioiTinh, NgayVaoLam, ChucVu, DiaChi, SDT, CMND);
        CNhanVien.CapNhat(nv, macu);
        //lấy nguồn dữ liệu mới
        layDuLieuNhanVien();    
    }//GEN-LAST:event_btSuaActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        if(txtMaNhanVien_NhanVien.getText().length()<=0)
        return;
        int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa [" + txtMaNhanVien_NhanVien.getText() + "] không ?","Thông báo",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (kq == JOptionPane.YES_OPTION) {
            macu = txtMaNhanVien_NhanVien.getText();
            CNhanVien.XoaBo(macu);
            layDuLieuNhanVien();  
            XoaTrang();
        }
    }//GEN-LAST:event_btXoaActionPerformed

    private void btKhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKhongActionPerformed
        XoaTrang();
    }//GEN-LAST:event_btKhongActionPerformed

    private void btnXoa_TaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa_TaiKhoanActionPerformed
        if(txtID_TaiKhoan.getText().length()<=0)
        return;
        int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa [" + txtID_TaiKhoan.getText() + "] không ?","Thông báo",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (kq == JOptionPane.YES_OPTION) {
            macu = txtID_TaiKhoan.getText();
            CUsers.XoaBo(macu);
            layDuLieuTaiKhoan();
        }          // TODO add your handling code here:
    }//GEN-LAST:event_btnXoa_TaiKhoanActionPerformed

    private void btnReset_TaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset_TaiKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReset_TaiKhoanActionPerformed

    private void txtCMND_NhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCMND_NhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCMND_NhanVienActionPerformed
     public String GetCbbSelected(JComboBox cbb) {
        Object[] obj = cbb.getSelectedObjects();
        displayvalueModel item = (displayvalueModel) obj[0];
        return item.displayvalue.toString();
    }
    public void layDuLieuChucVu() {
        String cautruyvan = "";
        cautruyvan = "select * from ChucVu ";
        ResultSet rs = conn.ExcuteQueryGetTable(cautruyvan);
        Object[] obj = new Object[]{"STT", "Mã ", "Tên Chức Vụ", "Ghi Chú"};
        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
        tblChucVu_ChucVu.setModel(tableModel);
        int c = 0;
        try {
            while (rs.next()) {
                c++;
                Object[] item = new Object[4];
                item[0] = c;
                item[1] = rs.getInt("MaChucVu");
                item[2] = rs.getString("TenChucVu");
                item[3] = rs.getString("GhiChu");
                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    public void layDuLieuNhanVien() {
        String cautruyvan = "";
        cautruyvan = "select * from NhanVien,ChucVu "
                + "where NhanVien.ChucVu=ChucVu.MaChucVu";
        ResultSet rs = conn.ExcuteQueryGetTable(cautruyvan);
        Object[] obj = new Object[]{"Mã Nhân Viên", "Tên Nhân Viên", "Ngày Sinh", "Giới Tính", "Ngày Vào Làm", "Chức Vụ", "Dịa Chỉ", "SDT", "CMND"};
        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
        tblNhanVien_NhanVien2.setModel(tableModel);
        int c = 0;
        try {
            while (rs.next()) {
                Object[] item = new Object[10];
                item[0] = rs.getInt("MaNhanVien");
                item[1] = rs.getString("TenNhanVien");
                item[2] = rs.getString("NgaySinh");
                item[3] = rs.getString("GioiTinh");
                item[4] = rs.getString("NgayVaoLam");
                item[5] = rs.getString("TenChucVu");
                item[6] = rs.getString("DiaChi");
                item[7] = rs.getString("SDT");
                item[8] = rs.getString("CMND");
                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
//        public DefaultComboBoxModel LayDuLieucbb(String bang, String Ten, String Ma) {
//        String cautruyvan = "select *from " + bang;
//        ResultSet rs = MainClass.connection.ExcuteQueryGetTable(cautruyvan);
//        DefaultComboBoxModel cbbmodel = new DefaultComboBoxModel();
//        try {
//            while (rs.next()) {
//                displayvalueModel valueModel = new displayvalueModel(rs.getString(Ten), rs.getString(Ma));
//                cbbmodel.addElement(valueModel);
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.toString());
//        }
//        return cbbmodel;
//    }

   
    public void setSelectedCombobox(String cbbselected, JComboBox cbb) {
        for (int i = 0; i < cbb.getItemCount(); i++) {
            Object obj = cbb.getItemAt(i);
            if (obj != null) {
                displayvalueModel m = (displayvalueModel) obj;
                if (cbbselected.trim().equals(m.displayMember)) {
                    cbb.setSelectedItem(m);
                }
            }
        }
    }

        
    public void ThongBao(String noiDungThongBao, String tieuDeThongBao, int icon) {
        JOptionPane.showMessageDialog(new JFrame(), noiDungThongBao,
                tieuDeThongBao, icon);
    }
    public void layDuLieuNhanVienofChucVu(String MaChucVu) {
        String cautruyvan = "";
        cautruyvan = "select * from NhanVien,ChucVu "
                + "where NhanVien.ChucVu=ChucVu.MaChucVu and ChucVu=" + MaChucVu;
        ResultSet rs = conn.ExcuteQueryGetTable(cautruyvan);
        Object[] obj = new Object[]{"STT", "Mã Nhân Viên", "Tên Nhân Viên", "Chức Vụ"};
        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
        tblNhanVien_ChucVu.setModel(tableModel);
        int c = 0;
        try {
            while (rs.next()) {
                c++;
                Object[] item = new Object[4];
                item[0] = c;
                item[1] = rs.getInt("MaNhanVien");
                item[2] = rs.getString("TenNhanVien");
                item[3] = rs.getString("TenChucVu");
                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    public void layDuLieuTaiKhoan() {
        String cautruyvan = "";
        cautruyvan = "select ID, NhanVien.TenNhanVien ,Users.UserName,Users.PassWord"
                + ",Users.Quyen,Users.GhiChu  from Users,NhanVien "
                + "where Users.MaNhanVien=NhanVien.MaNhanVien";
        ResultSet rs = conn.ExcuteQueryGetTable(cautruyvan);
        Object[] obj = new Object[]{"STT", "ID", "Nhân Viên", "UserName", "PassWord", "Quyền", "Ghi Chú"};
        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
        tblTaiKhoan_TaiKhoan.setModel(tableModel);
        int c = 0;
        try {
            while (rs.next()) {
                c++;
                Object[] item = new Object[7];
                item[0] = c;
                item[1] = rs.getString("ID");
                item[2] = rs.getString("TenNhanVien");
                item[3] = rs.getString("UserName");
                item[4] = rs.getString("PassWord");
                item[5] = rs.getString("Quyen");
                item[6] = rs.getString("GhiChu");
                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    public void ResNhanVien() {
        txtMaNhanVien_NhanVien.setText("");
        txtTenNhanVien_NhanVien.setText("");
//        cbbNgaySinh_NhanVien.setSelectedItem("25");
//        cbbThangSinh_NhanVien.setSelectedItem("12");
//        cbbNamSinh_NhanVien.setSelectedItem("1996");
//        cbbNgayVaoLam_NhanVien.setSelectedItem("25");
//        cbbThangVaoLam_NhanVien.setSelectedItem("12");
//        cbbNamVaoLam_NhanVien.setSelectedItem("1996");
        txtDiaChi_NhanVien.setText("");
        txtSDT_NhanVien.setText("");
        txtCMND_NhanVien.setText("");
        cbbChucVu_NhanVien.setSelectedIndex(0);
//        rbtnNam_NhanVien.setSelected(true);
//        rbtnNu_NhanVien.setSelected(false);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBTK;
    private javax.swing.JButton btKhong;
    private javax.swing.JButton btSua;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btXoa;
    private javax.swing.JButton btnReset_ChucVu;
    private javax.swing.JButton btnReset_TaiKhoan;
    private javax.swing.JButton btnSua_ChucVu;
    private javax.swing.JButton btnSua_TaiKhoan;
    private javax.swing.JButton btnThem_ChucVu;
    private javax.swing.JButton btnThem_TaiKhoan;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoaNeuRong_ChucVu;
    private javax.swing.JButton btnXoa_TaiKhoan;
    private javax.swing.JComboBox<String> cbGioiTinh;
    private javax.swing.JComboBox<String> cbbChucVu_NhanVien;
    private javax.swing.JComboBox<String> cbbQuyen_TaiKhoan;
    private javax.swing.JComboBox<String> cbbTenNhanVien_TaiKhoan;
    private com.toedter.calendar.JDateChooser dtNgaySinh;
    private com.toedter.calendar.JDateChooser dtNgayVaoLam;
    private javax.swing.ButtonGroup gioiTinh;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelChucVu;
    private javax.swing.JPanel jPanelNhanVien;
    private javax.swing.JPanel jPanelTaiKhoan;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPaneNhanVien;
    private javax.swing.JLabel lblDiaChi_NhanVien;
    private javax.swing.JLabel lblMaNhanVien_NhanVien;
    private javax.swing.JLabel lblSDT_NhanVien;
    private javax.swing.JLabel lblTenNhanVien_NhanVien;
    private javax.swing.JTable tblChucVu_ChucVu;
    private javax.swing.JTable tblNhanVien_ChucVu;
    private javax.swing.JTable tblNhanVien_NhanVien;
    private javax.swing.JTable tblNhanVien_NhanVien2;
    private javax.swing.JTable tblTaiKhoan_TaiKhoan;
    private javax.swing.JTextField txtCMND_NhanVien;
    private javax.swing.JTextArea txtChuThich_ChucVu;
    private javax.swing.JTextPane txtChuThich_TaiKhoan;
    private javax.swing.JTextField txtDiaChi_NhanVien;
    private javax.swing.JTextField txtID_TaiKhoan;
    private javax.swing.JTextField txtMaChucVu_ChucVu;
    private javax.swing.JTextField txtMaNhanVien_NhanVien;
    private javax.swing.JPasswordField txtPassWord_TaiKhoan;
    private javax.swing.JTextField txtSDT_NhanVien;
    private javax.swing.JTextField txtTenChucVu_ChucVu;
    private javax.swing.JTextField txtTenNhanVien_NhanVien;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtUserName_TaiKhoan;
    // End of variables declaration//GEN-END:variables
}
