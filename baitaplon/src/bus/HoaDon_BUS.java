package bus;

import java.util.ArrayList;

import Interface.InHoaDon;
import dao.Hoadon_DAO;
import entity.HoaDon;

public class HoaDon_BUS implements InHoaDon {
	Hoadon_DAO hd_dao = new Hoadon_DAO();
	@Override
	public ArrayList<HoaDon> getAllHoaDon() {
		// TODO Auto-generated method stub
		return hd_dao.getAllHoaDon();
	}
	@Override
	public ArrayList<HoaDon> getHoaDonTheoMaHD(String maHD) {
		// TODO Auto-generated method stub
		return hd_dao.getHoaDonTheoMaHD(maHD);
	}
	@Override
	public boolean create(HoaDon hd) {
		// TODO Auto-generated method stub
		return hd_dao.create(hd);
	}
	@Override
	public boolean delete(HoaDon hd) {
		return hd_dao.delete(hd);
	}
	

}
