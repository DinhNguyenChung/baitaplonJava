package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class KhachHang implements Serializable {
	private String maKH;
	private String tenKH;
	private Date ngaySinh;
	private String diaChi;
	private String sdt;
	private String email;
	private String cmnd;
//	private Tour maTour ;
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public KhachHang(String maKH) {
		super();
		this.maKH = maKH;
	}

	public KhachHang(String maKH, String tenKH, Date ngaySinh, String diaChi, String sdt, String email, String cmnd) {
	super();
	this.maKH = maKH;
	this.tenKH = tenKH;
	this.ngaySinh = ngaySinh;
	this.diaChi = diaChi;
	this.sdt = sdt;
	this.email = email;
	this.cmnd = cmnd;
}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maKH);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(maKH, other.maKH);
	}

	@Override
	public String toString() {
		return  maKH + ";" + tenKH + ";" + ngaySinh + ";" + diaChi + ";"
				+ sdt + ";" + email + ";" + cmnd;
	}
	
	
}
