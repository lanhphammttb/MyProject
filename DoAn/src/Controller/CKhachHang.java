package Controller;

import Model.KhachHang;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CKhachHang {
    public static Connection conn;
    public static Statement state;
    public static PreparedStatement pstate;
    public static String sql;
    public static ResultSet rs;
    //1. lấy nguồn: lấy dữ liệu từ CSDL và đưa vào mảng ArryList<TaiKhoan>
    public static List<KhachHang> LayNguon(String sMaKhachHang){
        List<KhachHang> arr = new ArrayList<>();
        conn = null;
        state = null;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "select * From KhachHang ";
            if(sMaKhachHang.equals("")==false)
                sql = sql + " Where KhachHang.MaKhachHang = N'" + sMaKhachHang+ "'";
            sql = sql + " Order by TenKhachHang asc ";
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                KhachHang temp = new KhachHang();
                temp.setMaKhachHang(rs.getString("MaKhachHang"));
                temp.setTenKhachHang(rs.getString("TenKhachHang"));
                temp.setNgaySinh(rs.getString("NgaySinh"));
                temp.setGioiTinh(rs.getString("GioiTinh"));  
                temp.setDiaChi(rs.getString("DiaChi"));
                temp.setSDT(rs.getString("SDT"));
                temp.setLoaiKhachHang(rs.getString("LoaiKhachHang"));
                temp.setGhiChu(rs.getString("GhiChu"));
                arr.add(temp);
            }
            state.close(); conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(state!=null)
                try {
                    state.close();
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
        return arr;
    }
    //2. insert: thêm tài khoản 
    public static void ThemMoi(KhachHang kh) {
        conn = null;
        pstate = null;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "insert into KhachHang (TenKhachHang, NgaySinh, GioiTinh, DiaChi, SDT, LoaiKhachHang, GhiChu) values (?,?,?,?,?,?,?)";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, kh.getTenKhachHang());
            pstate.setString(2, kh.getNgaySinh());
            pstate.setString(3, kh.getGioiTinh());
            pstate.setString(4, kh.getDiaChi());
            pstate.setString(5, kh.getSDT());
            pstate.setString(6, kh.getLoaiKhachHang());
            pstate.setString(7, kh.getGhiChu());
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
    //3. update: cập nhật tài khoản
    public static void CapNhat(KhachHang kh, String macu){
        conn = null;
        pstate = null;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "update KhachHang set  TenKhachHang =?, NgaySinh =?, GioiTinh =?, DiaChi = ?, SDT =?, LoaiKhachHang =?, GhiChu =? where MaKhachHang=? ";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, kh.getTenKhachHang());
            pstate.setString(2, kh.getNgaySinh());
            pstate.setString(3, kh.getGioiTinh());
            pstate.setString(4, kh.getDiaChi());
            pstate.setString(5, kh.getSDT());
            pstate.setString(6, kh.getLoaiKhachHang());
            pstate.setString(7, kh.getGhiChu());
            pstate.setString(8, macu);
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
    //4. delete: xóa tài khoản
    public static void XoaBo(String macu) {
        conn = null;
        pstate = null;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "delete from KhachHang where MaKhachHang=?";
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
