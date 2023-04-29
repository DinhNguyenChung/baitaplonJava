package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Interface.InKhachHang;
import connectDB.ConnectDB;
import entity.Tour;
import entity.KhachHang;

public class KhachHang_DAO implements InKhachHang{
	public KhachHang_DAO() {
		
	}
	public ArrayList<KhachHang> getallkhachhang(){
		ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maKH = rs.getString("maKH");
				String tenKH = rs.getString("tenKH");
				Date ngsinh = rs.getDate("ngaySinh");
				String diachi = rs.getString("diaChi");
				String sdt = rs.getString("sdt");
				String email = rs.getString("email");
				String cmnd = rs.getString("cmnd");
//				Tour Tour = new Tour(rs.getString("maTour"));
				KhachHang kh = new KhachHang(maKH,tenKH,ngsinh,diachi,sdt,email,cmnd);
				dskh.add(kh);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dskh;
	}
	public ArrayList<KhachHang> getkhachhangTheoMaKH(String id){
		ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from KhachHang where makh = ?";
			statement= con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				String maKH = rs.getString("maKH");
				String tenKH = rs.getString("tenKH");
				Date ngsinh = rs.getDate("ngaySinh");
				
				String diachi = rs.getString("diaChi");
				String sdt = rs.getString("sdt");
				String email = rs.getString("email");
				String cmnd = rs.getString("cmnd");
//				Tour Tour = new Tour(rs.getString("maTour"));
				KhachHang kh = new KhachHang(maKH,tenKH,ngsinh,diachi,sdt,email,cmnd);
				dskh.add(kh);
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
		}return dskh;
	}
	
//	public ArrayList<khachhang> getkhachhangTheoMaTour(String id){
//		ArrayList<khachhang> dskh = new ArrayList<khachhang>();
//		
//		ConnectSQL.getInstance();
//		Connection con = ConnectSQL.getConnection();
//		PreparedStatement statement = null;
//		try {
//			String sql = "Select * from KhachHang where maTour = ?";
//			statement= con.prepareStatement(sql);
//			statement.setString(1, id);
//			ResultSet rs = statement.executeQuery();
//			
//			while(rs.next()) {
//				String maKH = rs.getString("maKH");
//				String tenKH = rs.getString("tenKH");
//				Date ngsinh = rs.getDate("ngaySinh");
//				
//				String diachi = rs.getString("diaChi");
//				String sdt = rs.getString("sdt");
//				String email = rs.getString("email");
//				String cmnd = rs.getString("cmnd");
////				Tour Tour = new Tour(rs.getString("maTour"));
//				khachhang kh = new khachhang(maKH,tenKH,ngsinh,diachi,sdt,email,cmnd);
//				dskh.add(kh);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//			
//		}
//		finally {
//			try {
//				statement.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//				e2.printStackTrace();
//			}
//		}return dskh;
//	}
	public boolean create(KhachHang kh) {
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n=0;
		try {

			statement= con.prepareStatement("insert into KhachHang values(?,?,?,?,?,?,?)");
			statement.setString(1, kh.getMaKH());
			statement.setString(2,kh.getTenKH());

			statement.setDate(3, kh.getNgaySinh());
//			statement.setBoolean(4,kh.isPhai());
			statement.setString(4, kh.getDiaChi());
//			statement.setString(5,kh.getPban().getMaPB());
			statement.setString(5,kh.getSdt());
			statement.setString(6,kh.getEmail());
			statement.setString(7,kh.getCmnd() );
//			statement.setString(8, kh.getMaTour().getMaTour());
			
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
public boolean update(KhachHang kh) {
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n=0;
		try {

			statement= con.prepareStatement("update KhachHang set tenKH =? , ngaySinh=?,diaChi=?,sdt=?,email=?,cmnd=? "
					+ "						where maKH=?");
			
			statement.setString(1,kh.getTenKH());

			statement.setDate(2, kh.getNgaySinh());
//			statement.setBoolean(4,kh.isPhai());
			statement.setString(3, kh.getDiaChi());
//			statement.setString(5,kh.getPban().getMaPB());
			statement.setString(4,kh.getSdt());
			statement.setString(5,kh.getEmail());
			statement.setString(6,kh.getCmnd() );
//			statement.setString(7, kh.getMaTour().getMaTour());
			statement.setString(7,kh.getMaKH());
			
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
public boolean delete(KhachHang kh) {
	
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	PreparedStatement statement = null;
	int n=0;
	try {

		statement= con.prepareStatement("delete from KhachHang where maKH=?");
		
		statement.setString(1,kh.getMaKH());
		
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
@Override
public ArrayList<KhachHang> getkhachhangTheoMaTour(String id) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public ArrayList<KhachHang> getkhachhangTheoCCCD(String id) {
	// TODO Auto-generated method stub
	
	ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
	
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	PreparedStatement statement = null;
	try {
		String sql = "Select * from KhachHang where cmnd = ?";
		statement= con.prepareStatement(sql);
		statement.setString(1, id);
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			String maKH = rs.getString("maKH");
			String tenKH = rs.getString("tenKH");
			Date ngsinh = rs.getDate("ngaySinh");
			
			String diachi = rs.getString("diaChi");
			String sdt = rs.getString("sdt");
			String email = rs.getString("email");
			String cmnd = rs.getString("cmnd");
//			Tour Tour = new Tour(rs.getString("maTour"));
			KhachHang kh = new KhachHang(maKH,tenKH,ngsinh,diachi,sdt,email,cmnd);
			dskh.add(kh);
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
	}return dskh;
}
@Override
public ArrayList<KhachHang> getkhachhangTheoSDT(String sdts) {
ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
	
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	PreparedStatement statement = null;
	try {
		String sql = "Select * from KhachHang where sdt = ?";
		statement= con.prepareStatement(sql);
		statement.setString(1, sdts);
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			String maKH = rs.getString("maKH");
			String tenKH = rs.getString("tenKH");
			Date ngsinh = rs.getDate("ngaySinh");
			
			String diachi = rs.getString("diaChi");
			String sdt = rs.getString("sdt");
			String email = rs.getString("email");
			String cmnd = rs.getString("cmnd");
//			Tour Tour = new Tour(rs.getString("maTour"));
			KhachHang kh = new KhachHang(maKH,tenKH,ngsinh,diachi,sdt,email,cmnd);
			dskh.add(kh);
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
	}return dskh;
}


}
