package application;
import java.sql.Timestamp;

public class Kullanýcýlar {
	private int kullanýcýID;
	private String kullanýcý_adý;
	private String þifre;
	private String ad;
	private String soyad;
	private String eposta;
	private String tel_no;
	private String rolü;
	private Timestamp kayýt_tarihi;
	
	Kullanýcýlar(){
		this.rolü="kullanýcý";
	}
	Kullanýcýlar(int id, String usrname, String þifre, String ad, String soyad, String eposta, String telno, String rol, Timestamp kayittarihi ){
		this.kullanýcýID=id;
		this.kullanýcý_adý=usrname;
		this.þifre=þifre;
		this.ad=ad;
		this.soyad=soyad;
		this.eposta=eposta;
		this.tel_no=telno;
		this.rolü=rol;
		this.kayýt_tarihi=kayittarihi;
	}
	public int getKullanýcýID() {
		return kullanýcýID;
	}
	public void setKullanýcýID(int kullanýcýID) {
		this.kullanýcýID = kullanýcýID;
	}
	public String getKullanýcý_adý() {
		return kullanýcý_adý;
	}
	public void setKullanýcý_adý(String kullanýcý_adý) {
		this.kullanýcý_adý = kullanýcý_adý;
	}
	public String getÞifre() {
		return þifre;
	}
	public void setÞifre(String þifre) {
		this.þifre = þifre;
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
	public String getEposta() {
		return eposta;
	}
	public void setEposta(String eposta) {
		this.eposta = eposta;
	}
	public String getTel_no() {
		return tel_no;
	}
	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}
	public String getRolü() {
		return rolü;
	}
	public void setRolü(String rolü) {
		this.rolü = rolü;
	}
	public Timestamp getKayýt_tarihi() {
		return kayýt_tarihi;
	}
	public void setKayýt_tarihi(Timestamp kayýt_tarihi) {
		this.kayýt_tarihi = kayýt_tarihi;
	}
	
}

