//package ui;
//
//import java.awt.EventQueue;
//
//
//
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//
//import java.awt.SystemColor;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.sql.Date;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.List;
//import java.awt.Font;
//import java.awt.GraphicsEnvironment;
//import java.awt.Rectangle;
//
//import javax.swing.SwingConstants;
//import javax.swing.JPanel;
//import java.awt.Color;
//import javax.swing.border.TitledBorder;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.border.EtchedBorder;
//import javax.swing.JTextField;
//import javax.swing.DefaultComboBoxModel;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import com.toedter.calendar.JDateChooser;
//
//import connectDB.ConnectDB;
//import dao.NhanVien_DAO;
//import entity.KhachHang;
//import entity.NhanVien;
//
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//
//public class QuanLyNhanVien {
//	
////	private JPanel contentPane;
//	private JFrame frame;
//	private JTextField txtMaNV;
//	private JTextField txtHoTen;
//	private JTextField txtDiaChi;
//	private JTextField txtSDT;
//	private JTextField txtEmail;
//	private JTextField txtCMND;
//	private DefaultTableModel modelNhanVien;
//	private JTable table;
//	private JDateChooser dateNgSinh;
//	private NhanVien_DAO nv_dao;
//	private JComboBox cboMaNV;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					QuanLyNhanVien window = new QuanLyNhanVien();
//					window.getFrame().setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	public QuanLyNhanVien() {
//		try {
//			ConnectDB.getInstance().connect();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		initialize();
//	}
//	private void initialize() {
//		
//		frame = new JFrame();
//		frame.setTitle("QUẢN LÝ NHÂN VIÊN");
//		frame.setBounds(100, 100, 1000, 700);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setLocationRelativeTo(null);
//		frame.setUndecorated(true);
//		frame.getContentPane().setLayout(null);
//		
//		nv_dao = new NhanVien_DAO();
//		
//		JPanel pnlThongTinNV = new JPanel();
//		pnlThongTinNV.setLayout(null);
//		pnlThongTinNV.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "TH\u00D4NG TIN NH\u00C2N VI\u00CAN", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
//		pnlThongTinNV.setBackground(Color.WHITE);
//		pnlThongTinNV.setBounds(12, 95, 964, 182);
//		frame.getContentPane().add(pnlThongTinNV);
//		
//		JLabel lblMaNV = new JLabel("Mã nhân viên : ");
//		lblMaNV.setFont(new Font("Arial", Font.PLAIN, 13));
//		lblMaNV.setBounds(10, 25, 110, 23);
//		pnlThongTinNV.add(lblMaNV);
//		
//		txtMaNV = new JTextField();
//		txtMaNV.setColumns(10);
//		txtMaNV.setBounds(117, 25, 200, 25);
//		pnlThongTinNV.add(txtMaNV);
//		
//		JLabel lblHoTen = new JLabel("Họ tên :");
//		lblHoTen.setFont(new Font("Arial", Font.PLAIN, 13));
//		lblHoTen.setBounds(10, 65, 110, 23);
//		pnlThongTinNV.add(lblHoTen);
//		
//		JLabel lblNgaySinh = new JLabel("Ngày sinh : ");
//		lblNgaySinh.setFont(new Font("Arial", Font.PLAIN, 13));
//		lblNgaySinh.setBounds(10, 105, 110, 23);
//		pnlThongTinNV.add(lblNgaySinh);
//		
//		JLabel lblDiaChi = new JLabel("Địa chỉ :");
//		lblDiaChi.setFont(new Font("Arial", Font.PLAIN, 13));
//		lblDiaChi.setBounds(10, 145, 110, 23);
//		pnlThongTinNV.add(lblDiaChi);
//		
//		JLabel lblSDT = new JLabel("Số điện thoại : ");
//		lblSDT.setFont(new Font("Arial", Font.PLAIN, 13));
//		lblSDT.setBounds(365, 25, 110, 23);
//		pnlThongTinNV.add(lblSDT);
//		
//		JLabel lblEmail = new JLabel("Email : ");
//		lblEmail.setFont(new Font("Arial", Font.PLAIN, 13));
//		lblEmail.setBounds(365, 65, 82, 23);
//		pnlThongTinNV.add(lblEmail);
//		
//		txtHoTen = new JTextField();
//		txtHoTen.setColumns(10);
//		txtHoTen.setBounds(117, 65, 200, 25);
//		pnlThongTinNV.add(txtHoTen);
//		
//		txtDiaChi = new JTextField();
//		txtDiaChi.setColumns(10);
//		txtDiaChi.setBounds(117, 145, 200, 25);
//		pnlThongTinNV.add(txtDiaChi);
//		
//		txtSDT = new JTextField();
//		txtSDT.setColumns(10);
//		txtSDT.setBounds(452, 24, 200, 25);
//		pnlThongTinNV.add(txtSDT);
//		
//		txtEmail = new JTextField();
//		txtEmail.setColumns(10);
//		txtEmail.setBounds(452, 64, 200, 25);
//		pnlThongTinNV.add(txtEmail);
//		
//		dateNgSinh = new JDateChooser();
//		dateNgSinh.setBounds(117, 109, 200, 25);
//		pnlThongTinNV.add(dateNgSinh);
//		
//		JButton btnThem = new JButton("Thêm");
//		btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnThem.setBounds(704, 93, 120, 35);
//		pnlThongTinNV.add(btnThem);
//		btnThem.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				Them();
//			}
//		});
//		
//		JButton btnXoaRong = new JButton("Xóa rỗng");
//		btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnXoaRong.setBounds(704, 53, 120, 35);
//		pnlThongTinNV.add(btnXoaRong);
//		
//		btnXoaRong.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				txtMaNV.setText("");
//				txtHoTen.setText("");
//				txtDiaChi.setText("");
//				txtSDT.setText("");
//				txtCMND.setText("");
//				txtEmail.setText("");
//				dateNgSinh.setDate(null);;
//			}
//		});
//		
//		JButton btnXoa = new JButton("Xóa");
//		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnXoa.setBounds(834, 13, 120, 35);
//		pnlThongTinNV.add(btnXoa);
//		
//		btnXoa.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				int row = table.getSelectedRow();
//				String maNV = table.getValueAt(row, 0).toString();
//				NhanVien nv = new NhanVien(maNV);
//				try {
//					int hoi = JOptionPane.showConfirmDialog(null ,"Bạn chắc chắn Xóa ?","Chú ý",JOptionPane.YES_NO_OPTION);
//					if(hoi==JOptionPane.YES_NO_OPTION) {
//						nv_dao.delete(nv);
//						modelNhanVien.removeRow(row);
//					}
//				} catch (Exception e1) {
//					JOptionPane.showMessageDialog(null, "Xóa thất bại");
//				}
//			}
//		});
//		
//		JButton btnSua = new JButton("Sửa");
//		btnSua.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnSua.setBounds(704, 13, 120, 35);
//		pnlThongTinNV.add(btnSua);
//		
//		btnSua.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				String maNV = txtMaNV.getText();
//				String tenNV = txtHoTen.getText();
//				Date ngaysinh=  new Date(dateNgSinh.getDate().getTime());
//				String diachi =  txtDiaChi.getText();
//				String sdt= txtSDT.getText();
//				String email = txtEmail.getText();
//				String cccd= (txtCMND.getText());
//
//				NhanVien nv = new NhanVien(maNV, tenNV, ngaysinh, diachi, sdt, email, cccd);
//				try {
//					if(nv_dao.update(nv)) {
//						JOptionPane.showMessageDialog(null, "Cập nhật thành công");
//						XoahetDuLieutrenTable();
//						DocDuLieutrenSQL();
//					}
//				} catch (Exception e2) {
//				}
//			}
//		});
//		
//		cboMaNV = new JComboBox();
//		cboMaNV.setBounds(452, 144, 200, 25);
//		pnlThongTinNV.add(cboMaNV);
//		ArrayList<NhanVien> listnv = nv_dao.getallNhanVien();
//		for(NhanVien nv:listnv) {
//			cboMaNV.addItem(nv.getMaNV());
//		}
//		
//		JButton btnTimMa = new JButton("Tìm kiếm theo mã Nhân viên");
//		btnTimMa.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnTimMa.setBounds(704, 137, 250, 35);
//		pnlThongTinNV.add(btnTimMa);
//		
//		btnTimMa.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				try {
//					String maTim = cboMaNV.getSelectedItem().toString();
//					List<NhanVien> listNV = null;
//					listNV = nv_dao.getNhanVienTheoMaNV(maTim);
//					if(listNV ==null) JOptionPane.showMessageDialog(null,"Không tìm thấy ");
//					XoahetDuLieutrenTable();
//					for(NhanVien nv:listNV) {
//						modelNhanVien.addRow(new Object[] {nv.getMaNV(),nv.getTenNV(),nv.getNgaySinh(),nv.getDiaChi(),nv.getSdt(),nv.getEmail(),nv.getCmnd()});
//					}
//				} catch (Exception e3) {
//					JOptionPane.showMessageDialog(null, "Lỗi");
//					DocDuLieutrenSQL();
//				}
//			}
//		});
//		
//		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên");
//		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
//		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
//		lblNewLabel_1.setBounds(365, 144, 82, 25);
//		pnlThongTinNV.add(lblNewLabel_1);
//		
//		JLabel lblCmndcccd = new JLabel("CMND/CCCD : ");
//		lblCmndcccd.setFont(new Font("Arial", Font.PLAIN, 13));
//		lblCmndcccd.setBounds(365, 105, 110, 23);
//		pnlThongTinNV.add(lblCmndcccd);
//		
//		txtCMND = new JTextField();
//		txtCMND.setColumns(10);
//		txtCMND.setBounds(452, 104, 200, 25);
//		pnlThongTinNV.add(txtCMND);
//		
//		
//		
//		JButton btnThoat = new JButton("Thoát");
//		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnThoat.setBounds(834, 93, 120, 35);
//		pnlThongTinNV.add(btnThoat);
//		
//		btnThoat.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				TrangChu tc = new TrangChu();
//				tc.setVisible(true);
//				setVisible(false);
//			}
//		});
//		
//		JButton btnLamMoi = new JButton("Làm mới");
//		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnLamMoi.setBounds(833, 53, 120, 35);
//		pnlThongTinNV.add(btnLamMoi);
//		
//		btnLamMoi.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				XoahetDuLieutrenTable();
//				DocDuLieutrenSQL();
//			}
//		});
//		
//		JPanel pnlDanhSachNV = new JPanel();
//		pnlDanhSachNV.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "DANH S\u00C1CH NH\u00C2N VI\u00CAN", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
//		pnlDanhSachNV.setBackground(Color.WHITE);
//		pnlDanhSachNV.setBounds(10, 287, 966, 366);
//		frame.getContentPane().add(pnlDanhSachNV);
//		pnlDanhSachNV.setLayout(null);
//		
//		String [] header = "Mã nhân viên;Tên nhân viên;Ngày sinh;Địa chỉ;Số điện thoại;Email;CMND/CCCD".split(";");
//		modelNhanVien = new DefaultTableModel(header, 0);
//		JScrollPane scroll = new JScrollPane(table = new JTable(modelNhanVien));
//		scroll.setSize(946, 337);
//		scroll.setLocation(10, 19);
//		pnlDanhSachNV.add(scroll);
//		
//		table.addMouseListener(new MouseListener() {
//			
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mousePressed(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mouseExited(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//				int row = table.getSelectedRow();
//				txtMaNV.setText(table.getValueAt(row, 0).toString());
//				txtHoTen.setText(table.getValueAt(row, 1).toString());
//				try {
//					dateNgSinh.setDate((Date)table.getValueAt(row, 2));
//				} catch (Exception e2) {
//					// TODO: handle exception
//					 String dateString = table.getValueAt(row, 2).toString();
//					 SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
//					    try {
//					    	java.util.Date utilDate = outputFormat.parse(dateString);
//					    	java.sql.Date sqldate = new java.sql.Date(utilDate.getTime());
//					    	dateNgSinh.setDate(sqldate);
//					    	
//					    } catch (ParseException e1) {
//					        // Handle the exception
//					    }
//				} 
//				txtDiaChi.setText(table.getValueAt(row, 3).toString());
//				txtSDT.setText(table.getValueAt(row, 4).toString());
//				txtEmail.setText(table.getValueAt(row, 5).toString());
//				txtCMND.setText(table.getValueAt(row, 6).toString());
//			}
//		});
//		
//		JPanel pnlTitile = new JPanel();
//		pnlTitile.setLayout(null);
//		pnlTitile.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
//		pnlTitile.setBackground(Color.WHITE);
//		pnlTitile.setBounds(10, 9, 966, 76);
//		frame.getContentPane().add(pnlTitile);
//		
//		JLabel lblTitle = new JLabel("QUẢN LÝ NHÂN VIÊN");
//		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
//		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 35));
//		lblTitle.setBackground(SystemColor.menu);
//		lblTitle.setBounds(0, 0, 966, 76);
//		pnlTitile.add(lblTitle);
////		contentPane = new JPanel();
////		contentPane.add(frame);
//		DocDuLieutrenSQL();
//	}
//	
//		protected void setVisible(boolean b) {}
//
//	private void XoahetDuLieutrenTable() {
//		DefaultTableModel md = (DefaultTableModel)table.getModel();
//		md.getDataVector().removeAllElements();
//	}
//	private void DocDuLieutrenSQL() {
//		List<NhanVien> list = nv_dao.getallNhanVien();
//		if(modelNhanVien==null) {
//			JOptionPane.showMessageDialog(null, "modelNhanVien không tồn tại");
//			return;
//		}
//		for(NhanVien nv:list) {
//			modelNhanVien.addRow(new Object[] {nv.getMaNV(),nv.getTenNV(),nv.getNgaySinh(),nv.getDiaChi(),nv.getSdt(),nv.getEmail(),nv.getCmnd()});
//		}
//	}
//	private void Them() {
//		String maNV = txtMaNV.getText();
//		String tenNV = txtHoTen.getText();
////		Date ngaysinh=  new Date(dateNgSinh.getDate().getTime());
//		java.util.Date ngaysinh = dateNgSinh.getDate();
//		java.sql.Date ngsinh=  new java.sql.Date(ngaysinh.getTime());
//		String diaChi = txtDiaChi.getText();
//		String sdt = txtSDT.getText();
//		String email = txtEmail.getText();
//		String cmnd = txtCMND.getText();
//		
//		NhanVien nv = new NhanVien(maNV, tenNV, ngsinh, diaChi, sdt, email, cmnd);
//		
//		try {
//			nv_dao.create(nv);
//			String[] dataRow = {nv.getMaNV(), nv.getTenNV(), nv.getNgaySinh().toString(), nv.getDiaChi(), nv.getSdt(), nv.getEmail(), nv.getCmnd()};
//			modelNhanVien.addRow(dataRow);
//		} catch (Exception e1) {
//			JOptionPane.showMessageDialog(null, "Trùng mã!");
//		}
//	}
//	public JFrame getFrame() {
//		return frame;
//	}
//}


package ui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import bus.NhanVien_BUS;
import connectDB.*;
import dao.NhanVien_DAO;
import entity.*;
import cre.*;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class QuanLyNhanVien {

	private JFrame frame;
	private JTextField txtMaNV;
	private JTextField txtHoTen;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JTextField txtCMND;
	private DefaultTableModel modelNhanVien;
	private JTable table;
	private JDateChooser dateNgSinh;
	private NhanVien_BUS nv_bus;
	private JComboBox cboMaNV;
	private NhanVien_CRE nv_cre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyNhanVien window = new QuanLyNhanVien();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected Window getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}

	public QuanLyNhanVien() {
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			// TODO: handle exception
		}
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.scrollbar);
		frame.setTitle("QUẢN LÝ NHÂN VIÊN");
		frame.setBounds(100, 100, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setUndecorated(true);
		
		nv_bus = new NhanVien_BUS();
		nv_cre = new NhanVien_CRE();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Th\u00F4ng tin nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 76, 980, 229);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel pnlThongTinNV = new JPanel();
		pnlThongTinNV.setBounds(10, 23, 960, 186);
		panel.add(pnlThongTinNV);
		pnlThongTinNV.setLayout(null);
		pnlThongTinNV.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlThongTinNV.setBackground(Color.WHITE);
		
		JLabel lblMaNV = new JLabel("Mã nhân viên ");
		lblMaNV.setForeground(SystemColor.textHighlight);
		lblMaNV.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblMaNV.setBounds(10, 25, 110, 25);
		pnlThongTinNV.add(lblMaNV);
		
		txtMaNV = new JTextField();
		txtMaNV.setBackground(Color.WHITE);
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(117, 25, 200, 25);
		pnlThongTinNV.add(txtMaNV);
		txtMaNV.setEditable(false);
		
		JLabel lblHoTen = new JLabel("Họ tên ");
		lblHoTen.setForeground(SystemColor.textHighlight);
		lblHoTen.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblHoTen.setBounds(10, 65, 110, 25);
		pnlThongTinNV.add(lblHoTen);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh ");
		lblNgaySinh.setForeground(SystemColor.textHighlight);
		lblNgaySinh.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNgaySinh.setBounds(10, 105, 110, 25);
		pnlThongTinNV.add(lblNgaySinh);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ ");
		lblDiaChi.setForeground(SystemColor.textHighlight);
		lblDiaChi.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblDiaChi.setBounds(10, 145, 110, 25);
		pnlThongTinNV.add(lblDiaChi);
		
		JLabel lblSDT = new JLabel("Số điện thoại ");
		lblSDT.setForeground(SystemColor.textHighlight);
		lblSDT.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblSDT.setBounds(362, 25, 99, 25);
		pnlThongTinNV.add(lblSDT);
		
		JLabel lblEmail = new JLabel("Email ");
		lblEmail.setForeground(SystemColor.textHighlight);
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblEmail.setBounds(362, 65, 80, 25);
		pnlThongTinNV.add(lblEmail);
		
		txtHoTen = new JTextField();
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(117, 65, 200, 25);
		pnlThongTinNV.add(txtHoTen);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(117, 145, 200, 25);
		pnlThongTinNV.add(txtDiaChi);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(459, 25, 200, 25);
		pnlThongTinNV.add(txtSDT);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(459, 65, 200, 25);
		pnlThongTinNV.add(txtEmail);
		
		dateNgSinh = new JDateChooser();
		dateNgSinh.setBounds(117, 105, 200, 25);
		pnlThongTinNV.add(dateNgSinh);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setForeground(SystemColor.window);
		btnThem.setBackground(SystemColor.textHighlight);
		btnThem.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnThem.setBounds(689, 142, 115, 30);
		pnlThongTinNV.add(btnThem);
		btnThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (KiemTraDuLieu() == true) {
					Them();
				} else {
					JOptionPane.showMessageDialog(null, "Lỗi thêm!");
				}
			}
		});
		
		JButton btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setForeground(SystemColor.window);
		btnXoaRong.setBackground(SystemColor.textHighlight);
		btnXoaRong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnXoaRong.setBounds(689, 85, 115, 30);
		pnlThongTinNV.add(btnXoaRong);
		
		btnXoaRong.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtMaNV.setText("");
				txtHoTen.setText("");
				txtDiaChi.setText("");
				txtSDT.setText("");
				txtCMND.setText("");
				txtEmail.setText("");
				dateNgSinh.setDate(null);;
			}
		});
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setForeground(SystemColor.window);
		btnXoa.setBackground(SystemColor.textHighlight);
		btnXoa.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnXoa.setBounds(835, 25, 115, 30);
		pnlThongTinNV.add(btnXoa);
		
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				String maNV = table.getValueAt(row, 0).toString();
				NhanVien nv = new NhanVien(maNV);
				try {
					int hoi = JOptionPane.showConfirmDialog(null ,"Bạn chắc chắn Xóa ?","Chú ý",JOptionPane.YES_NO_OPTION);
					if(hoi==JOptionPane.YES_NO_OPTION) {
						nv_bus.delete(nv);
						modelNhanVien.removeRow(row);
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Xóa thất bại");
				}
			}
		});
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setForeground(SystemColor.window);
		btnSua.setBackground(SystemColor.textHighlight);
		btnSua.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnSua.setBounds(689, 25, 115, 30);
		pnlThongTinNV.add(btnSua);
		
		btnSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String maNV = txtMaNV.getText();
				String tenNV = txtHoTen.getText();
				Date ngaysinh=  new Date(dateNgSinh.getDate().getTime());
				String diachi =  txtDiaChi.getText();
				String sdt= txtSDT.getText();
				String email = txtEmail.getText();
				String cccd= (txtCMND.getText());

				NhanVien nv = new NhanVien(maNV, tenNV, ngaysinh, diachi, sdt, email, cccd);
				try {
					if(nv_bus.update(nv)) {
						JOptionPane.showMessageDialog(null, "Cập nhật thành công");
						XoahetDuLieutrenTable();
						DocDuLieutrenSQL();
					}
				} catch (Exception e2) {
				}
			}
		});
		
		cboMaNV = new JComboBox();
		cboMaNV.setBackground(Color.WHITE);
		cboMaNV.setBounds(459, 145, 99, 25);
		pnlThongTinNV.add(cboMaNV);
		
		JButton btnTimMa = new JButton("Tìm kiếm");
		btnTimMa.setForeground(Color.WHITE);
		btnTimMa.setBackground(new Color(102, 205, 170));
		btnTimMa.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnTimMa.setBounds(568, 145, 91, 25);
		pnlThongTinNV.add(btnTimMa);
		
		btnTimMa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String maTim = cboMaNV.getSelectedItem().toString();
					List<NhanVien> listNV = null;
					listNV = nv_bus.getNhanVienTheoMaNV(maTim);
					if(listNV ==null) JOptionPane.showMessageDialog(null,"Không tìm thấy ");
					XoahetDuLieutrenTable();
					for(NhanVien nv:listNV) {
						modelNhanVien.addRow(new Object[] {nv.getMaNV(),nv.getTenNV(),nv.getNgaySinh(),nv.getDiaChi(),nv.getSdt(),nv.getEmail(),nv.getCmnd()});
					}
				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, "Lỗi");
					DocDuLieutrenSQL();
				}
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên");
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1.setBounds(362, 145, 99, 25);
		pnlThongTinNV.add(lblNewLabel_1);
		
		JLabel lblCmndcccd = new JLabel("CMND/CCCD ");
		lblCmndcccd.setForeground(SystemColor.textHighlight);
		lblCmndcccd.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblCmndcccd.setBounds(362, 105, 110, 25);
		pnlThongTinNV.add(lblCmndcccd);
		
		txtCMND = new JTextField();
		txtCMND.setColumns(10);
		txtCMND.setBounds(459, 105, 200, 25);
		pnlThongTinNV.add(txtCMND);
		
		
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.setBackground(new Color(255, 99, 71));
		btnThoat.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnThoat.setBounds(835, 142, 115, 30);
		pnlThongTinNV.add(btnThoat);
		
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangChu tc = new TrangChu();
				tc.setVisible(true);
//				setVisible(false);
				frame.setVisible(false);
			}
		});
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setForeground(SystemColor.window);
		btnLamMoi.setBackground(SystemColor.textHighlight);
		btnLamMoi.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnLamMoi.setBounds(834, 85, 115, 30);
		pnlThongTinNV.add(btnLamMoi);
		
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoahetDuLieutrenTable();
				DocDuLieutrenSQL();
			}
		});
		ArrayList<NhanVien> listnv = nv_bus.getallNhanVien();
		for(NhanVien nv:listnv) {
			cboMaNV.addItem(nv.getMaNV());
		}
		
		JPanel pnlDanhSachNV = new JPanel();
		pnlDanhSachNV.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlDanhSachNV.setBackground(SystemColor.menu);
		pnlDanhSachNV.setBounds(10, 304, 980, 386);
		frame.getContentPane().add(pnlDanhSachNV);
		pnlDanhSachNV.setLayout(null);
		
		String [] header = "Mã nhân viên;Tên nhân viên;Ngày sinh;Địa chỉ;Số điện thoại;Email;CMND/CCCD".split(";");
		modelNhanVien = new DefaultTableModel(header, 0);
		JScrollPane scroll = new JScrollPane(table = new JTable(modelNhanVien));
		JViewport viewport = scroll.getViewport();
		viewport.setBackground(Color.WHITE);
		scroll.setSize(960, 343);
		scroll.setLocation(10, 26);
		pnlDanhSachNV.add(scroll);
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				txtMaNV.setText(table.getValueAt(row, 0).toString());
				txtHoTen.setText(table.getValueAt(row, 1).toString());
				try {
					dateNgSinh.setDate((Date)table.getValueAt(row, 2));
				} catch (Exception e2) {
					// TODO: handle exception
					 String dateString = table.getValueAt(row, 2).toString();
					 SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
					    try {
					    	java.util.Date utilDate = outputFormat.parse(dateString);
					    	java.sql.Date sqldate = new java.sql.Date(utilDate.getTime());
					    	dateNgSinh.setDate(sqldate);
					    	
					    } catch (ParseException e1) {
					        // Handle the exception
					    }
				} 
				txtDiaChi.setText(table.getValueAt(row, 3).toString());
				txtSDT.setText(table.getValueAt(row, 4).toString());
				txtEmail.setText(table.getValueAt(row, 5).toString());
				txtCMND.setText(table.getValueAt(row, 6).toString());
			}
		});
		
		JPanel pnlTitile = new JPanel();
		pnlTitile.setLayout(null);
		pnlTitile.setBorder(null);
		pnlTitile.setBackground(SystemColor.scrollbar);
		pnlTitile.setBounds(10, 0, 980, 75);
		frame.getContentPane().add(pnlTitile);
		
		JLabel lblTitle = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblTitle.setForeground(SystemColor.window);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblTitle.setBackground(SystemColor.scrollbar);
		lblTitle.setBounds(0, 0, 970, 75);
		pnlTitile.add(lblTitle);
		
		DocDuLieutrenSQL();
	}
	
		protected void setVisible(boolean b) {}

	private void XoahetDuLieutrenTable() {
		DefaultTableModel md = (DefaultTableModel)table.getModel();
		md.getDataVector().removeAllElements();
	}
	private void DocDuLieutrenSQL() {
		List<NhanVien> list = nv_bus.getallNhanVien();
		if(modelNhanVien==null) {
			JOptionPane.showMessageDialog(null, "modelNhanVien không tồn tại");
			return;
		}
		for(NhanVien nv:list) {
			modelNhanVien.addRow(new Object[] {nv.getMaNV(),nv.getTenNV(),nv.getNgaySinh(),nv.getDiaChi(),nv.getSdt(),nv.getEmail(),nv.getCmnd()});
		}
	}

	private void Them() {
//		String maNV = txtMaNV.getText();
		String maNV = getMaNV();
		String tenNV = txtHoTen.getText();
		java.util.Date ngaysinh = dateNgSinh.getDate();
		java.sql.Date ngsinh=  new java.sql.Date(ngaysinh.getTime());
		String diaChi = txtDiaChi.getText();
		String sdt = txtSDT.getText();
		String email = txtEmail.getText();
		String cmnd = txtCMND.getText();
		
		NhanVien nv = new NhanVien(maNV, tenNV, ngsinh, diaChi, sdt, email, cmnd);
		
		try {
			nv_bus.create(nv);
			String[] dataRow = {nv.getMaNV(), nv.getTenNV(), nv.getNgaySinh().toString(), nv.getDiaChi(), nv.getSdt(), nv.getEmail(), nv.getCmnd()};
			modelNhanVien.addRow(dataRow);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Trùng mã!");
		}
	}
	
	private String getMaNV() {
		int maCuoi = Integer.parseInt(nv_cre.getfivemacuoiNV());
		String maNV = "NV";
		String maCuoiNV = String.valueOf(maCuoi+1);
		int numZero = 3 - maCuoiNV.length();
		for (int i = 0; i < numZero; i++)
		{
			maNV += "0";
		}
		maNV += maCuoiNV;
		return maNV; 
	}
	
	private boolean KiemTraDuLieu() {
		String tenNV = txtHoTen.getText().trim();
		String diaChi = txtDiaChi.getText().trim();
		String sdt = txtSDT.getText().trim();
		String email = txtEmail.getText().trim();
		String cmnd = txtCMND.getText().trim();
		
		// Họ tên của NHÂN VIÊN là dãy kí tự không rỗng, không chứa số hay kí tự đặc biệt ^[\\p{L}' ]+$
		if (!(tenNV.length() > 0 && tenNV.matches("^[\\p{L}' ]+$"))) {
			JOptionPane.showMessageDialog(null, "Lỗi! Họ tên của nhân viên không được để trống, không chứa kí số hay kí tự đặc biệt!");
			txtHoTen.requestFocus();
			return false;
		}
		if (!(diaChi.length()>0 && diaChi.matches("^[\\p{L}0-9' ,]+$"))) {
			JOptionPane.showConfirmDialog(null, "Lỗi! Địa chỉ không được để trống và không chứa kí tự đặc biệt");
			txtDiaChi.requestFocus();
			return false;
		}
		if (!(sdt.length() > 0 && sdt.matches("^(03|05|07|08|09)[0-9]{8}$"))) {
			JOptionPane.showMessageDialog(null, "Lỗi! Số điện thoại chứa 10 kí số và không được để trống!");
			txtSDT.requestFocus();
			return false;
		}
		if (!(email.length() > 0 && email.matches("^\\w(@gmail.com)$"))) {
			JOptionPane.showMessageDialog(null, "Lỗi! Email rỗng hoặc không đúng định dạng!");
			txtEmail.requestFocus();
			return false;
		}
		if (!(cmnd.length() > 0 && cmnd.matches("^0[0-9]{1}[0-9]{1}[0-9]{9}$"))) {
			JOptionPane.showMessageDialog(null, "Lỗi! CMND/CCCD rỗng hoặc không đúng định dạng!");
			return false;
		}
		return true;
	}
}
