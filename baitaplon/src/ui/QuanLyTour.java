package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import bus.Tour_BUS;
import connectDB.ConnectDB;
import cre.Tour_CRE;
import dao.Tour_DAO;
import entity.Tour;

//import com.toedter.calendar.JDateChooser;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.SwingConstants;
import java.awt.Button;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

public class QuanLyTour extends JFrame implements MouseListener {
	private JPanel contentPane;
	private JTextField txtMaTour;
	private JTextField txtTenTour;
	private JTextField txtDiaDiem;
	private JTextField txtNgayKH;
	private JTextField txtNgayKT;
	private JTextField txtGiaTour;
	private JButton btnThem;
	private JButton btnXoaRong;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnTimKiem;

	private com.toedter.calendar.JDateChooser date_KH;
	private com.toedter.calendar.JDateChooser date_KT;
	private JTextField lblTimKiem;
	private JTextField textField;
	private JTextField txtSoLuong;
	private JTable table;
	private DefaultTableModel model;
	private Tour_BUS tour_bus;
	private Tour_CRE tour_cre;
	private JPanel panel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyTour frame = new QuanLyTour();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuanLyTour() {

		// Kết nối đến SQL
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		tour_bus = new Tour_BUS();
		tour_cre = new Tour_CRE();

		setTitle("QUẢN LÝ TOUR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.scrollbar);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.scrollbar);
		panel.setBorder(null);
		panel.setBounds(10, 0, 980, 75);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("QUẢN LÝ TOUR");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setBackground(SystemColor.activeCaptionBorder);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblNewLabel.setBounds(0, 0, 980, 75);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"TH\u00D4NG TIN TOUR", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(10, 74, 338, 616);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBackground(SystemColor.window);
		panel_4.setBounds(10, 21, 316, 349);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblMaTour = new JLabel("Mã tour ");
		lblMaTour.setBounds(10, 10, 75, 25);
		panel_4.add(lblMaTour);
		lblMaTour.setForeground(SystemColor.textHighlight);
		lblMaTour.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JLabel lblTenTour = new JLabel("Tên tour ");
		lblTenTour.setBounds(10, 60, 75, 25);
		panel_4.add(lblTenTour);
		lblTenTour.setForeground(SystemColor.textHighlight);
		lblTenTour.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JLabel lblDiaDiem = new JLabel("Địa điểm ");
		lblDiaDiem.setBounds(10, 110, 86, 25);
		panel_4.add(lblDiaDiem);
		lblDiaDiem.setForeground(SystemColor.textHighlight);
		lblDiaDiem.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JLabel lblNgayKH = new JLabel("Ngày khởi hành ");
		lblNgayKH.setBounds(10, 160, 127, 25);
		panel_4.add(lblNgayKH);
		lblNgayKH.setForeground(SystemColor.textHighlight);
		lblNgayKH.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JLabel lblNgayKT = new JLabel("Ngày kết thúc ");
		lblNgayKT.setBounds(10, 210, 127, 25);
		panel_4.add(lblNgayKT);
		lblNgayKT.setForeground(SystemColor.textHighlight);
		lblNgayKT.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JLabel lblSLngKhch = new JLabel("Số lượng khách ");
		lblSLngKhch.setBounds(10, 260, 122, 25);
		panel_4.add(lblSLngKhch);
		lblSLngKhch.setForeground(SystemColor.textHighlight);
		lblSLngKhch.setFont(new Font("Segoe UI", Font.BOLD, 13));

		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(121, 260, 179, 25);
		panel_4.add(txtSoLuong);
		txtSoLuong.setColumns(10);

		JLabel lblGiaTour = new JLabel("Giá tour ");
		lblGiaTour.setBounds(10, 310, 75, 26);
		panel_4.add(lblGiaTour);
		lblGiaTour.setForeground(SystemColor.textHighlight);
		lblGiaTour.setFont(new Font("Segoe UI", Font.BOLD, 13));

		txtMaTour = new JTextField();
		txtMaTour.setBounds(121, 10, 181, 25);
		panel_4.add(txtMaTour);
		txtMaTour.setColumns(10);
		txtMaTour.setEditable(false);

		txtTenTour = new JTextField();
		txtTenTour.setBounds(121, 60, 181, 25);
		panel_4.add(txtTenTour);
		txtTenTour.setColumns(10);

		txtDiaDiem = new JTextField();
		txtDiaDiem.setBounds(121, 110, 181, 25);
		panel_4.add(txtDiaDiem);
		txtDiaDiem.setColumns(10);

		date_KH = new JDateChooser();
		date_KH.setBounds(121, 160, 181, 25);
		panel_4.add(date_KH);

		date_KT = new JDateChooser();
		date_KT.setBounds(121, 210, 181, 25);
		panel_4.add(date_KT);

		txtGiaTour = new JTextField();
		txtGiaTour.setBounds(121, 310, 179, 25);
		panel_4.add(txtGiaTour);
		txtGiaTour.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 382, 316, 198);
		panel_1.add(panel_3);
				panel_3.setLayout(null);
		
				JButton btnThoat = new JButton("Thoát");
				btnThoat.setBackground(new Color(255, 69, 0));
				btnThoat.setForeground(SystemColor.window);
				btnThoat.setBounds(186, 160, 120, 30);
				panel_3.add(btnThoat);
				btnThoat.setFont(new Font("Segoe UI", Font.BOLD, 13));
				
						btnThem = new JButton("Thêm");
						btnThem.setForeground(SystemColor.window);
						btnThem.setBackground(SystemColor.textHighlight);
						btnThem.setBounds(10, 110, 120, 30);
						panel_3.add(btnThem);
						btnThem.setFont(new Font("Segoe UI", Font.BOLD, 13));
						
								btnXoaRong = new JButton("Xóa Rỗng");
								btnXoaRong.setBackground(SystemColor.textHighlight);
								btnXoaRong.setForeground(SystemColor.window);
								btnXoaRong.setBounds(186, 60, 120, 30);
								panel_3.add(btnXoaRong);
								btnXoaRong.setFont(new Font("Segoe UI", Font.BOLD, 13));
								
										btnSua = new JButton("Sửa");
										btnSua.setBackground(SystemColor.textHighlight);
										btnSua.setForeground(SystemColor.window);
										btnSua.setBounds(10, 160, 120, 30);
										panel_3.add(btnSua);
										btnSua.setFont(new Font("Segoe UI", Font.BOLD, 13));
										
												btnXoa = new JButton("Xóa");
												btnXoa.setBackground(SystemColor.textHighlight);
												btnXoa.setBounds(186, 110, 120, 30);
												panel_3.add(btnXoa);
												btnXoa.setFont(new Font("Segoe UI", Font.BOLD, 13));
												btnXoa.setForeground(SystemColor.window);
												
														btnTimKiem = new JButton("Tìm kiếm");
														btnTimKiem.setBackground(new Color(102, 205, 170));
														btnTimKiem.setForeground(SystemColor.window);
														btnTimKiem.setBounds(10, 60, 120, 30);
														panel_3.add(btnTimKiem);
														btnTimKiem.setFont(new Font("Segoe UI", Font.BOLD, 13));
														
																lblTimKiem = new JTextField();
																lblTimKiem.setBounds(10, 15, 120, 30);
																panel_3.add(lblTimKiem);
																lblTimKiem.setColumns(10);
																
																JLabel lblNewLabel_1 = new JLabel("Mã Tour");
																lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
																lblNewLabel_1.setBounds(10, 0, 120, 14);
																panel_3.add(lblNewLabel_1);
																
																JButton btnDanhSach = new JButton("Danh Sách");
																btnDanhSach.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																		XoaDuLieuTrentable();
																		DocDuLieuTuDB();
																		XoaRong();
																	}
																});
																btnDanhSach.setFont(new Font("Segoe UI", Font.BOLD, 13));
																btnDanhSach.setBackground(SystemColor.textHighlight);
																btnDanhSach.setForeground(SystemColor.window);
																btnDanhSach.setBounds(186, 15, 120, 30);
																panel_3.add(btnDanhSach);
														btnTimKiem.addActionListener(new ActionListener() {
															@Override
															public void actionPerformed(ActionEvent e) {
																try {
																	String maTour = lblTimKiem.getText();
																	List<Tour> list = tour_bus.getTourTheoMaTour(maTour);
																	if (list.isEmpty()) {
																		JOptionPane.showInternalMessageDialog(null, "Không tìm thấy");
																	} else {
																		clearTable();
																		for (Tour tour : list) {
																			model.addRow(new Object[] { tour.getMaTour(), tour.getTenTour(), tour.getDiadiemden(),
																					tour.getNgaykhoihanh(), tour.getNgaykethuc(), tour.getGiatien(),
																					tour.getSoluong() });
																		}
																	}
																} catch (Exception e2) {
																	JOptionPane.showMessageDialog(null, "Lỗi khi tìm kiếm tour: " + e2.getMessage());
																}
															}
														});
												btnXoa.addActionListener(new ActionListener() {
													@Override
													public void actionPerformed(ActionEvent e) {
														int row = table.getSelectedRow();
														String maTour = txtMaTour.getText();

														Tour tour = new Tour(maTour);
														try {
															tour_bus.delete(tour);
														} catch (Exception e2) {
															JOptionPane.showMessageDialog(null, "Xóa thất bại");
														}
														model.removeRow(row);
													}
												});
										btnSua.addActionListener(new ActionListener() {
											@Override
											public void actionPerformed(ActionEvent e) {
												if (validData()) {
													try {
														String maTour = txtMaTour.getText();
														String tenTour = txtTenTour.getText();
														String diaDiem = txtDiaDiem.getText();
														java.sql.Date ngayKH = new java.sql.Date(date_KH.getDate().getTime());
														java.sql.Date ngayKT = new java.sql.Date(date_KT.getDate().getTime());
														double giaTour = Double.parseDouble(txtGiaTour.getText());
														int soLuong = Integer.parseInt(txtSoLuong.getText());
														Tour tour = new Tour(maTour, tenTour, diaDiem, ngayKH, ngayKT, giaTour, soLuong);

														if (tour_bus.update(tour)) {
															clearTable();
															DocDuLieuTuDB();
														} else
															JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
													} catch (Exception e2) {

														JOptionPane.showMessageDialog(null, "Cần chọn tour để cập nhật");
													}
												}
											}
										});
								btnXoaRong.addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent e) {
										XoaRong();
									}
								});
						btnThem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if (validData()) {
									String maTour = getmaTour();
									String tenTour = txtTenTour.getText();
									String diaDiem = txtDiaDiem.getText();
									java.sql.Date ngayKH = new java.sql.Date(date_KH.getDate().getTime());
									java.sql.Date ngayKT = new java.sql.Date(date_KT.getDate().getTime());
									double giaTour = Double.parseDouble(txtGiaTour.getText());
									int soLuong = Integer.parseInt(txtSoLuong.getText());
									Tour tour = new Tour(maTour, tenTour, diaDiem, ngayKH, ngayKT, giaTour, soLuong);

									try {
										tour_bus.create(tour);
										model.addRow(new Object[] { tour.getMaTour(), tour.getTenTour(), tour.getDiadiemden(),
												tour.getNgaykhoihanh(), tour.getNgaykethuc(), tour.getGiatien(),
												tour.getSoluong() });
									} catch (Exception e2) {
										JOptionPane.showMessageDialog(null, "Trùng mã");
									}
								}
							}
						});
				btnThoat.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
//						dispose();
				TrangChu tc = new TrangChu();
				tc.setVisible(true);
				setVisible(false);
					}
				});

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.menu);
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"DANH S\u00C1CH TOUR", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(354, 74, 636, 616);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 20, 616, 560);
		panel_2.add(scrollPane);

		table = new JTable();
		table.setModel(model = new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 tour ", "T\u00EAn tour ", "\u0110\u1ECBa \u0111i\u1EC3m ",
						"Ng\u00E0y kh\u1EDFi h\u00E0nh ", "Ng\u00E0y k\u1EBFt th\u00FAc",
						"S\u1ED1 l\u01B0\u1EE3ng kh\u00E1ch", "Gi\u00E1 tour " }));
		scrollPane.setViewportView(table);

		DocDuLieuTuDB();
		table.addMouseListener(this);
	}

	public void DocDuLieuTuDB() {
		List<Tour> list = tour_bus.getalltbTour();
		for (Tour tour : list) {
			model.addRow(new Object[] { tour.getMaTour(), tour.getTenTour(), tour.getDiadiemden(),
					tour.getNgaykhoihanh(), tour.getNgaykethuc(), tour.getSoluong(), tour.getGiatien() });
		}
	}
	public void XoaRong() {
		txtDiaDiem.setText("");
		txtGiaTour.setText("");
		txtMaTour.setText("");
		date_KH.setDate(null);
		date_KT.setDate(null);
		txtSoLuong.setText("");
		txtTenTour.setText("");
		
	}
	public void XoaDuLieuTrentable() {
		DefaultTableModel dm = (DefaultTableModel)table.getModel();
		dm.getDataVector().removeAllElements();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMaTour.setText(model.getValueAt(row, 0).toString());
		txtTenTour.setText(model.getValueAt(row, 1).toString());
		txtDiaDiem.setText(model.getValueAt(row, 2).toString());
		date_KH.setDate((Date) model.getValueAt(row, 3));
		date_KT.setDate((Date) model.getValueAt(row, 4));
		txtSoLuong.setText(model.getValueAt(row, 6).toString());
		txtGiaTour.setText(model.getValueAt(row, 5).toString());

	}

	private void clearTable() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
	}

	public boolean validData() {
		String diaDiem = txtDiaDiem.getText().trim();
		String tenTour = txtTenTour.getText().trim();
		String soLuong = txtSoLuong.getText().trim();
		String giaTour = txtGiaTour.getText().trim();

		if (tenTour.equals("")) {
			txtTenTour.requestFocus();
			JOptionPane.showMessageDialog(this, "Tên tour không được rỗng");
			return false;
		} else if (!(tenTour.length() > 0 && tenTour.matches("[\\p{L}'0-9 ]+"))) {
			txtTenTour.requestFocus();
			JOptionPane.showMessageDialog(this, "Tên tour không hợp lệ");
			return false;
		}

		if (diaDiem.equals("")) {
			txtDiaDiem.requestFocus();
			JOptionPane.showMessageDialog(this, "Địa điểm không được rỗng");
			return false;
		} else if (!(diaDiem.length() > 0 && diaDiem.matches("[\\p{L}0-9'_ ]+"))) {
			txtDiaDiem.requestFocus();
			JOptionPane.showMessageDialog(this, "Tên địa điểm không hợp lệ");
			return false;
		}

		try {
			java.sql.Date ngayKH = new java.sql.Date(date_KH.getDate().getTime());
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, 10);
			java.util.Date chkNgayKhoiHanh = new java.util.Date(cal.getTimeInMillis());
			if (!(ngayKH.after(chkNgayKhoiHanh))) {
				JOptionPane.showMessageDialog(null, "Ngày khởi hành phải cách hiện tại ít nhất 10 ngày");
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ngày khởi hành không được để trống");
			return false;
		}

		try {
			java.sql.Date ngayKT = new java.sql.Date(date_KT.getDate().getTime());
			java.sql.Date ngayKH = new java.sql.Date(date_KH.getDate().getTime());
			if (!((ngayKT.getDate() - ngayKH.getDate() >= 2))) {
				System.out.println(ngayKT.getDate() - ngayKH.getDate());
				JOptionPane.showMessageDialog(null, "Ngày kết thúc phải cách ngày khởi hành ít nhất 2 ngày");
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ngày kết thúc không được để trống");
			return false;
		}

		if ((soLuong.length() > 0)) {
			try {
				int sl = Integer.parseInt(soLuong);
				if (!(sl >= 10 && sl <= 150)) {
					JOptionPane.showMessageDialog(this, "Số lượng khách phải nằm trong khoảng (10,150)");
					return false;
				}
			} catch (NumberFormatException e) {
				txtSoLuong.requestFocus();
				JOptionPane.showMessageDialog(this, "Số lượng khách phải là số");
				return false;
			}
		} else {
			txtSoLuong.requestFocus();
			JOptionPane.showMessageDialog(this, "Số lượng không được rỗng");
			return false;
		}

		if ((giaTour.length() > 0)) {
			try {
				double gia = Double.parseDouble(giaTour);
				if (!(gia >= 100000)) {
					JOptionPane.showMessageDialog(this, "Giá tour phải trên 100 000");
					return false;
				}
			} catch (NumberFormatException e) {
				txtGiaTour.requestFocus();
				JOptionPane.showMessageDialog(this, "Giá tour phải là số");
				return false;
			}
		} else {
			txtGiaTour.requestFocus();
			JOptionPane.showMessageDialog(this, "Giá tour không được rỗng");
			return false;
		}
		return true;
	}
	
	private String getmaTour() {
		int macuoi = Integer.parseInt(tour_cre.getfivemacuoiTour());
		String maKH = "MT";
		String macuoiTour = String.valueOf(macuoi+1);
		int numZeroes = 3- macuoiTour.length();
		for(int i=0;i<numZeroes;i++) {
			maKH +="0";
		}
		maKH +=macuoiTour;
		
		return maKH;
	}
	

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
