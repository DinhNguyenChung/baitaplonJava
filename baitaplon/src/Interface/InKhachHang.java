package Interface;

import java.util.ArrayList;

import entity.KhachHang;

public interface InKhachHang {
	public ArrayList<KhachHang> getallkhachhang();
	public ArrayList<KhachHang> getkhachhangTheoMaKH(String id);
	public ArrayList<KhachHang> getkhachhangTheoMaTour(String id);
	public boolean create(KhachHang kh);
	public boolean update(KhachHang kh) ;
	public boolean delete(KhachHang kh);
	public ArrayList<KhachHang> getkhachhangTheoCCCD(String id);
	public ArrayList<KhachHang> getkhachhangTheoSDT(String sdt);
//	public String getfivemacuoiKH();
}
