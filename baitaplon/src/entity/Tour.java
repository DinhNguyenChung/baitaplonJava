package entity;

import java.sql.Date;

import java.util.Objects;

public class Tour {
	private String maTour;
	private String tenTour;
	private String diadiemden;
	private Date ngaykhoihanh;
	private Date ngaykethuc;
	private double giatien;
	private int soluong;
	public Tour() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tour(String maTour) {
		this(maTour,"","",null,null,0.0,0);
	}
	public Tour(String maTour, String tenTour, String diadiemden, Date ngaykhoihanh, Date ngaykethuc, double giatien,
			int soluong) {
		super();
		this.maTour = maTour;
		this.tenTour = tenTour;
		this.diadiemden = diadiemden;
		this.ngaykhoihanh = ngaykhoihanh;
		this.ngaykethuc = ngaykethuc;
		this.giatien = giatien;
		this.soluong = soluong;
	}
	public String getMaTour() {
		return maTour;
	}
	public void setMaTour(String maTour) {
		this.maTour = maTour;
	}
	public String getTenTour() {
		return tenTour;
	}
	public void setTenTour(String tenTour) {
		this.tenTour = tenTour;
	}
	public String getDiadiemden() {
		return diadiemden;
	}
	public void setDiadiemden(String diadiemden) {
		this.diadiemden = diadiemden;
	}
	public Date getNgaykhoihanh() {
		return ngaykhoihanh;
	}
	public void setNgaykhoihanh(Date ngaykhoihanh) {
		this.ngaykhoihanh = ngaykhoihanh;
	}
	public Date getNgaykethuc() {
		return ngaykethuc;
	}
	public void setNgaykethuc(Date ngaykethuc) {
		this.ngaykethuc = ngaykethuc;
	}
	public double getGiatien() {
		return giatien;
	}
	public void setGiatien(double giatien) {
		this.giatien = giatien;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maTour);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tour other = (Tour) obj;
		return Objects.equals(maTour, other.maTour);
	}
	@Override
	public String toString() {
		return maTour + ";" + tenTour + ";" + diadiemden + ";"
				+ ngaykhoihanh + ";" + ngaykethuc + ";" + giatien + ";" + soluong ;
	}
	
	
	
}
