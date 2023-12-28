/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.admin.capthuong;

import controller.CapThuongListener;
import dao.CapThuongHocDAO;
import dao.NhanKhauDAO;
import dao.TenCapThuongDipDAO;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.CapThuongDip;
import model.CapThuongHoc;
import model.NhanKhau;

/**
 *
 * @author Admin
 */
public class CapThuongDipView extends JFrame{
    private JTextField field_mahk;
     private JTextField tenma_thuong,tendip,sotien,tenqua;
     private JLabel jl_soqua,jl_sotien;
    JTable jt;
    JScrollPane js;
    String[] col;
    DefaultTableModel tableModel;
    JComboBox loaids_ComboBox;
    private String loaids = "Theo dịp";
     public CapThuongDipView(){
        setTitle("Cấp thưởng theo dịp");
        setSize(800, 600);
        setLocationRelativeTo(null);
       // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ActionListener ac = new CapThuongListener(this);
        field_mahk = new JTextField(20);
        tenqua = new JTextField(20);
        tenma_thuong = new JTextField(20);
        tendip = new JTextField(20);
        sotien = new JTextField(20);
        
        jl_soqua = new JLabel();
        jl_sotien = new JLabel();
        
        JButton btn_themthuong = new JButton("Thêm phần thưởng");
        btn_themthuong.addActionListener(ac);
        JButton btn_timquatheoho = new JButton("Tìm theo hộ");
        btn_timquatheoho.addActionListener(ac);
        JButton btn_xemTenQua = new JButton("Xem phần thưởng");
        btn_xemTenQua.addActionListener(ac);
        JButton btn_xemhsinh = new JButton("Danh sách học sinh");
        btn_xemhsinh.addActionListener(ac);
        
        loaids_ComboBox = new JComboBox<>(new String[]{"Theo dịp", "Theo học tập", "Tất cả"});
        loaids_ComboBox.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            loaids = (String) loaids_ComboBox.getSelectedItem();
            phatPT();
        }
        });
        
        
        this.setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(8, 5));
        
        inputPanel.add(new JLabel("Thêm phần thưởng:"));  
        inputPanel.add(new JLabel());
        
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel("Tìm kiếm:"));  
        inputPanel.add(new JLabel());
        
        inputPanel.add(new JLabel("Mã thưởng:"));          
        inputPanel.add(tenma_thuong);
        
        inputPanel.add(new JLabel()); 
        inputPanel.add(new JLabel("Mã hộ khẩu"));
        inputPanel.add(field_mahk);         
        
        inputPanel.add(new JLabel("Dịp:"));          
        inputPanel.add(tendip);
        
        inputPanel.add(new JLabel()); 
        inputPanel.add(new JLabel());
        inputPanel.add(btn_timquatheoho);  
     
        inputPanel.add(new JLabel("Số tiền:"));          
        inputPanel.add(sotien);

        inputPanel.add(new JLabel()); 
        inputPanel.add(new JLabel("Xem danh sách học sinh:"));
        inputPanel.add(btn_xemhsinh); 
        
        inputPanel.add(new JLabel("Tên quà:"));
        inputPanel.add(tenqua);
        
        inputPanel.add(new JLabel()); 
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel()); 
        
        inputPanel.add(btn_xemTenQua);
        inputPanel.add(btn_themthuong);
        
        inputPanel.add(new JLabel()); 
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());
        
        inputPanel.add(new JLabel("Danh sách cấp thưởng")); 
        inputPanel.add(loaids_ComboBox);
        
        
        inputPanel.add(new JLabel()); 
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());
        
        inputPanel.add(jl_soqua); 
        inputPanel.add(jl_sotien);
        
        inputPanel.add(new JLabel()); 
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());
        
        col = new String[]{"ID", "Tên", "Mã hộ khẩu","Mã thưởng"};
        tableModel = new DefaultTableModel(col, 0);
        jt = new JTable(tableModel);
        js = new JScrollPane(jt);
        
        phatPT();
        
        this.add(js, BorderLayout.CENTER);
        this.add(inputPanel, BorderLayout.NORTH); 
         setVisible(true);
     }
     
    public void themPT(){
        CapThuongDip ctd = new CapThuongDip();
        ctd.setMa_thuong(tenma_thuong.getText());
        ctd.setDip(tendip.getText());
        ctd.setTen_qua(tenqua.getText());
        try {
            int tien = Integer.parseInt(sotien.getText());
            ctd.setSotien(tien);
        } catch (NumberFormatException nfe) {
            // Handle the case where the input is not a valid integer
            nfe.printStackTrace();
        }
        TenCapThuongDipDAO.getInstance().insert(ctd);
        tableModel.setRowCount(0);
        phatPT();
    }
    public void phatPT(){
        tableModel.setRowCount(0); // Clear existing data
        if(loaids.equals("Theo dịp")){
            phatPTdip();
        }
        else if(loaids.equals("Theo học tập")){
            phatPThoc();
        }
        else if(loaids.equals("Tất cả")){
            phatPTdip();
            phatPThoc();
            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
            jt.setRowSorter(sorter);

             // Set the sort key for the "Mã hộ khẩu" column
            sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(2, SortOrder.ASCENDING)));
            soQuaTienhoc();
        }
    }
    public void phatPTdip(){
       
        ArrayList<NhanKhau> nk = NhanKhauDAO.getInstance().selectByage018();
        ArrayList<String> ten_ma = TenCapThuongDipDAO.getInstance().selectTenCT();
        for(NhanKhau i: nk){
            for(String j : ten_ma){
                String ma_ct = j;
                String mahk = i.getMa_hk();
                int id = i.getId();
                String ten = i.getTen();
                Object[] data = {id,ten, mahk, ma_ct};
                tableModel.addRow(data);
            }
        }
        soQuaTien();
    }
    public void soQuaTien(){
        int tongsoqua= jt.getRowCount();
        jl_soqua.setText("Tổng số quà: "+ tongsoqua);
        int sotienqua = TenCapThuongDipDAO.getInstance().tiensoqua();
        //System.out.println(sotienqua);
        int soqua = TenCapThuongDipDAO.getInstance().soqua();
        //System.out.println(soqua);
        int songuoi = tongsoqua / soqua;
        //System.out.println(songuoi);
        int tien = sotienqua * songuoi;
        jl_sotien.setText("Tổng số tiền: "+ tien);
    }
    public void phatPThoc(){
        
        ArrayList<CapThuongHoc> cth = CapThuongHocDAO.getInstance().selectAll();
        for(CapThuongHoc i : cth){
            String mahk = i.getMa_hk();
            int id = i.getId();
            String ten = i.getTen();
            String ma_ct = TenCapThuongDipDAO.getInstance().ten_mathuong(i);
            Object[] data = {id,ten, mahk, ma_ct};
            tableModel.addRow(data);
        }
        soQuaTienhoc();
    }
    public void soQuaTienhoc(){
        int tongsoqua= jt.getRowCount();
        jl_soqua.setText("Tổng số quà: "+ tongsoqua);
        int tien = 0;
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            // Assuming the "ID" column is at index 0
            String value = (String)tableModel.getValueAt(row, 3);
            tien += TenCapThuongDipDAO.getInstance().Selecttien_mathuong(value);
            
        }
        jl_sotien.setText("Tổng số tiền: "+ tien);
    }
    public void xemPT(){
         //ArrayList<CapThuongDip> kq = TenCapThuongDipDAO.getInstance().selectAll();
         new BangCTDip();
    }
    public void timTheoHo(){
        tableModel.setRowCount(0); // Clear existing data
        if(loaids.equals("Theo dịp")){
            timTheoHodip();
        }
        else if(loaids.equals("Theo học tập")){
            timTheoHohoc();
        }

        else if(loaids.equals("Tất cả")){
            timTheoHodip();
            timTheoHohoc();
        }
        field_mahk.setText("");
    }
    public void timTheoHodip(){
        ArrayList<NhanKhau> nk = NhanKhauDAO.getInstance().selectByage018();
        ArrayList<String> ten_ma = TenCapThuongDipDAO.getInstance().selectTenCT();
        for(NhanKhau i: nk){
            for(String j : ten_ma){
                String mahk = i.getMa_hk();
                if(mahk.equals(field_mahk.getText())){
                    String ma_ct = j;
                    int id = i.getId();
                    String ten = i.getTen();
                    Object[] data = {id,ten, mahk, ma_ct};
                    tableModel.addRow(data);
                }
            }
        }
        soQuaTien();
    }
    public void timTheoHohoc(){
        ArrayList<CapThuongHoc> cth = CapThuongHocDAO.getInstance().selectAll();
        for(CapThuongHoc i : cth){
            String mahk = i.getMa_hk();
            if(mahk.equals(field_mahk.getText())){
                int id = i.getId();
                String ten = i.getTen();
                String ma_ct = TenCapThuongDipDAO.getInstance().ten_mathuong(i);
                Object[] data = {id,ten, mahk, ma_ct};
                tableModel.addRow(data);
            }
        }
        soQuaTienhoc();
    }
    
    
    
    public void danhsach_hs(){
        new BangHocSinh();
    }
}
