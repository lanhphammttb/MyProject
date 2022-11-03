/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

//import Main.MainClass;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
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
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import Controller.CKhachHang;
import Controller.CUsers;
import Model.KhachHang;
import Database.CalendarAdapter;
import Database.ConnectDB;
//import Database.ConnectDB;
//import Database.PrintPDF;
import static java.awt.SystemColor.control;
import java.text.ParseException;
import javax.swing.table.TableModel;


public class PanelKhachHang extends javax.swing.JPanel {
    //MVC
    //public static ConnectDB conn = new ConnectDB();
    DefaultTableModel tblDanhSach;
    java.util.List<KhachHang> arr = new ArrayList<>();
    String MaKhachHang, TenKhachHang, NgaySinh, GioiTinh, DiaChi, SDT, LoaiKhachHang, GhiChu, sMaKhachHangTim;
    String macu;
    SimpleDateFormat sDF = new SimpleDateFormat("yyyy-MM-dd");
    Date date;
    private final String[] colName = {"Mã khách hàng", "Tên khách hàng", "Ngày sinh", "Giới tính", "Địa chỉ", "Số điện thoại", "Loại khách Hàng", "Ghi chú"};
    private final String[] sqlName = {"MaKhachHang", "TenKhachHang", "NgaySinh", "GioiTinh", "DiaChi", "SDT", "LoaiKhachHang", "GhiChu"};
    Vector<String> vec = new Vector<String>(100);    
	public PanelKhachHang() {
		initComponents();
                //MVC
                        tblDanhSach = (DefaultTableModel) tblKhachHang_KhachHang.getModel();
                        sMaKhachHangTim="";
                        LayNguon();
        }
    public void XoaTrang(){
        txtMaKhachHang_KhachHang.setText("");
        txtTenKhachHang_KhachHang.setText("");
        txtDiaChi_KhachHang.setText("");
        txtSDT_KhachHang.setText(""); 
        txtGhiChu_KhachHang.setText("");
        cbGioiTinh.setSelectedIndex(0);
    }
    
    public void  LayNguon(){
        arr = CKhachHang.LayNguon(sMaKhachHangTim);
        tblDanhSach.setRowCount(0); // xóa trắng danh sách
        arr.forEach(p->{
            tblDanhSach.addRow(new Object[]{
                p.getMaKhachHang(), p.getTenKhachHang(), p.getNgaySinh(), p.getGioiTinh(), p.getDiaChi(), p.getSDT(), p.getLoaiKhachHang(), p.getGhiChu(),
            });
        });
    }
            
            
	private void loadDataTableS() {
		try {
			String col = sqlName[CBTK.getSelectedIndex()];
			String key = txtTimKiem.getText();
			DefaultTableModel tableModel = new DefaultTableModel();
                	Database.ConnectDB conn = new Database.ConnectDB ();
			Vector<String> colsName = new Vector<String>(10);
			colsName.add("Mã khách hàng");
			colsName.add("Tên khách hàng");
			colsName.add("Ngày sinh");
			colsName.add("Giới tính");
			colsName.add("Địa chỉ");
			colsName.add("Số điện thoại");
			colsName.add("Loại khách Hàng");
                        colsName.add("Ghi chú");
			
			tableModel.setColumnIdentifiers(colsName);
			
			vec = conn.selectSearch("KhachHang", col, key);
			
			String[][] str = new String[vec.size()][];
			for (int i = 0; i < vec.size(); i++) {
				Vector<String> vector = new Vector<String>(100);
				str[i] = vec.get(i).split("\t");
				for (int j = 0; j < str[i].length; j++) {
					vector.add(str[i][j]);
				}
				tableModel.addRow(vector);
			}
			tblKhachHang_KhachHang.setModel(tableModel);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không có kết quả tìm kiếm ", "Thông báo", 1);
		}
	}
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                ImageIcon icon = new ImageIcon("background2.jpg");
                Image image = icon.getImage();
                g.drawImage(image, 0, 0, this.getSize().width, this.getSize().height, this);

            }
        };
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
        jPanel_KhachHang = new javax.swing.JPanel();
        jScrollPane24 = new javax.swing.JScrollPane();
        tblKhachHang_KhachHang = new javax.swing.JTable();
        jLabel56 = new javax.swing.JLabel();
        lblMaKhachHang_KhachHang = new javax.swing.JLabel();
        lblTenKhachHang_KhachHang = new javax.swing.JLabel();
        txtMaKhachHang_KhachHang = new javax.swing.JTextField();
        txtTenKhachHang_KhachHang = new javax.swing.JTextField();
        lblNgaySinh_KhachHang = new javax.swing.JLabel();
        lblGioiTinh_KhachHang = new javax.swing.JLabel();
        lblDiaChi_KhachHang = new javax.swing.JLabel();
        txtDiaChi_KhachHang = new javax.swing.JTextField();
        lblSDT_KhachHang = new javax.swing.JLabel();
        txtSDT_KhachHang = new javax.swing.JTextField();
        cbbLoaiKhachHang_KhachHang = new javax.swing.JComboBox<>();
        lblLoaiKhachHang_KhachHang = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        txtGhiChu_KhachHang = new javax.swing.JTextPane();
        btnSua_KhachHang = new javax.swing.JButton();
        btnXoa_KhachHang = new javax.swing.JButton();
        lblLoiMaKhachHang_KhachHang4 = new javax.swing.JLabel();
        lblLoiMaKhachHang_KhachHang5 = new javax.swing.JLabel();
        cbGioiTinh = new javax.swing.JComboBox<>();
        dtNgaySinh = new com.toedter.calendar.JDateChooser();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1366, 738));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(1366, 700));

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

        CBTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã khách hàng", "Tên khách hàng", "Ngày sinh", "Giới tính", "Địa chỉ", "Số điện thoại", "Loại khách Hàng", "Ghi chú" }));
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
        btKhong.setToolTipText("");
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
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel13))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btThem, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btSua, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(btKhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThem)
                    .addComponent(btSua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btXoa)
                    .addComponent(btKhong))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel_KhachHang.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel_KhachHangComponentShown(evt);
            }
        });

        tblKhachHang_KhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Khách Hàng", "Tên Khách Hàng", "Ngày Sinh", "Giới Tính", "Ðịa Chỉ", "SDT", "Loại Khách Hàng", "Ghi Chú"
            }
        ));
        tblKhachHang_KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHang_KhachHangMouseClicked(evt);
            }
        });
        jScrollPane24.setViewportView(tblKhachHang_KhachHang);

        jLabel56.setText("Khách Hàng");

        lblMaKhachHang_KhachHang.setText("Mã khách hàng");

        lblTenKhachHang_KhachHang.setText("Tên khách hàng");

        txtMaKhachHang_KhachHang.setEditable(false);

        txtTenKhachHang_KhachHang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTenKhachHang_KhachHangFocusLost(evt);
            }
        });
        txtTenKhachHang_KhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKhachHang_KhachHangActionPerformed(evt);
            }
        });
        txtTenKhachHang_KhachHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTenKhachHang_KhachHangKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTenKhachHang_KhachHangKeyTyped(evt);
            }
        });

        lblNgaySinh_KhachHang.setText("Ngày Sinh");

        lblGioiTinh_KhachHang.setText("Giới Tính");

        lblDiaChi_KhachHang.setText("Địa Chỉ");

        txtDiaChi_KhachHang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDiaChi_KhachHangFocusLost(evt);
            }
        });

        lblSDT_KhachHang.setText("Số điện thoại");

        txtSDT_KhachHang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSDT_KhachHangFocusLost(evt);
            }
        });
        txtSDT_KhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDT_KhachHangActionPerformed(evt);
            }
        });

        cbbLoaiKhachHang_KhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thường", "Vip " }));
        cbbLoaiKhachHang_KhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLoaiKhachHang_KhachHangActionPerformed(evt);
            }
        });

        lblLoaiKhachHang_KhachHang.setText("Loại KH");

        jLabel85.setText("Ghi Chú");

        jScrollPane25.setViewportView(txtGhiChu_KhachHang);

        btnSua_KhachHang.setText("Sửa");
        btnSua_KhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua_KhachHangActionPerformed(evt);
            }
        });

        btnXoa_KhachHang.setText("Xóa");
        btnXoa_KhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa_KhachHangActionPerformed(evt);
            }
        });

        lblLoiMaKhachHang_KhachHang4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblLoiMaKhachHang_KhachHang4.setForeground(new java.awt.Color(255, 0, 51));

        lblLoiMaKhachHang_KhachHang5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblLoiMaKhachHang_KhachHang5.setForeground(new java.awt.Color(255, 0, 51));

        cbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

        dtNgaySinh.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel_KhachHangLayout = new javax.swing.GroupLayout(jPanel_KhachHang);
        jPanel_KhachHang.setLayout(jPanel_KhachHangLayout);
        jPanel_KhachHangLayout.setHorizontalGroup(
            jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_KhachHangLayout.createSequentialGroup()
                .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_KhachHangLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNgaySinh_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTenKhachHang_KhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblGioiTinh_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaKhachHang_KhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 45, Short.MAX_VALUE)
                        .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenKhachHang_KhachHang)
                            .addComponent(cbGioiTinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaKhachHang_KhachHang)
                            .addComponent(dtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                        .addGap(139, 139, 139)
                        .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_KhachHangLayout.createSequentialGroup()
                                    .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblLoaiKhachHang_KhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel_KhachHangLayout.createSequentialGroup()
                                            .addComponent(lblSDT_KhachHang)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblLoiMaKhachHang_KhachHang5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(jPanel_KhachHangLayout.createSequentialGroup()
                                    .addComponent(lblDiaChi_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)))
                            .addGroup(jPanel_KhachHangLayout.createSequentialGroup()
                                .addComponent(jLabel85)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane25)
                            .addComponent(txtDiaChi_KhachHang)
                            .addComponent(txtSDT_KhachHang)
                            .addComponent(cbbLoaiKhachHang_KhachHang, 0, 240, Short.MAX_VALUE))
                        .addGap(343, 343, 343)
                        .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnXoa_KhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(btnSua_KhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel_KhachHangLayout.createSequentialGroup()
                        .addGap(441, 441, 441)
                        .addComponent(jLabel56)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel_KhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 1046, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_KhachHangLayout.createSequentialGroup()
                    .addGap(145, 145, 145)
                    .addComponent(lblLoiMaKhachHang_KhachHang4, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addGap(833, 833, 833)))
        );
        jPanel_KhachHangLayout.setVerticalGroup(
            jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_KhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaKhachHang_KhachHang)
                    .addComponent(txtMaKhachHang_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDiaChi_KhachHang)
                    .addComponent(txtDiaChi_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_KhachHangLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblLoiMaKhachHang_KhachHang5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnSua_KhachHang))
                    .addGroup(jPanel_KhachHangLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnXoa_KhachHang)
                            .addGroup(jPanel_KhachHangLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTenKhachHang_KhachHang)
                                    .addComponent(txtTenKhachHang_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblNgaySinh_KhachHang)
                                    .addComponent(dtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblGioiTinh_KhachHang)
                                    .addComponent(cbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel_KhachHangLayout.createSequentialGroup()
                                .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSDT_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSDT_KhachHang))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblLoaiKhachHang_KhachHang)
                                    .addComponent(cbbLoaiKhachHang_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel85)
                                    .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_KhachHangLayout.createSequentialGroup()
                    .addContainerGap(484, Short.MAX_VALUE)
                    .addComponent(lblLoiMaKhachHang_KhachHang4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_KhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(172, 172, 172))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

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

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
    loadDataTableS();
    }//GEN-LAST:event_btnTimKiemActionPerformed
               
    private void CBTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBTKActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
     loadDataTableS();
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void tblKhachHang_KhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHang_KhachHangMouseClicked
    try{    
        int index = tblKhachHang_KhachHang.getSelectedRow();
        TableModel model = tblKhachHang_KhachHang.getModel();
        MaKhachHang = model.getValueAt(index, 0).toString();
        TenKhachHang = model.getValueAt(index, 1).toString();
        NgaySinh = model.getValueAt(index, 2).toString();
        GioiTinh = model.getValueAt(index, 3).toString();
        DiaChi = model.getValueAt(index, 4).toString();
        SDT = model.getValueAt(index, 5).toString();
        LoaiKhachHang = model.getValueAt(index, 6).toString();
        GhiChu = model.getValueAt(index, 7).toString();

        txtMaKhachHang_KhachHang.setText(MaKhachHang);
        txtTenKhachHang_KhachHang.setText(TenKhachHang);
        try {
            date = sDF.parse(NgaySinh);
            dtNgaySinh.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(PanelKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }        
        cbGioiTinh.setSelectedItem(GioiTinh);
        txtDiaChi_KhachHang.setText(DiaChi);
        txtSDT_KhachHang.setText(SDT);
        cbbLoaiKhachHang_KhachHang.setSelectedItem(LoaiKhachHang);
        txtGhiChu_KhachHang.setText(GhiChu);
    } catch (NullPointerException ex) {
    System.out.println("Bắt ngoại lệ dữ liệu null:" + ex);
    }            
    }//GEN-LAST:event_tblKhachHang_KhachHangMouseClicked

    private void txtTenKhachHang_KhachHangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenKhachHang_KhachHangFocusLost
        lblTenKhachHang_KhachHang.setForeground(Color.black);
    }//GEN-LAST:event_txtTenKhachHang_KhachHangFocusLost

    private void txtTenKhachHang_KhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKhachHang_KhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKhachHang_KhachHangActionPerformed

    private void txtTenKhachHang_KhachHangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenKhachHang_KhachHangKeyPressed

    }//GEN-LAST:event_txtTenKhachHang_KhachHangKeyPressed

    private void txtTenKhachHang_KhachHangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenKhachHang_KhachHangKeyTyped

    }//GEN-LAST:event_txtTenKhachHang_KhachHangKeyTyped

    private void txtDiaChi_KhachHangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiaChi_KhachHangFocusLost
        lblDiaChi_KhachHang.setForeground(Color.black);
    }//GEN-LAST:event_txtDiaChi_KhachHangFocusLost

    private void txtSDT_KhachHangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSDT_KhachHangFocusLost
        lblSDT_KhachHang.setForeground(Color.black);
    }//GEN-LAST:event_txtSDT_KhachHangFocusLost

    private void btnSua_KhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua_KhachHangActionPerformed

    }//GEN-LAST:event_btnSua_KhachHangActionPerformed

    private void btnXoa_KhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa_KhachHangActionPerformed

    }//GEN-LAST:event_btnXoa_KhachHangActionPerformed

    private void jPanel_KhachHangComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel_KhachHangComponentShown

    }//GEN-LAST:event_jPanel_KhachHangComponentShown

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        txtMaKhachHang_KhachHang.requestFocus();
        if(txtTenKhachHang_KhachHang.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên khách","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtTenKhachHang_KhachHang.requestFocus();
            return;
        }
        if(txtDiaChi_KhachHang.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập địa chỉ khách","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtDiaChi_KhachHang.requestFocus();
            return;
        }
        if(txtSDT_KhachHang.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập SÐT khách","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtSDT_KhachHang.requestFocus();
            return;
        }

        //thực hiện ghi
        MaKhachHang=txtMaKhachHang_KhachHang.getText();
        TenKhachHang=txtTenKhachHang_KhachHang.getText();
        NgaySinh = sDF.format(dtNgaySinh.getDate());
        GioiTinh = cbGioiTinh.getSelectedItem().toString();
        DiaChi = txtDiaChi_KhachHang.getText();
        SDT= txtSDT_KhachHang.getText();
        LoaiKhachHang = cbbLoaiKhachHang_KhachHang.getSelectedItem().toString();
        GhiChu =txtGhiChu_KhachHang.getText();

        KhachHang nv = new KhachHang(MaKhachHang, TenKhachHang, NgaySinh, GioiTinh, DiaChi, SDT, LoaiKhachHang, GhiChu);
        CKhachHang.ThemMoi(nv);
        //lấy nguồn dữ liệu mới
        LayNguon();
    }//GEN-LAST:event_btThemActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        if(txtMaKhachHang_KhachHang.getText().length()<=0)
        return;
        int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa [" + txtMaKhachHang_KhachHang.getText() + "] không ?","Thông báo",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (kq == JOptionPane.YES_OPTION) {
            macu = txtMaKhachHang_KhachHang.getText();
            CKhachHang.XoaBo(macu);
            LayNguon();
            XoaTrang();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btXoaActionPerformed

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
        macu = txtMaKhachHang_KhachHang.getText();
        txtMaKhachHang_KhachHang.requestFocus();
        if(txtTenKhachHang_KhachHang.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên khách","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtTenKhachHang_KhachHang.requestFocus();
            return;
        }
        if(txtDiaChi_KhachHang.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tài khoản khách","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtDiaChi_KhachHang.requestFocus();
            return;
        }
        if(txtSDT_KhachHang.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mật khẩu khách","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtSDT_KhachHang.requestFocus();
            return;
        }

        //thực hiện ghi
        MaKhachHang=txtMaKhachHang_KhachHang.getText();
        TenKhachHang=txtTenKhachHang_KhachHang.getText();
        NgaySinh = sDF.format(dtNgaySinh.getDate());
        GioiTinh = cbGioiTinh.getSelectedItem().toString();
        DiaChi = txtDiaChi_KhachHang.getText();
        SDT= txtSDT_KhachHang.getText();
        LoaiKhachHang = cbbLoaiKhachHang_KhachHang.getSelectedItem().toString();
        GhiChu =txtGhiChu_KhachHang.getText();

        KhachHang nv = new KhachHang(MaKhachHang, TenKhachHang, NgaySinh, GioiTinh, DiaChi, SDT, LoaiKhachHang, GhiChu);
        CKhachHang.CapNhat(nv, macu);
        LayNguon();        
    }//GEN-LAST:event_btSuaActionPerformed

    private void btKhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKhongActionPerformed
        XoaTrang();
    }//GEN-LAST:event_btKhongActionPerformed

    private void txtSDT_KhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDT_KhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDT_KhachHangActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    txtTimKiem.setText("");
    loadDataTableS();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbbLoaiKhachHang_KhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLoaiKhachHang_KhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbLoaiKhachHang_KhachHangActionPerformed

//    public static void main(String[] args) {
//		
//		java.awt.EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				PanelKhachHang pKhachHang = new PanelKhachHang();
//				
//				pKhachHang.setVisible(true);
//				
//			}
//		});
//		
//	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBTK;
    private javax.swing.JButton btKhong;
    private javax.swing.JButton btSua;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btXoa;
    private javax.swing.JButton btnSua_KhachHang;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa_KhachHang;
    private javax.swing.JComboBox<String> cbGioiTinh;
    private javax.swing.JComboBox<String> cbbLoaiKhachHang_KhachHang;
    private com.toedter.calendar.JDateChooser dtNgaySinh;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel_KhachHang;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JLabel lblDiaChi_KhachHang;
    private javax.swing.JLabel lblGioiTinh_KhachHang;
    private javax.swing.JLabel lblLoaiKhachHang_KhachHang;
    private javax.swing.JLabel lblLoiMaKhachHang_KhachHang4;
    private javax.swing.JLabel lblLoiMaKhachHang_KhachHang5;
    private javax.swing.JLabel lblMaKhachHang_KhachHang;
    private javax.swing.JLabel lblNgaySinh_KhachHang;
    private javax.swing.JLabel lblSDT_KhachHang;
    private javax.swing.JLabel lblTenKhachHang_KhachHang;
    private javax.swing.JTable tblKhachHang_KhachHang;
    private javax.swing.JTextField txtDiaChi_KhachHang;
    private javax.swing.JTextPane txtGhiChu_KhachHang;
    private javax.swing.JTextField txtMaKhachHang_KhachHang;
    private javax.swing.JTextField txtSDT_KhachHang;
    private javax.swing.JTextField txtTenKhachHang_KhachHang;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
