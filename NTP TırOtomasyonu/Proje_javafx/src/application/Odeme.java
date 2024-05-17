package application;

import java.sql.Timestamp;

public class Odeme {
	private int odeme_id;
    private Timestamp ödeme_tarihi;
    private Satislar satýþ_id;
    private Urunler ürün_id;
    private Musteriler müþteri_id;

     Odeme(int odeme_id, Timestamp ödeme_tarihi, Satislar satýþ_id, Urunler ürün_id, Musteriler müþteri_id) {
        this.odeme_id = odeme_id;
    	this.ödeme_tarihi = ödeme_tarihi;
        this.satýþ_id = satýþ_id;
        this.ürün_id = ürün_id;
        this.müþteri_id = müþteri_id;
    }

	public int getOdeme_id() {
		return odeme_id;
	}

	public void setOdeme_id(int odeme_id) {
		this.odeme_id = odeme_id;
	}

	public Timestamp getÖdeme_tarihi() {
		return ödeme_tarihi;
	}

	public void setÖdeme_tarihi(Timestamp ödeme_tarihi) {
		this.ödeme_tarihi = ödeme_tarihi;
	}

	public Satislar getSatýþ_id() {
		return satýþ_id;
	}

	public void setSatýþ_id(Satislar satýþ_id) {
		this.satýþ_id = satýþ_id;
	}

	public Urunler getÜrün_id() {
		return ürün_id;
	}

	public void setÜrün_id(Urunler ürün_id) {
		this.ürün_id = ürün_id;
	}

	public Musteriler getMüþteri_id() {
		return müþteri_id;
	}

	public void setMüþteri_id(Musteriler müþteri_id) {
		this.müþteri_id = müþteri_id;
	}

}
