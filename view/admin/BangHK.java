package view.admin;

import dao.HoKhauDAO;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.SoHoKhau;

public class BangHK extends JFrame {
    JTable jt;
    JScrollPane js;
    String[] col;

    public BangHK() {
        ArrayList<SoHoKhau> shk = HoKhauDAO.getInstance().selectAll();
        setTitle("Bảng thông tin");
        setSize(800, 600);
        setLocationRelativeTo(null);

        col = new String[]{"Mã hộ khẩu", "Tên chủ hộ", "Địa chỉ"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        jt = new JTable(tableModel);
        js = new JScrollPane(jt);

        for (int i = 0; i < shk.size(); i++) {
            String ma_hk = shk.get(i).getMa_hk();
            String tenchuho = shk.get(i).getTenchuho();
            String diachi = shk.get(i).getDiachi();

            Object[] data = {ma_hk, tenchuho, diachi};
            tableModel.addRow(data);
        }

        this.add(js);

        // Modify the appearance of components
        customizeComponents();

        setVisible(true);
    }

    private void customizeComponents() {
        // Customize the appearance of the components
        jt.setFont(new Font("Tahoma", Font.PLAIN, 16));
        jt.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
        jt.setRowHeight(25);

        // You can customize the appearance of other components here, for example:
        // label.setFont(new Font("Tahoma", Font.PLAIN, 16));
        // textField.setFont(new Font("Tahoma", Font.PLAIN, 16));

        // Set preferred sizes for better layout control
        jt.setPreferredSize(new java.awt.Dimension(780, 500));
        js.setPreferredSize(new java.awt.Dimension(780, 500));

        // Add borders to components for better visibility
        jt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        js.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

//    public static void main(String[] args) {
//        ArrayList<SoHoKhau> shkList = new ArrayList<>();
//        // Add sample data to the list
//        shkList.add(new SoHoKhau("HK001", "Nguyen Van A", "123 Street, City"));
//        shkList.add(new SoHoKhau("HK002", "Tran Thi B", "456 Street, Town"));
//
//        // Create and display the frame
//        new BangHK(shkList);
//    }
}
