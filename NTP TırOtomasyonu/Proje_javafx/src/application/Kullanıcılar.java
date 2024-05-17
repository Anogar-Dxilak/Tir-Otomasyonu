package application;
import java.sql.Timestamp;

public class Kullan�c�lar {
	private int kullan�c�ID;
	private String kullan�c�_ad�;
	private String �ifre;
	private String ad;
	private String soyad;
	private String eposta;
	private String tel_no;
	private String rol�;
	private Timestamp kay�t_tarihi;
	
	Kullan�c�lar(){
		this.rol�="kullan�c�";
	}
	Kullan�c�lar(int id, String usrname, String �ifre, String ad, String soyad, String eposta, String telno, String rol, Timestamp kayittarihi ){
		this.kullan�c�ID=id;
		this.kullan�c�_ad�=usrname;
		this.�ifre=�ifre;
		this.ad=ad;
		this.soyad=soyad;
		this.eposta=eposta;
		this.tel_no=telno;
		this.rol�=rol;
		this.kay�t_tarihi=kayittarihi;
	}
	public int getKullan�c�ID() {
		return kullan�c�ID;
	}
	public void setKullan�c�ID(int kullan�c�ID) {
		this.kullan�c�ID = kullan�c�ID;
	}
	public String getKullan�c�_ad�() {
		return kullan�c�_ad�;
	}
	public void setKullan�c�_ad�(String kullan�c�_ad�) {
		this.kullan�c�_ad� = kullan�c�_ad�;
	}
	public String get�ifre() {
		return �ifre;
	}
	public void set�ifre(String �ifre) {
		this.�ifre = �ifre;
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
	public String getRol�() {
		return rol�;
	}
	public void setRol�(String rol�) {
		this.rol� = rol�;
	}
	public Timestamp getKay�t_tarihi() {
		return kay�t_tarihi;
	}
	public void setKay�t_tarihi(Timestamp kay�t_tarihi) {
		this.kay�t_tarihi = kay�t_tarihi;
	}
	
}

