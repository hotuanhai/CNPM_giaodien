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
import model.CapThuongHoc;
import model.SoHoKhau;

/**
 *
 * @author Admin
 */
public class CapThuongHocDAO implements DAOInterface<CapThuongHoc>{
    public static CapThuongHocDAO getInstance() {
	return new CapThuongHocDAO();
    }
    @Override
    public int insert(CapThuongHoc t) {
        int kq=0;
        try {
            
            Connection con = JDBCUtil.getConnection();
            
            String sql= "INSERT INTO CAPTHUONG_HOC (id, ten, ma_hk, thanhtich, qua) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getId());
            st.setString(2, t.getTen());
            st.setString(3, t.getMa_hk());
            st.setString(4, t.getThanhtich());
            st.setString(5, t.getQua());
            kq = st.executeUpdate();
            
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    @Override
    public int update(CapThuongHoc t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(CapThuongHoc t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<CapThuongHoc> selectAll() {
        ArrayList<CapThuongHoc> kq = new ArrayList<CapThuongHoc>();
        try {
            
        Connection con = JDBCUtil.getConnection();
            
        
        Statement st = con.createStatement();
        String sql = "select * from CAPTHUONG_HOC";
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            int id = rs.getInt("id");
            String mahk =rs.getString("ma_hk");
            String thanhtich = rs.getString("thanhtich");
            String qua = rs.getString("qua");
            String name = rs.getString("ten");
                        
            CapThuongHoc cth = new CapThuongHoc(id, name,mahk,thanhtich,qua);
            kq.add(cth);
        }
        JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    @Override
    public ArrayList<CapThuongHoc> selectByHoKhau(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public int updateThanhTich(int id,String thanhtich,String qua){
        int kq=0;
        try {
            
            Connection con = JDBCUtil.getConnection();
            String sql ="UPDATE CAPTHUONG_HOC SET thanhtich = ?, qua = ? WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, thanhtich);
            st.setString(2, qua);
            st.setInt(3, id);
            kq = st.executeUpdate();
            
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
}
