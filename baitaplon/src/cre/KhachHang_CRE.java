package cre;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectDB.ConnectDB;


public class KhachHang_CRE {
	public String getfivemacuoiKH(){
		String macuoiKH = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select top 1 right(maKH,3) from KhachHang order by maKH desc ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				macuoiKH = rs.getString("");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return macuoiKH;
	}
}
