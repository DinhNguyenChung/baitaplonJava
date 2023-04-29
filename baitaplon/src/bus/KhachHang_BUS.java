package bus;

import java.util.ArrayList;

import Interface.InKhachHang;
import dao.KhachHang_DAO;
import entity.KhachHang;

public class KhachHang_BUS implements InKhachHang {
	KhachHang_DAO kh_dao = new KhachHang_DAO();

	@Override
	public ArrayList<KhachHang> getallkhachhang() {
		// TODO Auto-generated method stub
		return kh_dao.getallkhachhang();
	}

	@Override
	public ArrayList<KhachHang> getkhachhangTheoMaKH(String id) {
		// TODO Auto-generated method stub
		return kh_dao.getkhachhangTheoMaKH(id);
	}

	@Override
	public ArrayList<KhachHang> getkhachhangTheoMaTour(String id) {
		// TODO Auto-generated method stub
		return kh_dao.getkhachhangTheoMaTour(id);
	}

	@Override
	public boolean create(KhachHang kh) {
		// TODO Auto-generated method stub
		return kh_dao.create(kh);
	}

	@Override
	public boolean update(KhachHang kh) {
		// TODO Auto-generated method stub
		return kh_dao.update(kh);
	}

	@Override
	public boolean delete(KhachHang kh) {
		// TODO Auto-generated method stub
		return kh_dao.delete(kh);
	}

	@Override
	public ArrayList<KhachHang> getkhachhangTheoCCCD(String id) {
		// TODO Auto-generated method stub
		return kh_dao.getkhachhangTheoCCCD(id);
	}

	@Override
	public ArrayList<KhachHang> getkhachhangTheoSDT(String sdt) {
		// TODO Auto-generated method stub
		return kh_dao.getkhachhangTheoSDT(sdt);
	}



}
