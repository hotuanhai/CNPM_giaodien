/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KhoanThu;
import model.SoHoKhau;

/**
 *
 * @author Admin
 */
public class KhoanThuDAO implements DAOInterface<KhoanThu>{

    public static KhoanThuDAO getInstance() {
		return new KhoanThuDAO();
	}
    @Override
    public int insert(KhoanThu t) {
        int kq=0;
        try {
            
            Connection con = JDBCUtil.getConnection();
             String sql ="INSERT INTO KHOAN_THU(ma_thu,ngay,sotien)"+ " VALUES(?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMa_thu());
            st.setDate(2,t.getNgay());
            st.setInt(3, t.getSotien());
            kq = st.executeUpdate();
            //System.out.println(sql);
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    @Override
    public int update(KhoanThu t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(KhoanThu t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<KhoanThu> selectAll() {
        ArrayList<KhoanThu> kq = new ArrayList<KhoanThu>();
        try { 
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "select * from KHOAN_THU";
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                String ma_thu =rs.getString("ma_thu");
                java.sql.Date ngay = rs.getDate("ngay");
                int sotien = rs.getInt("sotien");

                KhoanThu kt  = new KhoanThu(ma_thu, ngay,sotien);
                kq.add(kt);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return kq;
    }

    @Override
    public ArrayList<KhoanThu> selectByHoKhau(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
