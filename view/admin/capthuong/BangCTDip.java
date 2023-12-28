
package view.admin.capthuong;

import controller.CapThuongListener;
import dao.TenCapThuongDipDAO;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.CapThuongDip;

public class BangCTDip extends JFrame{
    JTable jt;
    JScrollPane js;
    String[] col;
    DefaultTableModel tableModel;
    
    public BangCTDip(){
        setTitle("Tên phần thưởng");
        setSize(800, 600);
        setLocationRelativeTo(null);
       
        ActionListener ac = new CapThuongListener(this);
        
        this.setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(1, 1));
        inputPanel.add(new JLabel("Danh sách phần thưởng:"));
        
        
        col = new String[]{"Mã thưởng","Dịp","Tên quà","Số tiền"};
        tableModel = new DefaultTableModel(col, 0);
        jt = new JTable(tableModel);
        js = new JScrollPane(jt);
        taobang();
        
        
        JPanel btnPanel = new JPanel(new FlowLayout());
        JButton btn_suathuong = new JButton("Sửa phần thưởng");
        btn_suathuong.addActionListener(ac);
        JButton btn_xoathuong = new JButton("Xóa phần thưởng");
        btn_xoathuong.addActionListener(ac);
        //btnPanel.add(btn_suathuong);
        btnPanel.add(btn_xoathuong);
        
        this.add(js,BorderLayout.CENTER);
        this.add(inputPanel, BorderLayout.NORTH); 
        this.add(btnPanel,BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    public void deleteSelectedRow() {
        int selectedRow = jt.getSelectedRow();
        if (selectedRow != -1) {
            // Get data from the selected row
            String maThuong = (String) jt.getValueAt(selectedRow, 0);
            String dip = (String) jt.getValueAt(selectedRow, 1);
            CapThuongDip ctd = new CapThuongDip();
            ctd.setDip(dip);
            ctd.setMa_thuong(maThuong);
            // Confirm with the user before deletion
            int option = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa dòng này?",
                    "Confirm Deletion", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                //model.deleteData(maThuong);
                //updateTable(); 
                TenCapThuongDipDAO.getInstance().delete(ctd);
                // Update the view
                taobang();
                
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
        }
    }
    
    public void taobang(){
        ArrayList<CapThuongDip> ctd = TenCapThuongDipDAO.getInstance().selectAll();
        tableModel.setRowCount(0); // Clear existing data
        for (CapThuongDip capThuongDip : ctd) {
            tableModel.addRow(new Object[]{capThuongDip.getMa_thuong(), capThuongDip.getDip(), capThuongDip.getTen_qua(),capThuongDip.getSotien()});
        }
    }
    
    
}
