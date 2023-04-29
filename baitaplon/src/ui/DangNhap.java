package ui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JSlider;
import java.awt.Canvas;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.SwingConstants;

public class DangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JTextField txtMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
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
	public DangNhap() {
		setBackground(new Color(255, 255, 255));
		setTitle("ĐĂNG NHẬP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 437);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(null);
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(SystemColor.window);
		panel.setBounds(10, 23, 323, 371);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTaiKhoan = new JLabel("Tài khoản :");
		lblTaiKhoan.setForeground(SystemColor.textHighlight);
		lblTaiKhoan.setBounds(32, 68, 107, 32);
		panel.add(lblTaiKhoan);
		lblTaiKhoan.setFont(new Font("Segoe UI", Font.BOLD, 16));
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBounds(32, 110, 260, 25);
		panel.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		txtTaiKhoan.setText("admin");
		JLabel lblMatKhau = new JLabel("Mật khẩu :");
		lblMatKhau.setForeground(SystemColor.textHighlight);
		lblMatKhau.setBounds(32, 145, 107, 32);
		panel.add(lblMatKhau);
		lblMatKhau.setFont(new Font("Segoe UI", Font.BOLD, 16));
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(32, 187, 260, 25);
		panel.add(txtMatKhau);
		txtMatKhau.setColumns(10);
		txtMatKhau.setText("admin");
		JButton btnDangNhap = new JButton("ĐĂNG NHẬP");
		btnDangNhap.setBackground(SystemColor.activeCaption);
		btnDangNhap.setForeground(new Color(255, 255, 255));
		btnDangNhap.setBounds(102, 251, 110, 30);
		panel.add(btnDangNhap);
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tk = txtTaiKhoan.getText();
				String mk = txtMatKhau.getText();
				if(tk.equals("admin") && mk.equals("admin")){
					JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
					TrangChu tc = new TrangChu();
					tc.setVisible(true);
					setVisible(false);
					
				}
				else if(!(tk.equals("admin")) && mk.equals("admin")) {
					JOptionPane.showMessageDialog(null, "Sai tên đăng nhập");
				}
				else if((tk.equals("admin")) && !(mk.equals("admin"))){
					JOptionPane.showMessageDialog(null, "Sai mật khẩu");
				}
				else {
					JOptionPane.showMessageDialog(null, "Sai tên đăng nhập và mật khẩu");
				}
			}
		});
		btnDangNhap.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel lblNewLabel_2 = new JLabel("ĐĂNG NHẬP");
		lblNewLabel_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBackground(SystemColor.textHighlight);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2.setBounds(10, 10, 303, 25);
		panel.add(lblNewLabel_2);
	}
}
