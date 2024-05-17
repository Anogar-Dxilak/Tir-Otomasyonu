package application;
import java.sql.Timestamp;

public class Musteriler {
		private int m��teriID;
		private String ad;
		private String soyad;
		private String tel_no;
		private String email;
		private Timestamp kay�t_tarihi;
		
		Musteriler(int id, String ad, String soyad, String telno, String email, Timestamp kay�ttarihi ){
			this.m��teriID=id;
			this.ad=ad;
			this.soyad=soyad;
			this.tel_no=telno;
			this.email=email;
			this.kay�t_tarihi=kay�ttarihi;
		}

		public int getM��teriID() {
			return m��teriID;
		}

		public void setM��teriID(int m��teriID) {
			this.m��teriID = m��teriID;
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

		public String getTel_no() {
			return tel_no;
		}

		public void setTel_no(String tel_no) {
			this.tel_no = tel_no;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Timestamp getKay�t_tarihi() {
			return kay�t_tarihi;
		}

		public void setKay�t_tarihi(Timestamp kay�t_tarihi) {
			this.kay�t_tarihi = kay�t_tarihi;
		}	
}
