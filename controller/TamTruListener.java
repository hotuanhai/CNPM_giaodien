/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.admin.paper.BangTamTru;
import view.admin.paper.XinTamTru;

/**
 *
 * @author Admin
 */
public class TamTruListener implements ActionListener{
    private XinTamTru xtt;
    private BangTamTru btt;
    public TamTruListener(BangTamTru btt){
        this.btt=btt;
    }
    public TamTruListener(XinTamTru xtt ){
        this.xtt = xtt;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if(src.equals("Nộp đơn")){
            this.xtt.saveToAttributes();
        }
        else if(src.equals("Xóa giấy tạm trú")){
            this.btt.deleteSelectedRow();
        }
        else if(src.equals("Danh sách tạm trú")){
            this.xtt.bangTT();
        }
    }
    
}
