package view.admin;

import controller.AdminListener;
import dao.HoKhauDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;
import model.SoHoKhau;

public class InputHoKhau extends JFrame {
    private JTextField ma_hk, tenchuho, dchi;
    private SoHoKhau shk;

    public InputHoKhau() {
        setTitle("Thêm hộ khẩu");
        setSize(400, 300);
        setLocationRelativeTo(null);

        ActionListener ac = new AdminListener(this);

        ma_hk = new JTextField(20);
        tenchuho = new JTextField(20);
        dchi = new JTextField(20);

        JButton submit = new JButton("Thêm vào hộ khẩu");
        JButton btn_xemHK = new JButton("Xem hộ khẩu");
        btn_xemHK.addActionListener(ac);

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Set font and alignment for JLabels
        Font labelFont = new Font("Arial", Font.BOLD, 14);

        JLabel labelMaHK = new JLabel("Mã hộ khẩu:");
        labelMaHK.setFont(labelFont);
        inputPanel.add(labelMaHK);
        inputPanel.add(ma_hk);

        JLabel labelTenChuHo = new JLabel("Tên chủ hộ:");
        labelTenChuHo.setFont(labelFont);
        inputPanel.add(labelTenChuHo);
        inputPanel.add(tenchuho);

        JLabel labelDiaChi = new JLabel("Địa chỉ:");
        labelDiaChi.setFont(labelFont);
        inputPanel.add(labelDiaChi);
        inputPanel.add(dchi);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(btn_xemHK);
        buttonPanel.add(submit);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set font for JButton
        Font buttonFont = new Font("Arial", Font.PLAIN, 12);
        submit.setFont(buttonFont);
        btn_xemHK.setFont(buttonFont);

        submit.addActionListener(e -> {
            saveToAttributes();
            JOptionPane.showMessageDialog(this, "Hộ khẩu đã được thêm thành công!");
            clearFields();
        });

        setVisible(true);
    }

    public void saveToAttributes() {
        shk = new SoHoKhau();
        Objects.requireNonNull(this.shk).setMa_hk(ma_hk.getText());
        this.shk.setDiachi(dchi.getText());
        this.shk.setTenchuho(tenchuho.getText());
        System.out.println(shk);
        HoKhauDAO.getInstance().insert(shk);
    }

    private void clearFields() {
        ma_hk.setText("");
        tenchuho.setText("");
        dchi.setText("");
    }

    public static void main(String[] args) {
        new InputHoKhau();
    }
}
