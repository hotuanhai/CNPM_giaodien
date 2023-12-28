/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.admin.thuphi;

import controller.AdminListener;
import dao.DongGopDAO;
import dao.NhanKhauDAO;
import database.JDBCUtil;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.DongGop;
import model.KhoanThu;

/**
 *
 * @author Admin
 */
public class DongGopView extends JFrame{
    private JTextField ma_donggopds,ma_donggop,ngay,sotien;
    private JTextField ma_hk;
    private JTextField tim_madg, tim_mahk;
    private DongGop dg;
    
    JTable jt;
    JScrollPane js;
    String[] col;
    DefaultTableModel tableModel;
    
    public DongGopView(){
        setTitle("Quản lý đóng góp");
        setSize(800, 600);
        setLocationRelativeTo(null);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ActionListener ac = new AdminListener(this);
        
        ma_donggopds = new JTextField(20);
        ma_donggop = new JTextField(20);
        ngay = new JTextField(20);
        sotien = new JTextField(20);
        ma_hk = new JTextField(20);
        
        tim_madg = new JTextField(20);
        tim_mahk = new JTextField(20);
        
        JButton themDongGop = new JButton("Thêm đóng góp");
        themDongGop.addActionListener(ac);
        JButton xemDongGop = new JButton("Xem đóng góp");
        xemDongGop.addActionListener(ac);
        JButton themDanhSach = new JButton("Thêm vào danh sách");
        themDanhSach.addActionListener(ac);
        JButton timDanhSach = new JButton("Tìm danh sách");
        timDanhSach.addActionListener(ac);
//        JButton xemDanhSach = new JButton("Xem danh sách");
//        xemDanhSach.addActionListener(ac);
        
        this.setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(7, 5));
        
        inputPanel.add(new JLabel("Thêm vào danh sách:"));  
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());
        
        inputPanel.add(new JLabel("Thêm mục đóng góp:"));  
        inputPanel.add(new JLabel());
        
        inputPanel.add(new JLabel("Mã đóng góp:"));          
        inputPanel.add(ma_donggopds);
        inputPanel.add(new JLabel());
        
        inputPanel.add(new JLabel("Mã đóng góp:"));          
        inputPanel.add(ma_donggop);
        
        inputPanel.add(new JLabel("Ngày:"));            
        inputPanel.add(ngay);
        inputPanel.add(new JLabel());

        inputPanel.add(xemDongGop);
        inputPanel.add(themDongGop);
        
        inputPanel.add(new JLabel("Mã hộ khẩu:"));            
        inputPanel.add(ma_hk);
        inputPanel.add(new JLabel());
        
        inputPanel.add(new JLabel("Tìm kiếm"));               
        inputPanel.add(new JLabel());
        
        inputPanel.add(new JLabel("Số tiền:"));            
        inputPanel.add(sotien);
        inputPanel.add(new JLabel());
        
        inputPanel.add(new JLabel("Mã hộ khẩu:"));
        inputPanel.add(tim_mahk);
        
        inputPanel.add(new JLabel());
        inputPanel.add(themDanhSach);
        inputPanel.add(new JLabel());
        
        inputPanel.add(new JLabel("Mã đóng góp:"));
        inputPanel.add(tim_madg);
        
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());
        inputPanel.add(timDanhSach);
        
        col = new String[]{"Mã đóng góp","Ngày đóng góp","Mã hộ khẩu","Số tiền"};
        tableModel = new DefaultTableModel(col, 0);
        jt = new JTable(tableModel);
        js = new JScrollPane(jt);
        xemDanhSach();
        
        
        this.add(js, BorderLayout.CENTER);
        this.add(inputPanel, BorderLayout.NORTH);
        setVisible(true);
    }
    public void themTenDongGop(){
        int kq=0;
        try {       
            Connection con = JDBCUtil.getConnection();
             String sql ="INSERT INTO TEN_DONGGOP(ma_donggop)"+ " VALUES(?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ma_donggop.getText());
            kq = st.executeUpdate();
            //System.out.println(sql);
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        };
    }
    
    public void bangTenDongGop(){
        new BangDongGop();
    }
    
    public void themDanhSach(){
         this.dg = new DongGop();
        this.dg.setMa_donggop(ma_donggopds.getText());
        this.dg.setMa_hk(ma_hk.getText());
         try {
            int tien = Integer.parseInt(sotien.getText());
            this.dg.setSotien(tien);
        } catch (NumberFormatException nfe) {
            // Handle the case where the input is not a valid integer
            nfe.printStackTrace();
        }
        String ngaythu = ngay.getText();  
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = null;
            try {
            utilDate = dateFormat.parse(ngaythu);
            } catch (ParseException ex) {
            
            }
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        this.dg.setNgay(sqlDate);
        System.out.println(dg);
        DongGopDAO.getInstance().insert(dg);
        xemDanhSach();
    }
    
    public void xemDanhSach(){
        tableModel.setRowCount(0); // Clear existing data
        ArrayList<DongGop> dg = DongGopDAO.getInstance().selectAll();
        for (int i = 0; i < dg.size(); i++) {
            String ma_dg = dg.get(i).getMa_donggop();
            java.sql.Date ngay = dg.get(i).getNgay();
            String ma_hk = dg.get(i).getMa_hk();
            int sotien = dg.get(i).getSotien();

            Object[] data = {ma_dg, ngay,ma_hk, sotien};
            tableModel.addRow(data);
        }
    }
    
    public void timDanhsach(){
        String madg = tim_madg.getText();
        if (madg.isEmpty()) {
            madg = null;
        }
        String mahk = tim_mahk.getText();
        if (mahk.isEmpty()) {
            mahk = null;
        }
        System.out.println(madg + " "+ mahk);
        ArrayList<DongGop> dg = DongGopDAO.getInstance().timkiem(madg, mahk);
        tableModel.setRowCount(0);
        for (int i = 0; i < dg.size(); i++) {
            String ma_dg = dg.get(i).getMa_donggop();
            java.sql.Date ngay = dg.get(i).getNgay();
            String ma_hk = dg.get(i).getMa_hk();
            int sotien = dg.get(i).getSotien();

            Object[] data = {ma_dg, ngay,ma_hk, sotien};
            tableModel.addRow(data);
        }
    }
}
