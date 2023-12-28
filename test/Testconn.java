
package test;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Testconn {
    public static void main(String[] args) {
        try {
            Connection conn = JDBCUtil.getConnection();
            Statement st = conn.createStatement();
            System.out.println(conn.getCatalog());
            //JDBCUtil.printInfo(conn);
            JDBCUtil.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(Testconn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
