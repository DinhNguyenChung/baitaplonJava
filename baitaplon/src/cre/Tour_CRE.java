package cre;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectDB.ConnectDB;


public class Tour_CRE {
	public String getfivemacuoiTour(){
		String macuoiTour = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select top 1 right(maTour,3) from Tour order by maTour desc ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				macuoiTour = rs.getString("");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return macuoiTour;
	}
}
