package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.math.BigDecimal;
import com.MySQL.util.VeritabanýUtil;
import java.sql.Timestamp;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.*;

public class Form3Controller {
	
	public Form3Controller() {
		baglanti=VeritabanýUtil.Baglan();
	}
	
    Connection baglanti=null;
    PreparedStatement sorguifadesi=null;
    ResultSet getirilen=null;
    String sql;
    
    //Baðlantýyý Kontrol et eðer Baðlý Deðilse Tekrar Baðlan
    private void checkAndReconnect() {
        try {
            if (baglanti == null || baglanti.isClosed()) {
                baglanti = VeritabanýUtil.Baglan();
                System.out.println("Veritabanýna baðlandý.");
            }
        } catch (SQLException e) {
            showAlert("Veritabaný Baðlantý Hatasý", "Veritabanýna yeniden baðlanýlamadý: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Araçlar> tümaraçlar_view;
    
    @FXML
    private TableColumn<Araçlar, Integer> Col_arçAraçTipi;

    @FXML
    private TableColumn<Araçlar, String> Col_arçBakým;

    @FXML
    private TableColumn<Araçlar, String> Col_arçDurum;

    @FXML
    private TableColumn<Araçlar, String> Col_arçId;

    @FXML
    private TableColumn<Araçlar, String> Col_arçKm;

    @FXML
    private TableColumn<Araçlar, String> Col_arçMarka;

    @FXML
    private TableColumn<Araçlar, String> Col_arçPlaka;

    @FXML
    private TableColumn<Araçlar, String> Col_arçYakýtTürü;

    @FXML
    private TableColumn<Araçlar, String> Col_arçYýl;
    
    @FXML
    private TableColumn<Araçlar, String> Col_arçþfrAdý;

    @FXML
    private TableView<Soforler> kçk_þfr_view;
    
    @FXML
    private TableColumn<Soforler, String> Col_kçkþfr_Adý;

    @FXML
    private TableColumn<Soforler, String> Col_kçkþfr_Durum;

    @FXML
    private TableColumn<Soforler, Integer> Col_kçkþfr_ID;

    @FXML
    private TableColumn<Soforler, String> Col_kçkþfr_Soyadý;

    @FXML
    private TableColumn<Soforler, Timestamp> Col_kçkþfr_Tarih;
    
    @FXML
    private TableView<Satislar> ödnmemiþ_stþ_view;

    @FXML
    private TableColumn<Satislar, Integer> Col_ödnmyn_ID;

    @FXML
    private TableColumn<Satislar, String> Col_ödnmyn_durum;

    @FXML
    private TableColumn<Satislar, String> Col_ödnmyn_mþtrad;

    @FXML
    private TableColumn<Satislar, String> Col_ödnmyn_mþtrsoyad;

    @FXML
    private TableColumn<Satislar, String> Col_ödnmyn_ürünad;

    @FXML
    private TableColumn<Satislar, BigDecimal> Col_ödnmyn_ürünfyt;

    @FXML
    private TableColumn<Satislar, BigDecimal> Col_ödnmyn_ürünmik;
    
    @FXML
    private TableView<Urunler> ürünler_view;

    @FXML
    private TableColumn<Urunler, String> Col_ürünAd;

    @FXML
    private TableColumn<Urunler, String> Col_ürünDurum;

    @FXML
    private TableColumn<Urunler, Integer> Col_ürünID;
    
    @FXML
    private TableColumn<Urunler, BigDecimal> Col_kgfiyat;
    
    @FXML
    private TableColumn<Urunler, BigDecimal> Col_tplmkg;
    
    @FXML
    private TableColumn<Urunler, Timestamp> Col_ürüntarih;
    
    @FXML
    private TableView<Soforler> þfr_view;

    @FXML
    private TableColumn<Soforler, Integer> Col_þfr_ID;

    @FXML
    private TableColumn<Soforler, String> Col_þfr_ad;

    @FXML
    private TableColumn<Soforler, String> Col_þfr_durumu;

    @FXML
    private TableColumn<Soforler, Timestamp> Col_þfr_kyttarih;

    @FXML
    private TableColumn<Soforler, String> Col_þfr_soyad;

    @FXML
    private TableColumn<Soforler, String> Col_þfr_telno;
    
    @FXML
    private TableView<Araçlar> þfr_arç_view;

    @FXML
    private TableColumn<Araçlar, Integer> Col_þfrarç_ID;

    @FXML
    private TableColumn<Araçlar, String> Col_þfrarç_bkm;

    @FXML
    private TableColumn<Araçlar, String> Col_þfrarç_durum;

    @FXML
    private TableColumn<Araçlar, String> Col_þfrarçAdý;

    @FXML
    private TableColumn<Araçlar, String> Col_þfrarç_km;

    @FXML
    private TableColumn<Araçlar, String> Col_þfrarç_marka;

    @FXML
    private TableColumn<Araçlar, String> Col_þfrarç_plaka;

    @FXML
    private TableColumn<Araçlar, String> Col_þfrarç_tipi;

    @FXML
    private TableColumn<Araçlar, String> Col_þfrarç_ykttür;

    @FXML
    private TableColumn<Araçlar, String> Col_þfrarç_yýl;
    
    @FXML
    private TableView<Satislar> stþ_Satýþlar_view;
    
    @FXML
    private TableColumn<Satislar, Integer> Col_stþ_ID;

    @FXML
    private TableColumn<Satislar, String> Col_stþ_ad;

    @FXML
    private TableColumn<Satislar, BigDecimal> Col_stþ_miktar;

    @FXML
    private TableColumn<Satislar, String> Col_stþ_mþtID;

    @FXML
    private TableColumn<Satislar, Timestamp> Col_stþ_tarih;

    @FXML
    private TableColumn<Satislar, BigDecimal> Col_stþ_topkazanç;

    @FXML
    private TableColumn<Satislar, String> Col_stþ_ödnmdurum;

    @FXML
    private TableView<Musteriler> stþ_müþteriler_view;
    
    @FXML
    private TableColumn<Musteriler, Integer> Col_stþmþtr_ID;

    @FXML
    private TableColumn<Musteriler, String> Col_stþmþtr_ad;

    @FXML
    private TableColumn<Musteriler, String> Col_stþmþtr_email;

    @FXML
    private TableColumn<Musteriler, String> Col_stþmþtr_soyad;

    @FXML
    private TableColumn<Musteriler, Timestamp> Col_stþmþtr_tarih;

    @FXML
    private TableColumn<Musteriler, String> Col_stþmþtr_tel;
    
    @FXML
    private TableView<Urunler> stþ_ürünler_view;

    @FXML
    private TableColumn<Urunler, Integer> Col_stþürn_ID;

    @FXML
    private TableColumn<Urunler, String> Col_stþürn_ad;

    @FXML
    private TableColumn<Urunler, String> Col_stþürn_durum;

    @FXML
    private TableColumn<Urunler, BigDecimal> Col_stþürn_kgfiyat;

    @FXML
    private TableColumn<Urunler, BigDecimal> Col_stþürn_mevcut;

    @FXML
    private TableColumn<Urunler, Timestamp> Col_stþürn_tarih;
    
    @FXML
    private TableView<Musteriler> müþteriler_view;
    
    @FXML
    private TableColumn<Musteriler, String> Col_mþtrAd;

    @FXML
    private TableColumn<Musteriler, String> Col_mþtrEmail;

    @FXML
    private TableColumn<Musteriler, Integer> Col_mþtrId;

    @FXML
    private TableColumn<Musteriler, String> Col_mþtrSoyad;

    @FXML
    private TableColumn<Musteriler, Timestamp> Col_mþtrTarih;

    @FXML
    private TableColumn<Musteriler, String> Col_mþtrTel;
    
    @FXML
    private TableView<Araçlar> stþ_arç_view;
    
    @FXML
    private TableColumn<Araçlar, Integer> Col_stþ_arçID;
    
    @FXML
    private TableColumn<Araçlar, String> Col_stþ_arçMarka;
    
    @FXML
    private TableColumn<Araçlar, Integer> Col_stþ_arçKm;
    
    @FXML
    private TableColumn<Araçlar, String> Col_stþ_arçBakým;
    
    @FXML
    private TableColumn<Araçlar, String> Col_stþ_arçYakýt;
    
    @FXML
    private TableColumn<Araçlar, String> Col_stþ_arçÞoförad;
    
    @FXML
    private TableView<Soforler> stþ_þfr_view;
    
    @FXML
    private TableColumn<Soforler, Integer> Col_stþ_þfrID;
    
    @FXML
    private TableColumn<Soforler, String> Col_stþ_þfradý;
    
    @FXML
    private TableColumn<Soforler, String> Col_stþ_þfrsoyad;
    
    @FXML
    private TableColumn<Soforler, String> Col_stþ_þfrtel;
    
    @FXML
    private TableColumn<Soforler, Timestamp> Col_stþ_þfrtarih;
    
    @FXML
    private TableView<Satislar> Son10Satýþ_tblview;
    
    @FXML
    private TableColumn<Satislar, Integer> Col_son10satýþ_ID;
    
    @FXML
    private TableColumn<Satislar, Timestamp> Col_son10satýþ_tarih;
    
    @FXML
    private TableColumn<Satislar, String> Col_son10satýþ_müþteri;
    
    @FXML
    private TableColumn<Satislar, String> Col_son10satýþ_ürün;
    
    @FXML
    private TableColumn<Satislar, BigDecimal> Col_son10satýþ_miktar;
    
    @FXML
    private TableColumn<Satislar, BigDecimal> Col_son10satýþ_tutar;
    
    @FXML
    private TableView<Odeme> Son10Ödeme_tblview;
    
    @FXML 
    private TableColumn<Odeme, Timestamp> Col_son10ödeme_tarih;
    
    @FXML 
    private TableColumn<Odeme, String> Col_son10ödeme_müþteriad;
    
    @FXML 
    private TableColumn<Odeme, String> Col_son10ödeme_müþterisoyad;
    
    @FXML 
    private TableColumn<Odeme, String> Col_son10ödeme_ürünad;
    
    @FXML 
    private TableColumn<Odeme, String> Col_son10ödeme_tutar;
    
    @FXML
    private TextField arçekle_marka_txt;

    @FXML
    private TextField arçekle_araçtipi_txt;

    @FXML
    private TextField arçekle_plaka_txt;

    @FXML
    private TextField arçekle_yakýttürü_txt;

    @FXML
    private TextField arçekle_yýl_txt;
    
    @FXML
    private TextField arçekle_km_txt;
    
    @FXML
    private TextField arçekle_durum_txt;
    
    @FXML
    private TextField arçekle_bakým_txt;
    
    @FXML
    private Button arçekle_btn;
    
    @FXML
    private Button arçekle_iptl_btn;

    @FXML
    private Button arçþfr_dðtr_btn;
    
    @FXML
    private Button arçþfr_dðtriptl_btn;
    
    @FXML
    private Button Id_iptl_btn;

    @FXML
    private ComboBox<String> araç_bakým_cmbx;

    @FXML
    private ComboBox<String> araç_durum_cmbx;

    @FXML
    private Button arç_tnmla_btn;

    @FXML
    private Button arç_tnmlaiptl_btn;

    @FXML
    private LineChart<String, Number> arçkul_grafik;

    @FXML
    private Button arçsil_btn;

    @FXML
    private Label bgn_stþ_lbl;

    @FXML
    private Button bkm_ony_btn;

    @FXML
    private Label buay_stþ_lbl;

    @FXML
    private Button drm_ony_btn;

    @FXML
    private Label dün_stþ_lbl;

    @FXML
    private Button lst_update_btn;
    
    @FXML
    private Button arç_dznl_btn;
    
    @FXML
    private Label stþ_arçID_lbl;
    
    @FXML
    private Label stþ_þfrID_lbl;

    @FXML
    private TextField mþtr_adara_txt;

    @FXML
    private Button mþtr_bul_btn;

    @FXML
    private Button mþtr_buliptl_btn;

    @FXML
    private Button mþtr_dznl_btn;

    @FXML
    private Button mþtr_ekle_btn;

    @FXML
    private Button mþtr_iptl_btn;
    
    @FXML
    private Button þfr_aktfdðþ_btn;
    
    @FXML
    private Button þfr_aktfdðþ_btn2;

    @FXML
    private Button mþtr_list_updt_btn;

    @FXML
    private Button mþtr_sil_btn;

    @FXML
    private TextField mþtr_soyadara_txt;

    @FXML
    private TextField mþtrekle_ad_txt;

    @FXML
    private TextField mþtrekle_email_txt;

    @FXML
    private TextField mþtrekle_soyad_txt;

    @FXML
    private TextField mþtrekle_tel_txt;

    @FXML
    private LineChart<?, ?> satýþlar_grafik;

    @FXML
    private Label sn7_stþ_lbl;
    
    @FXML
    private Label stþ_þfr_lbl;
    
    @FXML
    private Label stþ_arç_lbl;

    @FXML
    private Label sçl_þfr_lbl;
    
    @FXML
    private Label sçln_þfrarçID_lbl;

    @FXML
    private Label sçln_þfrID_lbl;
    
    @FXML
    private Label stþ_ürnID_lbl;
    
    @FXML
    private Label stþ_mþtrID_lbl;
    
    @FXML
    private Label sçln_arçID_lbl;

    @FXML
    private Label sçln_þfr_fakelbl;
    
    @FXML
    private Label sçln_þfr_lbl;

    @FXML
    private Label sçlnmþtr_lbl;

    @FXML
    private Label tplm_araç_lbl;

    @FXML
    private Label tplm_mþtr_lbl;

    @FXML
    private Label tplm_stþ_lbl;

    @FXML
    private Label tplm_þoför_lbl;

    @FXML
    private TextField updt_kgfiyat_txt;

    @FXML
    private TextField updt_tplmkg_txt;

    @FXML
    private TextField updt_ürnad_txt;

    @FXML
    private TextField updt_ürndrm_txt;

    @FXML
    private Button ödeme_btn;
    
    @FXML
    private Button tbllr_gncll_btn;

    @FXML
    private Button ödeme_iptl_btn;

    @FXML
    private Label ödmedrmu_lbl;

    @FXML
    private Button ürn_kaldýr_btn;

    @FXML
    private Button ürnblgi_updt_btn;

    @FXML
    private Button ürnekle_btn;

    @FXML
    private TextField ürnekle_kgbaþý_txt;

    @FXML
    private Button ürnekle_tmzl_btn;

    @FXML
    private TextField ürnekle_tplmkg_txt;

    @FXML
    private TextField ürnekle_ürndrm_txt;

    @FXML
    private TextField ürnekle_ürünad_txt;
    
    @FXML
    private TextField stþ_ürnstþ_txt;
    
    @FXML
    private Button stþ_stþyap_btn;

    @FXML
    private Label ürnsec_lbl;

    @FXML
    private Button ürnsec_tmzl_btn;

    @FXML
    private Button ürün_list_upt_btn;

    @FXML
    private RadioButton þfr_drm_radio1;

    @FXML
    private RadioButton þfr_drm_radio2;

    @FXML
    private ToggleGroup þfr_durum_radio;

    @FXML
    private Button þfr_ekle_btn;

    @FXML
    private TextField þfr_eklead_txt;

    @FXML
    private Button þfr_ekleiptl_btn;

    @FXML
    private TextField þfr_eklesoyad_txt;

    @FXML
    private TextField þfr_ekletelno_txt;

    @FXML
    private Button þfr_lstupt_btn;

    @FXML
    private Button þfr_sil_btn;

    @FXML
    private Button þfr_siltmzl_btn;
    
    @FXML
    void arç_dznl_Click(ActionEvent event) {
    	checkAndReconnect();
    	 try {
    	        int selectedAraçID = Integer.parseInt(sçln_arçID_lbl.getText());
    	        String plaka = arçekle_plaka_txt.getText();
    	        String marka = arçekle_marka_txt.getText();
    	        String yýl = arçekle_yýl_txt.getText();
    	        String araçTipi = arçekle_araçtipi_txt.getText();
    	        String durum = arçekle_durum_txt.getText();
    	        String km = arçekle_km_txt.getText();
    	        String bakýmý = arçekle_bakým_txt.getText();
    	        String yakýtTürü = arçekle_yakýttürü_txt.getText();

    	        // Boþ alan kontrolü
    	        if (plaka.isEmpty() || marka.isEmpty() || yýl.isEmpty() || araçTipi.isEmpty() || durum.isEmpty() || km.isEmpty() || bakýmý.isEmpty() || yakýtTürü.isEmpty()) {
    	            showAlert("Boþ Alan Hatasý", "Lütfen tüm alanlarý doldurun.", Alert.AlertType.INFORMATION);
    	            return;
    	        }

    	        // Sayýsal giriþ kontrolü (yýl ve km)
    	        if (!yýl.matches("\\d+") || !km.matches("\\d+")) {
    	            showAlert("Geçersiz Giriþ", "Yýl ve Km alanlarýna sadece sayý girmelisiniz.", Alert.AlertType.INFORMATION);
    	            return;
    	        }

    	        // Bakým alaný kontrolü (var/yok)
    	        if (!bakýmý.equals("var") && !bakýmý.equals("yok")) {
    	            showAlert("Geçersiz Giriþ", "Bakým alanýna sadece 'var' veya 'yok' girmelisiniz.", Alert.AlertType.INFORMATION);
    	            return;
    	        }

    	        // Durum alaný kontrolü (aktif/inaktif)
    	        if (!durum.equals("aktif") && !durum.equals("inaktif")) {
    	            showAlert("Geçersiz Giriþ", "Durum alanýna sadece 'aktif' veya 'inaktif' girmelisiniz.", Alert.AlertType.INFORMATION);
    	            return;
    	        }

    	        String sql = "UPDATE araçlar SET plaka = ?, marka = ?, yýl = ?, araç_tipi = ?, durum = ?, km = ?, bakýmý = ?, yakýt_türü = ? WHERE araçID = ?";

    	        PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
    	        sorguifadesi.setString(1, plaka);
    	        sorguifadesi.setString(2, marka);
    	        sorguifadesi.setString(3, yýl);
    	        sorguifadesi.setString(4, araçTipi);
    	        sorguifadesi.setString(5, durum);
    	        sorguifadesi.setString(6, km);
    	        sorguifadesi.setString(7, bakýmý);
    	        sorguifadesi.setString(8, yakýtTürü);
    	        sorguifadesi.setInt(9, selectedAraçID);

    	        int result = sorguifadesi.executeUpdate();
    	        if (result > 0) {
    	            showAlert("Baþarýlý", "Araç baþarýyla güncellendi!", Alert.AlertType.CONFIRMATION);
    	            arç_temizle();
    	            AraçlarýGetir(tümaraçlar_view);
    	        } else {
    	            showAlert("Baþarýsýz", "Araç güncellenemedi!", Alert.AlertType.ERROR);
    	        }
    	    } catch (SQLException e) {
    	        showAlert("Veritabaný Hatasý", "Araç güncellenirken bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
    	    }
    }
    
    @FXML
    void tbllr_gncll_Click(ActionEvent event) {
    	AraçlarýGetir(tümaraçlar_view);
    	AraçlarýListele();
    	MüþterileriGetir(müþteriler_view);
    	musteriListele();
    	ÜrünleriGetir(ürünler_view);
    	ÜrünleriListele();
    	ÞoförleriGetir(þfr_view);
    	ÞoförleriListele();
    	satislariGetir(stþ_Satýþlar_view); 
    	SatýslarArçListele();
    	SatýslarÞfrlrListele();
    	odemeDurumuListesi();
    }
    
    @FXML
    void arçekle_Click(ActionEvent event) {
        checkAndReconnect();
        String plaka = arçekle_plaka_txt.getText();
        String marka = arçekle_marka_txt.getText();
        String yýl = arçekle_yýl_txt.getText();
        String araçTipi = arçekle_araçtipi_txt.getText();
        String durum = arçekle_durum_txt.getText();
        String km = arçekle_km_txt.getText();
        String bakýmý = arçekle_bakým_txt.getText();
        String yakýtTürü = arçekle_yakýttürü_txt.getText();
        int þoförID = 1;

        // Boþ alan kontrolü
        if (plaka.isEmpty() || marka.isEmpty() || yýl.isEmpty() || araçTipi.isEmpty() || durum.isEmpty() || km.isEmpty() || bakýmý.isEmpty() || yakýtTürü.isEmpty()) {
            showAlert("Boþ Alan Hatasý", "Lütfen tüm alanlarý doldurun.", Alert.AlertType.INFORMATION);
            return;
        }

        // Sayýsal giriþ kontrolü (yýl ve km)
        if (!yýl.matches("\\d+") || !km.matches("\\d+")) {
            showAlert("Geçersiz Giriþ", "Yýl ve Km alanlarýna sadece sayý girmelisiniz.", Alert.AlertType.INFORMATION);
            return;
        }

        // Bakým alaný kontrolü (var/yok)
        if (!bakýmý.equals("var") && !bakýmý.equals("yok")) {
            showAlert("Geçersiz Giriþ", "Bakým alanýna sadece 'var' veya 'yok' girmelisiniz.", Alert.AlertType.INFORMATION);
            return;
        }

        // Durum alaný kontrolü (aktif/inaktif)
        if (!durum.equals("aktif") && !durum.equals("inaktif")) {
            showAlert("Geçersiz Giriþ", "Durum alanýna sadece 'aktif' veya 'inaktif' girmelisiniz.", Alert.AlertType.INFORMATION);
            return;
        }

        String sql = "INSERT INTO araçlar (plaka, marka, yýl, araç_tipi, durum, km, bakýmý, yakýt_türü, þoförID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
            sorguifadesi.setString(1, plaka);
            sorguifadesi.setString(2, marka);
            sorguifadesi.setString(3, yýl);
            sorguifadesi.setString(4, araçTipi);
            sorguifadesi.setString(5, durum);
            sorguifadesi.setString(6, km);
            sorguifadesi.setString(7, bakýmý);
            sorguifadesi.setString(8, yakýtTürü);
            sorguifadesi.setInt(9, þoförID);

            int result = sorguifadesi.executeUpdate();
            if (result > 0) {
                showAlert("Baþarýlý", "Araç baþarýyla eklendi!", Alert.AlertType.CONFIRMATION);
                AraçlarýGetir(tümaraçlar_view);
                arç_temizle();
            } else {
                showAlert("Baþarýsýz", "Araç eklenemedi!", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            showAlert("Veritabaný Hatasý", "Araç eklenirken bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }


    	private void arç_temizle() {
    	    arçekle_plaka_txt.clear();
    	    arçekle_marka_txt.clear();
    	    arçekle_yýl_txt.clear();
    	    arçekle_araçtipi_txt.clear();
    	    arçekle_durum_txt.clear();
    	    arçekle_km_txt.clear();
    	    arçekle_bakým_txt.clear();
    	    arçekle_yakýttürü_txt.clear();
    	}
    	
    @FXML
    void arçekle_iptl_Click(ActionEvent event) {
    	arç_temizle();
    }
    
    @FXML
    void arçþfr_dðtr_Click(ActionEvent event) {
    	 String aracIDText = sçln_arçID_lbl.getText();
         String soforIDText = sçln_þfrID_lbl.getText();

         if (aracIDText.isEmpty() || soforIDText.isEmpty()) {
             showAlert("Geçersiz Giriþ", "Lütfen hem araç hem de þoför ID'lerini seçin.", Alert.AlertType.INFORMATION);
             return;
         }

         int aracID = Integer.parseInt(aracIDText);
         int soforID = Integer.parseInt(soforIDText);

         String sql = "UPDATE araçlar SET þoförID = ? WHERE araçID = ?";

         try {
             baglanti = VeritabanýUtil.Baglan(); 
             PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
             sorguifadesi.setInt(1, soforID);
             sorguifadesi.setInt(2, aracID);
             int rowsUpdated = sorguifadesi.executeUpdate();

             if (rowsUpdated > 0) {
                 showAlert("Baþarýlý", "Araç þoförü baþarýyla güncellendi.", Alert.AlertType.CONFIRMATION);
                 sçln_arçID_lbl.setText("Lütfen ID seçin");
                 sçln_þfrID_lbl.setText("Lütfen ID seçin");
             } else {
                 showAlert("Baþarýsýz", "Güncelleme sýrasýnda bir hata oluþtu.", Alert.AlertType.ERROR);
             }

             sorguifadesi.close();
             baglanti.close();
         } catch (SQLException e) {
             e.printStackTrace();
             showAlert("Veritabaný Hatasý", "Veritabaný iþlemi sýrasýnda bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
         }
    }
    
    @FXML
    void arçþfr_dðtriptl_Click(ActionEvent event) {
    	sçln_arçID_lbl.setText("Lütfen ID seçin");
        sçln_þfrID_lbl.setText("Lütfen ID seçin");
    }

    @FXML
    void arç_tnmla_Click(ActionEvent event) {
    	checkAndReconnect();
    	String araçIDText = sçln_þfrarçID_lbl.getText();
        String þoförIDText = sçln_þfr_lbl.getText();

        if (araçIDText.equals("Seçilen Araç") || þoförIDText.equals("Seçilen Kiþi")) {
            showAlert("Geçersiz Giriþ", "Lütfen hem araç hem de þoför seçin.", Alert.AlertType.INFORMATION);
            return;
        }

        int araçID = Integer.parseInt(araçIDText);
        int þoförID = Integer.parseInt(þoförIDText);

        String sql = "UPDATE araçlar SET þoförID = ? WHERE araçID = ?";
        try {
            PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
            sorguifadesi.setInt(1, þoförID);
            sorguifadesi.setInt(2, araçID);

            int result = sorguifadesi.executeUpdate();
            if (result > 0) {
                showAlert("Baþarýlý", "Araç baþarýyla tanýmlandý!", Alert.AlertType.CONFIRMATION);
                AraçlarýListele();
                sçln_arçID_lbl.setText("Seçilen Araç");
            } else {
                showAlert("Baþarýsýz", "Araç tanýmlanamadý!", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            showAlert("Veritabaný Hatasý", "Araç tanýmlanýrken bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    void arç_tnmlaiptl_Click(ActionEvent event) {
    	sçln_þfrarçID_lbl.setText("Seçilen Araç");
    }

    @FXML
    void mþtr_bul_Click(ActionEvent event) {
    	 String müþteriAd = mþtr_adara_txt.getText();
    	    String müþteriSoyad = mþtr_soyadara_txt.getText();

    	    if (müþteriAd.isEmpty() || müþteriSoyad.isEmpty()) {
    	        showAlert("Eksik Bilgi", "Lütfen müþteri adý ve soyadýný girin.", Alert.AlertType.WARNING);
    	        return;
    	    }

    	    checkAndReconnect();
    	    String sql = "SELECT s.*, u.ürün_adý AS ürün_adý, m.ad AS müþteri_ad, m.soyad AS müþteri_soyad " +
    	                 "FROM satislar s " +
    	                 "JOIN ürünler u ON s.ürünID = u.ürünID " +
    	                 "JOIN müþteriler m ON s.müþteriID = m.müþteriID " +
    	                 "WHERE s.ödeme_durumu = 'Ödenmedi' AND m.ad = ? AND m.soyad = ?";
    	    ObservableList<Satislar> satisList = FXCollections.observableArrayList();
    	    try {
    	        baglanti = VeritabanýUtil.Baglan();
    	        sorguifadesi = baglanti.prepareStatement(sql);
    	        sorguifadesi.setString(1, müþteriAd);
    	        sorguifadesi.setString(2, müþteriSoyad);
    	        getirilen = sorguifadesi.executeQuery();
    	        while (getirilen.next()) {
    	            Urunler urun = new Urunler(getirilen.getInt("ürünID"), getirilen.getString("ürün_adý"), null, null, null, null);
    	            Musteriler musteri = new Musteriler(getirilen.getInt("müþteriID"), getirilen.getString("müþteri_ad"), getirilen.getString("müþteri_soyad"), null, null, null);
    	            Araçlar araç = new Araçlar(getirilen.getInt("araçID"), null, null, null, null, null, null, null, null, null);
    	            Soforler sofor = new Soforler(getirilen.getInt("þoförID"), null, null, null, null, null);

    	            satisList.add(new Satislar(
    	                getirilen.getInt("satýþID"),
    	                urun,
    	                musteri,
    	                araç,
    	                sofor,
    	                getirilen.getBigDecimal("miktar"),
    	                getirilen.getBigDecimal("toplam_fiyat"),
    	                getirilen.getTimestamp("satýþ_tarihi"),
    	                getirilen.getString("ödeme_durumu")
    	            ));
    	        }
    	        Col_ödnmyn_ID.setCellValueFactory(new PropertyValueFactory<>("satýþID"));
    	        Col_ödnmyn_mþtrad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMüþteriID().getAd()));
    	        Col_ödnmyn_mþtrsoyad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMüþteriID().getSoyad()));
    	        Col_ödnmyn_ürünad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getÜrünID().getÜrün_adý()));
    	        Col_ödnmyn_ürünmik.setCellValueFactory(new PropertyValueFactory<>("miktar"));
    	        Col_ödnmyn_ürünfyt.setCellValueFactory(new PropertyValueFactory<>("toplam_fiyat"));
    	        Col_ödnmyn_durum.setCellValueFactory(new PropertyValueFactory<>("ödeme_durumu"));

    	        ödnmemiþ_stþ_view.setItems(satisList);
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	        showAlert("Satýþlarý Getirme Kýsmýnda Veritabaný Hatasý", "Veritabaný iþlemi sýrasýnda bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
    	    } finally {
    	        try {
    	            if (getirilen != null) getirilen.close();
    	            if (sorguifadesi != null) sorguifadesi.close();
    	            if (baglanti != null) baglanti.close();
    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        }
    	    }
    }

    @FXML
    void mþtr_buliptl_Click(ActionEvent event) {
    	 mþtr_adara_txt.clear();
    	 mþtr_soyadara_txt.clear();
    	 odemeDurumuListesi();
    }

    @FXML
    void mþtr_dznl_Click(ActionEvent event) {
    	checkAndReconnect();
    	String selectedMusteriID = sçlnmþtr_lbl.getText();

        if (selectedMusteriID.isEmpty() || selectedMusteriID.equals("Seçilen Müþteri")) {
            showAlert("Geçersiz Giriþ", "Lütfen düzenlemek için bir müþteri seçin.", Alert.AlertType.INFORMATION);
            return;
        }

        int musteriID = Integer.parseInt(selectedMusteriID);
        String ad = mþtrekle_ad_txt.getText();
        String soyad = mþtrekle_soyad_txt.getText();
        String tel = mþtrekle_tel_txt.getText();
        String email = mþtrekle_email_txt.getText();

        if (ad.isEmpty() || soyad.isEmpty() || tel.isEmpty() || email.isEmpty()) {
            showAlert("Boþ Alan Hatasý", "Lütfen tüm alanlarý doldurun.", Alert.AlertType.INFORMATION);
            return;
        }

        String sql = "UPDATE müþteriler SET ad = ?, soyad = ?, tel_no = ?, email = ? WHERE müþteriID = ?";

        try {
            checkAndReconnect();
            PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
            sorguifadesi.setString(1, ad);
            sorguifadesi.setString(2, soyad);
            sorguifadesi.setString(3, tel);
            sorguifadesi.setString(4, email);
            sorguifadesi.setInt(5, musteriID);
            int result = sorguifadesi.executeUpdate();

            if (result > 0) {
                showAlert("Baþarýlý", "Müþteri baþarýyla güncellendi!", Alert.AlertType.CONFIRMATION);
                MüþterileriGetir(müþteriler_view);
            } else {
                showAlert("Baþarýsýz", "Müþteri güncellenemedi!", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            showAlert("Veritabaný Hatasý", "Müþteri güncellenirken bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    void mþtr_ekle_Click(ActionEvent event) {
    	String ad = mþtrekle_ad_txt.getText();
    	String soyad = mþtrekle_soyad_txt.getText();
    	String tel = mþtrekle_tel_txt.getText();
    	String email = mþtrekle_email_txt.getText();
    	    if (ad.isEmpty() || soyad.isEmpty() || tel.isEmpty() || email.isEmpty()) {  	
    	        showAlert("Boþ Alan Hatasý", "Lütfen tüm alanlarý doldurun.", Alert.AlertType.INFORMATION);
    	        return;
    	    }

    	    String sql = "INSERT INTO müþteriler (ad, soyad, tel_no, email) VALUES (?, ?, ?, ?)";

    	    try {
    	        checkAndReconnect();
    	        PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
    	        sorguifadesi.setString(1, ad);
    	        sorguifadesi.setString(2, soyad);
    	        sorguifadesi.setString(3, tel);
    	        sorguifadesi.setString(4, email);
    	        int result = sorguifadesi.executeUpdate();

    	        if (result > 0) {
    	            showAlert("Baþarýlý", "Müþteri baþarýyla eklendi!", Alert.AlertType.CONFIRMATION);
    	            mþtr_temizle();
    	            MüþterileriGetir(müþteriler_view);
    	        } else {
    	            showAlert("Baþarýsýz", "Müþteri eklenemedi!", Alert.AlertType.ERROR);
    	        }
    	    } catch (SQLException e) {
    	        showAlert("Veritabaný Hatasý", "Müþteri eklenirken bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
    	    }
    	}

    @FXML
    void mþtr_iptal_Click(ActionEvent event) {
    	mþtr_temizle();
    }
    
    private void mþtr_temizle() {
        mþtrekle_ad_txt.clear();
        mþtrekle_soyad_txt.clear();
        mþtrekle_tel_txt.clear();
        mþtrekle_email_txt.clear();
        sçlnmþtr_lbl.setText("Seçilen Müþteri");
    }

    @FXML
    void mþtr_list_updt_Click(ActionEvent event) {
    	AraçlarýGetir(tümaraçlar_view);
    	AraçlarýListele();
    	MüþterileriGetir(müþteriler_view);
    	musteriListele();
    	ÜrünleriGetir(ürünler_view);
    	ÜrünleriListele();
    	ÞoförleriGetir(þfr_view);
    	ÞoförleriListele();
    	satislariGetir(stþ_Satýþlar_view); 
    	SatýslarArçListele();
    	SatýslarÞfrlrListele();
    	odemeDurumuListesi();
    }

    @FXML
    void mþtr_sil_Click(ActionEvent event) {
    	checkAndReconnect();
    	String selectedMusteriID = sçlnmþtr_lbl.getText();

    	    if (selectedMusteriID.isEmpty() || selectedMusteriID.equals("Seçilen Müþteri")) {
    	        showAlert("Geçersiz Giriþ", "Lütfen silmek için bir müþteri seçin.", Alert.AlertType.INFORMATION);
    	        return;
    	    }

    	    int musteriID = Integer.parseInt(selectedMusteriID);

    	    String sql = "DELETE FROM müþteriler WHERE müþteriID = ?";

    	    try {
    	        checkAndReconnect();
    	        PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
    	        sorguifadesi.setInt(1, musteriID);
    	        int result = sorguifadesi.executeUpdate();

    	        if (result > 0) {
    	            showAlert("Baþarýlý", "Müþteri baþarýyla silindi!", Alert.AlertType.CONFIRMATION);
    	            sçlnmþtr_lbl.setText("Seçilen Müþteri");
    	            MüþterileriGetir(müþteriler_view);
    	        } else {
    	            showAlert("Baþarýsýz", "Müþteri silinemedi!", Alert.AlertType.ERROR);
    	        }
    	    } catch (SQLException e) {
    	        showAlert("Veritabaný Hatasý", "Müþteri silinirken bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
    	    }
    }

    @FXML
    void ödeme_Click(ActionEvent event) {
    	checkAndReconnect();
        String selectedID = ödmedrmu_lbl.getText();

        if (selectedID.isEmpty() || selectedID.equals("Seçilen ID")) {
            showAlert("Geçersiz Giriþ", "Lütfen bir ID seçin.", Alert.AlertType.INFORMATION);
            return;
        }

        int id = Integer.parseInt(selectedID);

        String updateSql = "UPDATE satislar SET ödeme_durumu = ? WHERE satýþID = ?";
        String selectSql = "SELECT * FROM satislar WHERE satýþID = ?";

        try {
            checkAndReconnect();
            PreparedStatement updateSorgu = baglanti.prepareStatement(updateSql);
            updateSorgu.setString(1, "ödendi");
            updateSorgu.setInt(2, id);
            int result = updateSorgu.executeUpdate();

            if (result > 0) {
                showAlert("Baþarýlý", "Ödeme durumu baþarýyla güncellendi!", Alert.AlertType.CONFIRMATION);
                ödmedrmu_lbl.setText("Seçilen ID");

                // Güncellenen satýþ kaydýný seç
                PreparedStatement selectSorgu = baglanti.prepareStatement(selectSql);
                selectSorgu.setInt(1, id);
                ResultSet rs = selectSorgu.executeQuery();

                if (rs.next()) {
                    int satisID = rs.getInt("satýþID");
                    int urunID = rs.getInt("ürünID");
                    int musteriID = rs.getInt("müþteriID");

                    // Ödeme bilgilerini odemeler tablosuna ekle
                    String insertSql = "INSERT INTO odemeler (satýþ_id, ürün_id, müþteri_id) VALUES (?, ?, ?)";
                    PreparedStatement insertSorgu = baglanti.prepareStatement(insertSql);
                    insertSorgu.setInt(1, satisID);
                    insertSorgu.setInt(2, urunID);
                    insertSorgu.setInt(3, musteriID);

                    int insertResult = insertSorgu.executeUpdate();

                    if (insertResult > 0) {
                        showAlert("Baþarýlý", "Ödeme bilgileri baþarýyla kaydedildi!", Alert.AlertType.CONFIRMATION);
                        son10Odeme();
                    } else {
                        showAlert("Baþarýsýz", "Ödeme bilgileri kaydedilemedi!", Alert.AlertType.ERROR);
                    }
                }
            } else {
                showAlert("Baþarýsýz", "Ödeme durumu güncellenemedi!", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            showAlert("Veritabaný Hatasý", "Ödeme durumu güncellenirken bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
        } finally {
            try {
                if (baglanti != null) baglanti.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void ödeme_iptl_btn(ActionEvent event) {
    	ödmedrmu_lbl.setText("Seçilen ID");
    }

    @FXML
    void ürn_kaldýr_Click(ActionEvent event) {
    	checkAndReconnect();
    	String idText = ürnsec_lbl.getText();

        if (idText.isEmpty() || idText.equals("Seçilen Ürün")) {
            showAlert("Geçersiz Giriþ", "Lütfen bir ürün seçin.", Alert.AlertType.INFORMATION);
            return;
        }

        int id = Integer.parseInt(idText);

        String sql = "DELETE FROM ürünler WHERE ürünID = ?";

        try {
            checkAndReconnect();
            PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
            sorguifadesi.setInt(1, id);

            int result = sorguifadesi.executeUpdate();
            if (result > 0) {
                showAlert("Baþarýlý", "Ürün baþarýyla silindi!", Alert.AlertType.CONFIRMATION);
                temizleGüncelle();
            } else {
                showAlert("Baþarýsýz", "Ürün silinemedi!", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            showAlert("Veritabaný Hatasý", "Ürün silinirken bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    void ürnblgi_updt_Click(ActionEvent event) {
    	checkAndReconnect();
    	String idText = ürnsec_lbl.getText();
        String ad = updt_ürnad_txt.getText();
        String kgfiyat = updt_kgfiyat_txt.getText();
        String tplmkg = updt_tplmkg_txt.getText();
        String durum = updt_ürndrm_txt.getText();

         if (idText.isEmpty() || ad.isEmpty() || kgfiyat.isEmpty() || tplmkg.isEmpty() || durum.isEmpty()) {
             showAlert("Boþ Alan Hatasý", "Lütfen tüm alanlarý doldurun.", Alert.AlertType.INFORMATION);
             return;
         }

         if (!kgfiyat.matches("\\d+(\\.\\d+)?") || !tplmkg.matches("\\d+(\\.\\d+)?")) {
             showAlert("Geçersiz Giriþ", "Kilo Baþý Fiyat ve Toplam Kg alanlarýna sadece sayý girmelisiniz.", Alert.AlertType.INFORMATION);
             return;
         }

         int id = Integer.parseInt(idText);

         String sql = "UPDATE ürünler SET ürün_adý = ?, kilobaþý_fiyat = ?, toplam_kg = ?, ürün_durumu = ? WHERE ürünID = ?";

         try {
             checkAndReconnect();
             PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
             sorguifadesi.setString(1, ad);
             sorguifadesi.setBigDecimal(2, new BigDecimal(kgfiyat));
             sorguifadesi.setBigDecimal(3, new BigDecimal(tplmkg));
             sorguifadesi.setString(4, durum);
             sorguifadesi.setInt(5, id);

             int result = sorguifadesi.executeUpdate();
             if (result > 0) {
                 showAlert("Baþarýlý", "Ürün baþarýyla güncellendi!", Alert.AlertType.CONFIRMATION);
                 temizleGüncelle();
             } else {
                 showAlert("Baþarýsýz", "Ürün güncellenemedi!", Alert.AlertType.ERROR);
             }
         } catch (SQLException e) {
             showAlert("Veritabaný Hatasý", "Ürün güncellenirken bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
         }
    }

    @FXML
    void ürnekle_Click(ActionEvent event) {
    	checkAndReconnect();
    	String ad = ürnekle_ürünad_txt.getText();
        String kgfiyat = ürnekle_kgbaþý_txt.getText();
        String tplmkg = ürnekle_tplmkg_txt.getText();
        String durum = ürnekle_ürndrm_txt.getText();

        // Boþ alan kontrolü
        if (ad.isEmpty() || kgfiyat.isEmpty() || tplmkg.isEmpty() || durum.isEmpty()) {
            showAlert("Boþ Alan Hatasý", "Lütfen tüm alanlarý doldurun.", Alert.AlertType.INFORMATION);
            return;
        }

        // Sayýsal giriþ kontrolü (kgfiyat ve tplmkg)
        if (!kgfiyat.matches("\\d+(\\.\\d+)?") || !tplmkg.matches("\\d+(\\.\\d+)?")) {
            showAlert("Geçersiz Giriþ", "Kilo Baþý Fiyat ve Toplam Kg alanlarýna sadece sayý girmelisiniz.", Alert.AlertType.INFORMATION);
            return;
        }

        String sql = "INSERT INTO ürünler (ürün_adý, kilobaþý_fiyat, toplam_kg, ürün_durumu) VALUES (?, ?, ?, ?)";

        try {
            checkAndReconnect();
            PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
            sorguifadesi.setString(1, ad);
            sorguifadesi.setBigDecimal(2, new BigDecimal(kgfiyat));
            sorguifadesi.setBigDecimal(3, new BigDecimal(tplmkg));
            sorguifadesi.setString(4, durum);

            int result = sorguifadesi.executeUpdate();
            if (result > 0) {
                showAlert("Baþarýlý", "Ürün baþarýyla eklendi!", Alert.AlertType.CONFIRMATION);
                temizleEkle();
            } else {
                showAlert("Baþarýsýz", "Ürün eklenemedi!", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            showAlert("Veritabaný Hatasý", "Ürün eklenirken bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    void ürnekle_tmzl_Click(ActionEvent event) {
    	 temizleEkle();
    }

    @FXML
    void ürnsec_tmzl_Click(ActionEvent event) {
    	temizleGüncelle();
    }

    @FXML
    void ürün_list_upt_Click(ActionEvent event) {
    	ÜrünleriGetir(ürünler_view);
    }
    
    private void temizleEkle() {
        ürnekle_ürünad_txt.clear();
        ürnekle_kgbaþý_txt.clear();
        ürnekle_tplmkg_txt.clear();
        ürnekle_ürndrm_txt.clear();
    }
    
    private void temizleGüncelle() {
        updt_ürnad_txt.clear();
        updt_kgfiyat_txt.clear();
        updt_tplmkg_txt.clear();
        updt_ürndrm_txt.clear();
        ürnsec_lbl.setText("Seçilen Ürün");
    }

    @FXML
    void þfr_ekle_Click(ActionEvent event) {
    	checkAndReconnect();
    	String ad = þfr_eklead_txt.getText();
        String soyad = þfr_eklesoyad_txt.getText();
        String telno = þfr_ekletelno_txt.getText();
        String durum = þfr_drm_radio1.isSelected() ? "Ýnaktif" : "Aktif";

        if (ad.isEmpty() || soyad.isEmpty() || telno.isEmpty()) {
            showAlert("Boþ Alan Hatasý", "Lütfen tüm alanlarý doldurun.", Alert.AlertType.INFORMATION);
            return;
        }

        String sql = "INSERT INTO þoförler (ad, soyad, tel_no, durumu) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
            sorguifadesi.setString(1, ad);
            sorguifadesi.setString(2, soyad);
            sorguifadesi.setString(3, telno);
            sorguifadesi.setString(4, durum);

            int result = sorguifadesi.executeUpdate();
            if (result > 0) {
                showAlert("Baþarýlý", "Þoför baþarýyla eklendi!", Alert.AlertType.CONFIRMATION);
                ÞoförleriGetir(þfr_view);
                þfr_eklead_txt.clear();
                þfr_eklesoyad_txt.clear();
                þfr_ekletelno_txt.clear();
                þfr_drm_radio1.setSelected(true);
            } else {
                showAlert("Baþarýsýz", "Þoför eklenemedi!", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            showAlert("Veritabaný Hatasý", "Þoför eklenirken bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    void þfr_aktfdðþ_Click(ActionEvent event) {
    	checkAndReconnect();
        
        String þoförIDText = sçln_þfr_lbl.getText();
        if (þoförIDText == null || þoförIDText.isEmpty() || þoförIDText.equals("Seçilen Kiþi")) {
            showAlert("Geçersiz Giriþ", "Lütfen bir þoför seçin.", Alert.AlertType.INFORMATION);
            return;
        }

        int þoförID = Integer.parseInt(þoförIDText);

        String sqlSelect = "SELECT durumu FROM þoförler WHERE þoförID = ?";
        String sqlUpdate = "UPDATE þoförler SET durumu = ? WHERE þoförID = ?";

        try {
            PreparedStatement sorguifadesi = baglanti.prepareStatement(sqlSelect);
            sorguifadesi.setInt(1, þoförID);
            ResultSet getirilen = sorguifadesi.executeQuery();

            if (getirilen.next()) {
                String currentStatus = getirilen.getString("durumu");
                String newStatus = currentStatus.equals("Aktif") ? "Ýnaktif" : "Aktif";

                PreparedStatement updateStatement = baglanti.prepareStatement(sqlUpdate);
                updateStatement.setString(1, newStatus);
                updateStatement.setInt(2, þoförID);
                int result = updateStatement.executeUpdate();

                if (result > 0) {
                    showAlert("Baþarýlý", "Þoför durumu baþarýyla deðiþtirildi!", Alert.AlertType.CONFIRMATION);
                    ÞoförleriGetir(þfr_view);
                    sçln_þfr_lbl.setText("Seçilen Kiþi");
                } else {
                    showAlert("Baþarýsýz", "Þoför durumu deðiþtirilemedi!", Alert.AlertType.ERROR);
                }
            } else {
                showAlert("Þoför Bulunamadý", "Belirtilen ID'ye sahip bir þoför bulunamadý.", Alert.AlertType.ERROR);
            }

        } catch (SQLException e) {
            showAlert("Veritabaný Hatasý", "Veritabaný iþlemi sýrasýnda bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }
    
    @FXML
    void þfr_aktfdðþ_Click2(ActionEvent event) {
    	checkAndReconnect();
        String þoförIDText = sçln_þfr_lbl.getText();
        if (þoförIDText == null || þoförIDText.isEmpty() || þoförIDText.equals("Seçilen Kiþi")) {
            showAlert("Geçersiz Giriþ", "Lütfen bir þoför seçin.", Alert.AlertType.INFORMATION);
            return;
        }
        int þoförID = Integer.parseInt(þoförIDText);
        String currentStatus = null;
        String sqlSelect = "SELECT durumu FROM þoförler WHERE þoförID = ?";
        try (PreparedStatement sorguifadesi = baglanti.prepareStatement(sqlSelect)) {
            sorguifadesi.setInt(1, þoförID);
            ResultSet getirilen = sorguifadesi.executeQuery();
            if (getirilen.next()) {
                currentStatus = getirilen.getString("durumu");
            }
        } catch (SQLException e) {
            showAlert("Veritabaný Hatasý", "Veritabaný iþlemi sýrasýnda bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
            return;
        }
        if (currentStatus == null) {
            showAlert("Þoför Bulunamadý", "Belirtilen ID'ye sahip bir þoför bulunamadý.", Alert.AlertType.ERROR);
            return;
        }
        String newStatus = "Ýnaktif";
        if (currentStatus.equals("Ýnaktif")) {
            newStatus = "Aktif";
        }
        String sqlUpdate = "UPDATE þoförler SET durumu = ? WHERE þoförID = ?";
        try (PreparedStatement sorguifadesi = baglanti.prepareStatement(sqlUpdate)) {
            sorguifadesi.setString(1, newStatus);
            sorguifadesi.setInt(2, þoförID);
            int result = sorguifadesi.executeUpdate();
            if (result > 0) {
                showAlert("Baþarýlý", "Þoför durumu baþarýyla güncellendi!", Alert.AlertType.CONFIRMATION);
                ÞoförleriGetir(þfr_view);
                sçln_þfr_lbl.setText("Seçilen Kiþi");
            } else {
                showAlert("Baþarýsýz", "Þoför durumu deðiþtirilemedi!", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            showAlert("Veritabaný Hatasý", "Veritabaný iþlemi sýrasýnda bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    @FXML
    void þfr_ekleiptl_Click(ActionEvent event) {
    	þfr_eklead_txt.clear();
        þfr_eklesoyad_txt.clear();
        þfr_ekletelno_txt.clear();
        þfr_drm_radio1.setSelected(true);
    }

    @FXML
    void þfr_lstupt_Click(ActionEvent event) {
    	ÞoförleriGetir(þfr_view);
    	AraçlarýListele();
    }

    @FXML
    void þfr_sil_Click(ActionEvent event) {
    	checkAndReconnect();
    	String þoförIDText = sçln_þfr_lbl.getText();
        if (þoförIDText.equals("Seçilen Kiþi")) {
            showAlert("Geçersiz Giriþ", "Lütfen bir þoför seçin.", Alert.AlertType.INFORMATION);
            return;
        }

        int þoförID = Integer.parseInt(þoförIDText);

        String sql = "DELETE FROM þoförler WHERE þoförID = ?";
        try {
            PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
            sorguifadesi.setInt(1, þoförID);

            int result = sorguifadesi.executeUpdate();
            if (result > 0) {
                showAlert("Baþarýlý", "Þoför baþarýyla silindi!", Alert.AlertType.CONFIRMATION);
                ÞoförleriGetir(þfr_view);
                sçln_þfr_lbl.setText("Seçilen Kiþi");
            } else {
                showAlert("Baþarýsýz", "Þoför silinemedi!", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            showAlert("Veritabaný Hatasý", "Þoför silinirken bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    void þfr_siltmzl_Click(ActionEvent event) {
    	sçln_þfr_lbl.setText("Seçilen Kiþi");
    }
    
    @FXML
    void bkm_ony_Click(ActionEvent event) {
    	checkAndReconnect();
    	String aracIDText = sçln_arçID_lbl.getText();
        String yeniBakým = araç_bakým_cmbx.getValue();

        if (aracIDText.isEmpty() || yeniBakým == null || aracIDText.equals("Lütfen ID seçin")) {
            showAlert("Geçersiz Giriþ", "Lütfen hem araç ID'sini seçin hem de bakým durumunu belirleyin.", Alert.AlertType.INFORMATION);
            return;
        }

        try {
            int aracID = Integer.parseInt(aracIDText);

            String sql = "UPDATE araçlar SET bakýmý = ? WHERE araçID = ?";

            try {
                checkAndReconnect();
                PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
                sorguifadesi.setString(1, yeniBakým);
                sorguifadesi.setInt(2, aracID);
                int rowsUpdated = sorguifadesi.executeUpdate();

                if (rowsUpdated > 0) {
                    showAlert("Baþarýlý", "Araç bakým durumu baþarýyla güncellendi.", Alert.AlertType.CONFIRMATION);
                    sçln_arçID_lbl.setText("Lütfen ID seçin");
                    araç_bakým_cmbx.getSelectionModel().clearSelection();
                    AraçlarýGetir(tümaraçlar_view);
                } else {
                    showAlert("Baþarýsýz", "Güncelleme sýrasýnda bir hata oluþtu.", Alert.AlertType.ERROR);
                }

                sorguifadesi.close();
            } catch (SQLException e) {
                e.printStackTrace();
                showAlert("Veritabaný Hatasý", "Veritabaný iþlemi sýrasýnda bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        } catch (NumberFormatException e) {
            showAlert("Geçersiz ID", "Lütfen geçerli bir araç ID'si seçin.", Alert.AlertType.INFORMATION);
        	}
    }

    @FXML
    void drm_ony_Click(ActionEvent event) {
    	checkAndReconnect();
    	String aracIDText = sçln_arçID_lbl.getText();
        String yeniDurum = araç_durum_cmbx.getValue();

        if (aracIDText.isEmpty() || yeniDurum == null || aracIDText.equals("Lütfen ID seçin")) {
            showAlert("Geçersiz Giriþ", "Lütfen hem araç ID'sini seçin hem de durumu belirleyin.", Alert.AlertType.INFORMATION);
            return;
        }

        try {
            int aracID = Integer.parseInt(aracIDText);

            String sql = "UPDATE araçlar SET durum = ? WHERE araçID = ?";

            try {
                checkAndReconnect();
                PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
                sorguifadesi.setString(1, yeniDurum);
                sorguifadesi.setInt(2, aracID);
                int rowsUpdated = sorguifadesi.executeUpdate();

                if (rowsUpdated > 0) {
                    showAlert("Baþarýlý", "Araç durumu baþarýyla güncellendi.", Alert.AlertType.CONFIRMATION);
                    sçln_arçID_lbl.setText("Lütfen ID seçin");
                    araç_durum_cmbx.getSelectionModel().clearSelection();
                    AraçlarýGetir(tümaraçlar_view);
                } else {
                    showAlert("Baþarýsýz", "Güncelleme sýrasýnda bir hata oluþtu.", Alert.AlertType.ERROR);
                }

                sorguifadesi.close();
            } catch (SQLException e) {
                e.printStackTrace();
                showAlert("Veritabaný Hatasý", "Veritabaný iþlemi sýrasýnda bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        } catch (NumberFormatException e) {
            showAlert("Geçersiz ID", "Lütfen geçerli bir araç ID'si seçin.", Alert.AlertType.INFORMATION);
        }
    }
    
    @FXML
    void arçsil_Click(ActionEvent event) {
    	checkAndReconnect();
    	String aracIDText = sçln_arçID_lbl.getText();

        if (aracIDText.isEmpty()) {
            showAlert("Geçersiz Giriþ", "Lütfen araç ID'sini seçin.", Alert.AlertType.INFORMATION);
            return;
        }

        int aracID = Integer.parseInt(aracIDText);

        String sql = "DELETE FROM araçlar WHERE araçID = ?";

        try {
            checkAndReconnect();
            PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
            sorguifadesi.setInt(1, aracID);
            int rowsDeleted = sorguifadesi.executeUpdate();

            if (rowsDeleted > 0) {
                showAlert("Baþarýlý", "Araç baþarýyla silindi.", Alert.AlertType.CONFIRMATION);
                sçln_arçID_lbl.setText("Lütfen ID seçin");
                AraçlarýGetir(tümaraçlar_view);
            } else {
                showAlert("Baþarýsýz", "Silme iþlemi sýrasýnda bir hata oluþtu.", Alert.AlertType.ERROR);
            }

            sorguifadesi.close();
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Veritabaný Hatasý", "Veritabaný iþlemi sýrasýnda bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    void Id_iptl_Click(ActionEvent event) {
    	araç_durum_cmbx.getSelectionModel().clearSelection();
        araç_bakým_cmbx.getSelectionModel().clearSelection();
    }
    
    @FXML
    void lst_update_Click(ActionEvent event) {
    	AraçlarýGetir(tümaraçlar_view);
    }
    
    @FXML
    void stþ_stþyap_Click(ActionEvent event) {
    	checkAndReconnect();
        String müþteriID = stþ_mþtrID_lbl.getText();
        String ürünID = stþ_ürnID_lbl.getText();
        String aracID = stþ_arçID_lbl.getText();
        String þoförID = stþ_þfrID_lbl.getText();
        String miktarStr = stþ_ürnstþ_txt.getText();

        if (müþteriID.isEmpty() || ürünID.isEmpty() || aracID.isEmpty() || þoförID.isEmpty() || miktarStr.isEmpty()) {
            showAlert("Eksik Bilgi", "Lütfen tüm bilgileri doldurun.", Alert.AlertType.WARNING);
            return;
        }

        BigDecimal miktar;
        try {
            miktar = new BigDecimal(miktarStr);
        } catch (NumberFormatException e) {
            showAlert("Geçersiz Miktar", "Lütfen geçerli bir miktar girin.", Alert.AlertType.WARNING);
            return;
        }

        try {
            String sql = "SELECT kilobaþý_fiyat, toplam_kg FROM ürünler WHERE ürünID = ?";
            PreparedStatement ps = baglanti.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(ürünID));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                BigDecimal kgFiyat = rs.getBigDecimal("kilobaþý_fiyat");
                BigDecimal toplamKg = rs.getBigDecimal("toplam_kg");

                if (toplamKg.compareTo(miktar) < 0) {
                    showAlert("Yetersiz Stok", "Yeterli miktarda ürün bulunmamaktadýr.", Alert.AlertType.WARNING);
                    return;
                }

                BigDecimal toplamFiyat = kgFiyat.multiply(miktar);
                String insertSql = "INSERT INTO satislar (müþteriID, ürünID, miktar, toplam_fiyat, araçID, þoförID) VALUES (?, ?, ?, ?, ?, ?)";
                ps = baglanti.prepareStatement(insertSql);
                ps.setInt(1, Integer.parseInt(müþteriID));
                ps.setInt(2, Integer.parseInt(ürünID));
                ps.setBigDecimal(3, miktar);
                ps.setBigDecimal(4, toplamFiyat);
                ps.setInt(5, Integer.parseInt(aracID));
                ps.setInt(6, Integer.parseInt(þoförID));
                ps.executeUpdate();

                String updateSql = "UPDATE ürünler SET toplam_kg = toplam_kg - ? WHERE ürünID = ?";
                ps = baglanti.prepareStatement(updateSql);
                ps.setBigDecimal(1, miktar);
                ps.setInt(2, Integer.parseInt(ürünID));
                ps.executeUpdate();

                showAlert("Baþarýlý", "Satýþ iþlemi baþarýyla gerçekleþtirildi.", Alert.AlertType.INFORMATION);
                ÜrünleriListele(); // Ürün listesini güncelle
                satislariGetir(stþ_Satýþlar_view); // Satýþ listesini güncelle
            }
        } catch (SQLException e) {
            showAlert("Veritabaný Hatasý", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    private void showAlert(String title, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void AraçlarýGetir(TableView<Araçlar> tablo) {
        String sql = "SELECT a.araçID, a.plaka, a.marka, a.yýl, a.araç_tipi, a.durum, a.km, a.bakýmý, a.yakýt_türü, s.þoförID, s.ad AS þoför_adý FROM araçlar a JOIN þoförler s ON a.þoförID = s.þoförID";
        ObservableList<Araçlar> araçListesi = FXCollections.observableArrayList();
        try {
            baglanti = VeritabanýUtil.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();
            while (getirilen.next()) {
                Soforler sofor = new Soforler(
                    getirilen.getInt("þoförID"),
                    getirilen.getString("þoför_adý"),
                    null, null, null, null
                );

                araçListesi.add(new Araçlar(
                    getirilen.getInt("araçID"),
                    getirilen.getString("plaka"),
                    getirilen.getString("marka"),
                    getirilen.getString("yýl"),
                    getirilen.getString("araç_tipi"),
                    getirilen.getString("durum"),
                    getirilen.getString("km"),
                    getirilen.getString("bakýmý"),
                    getirilen.getString("yakýt_türü"),
                    sofor
                ));
            }

            Col_arçId.setCellValueFactory(new PropertyValueFactory<>("araçID"));
            Col_arçPlaka.setCellValueFactory(new PropertyValueFactory<>("plaka"));
            Col_arçMarka.setCellValueFactory(new PropertyValueFactory<>("marka"));
            Col_arçYýl.setCellValueFactory(new PropertyValueFactory<>("yýl"));
            Col_arçAraçTipi.setCellValueFactory(new PropertyValueFactory<>("araç_tipi"));
            Col_arçDurum.setCellValueFactory(new PropertyValueFactory<>("durum"));
            Col_arçKm.setCellValueFactory(new PropertyValueFactory<>("km"));
            Col_arçBakým.setCellValueFactory(new PropertyValueFactory<>("bakýmý"));
            Col_arçYakýtTürü.setCellValueFactory(new PropertyValueFactory<>("yakýt_türü"));
            Col_arçþfrAdý.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getÞoförID().getAd()));

            tablo.setItems(araçListesi);
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Araçlarý Getirme Kýsmýnda Veritabaný Hatasý", "Veritabaný iþlemi sýrasýnda bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
        } finally {
            try {
                if (sorguifadesi != null) sorguifadesi.close();
                if (getirilen != null) getirilen.close();
                if (baglanti != null) baglanti.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    
    public void AraçlarýListele() {
        String sql = "SELECT a.araçID, a.plaka, a.marka, a.yýl, a.araç_tipi, a.durum, a.km, a.bakýmý, a.yakýt_türü, s.þoförID, s.ad AS þoför_adý FROM araçlar a JOIN þoförler s ON a.þoförID = s.þoförID";
        ObservableList<Araçlar> araçList = FXCollections.observableArrayList();
        try {
            baglanti = VeritabanýUtil.Baglan(); 
            sorguifadesi = baglanti.prepareStatement(sql);
            ResultSet getirilen = sorguifadesi.executeQuery();
            while (getirilen.next()) {
                Soforler sofor = new Soforler(
                    getirilen.getInt("þoförID"),
                    getirilen.getString("þoför_adý"),
                    null, null, null, null 
                );
                
                araçList.add(new Araçlar(
                    getirilen.getInt("araçID"),
                    getirilen.getString("plaka"),
                    getirilen.getString("marka"),
                    getirilen.getString("yýl"),
                    getirilen.getString("araç_tipi"),
                    getirilen.getString("durum"),
                    getirilen.getString("km"),
                    getirilen.getString("bakýmý"),
                    getirilen.getString("yakýt_türü"),
                    sofor 
                ));
            }
            Col_þfrarç_ID.setCellValueFactory(new PropertyValueFactory<>("araçID"));
            Col_þfrarç_plaka.setCellValueFactory(new PropertyValueFactory<>("plaka"));
            Col_þfrarç_marka.setCellValueFactory(new PropertyValueFactory<>("marka"));
            Col_þfrarç_yýl.setCellValueFactory(new PropertyValueFactory<>("yýl"));
            Col_þfrarç_tipi.setCellValueFactory(new PropertyValueFactory<>("araç_tipi"));
            Col_þfrarç_durum.setCellValueFactory(new PropertyValueFactory<>("durum"));
            Col_þfrarç_km.setCellValueFactory(new PropertyValueFactory<>("km"));
            Col_þfrarç_bkm.setCellValueFactory(new PropertyValueFactory<>("bakýmý"));
            Col_þfrarç_ykttür.setCellValueFactory(new PropertyValueFactory<>("yakýt_türü"));
            Col_þfrarçAdý.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getÞoförID().getAd()));

            þfr_arç_view.setItems(araçList);
        } catch (SQLException e) {
            showAlert("Araçlarý Listeleme Kýsmýnda Veritabaný Hatasý", "Veritabaný iþlemi sýrasýnda bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
        } finally {
            try {
                if (getirilen != null) getirilen.close();
                if (sorguifadesi != null) sorguifadesi.close();
                if (baglanti != null) baglanti.close();
            } catch (SQLException e) {
                showAlert("Kaynaklarý Kapama Hatasý", "Kaynaklarý kapatýrken bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        }
    }


    
    public void MüþterileriGetir(TableView<Musteriler> tablo) {
    	checkAndReconnect();
    	
        sql = "SELECT * FROM müþteriler";
        ObservableList<Musteriler> mþtrList = FXCollections.observableArrayList();
        try {
            sorguifadesi = baglanti.prepareStatement(sql);
            ResultSet getirilen = sorguifadesi.executeQuery();
            while (getirilen.next()) {
                mþtrList.add(new Musteriler(
                    getirilen.getInt("müþteriID"),
                    getirilen.getString("ad"),
                    getirilen.getString("soyad"),
                    getirilen.getString("tel_no"),
                    getirilen.getString("email"),
                    getirilen.getTimestamp("kayýt_tarihi")
                ));
            }
            Col_mþtrId.setCellValueFactory(new PropertyValueFactory<>("müþteriID"));
            Col_mþtrAd.setCellValueFactory(new PropertyValueFactory<>("ad"));
            Col_mþtrSoyad.setCellValueFactory(new PropertyValueFactory<>("soyad"));
            Col_mþtrTel.setCellValueFactory(new PropertyValueFactory<>("tel_no"));
            Col_mþtrEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            Col_mþtrTarih.setCellValueFactory(new PropertyValueFactory<>("kayýt_tarihi"));
            
            tablo.setItems(mþtrList);
        } catch (SQLException e) {
        	e.printStackTrace();
            showAlert("Müþterileri Getirme Kýsmýnda Veritabaný Hatasý", "Veritabaný iþlemi sýrasýnda bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    public void musteriListele() {
        String sql = "SELECT * FROM müþteriler";
        ObservableList<Musteriler> mþtrList = FXCollections.observableArrayList();

        try {
            sorguifadesi = baglanti.prepareStatement(sql);
            ResultSet getirilen = sorguifadesi.executeQuery();

            while (getirilen.next()) {
                mþtrList.add(new Musteriler(
                    getirilen.getInt("müþteriID"),
                    getirilen.getString("ad"),
                    getirilen.getString("soyad"),
                    getirilen.getString("tel_no"),
                    getirilen.getString("email"),
                    getirilen.getTimestamp("kayýt_tarihi")
                ));
            }

            Col_stþmþtr_ID.setCellValueFactory(new PropertyValueFactory<>("müþteriID"));
            Col_stþmþtr_ad.setCellValueFactory(new PropertyValueFactory<>("ad"));
            Col_stþmþtr_soyad.setCellValueFactory(new PropertyValueFactory<>("soyad"));
            Col_stþmþtr_tel.setCellValueFactory(new PropertyValueFactory<>("tel_no"));
            Col_stþmþtr_email.setCellValueFactory(new PropertyValueFactory<>("email"));
            Col_stþmþtr_tarih.setCellValueFactory(new PropertyValueFactory<>("kayýt_tarihi"));

            stþ_müþteriler_view.setItems(mþtrList);
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Listeleme Kýsmýnda Veritabaný Hatasý", "Veritabaný iþlemi sýrasýnda bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    private void SatýslarArçListele() {
        ObservableList<Araçlar> araçList = FXCollections.observableArrayList();
        String sql = "SELECT a.araçID, a.plaka, a.marka, a.yýl, a.araç_tipi, a.durum, a.km, a.bakýmý, a.yakýt_türü, s.ad AS þoför_adý " +
                     "FROM araçlar a " +
                     "LEFT JOIN þoförler s ON a.þoförID = s.þoförID " +
                     "WHERE a.durum = 'aktif'";

        try {
            baglanti = VeritabanýUtil.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();

            while (getirilen.next()) {
                araçList.add(new Araçlar(
                    getirilen.getInt("araçID"),
                    getirilen.getString("plaka"),
                    getirilen.getString("marka"),
                    getirilen.getString("yýl"),
                    getirilen.getString("araç_tipi"),
                    getirilen.getString("durum"),
                    getirilen.getString("km"),
                    getirilen.getString("bakýmý"),
                    getirilen.getString("yakýt_türü"),
                    new Soforler(0, getirilen.getString("þoför_adý"), null, null, null, null)
                ));
            }

            Col_stþ_arçID.setCellValueFactory(new PropertyValueFactory<>("araçID"));
            Col_stþ_arçMarka.setCellValueFactory(new PropertyValueFactory<>("marka"));
            Col_stþ_arçKm.setCellValueFactory(new PropertyValueFactory<>("km"));
            Col_stþ_arçBakým.setCellValueFactory(new PropertyValueFactory<>("bakýmý"));
            Col_stþ_arçYakýt.setCellValueFactory(new PropertyValueFactory<>("yakýt_türü"));
            Col_stþ_arçÞoförad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getÞoförID().getAd()));

            stþ_arç_view.setItems(araçList);
        } catch (SQLException e) {
            showAlert("Veritabaný Hatasý", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    private void SatýslarÞfrlrListele() {
        ObservableList<Soforler> þoförList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM þoförler WHERE durumu = 'aktif'";

        try {
            baglanti = VeritabanýUtil.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();

            while (getirilen.next()) {
                þoförList.add(new Soforler(
                        getirilen.getInt("þoförID"),
                        getirilen.getString("ad"),
                        getirilen.getString("soyad"),
                        getirilen.getString("tel_no"),
                        getirilen.getTimestamp("kayýt_tarihi"),
                        getirilen.getString("durumu")
                ));
            }

            Col_stþ_þfrID.setCellValueFactory(new PropertyValueFactory<>("þoförID"));
            Col_stþ_þfradý.setCellValueFactory(new PropertyValueFactory<>("ad"));
            Col_stþ_þfrsoyad.setCellValueFactory(new PropertyValueFactory<>("soyad"));
            Col_stþ_þfrtel.setCellValueFactory(new PropertyValueFactory<>("tel_no"));
            Col_stþ_þfrtarih.setCellValueFactory(new PropertyValueFactory<>("kayýt_tarihi"));

            stþ_þfr_view.setItems(þoförList);
        } catch (SQLException e) {
            showAlert("Veritabaný Hatasý", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    public void ÜrünleriGetir(TableView<Urunler> tablo) {
        sql = "SELECT * FROM ürünler";
        ObservableList<Urunler> ürünList = FXCollections.observableArrayList();
        try {
            sorguifadesi = baglanti.prepareStatement(sql);
            ResultSet getirilen = sorguifadesi.executeQuery();
            while (getirilen.next()) {
                ürünList.add(new Urunler(
                    getirilen.getInt("ürünID"),
                    getirilen.getString("ürün_adý"),
                    getirilen.getBigDecimal("kilobaþý_fiyat"),
                    getirilen.getBigDecimal("toplam_kg"),
                    getirilen.getString("ürün_durumu"),
                    getirilen.getTimestamp("kayýt_tarihi")
                ));
            }
            Col_ürünID.setCellValueFactory(new PropertyValueFactory<>("ürünID"));
            Col_ürünAd.setCellValueFactory(new PropertyValueFactory<>("ürün_adý"));
            Col_kgfiyat.setCellValueFactory(new PropertyValueFactory<>("kilobaþý_fiyat"));
            Col_tplmkg.setCellValueFactory(new PropertyValueFactory<>("toplam_kg"));
            Col_ürünDurum.setCellValueFactory(new PropertyValueFactory<>("ürün_durumu"));
            Col_ürüntarih.setCellValueFactory(new PropertyValueFactory<>("kayýt_tarihi"));

            tablo.setItems(ürünList);
        } catch (SQLException e) {
            showAlert("Ürünleri Getirme Kýsmýnda Veritabaný Hatasý", "Veritabaný iþlemi sýrasýnda bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    public void ÜrünleriListele() {
        sql = "SELECT * FROM ürünler";
        ObservableList<Urunler> ürünList = FXCollections.observableArrayList();
        try {
            sorguifadesi = baglanti.prepareStatement(sql);
            ResultSet getirilen = sorguifadesi.executeQuery();
            while (getirilen.next()) {
                ürünList.add(new Urunler(
                    getirilen.getInt("ürünID"),
                    getirilen.getString("ürün_adý"),
                    getirilen.getBigDecimal("kilobaþý_fiyat"),
                    getirilen.getBigDecimal("toplam_kg"),
                    getirilen.getString("ürün_durumu"),
                    getirilen.getTimestamp("kayýt_tarihi")
                ));
            }
            Col_stþürn_ID.setCellValueFactory(new PropertyValueFactory<>("ürünID"));
            Col_stþürn_ad.setCellValueFactory(new PropertyValueFactory<>("ürün_adý"));
            Col_stþürn_kgfiyat.setCellValueFactory(new PropertyValueFactory<>("kilobaþý_fiyat"));
            Col_stþürn_mevcut.setCellValueFactory(new PropertyValueFactory<>("toplam_kg"));
            Col_stþürn_durum.setCellValueFactory(new PropertyValueFactory<>("ürün_durumu"));
            Col_stþürn_tarih.setCellValueFactory(new PropertyValueFactory<>("kayýt_tarihi"));
            
            stþ_ürünler_view.setItems(ürünList);
        } catch (SQLException e) {
            showAlert("Ürünleri Listele Kýsmýnda Veritabaný Hatasý", "Veritabaný iþlemi sýrasýnda bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    public void ÞoförleriGetir(TableView<Soforler> tablo) {
        sql = "SELECT * FROM þoförler";
        ObservableList<Soforler> þoförList = FXCollections.observableArrayList();
        try {
            baglanti = VeritabanýUtil.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            ResultSet getirilen = sorguifadesi.executeQuery();
            while (getirilen.next()) {
                þoförList.add(new Soforler(
                    getirilen.getInt("þoförID"),
                    getirilen.getString("ad"),
                    getirilen.getString("soyad"),
                    getirilen.getString("tel_no"),
                    getirilen.getTimestamp("kayýt_tarihi"),
                    getirilen.getString("durumu")
                ));
            }
            Col_þfr_ID.setCellValueFactory(new PropertyValueFactory<>("þoförID"));
            Col_þfr_ad.setCellValueFactory(new PropertyValueFactory<>("ad"));
            Col_þfr_soyad.setCellValueFactory(new PropertyValueFactory<>("soyad"));
            Col_þfr_telno.setCellValueFactory(new PropertyValueFactory<>("tel_no"));
            Col_þfr_kyttarih.setCellValueFactory(new PropertyValueFactory<>("kayýt_tarihi"));
            Col_þfr_durumu.setCellValueFactory(new PropertyValueFactory<>("durumu"));

            tablo.setItems(þoförList);
        } catch (SQLException e) {
            showAlert("Þoförleri Getirme Kýsmýnda Veritabaný Hatasý", "Veritabaný iþlemi sýrasýnda bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
        } finally {
            try {
                if (getirilen != null) getirilen.close();
                if (sorguifadesi != null) sorguifadesi.close();
                if (baglanti != null) baglanti.close();
            } catch (SQLException e) {
                showAlert("Kaynaklarý Kapama Hatasý", "Kaynaklarý kapatýrken bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        }
    }

    public void ÞoförleriListele() {
        String sql = "SELECT * FROM þoförler";
        ObservableList<Soforler> soforList = FXCollections.observableArrayList();
        try {
            baglanti = VeritabanýUtil.Baglan(); 
            sorguifadesi = baglanti.prepareStatement(sql);
            ResultSet getirilen = sorguifadesi.executeQuery();
            while (getirilen.next()) {
                soforList.add(new Soforler(
                    getirilen.getInt("þoförID"),
                    getirilen.getString("ad"),
                    getirilen.getString("soyad"),
                    getirilen.getString("tel_no"),
                    getirilen.getTimestamp("kayýt_tarihi"),
                    getirilen.getString("durumu")
                ));
            }
            Col_kçkþfr_ID.setCellValueFactory(new PropertyValueFactory<>("þoförID"));
            Col_kçkþfr_Adý.setCellValueFactory(new PropertyValueFactory<>("ad"));
            Col_kçkþfr_Soyadý.setCellValueFactory(new PropertyValueFactory<>("soyad"));
            Col_kçkþfr_Tarih.setCellValueFactory(new PropertyValueFactory<>("kayýt_tarihi"));
            Col_kçkþfr_Durum.setCellValueFactory(new PropertyValueFactory<>("durumu"));

            kçk_þfr_view.setItems(soforList);
        } catch (SQLException e) {
            showAlert("Þoförleri Listele Kýsmýnda Veritabaný Hatasý", "Veritabaný iþlemi sýrasýnda bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
        } finally {
            try {
                if (sorguifadesi != null) sorguifadesi.close();
                if (baglanti != null) baglanti.close();
            } catch (SQLException e) {
                showAlert("Kaynaklarý Kapama Hatasý", "Kaynaklarý kapatýrken bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        }
    }
    
    private void satislariGetir(TableView<Satislar> tablo) {
    	 String sql = "SELECT s.*, u.ürün_adý AS ürün_adý FROM satislar s JOIN ürünler u ON s.ürünID = u.ürünID";
    	    ObservableList<Satislar> satisList = FXCollections.observableArrayList();
    	    try {
    	        baglanti = VeritabanýUtil.Baglan();
    	        sorguifadesi = baglanti.prepareStatement(sql);
    	        ResultSet getirilen = sorguifadesi.executeQuery();
    	        while (getirilen.next()) {
    	            Urunler urun = new Urunler(getirilen.getInt("ürünID"), getirilen.getString("ürün_adý"), null, null, null, null);
    	            Musteriler musteri = new Musteriler(getirilen.getInt("müþteriID"), null, null, null, null, null);
    	            Araçlar araç = new Araçlar(getirilen.getInt("araçID"), null, null, null, null, null, null, null, null, null);
    	            Soforler sofor = new Soforler(getirilen.getInt("þoförID"), null, null, null, null, null);

    	            satisList.add(new Satislar(
    	                getirilen.getInt("satýþID"),
    	                urun,
    	                musteri,
    	                araç,
    	                sofor,
    	                getirilen.getBigDecimal("miktar"),
    	                getirilen.getBigDecimal("toplam_fiyat"),
    	                getirilen.getTimestamp("satýþ_tarihi"),
    	                getirilen.getString("ödeme_durumu")
    	            ));
    	        }
    	        Col_stþ_ID.setCellValueFactory(new PropertyValueFactory<>("satýþID"));
    	        Col_stþ_ad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getÜrünID().getÜrün_adý()));
    	        Col_stþ_mþtID.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMüþteriID().getMüþteriID() + ""));
    	        Col_stþ_miktar.setCellValueFactory(new PropertyValueFactory<>("miktar"));
    	        Col_stþ_topkazanç.setCellValueFactory(new PropertyValueFactory<>("toplam_fiyat"));
    	        Col_stþ_tarih.setCellValueFactory(new PropertyValueFactory<>("satýþ_tarihi"));
    	        Col_stþ_ödnmdurum.setCellValueFactory(new PropertyValueFactory<>("ödeme_durumu"));

    	        tablo.setItems(satisList);
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	        showAlert("Satýþlarý Getirme Kýsmýnda Veritabaný Hatasý", "Veritabaný iþlemi sýrasýnda bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
    	    } finally {
    	        try {
    	            if (getirilen != null) getirilen.close();
    	            if (sorguifadesi != null) sorguifadesi.close();
    	            if (baglanti != null) baglanti.close();
    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        }
    	    }
    	}
    
    private void odemeDurumuListesi() {
    	checkAndReconnect();
        String sql = "SELECT s.*, u.ürün_adý AS ürün_adý, m.ad AS müþteri_ad, m.soyad AS müþteri_soyad " +
                     "FROM satislar s " +
                     "JOIN ürünler u ON s.ürünID = u.ürünID " +
                     "JOIN müþteriler m ON s.müþteriID = m.müþteriID " +
                     "WHERE s.ödeme_durumu = 'Ödenmedi'";
        ObservableList<Satislar> satisList = FXCollections.observableArrayList();
        try {
            baglanti = VeritabanýUtil.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();
            while (getirilen.next()) {
                Urunler urun = new Urunler(getirilen.getInt("ürünID"), getirilen.getString("ürün_adý"), null, null, null, null);
                Musteriler musteri = new Musteriler(getirilen.getInt("müþteriID"), getirilen.getString("müþteri_ad"), getirilen.getString("müþteri_soyad"), null, null, null);
                Araçlar araç = new Araçlar(getirilen.getInt("araçID"), null, null, null, null, null, null, null, null, null);
                Soforler sofor = new Soforler(getirilen.getInt("þoförID"), null, null, null, null, null);

                satisList.add(new Satislar(
                    getirilen.getInt("satýþID"),
                    urun,
                    musteri,
                    araç,
                    sofor,
                    getirilen.getBigDecimal("miktar"),
                    getirilen.getBigDecimal("toplam_fiyat"),
                    getirilen.getTimestamp("satýþ_tarihi"),
                    getirilen.getString("ödeme_durumu")
                ));
            }
            Col_ödnmyn_ID.setCellValueFactory(new PropertyValueFactory<>("satýþID"));
            Col_ödnmyn_mþtrad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMüþteriID().getAd()));
            Col_ödnmyn_mþtrsoyad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMüþteriID().getSoyad()));
            Col_ödnmyn_ürünad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getÜrünID().getÜrün_adý()));
            Col_ödnmyn_ürünmik.setCellValueFactory(new PropertyValueFactory<>("miktar"));
            Col_ödnmyn_ürünfyt.setCellValueFactory(new PropertyValueFactory<>("toplam_fiyat"));
            Col_ödnmyn_durum.setCellValueFactory(new PropertyValueFactory<>("ödeme_durumu"));

            ödnmemiþ_stþ_view.setItems(satisList);
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Satýþlarý Getirme Kýsmýnda Veritabaný Hatasý", "Veritabaný iþlemi sýrasýnda bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
        } finally {
            try {
                if (getirilen != null) getirilen.close();
                if (sorguifadesi != null) sorguifadesi.close();
                if (baglanti != null) baglanti.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    @FXML
    void initialize() {
    	//Fonksiyonlarýn Çaðrý Noktasý
    	AraçlarýGetir(tümaraçlar_view);
    	AraçlarýListele();
    	MüþterileriGetir(müþteriler_view);
    	musteriListele();
    	ÜrünleriGetir(ürünler_view);
    	ÜrünleriListele();
    	ÞoförleriGetir(þfr_view);
    	ÞoförleriListele();
    	satislariGetir(stþ_Satýþlar_view); 
    	SatýslarArçListele();
    	SatýslarÞfrlrListele();
    	odemeDurumuListesi();
    	
    	//Home ekraný
    	  gunlukSatis();
          dünküSatis();
          son7gunSatis();
          buAySatis();
          toplamSatis();
          toplamSofor();
          toplamMusteri();
          toplamArac();
          son10Satis();
          son10Odeme();
         
    	//benim fake labellerim
    	sçln_þfr_fakelbl.textProperty().bind(sçln_þfr_lbl.textProperty());
    	
    	//Verim için Manuel eventler
    	müþteriler_view.setOnMouseClicked((MouseEvent event) -> {
            Musteriler selectedMusteri = müþteriler_view.getSelectionModel().getSelectedItem();
            if (selectedMusteri != null) {
                sçlnmþtr_lbl.setText(String.valueOf(selectedMusteri.getMüþteriID()));
                // Ýsteðe baðlý ek iþlemler burada yapýlabilir.
            }
        });
    	tümaraçlar_view.setOnMouseClicked((MouseEvent event) -> {
            Araçlar selectedAraç = tümaraçlar_view.getSelectionModel().getSelectedItem();
            if (selectedAraç != null) {
            	arçekle_plaka_txt.setText(selectedAraç.getPlaka());
                arçekle_marka_txt.setText(selectedAraç.getMarka());
                arçekle_yýl_txt.setText(selectedAraç.getYýl());
                arçekle_araçtipi_txt.setText(selectedAraç.getAraç_tipi());
                arçekle_durum_txt.setText(selectedAraç.getDurum());
                arçekle_km_txt.setText(selectedAraç.getKm());
                arçekle_bakým_txt.setText(selectedAraç.getBakýmý());
                arçekle_yakýttürü_txt.setText(selectedAraç.getYakýt_türü());
                sçln_arçID_lbl.setText(String.valueOf(selectedAraç.getAraçID()));
                güncelleGrafik(selectedAraç.getAraçID());
            }
        });
    	kçk_þfr_view.setOnMouseClicked((MouseEvent event) -> {
            Soforler selectedSofor = kçk_þfr_view.getSelectionModel().getSelectedItem();
            if (selectedSofor != null) {
                sçln_þfrID_lbl.setText(String.valueOf(selectedSofor.getÞoförID()));
            }
        });
    	 ürünler_view.setOnMouseClicked(event -> {
             Urunler selectedUrun = ürünler_view.getSelectionModel().getSelectedItem();
             if (selectedUrun != null) {
                 ürnsec_lbl.setText(String.valueOf(selectedUrun.getÜrünID()));
                 updt_ürnad_txt.setText(selectedUrun.getÜrün_adý());
                 updt_kgfiyat_txt.setText(String.valueOf(selectedUrun.getKilobaþý_fiyat()));
                 updt_tplmkg_txt.setText(String.valueOf(selectedUrun.getToplam_kg()));
                 updt_ürndrm_txt.setText(selectedUrun.getÜrün_durumu());
             }
         });
    	 þfr_view.setOnMouseClicked((MouseEvent event) -> {
    	        if (event.getClickCount() > 0) {
    	            Soforler seçilenÞoför = þfr_view.getSelectionModel().getSelectedItem();
    	            if (seçilenÞoför != null) {
    	                sçln_þfr_lbl.setText(String.valueOf(seçilenÞoför.getÞoförID()));
    	            }
    	        }
    	    });
    	 þfr_arç_view.setOnMouseClicked((MouseEvent event) -> {
    	        if (event.getClickCount() > 0) {
    	            Araçlar seçilenAraç = þfr_arç_view.getSelectionModel().getSelectedItem();
    	            if (seçilenAraç != null) {
    	            	sçln_þfrarçID_lbl.setText(String.valueOf(seçilenAraç.getAraçID()));
    	            } 
    	        }
    	    });
    	 ödnmemiþ_stþ_view.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
             if (newValue != null) {
                 ödmedrmu_lbl.setText(String.valueOf(newValue.getSatýþID()));
             }
         });
    	 stþ_müþteriler_view.setOnMouseClicked(this::müþteriSeç);
         stþ_ürünler_view.setOnMouseClicked(this::ürünSeç);
         stþ_arç_view.setOnMouseClicked(this::satýslararacSeç);
         stþ_þfr_view.setOnMouseClicked(this::satýslarþoförSeç);
    	
    	 // ComboBox'lara Deðerler Atama.
    	 araç_durum_cmbx.setItems(FXCollections.observableArrayList("aktif", "inaktif"));
    	 araç_bakým_cmbx.setItems(FXCollections.observableArrayList("var", "yok"));
    	 
    }
    
    private void gunlukSatis() {
        String sql = "SELECT SUM(toplam_fiyat) AS gunluk_satis FROM satislar WHERE DATE(satýþ_tarihi) = CURDATE()";
        try {
            baglanti = VeritabanýUtil.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();
            if (getirilen.next()) {
                bgn_stþ_lbl.setText(getirilen.getBigDecimal("gunluk_satis").toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (getirilen != null) getirilen.close(); if (sorguifadesi != null) sorguifadesi.close(); if (baglanti != null) baglanti.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
    
    private void dünküSatis() {
        checkAndReconnect();
        String sql = "SELECT SUM(toplam_fiyat) AS toplam FROM satislar WHERE DATE(satýþ_tarihi) = CURDATE() - INTERVAL 1 DAY";
        try {
            baglanti = VeritabanýUtil.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();
            if (getirilen.next()) {
                BigDecimal toplam = getirilen.getBigDecimal("toplam");
                if (toplam == null) {
                    toplam = BigDecimal.ZERO;
                }
                dün_stþ_lbl.setText(toplam.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Veritabaný Hatasý", "Dünkü satýþlarý getirirken bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
        } finally {
            try {
                if (getirilen != null) getirilen.close();
                if (sorguifadesi != null) sorguifadesi.close();
                if (baglanti != null) baglanti.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    
    private void son7gunSatis() {
        String sql = "SELECT SUM(toplam_fiyat) AS son7gun_satis FROM satislar WHERE DATE(satýþ_tarihi) >= CURDATE() - INTERVAL 7 DAY";
        try {
            baglanti = VeritabanýUtil.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();
            if (getirilen.next()) {
                sn7_stþ_lbl.setText(getirilen.getBigDecimal("son7gun_satis").toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (getirilen != null) getirilen.close(); if (sorguifadesi != null) sorguifadesi.close(); if (baglanti != null) baglanti.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
    
    private void buAySatis() {
        String sql = "SELECT SUM(toplam_fiyat) AS buay_satis FROM satislar WHERE MONTH(satýþ_tarihi) = MONTH(CURDATE()) AND YEAR(satýþ_tarihi) = YEAR(CURDATE())";
        try {
            baglanti = VeritabanýUtil.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();
            if (getirilen.next()) {
                buay_stþ_lbl.setText(getirilen.getBigDecimal("buay_satis").toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (getirilen != null) getirilen.close(); if (sorguifadesi != null) sorguifadesi.close(); if (baglanti != null) baglanti.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
    
    private void toplamSatis() {
        String sql = "SELECT SUM(toplam_fiyat) AS toplam_satis FROM satislar";
        try {
            baglanti = VeritabanýUtil.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();
            if (getirilen.next()) {
                tplm_stþ_lbl.setText(getirilen.getBigDecimal("toplam_satis").toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (getirilen != null) getirilen.close(); if (sorguifadesi != null) sorguifadesi.close(); if (baglanti != null) baglanti.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
    
    private void toplamSofor() {
        String sql = "SELECT COUNT(*) AS toplam_sofor FROM þoförler";
        try {
            baglanti = VeritabanýUtil.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();
            if (getirilen.next()) {
                tplm_þoför_lbl.setText(getirilen.getString("toplam_sofor"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (getirilen != null) getirilen.close(); if (sorguifadesi != null) sorguifadesi.close(); if (baglanti != null) baglanti.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
    
    private void toplamMusteri() {
        String sql = "SELECT COUNT(*) AS toplam_musteri FROM müþteriler";
        try {
            baglanti = VeritabanýUtil.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();
            if (getirilen.next()) {
                tplm_mþtr_lbl.setText(getirilen.getString("toplam_musteri"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (getirilen != null) getirilen.close(); if (sorguifadesi != null) sorguifadesi.close(); if (baglanti != null) baglanti.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
    
    private void toplamArac() {
        String sql = "SELECT COUNT(*) AS toplam_arac FROM araçlar";
        try {
            baglanti = VeritabanýUtil.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();
            if (getirilen.next()) {
                tplm_araç_lbl.setText(getirilen.getString("toplam_arac"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (getirilen != null) getirilen.close(); if (sorguifadesi != null) sorguifadesi.close(); if (baglanti != null) baglanti.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
    
    private void son10Satis() {
        String sql = "SELECT s.*, u.ürün_adý, m.ad AS müþteri_ad FROM satislar s JOIN ürünler u ON s.ürünID = u.ürünID JOIN müþteriler m ON s.müþteriID = m.müþteriID ORDER BY s.satýþ_tarihi DESC LIMIT 10";
        ObservableList<Satislar> satisList = FXCollections.observableArrayList();
        try {
            baglanti = VeritabanýUtil.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();
            while (getirilen.next()) {
                Urunler urun = new Urunler(getirilen.getInt("ürünID"), getirilen.getString("ürün_adý"), null, null, null, null);
                Musteriler musteri = new Musteriler(getirilen.getInt("müþteriID"), getirilen.getString("müþteri_ad"), null, null, null, null);
                Araçlar arac = new Araçlar(getirilen.getInt("araçID"), null, null, null, null, null, null, null, null, null);
                Soforler sofor = new Soforler(getirilen.getInt("þoförID"), null, null, null, null, null);

                satisList.add(new Satislar(
                    getirilen.getInt("satýþID"),
                    urun,
                    musteri,
                    arac,
                    sofor,
                    getirilen.getBigDecimal("miktar"),
                    getirilen.getBigDecimal("toplam_fiyat"),
                    getirilen.getTimestamp("satýþ_tarihi"),
                    getirilen.getString("ödeme_durumu")
                ));
            }
            Col_son10satýþ_ID.setCellValueFactory(new PropertyValueFactory<>("satýþID"));
            Col_son10satýþ_tarih.setCellValueFactory(new PropertyValueFactory<>("satýþ_tarihi"));
            Col_son10satýþ_müþteri.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMüþteriID().getAd()));
            Col_son10satýþ_ürün.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getÜrünID().getÜrün_adý()));
            Col_son10satýþ_miktar.setCellValueFactory(new PropertyValueFactory<>("miktar"));
            Col_son10satýþ_tutar.setCellValueFactory(new PropertyValueFactory<>("toplam_fiyat"));

            Son10Satýþ_tblview.setItems(satisList);
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Veritabaný Hatasý", e.getMessage(), Alert.AlertType.ERROR);
        } finally {
            try { if (getirilen != null) getirilen.close(); if (sorguifadesi != null) sorguifadesi.close(); if (baglanti != null) baglanti.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
    
    private void son10Odeme() {
        String sql = "SELECT o.odeme_id, o.ödeme_tarihi, m.ad AS musteri_ad, m.soyad AS musteri_soyad, u.ürün_adý, s.toplam_fiyat, s.satýþID, u.ürünID, m.müþteriID " +
                	 "FROM odemeler o " +
                	 "JOIN satislar s ON o.satýþ_id = s.satýþID " +
                	 "JOIN ürünler u ON s.ürünID = u.ürünID " +
                   	 "JOIN müþteriler m ON s.müþteriID = m.müþteriID " +
                	 "ORDER BY o.ödeme_tarihi DESC " +
                	 "LIMIT 10";
        ObservableList<Odeme> odemeList = FXCollections.observableArrayList();
        try {
            baglanti = VeritabanýUtil.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();
            while (getirilen.next()) {
                Satislar satis = new Satislar(getirilen.getInt("satýþID"), null, null, null, null, null, getirilen.getBigDecimal("toplam_fiyat"), null, null);
                Urunler urun = new Urunler(getirilen.getInt("ürünID"), getirilen.getString("ürün_adý"), null, null, null, null);
                Musteriler musteri = new Musteriler(getirilen.getInt("müþteriID"), getirilen.getString("musteri_ad"), getirilen.getString("musteri_soyad"), null, null, null);

                odemeList.add(new Odeme(
                    getirilen.getInt("odeme_id"),
                    getirilen.getTimestamp("ödeme_tarihi"),
                    satis,
                    urun,
                    musteri
                ));
            }

            Col_son10ödeme_tarih.setCellValueFactory(new PropertyValueFactory<>("ödeme_tarihi"));
            Col_son10ödeme_müþteriad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMüþteri_id().getAd()));
            Col_son10ödeme_müþterisoyad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMüþteri_id().getSoyad()));
            Col_son10ödeme_ürünad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getÜrün_id().getÜrün_adý()));
            Col_son10ödeme_tutar.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSatýþ_id().getToplam_fiyat().toString()));

            Son10Ödeme_tblview.setItems(odemeList);
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Veritabaný Hatasý", "Ödemeleri listelerken bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
        } finally {
            try {
                if (getirilen != null) getirilen.close();
                if (sorguifadesi != null) sorguifadesi.close();
                if (baglanti != null) baglanti.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


   
    //GRAFÝK VE SEÇ EVENTLERÝ
    private void güncelleGrafik(int araçID) {
        String sql = "SELECT yýl, km FROM araçlar WHERE araçID = ?";
        try {
            baglanti = VeritabanýUtil.Baglan();
            PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
            sorguifadesi.setInt(1, araçID);
            ResultSet getirilen = sorguifadesi.executeQuery();

            NumberAxis xAxis = new NumberAxis();
            NumberAxis yAxis = new NumberAxis();
            xAxis.setLabel("Yýl");
            yAxis.setLabel("Kilometre");

            xAxis.setAutoRanging(false);
            yAxis.setAutoRanging(false);

            xAxis.setLowerBound(0);
            yAxis.setLowerBound(0);

            arçkul_grafik.getXAxis().setAutoRanging(true);
            arçkul_grafik.getYAxis().setAutoRanging(true);
            
            arçkul_grafik.setTitle("Araç Kullanýmý");
            arçkul_grafik.getXAxis().setLabel("Yýl");
            arçkul_grafik.getYAxis().setLabel("Kilometre");

            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName("Araç ID: " + araçID);

            series.getData().add(new XYChart.Data<>("0", 0));

            while (getirilen.next()) {
                String yýl = getirilen.getString("yýl");
                int km = getirilen.getInt("km");
                series.getData().add(new XYChart.Data<>(yýl, km));
            }

            arçkul_grafik.getData().clear();
            arçkul_grafik.getData().add(series);

            getirilen.close();
            sorguifadesi.close();
            baglanti.close();
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Veritabaný Hatasý", "Veritabaný iþlemi sýrasýnda bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    private void müþteriSeç(MouseEvent event) {
        Musteriler seçilenMüþteri = stþ_müþteriler_view.getSelectionModel().getSelectedItem();
        if (seçilenMüþteri != null) {
            stþ_mþtrID_lbl.setText(String.valueOf(seçilenMüþteri.getMüþteriID()));
        }
    }
    
    @FXML
    private void ürünSeç(MouseEvent event) {
        Urunler seçilenÜrün = stþ_ürünler_view.getSelectionModel().getSelectedItem();
        if (seçilenÜrün != null) {
            stþ_ürnID_lbl.setText(String.valueOf(seçilenÜrün.getÜrünID()));
        }
    }
    
    private void satýslararacSeç(MouseEvent event) {
        Araçlar selectedAraç = stþ_arç_view.getSelectionModel().getSelectedItem();
        if (selectedAraç != null) {
            stþ_arçID_lbl.setText(String.valueOf(selectedAraç.getAraçID()));
        }
    }
    
    private void satýslarþoförSeç(MouseEvent event) {
        Soforler selectedSofor = stþ_þfr_view.getSelectionModel().getSelectedItem();
        if (selectedSofor != null) {
            stþ_þfrID_lbl.setText(String.valueOf(selectedSofor.getÞoförID()));
        }
    }

	public void setUserInfo(String username) {
		// TODO Auto-generated method stub
		
	}

}
