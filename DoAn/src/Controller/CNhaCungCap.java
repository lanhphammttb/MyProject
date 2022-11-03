package Controller;

import Model.NhaCungCap;
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

public class CNhaCungCap {
    public static Connection conn;
    public static Statement state;
    public static PreparedStatement pstate;
    public static String sql;
    public static ResultSet rs;
    //1. lấy nguồn: lấy dữ liệu từ CSDL và đưa vào mảng ArryList<TaiKhoan>
    public static List<NhaCungCap> LayNguon(String sMaNCC){
        List<NhaCungCap> arr = new ArrayList<>();
        conn = null;
        state = null;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "select * From NhaCungCap ";
            if(sMaNCC.equals("")==false)
                sql = sql + " Where NhaCungCap.MaNCC'" + sMaNCC + "'";
            sql = sql + " Order by TenNCC Desc";
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                NhaCungCap temp = new NhaCungCap();
                temp.setMaNCC(rs.getString("MaNCC"));
                temp.setTenNCC(rs.getString("TenNCC"));
                temp.setDiaChi(rs.getString("DiaChi"));
                temp.setSDT(rs.getString("SDT"));  
                temp.setEmail(rs.getString("Email"));
                temp.setGhiChu(rs.getString("GhiChu"));
                arr.add(temp);
            }
            state.close(); conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CNhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(state!=null)
                try {
                    state.close();
            } catch (SQLException ex) {
                Logger.getLogger(CNhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(conn!=null)
                try {
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CNhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arr;
    }
    //2. insert: thêm tài nccoản 
    public static void ThemMoi(NhaCungCap ncc) {
        conn = null;
        pstate = null;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "insert into NhaCungCap (TenNCC, DiaChi, SDT, Email, GhiChu) values (?,?,?,?,?)";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, ncc.getTenNCC());
            pstate.setString(2, ncc.getDiaChi());
            pstate.setString(3, ncc.getSDT());
            pstate.setString(4, ncc.getEmail());
            pstate.setString(5, ncc.getGhiChu());
            pstate.execute();
            pstate.close(); conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CNhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(pstate!=null)
                try {
                    pstate.close();
            } catch (SQLException ex) {
                Logger.getLogger(CNhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(conn!=null)
                try {
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CNhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }   
    }
    //3. update: cập nhật tài nccoản
    public static void CapNhat(NhaCungCap ncc, String macu){
        conn = null;
        pstate = null;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "update NhaCungCap set TenNCC =?, DiaChi = ?, SDT =?, Email =?, GhiChu =? where MaNCC=? ";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, ncc.getTenNCC());
            pstate.setString(2, ncc.getDiaChi());
            pstate.setString(3, ncc.getSDT());
            pstate.setString(4, ncc.getEmail());
            pstate.setString(5, ncc.getGhiChu());
            pstate.setString(6, macu);
            pstate.execute();
            pstate.close(); conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CNhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(pstate!=null)
                try {
                    pstate.close();
            } catch (SQLException ex) {
                Logger.getLogger(CNhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(conn!=null)
                try {
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CNhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }   
    }
    //4. delete: xóa tài nccoản
    public static void XoaBo(String macu) {
        conn = null;
        pstate = null;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "delete from NhaCungCap where MaNCC=?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, macu);
            pstate.execute();
            pstate.close(); conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CNhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(pstate!=null)
                try {
                    pstate.close();
            } catch (SQLException ex) {
                Logger.getLogger(CNhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(conn!=null)
                try {
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CNhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }   
    }
}
