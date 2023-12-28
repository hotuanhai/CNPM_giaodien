package view.admin.paper;

import controller.TamTruListener;
import dao.TamTruDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.TamTru;

public class BangTamTru extends JFrame {
    private JTextField field_mahk;
    private JTable jt;
    private JScrollPane js;
    private String[] col;
    private DefaultTableModel tableModel;
    JLabel jl_songuoi,jl_danhsach;

    public BangTamTru() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setTitle("Danh sách tạm trú");
        setSize(800, 600);
        setLocationRelativeTo(null);
        ActionListener ac = new TamTruListener(this);

        this.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 5));
        jl_songuoi = new JLabel("Tổng số người:");
        jl_songuoi.setFont(new Font("Arial", Font.BOLD, 14)); // Increased font size
        JButton btn_xoatamtru = new JButton("Xóa giấy tạm trú");
        btn_xoatamtru.addActionListener(ac);
        jl_danhsach = new JLabel("Danh sách tạm trú:");
        jl_danhsach.setFont(new Font("Arial", Font.PLAIN, 24));
        inputPanel.add(jl_danhsach);
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());

        inputPanel.add(jl_songuoi);
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());

        col = new String[]{"Mã tạm trú", "ID", "Lý do", "Thời gian (tháng)", "Nơi tạm trú"};
        tableModel = new DefaultTableModel(col, 0);
        jt = new JTable(tableModel);
        js = new JScrollPane(jt);
        taobang();
        this.add(js, BorderLayout.CENTER);
        this.add(inputPanel, BorderLayout.NORTH);

        // Create a new JPanel for the south position with FlowLayout
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Centered alignment
        southPanel.add(btn_xoatamtru);
        this.add(southPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void taobang() {
        tableModel.setRowCount(0); // Clear existing data
        ArrayList<TamTru> tt = TamTruDAO.getInstance().selectAll();
        for (TamTru i : tt) {
            int ma_tt = i.getMa_tamtru();
            int id = i.getId();
            String lydo = i.getLydo();
            int thoigian = i.getThoigian();
            String noitt = i.getNoitamtru();
            Object[] data = {ma_tt, id, lydo, thoigian, noitt};
            tableModel.addRow(data);
        }
        jl_songuoi.setText("Tổng số người: " + jt.getRowCount());
    }

    public void deleteSelectedRow() {
        int selectedRow = jt.getSelectedRow();
        if (selectedRow != -1) {
            // Get data from the selected row
            int matt = (int) jt.getValueAt(selectedRow, 0);

            TamTru ctd = new TamTru();
            ctd.setMa_tamtru(matt);
            // Confirm with the user before deletion
            int option = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa dòng này?",
                    "Confirm Deletion", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                TamTruDAO.getInstance().delete(ctd);
                // Update the view
                taobang();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BangTamTru());
    }
}
