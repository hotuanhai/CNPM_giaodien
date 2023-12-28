/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import database.JDBCUtil;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CapThuongHoc;
import model.NhanKhau;

/**
 *
 * @author Admin
 */
public class NhanKhauDAO implements DAOInterface<NhanKhau>{

    public static NhanKhauDAO getInstance() {
		return new NhanKhauDAO();
	}
    @Override
    public int insert(NhanKhau t) {
    int kq = 0;
    try {
        Connection con = JDBCUtil.getConnection();
        int id = 0;
        String sql = "INSERT INTO NHAN_KHAU(name,birth,nghe,qh,ma_hk,namehome,sex,dantoc,que,tongiao,noilamviec,ngaycap,noicap,addresscu,cccd)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        // Use PreparedStatement with placeholders to avoid SQL injection
        PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        st.setString(1, t.getTen());
        st.setDate(2, new java.sql.Date(t.getNgaySinh().getTime()));
        st.setString(3, t.getNgheNghiep());
        st.setString(4, t.getQuanHe());
        st.setString(5, t.getMa_hk());
        st.setString(6, t.getBiDanh());
        st.setInt(7, t.getGioiTinh());
        st.setString(8, t.getDanToc());
        st.setString(9, t.getQueQuan());
        st.setString(10, t.getTonGiao());
        st.setString(11, t.getNoiLam());
        st.setDate(12, new java.sql.Date(t.getNgayCap().getTime()));
        st.setString(13, t.getNoiCap());
        st.setString(14, t.getNoiTTTruoc());
        st.setString(15, t.getCccd());

        // Execute the PreparedStatement
        kq = st.executeUpdate();

        // Retrieve the generated keys after executing the PreparedStatement
        ResultSet generatedKeys = st.getGeneratedKeys();
        if (generatedKeys.next()) {
            id = generatedKeys.getInt(1); // Retrieve the generated ID
        }

        CapThuongHoc cth = new CapThuongHoc();
        if (isAgeBetween6And18(t.getNgaySinh())) {
            cth.setTen(t.getTen());
            cth.setMa_hk(t.getMa_hk());
            cth.setId(id);
            CapThuongHocDAO.getInstance().insert(cth);
        }

        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return kq;
}
  
    @Override
    public int update(NhanKhau t) {
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
        return kq;
    }

    @Override
    public int delete(NhanKhau t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<NhanKhau> selectAll() {
        ArrayList<NhanKhau> kq = new ArrayList<NhanKhau>();
        try {
            
        Connection con = JDBCUtil.getConnection();
            
        
        Statement st = con.createStatement();
        String sql = "select * from NHAN_KHAU order by ma_hk ASC";
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            int id =rs.getInt("id");
            String name = rs.getString("name");
            Date birth = rs.getDate("birth");
            String note = rs.getString("note");
            String qh = rs.getString("qh");
            String mahk = rs.getString("ma_hk");
            String bidanh = rs.getString("namehome");
            int sex = rs.getInt("sex");
            String dantoc = rs.getString("dantoc");
            String que = rs.getString("que");
            String tongiao = rs.getString("tongiao");
            String noilv = rs.getString("noilamviec");
            Date ngaycap = rs.getDate("ngaycap");
            String noicap = rs.getString("noicap");
            Date ngaychuyen = rs.getDate("ngaychuyen");
            String addresscu = rs.getString("addresscu");
            String cccd = rs.getString("cccd");
            String nghe = rs.getString("nghe");
            String address = rs.getString("address");
            
            NhanKhau NhanKhau = new NhanKhau(id, name, birth,note,qh,mahk,bidanh,sex,dantoc,que,tongiao,nghe,
                    noilv,cccd,ngaycap,noicap,addresscu,ngaychuyen,address);
            kq.add(NhanKhau);
        }
        JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    @Override
    public ArrayList<NhanKhau> selectByHoKhau(String condition) {
        ArrayList kq = new ArrayList();
        try {
            
        Connection con = JDBCUtil.getConnection();
            
        String sql = "SELECT * FROM NHAN_KHAU where ma_hk=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,condition);
        
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            int id =rs.getInt("id");
            String name = rs.getString("name");
            Date birth = rs.getDate("birth");
            int sex = rs.getInt("sex");
            String cccd = rs.getString("cccd");
            
            NhanKhau NhanKhau = new NhanKhau(id, name, birth,sex,cccd);
            kq.add(NhanKhau);
        }
        JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    
    public ArrayList<NhanKhau> selectByage018(){
         ArrayList<NhanKhau> kq = new ArrayList<NhanKhau>();
         try {
            
        Connection con = JDBCUtil.getConnection();
            
        String sql = "SELECT id,ma_hk,name\n" +
                    "FROM NHAN_KHAU\n" +
                    "WHERE DATEDIFF(YEAR, birth, GETDATE()) BETWEEN 0 AND 18 order by ma_hk ASC;";
        PreparedStatement st = con.prepareStatement(sql);
         
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            NhanKhau nk = new NhanKhau();
            int id =rs.getInt("id");
            String mahk = rs.getString("ma_hk");
            String ten = rs.getString("name");
            nk.setId(id);
            nk.setTen(ten);
            nk.setMa_hk(mahk);
            kq.add(nk);
        }
        JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    
    public ArrayList<NhanKhau> selectByage618(){
         ArrayList<NhanKhau> kq = new ArrayList<NhanKhau>();
         try {
            
        Connection con = JDBCUtil.getConnection();
            
        String sql = "SELECT id,ma_hk,name\n" +
                    "FROM NHAN_KHAU\n" +
                    "WHERE DATEDIFF(YEAR, birth, GETDATE()) BETWEEN 6 AND 18 order by ma_hk ASC;";
        PreparedStatement st = con.prepareStatement(sql);
         
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            NhanKhau nk = new NhanKhau();
            int id =rs.getInt("id");
            String mahk = rs.getString("ma_hk");
            String ten = rs.getString("name");
            nk.setId(id);
            nk.setTen(ten);
            nk.setMa_hk(mahk);
            kq.add(nk);
        }
        JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    
    public int moisinh(NhanKhau t) {
        int kq = 0;
        try {
               //B1 : ket noi
            Connection con = JDBCUtil.getConnection();
            // B2: SQL
            String sql = "INSERT INTO NHAN_KHAU(name,birth,addresscu,qh,ma_hk,namehome,sex,dantoc,que)"
                    + " VALUES('" + t.getTen() + "' ,'" + t.getNgaySinh() + "' ,'"+t.getNoiTTTruoc()+ "' ,'" + t.getQuanHe() + "', '" + t.getMa_hk() + "' ,'" + t.getBiDanh() + "', " + t.getGioiTinh() + " ,'" + t.getDanToc() + "','" + t.getQueQuan()  + "' )";
            PreparedStatement st = con.prepareStatement(sql);
             
            kq = st.executeUpdate();
            //B3 : ngat ket noi
            //System.out.println(sql);
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    
    public int mat(int t) {
        int kq=0;
        try{    
            Connection con = JDBCUtil.getConnection();
         
            String sql = "UPDATE NHAN_KHAU SET note = 'mat' WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t);
            System.out.println(sql);
            kq = st.executeUpdate();
            
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    
    public int chuyen(NhanKhau t) {
    int kq = 0;
    try {
        Connection con = JDBCUtil.getConnection();

       
        String query = "SELECT address FROM NHAN_KHAU WHERE id = ?";
        PreparedStatement selectSt = con.prepareStatement(query);
        selectSt.setInt(1, t.getId());
        ResultSet rs = selectSt.executeQuery();

        String currentAddress = "";
        if (rs.next()) {
            currentAddress = rs.getString("address");
        }

        String sql = "UPDATE NHAN_KHAU SET addresscu = ?, address = ?, ngaychuyen = ? WHERE id = ?";
        PreparedStatement updateSt = con.prepareStatement(sql);
        updateSt.setString(1, currentAddress); 
        updateSt.setString(2, t.getAddress()); 
        updateSt.setDate(3, t.getNgaychuyen());
        updateSt.setInt(4, t.getId());

        kq = updateSt.executeUpdate();

        rs.close();
        selectSt.close();
        updateSt.close();

        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return kq;
}
    public int updateHK(int t,String ma_hkmoi) {
        int kq=0;
        try{    
            Connection con = JDBCUtil.getConnection();
         
            String query = "SELECT * FROM NHAN_KHAU WHERE id = ?";
            PreparedStatement selectSt = con.prepareStatement(query);
            selectSt.setInt(1, t);
            ResultSet rs = selectSt.executeQuery();
            
            if (rs.next()) {
                
                String sql = "UPDATE NHAN_KHAU SET ma_hk = ? WHERE id = ?";
                PreparedStatement updateSt = con.prepareStatement(sql);
                updateSt.setString(1, ma_hkmoi);
                updateSt.setInt(2, t);
                kq = updateSt.executeUpdate();
        }
            
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    
    public int songuoi018(){
        int kq=0;
        try{    
            Connection con = JDBCUtil.getConnection();
         
            String query = "(select count(*) as songuoi from NHAN_KHAU WHERE DATEDIFF(YEAR, birth, GETDATE()) BETWEEN 0 AND 18)";
            PreparedStatement selectSt = con.prepareStatement(query);
            ResultSet rs = selectSt.executeQuery();
            if (rs.next()) {
                kq = rs.getInt("songuoi");
            }
            
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    
    public static boolean isAgeBetween6And18(Date birth) {
        try {
            LocalDate birthdate = birth.toLocalDate();
            LocalDate currentDate = LocalDate.now();
            
            // Calculate the age using Period.between
            Period period = Period.between(birthdate, currentDate);
            int age = period.getYears();
            
            // Check if age is between 6 and 18
            return age >= 6 && age <= 18;
        } catch (Exception e) {
            // Handle exceptions appropriately
            e.printStackTrace();
            return false;
        }
    }
}
