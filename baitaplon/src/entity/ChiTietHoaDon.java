package entity;

import java.util.Objects;

public class ChiTietHoaDon {
	private String maCTHD;
	private HoaDon maHD;
	private Tour maTour;
	private int soLuongKhach;
	private double donGia;
	private double thanhTien;
	
	
	public ChiTietHoaDon(String maCTHD) {
		super();
		this.maCTHD = maCTHD;
	}
	public ChiTietHoaDon(String maCTHD, HoaDon maHD, Tour maTour, int soLuongKhach, double donGia, double thanhTien) {
		super();
		this.maCTHD = maCTHD;
		this.maHD = maHD;
		this.maTour = maTour;
		this.soLuongKhach = soLuongKhach;
		this.donGia = donGia;
		this.thanhTien = thanhTien;
	}
	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaCTHD() {
		return maCTHD;
	}
	public void setMaCTHD(String maCTHD) {
		this.maCTHD = maCTHD;
	}
	public HoaDon getMaHD() {
		return maHD;
	}
	public void setMaHD(HoaDon maHD) {
		this.maHD = maHD;
	}
	public Tour getMaTour() {
		return maTour;
	}
	public void setMaTour(Tour maTour) {
		this.maTour = maTour;
	}
	public int getSoLuongKhach() {
		return soLuongKhach;
	}
	public void setSoLuongKhach(int soLuongKhach) {
		this.soLuongKhach = soLuongKhach;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maCTHD);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHoaDon other = (ChiTietHoaDon) obj;
		return Objects.equals(maCTHD, other.maCTHD);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return maCTHD + ";" + maHD.getMaHD() + ";" + maTour.getMaTour() + ";" + soLuongKhach + ";" + donGia + ";" + thanhTien;
	}
	
	
}
