
package model;

public class TrangThaiThu {
    private String ma_thu;
    private String ma_hk;
    private int trangthai;

    public TrangThaiThu() {
    }

    public TrangThaiThu(String ma_thu, String ma_hk, int trangthai) {
        this.ma_thu = ma_thu;
        this.ma_hk = ma_hk;
        this.trangthai = trangthai;
    }

    public String getMa_thu() {
        return ma_thu;
    }

    public void setMa_thu(String ma_thu) {
        this.ma_thu = ma_thu;
    }

    public String getMa_hk() {
        return ma_hk;
    }

    public void setMa_hk(String ma_hk) {
        this.ma_hk = ma_hk;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    
}
