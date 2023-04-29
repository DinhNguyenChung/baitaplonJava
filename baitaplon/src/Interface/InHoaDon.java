package Interface;

import java.util.ArrayList;

import entity.HoaDon;

public interface InHoaDon {
	public ArrayList<HoaDon> getAllHoaDon();
	public ArrayList<HoaDon> getHoaDonTheoMaHD(String maHD);
	public boolean create(HoaDon hd) ;
	public boolean delete(HoaDon hd);
	
}
