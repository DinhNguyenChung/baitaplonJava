package Interface;

import java.util.ArrayList;

import entity.NhanVien;

public interface InNhanVien {
	public ArrayList<NhanVien> getallNhanVien();
	public ArrayList<NhanVien> getNhanVienTheoMaNV(String id);
	public boolean create(NhanVien nv) ;
	public boolean update(NhanVien nv);
	public boolean delete(NhanVien nv);
	public ArrayList<NhanVien> getkhachhangTheoMaTour(String id);
}
