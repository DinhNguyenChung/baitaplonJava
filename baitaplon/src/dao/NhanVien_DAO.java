package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import Interface.InNhanVien;
import connectDB.ConnectDB;
import entity.KhachHang;
import entity.NhanVien;

public class NhanVien_DAO implements InNhanVien{
	
	public NhanVien_DAO() {}
	
	public ArrayList<NhanVien> getallNhanVien(){
		ArrayList<NhanVien> danhSachNhanVien = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT * FROM NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNV = rs.getString("maNV");
				String tenNV = rs.getString("tenNV");
				java.sql.Date ngaySinh = rs.getDate("ngaySinh");
				String diaChi = rs.getString("diaChi");
				String sdt = rs.getString("sdt");
				String email = rs.getString("email");
				String cmnd = rs.getString("cmnd");
				NhanVien nv = new NhanVien(maNV, tenNV, ngaySinh, diaChi, sdt, email, cmnd);
				danhSachNhanVien.add(nv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachNhanVien;
	}
	
	public ArrayList<NhanVien> getNhanVienTheoMaNV(String id){
		ArrayList<NhanVien> danhSachNhanVien = new ArrayList<NhanVien>();
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM NhanVien where maNV = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				String maNV = rs.getString("maNV");
				String tenNV = rs.getString("tenNV");
				java.sql.Date ngsinh = rs.getDate("ngaySinh");
				String diachi = rs.getString("diaChi");
				String sdt = rs.getString("sdt");
				String email = rs.getString("email");
				String cmnd = rs.getString("cmnd");
				NhanVien nv = new NhanVien(maNV, tenNV, ngsinh, diachi, sdt, email, cmnd);
				danhSachNhanVien.add(nv);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			
		}
		finally {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return danhSachNhanVien;
	}
	
	public boolean create(NhanVien nv) {
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {

			statement= con.prepareStatement("insert into NhanVien values(?,?,?,?,?,?,?)");
			statement.setString(1, nv.getMaNV());
			statement.setString(2,nv.getTenNV());
			statement.setDate(3, (java.sql.Date) nv.getNgaySinh());
			statement.setString(4, nv.getDiaChi());
			statement.setString(5,nv.getSdt());
			statement.setString(6,nv.getEmail());
			statement.setString(7,nv.getCmnd());
			n = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();			
		}
		finally {
			try {
				statement.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}return n>0;
	}
	
	public boolean update(NhanVien nv) {
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n=0;
		try {

			statement= con.prepareStatement("update NhanVien set tenNV =? , ngaySinh=?,diaChi=?,sdt=?,email=?,cmnd=?"
					+ "						where maNV=?");
			statement.setString(1,nv.getTenNV());
			statement.setDate(2, (java.sql.Date) nv.getNgaySinh());
			statement.setString(3, nv.getDiaChi());
			statement.setString(4,nv.getSdt());
			statement.setString(5,nv.getEmail());
			statement.setString(6,nv.getCmnd());
			statement.setString(7,nv.getMaNV());
			
			n = statement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}return n>0;
	}
	
	public boolean delete(NhanVien nv) {
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n=0;
		try {
	
			statement= con.prepareStatement("delete from NhanVien where maNV=?");
			
			statement.setString(1,nv.getMaNV());
			
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
		}return n>0;
	}
	
	public ArrayList<NhanVien> getkhachhangTheoMaTour(String id){
	ArrayList<NhanVien> danhSachNV = new ArrayList<NhanVien>();
	
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	PreparedStatement statement = null;
	try {
		String sql = "SELECT * FROM NhanVien where maNV = ?";
		statement= con.prepareStatement(sql);
		statement.setString(1, id);
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			String maNV = rs.getString("maNV");
			String tenNV = rs.getString("tenNV");
			java.sql.Date ngsinh = rs.getDate("ngaySinh");
			String diachi = rs.getString("diaChi");
			String sdt = rs.getString("sdt");
			String email = rs.getString("email");
			String cmnd = rs.getString("cmnd");
			NhanVien nv = new NhanVien(maNV, tenNV, ngsinh, diachi, sdt, email, cmnd);
			danhSachNV.add(nv);
		}
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
	}return danhSachNV;
}
}
