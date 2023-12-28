package view.admin;

import controller.AdminListener;
import dao.NhanKhauDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class KhaiTu extends JFrame {
    private JTextField id;

    public KhaiTu() {
        setTitle("Khai tử");
        setSize(400, 200);
        setLocationRelativeTo(null);

        ActionListener ac = new AdminListener(this);

        id = new JTextField(15);
        JButton submit = new JButton("Xác nhận khai tử");

        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));

        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel label = new JLabel("Nhập ID người mất:");
        
        // Make the JLabel bold
        Font boldFont = new Font(label.getFont().getName(), Font.BOLD, label.getFont().getSize());
        label.setFont(boldFont);
        
        labelPanel.add(label);
        panel.add(labelPanel);

        JPanel textFieldPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        textFieldPanel.add(id);
        panel.add(textFieldPanel);

        panel.add(submit);

        submit.addActionListener(ac);

        add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(submit);
        add(buttonPanel, BorderLayout.SOUTH);

        Dimension buttonSize = new Dimension(120, 30);
        submit.setPreferredSize(buttonSize);

        setVisible(true);
    }

    public void saveToAttributes() {
        int t = 0;
        try {
            t = Integer.parseInt(id.getText());
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        System.out.println(t);
        NhanKhauDAO.getInstance().mat(t);
    }

    public static void main(String[] args) {
        new KhaiTu();
    }
}
