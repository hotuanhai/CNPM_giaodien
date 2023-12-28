/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.admin.thuphi;

import dao.NhanKhauDAO;
import database.JDBCUtil;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class BangDongGop extends JFrame{
    JTable jt;
    JScrollPane js;
    String[] col;
    public BangDongGop(){
        setTitle("Bảng thông tin");
        setSize(200, 200);
        setLocationRelativeTo(null);
        
        col = new String[]{"Mã đóng góp"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        jt = new JTable(tableModel);
        js = new JScrollPane(jt);
        
        tableModel.setRowCount(0);
        ArrayList<String> kq = new ArrayList<String>();
        try { 
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "select * from TEN_DONGGOP";
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                String ma_thu =rs.getString("ma_donggop");        
                kq.add(ma_thu);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < kq.size(); i++) {
            String dg = kq.get(i);
            Object[] data = {dg};
            tableModel.addRow(data);
        }
        
        this.add(js);
        setVisible(true);
    }
}
