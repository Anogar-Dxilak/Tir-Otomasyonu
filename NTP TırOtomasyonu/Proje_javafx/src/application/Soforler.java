package application;

import java.sql.Timestamp;

public class Soforler {
    private int þoförID;
    private String ad;
    private String soyad;
    private String tel_no;
    private Timestamp kayýt_tarihi;
    private String durumu;

    public Soforler(int id, String ad, String soyad, String telno, Timestamp kayýttarihi, String durumu) {
        this.þoförID = id;
        this.ad = ad;
        this.soyad = soyad;
        this.tel_no = telno;
        this.kayýt_tarihi = kayýttarihi;
        this.durumu = durumu;
    }

    public int getÞoförID() {
        return þoförID;
    }

    public void setÞoförID(int þoförID) {
        this.þoförID = þoförID;
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

    public Timestamp getKayýt_tarihi() {
        return kayýt_tarihi;
    }

    public void setKayýt_tarihi(Timestamp kayýt_tarihi) {
        this.kayýt_tarihi = kayýt_tarihi;
    }

    public String getDurumu() {
        return durumu;
    }

    public void setDurumu(String durumu) {
        this.durumu = durumu;
    }
}
