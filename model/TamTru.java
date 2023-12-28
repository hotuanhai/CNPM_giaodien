package model;

import java.sql.Date;


public class TamTru {
    private String   lydo, noitamtru;
    private int thoigian;
    private int id;
    private int ma_tamtru;

    public TamTru(String lydo, String noitamtru, int thoigian, int id, int ma_tamtru) {
        this.lydo = lydo;
        this.noitamtru = noitamtru;
        this.thoigian = thoigian;
        this.id = id;
        this.ma_tamtru = ma_tamtru;
    }

    public TamTru() {
    }

    public String getLydo() {
        return lydo;
    }

    public void setLydo(String lydo) {
        this.lydo = lydo;
    }

    public String getNoitamtru() {
        return noitamtru;
    }

    public void setNoitamtru(String noitamtru) {
        this.noitamtru = noitamtru;
    }

    public int getThoigian() {
        return thoigian;
    }

    public void setThoigian(int thoigian) {
        this.thoigian = thoigian;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMa_tamtru() {
        return ma_tamtru;
    }

    public void setMa_tamtru(int ma_tamtru) {
        this.ma_tamtru = ma_tamtru;
    }

    
    
    
}
