package cre;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectDB.ConnectDB;

public class NhanVien_CRE {
	public String getfivemacuoiNV(){
		String macuoiNV = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select top 1 right(maNV,3) from NhanVien order by maNV desc ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				macuoiNV = rs.getString("");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return macuoiNV;
	}
}
