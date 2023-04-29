package Interface;

import java.sql.Date;
import java.util.ArrayList;
import entity.ThongKe;

public interface InThongKe {
	public ArrayList<ThongKe> getAllThongKe();
	public ArrayList<ThongKe> getThongKeTheo2ngay(Date ngBD,Date ngayKT);
	public ArrayList<ThongKe> getThongKeTheoNgayBD(Date ngBD);
	public ArrayList<ThongKe> getThongKeTheoNgayKT(Date ngKT);
	
	
}
