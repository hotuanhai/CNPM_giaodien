package view.login;

import controller.LoginListener;
import database.JDBCUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;
import view.admin.AdminView;

public class AdminLogin extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel label;
    private JPanel contentPane;

    public AdminLogin() {
        // Set the look and feel to Nimbus for a modern appearance
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ActionListener ac = new LoginListener(this);

        JLabel lblNewLabel = new JLabel("Login");
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

        JLabel lblUsername = new JLabel("ID");
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

        JButton uLogin = new JButton("LOGIN");
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
        String id = textField.getText();
        String pass = passwordField.getText();
        try {
            Connection connection = JDBCUtil.getConnection();

            PreparedStatement st = (PreparedStatement) connection
                    .prepareStatement("Select ma_cb, mk from TAI_KHOAN_ADMIN where ma_cb=? and mk=?");

            st.setString(1, id);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                dispose();

                String macb = rs.getString("ma_cb");
                // You might want to pass 'macb' to AdminView for further customization
                AdminView av = new AdminView(macb);
                JOptionPane.showMessageDialog(btnNewButton, "Bạn đã đăng nhập thành công");
            } else {
                JOptionPane.showMessageDialog(btnNewButton, "Sai tên hoặc mật khẩu");
                
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
