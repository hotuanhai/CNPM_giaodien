
package model;

import java.sql.Date;

public class DongGop {
    private String ma_donggop;
    private Date ngay;
    private int sotien;
    private String ma_hk;

    public DongGop() {
    }

    public DongGop(String ma_donggop, Date ngay, int sotien, String ma_hk) {
        this.ma_donggop = ma_donggop;
        this.ngay = ngay;
        this.sotien = sotien;
        this.ma_hk = ma_hk;
    }

    @Override
    public String toString() {
        return "DongGop{" + "ma_donggop=" + ma_donggop + ", ngay=" + ngay + ", sotien=" + sotien + ", ma_hk=" + ma_hk + '}';
    }
    
    public String getMa_donggop() {
        return ma_donggop;
    }

    public void setMa_donggop(String ma_donggop) {
        this.ma_donggop = ma_donggop;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public int getSotien() {
        return sotien;
    }

    public void setSotien(int sotien) {
        this.sotien = sotien;
    }

    public String getMa_hk() {
        return ma_hk;
    }

    public void setMa_hk(String ma_hk) {
        this.ma_hk = ma_hk;
    }
    
}
