package model;

import java.sql.Date;

public class NhanKhau {
    private int id;
    private String ten;
    private Date ngaySinh;    
    private String note;
    private String quanHe;
    private String ma_hk;
    private String biDanh;
    private int gioiTinh;
    private String danToc;
    private String queQuan;
    private String tonGiao;
    private String ngheNghiep;
    private String noiLam;
    private String cccd;
    private Date ngayCap;
    private String noiCap;
    private String noiTTTruoc;
    private Date ngaychuyen;
    private String address;

    public NhanKhau() {
    }

    public NhanKhau(int id, String ten, Date ngaySinh, String note, String quanHe, String ma_hk, String biDanh, int gioiTinh, String danToc, String queQuan, String tonGiao, String ngheNghiep, String noiLam, String cccd, Date ngayCap, String noiCap, String noiTTTruoc, Date ngaychuyen, String address) {
        this.id = id;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.note = note;
        this.quanHe = quanHe;
        this.ma_hk = ma_hk;
        this.biDanh = biDanh;
        this.gioiTinh = gioiTinh;
        this.danToc = danToc;
        this.queQuan = queQuan;
        this.tonGiao = tonGiao;
        this.ngheNghiep = ngheNghiep;
        this.noiLam = noiLam;
        this.cccd = cccd;
        this.ngayCap = ngayCap;
        this.noiCap = noiCap;
        this.noiTTTruoc = noiTTTruoc;
        this.ngaychuyen = ngaychuyen;
        this.address = address;
    }

    public NhanKhau(int id, String ten, Date ngaySinh, String note, String quanHe, String ma_hk, String biDanh, int gioiTinh, String danToc, String queQuan, String tonGiao, String ngheNghiep, String noiLam, String cccd, Date ngayCap, String noiCap, String noiTTTruoc, Date ngaychuyen) {
        this.id = id;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.note = note;
        this.quanHe = quanHe;
        this.ma_hk = ma_hk;
        this.biDanh = biDanh;
        this.gioiTinh = gioiTinh;
        this.danToc = danToc;
        this.queQuan = queQuan;
        this.tonGiao = tonGiao;
        this.ngheNghiep = ngheNghiep;
        this.noiLam = noiLam;
        this.cccd = cccd;
        this.ngayCap = ngayCap;
        this.noiCap = noiCap;
        this.noiTTTruoc = noiTTTruoc;
        this.ngaychuyen = ngaychuyen;
    }

    public NhanKhau(int id, String ten, Date ngaySinh, int gioiTinh, String cccd) {
        this.id = id;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.cccd = cccd;
    }

    @Override
    public String toString() {
        return "NhanKhau{" + "id=" + id + ", ten=" + ten + ", ngaySinh=" + ngaySinh + ", note=" + note + ", quanHe=" + quanHe + ", ma_hk=" + ma_hk + ", biDanh=" + biDanh + ", gioiTinh=" + gioiTinh + ", danToc=" + danToc + ", queQuan=" + queQuan + ", tonGiao=" + tonGiao + ", ngheNghiep=" + ngheNghiep + ", noiLam=" + noiLam + ", cccd=" + cccd + ", ngayCap=" + ngayCap + ", noiCap=" + noiCap + ", noiTTTruoc=" + noiTTTruoc + ", ngaychuyen=" + ngaychuyen + ", address=" + address + '}';
    }

    

    
//    public String toString1() {
//        return "NhanKhau{" + "id=" + id + ", ten=" + ten + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", ngheNghiep=" + ngheNghiep + ", cccd=" + cccd + '}';
//    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getQuanHe() {
        return quanHe;
    }

    public void setQuanHe(String quanHe) {
        this.quanHe = quanHe;
    }

    public String getMa_hk() {
        return ma_hk;
    }

    public void setMa_hk(String ma_hk) {
        this.ma_hk = ma_hk;
    }

    public String getBiDanh() {
        return biDanh;
    }

    public void setBiDanh(String biDanh) {
        this.biDanh = biDanh;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getTonGiao() {
        return tonGiao;
    }

    public void setTonGiao(String tonGiao) {
        this.tonGiao = tonGiao;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public String getNoiLam() {
        return noiLam;
    }

    public void setNoiLam(String noiLam) {
        this.noiLam = noiLam;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public Date getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(Date ngayCap) {
        this.ngayCap = ngayCap;
    }

    public String getNoiCap() {
        return noiCap;
    }

    public void setNoiCap(String noiCap) {
        this.noiCap = noiCap;
    }

    public String getNoiTTTruoc() {
        return noiTTTruoc;
    }

    public void setNoiTTTruoc(String noiTTTruoc) {
        this.noiTTTruoc = noiTTTruoc;
    }

    public Date getNgaychuyen() {
        return ngaychuyen;
    }

    public void setNgaychuyen(Date ngaychuyen) {
        this.ngaychuyen = ngaychuyen;
    }

    

   
    
}
