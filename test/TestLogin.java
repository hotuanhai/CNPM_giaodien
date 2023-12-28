
package test;

import javax.swing.UIManager;
import view.login.AdminLogin;
import view.login.BeginLogin;


public class TestLogin {
    public static void main(String[] args) {
		try {
                    
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    new AdminLogin();
		} catch (Exception ex) {
			ex.printStackTrace();
		}	

	}
}
//-J-Dfile.encoding=UTF-8
