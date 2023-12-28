
package view.login;

import controller.LoginListener;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


public class BeginLogin extends JFrame{

    public BeginLogin() {
        this.setTitle("Begin Login");
        this.setLocationRelativeTo(null);
        this.setSize(600, 600);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ActionListener ac = new LoginListener(this);
              
        JButton jButton_admin = new JButton("Ban Quan Ly");
        jButton_admin.addActionListener(ac);
	JButton jButton_user = new JButton("Nguoi Dan");        
        jButton_user.addActionListener(ac);
        
        
        this.setLayout(new GridLayout(1,2));
        this.add(jButton_admin);
        this.add(jButton_user);
        this.setVisible(true);
    }
    
    public void toUser(){
        dispose();
        new UserLogin();
    }
    public void toAdmin(){
        dispose();
        new AdminLogin();
    }
}
