package view.admin;

import dao.NhanKhauDAO;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.NhanKhau;
import java.sql.Date;
import javax.swing.table.TableColumn;

public class BangNK extends JFrame {
    JTable jt;
    JScrollPane js;
    String[] col;

    public BangNK() {
        ArrayList<NhanKhau> nk = NhanKhauDAO.getInstance().selectAll();
        setTitle("Bảng thông tin");

        // Get the screen size
        int screenWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

        setSize(screenWidth, screenHeight); // Set the size to full screen
        setLocationRelativeTo(null);

        col = new String[]{"ID", "Tên", "Ngày sinh", "Ghi chú", "Quan hệ", "Mã hộ khẩu", "Bí danh", "Giới tính", "Dân tộc", "Quê quán",
            "Tôn giáo", "Nghề nghiệp", "Nơi làm", "CCCD", "Ngày cấp", "Nơi cấp", "Nơi thường trú trước", "Ngày chuyển", "Địa chỉ"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        jt = new JTable(tableModel);
        js = new JScrollPane(jt);

        for (int i = 0; i < nk.size(); i++) {
            int id = nk.get(i).getId();
            String ten = nk.get(i).getTen();
            Date ngaysinh = nk.get(i).getNgaySinh();
            String note = nk.get(i).getNote();
            String quanhe = nk.get(i).getQuanHe();
            String mahk = nk.get(i).getMa_hk();
            String bidanh = nk.get(i).getBiDanh();

            String gioitinh = "";
            int gt = nk.get(i).getGioiTinh();
            if (gt == 0) {
                gioitinh = "Nữ";
            } else if (gt == 1) {
                gioitinh = "Nam";
            }

            String dantoc = nk.get(i).getDanToc();
            String quequan = nk.get(i).getQueQuan();
            String tongiao = nk.get(i).getTonGiao();
            String nghe = nk.get(i).getNgheNghiep();
            String noilam = nk.get(i).getNoiLam();
            String cccd = nk.get(i).getCccd();
            Date ngaycap = nk.get(i).getNgayCap();
            String noicap = nk.get(i).getNoiCap();
            String nttt = nk.get(i).getNoiTTTruoc();
            Date ngaychuyen = nk.get(i).getNgaychuyen();
            String diachi = nk.get(i).getAddress();

            Object[] data = {id, ten, ngaysinh, note, quanhe, mahk, bidanh, gioitinh, dantoc, quequan,
                tongiao, nghe, noilam, cccd, ngaycap, noicap, nttt, ngaychuyen, diachi};
            tableModel.addRow(data);
        }

        this.add(js);
        this.pack();
        this.setVisible(true);
    }

    public static void setJTableColumnsWidth(JTable table, int tablePreferredWidth, double... percentages) {
        double total = 0;
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            total += percentages[i];
        }

        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth((int) (tablePreferredWidth * (percentages[i] / total)));
        }
    }
}
