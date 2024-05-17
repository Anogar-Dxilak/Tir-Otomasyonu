package application;
import java.sql.Timestamp;
import java.math.BigDecimal;

public class Urunler {
	private int ürünID;
	private String ürün_adý;
 	private BigDecimal kilobaþý_fiyat;
	private BigDecimal toplam_kg;
	private String ürün_durumu;
	private Timestamp kayýt_tarihi;
	
	Urunler(int id, String urunad, BigDecimal kilofiyati, BigDecimal toplamkg, String üründurumu, Timestamp geliþtarihi) {
		this.ürünID=id;
		this.ürün_adý=urunad;
		this.kilobaþý_fiyat=kilofiyati;
		this.toplam_kg=toplamkg;
		this.ürün_durumu=üründurumu;
		this.kayýt_tarihi=geliþtarihi;
	}

	public int getÜrünID() {
		return ürünID;
	}

	public void setÜrünID(int ürünID) {
		this.ürünID = ürünID;
	}

	public String getÜrün_adý() {
		return ürün_adý;
	}

	public void setÜrün_adý(String ürün_adý) {
		this.ürün_adý = ürün_adý;
	}

	public BigDecimal getKilobaþý_fiyat() {
		return kilobaþý_fiyat;
	}

	public void setKilobaþý_fiyat(BigDecimal kilobaþý_fiyat) {
		this.kilobaþý_fiyat = kilobaþý_fiyat;
	}

	public BigDecimal getToplam_kg() {
		return toplam_kg;
	}

	public void setToplam_kg(BigDecimal toplam_kg) {
		this.toplam_kg = toplam_kg;
	}

	public String getÜrün_durumu() {
		return ürün_durumu;
	}

	public void setÜrün_durumu(String ürün_durumu) {
		this.ürün_durumu = ürün_durumu;
	}

	public Timestamp getKayýt_tarihi() {
		return kayýt_tarihi;
	}

	public void setKayýt_tarihi(Timestamp kayýt_tarihi) {
		this.kayýt_tarihi = kayýt_tarihi;
	}
	
}
