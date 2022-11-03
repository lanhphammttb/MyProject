package Controller;

import static Controller.CKhachHang.conn;
import static Controller.CKhachHang.pstate;
import static Controller.CKhachHang.sql;
import static Database.ConnectDB.dbURL;
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
import Model.SanPham;

public class CSanPham{

    public static String sql;
    public static Connection conn;
    public static Statement state;
    public static ResultSet rs;
    public static PreparedStatement pstate;
    //2.them tai khoan

    public static void ThemMoi(SanPham tk) {
        conn = null;
        pstate = null;

        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Insert into SanPham(MaSanPham, TenSanPham, LoaiSanPham, Size, GiaBan) values(?,?,?,?,?)";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, tk.getMaSanPham());
            pstate.setString(2, tk.getTenSanPham());
            pstate.setString(3, tk.getLoaiSanPham());
            pstate.setString(4, tk.getSize());
            pstate.setString(5, tk.getGiaBan());
            pstate.execute();
            pstate.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    //3.cap nhat tai khoan
    public static void CapNhat(SanPham tk, String macu) {
        conn = null;
        pstate = null;

        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Update SanPham Set MaSanPham =?, TenSanPham =?, LoaiSanPham =?, Size =?, GiaBan =? Where MaSanPham=?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, tk.getMaSanPham());
            pstate.setString(2, tk.getTenSanPham());
            pstate.setString(3, tk.getLoaiSanPham());
            pstate.setString(4, tk.getSize());
            pstate.setString(5, tk.getGiaBan());
            pstate.setString(6, macu);
            pstate.execute();
            pstate.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CSanPham.class.getName()).log(Level.SEVERE, null, ex);
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
            sql = "delete from SanPham where MaSanPham=?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, macu);
            pstate.execute();
            pstate.close(); conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(pstate!=null)
                try {
                    pstate.close();
            } catch (SQLException ex) {
                Logger.getLogger(CKhachHang.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(conn!=null)
                try {
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CKhachHang.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }   
    }
}
