package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.Tour;
import entity.KhachHang;
import entity.NhanVien;

public class Hoadon_DAO {
	public Hoadon_DAO() {
		
	}

	public ArrayList<HoaDon> getAllHoaDon(){
		ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT * FROM HoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString("maHD");
				Date ngayLap = rs.getDate("ngayLap");
				KhachHang kh = new KhachHang(rs.getString("maKH"));
				NhanVien nv = new NhanVien(rs.getString("maNV"));
				double tongTien = rs.getDouble("tongTien");
				
				HoaDon hd = new HoaDon(ma, ngayLap, kh, nv, tongTien);
				dshd.add(hd);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dshd;
	}
	public ArrayList<HoaDon> getHoaDonTheoMaHD(String maHD){
		ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
		ConnectDB.getInstance();
		Connection con =  ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "SELECT * FROM HoaDon WHERE maHD = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maHD);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String ma = rs.getString("maHD");
				Date ngayLap = rs.getDate("ngayLap");
				KhachHang kh = new KhachHang(rs.getString("maKH"));
				NhanVien nv = new NhanVien(rs.getString("maNV"));
				double tongTien = rs.getDouble("tongTien");
				
				HoaDon hd = new HoaDon(ma, ngayLap, kh, nv, tongTien);
				dshd.add(hd);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dshd;
	}
	public boolean create(HoaDon hd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("INSERT INTO HoaDon values(?, ?, ?, ?, ?)");
			stmt.setString(1, hd.getMaHD());
			stmt.setDate(2, hd.getNgayLap());
			stmt.setString(3, hd.getKhachHang().getMaKH());
			stmt.setString(4, hd.getNhanVien().getMaNV());
			stmt.setDouble(5, hd.getTongTien());
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
	
	public ArrayList<HoaDon> getHoaDonTheoNgayLap(Date ngayLap) {
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
				
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				PreparedStatement stmt = null;
				try {
					
					String sql = "Select * from HoaDon where ngayLap = ? ";
					stmt = con.prepareStatement(sql);
					stmt.setDate(1, ngayLap);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()) {
						String ma = rs.getString("maHD");
						Date ngayLap1 = rs.getDate("ngayLap");
						KhachHang kh = new KhachHang(rs.getString("maKH"));
						NhanVien nv = new NhanVien(rs.getString("maNV"));
						double tongTien = rs.getDouble("tongTien");
						
						HoaDon hd = new HoaDon(ma, ngayLap1, kh, nv, tongTien);
						dsHD.add(hd);
					}
				}
				catch (Exception e){
					e.printStackTrace();
				}
				finally {
					try {
						stmt.close();
					}
					catch (Exception e){
						e.printStackTrace();
					}
				}
				return dsHD;
	}
	
	public boolean delete(HoaDon hd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n=0;
		try {
			
			String sqlDeleteChiTietHoaDon = "DELETE FROM ChiTietHoaDon WHERE maHD = ?";
			statement = con.prepareStatement(sqlDeleteChiTietHoaDon);
			statement.setString(1, hd.getMaHD());
			statement.executeUpdate();

			statement= con.prepareStatement("delete from HoaDon where maHD = ?");
			statement.setString(1,hd.getMaHD());
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

