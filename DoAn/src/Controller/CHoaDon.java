/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.CChiTietHoaDon.conn;
import static Controller.CChiTietHoaDon.rs;
import static Controller.CChiTietHoaDon.sql;
import static Controller.CChiTietHoaDon.state;
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
import Model.HoaDon;
import Model.ChiTietHoaDon;

public class CHoaDon {
    public static String sql;
    public static Connection conn;
    public static Statement state;
    public static ResultSet rs;
    public static PreparedStatement pstate;
    //1. lay nguon
    public static List<HoaDon> LayNguonHD(String sMaHoaDon){
        List<HoaDon> arr = new ArrayList<>();
         conn = null;
         state = null;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "select * From HoaDon ";
            if(sMaHoaDon.equals("")==false)
                sql = sql + " Where HoaDon.MaHoaDon = " + sMaHoaDon;
            //sql = sql + " Order by MaHoaDon ";
            state =conn.createStatement();
             rs = state.executeQuery(sql);
            while(rs.next()){
                HoaDon temp = new HoaDon();
                temp.setMaHoaDon(rs.getString("MaHoaDon")); 
                temp.setMaKhachHang(rs.getString("MaKhachHang"));               
                temp.setMaNhanVien(rs.getString("MaNhanVien"));
                temp.setNgayLapHoaDon(rs.getString("NgayLapHoaDon"));
                temp.setKhuyenMai(rs.getString("KhuyenMai"));
                temp.setTongTien(rs.getString("TongTien"));
                temp.setGhiChu(rs.getString("GhiChu"));
                arr.add(temp);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(state!=null){
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arr;
    }
//    public static List<HoaDon> LayDuLieuHoaDon(){
//        List<HoaDon> arr = new ArrayList<>();
//         conn = null;
//         state = null;
//        
//        try {
//            conn = DriverManager.getConnection(dbURL);
//            sql = "select MaHoaDon,KhachHang.TenKhachHang as TenKhachHang,NhanVien.TenNhanVien,TongTien,NgayLapHoaDon,HoaDon.GhiChu from HoaDon,KhachHang,NhanVien where HoaDon.MaKhachHang =KhachHang.MaKhachHang and HoaDon.MaNhanVien=NhanVien.MaNhanVien ";
//            state =conn.createStatement();
//             rs = state.executeQuery(sql);
//            while(rs.next()){
//                HoaDon temp = new HoaDon();
//                temp.setMaHoaDon(rs.getString("MaHoaDon")); 
//                temp.setMaKhachHang(rs.getString("MaKhachHang"));               
//                temp.setMaNhanVien(rs.getString("MaNhanVien"));
//                temp.setNgayLapHoaDon(rs.getString("NgayLapHoaDon"));
//                temp.setTongTien(rs.getString("TongTien"));
//                temp.setGhiChu(rs.getString("GhiChu"));
//                arr.add(temp);
//            }
//            state.close();
//            conn.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(CHoaDon.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        finally{
//            if(state!=null){
//                try {
//                    state.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(CHoaDon.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if(conn!=null){
//                try {
//                    conn.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(CHoaDon.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//        return arr;
//    }
           //2.them tai khoan
    public static void ThemMoi(HoaDon hd){
        conn = null;
        pstate = null;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Insert into HoaDon(MaKhachHang,MaNhanVien,NgayLapHoaDon,KhuyenMai, TongTien, GhiChu) values(?,?,?,?,?,?)";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, hd.getMaKhachHang());
            pstate.setString(2, hd.getMaNhanVien());
            pstate.setString(3, hd.getNgayLapHoaDon());
            pstate.setString(4, hd.getKhuyenMai());
            pstate.setString(5, hd.getTongTien());
            pstate.setString(6, hd.getGhiChu());
            pstate.execute();
            pstate.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(pstate!=null){
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    //3.cap nhat tai khoan
    public static void CapNhat(HoaDon hd, String macu){
        conn = null;
        pstate = null;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Update HoaDon Set MaKhachHang =?, MaNhanVien =?, NgayLapHoaDon =?,KhuyenMai =?, TongTien =?, GhiChu =? Where MaHoaDon =?";
            pstate = conn.prepareStatement(sql);
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, hd.getMaKhachHang());
            pstate.setString(2, hd.getMaNhanVien());
            pstate.setString(3, hd.getNgayLapHoaDon());
            pstate.setString(4, hd.getKhuyenMai());
            pstate.setString(5, hd.getTongTien());
            pstate.setString(6, hd.getGhiChu());
            pstate.setString(7, macu);
            pstate.execute();
            pstate.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(pstate!=null){
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CHoaDon.class.getName()).log(Level.SEVERE, null, ex);
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
            sql = "Delete From HoaDon Where MaHoaDon =?";
            pstate= conn.prepareStatement(sql);
            pstate.setString(1, macu);
            pstate.execute();
            pstate.close();
            conn.close();   
        } catch (SQLException ex) {
            Logger.getLogger(CHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(pstate!=null){
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }   
    } 
    public static List<HoaDon> findByDate(String ngay){
        List<HoaDon> arr = new ArrayList<>();
        conn = null;
        pstate=null;
       
        try {
            conn = DriverManager.getConnection(dbURL);
            sql="Select * From HoaDon where NgayLapHoaDon like ?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, "%" + ngay + "%");
            rs = pstate.executeQuery();
            while (rs.next())
            {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getString("MaHoaDon")); 
                hd.setMaKhachHang(rs.getString("MaKhachHang"));               
                hd.setMaNhanVien(rs.getString("MaNhanVien"));
                hd.setNgayLapHoaDon(rs.getString("NgayLapHoaDon"));
                hd.setKhuyenMai(rs.getString("KhuyenMai"));
                hd.setTongTien(rs.getString("TongTien"));
                hd.setGhiChu(rs.getString("GhiChu"));
                arr.add(hd);   
            }
            pstate.close(); conn.close();           
        } catch (SQLException ex) {
            Logger.getLogger(CHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    
    public static List<HoaDon> ThongKeTheoNam(String Stim){
        List<HoaDon> arr = new ArrayList<>();
         conn = null;
         pstate = null;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "select * from HoaDon Where NgayLapHoaDon like ?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, "%" + Stim);
            rs = pstate.executeQuery();
            while (rs.next())
            {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getString("MaHoaDon")); 
                hd.setMaKhachHang(rs.getString("MaKhachHang"));               
                hd.setMaNhanVien(rs.getString("MaNhanVien"));
                hd.setNgayLapHoaDon(rs.getString("NgayLapHoaDon"));
                hd.setKhuyenMai(rs.getString("KhuyenMai"));
                hd.setTongTien(rs.getString("TongTien"));
                hd.setGhiChu(rs.getString("GhiChu"));
                arr.add(hd);   
            }
            pstate.close(); conn.close();           
        } catch (SQLException ex) {
            Logger.getLogger(CHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    
        public static List<HoaDon> ThongKeTheoThang(String Sthang){
        List<HoaDon> arr = new ArrayList<>();
         conn = null;
         pstate = null;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "select * from HoaDon Where NgayLapHoaDon like ?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, "%" + Sthang+ "%");
            rs = pstate.executeQuery();
            while (rs.next())
            {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getString("MaHoaDon")); 
                hd.setMaKhachHang(rs.getString("MaKhachHang"));               
                hd.setMaNhanVien(rs.getString("MaNhanVien"));
                hd.setNgayLapHoaDon(rs.getString("NgayLapHoaDon"));
                hd.setKhuyenMai(rs.getString("KhuyenMai"));
                hd.setTongTien(rs.getString("TongTien"));
                hd.setGhiChu(rs.getString("GhiChu"));
                arr.add(hd);   
            }
            pstate.close(); conn.close();           
        } catch (SQLException ex) {
            Logger.getLogger(CHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

}
//        
////    public static List<HoaDon> CapnhatThanhTien(String sthanhtien,String sSua){
////        List<HoaDon> arr = new ArrayList<>();
////         conn = null;
////         pstate = null;
////        
////        try {
////            conn = DriverManager.getConnection(dbURL);
////            sql = "update HoaDon set DaThanhToan ='" + sthanhtien + "' where id='"+ sSua +"'";
////            pstate = conn.prepareStatement(sql);
////            rs = pstate.executeQuery();
////            while (rs.next())
////            {
////                HoaDon hd = new HoaDon();
//                hd.setIdPX(rs.getInt("idPX")); 
//                hd.setMaKH(rs.getString("MaKH"));               
//                hd.setMaNV(rs.getString("MaNV"));
//                hd.setNgayBan(rs.getString("NgayBan"));
//                hd.setTongtien(rs.getInt("TongTien"));
////                arr.add(hd);   
////            }
////            pstate.close(); conn.close();           
////        } catch (SQLException ex) {
////            Logger.getLogger(CHoaDon.class.getName()).log(Level.SEVERE, null, ex);
////        }
////        return arr;
////    }

