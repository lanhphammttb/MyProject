package Controller;

import Model.NhanVien;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import static Database.ConnectDB.dbURL;

public class CNhanVien{

    public static String sql;
    public static Connection conn;
    public static Statement state;
    public static ResultSet rs;
    public static PreparedStatement pstate;

//    //1. lay nguon
//    public static List<NhanVien> LayNguonNV(String sMaNhanVien) {
//        List<NhanVien> arr = new ArrayList<>();
//        conn = null;
//        state = null;
//
//        try {
//            conn = DriverManager.getConnection(dbURL);
//            sql = " select * From NhanVien ";
//            if (sMaNhanVien.equals("") == false) {
//                sql = sql + " Where NhanVien.MaNhanVien = N'" + sMaNhanVien + "'";    //phải có N k lỗi
//            }
//            sql = sql + " Order by TenNhanVien asc ";
//            state = conn.createStatement();
//            rs = state.executeQuery(sql);
//            while (rs.next()) {
//                NhanVien temp = new NhanVien();
//                temp.setMaNhanVien(rs.getString("MaNhanVien"));
//                temp.setTenNhanVien(rs.getString("TenNhanVien"));
//                temp.setNgaySinh(rs.getString("NgaySinh"));
//                temp.setGioiTinh(rs.getString("GioiTinh"));
//                temp.setNgayVaoLam(rs.getString("NgayVaoLam"));
//                temp.setChucVu (rs.getString("ChucVu"));
//                temp.setDiaChi(rs.getString("DiaChi"));
//                temp.setSDT(rs.getString("SDT"));
//                temp.setCMND(rs.getString("CMND"));
//                arr.add(temp);
//            }
//            state.close();
//            conn.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if (state != null) {
//                try {
//                    state.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//        return arr;
//    }
    //2.them tai khoan

    public static void ThemMoi(NhanVien tk) {
        conn = null;
        pstate = null;

        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Insert into NhanVien(TenNhanVien, NgaySinh, GioiTinh, NgayVaoLam, ChucVu, DiaChi, SDT, CMND) values(?,?,?,?,?,?,?,?)";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, tk.getTenNhanVien());
            pstate.setString(2, tk.getNgaySinh());
            pstate.setString(3, tk.getGioiTinh());
            pstate.setString(4, tk.getNgayVaoLam());
            pstate.setString(5, tk.getChucVu());
            pstate.setString(6, tk.getDiaChi());
            pstate.setString(7, tk.getSDT());
            pstate.setString(8, tk.getCMND());
            pstate.execute();
            pstate.close();conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    //3.cap nhat tai khoan
    public static void CapNhat(NhanVien tk, String macu) {
        conn = null;
        pstate = null;

        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Update NhanVien Set TenNhanVien =?, NgaySinh =?, GioiTinh =?, NgayVaoLam =?, ChucVu =?, DiaChi =?, SDT =?, CMND =? Where MaNhanVien=?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, tk.getTenNhanVien());
            pstate.setString(2, tk.getNgaySinh());
            pstate.setString(3, tk.getGioiTinh());
            pstate.setString(4, tk.getNgayVaoLam());
            pstate.setString(5, tk.getChucVu());
            pstate.setString(6, tk.getDiaChi());
            pstate.setString(7, tk.getSDT());
            pstate.setString(8, tk.getCMND());
            pstate.setString(9, macu);
            pstate.execute();
            pstate.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    //4.xoa tai khoan
    public static void XoaBo(String macu) {
        conn = null;
        pstate = null;

        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Delete From NhanVien Where MaNhanVien =?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, macu);
            pstate.execute();
            pstate.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void DoiMatKhau(NhanVien tk, String macu) {
        conn = null;
        pstate = null;

        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Update NhanVien Set MaNhanVien =?, TenNhanVien =?, NgaySinh =?, GioiTinh =?, NgayVaoLam =?, ChucVu =?, DiaChi =?, SDT =?, CMND =? Where MaNhanVien=?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, tk.getMaNhanVien());
            pstate.setString(2, tk.getTenNhanVien());
            pstate.setString(3, tk.getNgaySinh());
            pstate.setString(4, tk.getGioiTinh());
            pstate.setString(5, tk.getNgayVaoLam());
            pstate.setString(6, tk.getChucVu());
            pstate.setString(7, tk.getDiaChi());
            pstate.setString(8, tk.getSDT());
            pstate.setString(9, tk.getCMND());
            pstate.setString(10, macu);
            pstate.execute();
            pstate.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}