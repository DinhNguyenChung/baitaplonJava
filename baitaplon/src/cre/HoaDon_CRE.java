package cre;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectDB.ConnectDB;

public class HoaDon_CRE {
	public String getfivemacuoiHD(){
		String macuoiHD = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select top 1 right(maHD,3) from HoaDon order by maHD desc ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				macuoiHD = rs.getString("");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return macuoiHD;
	}
}
