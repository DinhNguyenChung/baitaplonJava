package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Interface.InChiTietHoaDon;
import Interface.InHoaDon;
import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Tour;

public class ChiTietHoaDon_DAO implements InChiTietHoaDon{
	
		

		public ArrayList<ChiTietHoaDon> getAllCTHoaDon(){
			ArrayList<ChiTietHoaDon> dscthd = new ArrayList<ChiTietHoaDon>();
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				String sql = "SELECT * FROM ChiTietHoaDon";
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				while(rs.next()) {
					String ma = rs.getString("maCTHD");
					HoaDon maHD = new HoaDon(rs.getString("maHD"));
					Tour maTour = new Tour(rs.getString("maTour"));
					int soLuongKhach = rs.getInt("soLuongKhach");
					double donGia = rs.getDouble("donGia");
					double thanhTien = rs.getDouble("thanhTien");
					
					ChiTietHoaDon cthd = new ChiTietHoaDon(ma, maHD, maTour, soLuongKhach, donGia, thanhTien);
					dscthd.add(cthd);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return dscthd;
		}
		public ArrayList<ChiTietHoaDon> getCTHoaDonTheoMaCTHD(String maCTHD){
			ArrayList<ChiTietHoaDon> dscthd = new ArrayList<ChiTietHoaDon>();
			ConnectDB.getInstance();
			Connection con =  ConnectDB.getConnection();
			PreparedStatement stmt = null;
			try {
				String sql = "SELECT * FROM ChiTietHoaDon WHERE maCTHD = ?";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, maCTHD);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					String ma = rs.getString("maCTHD");
					HoaDon maHD = new HoaDon(rs.getString("maHD"));
					Tour maTour = new Tour(rs.getString("maTour"));
					int soLuongKhach = rs.getInt("soLuongKhach");
					double donGia = rs.getDouble("donGia");
					double thanhTien = rs.getDouble("thanhTien");
					
					ChiTietHoaDon cthd = new ChiTietHoaDon(ma, maHD, maTour, soLuongKhach, donGia, thanhTien);
					dscthd.add(cthd);
				}
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return dscthd;
		}
		
		public ArrayList<ChiTietHoaDon> getCTHoaDonTheoMaHD(String mahd){
			ArrayList<ChiTietHoaDon> dscthd = new ArrayList<ChiTietHoaDon>();
			ConnectDB.getInstance();
			Connection con =  ConnectDB.getConnection();
			PreparedStatement stmt = null;
			try {
				String sql = "SELECT * FROM ChiTietHoaDon WHERE maHD = ?";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, mahd);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					String ma = rs.getString("maCTHD");
					HoaDon maHD = new HoaDon(rs.getString("maHD"));
					Tour maTour = new Tour(rs.getString("maTour"));
					int soLuongKhach = rs.getInt("soLuongKhach");
					double donGia = rs.getDouble("donGia");
					double thanhTien = rs.getDouble("thanhTien");
					
					ChiTietHoaDon cthd = new ChiTietHoaDon(ma, maHD, maTour, soLuongKhach, donGia, thanhTien);
					dscthd.add(cthd);
				}
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return dscthd;
		}
		
		
		public boolean create(ChiTietHoaDon cthd) {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				stmt = con.prepareStatement("INSERT INTO ChiTietHoaDon values(?, ?, ?, ?, ?, ?)");
				stmt.setString(1, cthd.getMaCTHD());
				stmt.setString(2, cthd.getMaHD().getMaHD());
				stmt.setString(3, cthd.getMaTour().getMaTour());
				stmt.setInt(4, cthd.getSoLuongKhach());
				stmt.setDouble(5, cthd.getDonGia());
				stmt.setDouble(6, cthd.getThanhTien());
				
				n = stmt.executeUpdate();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				try {
					stmt.close();
				}catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			return n > 0;
		}

		public int SLTourDaDat(String maTour) {
			
			int sl = 0;
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				String sql = "SELECT SUM(soLuongKhach) FROM ChiTietHoaDon WHERE maTour = ?";
				PreparedStatement sta = con.prepareStatement(sql);
				sta.setString(1, maTour);
//				Statement statement = con.createStatement();
				ResultSet rs = sta.executeQuery();
				
				while(rs.next()) {
					sl = rs.getInt("");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
		return sl;
	}
		@Override
		public boolean delete(ChiTietHoaDon cthd) {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement statement = null;
			int n=0;
			try {

				statement= con.prepareStatement("delete from ChiTietHoaDon where maHD=?");
				statement.setString(1,cthd.getMaHD().getMaHD());
				n = statement.executeUpdate();

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			finally {
				try {
					statement.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
			return n>0;
		}

	
}
