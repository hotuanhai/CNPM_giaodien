
package dao;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NhanKhau;
import model.SoHoKhau;


public class HoKhauDAO implements DAOInterface<SoHoKhau>{
    public static HoKhauDAO getInstance() {
	return new HoKhauDAO();
	}
    @Override
    public int insert(SoHoKhau t) {
        int kq=0;
        try {
            
            Connection con = JDBCUtil.getConnection();
             String sql ="INSERT INTO HO_KHAU(ma_hk,address,tenchuho)"+ " VALUES(?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMa_hk());
            st.setString(2,t.getDiachi());
            st.setString(3, t.getTenchuho());
            kq = st.executeUpdate();
            //System.out.println(sql);
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    @Override
    public int update(SoHoKhau t) {

        int kq=0;
        try {
            
            Connection con = JDBCUtil.getConnection();
            String sql ="";
            PreparedStatement st = con.prepareStatement(sql);
            
            kq = st.executeUpdate();
            
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;    }

    @Override
    public int delete(SoHoKhau t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<SoHoKhau> selectAll() {

        ArrayList<SoHoKhau> kq = new ArrayList<SoHoKhau>();
        try {
            
        Connection con = JDBCUtil.getConnection();
            
        
        Statement st = con.createStatement();
        String sql = "select * from HO_KHAU";
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            String id =rs.getString("ma_hk");
            String dchi = rs.getString("address");
            String name = rs.getString("tenchuho");
                        
            SoHoKhau sh = new SoHoKhau(id, name,dchi);
            kq.add(sh);
        }
        JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;   
    }

    @Override
    public ArrayList<SoHoKhau> selectByHoKhau(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public ArrayList<String> selectHoKhau(){
        ArrayList<String> kq = new ArrayList<String>();
        try {
            
        Connection con = JDBCUtil.getConnection();
                  
        Statement st = con.createStatement();
        String sql = "select ma_hk from HO_KHAU";
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            String id =rs.getString("ma_hk");                        
            kq.add(id);
        }
        JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
}
