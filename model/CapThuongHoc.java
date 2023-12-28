
package model;

public class CapThuongHoc {
    private int id;
    private String ten;
    private String ma_hk;
    private String thanhtich;
    private String qua;

    public CapThuongHoc() {
    }

    public CapThuongHoc(int id, String ten, String ma_hk, String thanhtich, String qua) {
        this.id = id;
        this.ten = ten;
        this.ma_hk = ma_hk;
        this.thanhtich = thanhtich;
        this.qua = qua;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMa_hk() {
        return ma_hk;
    }

    public void setMa_hk(String ma_hk) {
        this.ma_hk = ma_hk;
    }

    public String getThanhtich() {
        return thanhtich;
    }

    public void setThanhtich(String thanhtich) {
        this.thanhtich = thanhtich;
    }

    public String getQua() {
        return qua;
    }

    public void setQua(String qua) {
        this.qua = qua;
    }
    
}
