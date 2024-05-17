package application;

public class Araçlar {
	private int araçID;
	private String plaka;
	private String marka;
	private String yýl;
	private String araç_tipi;
	private String durum;
	private String km;
	private String bakýmý;
	private String yakýt_türü;
	private Soforler þoförID;
	
	Araçlar(int id, String plaka, String marka, String yýl, String araçtipi, String durumu, String km, String bakýmý, String yakýtý, Soforler þoförID){
		this.araçID=id;
		this.plaka=plaka;
		this.marka=marka;
		this.yýl=yýl;
		this.araç_tipi=araçtipi;
		this.durum=durumu;
		this.km=km;
		this.bakýmý=bakýmý;
		this.yakýt_türü=yakýtý;
		this.þoförID=þoförID;
	}

	public int getAraçID() {
		return araçID;
	}

	public void setAraçID(int araçID) {
		this.araçID = araçID;
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

	public String getYýl() {
		return yýl;
	}

	public void setYýl(String yýl) {
		this.yýl = yýl;
	}

	public String getAraç_tipi() {
		return araç_tipi;
	}

	public void setAraç_tipi(String araç_tipi) {
		this.araç_tipi = araç_tipi;
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

	public String getBakýmý() {
		return bakýmý;
	}

	public void setBakýmý(String bakýmý) {
		this.bakýmý = bakýmý;
	}

	public String getYakýt_türü() {
		return yakýt_türü;
	}

	public void setYakýt_türü(String yakýt_türü) {
		this.yakýt_türü = yakýt_türü;
	}

	public Soforler getÞoförID() {
		return þoförID;
	}

	public void setÞoförID(Soforler þoförID) {
		this.þoförID = þoförID;
	}
}
