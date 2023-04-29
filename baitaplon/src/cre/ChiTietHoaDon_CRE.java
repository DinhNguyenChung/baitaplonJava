package cre;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectDB.ConnectDB;

public class ChiTietHoaDon_CRE {
		public String getfivemacuoiCTHD(){
			String macuoiCTHD = null;
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				String sql = "Select top 1 right(maCTHD,3) from ChiTietHoaDon order by maCTHD desc ";
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				while(rs.next()) {
					macuoiCTHD = rs.getString("");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return macuoiCTHD;
		}
}
