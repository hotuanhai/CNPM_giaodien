package view.admin;

import controller.AdminListener;
import dao.HoKhauDAO;
import dao.NhanKhauDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import model.SoHoKhau;

public class TachHoKhau extends JFrame {
    private JTextField id, ma_hkcu, ma_hkmoi, tenchuhomoi, diachimoi;
    private SoHoKhau hkmoi;

    public TachHoKhau() {
        setTitle("Tách hộ khẩu");
        setSize(500, 400);
        setLocationRelativeTo(null);

        ActionListener ac = new AdminListener(this);

        id = new JTextField(10);
        ma_hkcu = new JTextField(10);
        ma_hkmoi = new JTextField(10);
        tenchuhomoi = new JTextField(10);
        diachimoi = new JTextField(10);

        Dimension textFieldSize = new Dimension(200, 25);
        id.setPreferredSize(textFieldSize);
        ma_hkcu.setPreferredSize(textFieldSize);
        ma_hkmoi.setPreferredSize(textFieldSize);
        tenchuhomoi.setPreferredSize(textFieldSize);
        diachimoi.setPreferredSize(textFieldSize);

        JButton submit = new JButton("Nộp tách hộ khẩu");
        
        // Đặt kích thước cho JButton
        Dimension buttonSize = new Dimension(150, 30);
        submit.setPreferredSize(buttonSize);
        
        submit.addActionListener(ac);

        setLayout(new GridLayout(6, 2));

        add(createBoldCenteredLabel("Mã hộ khẩu cũ:"));
        add(createLabelWithPadding(ma_hkcu, 10)); // Add padding around the text field

        add(createBoldCenteredLabel("ID nhân khẩu tách ra:" + '\n' + "(vd: 1,2,4)"));
        add(createLabelWithPadding(id, 10)); // Add padding around the text field

        add(createBoldCenteredLabel("Mã hộ khẩu mới"));
        add(createLabelWithPadding(ma_hkmoi, 10)); // Add padding around the text field

        add(createBoldCenteredLabel("Tên chủ hộ mới"));
        add(createLabelWithPadding(tenchuhomoi, 10)); // Add padding around the text field

        add(createBoldCenteredLabel("Địa chỉ mới"));
        add(createLabelWithPadding(diachimoi, 10)); // Add padding around the text field

        add(new JLabel()); // Dòng trống
        add(submit);

        // Set font size for text fields
        Font textFieldFont = new Font("Arial", Font.PLAIN, 16); // Adjust the font size as needed
        setTextFieldFont(this, textFieldFont);

        setVisible(true);
    }

    private JLabel createBoldCenteredLabel(String labelText) {
        JLabel label = new JLabel(labelText);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Make the JLabel bold
        Font boldFont = new Font(label.getFont().getName(), Font.BOLD, label.getFont().getSize());
        label.setFont(boldFont);
        
        return label;
    }

    private JLabel createLabelWithPadding(JTextField textField, int padding) {
        JLabel label = new JLabel();
        label.setLayout(new BorderLayout());
        label.add(textField, BorderLayout.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
        return label;
    }

    private void setTextFieldFont(Container container, Font font) {
        for (Component component : container.getComponents()) {
            if (component instanceof JTextField) {
                ((JTextField) component).setFont(font);
            } else if (component instanceof Container) {
                setTextFieldFont((Container) component, font);
            }
        }
    }

    public void saveToAttributes() {
        hkmoi = new SoHoKhau();
        hkmoi.setDiachi(diachimoi.getText());
        hkmoi.setMa_hk(ma_hkmoi.getText());
        hkmoi.setTenchuho(tenchuhomoi.getText());

        ArrayList<Integer> arr = new ArrayList<>();
        Scanner input = new Scanner(id.getText());
        input.useDelimiter(",");
        while (input.hasNext()) {
            try {
                int gtt = Integer.parseInt(input.next());
                arr.add(gtt);
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
        }
        HoKhauDAO.getInstance().insert(hkmoi);

        for (Integer i : arr) {
            NhanKhauDAO.getInstance().updateHK(i, this.hkmoi.getMa_hk());
        }
    }
}
