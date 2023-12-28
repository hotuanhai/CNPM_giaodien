
package view.admin.paper;

import controller.TamTruListener;
import controller.TamVangListener;
import dao.TamTruDAO;
import dao.TamVangDAO;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.TamTru;
import model.TamVang;

public class BangTamVang extends JFrame{
    private JTable jt;
    private JScrollPane js;
    private String[] col;
    private DefaultTableModel tableModel;
    JLabel jl_songuoi;
    public BangTamVang() {
        setTitle("Danh sách tạm vắng");
        setSize(800, 600);
        setLocationRelativeTo(null);
        ActionListener ac = new TamVangListener(this);

        this.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 4));
        jl_songuoi = new JLabel("Tổng số người:");
        JButton btn_xoatamvang = new JButton("Xóa giấy tạm vắng");
        btn_xoatamvang.addActionListener(ac);

        inputPanel.add(new JLabel("Danh sách tạm vắng:"));
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());
        
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());

        inputPanel.add(jl_songuoi);
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());

        

        col = new String[]{"Mã tạm vắng", "ID", "Từ ngày", "Đến ngày", "Nơi tạm vắng"};
        tableModel = new DefaultTableModel(col, 0);
        jt = new JTable(tableModel);
        js = new JScrollPane(jt);
        taobang();
        this.add(js, BorderLayout.CENTER);
        this.add(inputPanel, BorderLayout.NORTH);

        // Create a new JPanel for the south position with FlowLayout
        JPanel southPanel = new JPanel(new FlowLayout());
        southPanel.add(btn_xoatamvang);
        this.add(southPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void taobang() {
        tableModel.setRowCount(0); // Clear existing data
        ArrayList<TamVang> tt = TamVangDAO.getInstance().selectAll();
        for (TamVang i : tt) {
            int ma_tv = i.getMa_tamvang();
            int id = i.getId();
            Date from = i.getDatefrom();
            Date to = i.getDateto();
            String noitt = i.getNoitamtru();
            Object[] data = {ma_tv, id, from, to, noitt};
            tableModel.addRow(data);
        }
        jl_songuoi.setText("Tổng số người: " + jt.getRowCount());
    }

    public void deleteSelectedRow() {
        int selectedRow = jt.getSelectedRow();
        if (selectedRow != -1) {
            // Get data from the selected row
            int matt = (int) jt.getValueAt(selectedRow, 0);

            TamVang ctd = new TamVang();
            ctd.setMa_tamvang(matt);
            // Confirm with the user before deletion
            int option = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa dòng này?",
                    "Confirm Deletion", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                TamVangDAO.getInstance().delete(ctd);
                // Update the view
                taobang();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
        }
    }
}
