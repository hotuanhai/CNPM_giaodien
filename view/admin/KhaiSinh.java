package view.admin;

import controller.AdminListener;
import dao.NhanKhauDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NhanKhau;

public class KhaiSinh extends JFrame {
    private JTextField ma_hk, quanhe, ngaySinh, ten, gioitinh, que, dantoc;
    private NhanKhau moisinh;

    public KhaiSinh() {
        setTitle("Khai Sinh");
        setSize(500, 400);
        setLocationRelativeTo(null);

        ActionListener ac = new AdminListener(this);

        ma_hk = new JTextField(15);
        quanhe = new JTextField(15);
        ngaySinh = new JTextField(15);
        ten = new JTextField(15);
        gioitinh = new JTextField(15);
        que = new JTextField(15);
        dantoc = new JTextField(15);

        // Increase the font size of the text fields
        Font textFieldFont = new Font("Arial", Font.PLAIN, 16);
        ma_hk.setFont(textFieldFont);
        quanhe.setFont(textFieldFont);
        ngaySinh.setFont(textFieldFont);
        ten.setFont(textFieldFont);
        gioitinh.setFont(textFieldFont);
        que.setFont(textFieldFont);
        dantoc.setFont(textFieldFont);

        JButton submit = new JButton("Nộp khai sinh");
        submit.setPreferredSize(new Dimension(150, 30));
        submit.addActionListener(ac);

        setLayout(new GridBagLayout());

        Font labelFont = new Font("Arial", Font.BOLD, 14);

        add(createLabel("Mã hộ khẩu:", labelFont), createConstraints(0, 0));
        add(ma_hk, createConstraints(1, 0));

        add(createLabel("Quan hệ:", labelFont), createConstraints(0, 1));
        add(quanhe, createConstraints(1, 1));

        add(createLabel("Ngày sinh:", labelFont), createConstraints(0, 2));
        add(ngaySinh, createConstraints(1, 2));

        add(createLabel("Tên:", labelFont), createConstraints(0, 3));
        add(ten, createConstraints(1, 3));

        add(createLabel("Quê:", labelFont), createConstraints(0, 4));
        add(que, createConstraints(1, 4));

        add(createLabel("Dân tộc:", labelFont), createConstraints(0, 5));
        add(dantoc, createConstraints(1, 5));

        add(createLabel("Giới tính:", labelFont), createConstraints(0, 6));
        add(gioitinh, createConstraints(1, 6));

        add(new JLabel(), createConstraints(0, 7));
        add(submit, createConstraints(1, 7));

        setVisible(true);
    }

    private JLabel createLabel(String labelText, Font font) {
        JLabel label = new JLabel(labelText);
        label.setFont(font);
        return label;
    }

    private GridBagConstraints createConstraints(int x, int y) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.anchor = GridBagConstraints.WEST; // Align to the left
        constraints.insets = new Insets(5, 5, 5, 5); // Add some padding
        return constraints;
    }

    public void saveToAttributes() {
        System.out.println("aj");
        moisinh = new NhanKhau();
        moisinh.setMa_hk(ma_hk.getText());
        moisinh.setDanToc(dantoc.getText());
        moisinh.setQuanHe(quanhe.getText());
        moisinh.setQueQuan(que.getText());
        moisinh.setTen(ten.getText());

        try {
            int gtt = Integer.parseInt(gioitinh.getText());
            this.moisinh.setGioiTinh(gtt);
        } catch (NumberFormatException nfe) {
            // Handle the case where the input is not a valid integer
            nfe.printStackTrace();
        }

        String ngaySinhText = ngaySinh.getText();
        // Parse the text into a java.util.Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = null;
        try {
            utilDate = dateFormat.parse(ngaySinhText);
        } catch (ParseException ex) {
            Logger.getLogger(KhaiSinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Convert java.util.Date to java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        this.moisinh.setNgaySinh(sqlDate);

        moisinh.setNoiTTTruoc("moi sinh");
        System.out.println(moisinh);
        NhanKhauDAO.getInstance().moisinh(moisinh);
    }

    public static void main(String[] args) {
        new KhaiSinh();
    }
}
