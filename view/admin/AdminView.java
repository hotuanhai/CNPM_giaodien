package view.admin;

import controller.AdminListener;
import dao.HoKhauDAO;
import dao.NhanKhauDAO;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import model.NhanKhau;
import model.SoHoKhau;

public class AdminView extends JFrame {
    private String macb;

    public AdminView(String chuc) {
        this.macb = chuc;
        System.out.println(this.macb);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        ActionListener av = new AdminListener(this);

        JMenuBar jMenuBar = new JMenuBar();

        JMenu jMenuQuanLyNhanKhauHoKhau = new JMenu("Quản lý nhân khẩu & hộ khẩu");

        // Yêu cầu xin giấy
        JMenu jMenuXinGiay = new JMenu("Yêu cầu xin giấy");
        JMenuItem jMenuItemTamTru = new JMenuItem("Tạm trú");
        jMenuItemTamTru.addActionListener(av);
        setPreferredWidth(jMenuItemTamTru, 200);

        JMenuItem jMenuItemTamVang = new JMenuItem("Tạm vắng");
        jMenuItemTamVang.addActionListener(av);
        setPreferredWidth(jMenuItemTamVang, 200);

        jMenuXinGiay.add(jMenuItemTamTru);
        jMenuXinGiay.addSeparator();
        jMenuXinGiay.add(jMenuItemTamVang);

        // Thay đổi nhân khẩu
        JMenu jMenuThayDoi = new JMenu("Thay đổi nhân khẩu");
        JMenuItem jMenuItemSinh = new JMenuItem("Mới sinh");
        jMenuItemSinh.addActionListener(av);
        setPreferredWidth(jMenuItemSinh, 200);

        JMenuItem jMenuItemKhaiTu = new JMenuItem("Khai tử");
        jMenuItemKhaiTu.addActionListener(av);
        setPreferredWidth(jMenuItemKhaiTu, 200);

        JMenuItem jMenuItemChuyen = new JMenuItem("Chuyển đi");
        jMenuItemChuyen.addActionListener(av);
        setPreferredWidth(jMenuItemChuyen, 200);

        jMenuThayDoi.add(jMenuItemSinh);
        jMenuThayDoi.addSeparator();
        jMenuThayDoi.add(jMenuItemKhaiTu);
        jMenuThayDoi.addSeparator();
        jMenuThayDoi.add(jMenuItemChuyen);

        // Thêm nhân khẩu
        JMenu jMenuThemNhanKhau = new JMenu("Thêm nhân khẩu");
        JMenuItem jMenuItemFile = new JMenuItem("File txt");
        jMenuItemFile.addActionListener(av);
        setPreferredWidth(jMenuItemFile, 200);

        JMenuItem jMenuItemTrucTiep = new JMenuItem("Trực tiếp");
        jMenuItemTrucTiep.addActionListener(av);
        setPreferredWidth(jMenuItemTrucTiep, 200);

        jMenuThemNhanKhau.add(jMenuItemFile);
        jMenuThemNhanKhau.addSeparator();
        jMenuThemNhanKhau.add(jMenuItemTrucTiep);

        // Thêm hộ khẩu
        JMenuItem jMenuThemHoKhau = new JMenuItem("Thêm hộ khẩu");
        jMenuThemHoKhau.addActionListener(av);
        setPreferredWidth(jMenuThemHoKhau, 200);
        
        JMenuItem jMenuItemTachHoKhau = new JMenuItem("Tách hộ khẩu");
        jMenuItemTachHoKhau.addActionListener(av);
        
        jMenuQuanLyNhanKhauHoKhau.add(jMenuXinGiay);
        jMenuQuanLyNhanKhauHoKhau.add(jMenuThayDoi);
        jMenuQuanLyNhanKhauHoKhau.add(jMenuThemNhanKhau);
        jMenuQuanLyNhanKhauHoKhau.add(jMenuThemHoKhau);
        jMenuQuanLyNhanKhauHoKhau.add(jMenuItemTachHoKhau);
        // Remaining menu items
        JMenu jMenuThuchi = new JMenu("Quản lý thu phí");
        JMenuItem jMenuItemThuphi = new JMenuItem("Thu phí");
        jMenuItemThuphi.addActionListener(av);
        setPreferredWidth(jMenuItemThuphi, 200);

        JMenuItem jMenuItemDonggop = new JMenuItem("Đóng góp");
        jMenuItemDonggop.addActionListener(av);
        setPreferredWidth(jMenuItemDonggop, 200);

        jMenuThuchi.add(jMenuItemThuphi);
        jMenuThuchi.add(jMenuItemDonggop);

        JMenuItem jMenuItemCapthuong = new JMenuItem("Quản lý cấp thưởng");
        jMenuItemCapthuong.addActionListener(av);
        setPreferredWidth(jMenuItemCapthuong, 200);

        jMenuBar.add(jMenuQuanLyNhanKhauHoKhau);
        jMenuBar.add(jMenuThuchi);
        jMenuBar.add(jMenuItemCapthuong);

        this.setJMenuBar(jMenuBar);
        this.setVisible(true);
    }

    private void setPreferredWidth(JMenuItem jMenuItem, int width) {
        Dimension dimension = new Dimension(width, jMenuItem.getPreferredSize().height);
        jMenuItem.setPreferredSize(dimension);
    }

    public void innhankhau() {
        new BangNK();
    }

    public void inhokhau() {

        new BangHK();
    }
}
