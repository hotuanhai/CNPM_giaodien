/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.admin.thuphi;

import controller.AdminListener;
import dao.HoKhauDAO;
import dao.KhoanThuDAO;
import dao.TrangThaiThuDAO;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.KhoanThu;
import model.TrangThaiThu;

/**
 *
 * @author Admin
 */
public class ThuPhiView extends JFrame{
    private JTextField ma_thu,ngay,sotien;
    private JTextField ma_hk;
    private KhoanThu kthu;
    
    JTable jt;
    JScrollPane js;
    String[] col;
    DefaultTableModel tableModel;
    
    public ThuPhiView(){
        setTitle("Quản lý thu phí");
        setSize(800, 600);
        setLocationRelativeTo(null);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ActionListener ac = new AdminListener(this);
        
        ma_thu = new JTextField(20);
        ngay = new JTextField(20);
        sotien = new JTextField(20);
        ma_hk = new JTextField(20);
        
        JButton submit = new JButton("Thêm khoản thu");
        submit.addActionListener(ac);
        JButton xemkt = new JButton("Xem tất cả");
        xemkt.addActionListener(ac);
        JButton xemtt = new JButton("Xem hộ chưa đóng");
        xemtt.addActionListener(ac);
        JButton timth = new JButton("Tìm theo hộ");
        timth.addActionListener(ac);
        
        this.setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(6, 5));
        inputPanel.add(new JLabel("Thêm khoản thu:"));  
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());
        
        inputPanel.add(new JLabel("Xem danh sách:"));  
        inputPanel.add(new JLabel());
        
        inputPanel.add(new JLabel("Mã thu:"));          
        inputPanel.add(ma_thu);
        inputPanel.add(new JLabel());
        
        inputPanel.add(xemkt);      
        inputPanel.add(xemtt);
        
        inputPanel.add(new JLabel("Ngày:"));            
        inputPanel.add(ngay);
        inputPanel.add(new JLabel());
        
        inputPanel.add(new JLabel("Tìm kiếm theo hộ:"));
        inputPanel.add(new JLabel());
        
        inputPanel.add(new JLabel("Số tiền:"));         
        inputPanel.add(sotien);
        inputPanel.add(new JLabel());
        
        inputPanel.add(ma_hk);
        inputPanel.add(timth);
        
        inputPanel.add(new JLabel());                       
        inputPanel.add(submit);      
        inputPanel.add(new JLabel());
        
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());
        
        inputPanel.add(new JLabel("Khoản thu:"));
        
        col = new String[]{"Mã thu", "Ngày", "Số tiền"};
        tableModel = new DefaultTableModel(col, 0);
        jt = new JTable(tableModel);
        js = new JScrollPane(jt);
        bangThu();
        
        this.add(js, BorderLayout.CENTER);
        this.add(inputPanel, BorderLayout.NORTH);  
        
        
        setVisible(true);
    }
    
    public void themKhoanThu(){
        this.kthu = new KhoanThu();
        
        kthu.setMa_thu(ma_thu.getText());
        
        try {
            int tien = Integer.parseInt(sotien.getText());
            this.kthu.setSotien(tien);
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
            this.kthu.setNgay(sqlDate);
            System.out.println(kthu);
            KhoanThuDAO.getInstance().insert(kthu);
            themTrangThaiThu(ma_thu.getText());
            
            Object[] data = {ma_thu.getText(), sqlDate, Integer.parseInt(sotien.getText())};
            tableModel.addRow(data);
    }
    public void bangThu(){   
        tableModel.setRowCount(0); // Clear existing data
        ArrayList<KhoanThu> allkt = KhoanThuDAO.getInstance().selectAll();

        for (int i = 0; i < allkt.size(); i++) {
            String ma_thu = allkt.get(i).getMa_thu();
            java.sql.Date ngay = allkt.get(i).getNgay();
            int sotien = allkt.get(i).getSotien();

            Object[] data = {ma_thu, ngay, sotien};
            tableModel.addRow(data);
        }
    }
    
    public void themTrangThaiThu(String mathu){
        ArrayList<String> kq = HoKhauDAO.getInstance().selectHoKhau();
        TrangThaiThu tthai = new TrangThaiThu();
        for(String i : kq){
            tthai.setMa_hk(i);
            tthai.setMa_thu(mathu);
            tthai.setTrangthai(0);
            TrangThaiThuDAO.getInstance().insert(tthai);
        }
    }
    
    public void bangttthu(){
        
        new BangTTThu(TrangThaiThuDAO.getInstance().selectAll());
    }
    public void bangchuadong(){
        
        new BangTTThu(TrangThaiThuDAO.getInstance().selectby0());
    }
    
    public void bangtheo_hokhau(){
        ArrayList<TrangThaiThu> tt = TrangThaiThuDAO.getInstance().selectbyhokhau(ma_hk.getText());
        new BangTTThu(tt);
    }
    
}
