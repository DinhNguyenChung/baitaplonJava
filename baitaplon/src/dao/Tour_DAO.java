package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Interface.InTour;
import connectDB.ConnectDB;
import entity.Tour;

public class Tour_DAO implements InTour{
	public Tour_DAO() {
		
	}
	public ArrayList<Tour> getalltbTour(){
		ArrayList<Tour> dsTour = new ArrayList<Tour>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "Select * from Tour";
			if(con !=null) {
			Statement statement = con.createStatement();
			
			ResultSet rs= statement.executeQuery(sql);
			while(rs.next()) {
				String maTour = rs.getString("maTour");
				String tenTour= rs.getString("tenTour");
				String ddden = rs.getString("diaDiemDen");
				Date ngaykh = rs.getDate("ngayKhoiHanh");
				Date ngaykt = rs.getDate("ngayKetThuc");
				double gia = rs.getDouble("giaTour");
				int sl = rs.getInt("soLuongKhach");
				Tour tour = new Tour(maTour,tenTour,ddden,ngaykh,ngaykt,gia,sl);
				dsTour.add(tour);
			}
			}
			else System.out.println("con ở tour_dao is null");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsTour;
	}
	public ArrayList<Tour> getTourTheoMaTour(String maTourID) {
		ArrayList<Tour> dsTour = new ArrayList<Tour>();
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			
			String sql = "Select * from Tour where maTour = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maTourID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				String diaDiem = rs.getString(3);
				Date ngayKH = rs.getDate(4);
				Date ngayKT = rs.getDate(5);
				Double giaTien = rs.getDouble(6);
				int soLuong = rs.getInt(7);
				Tour tour = new Tour(maTour, tenTour, diaDiem, ngayKH, ngayKT, giaTien, soLuong);
				dsTour.add(tour);

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
		return dsTour;
	}
	
	public boolean create(Tour tour) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into Tour values(?,?,?,?,?,?,?)");
			stmt.setString(1, tour.getMaTour());
			stmt.setString(2, tour.getTenTour());
			stmt.setString(3, tour.getDiadiemden());
			stmt.setDate(4, tour.getNgaykhoihanh());
			stmt.setDate(5, tour.getNgaykethuc());
			stmt.setDouble(6, tour.getGiatien());
			stmt.setInt(7, tour.getSoluong());
			n = stmt.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n>0;
	}
	
	public boolean delete(Tour tour) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from Tour where maTour = ?");
			stmt.setString(1, tour.getMaTour());
			n = stmt.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n>0;
	}
	
	public boolean update(Tour tour) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update Tour set  tenTour = ?, diaDiemDen = ?, ngayKhoiHanh = ?, ngayKetThuc = ?, giaTour = ?, soLuongKhach = ? where maTour =?");
			
			stmt.setString(1, tour.getTenTour());
			stmt.setString(2, tour.getDiadiemden());
			stmt.setDate(3, tour.getNgaykhoihanh());
			stmt.setDate(4, tour.getNgaykethuc());
			stmt.setDouble(5, tour.getGiatien());
			stmt.setInt(6, tour.getSoluong());
			stmt.setString(7, tour.getMaTour());
			n = stmt.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n>0;
	}
	@Override
	public ArrayList<Tour> getTourTheoTimTenvsDiaDiem(String maTourID, String dd) {
ArrayList<Tour> dsTour = new ArrayList<Tour>();
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			
			String sql = "Select * from Tour where tenTour = ? AND diaDiemDen = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maTourID);
			stmt.setString(2, dd);
//			stmt.setDouble(3, gia);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				String diaDiem = rs.getString(3);
				Date ngayKH = rs.getDate(4);
				Date ngayKT = rs.getDate(5);
				Double giaTien = rs.getDouble(6);
				int soLuong = rs.getInt(7);
				Tour tour = new Tour(maTour, tenTour, diaDiem, ngayKH, ngayKT, giaTien, soLuong);
				dsTour.add(tour);

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
		return dsTour;
	}
	@Override
	public ArrayList<Tour> getTourTheoTimTen(String Ten) {
ArrayList<Tour> dsTour = new ArrayList<Tour>();
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			
			String sql = "Select * from Tour where tenTour = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, Ten);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				String diaDiem = rs.getString(3);
				Date ngayKH = rs.getDate(4);
				Date ngayKT = rs.getDate(5);
				Double giaTien = rs.getDouble(6);
				int soLuong = rs.getInt(7);
				Tour tour = new Tour(maTour, tenTour, diaDiem, ngayKH, ngayKT, giaTien, soLuong);
				dsTour.add(tour);

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
		return dsTour;
	}
	@Override
	public ArrayList<Tour> getTourTheoDiaDiem(String dd) {
		ArrayList<Tour> dsTour = new ArrayList<Tour>();
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			
			String sql = "Select * from Tour where diaDiemDen = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, dd);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				String diaDiem = rs.getString(3);
				Date ngayKH = rs.getDate(4);
				Date ngayKT = rs.getDate(5);
				Double giaTien = rs.getDouble(6);
				int soLuong = rs.getInt(7);
				Tour tour = new Tour(maTour, tenTour, diaDiem, ngayKH, ngayKT, giaTien, soLuong);
				dsTour.add(tour);

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
		return dsTour;
	}
	@Override
	public ArrayList<Tour> getTourTheoGia(double giamin,double giamax) {
ArrayList<Tour> dsTour = new ArrayList<Tour>();
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			
			String sql = "Select * from Tour where giaTour >= ? AND giaTour <=?  ";
			stmt = con.prepareStatement(sql);
			stmt.setDouble(1, giamin);
			stmt.setDouble(2, giamax);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				String diaDiem = rs.getString(3);
				Date ngayKH = rs.getDate(4);
				Date ngayKT = rs.getDate(5);
				Double giaTien = rs.getDouble(6);
				int soLuong = rs.getInt(7);
				Tour tour = new Tour(maTour, tenTour, diaDiem, ngayKH, ngayKT, giaTien, soLuong);
				dsTour.add(tour);

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
		return dsTour;
	}
	@Override
	public ArrayList<Tour> getTourTheoNgayKH(Date ngayKh) {
ArrayList<Tour> dsTour = new ArrayList<Tour>();
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			
			String sql = "Select * from Tour where ngayKhoiHanh >= ? ";
			stmt = con.prepareStatement(sql);
			stmt.setDate(1, ngayKh);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				String diaDiem = rs.getString(3);
				Date ngayKH = rs.getDate(4);
				Date ngayKT = rs.getDate(5);
				Double giaTien = rs.getDouble(6);
				int soLuong = rs.getInt(7);
				Tour tour = new Tour(maTour, tenTour, diaDiem, ngayKH, ngayKT, giaTien, soLuong);
				dsTour.add(tour);

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
		return dsTour;
	}
	@Override
	public ArrayList<Tour> getTourTheoTimTenvsGia(String Ten, double giamin,double giamax) {
		ArrayList<Tour> dsTour = new ArrayList<Tour>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			
			String sql = "Select * from Tour where tenTour = ? AND  giaTour >= ? AND giaTour <=?  ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1,Ten );
			stmt.setDouble(2, giamin);
			stmt.setDouble(3, giamax);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				String diaDiem = rs.getString(3);
				Date ngayKH = rs.getDate(4);
				Date ngayKT = rs.getDate(5);
				Double giaTien = rs.getDouble(6);
				int soLuong = rs.getInt(7);
				Tour tour = new Tour(maTour, tenTour, diaDiem, ngayKH, ngayKT, giaTien, soLuong);
				dsTour.add(tour);

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
		return dsTour;
	}
	@Override
	public ArrayList<Tour> getTourTheoTimTenvsNgayKH(String Ten, Date NgayKH) {
		ArrayList<Tour> dsTour = new ArrayList<Tour>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			
			String sql = "Select * from Tour where tenTour = ? AND  ngayKhoiHanh >= ?  ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, Ten);
			stmt.setDate(2, NgayKH);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				String diaDiem = rs.getString(3);
				Date ngayKH = rs.getDate(4);
				Date ngayKT = rs.getDate(5);
				Double giaTien = rs.getDouble(6);
				int soLuong = rs.getInt(7);
				Tour tour = new Tour(maTour, tenTour, diaDiem, ngayKH, ngayKT, giaTien, soLuong);
				dsTour.add(tour);

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
		return dsTour;
	
	}
	@Override
	public ArrayList<Tour> getTourTheoTimDiaDiemvsGia(String dd, double giamin,double giamax) {
		ArrayList<Tour> dsTour = new ArrayList<Tour>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			
			String sql = "Select * from Tour where diaDiemDen = ? AND  giaTour >= ? AND giaTour <=?  ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1,dd );
			stmt.setDouble(2, giamin);
			stmt.setDouble(3, giamax);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				String diaDiem = rs.getString(3);
				Date ngayKH = rs.getDate(4);
				Date ngayKT = rs.getDate(5);
				Double giaTien = rs.getDouble(6);
				int soLuong = rs.getInt(7);
				Tour tour = new Tour(maTour, tenTour, diaDiem, ngayKH, ngayKT, giaTien, soLuong);
				dsTour.add(tour);

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
		return dsTour;
	}
	@Override
	public ArrayList<Tour> getTourTheoTimDiaDiemvsNgayKH(String dd, Date NgayKH) {
		ArrayList<Tour> dsTour = new ArrayList<Tour>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			
			String sql = "Select * from Tour where diaDiemDen = ? AND  ngayKhoiHanh >= ?  ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, dd);
			stmt.setDate(2, NgayKH);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				String diaDiem = rs.getString(3);
				Date ngayKH = rs.getDate(4);
				Date ngayKT = rs.getDate(5);
				Double giaTien = rs.getDouble(6);
				int soLuong = rs.getInt(7);
				Tour tour = new Tour(maTour, tenTour, diaDiem, ngayKH, ngayKT, giaTien, soLuong);
				dsTour.add(tour);

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
		return dsTour;
	}
	@Override
	public ArrayList<Tour> getTourTheoTimGiavsNgayKH(double giamin,double giamax, Date NgayKH) {
		ArrayList<Tour> dsTour = new ArrayList<Tour>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			
			String sql = "Select * from Tour where giaTour >= ? AND giaTour <=? AND  ngayKhoiHanh >= ?  ";
			stmt = con.prepareStatement(sql);
			stmt.setDouble(1,giamin );
			stmt.setDouble(2, giamax);
			stmt.setDate(3, NgayKH);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				String diaDiem = rs.getString(3);
				Date ngayKH = rs.getDate(4);
				Date ngayKT = rs.getDate(5);
				Double giaTien = rs.getDouble(6);
				int soLuong = rs.getInt(7);
				Tour tour = new Tour(maTour, tenTour, diaDiem, ngayKH, ngayKT, giaTien, soLuong);
				dsTour.add(tour);

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
		return dsTour;
	}
	@Override
	public ArrayList<Tour> getTourTheoTimTenvsDiaDiemvsGia(String ten, String dd, double giamin, double giamax) {
		ArrayList<Tour> dsTour = new ArrayList<Tour>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			
			String sql = "Select * from Tour where giaTour >= ? AND giaTour <=? AND diaDiemDen = ? AND tenTour =?";
			stmt = con.prepareStatement(sql);
			stmt.setDouble(1,giamin );
			stmt.setDouble(2, giamax);
			stmt.setString(3, dd);
			stmt.setString(4, ten);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				String diaDiem = rs.getString(3);
				Date ngayKH = rs.getDate(4);
				Date ngayKT = rs.getDate(5);
				Double giaTien = rs.getDouble(6);
				int soLuong = rs.getInt(7);
				Tour tour = new Tour(maTour, tenTour, diaDiem, ngayKH, ngayKT, giaTien, soLuong);
				dsTour.add(tour);

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
		return dsTour;
	}
	@Override
	public ArrayList<Tour> getTourTheoTimTenvsDiaDiemvsNgayKH(String ten, String dd, Date NgayKH) {
		ArrayList<Tour> dsTour = new ArrayList<Tour>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			
			String sql = "Select * from Tour where ngayKhoiHanh >= ?  AND diaDiemDen = ? AND tenTour =?";
			stmt = con.prepareStatement(sql);
			stmt.setDate(1, NgayKH);
			stmt.setString(2, dd);
			stmt.setString(3, ten);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				String diaDiem = rs.getString(3);
				Date ngayKH = rs.getDate(4);
				Date ngayKT = rs.getDate(5);
				Double giaTien = rs.getDouble(6);
				int soLuong = rs.getInt(7);
				Tour tour = new Tour(maTour, tenTour, diaDiem, ngayKH, ngayKT, giaTien, soLuong);
				dsTour.add(tour);

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
		return dsTour;
	}
	@Override
	public ArrayList<Tour> getTourTheoTimTenvsGiavsNgayKH(String ten, double giamin, double giamax, Date NgayKH) {
		ArrayList<Tour> dsTour = new ArrayList<Tour>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			
			String sql = "Select * from Tour where ngayKhoiHanh >= ?  AND giaTour >= ? AND giaTour <=? AND tenTour =?";
			stmt = con.prepareStatement(sql);
			stmt.setDate(1, NgayKH);
			stmt.setDouble(2, giamin);
			stmt.setDouble(3, giamax);
			stmt.setString(4,ten);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				String diaDiem = rs.getString(3);
				Date ngayKH = rs.getDate(4);
				Date ngayKT = rs.getDate(5);
				Double giaTien = rs.getDouble(6);
				int soLuong = rs.getInt(7);
				Tour tour = new Tour(maTour, tenTour, diaDiem, ngayKH, ngayKT, giaTien, soLuong);
				dsTour.add(tour);

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
		return dsTour;
	}
	@Override
	public ArrayList<Tour> getTourTheoTimDiaDiemvsGiavsNgayKH(String dd, double giamin, double giamax, Date NgayKH) {
		ArrayList<Tour> dsTour = new ArrayList<Tour>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			
			String sql = "Select * from Tour where ngayKhoiHanh >= ?  AND giaTour >= ? AND giaTour <=? AND diaDiemDen =?";
			stmt = con.prepareStatement(sql);
			stmt.setDate(1, NgayKH);
			stmt.setDouble(2, giamin);
			stmt.setDouble(3, giamax);
			stmt.setString(4,dd);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				String diaDiem = rs.getString(3);
				Date ngayKH = rs.getDate(4);
				Date ngayKT = rs.getDate(5);
				Double giaTien = rs.getDouble(6);
				int soLuong = rs.getInt(7);
				Tour tour = new Tour(maTour, tenTour, diaDiem, ngayKH, ngayKT, giaTien, soLuong);
				dsTour.add(tour);

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
		return dsTour;
	}
	@Override
	public ArrayList<Tour> getTourTheoTimTheoALL(String ten, String dd, double giamin, double giamax, Date NgayKH) {
		ArrayList<Tour> dsTour = new ArrayList<Tour>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			
			String sql = "Select * from Tour where ngayKhoiHanh >= ?  AND giaTour >= ? AND giaTour <=? AND diaDiemDen =? AND tenTour =?";
			stmt = con.prepareStatement(sql);
			stmt.setDate(1, NgayKH);
			stmt.setDouble(2, giamin);
			stmt.setDouble(3, giamax);
			stmt.setString(4,dd);
			stmt.setString(5,ten);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				String diaDiem = rs.getString(3);
				Date ngayKH = rs.getDate(4);
				Date ngayKT = rs.getDate(5);
				Double giaTien = rs.getDouble(6);
				int soLuong = rs.getInt(7);
				Tour tour = new Tour(maTour, tenTour, diaDiem, ngayKH, ngayKT, giaTien, soLuong);
				dsTour.add(tour);

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
		return dsTour;
	}
}
