package ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.Hoadon_DAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;

public class ThongKeDoanhThu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKeDoanhThu frame = new ThongKeDoanhThu();
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
	private ArrayList<entity.HoaDon> listHD;
	private DefaultTableModel model;
	private JTable table;
	private JTextField txtTongDT = new JTextField();
	private JDateChooser txtNgayLap;

	private Hoadon_DAO hdDao = new Hoadon_DAO();
	public ThongKeDoanhThu() {
		getContentPane().setFont(new Font("Segoe UI", Font.BOLD, 13));
		getContentPane().setBackground(SystemColor.scrollbar);
		setBackground(SystemColor.window);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 646);
		getContentPane().add(panel);
		panel.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		
		JLabel lblNewLabel = new JLabel("THỐNG KÊ DOANH THU");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 5, 446, 51);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 27));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.window);
		panel_1.setBounds(18, 153, 445, 435);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 0, 445, 435);
		panel_1.add(scrollPane);
		
		//Khởi tạo kết nối đến cơ sở dữ liệu:
				try {
					ConnectDB.getInstance().connect();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		table = new JTable();
		table.setBorder(null);
		table.setBackground(SystemColor.window);
		table.setModel(model = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 h\u00F3a \u0111\u01A1n", "Ng\u00E0y l\u1EADp", "T\u1ED5ng ti\u1EC1n"
			}
		));
		table.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		scrollPane.setViewportView(table);
		showTable();
		tong();
		JLabel lblNewLabel_1 = new JLabel("Tổng doanh thu :");
		lblNewLabel_1.setForeground(new Color(255, 99, 71));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 605, 125, 20);
		getContentPane().add(lblNewLabel_1);
		
		txtTongDT = new JTextField();
		txtTongDT.setForeground(SystemColor.inactiveCaptionText);
		txtTongDT.setFont(new Font("Segoe UI", Font.BOLD, 13));
		txtTongDT.setBackground(SystemColor.window);
		txtTongDT.setBounds(145, 605, 153, 20);
		getContentPane().add(txtTongDT);
		txtTongDT.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.scrollbar);
		panel_2.setBounds(20, 10, 443, 51);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("THỐNG KÊ DOANH THU");
		lblNewLabel_3.setForeground(SystemColor.window);
		lblNewLabel_3.setBackground(SystemColor.window);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel_3.setBounds(0, 0, 433, 50);
		panel_2.add(lblNewLabel_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.window);
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(20, 68, 443, 75);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Doanh thu theo ngày :");
		lblNewLabel_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_2.setBounds(68, 10, 139, 20);
		panel_3.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 11));
		
		txtNgayLap = new JDateChooser();
		txtNgayLap.setBounds(198, 10, 210, 20);
		panel_3.add(txtNgayLap);
		
			JButton btnNewButton = new JButton("Lọc");
			btnNewButton.setBackground(new Color(60, 179, 113));
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setBounds(114, 40, 95, 21);
			panel_3.add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Date Date = new java.sql.Date(txtNgayLap.getDate().getTime());
//				Date Date = txtNgayLap.getText();
						listHD = hdDao.getHoaDonTheoNgayLap(Date);
						model.setRowCount(0);
						for(entity.HoaDon hd : listHD) {
							model.addRow(new Object[] {
									hd.getMaHD(), hd.getNgayLap(), hd.getTongTien()
							});
						}
						tong();
					
				}
			});
			btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
			
			JButton btnLamMoi = new JButton("Làm mới");
			btnLamMoi.setBackground(SystemColor.textHighlight);
			btnLamMoi.setForeground(SystemColor.window);
			btnLamMoi.setBounds(225, 40, 95, 21);
			panel_3.add(btnLamMoi);
			btnLamMoi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//				txtNgayLap.setDate(new Date());
					showTable();
					
				}
			});
			btnLamMoi.setFont(new Font("Segoe UI", Font.BOLD, 13));
			
			JButton btnThoat = new JButton("Thoát");
			btnThoat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int select = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát?","Cảnh Báo",JOptionPane.YES_NO_OPTION);
					if(select == JOptionPane.YES_OPTION) {
						DatTour dt = new DatTour();
						dt.setVisible(true);
						dispose();
				}
				}});
			
			btnThoat.setForeground(Color.WHITE);
			btnThoat.setFont(new Font("Segoe UI", Font.BOLD, 13));
			btnThoat.setBackground(new Color(255, 69, 0));
			btnThoat.setBounds(378, 605, 85, 20);
			getContentPane().add(btnThoat);
	}
	private void tong() {
		// TODO Auto-generated method stub
		DecimalFormat x = new DecimalFormat("###,###,###");
		double tong = 0;
		for(int i=0; i < table.getRowCount();i++) {
			tong += Double.parseDouble(table.getValueAt(i, 2).toString());
		}
		
		txtTongDT.setText(x.format(tong));
	}
	private void showTable() {
		// TODO Auto-generated method stub
		listHD = hdDao.getAllHoaDon();
		model.setRowCount(0);
		for(entity.HoaDon hd : listHD) {
			model.addRow(new Object[] {
					hd.getMaHD(), hd.getNgayLap(), hd.getTongTien()
			});
		}
		
	}

}
