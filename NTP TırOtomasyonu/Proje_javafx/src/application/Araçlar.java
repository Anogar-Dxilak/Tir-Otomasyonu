package application;

public class Ara�lar {
	private int ara�ID;
	private String plaka;
	private String marka;
	private String y�l;
	private String ara�_tipi;
	private String durum;
	private String km;
	private String bak�m�;
	private String yak�t_t�r�;
	private Soforler �of�rID;
	
	Ara�lar(int id, String plaka, String marka, String y�l, String ara�tipi, String durumu, String km, String bak�m�, String yak�t�, Soforler �of�rID){
		this.ara�ID=id;
		this.plaka=plaka;
		this.marka=marka;
		this.y�l=y�l;
		this.ara�_tipi=ara�tipi;
		this.durum=durumu;
		this.km=km;
		this.bak�m�=bak�m�;
		this.yak�t_t�r�=yak�t�;
		this.�of�rID=�of�rID;
	}

	public int getAra�ID() {
		return ara�ID;
	}

	public void setAra�ID(int ara�ID) {
		this.ara�ID = ara�ID;
	}

	public String getPlaka() {
		return plaka;
	}

	public void setPlaka(String plaka) {
		this.plaka = plaka;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getY�l() {
		return y�l;
	}

	public void setY�l(String y�l) {
		this.y�l = y�l;
	}

	public String getAra�_tipi() {
		return ara�_tipi;
	}

	public void setAra�_tipi(String ara�_tipi) {
		this.ara�_tipi = ara�_tipi;
	}

	public String getDurum() {
		return durum;
	}

	public void setDurum(String durum) {
		this.durum = durum;
	}

	public String getKm() {
		return km;
	}

	public void setKm(String km) {
		this.km = km;
	}

	public String getBak�m�() {
		return bak�m�;
	}

	public void setBak�m�(String bak�m�) {
		this.bak�m� = bak�m�;
	}

	public String getYak�t_t�r�() {
		return yak�t_t�r�;
	}

	public void setYak�t_t�r�(String yak�t_t�r�) {
		this.yak�t_t�r� = yak�t_t�r�;
	}

	public Soforler get�of�rID() {
		return �of�rID;
	}

	public void set�of�rID(Soforler �of�rID) {
		this.�of�rID = �of�rID;
	}
}
