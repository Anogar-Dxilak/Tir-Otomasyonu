package application;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Satislar {
    private int sat��ID;
    private Urunler �r�nID;
    private Musteriler m��teriID;
    private Ara�lar ara�ID;
    private Soforler sof�rID;
    private BigDecimal miktar;
    private BigDecimal toplam_fiyat;
    private Timestamp sat��_tarihi;
    private String �deme_durumu;

    public Satislar() {
        this.�deme_durumu = "�denmedi";
    }

    public Satislar(int sat��ID, Urunler �r�nID, Musteriler m��teriID, Ara�lar ara�ID, Soforler sof�rID, BigDecimal miktar, BigDecimal toplamfiyat, Timestamp sat��tarihi, String �demedurumu) {
        this.sat��ID = sat��ID;
        this.�r�nID = �r�nID;
        this.m��teriID = m��teriID;
        this.ara�ID = ara�ID;
        this.sof�rID = sof�rID;
        this.miktar = miktar;
        this.toplam_fiyat = toplamfiyat;
        this.sat��_tarihi = sat��tarihi;
        this.�deme_durumu = �demedurumu;
    }
    
    public int getSat��ID() {
        return sat��ID;
    }

    public void setSat��ID(int sat��ID) {
        this.sat��ID = sat��ID;
    }

    public Urunler get�r�nID() {
        return �r�nID;
    }

    public void set�r�nID(Urunler �r�nID) {
        this.�r�nID = �r�nID;
    }

    public Musteriler getM��teriID() {
        return m��teriID;
    }

    public void setM��teriID(Musteriler m��teriID) {
        this.m��teriID = m��teriID;
    }

    public Ara�lar getAra�ID() {
        return ara�ID;
    }

    public void setAra�ID(Ara�lar ara�ID) {
        this.ara�ID = ara�ID;
    }

    public Soforler getSof�rID() {
        return sof�rID;
    }

    public void setSof�rID(Soforler sof�rID) {
        this.sof�rID = sof�rID;
    }

    public BigDecimal getMiktar() {
        return miktar;
    }

    public void setMiktar(BigDecimal miktar) {
        this.miktar = miktar;
    }

    public BigDecimal getToplam_fiyat() {
        return toplam_fiyat;
    }

    public void setToplam_fiyat(BigDecimal toplam_fiyat) {
        this.toplam_fiyat = toplam_fiyat;
    }

    public Timestamp getSat��_tarihi() {
        return sat��_tarihi;
    }

    public void setSat��_tarihi(Timestamp sat��_tarihi) {
        this.sat��_tarihi = sat��_tarihi;
    }

    public String get�deme_durumu() {
        return �deme_durumu;
    }

    public void set�deme_durumu(String �deme_durumu) {
        this.�deme_durumu = �deme_durumu;
    }
}
