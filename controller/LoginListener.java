
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.login.AdminLogin;
import view.login.BeginLogin;
import view.login.UserLogin;

public class LoginListener implements ActionListener{
    private BeginLogin bl;
    private AdminLogin al;
    private UserLogin ul;

    public LoginListener(BeginLogin bl) {
        this.bl = bl;
    }
    public LoginListener(AdminLogin al) {
        this.al = al;
    }
    public LoginListener(UserLogin ul) {
        this.ul = ul;
    }
       
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if(src.equals("Nguoi Dan")){
            this.bl.toUser();
        }
        else if(src.equals("Ban Quan Ly")){
            this.bl.toAdmin();
        }
        else if(src.equals("Login")){
            this.ul.log();
        }
        else if(src.equals("LOGIN")){
            this.al.log();
        }
    }
    
}
