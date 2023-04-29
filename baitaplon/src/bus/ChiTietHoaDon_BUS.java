package bus;

import java.util.ArrayList;

import Interface.InChiTietHoaDon;
import dao.ChiTietHoaDon_DAO;
import entity.ChiTietHoaDon;

public class ChiTietHoaDon_BUS implements InChiTietHoaDon {
	ChiTietHoaDon_DAO cthd_dao = new ChiTietHoaDon_DAO();
	@Override
	public ArrayList<ChiTietHoaDon> getAllCTHoaDon() {
		// TODO Auto-generated method stub
		return cthd_dao.getAllCTHoaDon();
	}

	@Override
	public ArrayList<ChiTietHoaDon> getCTHoaDonTheoMaCTHD(String maCTHD) {
		// TODO Auto-generated method stub
		return cthd_dao.getCTHoaDonTheoMaCTHD(maCTHD);
	}

	@Override
	public ArrayList<ChiTietHoaDon> getCTHoaDonTheoMaHD(String mahd) {
		// TODO Auto-generated method stub
		return cthd_dao.getCTHoaDonTheoMaHD(mahd);
	}

	@Override
	public boolean create(ChiTietHoaDon cthd) {
		// TODO Auto-generated method stub
		return cthd_dao.create(cthd);
	}

	@Override
	public boolean delete(ChiTietHoaDon cthd) {
		return cthd_dao.delete(cthd);
	}

	public int SLTourDaDat(String ma) {
		// TODO Auto-generated method stub
		return cthd_dao.SLTourDaDat(ma);
	}

}
