package application;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Satislar {
    private int satýþID;
    private Urunler ürünID;
    private Musteriler müþteriID;
    private Araçlar araçID;
    private Soforler soförID;
    private BigDecimal miktar;
    private BigDecimal toplam_fiyat;
    private Timestamp satýþ_tarihi;
    private String ödeme_durumu;

    public Satislar() {
        this.ödeme_durumu = "Ödenmedi";
    }

    public Satislar(int satýþID, Urunler ürünID, Musteriler müþteriID, Araçlar araçID, Soforler soförID, BigDecimal miktar, BigDecimal toplamfiyat, Timestamp satýþtarihi, String ödemedurumu) {
        this.satýþID = satýþID;
        this.ürünID = ürünID;
        this.müþteriID = müþteriID;
        this.araçID = araçID;
        this.soförID = soförID;
        this.miktar = miktar;
        this.toplam_fiyat = toplamfiyat;
        this.satýþ_tarihi = satýþtarihi;
        this.ödeme_durumu = ödemedurumu;
    }
    
    public int getSatýþID() {
        return satýþID;
    }

    public void setSatýþID(int satýþID) {
        this.satýþID = satýþID;
    }

    public Urunler getÜrünID() {
        return ürünID;
    }

    public void setÜrünID(Urunler ürünID) {
        this.ürünID = ürünID;
    }

    public Musteriler getMüþteriID() {
        return müþteriID;
    }

    public void setMüþteriID(Musteriler müþteriID) {
        this.müþteriID = müþteriID;
    }

    public Araçlar getAraçID() {
        return araçID;
    }

    public void setAraçID(Araçlar araçID) {
        this.araçID = araçID;
    }

    public Soforler getSoförID() {
        return soförID;
    }

    public void setSoförID(Soforler soförID) {
        this.soförID = soförID;
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

    public Timestamp getSatýþ_tarihi() {
        return satýþ_tarihi;
    }

    public void setSatýþ_tarihi(Timestamp satýþ_tarihi) {
        this.satýþ_tarihi = satýþ_tarihi;
    }

    public String getÖdeme_durumu() {
        return ödeme_durumu;
    }

    public void setÖdeme_durumu(String ödeme_durumu) {
        this.ödeme_durumu = ödeme_durumu;
    }
}
