package model;
import java.lang.*;
public class SoHoKhau {
    private String ma_hk;
    private String tenchuho;
    private String diachi;
    
     public SoHoKhau() {
    }

    public SoHoKhau(String ma_hk, String tenchuho, String diachi) {
        this.ma_hk = ma_hk;
        this.tenchuho = tenchuho;
        this.diachi = diachi;
    }

    public String getMa_hk() {
        return ma_hk;
    }

    public void setMa_hk(String ma_hk) {
        this.ma_hk = ma_hk;
    }

    public String getTenchuho() {
        return tenchuho;
    }

    public void setTenchuho(String tenchuho) {
        this.tenchuho = tenchuho;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    @Override
    public String toString() {
        return "SoHoKhau{" + "ma_hk=" + ma_hk + ", tenchuho=" + tenchuho + ", diachi=" + diachi + '}';
    }
    
    
}
