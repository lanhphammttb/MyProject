/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
import Model.PhieuNhap;
import Model.ChiTietPhieuNhap;

public class CPhieuNhap {
    public static String sql;
    public static Connection conn;
    public static Statement state;
    public static ResultSet rs;
    public static PreparedStatement pstate;
    //1. lay nguon
//    public static List<PhieuNhap> LayNguonHD(String sMaPhieuNhap){
//        List<PhieuNhap> arr = new ArrayList<>();
//         conn = null;
//         state = null;
//        
//        try {
//            conn = DriverManager.getConnection(dbURL);
//            sql = "select * From PhieuNhap ";
//            if(sMaPhieuNhap.equals("")==false)
//                sql = sql + " Where PhieuNhap.MaPhieuNhap = " + sMaPhieuNhap;
//            //sql = sql + " Order by MaPhieuNhap ";
//            state =conn.createStatement();
//             rs = state.executeQuery(sql);
//            while(rs.next()){
//                PhieuNhap temp = new PhieuNhap();
//                temp.setMaPhieuNhap(rs.getString("MaPhieuNhap")); 
//                temp.setMaKhachHang(rs.getString("MaKhachHang"));               
//                temp.setMaNhanVien(rs.getString("MaNhanVien"));
//                temp.setNgayNhap(rs.getString("NgayNhap"));
//                temp.setTongTien(rs.getString("TongTien"));
//                temp.setGhiChu(rs.getString("GhiChu"));
//                arr.add(temp);
//            }
//            state.close();
//            conn.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(CPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        finally{
//            if(state!=null){
//                try {
//                    state.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(CPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if(conn!=null){
//                try {
//                    conn.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(CPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//        return arr;
//    }
//    public static List<PhieuNhap> LayDuLieuPhieuNhap(){
//        List<PhieuNhap> arr = new ArrayList<>();
//         conn = null;
//         state = null;
//        
//        try {
//            conn = DriverManager.getConnection(dbURL);
//            sql = "select MaPhieuNhap,KhachHang.TenKhachHang as TenKhachHang,NhanVien.TenNhanVien,TongTien,NgayNhap,PhieuNhap.GhiChu from PhieuNhap,KhachHang,NhanVien where PhieuNhap.MaKhachHang =KhachHang.MaKhachHang and PhieuNhap.MaNhanVien=NhanVien.MaNhanVien ";
//            state =conn.createStatement();
//             rs = state.executeQuery(sql);
//            while(rs.next()){
//                PhieuNhap temp = new PhieuNhap();
//                temp.setMaPhieuNhap(rs.getString("MaPhieuNhap")); 
//                temp.setMaKhachHang(rs.getString("MaKhachHang"));               
//                temp.setMaNhanVien(rs.getString("MaNhanVien"));
//                temp.setNgayNhap(rs.getString("NgayNhap"));
//                temp.setTongTien(rs.getString("TongTien"));
//                temp.setGhiChu(rs.getString("GhiChu"));
//                arr.add(temp);
//            }
//            state.close();
//            conn.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(CPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        finally{
//            if(state!=null){
//                try {
//                    state.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(CPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if(conn!=null){
//                try {
//                    conn.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(CPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//        return arr;
//    }
           //2.them tai khoan
    public static void ThemMoi(PhieuNhap pn){
        conn = null;
        pstate = null;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Insert into PhieuNhap(MaNhanVien,MaNCC,NgayNhap,TongTien,GhiChu) values(?,?,?,?,?)";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, pn.getMaNhanVien());
            pstate.setString(2, pn.getMaNCC());
            pstate.setString(3, pn.getNgayNhap());
            pstate.setString(4, pn.getTongTien());
            pstate.setString(5, pn.getGhiChu());
            pstate.execute();
            pstate.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(pstate!=null){
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    //3.cap nhat tai khoan
    public static void CapNhat(PhieuNhap pn, String macu){
        conn = null;
        pstate = null;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Update PhieuNhap Set MaNhanVien =?, MaNCC =?, NgayNhap =?, TongTien =?, GhiChu =? Where MaPhieuNhap =?";
            pstate = conn.prepareStatement(sql);
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, pn.getMaNhanVien());
            pstate.setString(2, pn.getMaNCC());
            pstate.setString(3, pn.getNgayNhap());
            pstate.setString(4, pn.getTongTien());
            pstate.setString(5, pn.getGhiChu());
            pstate.setString(6, macu);
            pstate.execute();
            pstate.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(pstate!=null){
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
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
            sql = "Delete From PhieuNhap Where MaPhieuNhap =?";
            pstate= conn.prepareStatement(sql);
            pstate.setString(1, macu);
            pstate.execute();
            pstate.close();
            conn.close();   
        } catch (SQLException ex) {
            Logger.getLogger(CPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(pstate!=null){
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }   
    } 
    public static List<PhieuNhap> findByDate(String ngay){
        List<PhieuNhap> arr = new ArrayList<>();
        conn = null;
        pstate=null;
       
        try {
            conn = DriverManager.getConnection(dbURL);
            sql="Select * From PhieuNhap where NgayNhap like ?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, ngay);
            rs = pstate.executeQuery();
            while (rs.next())
            {
                PhieuNhap pn = new PhieuNhap();
                pn.setMaPhieuNhap(rs.getString("MaPhieuNhap")); 
                pn.setMaNhanVien(rs.getString("MaNhanVien"));               
                pn.setMaNCC(rs.getString("MaNCC"));
                pn.setNgayNhap(rs.getString("NgayNhap"));
                pn.setTongTien(rs.getString("TongTien"));
                pn.setGhiChu(rs.getString("GhiChu"));
                arr.add(pn);   
            }
            pstate.close(); conn.close();           
        } catch (SQLException ex) {
            Logger.getLogger(CPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    
    public static List<PhieuNhap> ThongKeTheoNam(String Stim){
        List<PhieuNhap> arr = new ArrayList<>();
         conn = null;
         pstate = null;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "select * from PhieuNhap Where NgayNhap like ?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, "%" + Stim);
            rs = pstate.executeQuery();
            while (rs.next())
            {
                PhieuNhap pn = new PhieuNhap();
                pn.setMaPhieuNhap(rs.getString("MaPhieuNhap")); 
                pn.setMaNhanVien(rs.getString("MaNhanVien"));               
                pn.setMaNCC(rs.getString("MaNCC"));
                pn.setNgayNhap(rs.getString("NgayNhap"));
                pn.setTongTien(rs.getString("TongTien"));
                pn.setGhiChu(rs.getString("GhiChu"));
                arr.add(pn);   
            }
            pstate.close(); conn.close();           
        } catch (SQLException ex) {
            Logger.getLogger(CPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    
        public static List<PhieuNhap> ThongKeTheoThang(String Sthang){
        List<PhieuNhap> arr = new ArrayList<>();
         conn = null;
         pstate = null;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "select * from PhieuNhap Where NgayNhap like ?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, "%" + Sthang+ "%");
            rs = pstate.executeQuery();
            while (rs.next())
            {
                PhieuNhap pn = new PhieuNhap();
                pn.setMaPhieuNhap(rs.getString("MaPhieuNhap")); 
                pn.setMaNhanVien(rs.getString("MaNhanVien"));               
                pn.setMaNCC(rs.getString("MaNCC"));
                pn.setNgayNhap(rs.getString("NgayNhap"));
                pn.setTongTien(rs.getString("TongTien"));
                pn.setGhiChu(rs.getString("GhiChu"));
                arr.add(pn);   
            }
            pstate.close(); conn.close();           
        } catch (SQLException ex) {
            Logger.getLogger(CPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
}
//        
////    public static List<PhieuNhap> CapnhatThanhTien(String sthanhtien,String sSua){
////        List<PhieuNhap> arr = new ArrayList<>();
////         conn = null;
////         pstate = null;
////        
////        try {
////            conn = DriverManager.getConnection(dbURL);
////            sql = "update PhieuNhap set DaThanhToan ='" + sthanhtien + "' where id='"+ sSua +"'";
////            pstate = conn.prepareStatement(sql);
////            rs = pstate.executeQuery();
////            while (rs.next())
////            {
////                PhieuNhap pn = new PhieuNhap();
//                pn.setIdPX(rs.getInt("idPX")); 
//                pn.setMaKH(rs.getString("MaKH"));               
//                pn.setMaNV(rs.getString("MaNV"));
//                pn.setNgayBan(rs.getString("NgayBan"));
//                pn.setTongtien(rs.getInt("TongTien"));
////                arr.add(pn);   
////            }
////            pstate.close(); conn.close();           
////        } catch (SQLException ex) {
////            Logger.getLogger(CPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
////        }
////        return arr;
////    }

