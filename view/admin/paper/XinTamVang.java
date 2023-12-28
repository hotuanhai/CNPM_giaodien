package view.admin.paper;

import controller.TamVangListener;
import dao.TamVangDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TamVang;
import view.admin.InputNhanKhau;

public class XinTamVang extends JFrame {
    private JTextField noi_tamtru, from, to, id;
    private TamVang person;

    public XinTamVang() {
        setTitle("Đơn tạm vắng");
        setSize(400, 300);
        setLocationRelativeTo(null);

        ActionListener ac = new TamVangListener(this);

        // Create components
        noi_tamtru = createFormattedTextField(15);
        from = createFormattedTextField(10);
        to = createFormattedTextField(10);
        id = createFormattedTextField(5);

        JButton submit = createStyledButton("Nộp đơn", ac);
        JButton btn_xemtv = createStyledButton("Danh sách tạm vắng", ac);

        // Set up layout
        setLayout(new GridLayout(5, 2, 10, 10));

        Font labelFont = new Font("Arial", Font.BOLD, 12);

        add(createLabel("ID:", labelFont));
        add(id);

        add(createLabel("Từ ngày:", labelFont));
        add(from);

        add(createLabel("Đến ngày:", labelFont));
        add(to);

        add(createLabel("Nơi tạm trú:", labelFont));
        add(noi_tamtru);

        add(btn_xemtv);
        add(submit);
       // submit.addActionListener(ac);

        this.setVisible(true);
    }

    private JLabel createLabel(String labelText, Font font) {
        JLabel label = new JLabel(labelText);
        label.setFont(font);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    private JTextField createFormattedTextField(int columns) {
        JTextField textField = new JTextField(columns);
        textField.setFont(new Font("Arial", Font.PLAIN, 12));
        return textField;
    }

    private JButton createStyledButton(String buttonText, ActionListener actionListener) {
        JButton button = new JButton(buttonText);
        button.setPreferredSize(new Dimension(120, 30));
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.addActionListener(actionListener);
        return button;
    }

    public void saveToAttributes() {
        System.out.println("hi");
        this.person = new TamVang();

        try {
            int idt = Integer.parseInt(id.getText());
            this.person.setId(idt);
        } catch (NumberFormatException nfe) {
            // Handle the case where the input is not a valid integer
            nfe.printStackTrace();
        }

        String datefrom = from.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = null;
        try {
            utilDate = dateFormat.parse(datefrom);
        } catch (ParseException ex) {
            Logger.getLogger(InputNhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        this.person.setDatefrom(sqlDate);

        String dateto = to.getText();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        utilDate = null;
        try {
            utilDate = dateFormat.parse(dateto);
        } catch (ParseException ex) {
            Logger.getLogger(InputNhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }
        sqlDate = new java.sql.Date(utilDate.getTime());

        this.person.setDateto(sqlDate);

        this.person.setNoitamtru(noi_tamtru.getText());
        System.out.println(person);
        TamVangDAO.getInstance().insert(person);
    }

    public void bangTV() {
        new BangTamVang();
    }

    public static void main(String[] args) {
        //new XinTamVang();
    }
}
