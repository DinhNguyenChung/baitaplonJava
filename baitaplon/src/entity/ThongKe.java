package entity;

public class ThongKe {
	private String tentour;
	private int solandat;
	private int solandi;

	private double giatour;
	private double tongtien;
	
	
	public ThongKe() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ThongKe(String tentour, int solandat, int solandi, double giatour, double tongtien) {
		super();
		this.tentour = tentour;
		this.solandat = solandat;
		this.solandi = solandi;
		this.giatour = giatour;
		this.tongtien = tongtien;
	}


	public String getTentour() {
		return tentour;
	}


	public void setTentour(String tentour) {
		this.tentour = tentour;
	}


	public int getSolandat() {
		return solandat;
	}


	public void setSolandat(int solandat) {
		this.solandat = solandat;
	}


	public int getSolandi() {
		return solandi;
	}


	public void setSolandi(int solandi) {
		this.solandi = solandi;
	}


	public double getGiatour() {
		return giatour;
	}


	public void setGiatour(double giatour) {
		this.giatour = giatour;
	}


	public double getTongtien() {
		return tongtien;
	}


	public void setTongtien(double tongtien) {
		this.tongtien = tongtien;
	}
	
	
}
