package application;

import java.sql.Timestamp;

public class Odeme {
	private int odeme_id;
    private Timestamp �deme_tarihi;
    private Satislar sat��_id;
    private Urunler �r�n_id;
    private Musteriler m��teri_id;

     Odeme(int odeme_id, Timestamp �deme_tarihi, Satislar sat��_id, Urunler �r�n_id, Musteriler m��teri_id) {
        this.odeme_id = odeme_id;
    	this.�deme_tarihi = �deme_tarihi;
        this.sat��_id = sat��_id;
        this.�r�n_id = �r�n_id;
        this.m��teri_id = m��teri_id;
    }

	public int getOdeme_id() {
		return odeme_id;
	}

	public void setOdeme_id(int odeme_id) {
		this.odeme_id = odeme_id;
	}

	public Timestamp get�deme_tarihi() {
		return �deme_tarihi;
	}

	public void set�deme_tarihi(Timestamp �deme_tarihi) {
		this.�deme_tarihi = �deme_tarihi;
	}

	public Satislar getSat��_id() {
		return sat��_id;
	}

	public void setSat��_id(Satislar sat��_id) {
		this.sat��_id = sat��_id;
	}

	public Urunler get�r�n_id() {
		return �r�n_id;
	}

	public void set�r�n_id(Urunler �r�n_id) {
		this.�r�n_id = �r�n_id;
	}

	public Musteriler getM��teri_id() {
		return m��teri_id;
	}

	public void setM��teri_id(Musteriler m��teri_id) {
		this.m��teri_id = m��teri_id;
	}

}
