
package model;

public class CapThuongDip {
    private String ma_thuong;
    private String ten_qua;
    private String dip;
    private int sotien;

    public CapThuongDip() {
    }

    public CapThuongDip(String ma_thuong, String dip, int sotien) {
        this.ma_thuong = ma_thuong;
        this.dip = dip;
        this.sotien = sotien;
    }

    public CapThuongDip(String ma_thuong, String ten_qua, String dip, int sotien) {
        this.ma_thuong = ma_thuong;
        this.ten_qua = ten_qua;
        this.dip = dip;
        this.sotien = sotien;
    }

    public String getTen_qua() {
        return ten_qua;
    }

    public void setTen_qua(String ten_qua) {
        this.ten_qua = ten_qua;
    }

    public String getMa_thuong() {
        return ma_thuong;
    }

    public void setMa_thuong(String ma_thuong) {
        this.ma_thuong = ma_thuong;
    }

    public String getDip() {
        return dip;
    }

    public void setDip(String dip) {
        this.dip = dip;
    }

    public int getSotien() {
        return sotien;
    }

    public void setSotien(int sotien) {
        this.sotien = sotien;
    }
    
}
