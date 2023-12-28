
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.admin.capthuong.BangCTDip;
import view.admin.capthuong.BangHocSinh;
import view.admin.capthuong.CapThuongDipView;

public class CapThuongListener implements ActionListener{
    private CapThuongDipView ctdv;
    private BangCTDip bctd;
    private BangHocSinh bhs;
    public CapThuongListener(BangHocSinh bhs){
        this.bhs=bhs;
    }
    public CapThuongListener(BangCTDip bctd){
        this.bctd= bctd;
    }
    public CapThuongListener(CapThuongDipView ctdv){
        this.ctdv = ctdv;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if(src.equals("Thêm phần thưởng")){
            this.ctdv.themPT();
        }
        else if(src.equals("Tìm theo hộ")){
            this.ctdv.timTheoHo();
        }
        else if(src.equals("Xem phần thưởng")){
            this.ctdv.xemPT();
        }
        else if(src.equals("Xóa phần thưởng")){
            this.bctd.deleteSelectedRow();
            //this.ctdv.phatPT();
        }
        else if(src.equals("Danh sách học sinh")){
            this.ctdv.danhsach_hs();
            //this.ctdv.phatPT();
        }
    }
    
}
