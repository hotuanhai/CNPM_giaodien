
package model;

import java.sql.Date;

public class KhoanThu {
    private String ma_thu;
    private Date ngay;
    private int sotien;

    public KhoanThu() {
    }

    public KhoanThu(String ma_thu, Date ngay, int sotien) {
        this.ma_thu = ma_thu;
        this.ngay = ngay;
        this.sotien = sotien;
    }

    @Override
    public String toString() {
        return "KhoanThu{" + "ma_thu=" + ma_thu + ", ngay=" + ngay + ", sotien=" + sotien + '}';
    }

    public String getMa_thu() {
        return ma_thu;
    }

    public void setMa_thu(String ma_thu) {
        this.ma_thu = ma_thu;
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
    
}
