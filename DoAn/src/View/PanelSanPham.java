package View;

import Controller.CHoaDon;
import Controller.CKhachHang;
import Controller.CNhanVien;
import Controller.CPhieuNhap;
import Controller.CSanPham;
import Controller.KiemTraDuLieu_Controller;
import Database.ConnectDB;
import static Database.ConnectDB.LayDuLieucbb;
//import Main.MainClass;
import Model.HoaDon;
import Model.NhanVien;
import Model.PhieuNhap;
import Model.SanPham;
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
import java.util.Vector;
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
import javax.swing.table.TableModel;

/**
 *
 * @author PLanh
 */
public class PanelSanPham extends javax.swing.JPanel {
    public static ConnectDB conn = new ConnectDB();
    DefaultTableModel tblDanhSach;
    java.util.List<SanPham> arr = new ArrayList<>();
    String MaSanPham, TenSanPham, LoaiSanPham, Size, GiaBan, sMaSanPhamTim;
    boolean ktThem;
    String macu;
    private final String[] colName = {"Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm","Size", "Giá bán"};
    private final String[] sqlName = {"MaSanPham", "TenSanPham", "LoaiSanPham", "Size","GiaBan"};
    Vector<String> vec = new Vector<String>(100);     
    public PanelSanPham() {
        initComponents();
    }
    
    public void XoaTrang(){
        txtMaSanPham_SanPham.setText("");
        txtTenSanPham_SanPham.setText("");
        //cbbLoaiSanPham_SanPham.setSelectedIndex(0);
        txtGiaBan_SanPham.setText("");
        txtSize_SanPham.setText("");
    }  
	private void loadDataTableS() {
		try {
			String col = sqlName[CBTK.getSelectedIndex()];
			String key = txtTimKiem.getText();
			DefaultTableModel tableModel = new DefaultTableModel();
                	Database.ConnectDB conn = new Database.ConnectDB ();
			Vector<String> colsName = new Vector<String>(10);
			colsName.add("Mã sản phẩm");
			colsName.add("Tên sản phẩm");
                        colsName.add("Loại sản phẩm");
                        colsName.add("Size");
                        colsName.add("Giá bán");
			
			tableModel.setColumnIdentifiers(colsName);
			
			vec = conn.selectSearch("SanPham", col, key);
			
			String[][] str = new String[vec.size()][];
			for (int i = 0; i < vec.size(); i++) {
				Vector<String> vector = new Vector<String>(100);
				str[i] = vec.get(i).split("\t");
				for (int j = 0; j < str[i].length; j++) {
					vector.add(str[i][j]);
				}
				tableModel.addRow(vector);
			}
			tblSanPham.setModel(tableModel);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không có kết quả tìm kiếm ", "Thông báo", 1);
		}
	}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneQuanLySanPham = new javax.swing.JTabbedPane();
        jPanelSanPham = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblTenSanPham_SanPham = new javax.swing.JLabel();
        lblMaSanPham_SanPham = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTenSanPham_SanPham = new javax.swing.JTextField();
        txtMaSanPham_SanPham = new javax.swing.JTextField();
        cbbLoaiSanPham_SanPham = new javax.swing.JComboBox<>();
        lblSize_SanPham = new javax.swing.JLabel();
        txtSize_SanPham = new javax.swing.JTextField();
        txtGiaBan_SanPham = new javax.swing.JTextField();
        lblGiaBan = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        labelHinhAnh = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        CBTK = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        btThem = new javax.swing.JButton();
        btSua = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        btKhong = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanelLoaiSanPham = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLoaiSanPham_LoaiSanPham = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtTenLoaiSanPham_LoaiSanPham = new javax.swing.JTextField();
        btnThem_LoaiSanPham = new javax.swing.JButton();
        btnSua_LoaiSanPham = new javax.swing.JButton();
        btnXoa_LoaiSanPham = new javax.swing.JButton();
        txtMaLoaiSanPham_LoaiSanPham = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblSanPham_LoaiSanPham = new javax.swing.JTable();
        jLabel74 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        btnXoaSP_LoaiSanPham = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1366, 700));

        jPanelSanPham.setBackground(new java.awt.Color(204, 204, 255));
        jPanelSanPham.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanelSanPhamComponentShown(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        lblTenSanPham_SanPham.setText("Tên Sản Phẩm");

        lblMaSanPham_SanPham.setText("Mã Sản Phẩm");

        jLabel3.setText("Loại Sản Phẩm");

        cbbLoaiSanPham_SanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbLoaiSanPham_SanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLoaiSanPham_SanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaSanPham_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTenSanPham_SanPham)
                            .addComponent(jLabel3))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTenSanPham_SanPham, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSanPham_SanPham, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbLoaiSanPham_SanPham, 0, 239, Short.MAX_VALUE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaSanPham_SanPham)
                    .addComponent(txtMaSanPham_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenSanPham_SanPham)
                    .addComponent(txtTenSanPham_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbbLoaiSanPham_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(127, Short.MAX_VALUE))
        );

        lblSize_SanPham.setText("Size");

        lblGiaBan.setText("Giá Bán");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 120, Short.MAX_VALUE)
                        .addComponent(txtGiaBan_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGiaBan)
                            .addComponent(lblSize_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSize_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lblSize_SanPham))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtSize_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiaBan_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGiaBan))
                .addContainerGap(210, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm ", "Tên Sản Phẩm", "Loại Sản Phẩm", "Size", "Giá Bán"
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 2), "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 0, 0))); // NOI18N

        jPanel7.setBackground(new java.awt.Color(204, 255, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

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

        CBTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Size", "Giá bán" }));
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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CBTK, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(btnTimKiem)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CBTK, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem)
                .addContainerGap())
        );

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

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/3d-building.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(26, 26, 26))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThem)
                    .addComponent(btSua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btXoa)
                    .addComponent(btKhong))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/3d-building.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanelSanPhamLayout = new javax.swing.GroupLayout(jPanelSanPham);
        jPanelSanPham.setLayout(jPanelSanPhamLayout);
        jPanelSanPhamLayout.setHorizontalGroup(
            jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSanPhamLayout.createSequentialGroup()
                .addGroup(jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelSanPhamLayout.createSequentialGroup()
                        .addGap(375, 375, 375)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(219, 219, 219))
                    .addGroup(jPanelSanPhamLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)))
                .addComponent(labelHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelSanPhamLayout.createSequentialGroup()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1368, Short.MAX_VALUE)))
        );
        jPanelSanPhamLayout.setVerticalGroup(
            jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSanPhamLayout.createSequentialGroup()
                .addGroup(jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSanPhamLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSanPhamLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelSanPhamLayout.createSequentialGroup()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 101, Short.MAX_VALUE)))
        );

        jTabbedPaneQuanLySanPham.addTab("Sản Phẩm", jPanelSanPham);

        jPanelLoaiSanPham.setBackground(new java.awt.Color(204, 204, 255));
        jPanelLoaiSanPham.setPreferredSize(new java.awt.Dimension(1030, 600));
        jPanelLoaiSanPham.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jPanelLoaiSanPhamComponentAdded(evt);
            }
        });
        jPanelLoaiSanPham.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanelLoaiSanPhamComponentShown(evt);
            }
        });

        tblLoaiSanPham_LoaiSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Mã Loại Sản Phẩm ", "Tên Loại Sản Phẩm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLoaiSanPham_LoaiSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiSanPham_LoaiSanPhamMouseClicked(evt);
            }
        });
        tblLoaiSanPham_LoaiSanPham.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tblLoaiSanPham_LoaiSanPhamComponentShown(evt);
            }
        });
        jScrollPane3.setViewportView(tblLoaiSanPham_LoaiSanPham);

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));

        jLabel13.setText("Mã Loại Sản Phẩm");

        jLabel14.setText("Tên Loại Sản Phẩm");

        btnThem_LoaiSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/file_blank_paper_document_page_icon_196467.png"))); // NOI18N
        btnThem_LoaiSanPham.setText("Thêm");
        btnThem_LoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem_LoaiSanPhamActionPerformed(evt);
            }
        });

        btnSua_LoaiSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/settings_options_configuration_setting_system_icon_196481.png"))); // NOI18N
        btnSua_LoaiSanPham.setText("Sửa");
        btnSua_LoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua_LoaiSanPhamActionPerformed(evt);
            }
        });

        btnXoa_LoaiSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Close_Icon_Dark_icon-icons.com_69143.png"))); // NOI18N
        btnXoa_LoaiSanPham.setText("Reset");
        btnXoa_LoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa_LoaiSanPhamActionPerformed(evt);
            }
        });

        txtMaLoaiSanPham_LoaiSanPham.setEditable(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnThem_LoaiSanPham)
                        .addGap(32, 32, 32)
                        .addComponent(btnSua_LoaiSanPham)
                        .addGap(35, 35, 35)
                        .addComponent(btnXoa_LoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenLoaiSanPham_LoaiSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(txtMaLoaiSanPham_LoaiSanPham))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtMaLoaiSanPham_LoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtTenLoaiSanPham_LoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem_LoaiSanPham)
                    .addComponent(btnSua_LoaiSanPham)
                    .addComponent(btnXoa_LoaiSanPham))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(204, 204, 255));

        tblSanPham_LoaiSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã Sản Phẩm ", "Tên Sản Phẩm", "Loại Sản Phẩm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblSanPham_LoaiSanPham);

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(0, 51, 255));
        jLabel74.setText(" Sản Phẩm");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jLabel74))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel74)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(0, 51, 255));
        jLabel73.setText("Loại Sản Phẩm");

        btnXoaSP_LoaiSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/xoa24.png"))); // NOI18N
        btnXoaSP_LoaiSanPham.setText("Xóa Nếu Rông");
        btnXoaSP_LoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSP_LoaiSanPhamActionPerformed(evt);
            }
        });

        jLabel16.setText("Lưu Ý Khi Xóa Loại Sản Phẩm Chứa Sản Phẩm ");

        javax.swing.GroupLayout jPanelLoaiSanPhamLayout = new javax.swing.GroupLayout(jPanelLoaiSanPham);
        jPanelLoaiSanPham.setLayout(jPanelLoaiSanPhamLayout);
        jPanelLoaiSanPhamLayout.setHorizontalGroup(
            jPanelLoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoaiSanPhamLayout.createSequentialGroup()
                .addGroup(jPanelLoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLoaiSanPhamLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLoaiSanPhamLayout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelLoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnXoaSP_LoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)))
                    .addGroup(jPanelLoaiSanPhamLayout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jLabel73)))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        jPanelLoaiSanPhamLayout.setVerticalGroup(
            jPanelLoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoaiSanPhamLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jLabel73)
                .addGroup(jPanelLoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLoaiSanPhamLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLoaiSanPhamLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanelLoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLoaiSanPhamLayout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaSP_LoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(183, 183, 183))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLoaiSanPhamLayout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );

        jTabbedPaneQuanLySanPham.addTab("Loại Sản Phẩm", jPanelLoaiSanPham);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1444, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jTabbedPaneQuanLySanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 1438, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 645, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jTabbedPaneQuanLySanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 6, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
    try{
        int index = tblSanPham.getSelectedRow();
        txtMaSanPham_SanPham.setText(tblSanPham.getValueAt(index, 0).toString());
        txtTenSanPham_SanPham.setText(tblSanPham.getValueAt(index, 1).toString());
        setSelectedCombobox(tblSanPham.getValueAt(index, 2).toString(), cbbLoaiSanPham_SanPham);
        txtSize_SanPham.setText(tblSanPham.getValueAt(index, 3).toString());
        txtGiaBan_SanPham.setText(tblSanPham.getValueAt(index, 4).toString());                      
    } catch (NullPointerException ex) {
    System.out.println("Bắt ngoại lệ dữ liệu null:" + ex);
    }            
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void jPanelSanPhamComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanelSanPhamComponentShown
        LayDuLieuSanPham();
        cbbLoaiSanPham_SanPham.setModel(LayDuLieucbb("LoaiSanPham", "TenLoaiSanPham", "MaLoaiSanPham"));
//        cbbHangSanXuat_SanPham.setModel(LayDuLieucbb("HangSanXuat", "TenHangSanXuat", "MaHangSanXuat"));
//        cbbTimKiemLoaiSanPham_SanPham.setModel(LayDuLieucbb("LoaiSanPham", "TenLoaiSanPham", "MaLoaiSanPham"));
    }//GEN-LAST:event_jPanelSanPhamComponentShown

    private void tblLoaiSanPham_LoaiSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiSanPham_LoaiSanPhamMouseClicked
        int viTriDongVuaBam = tblLoaiSanPham_LoaiSanPham.getSelectedRow();
        txtMaLoaiSanPham_LoaiSanPham.setText(tblLoaiSanPham_LoaiSanPham.getValueAt(viTriDongVuaBam, 1).toString());
        txtTenLoaiSanPham_LoaiSanPham.setText(tblLoaiSanPham_LoaiSanPham.getValueAt(viTriDongVuaBam, 2).toString());
        LayDuLieuSanPhamofLoaiSanPham(txtMaLoaiSanPham_LoaiSanPham.getText());
    }//GEN-LAST:event_tblLoaiSanPham_LoaiSanPhamMouseClicked

    private void tblLoaiSanPham_LoaiSanPhamComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tblLoaiSanPham_LoaiSanPhamComponentShown

    }//GEN-LAST:event_tblLoaiSanPham_LoaiSanPhamComponentShown

    private void btnThem_LoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem_LoaiSanPhamActionPerformed
        String MaLoaiSanPham, TenLoaiSanPham;
        MaLoaiSanPham = txtMaLoaiSanPham_LoaiSanPham.getText();
        TenLoaiSanPham = txtTenLoaiSanPham_LoaiSanPham.getText();
        String cautruyvan = "insert into LoaiSanPham values("
                + " N'" + TenLoaiSanPham + "')";
        System.out.println(cautruyvan);
        boolean kiemtra = true;
        if (!txtTenLoaiSanPham_LoaiSanPham.equals("")) {
            conn.ExcuteQueryUpdateDB(cautruyvan);
            System.out.println("Đã Thêm Thành Công");
        } else {
            ThongBao("Không thể Thêm loại sản phẩm", "lỗi", 2);
        }
        layDuLieuLoaiSanPham();
    }//GEN-LAST:event_btnThem_LoaiSanPhamActionPerformed

    private void btnSua_LoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua_LoaiSanPhamActionPerformed
        String MaLoaiSanPham, TenLoai;
        MaLoaiSanPham = txtMaLoaiSanPham_LoaiSanPham.getText();
        TenLoai = txtTenLoaiSanPham_LoaiSanPham.getText();
        String cautruyvan = "update LoaiSanPham set"
        + " TenLoaiSanPham=N'" + TenLoai + "'where MaLoaiSanPham=" + MaLoaiSanPham;
        if (!txtTenLoaiSanPham_LoaiSanPham.equals("")) {
            conn.ExcuteQueryUpdateDB(cautruyvan);
            System.out.println("Đã sửa Thành Công");
        } else {
            ThongBao("Bạn chưa nhập tên loại sản phẩm", TenLoai, 2);
        }
        layDuLieuLoaiSanPham();
    }//GEN-LAST:event_btnSua_LoaiSanPhamActionPerformed

    private void btnXoa_LoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa_LoaiSanPhamActionPerformed
        txtMaLoaiSanPham_LoaiSanPham.setText("");
        txtTenLoaiSanPham_LoaiSanPham.setText("");
    }//GEN-LAST:event_btnXoa_LoaiSanPhamActionPerformed

    private void btnXoaSP_LoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSP_LoaiSanPhamActionPerformed
        String MaLoai = txtMaLoaiSanPham_LoaiSanPham.getText();
        if (!MaLoai.equals("")) {
            String cautruyvan = "delete from LoaiSanPham where MaLoaiSanPham=" + MaLoai;
            String ctvKiemThu = "select count(MaSanPham) as SoSanPham"
            + " from SanPham,LoaiSanPham where SanPham.LoaiSanPham=LoaiSanPham.MaLoaiSanPham"
            + " and  LoaiSanPham.MaLoaiSanPham=" + MaLoai;
            ResultSet rs1 = conn.ExcuteQueryGetTable(ctvKiemThu);
            System.out.println(ctvKiemThu);
            int so1 = 0;
            try {
                if (rs1.next()) {
                    so1 = rs1.getInt("SoSanPham");
                    if (rs1.getInt("SoSanPham") == 0) {
                        conn.ExcuteQueryUpdateDB(cautruyvan);
                        System.out.println("đã xóa");
                        layDuLieuLoaiSanPham();
                    } else {
                        ThongBao("không thể xóa bởi Loại Sản Phẩm đã có " + so1 + " Sản Phẩm!", "báo lỗi", 2);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            ThongBao("bạn chưa click chuột vô bảng!", "làm ơn! hãy chứng minh bạn còn khả năng của cánh tay!!", 2);
        }
    }//GEN-LAST:event_btnXoaSP_LoaiSanPhamActionPerformed

    private void jPanelLoaiSanPhamComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jPanelLoaiSanPhamComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelLoaiSanPhamComponentAdded

    private void jPanelLoaiSanPhamComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanelLoaiSanPhamComponentShown
            layDuLieuLoaiSanPham();
            System.out.println("vô sản Phẩm");
    }//GEN-LAST:event_jPanelLoaiSanPhamComponentShown
    public int tam1 = 0;
    private void cbbLoaiSanPham_SanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLoaiSanPham_SanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbLoaiSanPham_SanPhamActionPerformed

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
        LayDuLieuSanPham();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        ktThem = true;
        txtMaSanPham_SanPham.requestFocus();
        //kiểm tra dữ liệu rỗng
        if(txtMaSanPham_SanPham.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã sản phẩm","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtMaSanPham_SanPham.requestFocus();
            return;
        }
        if(txtTenSanPham_SanPham.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên sản phẩm","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtTenSanPham_SanPham.requestFocus();
            return;
        }
        if(txtGiaBan_SanPham.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập giá bán","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtGiaBan_SanPham.requestFocus();
            return;
        }
        if(txtSize_SanPham.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập đơn vị tính","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtSize_SanPham.requestFocus();
            return;
        }

        //kiểm tra tính hợp lệ của dữ liệu
        //kiểm tra trùng mã (trùng khóa chính - xây dựng hàm kiểm tra trong controlle)
        if(KiemTraDuLieu_Controller.KiemTraTrungMa("SanPham", "MaSanPham", txtMaSanPham_SanPham.getText(), ktThem, macu)==true){
            JOptionPane.showMessageDialog(this, "Bạn nhập trùng mã lớp","Thông báo",JOptionPane.ERROR_MESSAGE);
            txtMaSanPham_SanPham.requestFocus();
            return;
        }
        //thực hiện ghi

        MaSanPham   = txtMaSanPham_SanPham.getText();
        TenSanPham  = txtTenSanPham_SanPham.getText();
        LoaiSanPham = GetCbbSelected(cbbLoaiSanPham_SanPham);
        Size   = txtSize_SanPham.getText();
        GiaBan      = txtGiaBan_SanPham.getText();
        

        SanPham nv = new SanPham(MaSanPham, TenSanPham, LoaiSanPham, Size, GiaBan);
        if(ktThem==true){
            CSanPham.ThemMoi(nv);
        }
        else{
            CSanPham.CapNhat(nv, macu);
        }
        //lấy nguồn dữ liệu mới
        LayDuLieuSanPham();    
    }//GEN-LAST:event_btThemActionPerformed

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
        macu = txtMaSanPham_SanPham.getText();
        ktThem = false;
        txtMaSanPham_SanPham.requestFocus();
        if(txtMaSanPham_SanPham.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã sản phẩm","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtMaSanPham_SanPham.requestFocus();
            return;
        }
        if(txtTenSanPham_SanPham.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên sản phẩm","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtTenSanPham_SanPham.requestFocus();
            return;
        }
        if(txtGiaBan_SanPham.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập giá bán","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtGiaBan_SanPham.requestFocus();
            return;
        }

        //kiểm tra tính hợp lệ của dữ liệu
        //kiểm tra trùng mã (trùng khóa chính - xây dựng hàm kiểm tra trong controlle)
        if(KiemTraDuLieu_Controller.KiemTraTrungMa("SanPham", "MaSanPham", txtMaSanPham_SanPham.getText(), ktThem, macu)==true){
            JOptionPane.showMessageDialog(this, "Bạn nhập trùng mã lớp","Thông báo",JOptionPane.ERROR_MESSAGE);
            txtMaSanPham_SanPham.requestFocus();
            return;
        }
        //thực hiện ghi

        MaSanPham   = txtMaSanPham_SanPham.getText();
        TenSanPham  = txtTenSanPham_SanPham.getText();
        LoaiSanPham = GetCbbSelected(cbbLoaiSanPham_SanPham);
        Size   = txtSize_SanPham.getText();
        GiaBan      = txtGiaBan_SanPham.getText();


        SanPham nv = new SanPham(MaSanPham, TenSanPham, LoaiSanPham, Size, GiaBan);
        if(ktThem==true){
            CSanPham.ThemMoi(nv);
        }
        else{
            CSanPham.CapNhat(nv, macu);
        }
        //lấy nguồn dữ liệu mới
        LayDuLieuSanPham();      
    }//GEN-LAST:event_btSuaActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        if(txtMaSanPham_SanPham.getText().length()<=0)
        return;
        int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa [" + txtMaSanPham_SanPham.getText() + "] không ?","Thông báo",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (kq == JOptionPane.YES_OPTION) {
            macu = txtMaSanPham_SanPham.getText();
            CSanPham.XoaBo(macu);
            LayDuLieuSanPham();
            XoaTrang();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btXoaActionPerformed

    private void btKhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKhongActionPerformed
        XoaTrang();
    }//GEN-LAST:event_btKhongActionPerformed
  
//
//
    public void LayDuLieuSanPham() {
        String cautruyvan = "";
        cautruyvan = "select MaSanPham, TenSanPham, LoaiSanPham.TenLoaiSanPham, Size, GiaBan from SanPham,LoaiSanPham where SanPham.LoaiSanPham=LoaiSanPham.MaLoaiSanPham";
        ResultSet rs = conn.ExcuteQueryGetTable(cautruyvan);
        Object[] obj = new Object[]{"Mã Sản Phẩm", "Tên sản phẩm", "Loại sản phẩm", "Size", "Giá bán"};
        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
        tblSanPham.setModel(tableModel);
        try {
            while (rs.next()) {
                Object[] item = new Object[10];
                item[0] = rs.getInt("MaSanPham");
                item[1] = rs.getString("TenSanPham");
                item[2] = rs.getString("TenLoaiSanPham");
                item[3] = rs.getString("Size");
                item[4] = rs.getInt("GiaBan");
                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    public int GetGiaSanPham(String MaSP) {
        int Gia = 0;
        String cautruyvan = "select * from SanPham where MaSanPham=" + MaSP;
        ResultSet rs = conn.ExcuteQueryGetTable(cautruyvan);
        try {
            if (rs.next()) {
                Gia = rs.getInt("GiaNhap");
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return Gia;
    }
    public void LayDuLieuSanPhamofLoaiSanPham(String MaLoaiSanPham) {
        String cautruyvan = "";
        cautruyvan = "select MaSanPham,SanPham.TenSanPham,LoaiSanPham.TenLoaiSanPham"
                + " as TenLoaiSanPham from SanPham,LoaiSanPham where"
                + " SanPham.LoaiSanPham=LoaiSanPham.MaLoaiSanPham and MaLoaiSanPham=" + MaLoaiSanPham;
        ResultSet rs = conn.ExcuteQueryGetTable(cautruyvan);
        Object[] obj = new Object[]{"STT", "Mã Sản Phẩm", "Tên sản phẩm", "Loại sản phẩm"};
        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
        tblSanPham_LoaiSanPham.setModel(tableModel);
        int c = 0;
        try {
            while (rs.next()) {
                c++;
                Object[] item = new Object[4];
                item[0] = c;
                item[1] = rs.getInt("MaSanPham");
                item[2] = rs.getString("TenSanPham");
                item[3] = rs.getString("TenLoaiSanPham");
                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    public void layDuLieuLoaiSanPham() {
        String cautruyvan = "";
        cautruyvan = "select * from LoaiSanPham ";
        ResultSet rs = conn.ExcuteQueryGetTable(cautruyvan);
        Object[] obj = new Object[]{"STT", "Mã Loại", "Tên Loại"};
        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
        tblLoaiSanPham_LoaiSanPham.setModel(tableModel);
        int c = 0;
        try {
            while (rs.next()) {
                c++;
                Object[] item = new Object[3];
                item[0] = c;
                item[1] = rs.getInt("MaLoaiSanPham");
                item[2] = rs.getString("TenLoaiSanPham");
                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }


//    public void layDuLieuChucVu() {
//        String cautruyvan = "";
//        cautruyvan = "select * from ChucVu ";
//        ResultSet rs = MainClass.connection.ExcuteQueryGetTable(cautruyvan);
//        Object[] obj = new Object[]{"STT", "Mã ", "Tên Chức Vụ", "Ghi Chú"};
//        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
//        tblChucVu_ChucVu.setModel(tableModel);
//        int c = 0;
//        try {
//            while (rs.next()) {
//                c++;
//                Object[] item = new Object[4];
//                item[0] = c;
//                item[1] = rs.getInt("MaChucVu");
//                item[2] = rs.getString("TenChucVu");
//                item[3] = rs.getString("GhiChu");
//                tableModel.addRow(item);
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.toString());
//        }
//    }
//
//  
//          public boolean KiemTraNhanSanPham(int ts) {
//        String MaSanPham, TenSanPham, GiaNhap,GiaBan,TonKho;
//        boolean kiemtra = false;
//        MaSanPham = txtMaSanPham_SanPham.getText();
//        TenSanPham = txtTenSanPham_SanPham.getText();
//        TonKho= txtDonViTinh_SanPham.getText().trim();
//        String  ThongBao = "";
//        GiaNhap = txtGiaNhap_SanPham.getText();
//        GiaBan = txtGiaBan_SanPham.getText();
//        if (MaSanPham.equals("") && ts == 1) {
//            ThongBao += "bạn chưa chọn khách hàng để lấy  Mã Khách Hàng\n";
//            lblMaSanPham_SanPham.setForeground(Color.red);
//        }
//        if (TenSanPham.equals("")) {
//            ThongBao += "bạn chưa Nhập Tên Sản Phẩm\n";
//            lblTenSanPham_SanPham.setForeground(Color.red);
//        }
//        if (GiaNhap.equals("")) {
//            lblGiaNhap_SanPham.setForeground(Color.red);
//            ThongBao += "bạn chưa Nhập Giá Bán\n";
//        }
//        if (GiaBan.equals("")) {
//            lblGiaBan.setForeground(Color.red);
//            ThongBao += "bạn chưa Nhập Giá Bán \n";
//        }
//              try {
//                  int bien =Integer.valueOf(GiaNhap);
//              } catch (Exception e) {
//                  ThongBao+="Giá Nhập Phải là số !\n";
//              }
//               try {
//                  int bien =Integer.valueOf(GiaBan);
//              } catch (Exception e) {
//                  ThongBao+="Giá Bán Phải là số !\n";
//              }
//              try {
//                   if (Integer.valueOf(GiaNhap)>Integer.valueOf(GiaBan)) {
//            lblGiaBan.setForeground(Color.red);
//            ThongBao += "Nhập Giá Bán Phải Lớn Hơn Giá Nhập \n";
//        } 
//              } catch (Exception e) {
//              }
//      
//         if (TonKho.equals("")) {
//            lblTonKho_SanPham.setForeground(Color.red);
//            ThongBao += "bạn chưa Nhập Tồn Kho \n";
//        }
//        if (ThongBao.equals("")) {
//            kiemtra = true;
//            lblTenSanPham_SanPham.setForeground(Color.black);
//            lblMaSanPham_SanPham.setForeground(Color.black);
//            lblGiaBan.setForeground(Color.black);
//             lblTonKho_SanPham.setForeground(Color.black);
//            lblGiaNhap_SanPham.setForeground(Color.black);
//        } else {
//            kiemtra = false;
//            ThongBao(ThongBao, "lỗi nhập liệu", 2);
//        }
//        return kiemtra;
//    }
    public void ThongBao(String noiDungThongBao, String tieuDeThongBao, int icon) {
        JOptionPane.showMessageDialog(new JFrame(), noiDungThongBao,
                tieuDeThongBao, icon);
    }
    public String GetCbbSelected(JComboBox cbb) {
        Object[] obj = cbb.getSelectedObjects();
        displayvalueModel item = (displayvalueModel) obj[0];
        return item.displayvalue.toString();

    }
//
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

    public DefaultComboBoxModel LayDuLieucbb(String bang, String Ten, String Ma) {
        String cautruyvan = "select *from " + bang;
        ResultSet rs = conn.ExcuteQueryGetTable(cautruyvan);
        DefaultComboBoxModel cbbmodel = new DefaultComboBoxModel();
        try {
            while (rs.next()) {
                displayvalueModel valueModel = new displayvalueModel(rs.getString(Ten), rs.getString(Ma));
                cbbmodel.addElement(valueModel);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return cbbmodel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBTK;
    private javax.swing.JButton btKhong;
    private javax.swing.JButton btSua;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btXoa;
    private javax.swing.JButton btnSua_LoaiSanPham;
    private javax.swing.JButton btnThem_LoaiSanPham;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoaSP_LoaiSanPham;
    private javax.swing.JButton btnXoa_LoaiSanPham;
    private javax.swing.JComboBox<String> cbbLoaiSanPham_SanPham;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelLoaiSanPham;
    private javax.swing.JPanel jPanelSanPham;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPaneQuanLySanPham;
    private javax.swing.JLabel labelHinhAnh;
    private javax.swing.JLabel lblGiaBan;
    private javax.swing.JLabel lblMaSanPham_SanPham;
    private javax.swing.JLabel lblSize_SanPham;
    private javax.swing.JLabel lblTenSanPham_SanPham;
    private javax.swing.JTable tblLoaiSanPham_LoaiSanPham;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tblSanPham_LoaiSanPham;
    private javax.swing.JTextField txtGiaBan_SanPham;
    private javax.swing.JTextField txtMaLoaiSanPham_LoaiSanPham;
    private javax.swing.JTextField txtMaSanPham_SanPham;
    private javax.swing.JTextField txtSize_SanPham;
    private javax.swing.JTextField txtTenLoaiSanPham_LoaiSanPham;
    private javax.swing.JTextField txtTenSanPham_SanPham;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
