
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import model.SoHoKhau;
import view.admin.AdminView;
import view.admin.BangHK;
import view.admin.BangNK;
import view.admin.ChuyenDi;
import view.admin.InputHoKhau;
import view.admin.InputNhanKhau;
import view.admin.KhaiSinh;
import view.admin.KhaiTu;
import view.admin.TachHoKhau;
import view.admin.TimKiemNKView;
import view.admin.UserInputFile;
import view.admin.capthuong.CapThuongDipView;
import view.admin.paper.XinTamTru;
import view.admin.paper.XinTamVang;
import view.admin.thuphi.DongGopView;
import view.admin.thuphi.ThuPhiView;

/**
 *
 * @author Admin
 */
public class AdminListener implements ActionListener{
    private InputNhanKhau ink;
    private UserInputFile uif;
    private AdminView av;
    private KhaiSinh ks;
    private InputHoKhau ihk;
    private KhaiTu kt;
    private ChuyenDi cd;
    private TachHoKhau thk;
    private ThuPhiView tpv;
    TimKiemNKView tknkv;
    private DongGopView dgv;
//    private XinTamVang xtv;
//    
//    public AdminListener(XinTamVang xtv){
//        this.xtv = xtv;
//    }
    public AdminListener(TimKiemNKView tknkv){
        this.tknkv = tknkv;
    }
    public AdminListener(DongGopView dgv){
        this.dgv = dgv;
    }
    public AdminListener(ThuPhiView tpv){
        this.tpv = tpv;
    }
    public AdminListener(TachHoKhau thk){
        this.thk=thk;
    }
    public AdminListener(ChuyenDi cd){
        this.cd=cd;
    }
    public AdminListener(KhaiTu kt){
        this.kt=kt;
    }
    public AdminListener(InputHoKhau ihk){
        this.ihk=ihk;
    }
    public AdminListener(KhaiSinh ks){
        this.ks = ks;
    }
    
    public AdminListener(UserInputFile uif){
        this.uif = uif;
    }
    public AdminListener(InputNhanKhau ink){
        this.ink = ink;
    }
    public AdminListener(AdminView av){
        this.av = av;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if(src.equals("Tai file txt")){
            try {
                this.uif.taifile();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AdminListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //admin
        else if(src.equals("File txt")){
            new UserInputFile();
        }
        else if(src.equals("Trực tiếp")){
            new InputNhanKhau();
        }
        else if(src.equals("thêm")){
            this.ink.them();
        }
        else if(src.equals("Xem nhân khẩu")){
            //System.out.println("hi");
            new BangNK();
        }
        else if(src.equals("Xem hộ khẩu")){
            //System.out.println("hi");
            new BangHK();
        }
        else if(src.equals("Mới sinh")){
            new KhaiSinh();
        }
        else if(src.equals("Tạm vắng")){
            new XinTamVang();
        }
        else if(src.equals("Tạm trú")){
            new XinTamTru();
        }
        else if(src.equals("Nộp khai sinh")){
            this.ks.saveToAttributes();
        }
        else if(src.equals("file txt")){
            System.out.println("fe");
        }
        else if(src.equals("Thêm hộ khẩu")){
            new InputHoKhau();
        }
        else if(src.equals("Tách hộ khẩu")){
            new TachHoKhau();
        }
        else if(src.equals("Thu phí")){
            new ThuPhiView();
        }
        else if(src.equals("Đóng góp")){
            new DongGopView();
        }
        else if(src.equals("Thêm vào hộ khẩu")){
            this.ihk.saveToAttributes();
        }
        else if(src.equals("Xác nhận khai tử")){
            this.kt.saveToAttributes();
        }
        else if(src.equals("Khai tử")){
            new KhaiTu();
        }
        else if(src.equals("Chuyển đi")){
            new ChuyenDi();
        }
        else if(src.equals("Nộp chuyển đi")){
            this.cd.saveToAttributes();
        }
        else if(src.equals("Nộp tách hộ khẩu")){
            this.thk.saveToAttributes();
        }
        else if(src.equals("Tìm kiếm")){
            this.tknkv.timkiem();
        }
        
        //thu phi view
        else if(src.equals("Thêm khoản thu")){
            this.tpv.themKhoanThu();
            
        }
        else if(src.equals("Xem tất cả")){
           this.tpv.bangttthu();
        }
        else if(src.equals("Xem hộ chưa đóng")){
           this.tpv.bangchuadong();
        }
        else if(src.equals("Tìm theo hộ")){
           this.tpv.bangtheo_hokhau();
        }
        //donggopview
        else if(src.equals("Thêm đóng góp")){
           this.dgv.themTenDongGop();
        }
        else if(src.equals("Xem đóng góp")){
           this.dgv.bangTenDongGop();
        }
        else if(src.equals("Thêm vào danh sách")){
           this.dgv.themDanhSach();
        }
        else if(src.equals("Tìm danh sách")){
           this.dgv.timDanhsach();
        }
        //capthuong
        else if(src.equals("Quản lý cấp thưởng")){
          new CapThuongDipView();
        }
    }
    
}
