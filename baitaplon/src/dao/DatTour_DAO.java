package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectDB.ConnectDB;

public class DatTour_DAO {
	public int SLTourdadat(String maTour) {
		
			int sl = 0;
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				String sql = "Select count(*) from DatTour where maTour ? ";
				PreparedStatement sta = null;
				sta.setString(1, maTour);
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				
				while(rs.next()) {
					sl = rs.getInt("");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
		return sl;
	}
}
