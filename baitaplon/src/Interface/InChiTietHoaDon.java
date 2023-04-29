package Interface;

import java.util.ArrayList;

import entity.ChiTietHoaDon;

public interface InChiTietHoaDon {
	public ArrayList<ChiTietHoaDon> getAllCTHoaDon();
	public ArrayList<ChiTietHoaDon> getCTHoaDonTheoMaCTHD(String maCTHD);
	public ArrayList<ChiTietHoaDon> getCTHoaDonTheoMaHD(String mahd);
	public boolean create(ChiTietHoaDon cthd);
	public boolean delete(ChiTietHoaDon cthd);
}
