package view.admin.capthuong;

import controller.CapThuongListener;
import dao.CapThuongHocDAO;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.CapThuongHoc;

public class BangHocSinh extends JFrame {
    private JTable jt;
    private JScrollPane js;
    private String[] col;
    private DefaultTableModel tableModel;
    private JComboBox<String> thanhtichComboBox;

    public BangHocSinh() {
        setTitle("Danh sách học sinh");
        setSize(800, 600);
        setLocationRelativeTo(null);

        ActionListener ac = new CapThuongListener(this);

        this.setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(1, 1));
        inputPanel.add(new JLabel("Danh sách học sinh:"));

        col = new String[]{"ID", "Tên", "Mã hộ khẩu", "Thành tích"};
        tableModel = new DefaultTableModel(col, 0);
        jt = new JTable(tableModel);
        js = new JScrollPane(jt);
        taobang();

        setUpThanhtichComboBoxEditor();

        this.add(js, BorderLayout.CENTER);
        this.add(inputPanel, BorderLayout.NORTH);

        setVisible(true);
    }

    public void taobang() {
        CapThuongHoc cth = new CapThuongHoc();
        ArrayList<CapThuongHoc> ct = CapThuongHocDAO.getInstance().selectAll();
        for (CapThuongHoc i : ct) {
            cth.setId(i.getId());
            cth.setMa_hk(i.getMa_hk());
            cth.setTen(i.getTen());
            cth.setThanhtich(i.getThanhtich());
            tableModel.addRow(new Object[]{cth.getId(), cth.getTen(), cth.getMa_hk(), cth.getThanhtich()});
        }
    }

    private void setUpThanhtichComboBoxEditor() {
    // Create a JComboBox with initial items
    thanhtichComboBox = new JComboBox<>(new String[]{"Giỏi,thành tích đặc biệt", "Khá", "Khác"});
    // thanhtichComboBox.setEditable(true);
    jt.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(thanhtichComboBox));

    jt.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {
        @Override
        protected void setValue(Object value) {
            setText((value == null) ? "" : value.toString());
        }
    });

    // Add an ActionListener to update the value in the data model when the user selects a value
    thanhtichComboBox.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             int editingRow = jt.getEditingRow();
        int editingColumn = jt.getEditingColumn();

        if (editingRow != -1 && editingColumn != -1) {
            updateSelectedRow(editingRow, thanhtichComboBox.getSelectedItem().toString());
        }
        }
    });
}

    private void updateSelectedRow(int selectedRow, String selectedValue) {
        DefaultTableModel model = (DefaultTableModel) jt.getModel();

        String qua;
        if ("Giỏi,thành tích đặc biệt".equals(selectedValue)) {
            qua = "10 cuốn vở";
        } else if ("Khá".equals(selectedValue)) {
            qua = "7 cuốn vở";
        } else if ("Khác".equals(selectedValue)) {
            qua = "5 cuốn vở";
        } else {
            qua = "";
        }

        int id = (int) model.getValueAt(selectedRow, 0);
        CapThuongHocDAO.getInstance().updateThanhTich(id, selectedValue, qua);
    }
}
