package database;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCUtil {
    public static Connection getConnection()  {
        Connection conn = null;
        try {            
            var server = "DESKTOP-CFTMCK3\\SQLEXPRESS";
            var user = "sa";
            var password = "123456";
            var db = "test1";
            var port = 1433;
            SQLServerDataSource ds = new SQLServerDataSource();
            ds.setUser(user);
            ds.setPassword(password);
            ds.setDatabaseName(db);
            ds.setServerName(server);
            ds.setPortNumber(port);
            ds.setEncrypt(false);
            
            conn = ds.getConnection();
            
        } catch (SQLServerException ex) {
            Logger.getLogger(JDBCUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    public static void closeConnection(Connection conn){
        try {
            if(conn != null){         
                conn.close();           
            }       
        }
        catch (SQLException ex) {
                Logger.getLogger(JDBCUtil.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
    public static void printInfo(Connection c) {
		try {
			if(c!=null) {
				DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
