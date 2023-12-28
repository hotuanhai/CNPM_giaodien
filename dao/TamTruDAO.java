
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
import model.SoHoKhau;
import model.TamTru;


public class TamTruDAO implements DAOInterface<TamTru>{
    public static TamTruDAO getInstance(){
        return new TamTruDAO();
    }
    @Override
    public int insert(TamTru t) {
        int kq=0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql="insert into TAM_TRU(lydo,noitamtru,thoigian,id) Values (?, ?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            // st.setInt(1, t.getMa_tamvang());
            st.setString(1, t.getLydo());
            st.setString(2, t.getNoitamtru());
            st.setInt(3, t.getThoigian());
            st.setInt(4, t.getId());
            
            kq = st.executeUpdate();
            } catch (SQLException ex) {
            Logger.getLogger(TamTruDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;        
    }

    @Override
    public int update(TamTru t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(TamTru t) {
        int kq=0;
        try {            
            Connection con = JDBCUtil.getConnection();
             String sql ="DELETE  FROM TAM_TRU WHERE ma_tamtru = ? ";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getMa_tamtru());           
            kq = st.executeUpdate();
            //System.out.println(sql);
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    @Override
    public ArrayList<TamTru> selectAll() {
        ArrayList<TamTru> kq = new ArrayList<TamTru>();
        try {
            
            Connection con = JDBCUtil.getConnection();

            Statement st = con.createStatement();
            String sql = "select * from TAM_TRU";
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                int ma_tamtru = rs.getInt("ma_tamtru");
                String lydo =rs.getString("lydo");
                int id = rs.getInt("id");
                int thoigian = rs.getInt("thoigian");
                String noitamtru = rs.getString("noitamtru");
                TamTru sh = new TamTru(lydo, noitamtru,thoigian,id,ma_tamtru);
                kq.add(sh);
        }
        JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;   
    }

    @Override
    public ArrayList<TamTru> selectByHoKhau(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
