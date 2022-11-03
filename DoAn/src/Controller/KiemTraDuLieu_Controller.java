/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
import static Database.ConnectDB.dbURL;

public class KiemTraDuLieu_Controller {
    public static String sql;
    public static Connection conn;
    public static Statement state;
    public static ResultSet rs;
    public static PreparedStatement pstate;
    
    public static boolean KiemTraTrungMa(String TenBang, String TenTruong ,String manhap, boolean ktThem, String macu){
        boolean kq=false;
        conn= null;
        pstate=null;
        
        try {
            conn=DriverManager.getConnection(dbURL);
            if(ktThem==true) {
                sql="Select " + TenTruong+" From " + TenBang +" Where "+ TenTruong+" ='"+ manhap+"'";
            } else {
                sql="Select " + TenTruong+" From " + TenBang +" Where "+ TenTruong+" ='"+ manhap+"' and "+ TenTruong +"<>'"+macu+"'";
            }
            state=conn.createStatement();
            rs= state.executeQuery(sql);
            if(rs.next()) {
                kq=true;
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(KiemTraDuLieu_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(state!=null){
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KiemTraDuLieu_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KiemTraDuLieu_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }   
        
        return kq;
        
    }        
}
