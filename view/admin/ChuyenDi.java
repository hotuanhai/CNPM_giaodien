package view.admin;

import controller.AdminListener;
import dao.NhanKhauDAO;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.NhanKhau;

public class ChuyenDi extends JFrame {
    private JTextField id, ngaychuyen, address, note;
    private NhanKhau nk;

    public ChuyenDi() {
        setTitle("Chuyển đi");
        setSize(400, 250);
        setLocationRelativeTo(null);

        ActionListener ac = new AdminListener(this);

        id = new JTextField(15);
        ngaychuyen = new JTextField(15);
        address = new JTextField(15);
        note = new JTextField(15);

        JButton submit = new JButton("Nộp chuyển đi");

        // Sử dụng layout GridLayout để sắp xếp các thành phần
        setLayout(new GridLayout(5, 2, 10, 10));

        // Thêm các thành phần vào frame
        add(createCenteredLabel("ID:", 12));
        add(id);

        add(createCenteredLabel("Ngày chuyển:", 12));
        add(ngaychuyen);

        add(createCenteredLabel("Nơi chuyển:", 12));
        add(address);

        add(createCenteredLabel("Ghi chú:", 12));
        add(note);

        // Tạo một JPanel mới để chứa JButton và đặt layout của nó thành FlowLayout.CENTER
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(submit);

        add(new JLabel()); // Dòng trống
        add(buttonPanel);
        submit.addActionListener(ac);

        setVisible(true);
    }

    private JLabel createCenteredLabel(String labelText, int fontSize) {
        JLabel label = new JLabel(labelText);
        label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, fontSize));
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        return label;
    }

    public void saveToAttributes() {
        nk = new NhanKhau();

        try {
            int gtt = Integer.parseInt(id.getText());
            this.nk.setId(gtt);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }

        this.nk.setAddress(address.getText());
        this.nk.setNote(note.getText());

        String ngayChuyenText = ngaychuyen.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = null;
        try {
            utilDate = dateFormat.parse(ngayChuyenText);
        } catch (ParseException ex) {
            Logger.getLogger(ChuyenDi.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        this.nk.setNgaychuyen(sqlDate);
        System.out.println(nk);
        NhanKhauDAO.getInstance().chuyen(nk);
    }

    
}
