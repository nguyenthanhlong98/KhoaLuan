package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import enity.NhanVien;
import enity.TaiKhoan;
import javax.swing.JScrollBar;
import javax.swing.JTree;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;

public class GUIPhieuKhamBenh extends JFrame implements MouseListener,ActionListener{

	private JPanel contentPane;
	private JComponent menuBar;
	private JMenu mnFile;
	private JMenu mnEdit;
	private JMenu mnHelp;
	
	private TaiKhoan mTaiKhoan;
	private NhanVien mNhanVien;
	private JPanel Jpanel_1;
	private JLabel lbldiaChiBN;
	private JTextField txtdiaChiBN;
	
	private JTextField txthoTenBN;
	private JRadioButton radnamBN;
	private JRadioButton radnuBN;
	private JTextField txtemailBN;
	private JLabel lblmaBN;

 
	private JPanel panel;
	/**
	 * Create the frame.
	 */
	public GUIPhieuKhamBenh(TaiKhoan taikhoan,NhanVien nhanvien) {
		this.mTaiKhoan=taikhoan;
		this.mNhanVien=nhanvien;
		setTitle("Phiếu khám bệnh");
		setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1177, 700);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmngXut = new JMenuItem("Đăng Xuất");
		mnFile.add(mntmngXut);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHpngBn = new JLabel("Phiếu Khám Bệnh");
		lblHpngBn.setBounds(371, 0, 325, 48);
		lblHpngBn.setHorizontalAlignment(SwingConstants.CENTER);
		lblHpngBn.setFont(new Font("Tahoma", Font.PLAIN, 32));
		contentPane.add(lblHpngBn);
		
		
		
		Jpanel_1 = new JPanel();
		Jpanel_1.setBounds(28, 59, 1104, 125);
		contentPane.add(Jpanel_1);
		Jpanel_1.setBackground(SystemColor.inactiveCaptionBorder);
		Jpanel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thông tin bệnh nhân", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Jpanel_1.setLayout(null);
		
		JLabel lblEmailBN = new JLabel("Email :");
		
		lblEmailBN.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblEmailBN.setBounds(623, 30, 86, 20);
				Jpanel_1.add(lblEmailBN);
				
				txtemailBN = new JTextField();
				txtemailBN.setFont(new Font("Tahoma", Font.PLAIN, 11));
				txtemailBN.setColumns(10);
				txtemailBN.setUI(new HintTextFieldUI("					Nhập email . VD: duyvien159@gmail.com", true, Color.GRAY));
				txtemailBN.setBounds(742, 30, 268, 20);
				txtemailBN.setEnabled(false);
				Jpanel_1.add(txtemailBN);
				
				JLabel lblgioiTinhBN = new JLabel("Giới tính:");
				lblgioiTinhBN.setBounds(33, 90, 86, 20);
				Jpanel_1.add(lblgioiTinhBN);
				lblgioiTinhBN.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JLabel lblhoTenBN = new JLabel("Họ tên: ");
				lblhoTenBN.setBounds(33, 60, 86, 20);
				Jpanel_1.add(lblhoTenBN);
				lblhoTenBN.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				txthoTenBN = new JTextField();
				txthoTenBN.setBounds(152, 61, 268, 20);
				txthoTenBN.setEnabled(false);
				Jpanel_1.add(txthoTenBN);
				txthoTenBN.setUI(new HintTextFieldUI("					Nhập họ tên bệnh nhân. VD: Nguyễn Văn B", true, Color.GRAY));
				txthoTenBN.setFont(new Font("Tahoma", Font.PLAIN, 11));
				txthoTenBN.setColumns(10);
				
				
				radnamBN = new JRadioButton("Nam");
				radnamBN.setBounds(152, 90, 59, 23);
				radnamBN.setEnabled(false);
				Jpanel_1.add(radnamBN);
				radnamBN.setBackground(SystemColor.inactiveCaptionBorder);
				radnamBN.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(radnamBN.isSelected())
						{
							radnuBN.setSelected(false);
						}
						
					}
				});
				radnamBN.setFont(new Font("Tahoma", Font.PLAIN, 11));
				radnamBN.setSelected(true);
				
				
				
				radnuBN = new JRadioButton("Nữ");
				radnuBN.setBounds(228, 90, 70, 23);
				radnuBN.setEnabled(false);
				Jpanel_1.add(radnuBN);
				radnuBN.setBackground(SystemColor.inactiveCaptionBorder);
				radnuBN.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(radnuBN.isSelected())
						{
							radnamBN.setSelected(false);
						}
						
					}
				});
				
				
				txtdiaChiBN = new JTextField();
				txtdiaChiBN.setBounds(742, 61, 268, 20);
				Jpanel_1.add(txtdiaChiBN);
				txtdiaChiBN.setUI(new HintTextFieldUI("					Nhập địa chỉ khách hàng. VD: Bình Thuận", true, Color.GRAY));
				txtdiaChiBN.setFont(new Font("Tahoma", Font.PLAIN, 11));
				txtdiaChiBN.setColumns(10);
				txtdiaChiBN.setEnabled(false);
				
				lbldiaChiBN = new JLabel("Địa chỉ:");
				lbldiaChiBN.setBounds(623, 60, 86, 20);
				Jpanel_1.add(lbldiaChiBN);
				lbldiaChiBN.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				lblmaBN = new JLabel("Mã bệnh nhân :");
				lblmaBN.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblmaBN.setBounds(33, 30, 86, 20);
				Jpanel_1.add(lblmaBN);
				
				JComboBox comboBox = new JComboBox();
				comboBox.setBounds(152, 30, 268, 20);
				Jpanel_1.add(comboBox);
				
				
				
				
				
				panel = new JPanel();
				panel.setBackground(SystemColor.inactiveCaptionBorder);
				panel.setBorder(new TitledBorder(null, "Thông tin khám bệnh", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel.setBounds(28, 203, 1106, 167);
				contentPane.add(panel);
				panel.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("Triệu Chứng :");
				lblNewLabel.setBounds(38, 30, 91, 19);
				panel.add(lblNewLabel);
				
				JTextArea tatTrieuChung = new JTextArea();
				tatTrieuChung.setBounds(154, 27, 888, 70);
				panel.add(tatTrieuChung);
				
				JLabel lblNewLabel_2 = new JLabel("Trạng Thái :");
				lblNewLabel_2.setBounds(37, 118, 91, 19);
				panel.add(lblNewLabel_2);
				
				JRadioButton rdbhoanthanh = new JRadioButton("Đã hoàn thành");
				
				rdbhoanthanh.setBounds(153, 118, 128, 23);
				panel.add(rdbhoanthanh);
				
				JRadioButton rdbchuahoanthanh = new JRadioButton("Chưa hoàn thành");
				rdbchuahoanthanh.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (rdbchuahoanthanh.isSelected())
							rdbhoanthanh.setSelected(false);
						else
							rdbhoanthanh.setSelected(true);
					}
				});
				rdbchuahoanthanh.setBounds(337, 118, 143, 23);
				rdbchuahoanthanh.setSelected(true);
				panel.add(rdbchuahoanthanh);
				
				rdbhoanthanh.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (rdbhoanthanh.isSelected())
							rdbchuahoanthanh.setSelected(false);
						else
							rdbchuahoanthanh.setSelected(true);
					}
				});
				
				
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBorder(new TitledBorder(null, "Kết quả khám bệnh", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBackground(SystemColor.inactiveCaptionBorder);
				panel_1.setBounds(26, 393, 1106, 108);
				contentPane.add(panel_1);
				
				JLabel lblNewLabel_1 = new JLabel("Chẩn đoán  :");
				lblNewLabel_1.setBounds(33, 30, 109, 19);
				panel_1.add(lblNewLabel_1);
				
				JTextArea tatChanDoan = new JTextArea();
				tatChanDoan.setBounds(152, 27, 889, 65);
				panel_1.add(tatChanDoan);
				
				JButton btnhuy = new JButton("Quay Lại");
				btnhuy.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnhuy.setBounds(977, 528, 155, 57);
				contentPane.add(btnhuy);
				
				JButton btnluu = new JButton("Lưu");
				btnluu.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnluu.setBounds(767, 528, 155, 57);
				contentPane.add(btnluu);
				
			
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
