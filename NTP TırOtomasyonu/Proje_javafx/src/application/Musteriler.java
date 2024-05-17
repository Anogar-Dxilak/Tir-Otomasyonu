package application;
import java.sql.Timestamp;

public class Musteriler {
		private int müþteriID;
		private String ad;
		private String soyad;
		private String tel_no;
		private String email;
		private Timestamp kayýt_tarihi;
		
		Musteriler(int id, String ad, String soyad, String telno, String email, Timestamp kayýttarihi ){
			this.müþteriID=id;
			this.ad=ad;
			this.soyad=soyad;
			this.tel_no=telno;
			this.email=email;
			this.kayýt_tarihi=kayýttarihi;
		}

		public int getMüþteriID() {
			return müþteriID;
		}

		public void setMüþteriID(int müþteriID) {
			this.müþteriID = müþteriID;
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

		public Timestamp getKayýt_tarihi() {
			return kayýt_tarihi;
		}

		public void setKayýt_tarihi(Timestamp kayýt_tarihi) {
			this.kayýt_tarihi = kayýt_tarihi;
		}	
}
