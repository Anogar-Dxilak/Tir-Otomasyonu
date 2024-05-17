package application;
import java.sql.Timestamp;
import java.math.BigDecimal;

public class Urunler {
	private int �r�nID;
	private String �r�n_ad�;
 	private BigDecimal kiloba��_fiyat;
	private BigDecimal toplam_kg;
	private String �r�n_durumu;
	private Timestamp kay�t_tarihi;
	
	Urunler(int id, String urunad, BigDecimal kilofiyati, BigDecimal toplamkg, String �r�ndurumu, Timestamp geli�tarihi) {
		this.�r�nID=id;
		this.�r�n_ad�=urunad;
		this.kiloba��_fiyat=kilofiyati;
		this.toplam_kg=toplamkg;
		this.�r�n_durumu=�r�ndurumu;
		this.kay�t_tarihi=geli�tarihi;
	}

	public int get�r�nID() {
		return �r�nID;
	}

	public void set�r�nID(int �r�nID) {
		this.�r�nID = �r�nID;
	}

	public String get�r�n_ad�() {
		return �r�n_ad�;
	}

	public void set�r�n_ad�(String �r�n_ad�) {
		this.�r�n_ad� = �r�n_ad�;
	}

	public BigDecimal getKiloba��_fiyat() {
		return kiloba��_fiyat;
	}

	public void setKiloba��_fiyat(BigDecimal kiloba��_fiyat) {
		this.kiloba��_fiyat = kiloba��_fiyat;
	}

	public BigDecimal getToplam_kg() {
		return toplam_kg;
	}

	public void setToplam_kg(BigDecimal toplam_kg) {
		this.toplam_kg = toplam_kg;
	}

	public String get�r�n_durumu() {
		return �r�n_durumu;
	}

	public void set�r�n_durumu(String �r�n_durumu) {
		this.�r�n_durumu = �r�n_durumu;
	}

	public Timestamp getKay�t_tarihi() {
		return kay�t_tarihi;
	}

	public void setKay�t_tarihi(Timestamp kay�t_tarihi) {
		this.kay�t_tarihi = kay�t_tarihi;
	}
	
}
