package entity;

import java.util.Date;

import java.util.Objects;
import java.sql.*;

public class NhanVien {

	private String maNV, tenNV;
	private Date ngaySinh;
	private String diaChi, sdt, email, cmnd;
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(java.sql.Date ngaySinh) {
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
	public NhanVien(String maNV, String tenNV, java.sql.Date ngaySinh, String diaChi, String sdt, String email, String cmnd) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.ngaySinh = (java.sql.Date)ngaySinh;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.email = email;
		this.cmnd = cmnd;
	}
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhanVien(String maNV) {
		this.maNV = maNV;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cmnd, diaChi, email, maNV, ngaySinh, sdt, tenNV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(cmnd, other.cmnd) && Objects.equals(diaChi, other.diaChi)
				&& Objects.equals(email, other.email) && Objects.equals(maNV, other.maNV)
				&& Objects.equals(ngaySinh, other.ngaySinh) && Objects.equals(sdt, other.sdt)
				&& Objects.equals(tenNV, other.tenNV);
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi
				+ ", sdt=" + sdt + ", email=" + email + ", cmnd=" + cmnd + "]";
	}

	
}
