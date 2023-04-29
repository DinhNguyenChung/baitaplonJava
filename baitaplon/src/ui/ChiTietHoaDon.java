package ui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import bus.ChiTietHoaDon_BUS;
import bus.HoaDon_BUS;
import connectDB.ConnectDB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EtchedBorder;

public class ChiTietHoaDon {

	public JFrame frame;
	
	private static HoaDon_BUS hd_bus;
	private static ChiTietHoaDon_BUS cthd_bus;
	
	private static JTable table;
	private static DefaultTableModel model;
	
	
	
	
	private static JTextField txtMaHD;
	private static JTextField txtMaTour;
	private static JTextField txtSL;
	private static JTextField txtDG;
	private static JTextField txtTT;
	private static JTextField txtTongTien;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiTietHoaDon window = new ChiTietHoaDon();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChiTietHoaDon() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.scrollbar);
		frame.setBounds(100, 100, 681, 434);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		
		
		cthd_bus = new ChiTietHoaDon_BUS();
		hd_bus = new HoaDon_BUS();
		
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.scrollbar);
		panel.setBounds(10, 10, 661, 62);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHI TIẾT HÓA ĐƠN");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setBackground(SystemColor.activeCaptionBorder);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 641, 41);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(SystemColor.window);
		panel_1.setBounds(10, 71, 661, 347);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 640, 137);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				txtMaHD.setText(model.getValueAt(row, 0).toString());
				txtMaTour.setText(model.getValueAt(row, 1).toString());
				txtSL.setText(model.getValueAt(row, 2).toString());
				txtDG.setText(model.getValueAt(row, 3).toString());
				txtTT.setText(model.getValueAt(row, 4).toString());
			}
		});
		table.setModel( model =new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 H\u00F3a \u0110\u01A1n", "M\u00E3 Tour", "S\u1ED1 l\u01B0\u1EE3ng Kh\u00E1ch", "\u0110\u01A1n Gi\u00E1", "Th\u00E0nh Ti\u1EC1n"
			}
		));
		scrollPane.setViewportView(table);
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã Khách Hàng");
		lblNewLabel_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(10, 16, 120, 14);
		panel_1.add(lblNewLabel_1_1);
		
		txtMaHD = new JTextField();
		txtMaHD.setHorizontalAlignment(SwingConstants.CENTER);
		txtMaHD.setColumns(10);
		txtMaHD.setBounds(10, 40, 120, 28);
		panel_1.add(txtMaHD);
		txtMaHD.setEditable(false);
		
		txtMaTour = new JTextField();
		txtMaTour.setHorizontalAlignment(SwingConstants.CENTER);
		txtMaTour.setColumns(10);
		txtMaTour.setBounds(140, 40, 120, 28);
		panel_1.add(txtMaTour);
		txtMaTour.setEditable(false);
		
		txtSL = new JTextField();
		txtSL.setHorizontalAlignment(SwingConstants.CENTER);
		txtSL.setColumns(10);
		txtSL.setBounds(270, 40, 120, 28);
		panel_1.add(txtSL);
		txtSL.setEditable(false);
		
		txtDG = new JTextField();
		txtDG.setHorizontalAlignment(SwingConstants.CENTER);
		txtDG.setColumns(10);
		txtDG.setBounds(400, 40, 120, 28);
		panel_1.add(txtDG);
		txtDG.setEditable(false);
		
		txtTT = new JTextField();
		txtTT.setHorizontalAlignment(SwingConstants.CENTER);
		txtTT.setColumns(10);
		txtTT.setBounds(530, 40, 120, 28);
		panel_1.add(txtTT);
		txtTT.setEditable(false);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Mã Tour");
		lblNewLabel_1_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(140, 16, 120, 14);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Số lượng Khách");
		lblNewLabel_1_1_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_1_2.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setBounds(270, 16, 120, 14);
		panel_1.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Đơn Giá");
		lblNewLabel_1_1_3.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_1_3.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3.setBounds(400, 16, 120, 14);
		panel_1.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Thành Tiền");
		lblNewLabel_1_1_4.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_1_4.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_4.setBounds(530, 16, 115, 14);
		panel_1.add(lblNewLabel_1_1_4);
		
		JButton btnThoat = new JButton("QUAY LẠI ");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatTour dt = new DatTour();
				dt.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnThoat.setBackground(SystemColor.textHighlight);
		btnThoat.setBounds(551, 274, 100, 25);
		panel_1.add(btnThoat);
		
		txtTongTien = new JTextField();
		txtTongTien.setHorizontalAlignment(SwingConstants.CENTER);
		txtTongTien.setEditable(false);
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(10, 275, 120, 25);
		panel_1.add(txtTongTien);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("Tổng tiền");
		lblNewLabel_1_1_5.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_1_5.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_5.setBounds(10, 254, 120, 14);
		panel_1.add(lblNewLabel_1_1_5);
//		DocDuLieuTrenTable();
	}
	public void HienTableTheoMaHD(String ma) {
		ArrayList<entity.ChiTietHoaDon> list = cthd_bus.getCTHoaDonTheoMaHD(ma);
		for(entity.ChiTietHoaDon ct:list) {
			txtMaHD.setText(ct.getMaHD().getMaHD());
			txtMaTour.setText(ct.getMaTour().getMaTour());
			txtSL.setText(String.valueOf(ct.getSoLuongKhach()));
			txtDG.setText(String.valueOf(ct.getDonGia()));
			txtTT.setText(String.valueOf(ct.getThanhTien()));
			model.addRow(new Object[] {
					ct.getMaHD().getMaHD(),ct.getMaTour().getMaTour(),ct.getSoLuongKhach(),ct.getDonGia(),ct.getThanhTien()
			} );
		}
	}
	
	public void showTongTien(String ma) {
		ArrayList<entity.HoaDon> dshd = hd_bus.getHoaDonTheoMaHD(ma);
		for(entity.HoaDon hd : dshd) {
			DecimalFormat x = new DecimalFormat("###,###,###");
			txtTongTien.setText(x.format(hd.getTongTien()));
		}
	}
	
	public class MyTableCellRenderer extends DefaultTableCellRenderer {
	    @Override
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	        c.setBackground(Color.LIGHT_GRAY);
	        return c;
	    }
	}
}
