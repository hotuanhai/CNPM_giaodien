package view.login;

import controller.LoginListener;
import database.JDBCUtil;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.border.EmptyBorder;
import view.user.UserView;

public class UserLogin extends JFrame{
    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel label;
    private JPanel contentPane;  
    
    
     
      public UserLogin() {
          
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ActionListener ac = new LoginListener(this);
        
        
        JLabel lblNewLabel = new JLabel("User Login");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lblNewLabel.setBounds(423, 13, 273, 93);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        textField.setBounds(481, 170, 281, 68);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(481, 286, 281, 68);
        contentPane.add(passwordField);

        JLabel lblUsername = new JLabel("id");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblUsername.setBounds(250, 166, 193, 52);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblPassword.setBounds(250, 286, 193, 52);
        contentPane.add(lblPassword);

        JButton uLogin = new JButton("Login");
        uLogin.setFont(new Font("Tahoma", Font.PLAIN, 26));
        uLogin.setBounds(545, 392, 162, 73);
        uLogin.addActionListener(ac);
        
            

        contentPane.add(uLogin);

        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        contentPane.add(label);
        this.setVisible(true);
    }


public void log() {
                String ma_hk = textField.getText();
                String pass = passwordField.getText();
                try {
                    Connection connection = JDBCUtil.getConnection();

                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select ma_hk, mk from TAI_KHOAN where ma_hk=? and mk=?");

                    st.setString(1, ma_hk);
                    st.setString(2, pass);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        dispose();
                        UserView uv = new UserView(ma_hk) ;
                        uv.setTitle("Welcome " + ma_hk);
                        //JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
                    }
                    JDBCUtil.closeConnection(connection);
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
    }
}


