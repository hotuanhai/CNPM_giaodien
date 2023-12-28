
package model;
import java.sql.Date;

public class TamVang {
    private String    noitamtru;
    private Date Datefrom,Dateto;
    private int id;
    private int ma_tamvang;

    public TamVang(String noitamtru, Date Datefrom, Date Dateto, int id, int ma_tamvang) {
        this.noitamtru = noitamtru;
        this.Datefrom = Datefrom;
        this.Dateto = Dateto;
        this.id = id;
        this.ma_tamvang = ma_tamvang;
    }

    public TamVang() {
    }

    public String getNoitamtru() {
        return noitamtru;
    }

    public void setNoitamtru(String noitamtru) {
        this.noitamtru = noitamtru;
    }

    public Date getDatefrom() {
        return Datefrom;
    }

    public void setDatefrom(Date Datefrom) {
        this.Datefrom = Datefrom;
    }

    public Date getDateto() {
        return Dateto;
    }

    public void setDateto(Date Dateto) {
        this.Dateto = Dateto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMa_tamvang() {
        return ma_tamvang;
    }

    public void setMa_tamvang(int ma_tamvang) {
        this.ma_tamvang = ma_tamvang;
    }

    @Override
    public String toString() {
        return "TamVang{" + "noitamtru=" + noitamtru + ", Datefrom=" + Datefrom + ", Dateto=" + Dateto + ", id=" + id + ", ma_tamvang=" + ma_tamvang + '}';
    }

   

    
     

   
}
