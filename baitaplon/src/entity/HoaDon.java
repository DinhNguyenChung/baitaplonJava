package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class HoaDon implements Serializable {
	private String maHD;
	private Date ngayLap;
	private KhachHang khachHang;
	private NhanVien nhanVien;
	private double tongTien;

	
	
	public HoaDon(String maHD) {
		super();
		this.maHD = maHD;
	}



	public HoaDon(String maHD, Date ngayLap, KhachHang khachHang, NhanVien nhanVien, double tongTien) {
		super();
		this.maHD = maHD;
		this.ngayLap = ngayLap;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.tongTien = tongTien;
	}



	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getMaHD() {
		return maHD;
	}



	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}



	public Date getNgayLap() {
		return ngayLap;
	}



	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}



	public KhachHang getKhachHang() {
		return khachHang;
	}



	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}



	public NhanVien getNhanVien() {
		return nhanVien;
	}



	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}



	public double getTongTien() {
		return tongTien;
	}



	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}



	@Override
	public int hashCode() {
		return Objects.hash(maHD);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHD, other.maHD);
	}



//	@Override
//	public String toString() {
//		return maHD + ";" + ngayLap + ";" + khachHang.getMaKh() + ";" + nhanVien.getMaNV() + ";" + tongTien;
//				
//	}
	
	
}
