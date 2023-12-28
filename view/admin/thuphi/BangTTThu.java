/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.admin.thuphi;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.TrangThaiThu;

/**
 *
 * @author Admin
 */
public class BangTTThu extends JFrame{
    JTable jt;
    JScrollPane js;
    String[] col;
    public BangTTThu(ArrayList<TrangThaiThu> tthai){
        setTitle("Bảng thông tin");
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        col = new String[]{"Mã thu","Mã hộ khẩu","Trạng thái"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        jt = new JTable(tableModel);
        js = new JScrollPane(jt);
        
        for (int i = 0; i < tthai.size(); i++){
            String ma_hk = tthai.get(i).getMa_hk();
            String ma_thu = tthai.get(i).getMa_thu();
            int tt = tthai.get(i).getTrangthai();
            
             Object[] data ={ma_thu,ma_hk,tt};
             tableModel.addRow(data);
        }
        
        this.add(js);
        setVisible(true);
    }
}
