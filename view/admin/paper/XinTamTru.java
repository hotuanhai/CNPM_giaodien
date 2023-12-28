package view.admin.paper;

import controller.TamTruListener;
import dao.TamTruDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import model.TamTru;

public class XinTamTru extends JFrame {
    private JTextField noi_tamtru, lydo, thoigian, id;
    private TamTru person;

    public XinTamTru() {
        setTitle("Đơn tạm trú");
        setSize(400, 300);
        setLocationRelativeTo(null);

        ActionListener ac = new TamTruListener(this);

        noi_tamtru = new JTextField(15);
        lydo = new JTextField(15);
        thoigian = new JTextField(5);
        id = new JTextField(5);

        JButton submit = new JButton("Nộp đơn");
        JButton btn_xemtt = new JButton("Danh sách tạm trú");
        btn_xemtt.addActionListener(ac);

        // Set up layout
        setLayout(new GridBagLayout());

        GridBagConstraints labelConstraints = new GridBagConstraints();
        labelConstraints.anchor = GridBagConstraints.WEST;
        labelConstraints.insets = new Insets(5, 5, 5, 5);

        Font labelFont = new Font("Arial", Font.BOLD, 12);

        labelConstraints.gridy = 0;
        add(createLabel("ID:", labelFont), labelConstraints);
        labelConstraints.gridy = 1;
        add(createLabel("Nơi tạm trú:", labelFont), labelConstraints);
        labelConstraints.gridy = 2;
        add(createLabel("Thời gian (tháng):", labelFont), labelConstraints);
        labelConstraints.gridy = 3;
        add(createLabel("Lý do:", labelFont), labelConstraints);

        GridBagConstraints fieldConstraints = new GridBagConstraints();
        fieldConstraints.fill = GridBagConstraints.HORIZONTAL;
        fieldConstraints.insets = new Insets(5, 5, 5, 5);

        fieldConstraints.gridy = 0;
        add(id, fieldConstraints);
        fieldConstraints.gridy = 1;
        add(noi_tamtru, fieldConstraints);
        fieldConstraints.gridy = 2;
        add(thoigian, fieldConstraints);
        fieldConstraints.gridy = 3;
        add(lydo, fieldConstraints);

        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridwidth = 2;
        buttonConstraints.gridy = 4;
        add(submit, buttonConstraints);
        buttonConstraints.gridy = 5;
        add(btn_xemtt, buttonConstraints);
        submit.addActionListener(ac);

        this.setVisible(true);
    }

    private JLabel createLabel(String labelText, Font font) {
        JLabel label = new JLabel(labelText);
        label.setFont(font);
        return label;
    }

    public void saveToAttributes() {
        System.out.println("fff");
        this.person = new TamTru();

        this.person.setNoitamtru(noi_tamtru.getText());
        this.person.setLydo(lydo.getText());

        try {
            int idt = Integer.parseInt(id.getText());
            this.person.setId(idt);
        } catch (NumberFormatException nfe) {
            // Handle the case where the input is not a valid integer
            nfe.printStackTrace();
        }

        try {
            int thoigiant = Integer.parseInt(thoigian.getText());
            this.person.setThoigian(thoigiant);
        } catch (NumberFormatException nfe) {
            // Handle the case where the input is not a valid integer
            nfe.printStackTrace();
        }

        System.out.println(person);
        TamTruDAO.getInstance().insert(person);
    }

    public void bangTT() {
        new BangTamTru();
    }
}
