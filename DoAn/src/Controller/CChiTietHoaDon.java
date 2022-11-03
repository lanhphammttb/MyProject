package Controller;

import static Controller.CNhanVien.pstate;
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
import Model.ChiTietHoaDon;
import static Database.ConnectDB.dbURL;

public class CChiTietHoaDon {
    public static String sql;
    public static Connection conn;
    public static Statement state;
    public static ResultSet rs;
    public static PreparedStatement pstate;
           //2.them tai khoan
    public static void ThemMoi(ChiTietHoaDon cn){
        conn = null;
        pstate = null;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Insert into ChiTietHoaDon(MaHoaDon, MaSanPham, SoLuong, TongTien) values(?,?,?,?)";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, cn.getMaHoaDon());
            pstate.setString(2, cn.getMaSanPham());
            pstate.setString(3, cn.getSoLuong());
            pstate.setString(4, cn.getTongTien());
            pstate.execute();
            pstate.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(pstate!=null){
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    //3.cap nhat tai khoan
    public static void CapNhat(ChiTietHoaDon cn, String macu){
        conn = null;
        pstate = null;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Update ChiTietHoaDon Set MaHoaDon = ?, MaSanPham =?, SoLuong = ?, TongTien = ? Where MaCTHD=?";
            pstate = conn.prepareStatement(sql);
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, cn.getMaHoaDon());
            pstate.setString(2, cn.getMaSanPham());
            pstate.setString(3, cn.getSoLuong());
            pstate.setString(4, cn.getTongTien());
            pstate.setString(5, macu);
            pstate.execute();
            pstate.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(pstate!=null){
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
    }
    //4.xoa tai khoan
    public static void XoaBo(String macu){
        conn = null;
        pstate = null;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Delete From ChiTietHoaDon Where MaCTHD =?";
            pstate= conn.prepareStatement(sql);
            pstate.setString(1, macu);
            pstate.execute();
            pstate.close();
            conn.close();   
        } catch (SQLException ex) {
            Logger.getLogger(CChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(pstate!=null){
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }   
    }            
}
