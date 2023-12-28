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
import model.CapThuongDip;
import model.CapThuongHoc;
import model.SoHoKhau;

/**
 *
 * @author Admin
 */
public class TenCapThuongDipDAO implements DAOInterface<CapThuongDip>{
    public static TenCapThuongDipDAO getInstance() {
		return new TenCapThuongDipDAO();
	}
    @Override
    public int insert(CapThuongDip t) {
        int kq=0;
        try {
            
            Connection con = JDBCUtil.getConnection();
             String sql ="INSERT INTO CAPTHUONG_DIP (ma_thuong, dip, sotien,tenqua) VALUES (?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMa_thuong());
            st.setString(2, t.getDip());
            st.setInt(3, t.getSotien());
            st.setString(4, t.getTen_qua());
            
            kq = st.executeUpdate();
            //System.out.println(sql);
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    @Override
    public int update(CapThuongDip t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(CapThuongDip t) {
        int kq=0;
        try {            
            Connection con = JDBCUtil.getConnection();
             String sql ="DELETE FROM CAPTHUONG_DIP WHERE ma_thuong = ? ";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMa_thuong());           
            kq = st.executeUpdate();
            //System.out.println(sql);
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    @Override
    public ArrayList<CapThuongDip> selectAll() {
        ArrayList<CapThuongDip> kq = new ArrayList<CapThuongDip>();
        try {
            
        Connection con = JDBCUtil.getConnection();
            
        
        Statement st = con.createStatement();
        String sql = "select * from CAPTHUONG_DIP";
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            String mathuong =rs.getString("ma_thuong");
            String dip = rs.getString("dip");
            int sotien = rs.getInt("sotien");
            String tenqua = rs.getString("tenqua");
                        
            CapThuongDip sh = new CapThuongDip(mathuong,tenqua, dip,sotien);
            kq.add(sh);
        }
        JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq; 
    }

    @Override
    public ArrayList<CapThuongDip> selectByHoKhau(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public ArrayList<String> selectTenCT(){
        ArrayList<String> kq = new ArrayList<String>();
        try {
            
        Connection con = JDBCUtil.getConnection();
            
        
        Statement st = con.createStatement();
        String sql = "select ma_thuong from CAPTHUONG_DIP";
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            String mathuong =rs.getString("ma_thuong");
            if (!mathuong.equals("ht1") && !mathuong.equals("ht2") && !mathuong.equals("ht3")){
                kq.add(mathuong);
            }
            
        }
        JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq; 
    }
    
    public int selectTienQua(){
        int kq = 0;
        try {
            
        Connection con = JDBCUtil.getConnection();
            
        
        Statement st = con.createStatement();
        String sql = "select sum(sotien) from CAPTHUONG_DIP";
        ResultSet rs = st.executeQuery(sql); 
        JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq; 
    }
    
    public int tiensoqua(){
        int kq=0;
        try{    
            Connection con = JDBCUtil.getConnection();
         
            String query = "(select sum(sotien) as tongtien from CAPTHUONG_DIP)";
            PreparedStatement selectSt = con.prepareStatement(query);
            ResultSet rs = selectSt.executeQuery();
            if (rs.next()) {
                kq = rs.getInt("tongtien")-44000;
            }
            
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    
    public int soqua(){
        int kq=0;
        try{    
            Connection con = JDBCUtil.getConnection();
         
            String query = "(select count(*) as soqua from CAPTHUONG_DIP)";
            PreparedStatement selectSt = con.prepareStatement(query);
            ResultSet rs = selectSt.executeQuery();
            if (rs.next()) {
                kq = rs.getInt("soqua")-3;
            }
            
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    
    public String ten_mathuong(CapThuongHoc i){
        String kq = "";
        try{    
            Connection con = JDBCUtil.getConnection();
         
            String query = "(select ma_thuong from CAPTHUONG_DIP where tenqua = ?)";
            PreparedStatement selectSt = con.prepareStatement(query);
            selectSt.setString(1, i.getQua()); 
            ResultSet rs = selectSt.executeQuery();
            if (rs.next()) {
                kq = rs.getString("ma_thuong");
            }            
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    public int Selecttien_mathuong(String i){
        int kq = 0;
        try{    
            Connection con = JDBCUtil.getConnection();
         
            String query = "(select sotien from CAPTHUONG_DIP where ma_thuong = ?)";
            PreparedStatement selectSt = con.prepareStatement(query);
            selectSt.setString(1, i); 
            ResultSet rs = selectSt.executeQuery();
            if (rs.next()) {
                kq = rs.getInt("sotien");
            }            
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
}
