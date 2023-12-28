
package view.user;

import controller.UserListener;
import dao.NhanKhauDAO;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import model.NhanKhau;

public class UserView extends JFrame{
    private JLabel jLabel;
    private String ma_hk;
    public UserView(String ma) {
        this.ma_hk=ma;
	this.setSize(500, 500);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
        
        ActionListener ul = new UserListener(this);
        
        JMenuBar jMenuBar = new JMenuBar();
		
		//Tao 1 menu
	JMenu jMenu_information = new JMenu("Xem thông tin");
		//Tao cac menu con
	JMenuItem jMenuItem_hokhau = new JMenuItem("Hộ khẩu");
	jMenuItem_hokhau.addActionListener(ul);
		
	JMenuItem jMenuItem_nhankhau = new JMenuItem("Nhân khẩu");
	jMenuItem_nhankhau.addActionListener(ul);
		
	jMenu_information.add(jMenuItem_hokhau);
	jMenu_information.addSeparator();
	jMenu_information.add(jMenuItem_nhankhau);
		
	JMenu jMenu_xingiay = new JMenu("Xin giấy");
	JMenuItem jMenuItem_tamtru = new JMenuItem("Tạm trú");
	jMenuItem_tamtru.addActionListener(ul);
                
        JMenuItem jMenuItem_tamvang = new JMenuItem("Tạm vắng");
	jMenuItem_tamvang.addActionListener(ul);
		
	jMenu_xingiay.add(jMenuItem_tamtru);
	jMenu_xingiay.addSeparator();
	jMenu_xingiay.add(jMenuItem_tamvang);
		
	JMenu jMenu_minhchung = new JMenu("Minh chứng");
		
	jMenuBar.add(jMenu_information);
	jMenuBar.add(jMenu_xingiay);
	jMenuBar.add(jMenu_minhchung);
        this.setJMenuBar(jMenuBar);
		
		//Tao label hien thi
	Font font = new Font("Arial", Font.BOLD, 50);
	jLabel = new JLabel();
		
	this.setLayout(new BorderLayout());
		
	this.add(jLabel, BorderLayout.CENTER);
		
	this.setVisible(true);
    }
    
    
    public void setTextJLabel(String s) {
		this.jLabel.setText(s);
	}
    public void innhankhau(){
        ArrayList<NhanKhau> nhankhau=  NhanKhauDAO.getInstance().selectByHoKhau(ma_hk);
        for(NhanKhau nk : nhankhau){
            System.out.println(nk.toString());
        }
    }
}
