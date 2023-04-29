package bus;

import java.sql.Date;
import java.util.ArrayList;

import Interface.InThongKe;
import dao.ThongKe_DAO;
import entity.ThongKe;

public class ThongKe_BUS implements InThongKe {
	ThongKe_DAO tk_dao = new ThongKe_DAO();
	@Override
	public ArrayList<ThongKe> getAllThongKe() {
		// TODO Auto-generated method stub
		return tk_dao.getAllThongKe();
	}
	@Override
	public ArrayList<ThongKe> getThongKeTheo2ngay(Date ngBD, Date ngayKT) {
		// TODO Auto-generated method stub
		return tk_dao.getThongKeTheo2ngay(ngBD, ngayKT);
	}
	@Override
	public ArrayList<ThongKe> getThongKeTheoNgayBD(Date ngBD) {
		// TODO Auto-generated method stub
		return tk_dao.getThongKeTheoNgayBD(ngBD);
	}
	@Override
	public ArrayList<ThongKe> getThongKeTheoNgayKT(Date ngKT) {
		// TODO Auto-generated method stub
		return tk_dao.getThongKeTheoNgayKT(ngKT);
	}

}
