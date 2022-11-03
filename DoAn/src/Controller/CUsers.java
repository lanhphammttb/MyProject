package Controller;

import Database.ConnectDB;
import Model.Users;
import static Database.ConnectDB.dbURL;
import static View.FrameLogin.ten;
//import static View.FrameLogin.ten;
//import static View.FrameLogin.user;
import java.io.*;
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

public class CUsers{
    public static String username, password;
    private static boolean admin = false;
    public static String sql;
    public static Connection conn;
    public static Statement state;
    public static ResultSet rs;
    public static PreparedStatement pstate;
    //2.them tai khoan

    public static void ThemMoi(Users u) {
        conn = null;
        pstate = null;

        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Insert into Users(MaNhanVien, UserName, PassWord, Quyen, GhiChu) values(?,?,?,?,?)";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, u.getMaNhanVien());
            pstate.setString(2, u.getUserName());
            pstate.setString(3, u.getPassWord());
            pstate.setString(4, u.getQuyen());
            pstate.setString(5, u.getGhiChu());
            pstate.execute();
            pstate.close();conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    //3.cap nhat tai khoan
    public static void CapNhat(Users u, String macu) {
        conn = null;
        pstate = null;

        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Update Users Set MaNhanVien =?, UserName =?, PassWord =?, Quyen =?, GhiChu =? Where ID=?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, u.getMaNhanVien());
            pstate.setString(2, u.getUserName());
            pstate.setString(3, u.getPassWord());
            pstate.setString(4, u.getQuyen());
            pstate.setString(5, u.getGhiChu());
            pstate.setString(6, macu);
            pstate.execute();
            pstate.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
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
            sql = "Delete From Users Where ID =?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, macu);
            pstate.execute();
            pstate.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }        
        public static void checkAdmin(){
         conn = null;
         state = null;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "select * from Users where UserName= '" + username + "' and PassWord= '" + password+ "'";
            state =conn.createStatement();
             rs = state.executeQuery(sql);
            while(rs.next()){
                String quyen = rs.getString("Quyen");
                int x = quyen.length() ;
            if(x==5){
                admin = true;
            }
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(state!=null){
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
	}
	public static boolean isAdmin(){
		return admin;
	}
	
	public static void reset(){
		username = password = "";
		admin = false;
	}   

        public static void DoiMatKhau(String username, String password, String passwordnew) {
        ConnectDB conn = new ConnectDB();   
        int ID;
        String cautruyvan = "select * from Users where UserName= '" + username + "' and PassWord= '" + password + "'";
        System.out.println(cautruyvan);
        ResultSet rs = conn.ExcuteQueryGetTable(cautruyvan);

        try {
            if (rs.next()) {
            ID = rs.getInt("ID");
            String cautruyvan2 = "Update Users set PassWord = '" + passwordnew + "' where ID =" + ID;
            System.out.println(cautruyvan2);
            ResultSet rs2 = conn.ExcuteQueryGetTable(cautruyvan2);               
            }
        } catch (SQLException ex) {
            System.out.println("lỗi đăng nhập");
        }
    }
        public static void DoiQuyen(String id, String quyen) {
        ConnectDB conn = new ConnectDB(); 
        String cautruyvan = "select * from Users where ID = '" + id + "'";
        System.out.println(cautruyvan);
        ResultSet rs = conn.ExcuteQueryGetTable(cautruyvan);

        try {
            if (rs.next()) {
            String cautruyvan2 = "Update Users set Quyen = N'" + quyen + "' where ID =" + id;
            System.out.println(cautruyvan2);
            ResultSet rs2 = conn.ExcuteQueryGetTable(cautruyvan2);               
            }
        } catch (SQLException ex) {
            System.out.println("lỗi");
        }
    }
}
	