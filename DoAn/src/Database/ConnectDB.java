/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;


import View.displayvalueModel;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


/**
 *
 * @author Windows 10 Version 2
 */
public class ConnectDB {
    Connection conn;
    public static String dbURL;
//            = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyCuaHangTraSua;username=sa;password=1704;";
    
    public ConnectDB(){   
    Properties p = new Properties();
        try {
            FileReader fin = new FileReader(new File("connection.properties"));
            p.load(fin);
            String host = p.getProperty("ServerID");
            String port = p.getProperty("Port");
            String dbname = p.getProperty("Database");
            String user = p.getProperty("Username");
            String pw = p.getProperty("Password");
            dbURL = "jdbc:sqlserver://" + host + ":" + port + ";databaseName=" + dbname+";username="+user+";password="+pw+";";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL);
            
            if(conn != null){
                System.out.println("Kết nối CSDL SQL Server thành công!");
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Lỗi 102:: Cấu hình bị trống");
        } catch (Exception e) {
        }
    }
    
    //Thực thi câu lệnh SELECT
    public ResultSet ExcuteQueryGetTable(String cauTruyVanSQL){
        try {
            Statement stmt = conn.createStatement();           
            ResultSet rs = stmt.executeQuery(cauTruyVanSQL);
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
            
        return null;
    }
    //Thực thi INSERT, DELETE, UPDATE
    public void ExcuteQueryUpdateDB(String cauTruyVanSQL){
       
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(cauTruyVanSQL);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
	public Vector<String> selectSearch(String table, String col, String key) {
		ResultSet rs = null;
		Vector<String> vector = new Vector<String>(100);
		String sqlcommand = "select * from ";
		PreparedStatement pst = null;

		sqlcommand = "select * from " + table + " where " + col + " like N'" + key + "%'" + " ;";
		System.out.println(sqlcommand);

		try {
			pst = conn.prepareStatement(sqlcommand);
			rs = pst.executeQuery();
			String str = new String();
			switch (table) {
				case "SanPham":
					while (rs.next()) {

						vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t"
								+ rs.getString(5));
					}
				case "NhanVien":
					while (rs.next()) {

						vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + CalendarAdapter.SQLDateToString(rs.getDate(3)) + "\t" + rs.getString(4)
								+ "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7) + "\t" + rs.getString(8));
					}
				case "KhachHang":
					while (rs.next()) {

						vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t"
								+ rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7)+ "\t" + rs.getString(8));
					}
				case "HoaDon":
					while (rs.next()) {

						vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t"
								+ rs.getString(5) + "\t" + rs.getString(6));
					}
			}
		} catch (SQLException ex) {
			System.out.println("Select error !" + ex.toString());
		}

		return vector;
	}    
        public static DefaultComboBoxModel LayDuLieucbb(String bang, String Ten, String Ma) {
        String cautruyvan = "select *from " + bang;
        ConnectDB conn = new ConnectDB();
        ResultSet rs = conn.ExcuteQueryGetTable(cautruyvan);
        DefaultComboBoxModel cbbmodel = new DefaultComboBoxModel();
        try {
            while (rs.next()) {
                displayvalueModel valueModel = new displayvalueModel(rs.getString(Ten), rs.getString(Ma));
                cbbmodel.addElement(valueModel);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return cbbmodel;
    }
}