package Interface;

import java.sql.Date;
import java.util.ArrayList;

import entity.Tour;

public interface InTour {
	public ArrayList<Tour> getalltbTour();
	public ArrayList<Tour> getTourTheoMaTour(String maTourID);
	public boolean create(Tour tour) ;
	public boolean delete(Tour tour);
	public boolean update(Tour tour);

	public ArrayList<Tour> getTourTheoTimTen(String Ten);
	public ArrayList<Tour> getTourTheoDiaDiem(String dd);
	public ArrayList<Tour> getTourTheoGia(double giamin,double giamax);
	public ArrayList<Tour> getTourTheoNgayKH(Date ngayKh);
	public ArrayList<Tour> getTourTheoTimTenvsDiaDiem(String Ten,String dd);
	public ArrayList<Tour> getTourTheoTimTenvsGia(String Ten,double giamin,double giamax);
	public ArrayList<Tour> getTourTheoTimTenvsNgayKH(String Ten,Date NgayKH);
	public ArrayList<Tour> getTourTheoTimDiaDiemvsGia(String dd,double giamin,double giamax);
	public ArrayList<Tour> getTourTheoTimDiaDiemvsNgayKH(String dd,Date NgayKH);
	public ArrayList<Tour> getTourTheoTimGiavsNgayKH(double giamin,double giamax,Date NgayKH);
	public ArrayList<Tour> getTourTheoTimTenvsDiaDiemvsGia(String ten,String dd,double giamin,double giamax);
	public ArrayList<Tour> getTourTheoTimTenvsDiaDiemvsNgayKH(String ten,String dd,Date NgayKH);
	public ArrayList<Tour> getTourTheoTimTenvsGiavsNgayKH(String ten,double giamin,double giamax,Date NgayKH);
	public ArrayList<Tour> getTourTheoTimDiaDiemvsGiavsNgayKH(String dd,double giamin,double giamax,Date NgayKH);
	public ArrayList<Tour> getTourTheoTimTheoALL(String ten,String dd,double giamin,double giamax,Date NgayKH);
	
	
	
	
	
	
	
}
