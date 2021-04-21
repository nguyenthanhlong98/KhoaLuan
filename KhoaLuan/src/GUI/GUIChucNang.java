package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import enity.NhanVien;
import enity.TaiKhoan;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;

public class GUIChucNang extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnbutton;
	private JButton btnbutton1;
	private JButton btnbutton2;
	private JButton btnbutton3;
	private JButton btnbutton4;
	private JButton btnbutton5;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmdangXuat;
	private JMenuItem mntmThoat;
	
	//
	NhanVien mNhanVien;
	TaiKhoan mTaiKhoan;
	
	private JButton btnxhd;
	private JLabel lblChucVu;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	
	public GUIChucNang(TaiKhoan taikhoan,NhanVien nhanvien) {
		this.mTaiKhoan=taikhoan;
		this.mNhanVien=nhanvien;
		intform();
		
	}
	
		

	public void intform() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));
		setTitle("Hệ thống chức năng");
		setBounds(100, 100, 1177, 700);
		setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmdangXuat = new JMenuItem("Đăng Xuất");
		mnFile.add(mntmdangXuat);
		
		mntmThoat = new JMenuItem("Thoát");
		mnFile.add(mntmThoat);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Hệ Thống Chức Năng");
		label.setBounds(450, 11, 328, 49);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.BOLD, 32));
		contentPane.add(label);
		
		JLabel lblten = new JLabel("Tên: ");
		lblten.setBounds(884, 52, 105, 29);
		lblten.setForeground(Color.BLACK);
		lblten.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblten);
		
		JLabel lblloaiNhanVien = new JLabel("Chức Vụ: ");
		lblloaiNhanVien.setBounds(884, 79, 105, 29);
		lblloaiNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblloaiNhanVien);
		
		btnbutton = new JButton("Quản Lí Nhân Viên");
		btnbutton.setIcon(new ImageIcon("travel_management.png"));
		btnbutton.setBounds(67, 128, 275, 100);
		btnbutton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		contentPane.add(btnbutton);
		
		btnbutton1 = new JButton("Quản Lí Bệnh Nhân");
		btnbutton1.setIcon(new ImageIcon("travel_management.png"));
		btnbutton1.setBounds(395, 128, 275, 100);
		btnbutton1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	
		contentPane.add(btnbutton1);
		
		btnbutton3 = new JButton("Lập Phiếu Khám");
		btnbutton3.setIcon(new ImageIcon("default_document.png"));
		btnbutton3.setBounds(395, 296, 275, 100);
		btnbutton3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnbutton3);
		
		btnbutton4 = new JButton("Lập Đơn Thuốc");
		btnbutton4.setIcon(new ImageIcon("default_document.png"));
		btnbutton4.setBounds(67, 296, 275, 100);
		btnbutton4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnbutton4);
		
		btnbutton5 = new JButton("Đổi Mật Khẩu");
		btnbutton5.setIcon(new ImageIcon("advancedsettings.png"));
		btnbutton5.setBounds(735, 296, 275, 100);
		btnbutton5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnbutton5);
		
		JLabel lblTen = new JLabel();
		lblTen.setBounds(973, 53, 144, 29);
		lblTen.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTen.setText(mNhanVien.getTen());
		contentPane.add(lblTen);
		
		
		btnxhd = new JButton("Lập Hóa Đơn");
		btnxhd.setIcon(new ImageIcon("efault_document.png"));
		btnxhd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnxhd.setBounds(735, 128, 275, 100);
		contentPane.add(btnxhd);
		
		lblChucVu = new JLabel();
		lblChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblChucVu.setBounds(984, 79, 144, 29);
		lblChucVu.setText(mTaiKhoan.getRole().getName());
		contentPane.add(lblChucVu);
		
		btnbutton5.addActionListener(this);
		btnbutton.addActionListener(this);
		btnbutton4.addActionListener(this);
		btnbutton3.addActionListener(this);
		btnbutton1.addActionListener(this);
		btnxhd.addActionListener(this);
		mntmdangXuat.addActionListener(this);
		mntmThoat.addActionListener(this);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		 if(o==btnbutton1)
		{
			dispose();
			GUIThongTinBenhNhan ft= new GUIThongTinBenhNhan(mTaiKhoan,mNhanVien);
			ft.setVisible(true);
		}
		 if(o==mntmdangXuat) 
		 {
			 dispose();
			 GUIDangNhap dn= new GUIDangNhap();
			 dn.setVisible(true);
		 }
		 if(o==btnbutton5) 
		 {
			 dispose();
			 GUIDoiMatKhau dmk= new GUIDoiMatKhau(mTaiKhoan,mNhanVien);
			 dmk.setVisible(true);
		 }
		 if(o==btnbutton) 
		 {
			 dispose();
			 GUIThongTinNhanVien nv= new GUIThongTinNhanVien(mTaiKhoan,mNhanVien);
			 nv.setVisible(true);
		 }
		 if(o==btnbutton3) 
		 {
			 dispose();
			 GUIPhieuKhamBenh nv= new GUIPhieuKhamBenh(mTaiKhoan,mNhanVien);
			 nv.setVisible(true);
		 }
	}
}
