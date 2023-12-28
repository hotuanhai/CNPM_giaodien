
package view.admin;
import java.sql.*;

import controller.AdminListener;
import dao.NhanKhauDAO;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import model.NhanKhau;
//import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;

public class InputNhanKhau extends JFrame{
    private NhanKhau nk;
    private JTextField jTextField_ten;
    private JTextField jTextField_ngaysinh;
    private JTextField jTextField_note;
    private JTextField jTextField_qh;
    private JTextField jTextField_mahk;
    private JTextField jTextField_bidanh;
    private JTextField jTextField_gioitinh;
    private JTextField jTextField_dt;
    private JTextField jTextField_que;
    private JTextField jTextField_tongiao;
    private JTextField jTextField_nghe;
    private JTextField jTextField_noilam;
    private JTextField jTextField_cccd;
    private JTextField jTextField_ngaycap;
    private JTextField jTextField_noicap;
    private JTextField jTextField_ttt;
//    private JTextField jTextField_ngaychuyen;
    public InputNhanKhau(){
        this.setSize(800, 800); // Set the size to 800x600
        this.setLocationRelativeTo(null);
        Font font = new Font("Arial", Font.BOLD, 16);
        
        this.nk = new NhanKhau();
        
         JLabel jLabel_ten = createCenteredLabel("Tên:", font);
        JLabel jLabel_ngaysinh = createCenteredLabel("Ngày sinh:", font);
        JLabel jLabel_note = createCenteredLabel("Ghi chú:", font);
        JLabel jLabel_qh = createCenteredLabel("Quan hệ:", font);
        JLabel jLabel_mahk = createCenteredLabel("Mã hộ khẩu:", font);
        JLabel jLabel_bidanh = createCenteredLabel("Bí danh:", font);
        JLabel jLabel_gioitinh = createCenteredLabel("Giới tính:", font);
        JLabel jLabel_dt = createCenteredLabel("Dân tộc:", font);
        JLabel jLabel_que = createCenteredLabel("Quê quán:", font);
        JLabel jLabel_tongiao = createCenteredLabel("Tôn giáo:", font);
        JLabel jLabel_nghe = createCenteredLabel("Nghề nghiệp:", font);
        JLabel jLabel_noilam = createCenteredLabel("Nơi làm:", font);
        JLabel jLabel_cccd = createCenteredLabel("CCCD:", font);
        JLabel jLabel_ngaycap = createCenteredLabel("Ngày cấp:", font);
        JLabel jLabel_noicap = createCenteredLabel("Nơi cấp:", font);
        JLabel jLabel_ttt = createCenteredLabel("Nơi thường trú trước:", font);
//        JLabel jLabel_ngaychuyen = new JLabel("Ngay chuyen");
//	jLabel_ngaychuyen.setFont(font);
        
        jTextField_ten = new JTextField(50);
	//jTextField_ten.setFont(font);
	jTextField_ngaysinh = new JTextField(50);
	//jTextField_ngaysinh.setFont(font);
	jTextField_note = new JTextField(50);
	//jTextField_note.setFont(font);        
        jTextField_qh = new JTextField(50);
	//jTextField_qh.setFont(font);
	jTextField_mahk = new JTextField(50);
	//jTextField_mahk.setFont(font);
	jTextField_bidanh = new JTextField(50);
	//jTextField_bidanh.setFont(font); 
        jTextField_gioitinh = new JTextField(50);
	//jTextField_gioitinh.setFont(font);
	jTextField_dt = new JTextField(50);
	//jTextField_dt.setFont(font);
	jTextField_que = new JTextField(50);
	//jTextField_que.setFont(font);        
        jTextField_tongiao = new JTextField(50);
	//jTextField_tongiao.setFont(font);
	jTextField_nghe = new JTextField(50);
	//jTextField_nghe.setFont(font);
	jTextField_noilam = new JTextField(50);
	//jTextField_noilam.setFont(font);
        jTextField_cccd = new JTextField(50);
	//jTextField_cccd.setFont(font);
	jTextField_ngaycap = new JTextField(50);
	//jTextField_ngaycap.setFont(font);
	jTextField_noicap = new JTextField(50);
	//jTextField_noicap.setFont(font);
        jTextField_ttt = new JTextField(50);
	//jTextField_ttt.setFont(font);
//	jTextField_ngaychuyen = new JTextField(50);
//	jTextField_ngaychuyen.setFont(font);
        ActionListener ac = new AdminListener(this);
	JButton jb = new JButton("thêm");
        jb.setFont(font);
        jb.addActionListener(ac);
        JButton btn_xemNK = new JButton("Xem nhân khẩu");
        btn_xemNK.addActionListener(ac);
        
        JPanel jPanelIO = new JPanel();
	jPanelIO.setLayout(new GridLayout(18, 2, 2, 10));
        jPanelIO.add(jLabel_ten); jPanelIO.add(jTextField_ten);
        jPanelIO.add(jLabel_ngaysinh); jPanelIO.add(jTextField_ngaysinh);
        jPanelIO.add(jLabel_note); jPanelIO.add(jTextField_note);
        jPanelIO.add(jLabel_qh); jPanelIO.add(jTextField_qh);
        jPanelIO.add(jLabel_mahk); jPanelIO.add(jTextField_mahk);
        jPanelIO.add(jLabel_bidanh); jPanelIO.add(jTextField_bidanh);
        jPanelIO.add(jLabel_gioitinh); jPanelIO.add(jTextField_gioitinh);
        jPanelIO.add(jLabel_dt); jPanelIO.add(jTextField_dt);
        jPanelIO.add(jLabel_que); jPanelIO.add(jTextField_que);
        jPanelIO.add(jLabel_tongiao); jPanelIO.add(jTextField_tongiao);
        jPanelIO.add(jLabel_nghe); jPanelIO.add(jTextField_nghe);
        jPanelIO.add(jLabel_noilam); jPanelIO.add(jTextField_noilam);
        jPanelIO.add(jLabel_cccd); jPanelIO.add(jTextField_cccd);
        jPanelIO.add(jLabel_ngaycap); jPanelIO.add(jTextField_ngaycap);
        jPanelIO.add(jLabel_noicap); jPanelIO.add(jTextField_noicap);
        jPanelIO.add(jLabel_ttt); jPanelIO.add(jTextField_ttt);
        jPanelIO.add(btn_xemNK);
        jPanelIO.add(jb);
//        jPanelIO.add(jLabel_ngaychuyen); jPanelIO.add(jTextField_ngaychuyen);
        
        
        //JScrollPane js = new JScrollPane(jPanelIO, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //this.nk.setTen(jTextField_ten.getText());
        //System.out.println(this.nk.getTen());
        
        
        
        

        this.setLayout(new BorderLayout(10, 10));
	this.add(jPanelIO, BorderLayout.CENTER);
       // this.add(jb,BorderLayout.SOUTH);
        
        this.setVisible(true);
    }
    public void them(){
        this.nk.setTen(jTextField_ten.getText());
        
        // Extract the text from jTextField_ngaysinh
        String ngaySinhText = jTextField_ngaysinh.getText();
        // Parse the text into a java.util.Date      
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = null;
        try {
            utilDate = dateFormat.parse(ngaySinhText);
        } catch (ParseException ex) {
            Logger.getLogger(InputNhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Convert java.util.Date to java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        this.nk.setNgaySinh(sqlDate);

        this.nk.setNote(jTextField_note.getText());
        this.nk.setQuanHe(jTextField_note.getText());
        this.nk.setMa_hk(jTextField_mahk.getText());
        this.nk.setBiDanh(jTextField_bidanh.getText());
        String gioitinh =  jTextField_gioitinh.getText();
        
        try {
            int gioiTinh = Integer.parseInt(jTextField_gioitinh.getText());
            this.nk.setGioiTinh(gioiTinh);
        } catch (NumberFormatException nfe) {
            // Handle the case where the input is not a valid integer
            nfe.printStackTrace();
            }
           
           
            this.nk.setDanToc(jTextField_dt.getText());
            this.nk.setQueQuan(jTextField_que.getText());
            this.nk.setTonGiao(jTextField_tongiao.getText());
            this.nk.setNgheNghiep(jTextField_nghe.getText());
            this.nk.setNoiLam(jTextField_noilam.getText());
            this.nk.setCccd(jTextField_cccd.getText());
            
            ngaySinhText = jTextField_ngaycap.getText();     
            utilDate = null;
            try {
            utilDate = dateFormat.parse(ngaySinhText);
            } catch (ParseException ex) {
            Logger.getLogger(InputNhanKhau.class.getName()).log(Level.SEVERE, null, ex);
            }
            sqlDate = new java.sql.Date(utilDate.getTime());
            this.nk.setNgayCap(sqlDate);
            
            this.nk.setNoiCap(jTextField_noicap.getText());
            this.nk.setNoiTTTruoc(jTextField_ttt.getText());
            
//            ngaySinhText = jTextField_ngaychuyen.getText();     
//            java.util.Date utilDate1 = null;
//            if(!ngaySinhText.equals("") ){
//            
//            try {
//            utilDate1 = dateFormat.parse(ngaySinhText);
//            } catch (ParseException ex) {
//            Logger.getLogger(InputNhanKhau.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            sqlDate = new java.sql.Date(utilDate1.getTime());
//            this.nk.setNgaychuyen(sqlDate);
//            }
            
            System.out.println(this.nk.getTen());
            System.out.println(this.nk.getNgaySinh());
            System.out.println(this.nk.getNote());
            System.out.println(nk.toString());
            
            NhanKhauDAO.getInstance().insert(nk);
    }
    private JLabel createCenteredLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }
}
