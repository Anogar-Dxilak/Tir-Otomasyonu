package application;

import java.sql.Timestamp;

public class Soforler {
    private int �of�rID;
    private String ad;
    private String soyad;
    private String tel_no;
    private Timestamp kay�t_tarihi;
    private String durumu;

    public Soforler(int id, String ad, String soyad, String telno, Timestamp kay�ttarihi, String durumu) {
        this.�of�rID = id;
        this.ad = ad;
        this.soyad = soyad;
        this.tel_no = telno;
        this.kay�t_tarihi = kay�ttarihi;
        this.durumu = durumu;
    }

    public int get�of�rID() {
        return �of�rID;
    }

    public void set�of�rID(int �of�rID) {
        this.�of�rID = �of�rID;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTel_no() {
        return tel_no;
    }

    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
    }

    public Timestamp getKay�t_tarihi() {
        return kay�t_tarihi;
    }

    public void setKay�t_tarihi(Timestamp kay�t_tarihi) {
        this.kay�t_tarihi = kay�t_tarihi;
    }

    public String getDurumu() {
        return durumu;
    }

    public void setDurumu(String durumu) {
        this.durumu = durumu;
    }
}
