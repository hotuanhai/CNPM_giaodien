/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.JDBCUtil;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DongGop;
import model.SoHoKhau;

/**
 *
 * @author Admin
 */
public class DongGopDAO implements DAOInterface<DongGop>{

    public static DongGopDAO getInstance() {
		return new DongGopDAO();
	}
    @Override
    public int insert(DongGop t) {
        int kq=0;
        try {
            
            Connection con = JDBCUtil.getConnection();
             String sql ="INSERT INTO DONG_GOP(ma_donggop,ngay,sotien,ma_hk)"+ " VALUES(?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMa_donggop());
            st.setDate(2,t.getNgay());
            st.setInt(3, t.getSotien());
            st.setString(4, t.getMa_hk());
            kq = st.executeUpdate();
            //System.out.println(sql);
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    @Override
    public int update(DongGop t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(DongGop t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<DongGop> selectAll() {
         ArrayList<DongGop> dg = new ArrayList<DongGop>();
         try {
            
            Connection con = JDBCUtil.getConnection();

            Statement st = con.createStatement();
            String sql = "select * from DONG_GOP";
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                String madonggop =rs.getString("ma_donggop");
                String mahk = rs.getString("ma_hk");
                int sotien = rs.getInt("sotien");
                Date ngay = rs.getDate("ngay");

                DongGop sh = new DongGop(madonggop, ngay,sotien,mahk);
                dg.add(sh);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return dg;
    }

    @Override
    public ArrayList<DongGop> selectByHoKhau(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     public ArrayList<DongGop> timkiem(String ma_donggop,String ma_hk){
          ArrayList<DongGop> dg = new ArrayList<DongGop>();
         try {  
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM DONG_GOP WHERE (ma_donggop = ? OR ? IS NULL) " +
                                                    "AND (ma_hk = ? OR ? IS NULL)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ma_donggop);
            st.setString(2, ma_donggop);
            st.setString(3, ma_hk);
            st.setString(4, ma_hk);
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                String madonggop =rs.getString("ma_donggop");
                String mahk = rs.getString("ma_hk");
                int sotien = rs.getInt("sotien");
                Date ngay = rs.getDate("ngay");

                DongGop sh = new DongGop(madonggop, ngay,sotien,mahk);
                dg.add(sh);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return dg;
     }
    
}
