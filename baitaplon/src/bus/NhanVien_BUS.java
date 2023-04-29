package bus;

import java.util.ArrayList;

import Interface.InNhanVien;
import dao.NhanVien_DAO;
import entity.NhanVien;

public class NhanVien_BUS implements InNhanVien{
	NhanVien_DAO nv_dao = new NhanVien_DAO();
	@Override
	public ArrayList<NhanVien> getallNhanVien() {
		// TODO Auto-generated method stub
		return nv_dao.getallNhanVien();
	}

	@Override
	public ArrayList<NhanVien> getNhanVienTheoMaNV(String id) {
		// TODO Auto-generated method stub
		return nv_dao.getNhanVienTheoMaNV(id);
	}

	@Override
	public boolean create(NhanVien nv) {
		// TODO Auto-generated method stub
		return nv_dao.create(nv);
	}

	@Override
	public boolean update(NhanVien nv) {
		// TODO Auto-generated method stub
		return nv_dao.update(nv);
	}

	@Override
	public boolean delete(NhanVien nv) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<NhanVien> getkhachhangTheoMaTour(String id) {
		// TODO Auto-generated method stub
		return nv_dao.getkhachhangTheoMaTour(id);
	}

}
