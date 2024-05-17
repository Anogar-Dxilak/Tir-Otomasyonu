package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.math.BigDecimal;
import com.MySQL.util.Veritaban�Util;
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
		baglanti=Veritaban�Util.Baglan();
	}
	
    Connection baglanti=null;
    PreparedStatement sorguifadesi=null;
    ResultSet getirilen=null;
    String sql;
    
    //Ba�lant�y� Kontrol et e�er Ba�l� De�ilse Tekrar Ba�lan
    private void checkAndReconnect() {
        try {
            if (baglanti == null || baglanti.isClosed()) {
                baglanti = Veritaban�Util.Baglan();
                System.out.println("Veritaban�na ba�land�.");
            }
        } catch (SQLException e) {
            showAlert("Veritaban� Ba�lant� Hatas�", "Veritaban�na yeniden ba�lan�lamad�: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Ara�lar> t�mara�lar_view;
    
    @FXML
    private TableColumn<Ara�lar, Integer> Col_ar�Ara�Tipi;

    @FXML
    private TableColumn<Ara�lar, String> Col_ar�Bak�m;

    @FXML
    private TableColumn<Ara�lar, String> Col_ar�Durum;

    @FXML
    private TableColumn<Ara�lar, String> Col_ar�Id;

    @FXML
    private TableColumn<Ara�lar, String> Col_ar�Km;

    @FXML
    private TableColumn<Ara�lar, String> Col_ar�Marka;

    @FXML
    private TableColumn<Ara�lar, String> Col_ar�Plaka;

    @FXML
    private TableColumn<Ara�lar, String> Col_ar�Yak�tT�r�;

    @FXML
    private TableColumn<Ara�lar, String> Col_ar�Y�l;
    
    @FXML
    private TableColumn<Ara�lar, String> Col_ar��frAd�;

    @FXML
    private TableView<Soforler> k�k_�fr_view;
    
    @FXML
    private TableColumn<Soforler, String> Col_k�k�fr_Ad�;

    @FXML
    private TableColumn<Soforler, String> Col_k�k�fr_Durum;

    @FXML
    private TableColumn<Soforler, Integer> Col_k�k�fr_ID;

    @FXML
    private TableColumn<Soforler, String> Col_k�k�fr_Soyad�;

    @FXML
    private TableColumn<Soforler, Timestamp> Col_k�k�fr_Tarih;
    
    @FXML
    private TableView<Satislar> �dnmemi�_st�_view;

    @FXML
    private TableColumn<Satislar, Integer> Col_�dnmyn_ID;

    @FXML
    private TableColumn<Satislar, String> Col_�dnmyn_durum;

    @FXML
    private TableColumn<Satislar, String> Col_�dnmyn_m�trad;

    @FXML
    private TableColumn<Satislar, String> Col_�dnmyn_m�trsoyad;

    @FXML
    private TableColumn<Satislar, String> Col_�dnmyn_�r�nad;

    @FXML
    private TableColumn<Satislar, BigDecimal> Col_�dnmyn_�r�nfyt;

    @FXML
    private TableColumn<Satislar, BigDecimal> Col_�dnmyn_�r�nmik;
    
    @FXML
    private TableView<Urunler> �r�nler_view;

    @FXML
    private TableColumn<Urunler, String> Col_�r�nAd;

    @FXML
    private TableColumn<Urunler, String> Col_�r�nDurum;

    @FXML
    private TableColumn<Urunler, Integer> Col_�r�nID;
    
    @FXML
    private TableColumn<Urunler, BigDecimal> Col_kgfiyat;
    
    @FXML
    private TableColumn<Urunler, BigDecimal> Col_tplmkg;
    
    @FXML
    private TableColumn<Urunler, Timestamp> Col_�r�ntarih;
    
    @FXML
    private TableView<Soforler> �fr_view;

    @FXML
    private TableColumn<Soforler, Integer> Col_�fr_ID;

    @FXML
    private TableColumn<Soforler, String> Col_�fr_ad;

    @FXML
    private TableColumn<Soforler, String> Col_�fr_durumu;

    @FXML
    private TableColumn<Soforler, Timestamp> Col_�fr_kyttarih;

    @FXML
    private TableColumn<Soforler, String> Col_�fr_soyad;

    @FXML
    private TableColumn<Soforler, String> Col_�fr_telno;
    
    @FXML
    private TableView<Ara�lar> �fr_ar�_view;

    @FXML
    private TableColumn<Ara�lar, Integer> Col_�frar�_ID;

    @FXML
    private TableColumn<Ara�lar, String> Col_�frar�_bkm;

    @FXML
    private TableColumn<Ara�lar, String> Col_�frar�_durum;

    @FXML
    private TableColumn<Ara�lar, String> Col_�frar�Ad�;

    @FXML
    private TableColumn<Ara�lar, String> Col_�frar�_km;

    @FXML
    private TableColumn<Ara�lar, String> Col_�frar�_marka;

    @FXML
    private TableColumn<Ara�lar, String> Col_�frar�_plaka;

    @FXML
    private TableColumn<Ara�lar, String> Col_�frar�_tipi;

    @FXML
    private TableColumn<Ara�lar, String> Col_�frar�_yktt�r;

    @FXML
    private TableColumn<Ara�lar, String> Col_�frar�_y�l;
    
    @FXML
    private TableView<Satislar> st�_Sat��lar_view;
    
    @FXML
    private TableColumn<Satislar, Integer> Col_st�_ID;

    @FXML
    private TableColumn<Satislar, String> Col_st�_ad;

    @FXML
    private TableColumn<Satislar, BigDecimal> Col_st�_miktar;

    @FXML
    private TableColumn<Satislar, String> Col_st�_m�tID;

    @FXML
    private TableColumn<Satislar, Timestamp> Col_st�_tarih;

    @FXML
    private TableColumn<Satislar, BigDecimal> Col_st�_topkazan�;

    @FXML
    private TableColumn<Satislar, String> Col_st�_�dnmdurum;

    @FXML
    private TableView<Musteriler> st�_m��teriler_view;
    
    @FXML
    private TableColumn<Musteriler, Integer> Col_st�m�tr_ID;

    @FXML
    private TableColumn<Musteriler, String> Col_st�m�tr_ad;

    @FXML
    private TableColumn<Musteriler, String> Col_st�m�tr_email;

    @FXML
    private TableColumn<Musteriler, String> Col_st�m�tr_soyad;

    @FXML
    private TableColumn<Musteriler, Timestamp> Col_st�m�tr_tarih;

    @FXML
    private TableColumn<Musteriler, String> Col_st�m�tr_tel;
    
    @FXML
    private TableView<Urunler> st�_�r�nler_view;

    @FXML
    private TableColumn<Urunler, Integer> Col_st��rn_ID;

    @FXML
    private TableColumn<Urunler, String> Col_st��rn_ad;

    @FXML
    private TableColumn<Urunler, String> Col_st��rn_durum;

    @FXML
    private TableColumn<Urunler, BigDecimal> Col_st��rn_kgfiyat;

    @FXML
    private TableColumn<Urunler, BigDecimal> Col_st��rn_mevcut;

    @FXML
    private TableColumn<Urunler, Timestamp> Col_st��rn_tarih;
    
    @FXML
    private TableView<Musteriler> m��teriler_view;
    
    @FXML
    private TableColumn<Musteriler, String> Col_m�trAd;

    @FXML
    private TableColumn<Musteriler, String> Col_m�trEmail;

    @FXML
    private TableColumn<Musteriler, Integer> Col_m�trId;

    @FXML
    private TableColumn<Musteriler, String> Col_m�trSoyad;

    @FXML
    private TableColumn<Musteriler, Timestamp> Col_m�trTarih;

    @FXML
    private TableColumn<Musteriler, String> Col_m�trTel;
    
    @FXML
    private TableView<Ara�lar> st�_ar�_view;
    
    @FXML
    private TableColumn<Ara�lar, Integer> Col_st�_ar�ID;
    
    @FXML
    private TableColumn<Ara�lar, String> Col_st�_ar�Marka;
    
    @FXML
    private TableColumn<Ara�lar, Integer> Col_st�_ar�Km;
    
    @FXML
    private TableColumn<Ara�lar, String> Col_st�_ar�Bak�m;
    
    @FXML
    private TableColumn<Ara�lar, String> Col_st�_ar�Yak�t;
    
    @FXML
    private TableColumn<Ara�lar, String> Col_st�_ar��of�rad;
    
    @FXML
    private TableView<Soforler> st�_�fr_view;
    
    @FXML
    private TableColumn<Soforler, Integer> Col_st�_�frID;
    
    @FXML
    private TableColumn<Soforler, String> Col_st�_�frad�;
    
    @FXML
    private TableColumn<Soforler, String> Col_st�_�frsoyad;
    
    @FXML
    private TableColumn<Soforler, String> Col_st�_�frtel;
    
    @FXML
    private TableColumn<Soforler, Timestamp> Col_st�_�frtarih;
    
    @FXML
    private TableView<Satislar> Son10Sat��_tblview;
    
    @FXML
    private TableColumn<Satislar, Integer> Col_son10sat��_ID;
    
    @FXML
    private TableColumn<Satislar, Timestamp> Col_son10sat��_tarih;
    
    @FXML
    private TableColumn<Satislar, String> Col_son10sat��_m��teri;
    
    @FXML
    private TableColumn<Satislar, String> Col_son10sat��_�r�n;
    
    @FXML
    private TableColumn<Satislar, BigDecimal> Col_son10sat��_miktar;
    
    @FXML
    private TableColumn<Satislar, BigDecimal> Col_son10sat��_tutar;
    
    @FXML
    private TableView<Odeme> Son10�deme_tblview;
    
    @FXML 
    private TableColumn<Odeme, Timestamp> Col_son10�deme_tarih;
    
    @FXML 
    private TableColumn<Odeme, String> Col_son10�deme_m��teriad;
    
    @FXML 
    private TableColumn<Odeme, String> Col_son10�deme_m��terisoyad;
    
    @FXML 
    private TableColumn<Odeme, String> Col_son10�deme_�r�nad;
    
    @FXML 
    private TableColumn<Odeme, String> Col_son10�deme_tutar;
    
    @FXML
    private TextField ar�ekle_marka_txt;

    @FXML
    private TextField ar�ekle_ara�tipi_txt;

    @FXML
    private TextField ar�ekle_plaka_txt;

    @FXML
    private TextField ar�ekle_yak�tt�r�_txt;

    @FXML
    private TextField ar�ekle_y�l_txt;
    
    @FXML
    private TextField ar�ekle_km_txt;
    
    @FXML
    private TextField ar�ekle_durum_txt;
    
    @FXML
    private TextField ar�ekle_bak�m_txt;
    
    @FXML
    private Button ar�ekle_btn;
    
    @FXML
    private Button ar�ekle_iptl_btn;

    @FXML
    private Button ar��fr_d�tr_btn;
    
    @FXML
    private Button ar��fr_d�triptl_btn;
    
    @FXML
    private Button Id_iptl_btn;

    @FXML
    private ComboBox<String> ara�_bak�m_cmbx;

    @FXML
    private ComboBox<String> ara�_durum_cmbx;

    @FXML
    private Button ar�_tnmla_btn;

    @FXML
    private Button ar�_tnmlaiptl_btn;

    @FXML
    private LineChart<String, Number> ar�kul_grafik;

    @FXML
    private Button ar�sil_btn;

    @FXML
    private Label bgn_st�_lbl;

    @FXML
    private Button bkm_ony_btn;

    @FXML
    private Label buay_st�_lbl;

    @FXML
    private Button drm_ony_btn;

    @FXML
    private Label d�n_st�_lbl;

    @FXML
    private Button lst_update_btn;
    
    @FXML
    private Button ar�_dznl_btn;
    
    @FXML
    private Label st�_ar�ID_lbl;
    
    @FXML
    private Label st�_�frID_lbl;

    @FXML
    private TextField m�tr_adara_txt;

    @FXML
    private Button m�tr_bul_btn;

    @FXML
    private Button m�tr_buliptl_btn;

    @FXML
    private Button m�tr_dznl_btn;

    @FXML
    private Button m�tr_ekle_btn;

    @FXML
    private Button m�tr_iptl_btn;
    
    @FXML
    private Button �fr_aktfd��_btn;
    
    @FXML
    private Button �fr_aktfd��_btn2;

    @FXML
    private Button m�tr_list_updt_btn;

    @FXML
    private Button m�tr_sil_btn;

    @FXML
    private TextField m�tr_soyadara_txt;

    @FXML
    private TextField m�trekle_ad_txt;

    @FXML
    private TextField m�trekle_email_txt;

    @FXML
    private TextField m�trekle_soyad_txt;

    @FXML
    private TextField m�trekle_tel_txt;

    @FXML
    private LineChart<?, ?> sat��lar_grafik;

    @FXML
    private Label sn7_st�_lbl;
    
    @FXML
    private Label st�_�fr_lbl;
    
    @FXML
    private Label st�_ar�_lbl;

    @FXML
    private Label s�l_�fr_lbl;
    
    @FXML
    private Label s�ln_�frar�ID_lbl;

    @FXML
    private Label s�ln_�frID_lbl;
    
    @FXML
    private Label st�_�rnID_lbl;
    
    @FXML
    private Label st�_m�trID_lbl;
    
    @FXML
    private Label s�ln_ar�ID_lbl;

    @FXML
    private Label s�ln_�fr_fakelbl;
    
    @FXML
    private Label s�ln_�fr_lbl;

    @FXML
    private Label s�lnm�tr_lbl;

    @FXML
    private Label tplm_ara�_lbl;

    @FXML
    private Label tplm_m�tr_lbl;

    @FXML
    private Label tplm_st�_lbl;

    @FXML
    private Label tplm_�of�r_lbl;

    @FXML
    private TextField updt_kgfiyat_txt;

    @FXML
    private TextField updt_tplmkg_txt;

    @FXML
    private TextField updt_�rnad_txt;

    @FXML
    private TextField updt_�rndrm_txt;

    @FXML
    private Button �deme_btn;
    
    @FXML
    private Button tbllr_gncll_btn;

    @FXML
    private Button �deme_iptl_btn;

    @FXML
    private Label �dmedrmu_lbl;

    @FXML
    private Button �rn_kald�r_btn;

    @FXML
    private Button �rnblgi_updt_btn;

    @FXML
    private Button �rnekle_btn;

    @FXML
    private TextField �rnekle_kgba��_txt;

    @FXML
    private Button �rnekle_tmzl_btn;

    @FXML
    private TextField �rnekle_tplmkg_txt;

    @FXML
    private TextField �rnekle_�rndrm_txt;

    @FXML
    private TextField �rnekle_�r�nad_txt;
    
    @FXML
    private TextField st�_�rnst�_txt;
    
    @FXML
    private Button st�_st�yap_btn;

    @FXML
    private Label �rnsec_lbl;

    @FXML
    private Button �rnsec_tmzl_btn;

    @FXML
    private Button �r�n_list_upt_btn;

    @FXML
    private RadioButton �fr_drm_radio1;

    @FXML
    private RadioButton �fr_drm_radio2;

    @FXML
    private ToggleGroup �fr_durum_radio;

    @FXML
    private Button �fr_ekle_btn;

    @FXML
    private TextField �fr_eklead_txt;

    @FXML
    private Button �fr_ekleiptl_btn;

    @FXML
    private TextField �fr_eklesoyad_txt;

    @FXML
    private TextField �fr_ekletelno_txt;

    @FXML
    private Button �fr_lstupt_btn;

    @FXML
    private Button �fr_sil_btn;

    @FXML
    private Button �fr_siltmzl_btn;
    
    @FXML
    void ar�_dznl_Click(ActionEvent event) {
    	checkAndReconnect();
    	 try {
    	        int selectedAra�ID = Integer.parseInt(s�ln_ar�ID_lbl.getText());
    	        String plaka = ar�ekle_plaka_txt.getText();
    	        String marka = ar�ekle_marka_txt.getText();
    	        String y�l = ar�ekle_y�l_txt.getText();
    	        String ara�Tipi = ar�ekle_ara�tipi_txt.getText();
    	        String durum = ar�ekle_durum_txt.getText();
    	        String km = ar�ekle_km_txt.getText();
    	        String bak�m� = ar�ekle_bak�m_txt.getText();
    	        String yak�tT�r� = ar�ekle_yak�tt�r�_txt.getText();

    	        // Bo� alan kontrol�
    	        if (plaka.isEmpty() || marka.isEmpty() || y�l.isEmpty() || ara�Tipi.isEmpty() || durum.isEmpty() || km.isEmpty() || bak�m�.isEmpty() || yak�tT�r�.isEmpty()) {
    	            showAlert("Bo� Alan Hatas�", "L�tfen t�m alanlar� doldurun.", Alert.AlertType.INFORMATION);
    	            return;
    	        }

    	        // Say�sal giri� kontrol� (y�l ve km)
    	        if (!y�l.matches("\\d+") || !km.matches("\\d+")) {
    	            showAlert("Ge�ersiz Giri�", "Y�l ve Km alanlar�na sadece say� girmelisiniz.", Alert.AlertType.INFORMATION);
    	            return;
    	        }

    	        // Bak�m alan� kontrol� (var/yok)
    	        if (!bak�m�.equals("var") && !bak�m�.equals("yok")) {
    	            showAlert("Ge�ersiz Giri�", "Bak�m alan�na sadece 'var' veya 'yok' girmelisiniz.", Alert.AlertType.INFORMATION);
    	            return;
    	        }

    	        // Durum alan� kontrol� (aktif/inaktif)
    	        if (!durum.equals("aktif") && !durum.equals("inaktif")) {
    	            showAlert("Ge�ersiz Giri�", "Durum alan�na sadece 'aktif' veya 'inaktif' girmelisiniz.", Alert.AlertType.INFORMATION);
    	            return;
    	        }

    	        String sql = "UPDATE ara�lar SET plaka = ?, marka = ?, y�l = ?, ara�_tipi = ?, durum = ?, km = ?, bak�m� = ?, yak�t_t�r� = ? WHERE ara�ID = ?";

    	        PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
    	        sorguifadesi.setString(1, plaka);
    	        sorguifadesi.setString(2, marka);
    	        sorguifadesi.setString(3, y�l);
    	        sorguifadesi.setString(4, ara�Tipi);
    	        sorguifadesi.setString(5, durum);
    	        sorguifadesi.setString(6, km);
    	        sorguifadesi.setString(7, bak�m�);
    	        sorguifadesi.setString(8, yak�tT�r�);
    	        sorguifadesi.setInt(9, selectedAra�ID);

    	        int result = sorguifadesi.executeUpdate();
    	        if (result > 0) {
    	            showAlert("Ba�ar�l�", "Ara� ba�ar�yla g�ncellendi!", Alert.AlertType.CONFIRMATION);
    	            ar�_temizle();
    	            Ara�lar�Getir(t�mara�lar_view);
    	        } else {
    	            showAlert("Ba�ar�s�z", "Ara� g�ncellenemedi!", Alert.AlertType.ERROR);
    	        }
    	    } catch (SQLException e) {
    	        showAlert("Veritaban� Hatas�", "Ara� g�ncellenirken bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
    	    }
    }
    
    @FXML
    void tbllr_gncll_Click(ActionEvent event) {
    	Ara�lar�Getir(t�mara�lar_view);
    	Ara�lar�Listele();
    	M��terileriGetir(m��teriler_view);
    	musteriListele();
    	�r�nleriGetir(�r�nler_view);
    	�r�nleriListele();
    	�of�rleriGetir(�fr_view);
    	�of�rleriListele();
    	satislariGetir(st�_Sat��lar_view); 
    	Sat�slarAr�Listele();
    	Sat�slar�frlrListele();
    	odemeDurumuListesi();
    }
    
    @FXML
    void ar�ekle_Click(ActionEvent event) {
        checkAndReconnect();
        String plaka = ar�ekle_plaka_txt.getText();
        String marka = ar�ekle_marka_txt.getText();
        String y�l = ar�ekle_y�l_txt.getText();
        String ara�Tipi = ar�ekle_ara�tipi_txt.getText();
        String durum = ar�ekle_durum_txt.getText();
        String km = ar�ekle_km_txt.getText();
        String bak�m� = ar�ekle_bak�m_txt.getText();
        String yak�tT�r� = ar�ekle_yak�tt�r�_txt.getText();
        int �of�rID = 1;

        // Bo� alan kontrol�
        if (plaka.isEmpty() || marka.isEmpty() || y�l.isEmpty() || ara�Tipi.isEmpty() || durum.isEmpty() || km.isEmpty() || bak�m�.isEmpty() || yak�tT�r�.isEmpty()) {
            showAlert("Bo� Alan Hatas�", "L�tfen t�m alanlar� doldurun.", Alert.AlertType.INFORMATION);
            return;
        }

        // Say�sal giri� kontrol� (y�l ve km)
        if (!y�l.matches("\\d+") || !km.matches("\\d+")) {
            showAlert("Ge�ersiz Giri�", "Y�l ve Km alanlar�na sadece say� girmelisiniz.", Alert.AlertType.INFORMATION);
            return;
        }

        // Bak�m alan� kontrol� (var/yok)
        if (!bak�m�.equals("var") && !bak�m�.equals("yok")) {
            showAlert("Ge�ersiz Giri�", "Bak�m alan�na sadece 'var' veya 'yok' girmelisiniz.", Alert.AlertType.INFORMATION);
            return;
        }

        // Durum alan� kontrol� (aktif/inaktif)
        if (!durum.equals("aktif") && !durum.equals("inaktif")) {
            showAlert("Ge�ersiz Giri�", "Durum alan�na sadece 'aktif' veya 'inaktif' girmelisiniz.", Alert.AlertType.INFORMATION);
            return;
        }

        String sql = "INSERT INTO ara�lar (plaka, marka, y�l, ara�_tipi, durum, km, bak�m�, yak�t_t�r�, �of�rID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
            sorguifadesi.setString(1, plaka);
            sorguifadesi.setString(2, marka);
            sorguifadesi.setString(3, y�l);
            sorguifadesi.setString(4, ara�Tipi);
            sorguifadesi.setString(5, durum);
            sorguifadesi.setString(6, km);
            sorguifadesi.setString(7, bak�m�);
            sorguifadesi.setString(8, yak�tT�r�);
            sorguifadesi.setInt(9, �of�rID);

            int result = sorguifadesi.executeUpdate();
            if (result > 0) {
                showAlert("Ba�ar�l�", "Ara� ba�ar�yla eklendi!", Alert.AlertType.CONFIRMATION);
                Ara�lar�Getir(t�mara�lar_view);
                ar�_temizle();
            } else {
                showAlert("Ba�ar�s�z", "Ara� eklenemedi!", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            showAlert("Veritaban� Hatas�", "Ara� eklenirken bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }


    	private void ar�_temizle() {
    	    ar�ekle_plaka_txt.clear();
    	    ar�ekle_marka_txt.clear();
    	    ar�ekle_y�l_txt.clear();
    	    ar�ekle_ara�tipi_txt.clear();
    	    ar�ekle_durum_txt.clear();
    	    ar�ekle_km_txt.clear();
    	    ar�ekle_bak�m_txt.clear();
    	    ar�ekle_yak�tt�r�_txt.clear();
    	}
    	
    @FXML
    void ar�ekle_iptl_Click(ActionEvent event) {
    	ar�_temizle();
    }
    
    @FXML
    void ar��fr_d�tr_Click(ActionEvent event) {
    	 String aracIDText = s�ln_ar�ID_lbl.getText();
         String soforIDText = s�ln_�frID_lbl.getText();

         if (aracIDText.isEmpty() || soforIDText.isEmpty()) {
             showAlert("Ge�ersiz Giri�", "L�tfen hem ara� hem de �of�r ID'lerini se�in.", Alert.AlertType.INFORMATION);
             return;
         }

         int aracID = Integer.parseInt(aracIDText);
         int soforID = Integer.parseInt(soforIDText);

         String sql = "UPDATE ara�lar SET �of�rID = ? WHERE ara�ID = ?";

         try {
             baglanti = Veritaban�Util.Baglan(); 
             PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
             sorguifadesi.setInt(1, soforID);
             sorguifadesi.setInt(2, aracID);
             int rowsUpdated = sorguifadesi.executeUpdate();

             if (rowsUpdated > 0) {
                 showAlert("Ba�ar�l�", "Ara� �of�r� ba�ar�yla g�ncellendi.", Alert.AlertType.CONFIRMATION);
                 s�ln_ar�ID_lbl.setText("L�tfen ID se�in");
                 s�ln_�frID_lbl.setText("L�tfen ID se�in");
             } else {
                 showAlert("Ba�ar�s�z", "G�ncelleme s�ras�nda bir hata olu�tu.", Alert.AlertType.ERROR);
             }

             sorguifadesi.close();
             baglanti.close();
         } catch (SQLException e) {
             e.printStackTrace();
             showAlert("Veritaban� Hatas�", "Veritaban� i�lemi s�ras�nda bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
         }
    }
    
    @FXML
    void ar��fr_d�triptl_Click(ActionEvent event) {
    	s�ln_ar�ID_lbl.setText("L�tfen ID se�in");
        s�ln_�frID_lbl.setText("L�tfen ID se�in");
    }

    @FXML
    void ar�_tnmla_Click(ActionEvent event) {
    	checkAndReconnect();
    	String ara�IDText = s�ln_�frar�ID_lbl.getText();
        String �of�rIDText = s�ln_�fr_lbl.getText();

        if (ara�IDText.equals("Se�ilen Ara�") || �of�rIDText.equals("Se�ilen Ki�i")) {
            showAlert("Ge�ersiz Giri�", "L�tfen hem ara� hem de �of�r se�in.", Alert.AlertType.INFORMATION);
            return;
        }

        int ara�ID = Integer.parseInt(ara�IDText);
        int �of�rID = Integer.parseInt(�of�rIDText);

        String sql = "UPDATE ara�lar SET �of�rID = ? WHERE ara�ID = ?";
        try {
            PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
            sorguifadesi.setInt(1, �of�rID);
            sorguifadesi.setInt(2, ara�ID);

            int result = sorguifadesi.executeUpdate();
            if (result > 0) {
                showAlert("Ba�ar�l�", "Ara� ba�ar�yla tan�mland�!", Alert.AlertType.CONFIRMATION);
                Ara�lar�Listele();
                s�ln_ar�ID_lbl.setText("Se�ilen Ara�");
            } else {
                showAlert("Ba�ar�s�z", "Ara� tan�mlanamad�!", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            showAlert("Veritaban� Hatas�", "Ara� tan�mlan�rken bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    void ar�_tnmlaiptl_Click(ActionEvent event) {
    	s�ln_�frar�ID_lbl.setText("Se�ilen Ara�");
    }

    @FXML
    void m�tr_bul_Click(ActionEvent event) {
    	 String m��teriAd = m�tr_adara_txt.getText();
    	    String m��teriSoyad = m�tr_soyadara_txt.getText();

    	    if (m��teriAd.isEmpty() || m��teriSoyad.isEmpty()) {
    	        showAlert("Eksik Bilgi", "L�tfen m��teri ad� ve soyad�n� girin.", Alert.AlertType.WARNING);
    	        return;
    	    }

    	    checkAndReconnect();
    	    String sql = "SELECT s.*, u.�r�n_ad� AS �r�n_ad�, m.ad AS m��teri_ad, m.soyad AS m��teri_soyad " +
    	                 "FROM satislar s " +
    	                 "JOIN �r�nler u ON s.�r�nID = u.�r�nID " +
    	                 "JOIN m��teriler m ON s.m��teriID = m.m��teriID " +
    	                 "WHERE s.�deme_durumu = '�denmedi' AND m.ad = ? AND m.soyad = ?";
    	    ObservableList<Satislar> satisList = FXCollections.observableArrayList();
    	    try {
    	        baglanti = Veritaban�Util.Baglan();
    	        sorguifadesi = baglanti.prepareStatement(sql);
    	        sorguifadesi.setString(1, m��teriAd);
    	        sorguifadesi.setString(2, m��teriSoyad);
    	        getirilen = sorguifadesi.executeQuery();
    	        while (getirilen.next()) {
    	            Urunler urun = new Urunler(getirilen.getInt("�r�nID"), getirilen.getString("�r�n_ad�"), null, null, null, null);
    	            Musteriler musteri = new Musteriler(getirilen.getInt("m��teriID"), getirilen.getString("m��teri_ad"), getirilen.getString("m��teri_soyad"), null, null, null);
    	            Ara�lar ara� = new Ara�lar(getirilen.getInt("ara�ID"), null, null, null, null, null, null, null, null, null);
    	            Soforler sofor = new Soforler(getirilen.getInt("�of�rID"), null, null, null, null, null);

    	            satisList.add(new Satislar(
    	                getirilen.getInt("sat��ID"),
    	                urun,
    	                musteri,
    	                ara�,
    	                sofor,
    	                getirilen.getBigDecimal("miktar"),
    	                getirilen.getBigDecimal("toplam_fiyat"),
    	                getirilen.getTimestamp("sat��_tarihi"),
    	                getirilen.getString("�deme_durumu")
    	            ));
    	        }
    	        Col_�dnmyn_ID.setCellValueFactory(new PropertyValueFactory<>("sat��ID"));
    	        Col_�dnmyn_m�trad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getM��teriID().getAd()));
    	        Col_�dnmyn_m�trsoyad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getM��teriID().getSoyad()));
    	        Col_�dnmyn_�r�nad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get�r�nID().get�r�n_ad�()));
    	        Col_�dnmyn_�r�nmik.setCellValueFactory(new PropertyValueFactory<>("miktar"));
    	        Col_�dnmyn_�r�nfyt.setCellValueFactory(new PropertyValueFactory<>("toplam_fiyat"));
    	        Col_�dnmyn_durum.setCellValueFactory(new PropertyValueFactory<>("�deme_durumu"));

    	        �dnmemi�_st�_view.setItems(satisList);
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	        showAlert("Sat��lar� Getirme K�sm�nda Veritaban� Hatas�", "Veritaban� i�lemi s�ras�nda bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
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
    void m�tr_buliptl_Click(ActionEvent event) {
    	 m�tr_adara_txt.clear();
    	 m�tr_soyadara_txt.clear();
    	 odemeDurumuListesi();
    }

    @FXML
    void m�tr_dznl_Click(ActionEvent event) {
    	checkAndReconnect();
    	String selectedMusteriID = s�lnm�tr_lbl.getText();

        if (selectedMusteriID.isEmpty() || selectedMusteriID.equals("Se�ilen M��teri")) {
            showAlert("Ge�ersiz Giri�", "L�tfen d�zenlemek i�in bir m��teri se�in.", Alert.AlertType.INFORMATION);
            return;
        }

        int musteriID = Integer.parseInt(selectedMusteriID);
        String ad = m�trekle_ad_txt.getText();
        String soyad = m�trekle_soyad_txt.getText();
        String tel = m�trekle_tel_txt.getText();
        String email = m�trekle_email_txt.getText();

        if (ad.isEmpty() || soyad.isEmpty() || tel.isEmpty() || email.isEmpty()) {
            showAlert("Bo� Alan Hatas�", "L�tfen t�m alanlar� doldurun.", Alert.AlertType.INFORMATION);
            return;
        }

        String sql = "UPDATE m��teriler SET ad = ?, soyad = ?, tel_no = ?, email = ? WHERE m��teriID = ?";

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
                showAlert("Ba�ar�l�", "M��teri ba�ar�yla g�ncellendi!", Alert.AlertType.CONFIRMATION);
                M��terileriGetir(m��teriler_view);
            } else {
                showAlert("Ba�ar�s�z", "M��teri g�ncellenemedi!", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            showAlert("Veritaban� Hatas�", "M��teri g�ncellenirken bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    void m�tr_ekle_Click(ActionEvent event) {
    	String ad = m�trekle_ad_txt.getText();
    	String soyad = m�trekle_soyad_txt.getText();
    	String tel = m�trekle_tel_txt.getText();
    	String email = m�trekle_email_txt.getText();
    	    if (ad.isEmpty() || soyad.isEmpty() || tel.isEmpty() || email.isEmpty()) {  	
    	        showAlert("Bo� Alan Hatas�", "L�tfen t�m alanlar� doldurun.", Alert.AlertType.INFORMATION);
    	        return;
    	    }

    	    String sql = "INSERT INTO m��teriler (ad, soyad, tel_no, email) VALUES (?, ?, ?, ?)";

    	    try {
    	        checkAndReconnect();
    	        PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
    	        sorguifadesi.setString(1, ad);
    	        sorguifadesi.setString(2, soyad);
    	        sorguifadesi.setString(3, tel);
    	        sorguifadesi.setString(4, email);
    	        int result = sorguifadesi.executeUpdate();

    	        if (result > 0) {
    	            showAlert("Ba�ar�l�", "M��teri ba�ar�yla eklendi!", Alert.AlertType.CONFIRMATION);
    	            m�tr_temizle();
    	            M��terileriGetir(m��teriler_view);
    	        } else {
    	            showAlert("Ba�ar�s�z", "M��teri eklenemedi!", Alert.AlertType.ERROR);
    	        }
    	    } catch (SQLException e) {
    	        showAlert("Veritaban� Hatas�", "M��teri eklenirken bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
    	    }
    	}

    @FXML
    void m�tr_iptal_Click(ActionEvent event) {
    	m�tr_temizle();
    }
    
    private void m�tr_temizle() {
        m�trekle_ad_txt.clear();
        m�trekle_soyad_txt.clear();
        m�trekle_tel_txt.clear();
        m�trekle_email_txt.clear();
        s�lnm�tr_lbl.setText("Se�ilen M��teri");
    }

    @FXML
    void m�tr_list_updt_Click(ActionEvent event) {
    	Ara�lar�Getir(t�mara�lar_view);
    	Ara�lar�Listele();
    	M��terileriGetir(m��teriler_view);
    	musteriListele();
    	�r�nleriGetir(�r�nler_view);
    	�r�nleriListele();
    	�of�rleriGetir(�fr_view);
    	�of�rleriListele();
    	satislariGetir(st�_Sat��lar_view); 
    	Sat�slarAr�Listele();
    	Sat�slar�frlrListele();
    	odemeDurumuListesi();
    }

    @FXML
    void m�tr_sil_Click(ActionEvent event) {
    	checkAndReconnect();
    	String selectedMusteriID = s�lnm�tr_lbl.getText();

    	    if (selectedMusteriID.isEmpty() || selectedMusteriID.equals("Se�ilen M��teri")) {
    	        showAlert("Ge�ersiz Giri�", "L�tfen silmek i�in bir m��teri se�in.", Alert.AlertType.INFORMATION);
    	        return;
    	    }

    	    int musteriID = Integer.parseInt(selectedMusteriID);

    	    String sql = "DELETE FROM m��teriler WHERE m��teriID = ?";

    	    try {
    	        checkAndReconnect();
    	        PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
    	        sorguifadesi.setInt(1, musteriID);
    	        int result = sorguifadesi.executeUpdate();

    	        if (result > 0) {
    	            showAlert("Ba�ar�l�", "M��teri ba�ar�yla silindi!", Alert.AlertType.CONFIRMATION);
    	            s�lnm�tr_lbl.setText("Se�ilen M��teri");
    	            M��terileriGetir(m��teriler_view);
    	        } else {
    	            showAlert("Ba�ar�s�z", "M��teri silinemedi!", Alert.AlertType.ERROR);
    	        }
    	    } catch (SQLException e) {
    	        showAlert("Veritaban� Hatas�", "M��teri silinirken bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
    	    }
    }

    @FXML
    void �deme_Click(ActionEvent event) {
    	checkAndReconnect();
        String selectedID = �dmedrmu_lbl.getText();

        if (selectedID.isEmpty() || selectedID.equals("Se�ilen ID")) {
            showAlert("Ge�ersiz Giri�", "L�tfen bir ID se�in.", Alert.AlertType.INFORMATION);
            return;
        }

        int id = Integer.parseInt(selectedID);

        String updateSql = "UPDATE satislar SET �deme_durumu = ? WHERE sat��ID = ?";
        String selectSql = "SELECT * FROM satislar WHERE sat��ID = ?";

        try {
            checkAndReconnect();
            PreparedStatement updateSorgu = baglanti.prepareStatement(updateSql);
            updateSorgu.setString(1, "�dendi");
            updateSorgu.setInt(2, id);
            int result = updateSorgu.executeUpdate();

            if (result > 0) {
                showAlert("Ba�ar�l�", "�deme durumu ba�ar�yla g�ncellendi!", Alert.AlertType.CONFIRMATION);
                �dmedrmu_lbl.setText("Se�ilen ID");

                // G�ncellenen sat�� kayd�n� se�
                PreparedStatement selectSorgu = baglanti.prepareStatement(selectSql);
                selectSorgu.setInt(1, id);
                ResultSet rs = selectSorgu.executeQuery();

                if (rs.next()) {
                    int satisID = rs.getInt("sat��ID");
                    int urunID = rs.getInt("�r�nID");
                    int musteriID = rs.getInt("m��teriID");

                    // �deme bilgilerini odemeler tablosuna ekle
                    String insertSql = "INSERT INTO odemeler (sat��_id, �r�n_id, m��teri_id) VALUES (?, ?, ?)";
                    PreparedStatement insertSorgu = baglanti.prepareStatement(insertSql);
                    insertSorgu.setInt(1, satisID);
                    insertSorgu.setInt(2, urunID);
                    insertSorgu.setInt(3, musteriID);

                    int insertResult = insertSorgu.executeUpdate();

                    if (insertResult > 0) {
                        showAlert("Ba�ar�l�", "�deme bilgileri ba�ar�yla kaydedildi!", Alert.AlertType.CONFIRMATION);
                        son10Odeme();
                    } else {
                        showAlert("Ba�ar�s�z", "�deme bilgileri kaydedilemedi!", Alert.AlertType.ERROR);
                    }
                }
            } else {
                showAlert("Ba�ar�s�z", "�deme durumu g�ncellenemedi!", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            showAlert("Veritaban� Hatas�", "�deme durumu g�ncellenirken bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
        } finally {
            try {
                if (baglanti != null) baglanti.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void �deme_iptl_btn(ActionEvent event) {
    	�dmedrmu_lbl.setText("Se�ilen ID");
    }

    @FXML
    void �rn_kald�r_Click(ActionEvent event) {
    	checkAndReconnect();
    	String idText = �rnsec_lbl.getText();

        if (idText.isEmpty() || idText.equals("Se�ilen �r�n")) {
            showAlert("Ge�ersiz Giri�", "L�tfen bir �r�n se�in.", Alert.AlertType.INFORMATION);
            return;
        }

        int id = Integer.parseInt(idText);

        String sql = "DELETE FROM �r�nler WHERE �r�nID = ?";

        try {
            checkAndReconnect();
            PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
            sorguifadesi.setInt(1, id);

            int result = sorguifadesi.executeUpdate();
            if (result > 0) {
                showAlert("Ba�ar�l�", "�r�n ba�ar�yla silindi!", Alert.AlertType.CONFIRMATION);
                temizleG�ncelle();
            } else {
                showAlert("Ba�ar�s�z", "�r�n silinemedi!", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            showAlert("Veritaban� Hatas�", "�r�n silinirken bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    void �rnblgi_updt_Click(ActionEvent event) {
    	checkAndReconnect();
    	String idText = �rnsec_lbl.getText();
        String ad = updt_�rnad_txt.getText();
        String kgfiyat = updt_kgfiyat_txt.getText();
        String tplmkg = updt_tplmkg_txt.getText();
        String durum = updt_�rndrm_txt.getText();

         if (idText.isEmpty() || ad.isEmpty() || kgfiyat.isEmpty() || tplmkg.isEmpty() || durum.isEmpty()) {
             showAlert("Bo� Alan Hatas�", "L�tfen t�m alanlar� doldurun.", Alert.AlertType.INFORMATION);
             return;
         }

         if (!kgfiyat.matches("\\d+(\\.\\d+)?") || !tplmkg.matches("\\d+(\\.\\d+)?")) {
             showAlert("Ge�ersiz Giri�", "Kilo Ba�� Fiyat ve Toplam Kg alanlar�na sadece say� girmelisiniz.", Alert.AlertType.INFORMATION);
             return;
         }

         int id = Integer.parseInt(idText);

         String sql = "UPDATE �r�nler SET �r�n_ad� = ?, kiloba��_fiyat = ?, toplam_kg = ?, �r�n_durumu = ? WHERE �r�nID = ?";

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
                 showAlert("Ba�ar�l�", "�r�n ba�ar�yla g�ncellendi!", Alert.AlertType.CONFIRMATION);
                 temizleG�ncelle();
             } else {
                 showAlert("Ba�ar�s�z", "�r�n g�ncellenemedi!", Alert.AlertType.ERROR);
             }
         } catch (SQLException e) {
             showAlert("Veritaban� Hatas�", "�r�n g�ncellenirken bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
         }
    }

    @FXML
    void �rnekle_Click(ActionEvent event) {
    	checkAndReconnect();
    	String ad = �rnekle_�r�nad_txt.getText();
        String kgfiyat = �rnekle_kgba��_txt.getText();
        String tplmkg = �rnekle_tplmkg_txt.getText();
        String durum = �rnekle_�rndrm_txt.getText();

        // Bo� alan kontrol�
        if (ad.isEmpty() || kgfiyat.isEmpty() || tplmkg.isEmpty() || durum.isEmpty()) {
            showAlert("Bo� Alan Hatas�", "L�tfen t�m alanlar� doldurun.", Alert.AlertType.INFORMATION);
            return;
        }

        // Say�sal giri� kontrol� (kgfiyat ve tplmkg)
        if (!kgfiyat.matches("\\d+(\\.\\d+)?") || !tplmkg.matches("\\d+(\\.\\d+)?")) {
            showAlert("Ge�ersiz Giri�", "Kilo Ba�� Fiyat ve Toplam Kg alanlar�na sadece say� girmelisiniz.", Alert.AlertType.INFORMATION);
            return;
        }

        String sql = "INSERT INTO �r�nler (�r�n_ad�, kiloba��_fiyat, toplam_kg, �r�n_durumu) VALUES (?, ?, ?, ?)";

        try {
            checkAndReconnect();
            PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
            sorguifadesi.setString(1, ad);
            sorguifadesi.setBigDecimal(2, new BigDecimal(kgfiyat));
            sorguifadesi.setBigDecimal(3, new BigDecimal(tplmkg));
            sorguifadesi.setString(4, durum);

            int result = sorguifadesi.executeUpdate();
            if (result > 0) {
                showAlert("Ba�ar�l�", "�r�n ba�ar�yla eklendi!", Alert.AlertType.CONFIRMATION);
                temizleEkle();
            } else {
                showAlert("Ba�ar�s�z", "�r�n eklenemedi!", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            showAlert("Veritaban� Hatas�", "�r�n eklenirken bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    void �rnekle_tmzl_Click(ActionEvent event) {
    	 temizleEkle();
    }

    @FXML
    void �rnsec_tmzl_Click(ActionEvent event) {
    	temizleG�ncelle();
    }

    @FXML
    void �r�n_list_upt_Click(ActionEvent event) {
    	�r�nleriGetir(�r�nler_view);
    }
    
    private void temizleEkle() {
        �rnekle_�r�nad_txt.clear();
        �rnekle_kgba��_txt.clear();
        �rnekle_tplmkg_txt.clear();
        �rnekle_�rndrm_txt.clear();
    }
    
    private void temizleG�ncelle() {
        updt_�rnad_txt.clear();
        updt_kgfiyat_txt.clear();
        updt_tplmkg_txt.clear();
        updt_�rndrm_txt.clear();
        �rnsec_lbl.setText("Se�ilen �r�n");
    }

    @FXML
    void �fr_ekle_Click(ActionEvent event) {
    	checkAndReconnect();
    	String ad = �fr_eklead_txt.getText();
        String soyad = �fr_eklesoyad_txt.getText();
        String telno = �fr_ekletelno_txt.getText();
        String durum = �fr_drm_radio1.isSelected() ? "�naktif" : "Aktif";

        if (ad.isEmpty() || soyad.isEmpty() || telno.isEmpty()) {
            showAlert("Bo� Alan Hatas�", "L�tfen t�m alanlar� doldurun.", Alert.AlertType.INFORMATION);
            return;
        }

        String sql = "INSERT INTO �of�rler (ad, soyad, tel_no, durumu) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
            sorguifadesi.setString(1, ad);
            sorguifadesi.setString(2, soyad);
            sorguifadesi.setString(3, telno);
            sorguifadesi.setString(4, durum);

            int result = sorguifadesi.executeUpdate();
            if (result > 0) {
                showAlert("Ba�ar�l�", "�of�r ba�ar�yla eklendi!", Alert.AlertType.CONFIRMATION);
                �of�rleriGetir(�fr_view);
                �fr_eklead_txt.clear();
                �fr_eklesoyad_txt.clear();
                �fr_ekletelno_txt.clear();
                �fr_drm_radio1.setSelected(true);
            } else {
                showAlert("Ba�ar�s�z", "�of�r eklenemedi!", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            showAlert("Veritaban� Hatas�", "�of�r eklenirken bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    void �fr_aktfd��_Click(ActionEvent event) {
    	checkAndReconnect();
        
        String �of�rIDText = s�ln_�fr_lbl.getText();
        if (�of�rIDText == null || �of�rIDText.isEmpty() || �of�rIDText.equals("Se�ilen Ki�i")) {
            showAlert("Ge�ersiz Giri�", "L�tfen bir �of�r se�in.", Alert.AlertType.INFORMATION);
            return;
        }

        int �of�rID = Integer.parseInt(�of�rIDText);

        String sqlSelect = "SELECT durumu FROM �of�rler WHERE �of�rID = ?";
        String sqlUpdate = "UPDATE �of�rler SET durumu = ? WHERE �of�rID = ?";

        try {
            PreparedStatement sorguifadesi = baglanti.prepareStatement(sqlSelect);
            sorguifadesi.setInt(1, �of�rID);
            ResultSet getirilen = sorguifadesi.executeQuery();

            if (getirilen.next()) {
                String currentStatus = getirilen.getString("durumu");
                String newStatus = currentStatus.equals("Aktif") ? "�naktif" : "Aktif";

                PreparedStatement updateStatement = baglanti.prepareStatement(sqlUpdate);
                updateStatement.setString(1, newStatus);
                updateStatement.setInt(2, �of�rID);
                int result = updateStatement.executeUpdate();

                if (result > 0) {
                    showAlert("Ba�ar�l�", "�of�r durumu ba�ar�yla de�i�tirildi!", Alert.AlertType.CONFIRMATION);
                    �of�rleriGetir(�fr_view);
                    s�ln_�fr_lbl.setText("Se�ilen Ki�i");
                } else {
                    showAlert("Ba�ar�s�z", "�of�r durumu de�i�tirilemedi!", Alert.AlertType.ERROR);
                }
            } else {
                showAlert("�of�r Bulunamad�", "Belirtilen ID'ye sahip bir �of�r bulunamad�.", Alert.AlertType.ERROR);
            }

        } catch (SQLException e) {
            showAlert("Veritaban� Hatas�", "Veritaban� i�lemi s�ras�nda bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }
    
    @FXML
    void �fr_aktfd��_Click2(ActionEvent event) {
    	checkAndReconnect();
        String �of�rIDText = s�ln_�fr_lbl.getText();
        if (�of�rIDText == null || �of�rIDText.isEmpty() || �of�rIDText.equals("Se�ilen Ki�i")) {
            showAlert("Ge�ersiz Giri�", "L�tfen bir �of�r se�in.", Alert.AlertType.INFORMATION);
            return;
        }
        int �of�rID = Integer.parseInt(�of�rIDText);
        String currentStatus = null;
        String sqlSelect = "SELECT durumu FROM �of�rler WHERE �of�rID = ?";
        try (PreparedStatement sorguifadesi = baglanti.prepareStatement(sqlSelect)) {
            sorguifadesi.setInt(1, �of�rID);
            ResultSet getirilen = sorguifadesi.executeQuery();
            if (getirilen.next()) {
                currentStatus = getirilen.getString("durumu");
            }
        } catch (SQLException e) {
            showAlert("Veritaban� Hatas�", "Veritaban� i�lemi s�ras�nda bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
            return;
        }
        if (currentStatus == null) {
            showAlert("�of�r Bulunamad�", "Belirtilen ID'ye sahip bir �of�r bulunamad�.", Alert.AlertType.ERROR);
            return;
        }
        String newStatus = "�naktif";
        if (currentStatus.equals("�naktif")) {
            newStatus = "Aktif";
        }
        String sqlUpdate = "UPDATE �of�rler SET durumu = ? WHERE �of�rID = ?";
        try (PreparedStatement sorguifadesi = baglanti.prepareStatement(sqlUpdate)) {
            sorguifadesi.setString(1, newStatus);
            sorguifadesi.setInt(2, �of�rID);
            int result = sorguifadesi.executeUpdate();
            if (result > 0) {
                showAlert("Ba�ar�l�", "�of�r durumu ba�ar�yla g�ncellendi!", Alert.AlertType.CONFIRMATION);
                �of�rleriGetir(�fr_view);
                s�ln_�fr_lbl.setText("Se�ilen Ki�i");
            } else {
                showAlert("Ba�ar�s�z", "�of�r durumu de�i�tirilemedi!", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            showAlert("Veritaban� Hatas�", "Veritaban� i�lemi s�ras�nda bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    @FXML
    void �fr_ekleiptl_Click(ActionEvent event) {
    	�fr_eklead_txt.clear();
        �fr_eklesoyad_txt.clear();
        �fr_ekletelno_txt.clear();
        �fr_drm_radio1.setSelected(true);
    }

    @FXML
    void �fr_lstupt_Click(ActionEvent event) {
    	�of�rleriGetir(�fr_view);
    	Ara�lar�Listele();
    }

    @FXML
    void �fr_sil_Click(ActionEvent event) {
    	checkAndReconnect();
    	String �of�rIDText = s�ln_�fr_lbl.getText();
        if (�of�rIDText.equals("Se�ilen Ki�i")) {
            showAlert("Ge�ersiz Giri�", "L�tfen bir �of�r se�in.", Alert.AlertType.INFORMATION);
            return;
        }

        int �of�rID = Integer.parseInt(�of�rIDText);

        String sql = "DELETE FROM �of�rler WHERE �of�rID = ?";
        try {
            PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
            sorguifadesi.setInt(1, �of�rID);

            int result = sorguifadesi.executeUpdate();
            if (result > 0) {
                showAlert("Ba�ar�l�", "�of�r ba�ar�yla silindi!", Alert.AlertType.CONFIRMATION);
                �of�rleriGetir(�fr_view);
                s�ln_�fr_lbl.setText("Se�ilen Ki�i");
            } else {
                showAlert("Ba�ar�s�z", "�of�r silinemedi!", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            showAlert("Veritaban� Hatas�", "�of�r silinirken bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    void �fr_siltmzl_Click(ActionEvent event) {
    	s�ln_�fr_lbl.setText("Se�ilen Ki�i");
    }
    
    @FXML
    void bkm_ony_Click(ActionEvent event) {
    	checkAndReconnect();
    	String aracIDText = s�ln_ar�ID_lbl.getText();
        String yeniBak�m = ara�_bak�m_cmbx.getValue();

        if (aracIDText.isEmpty() || yeniBak�m == null || aracIDText.equals("L�tfen ID se�in")) {
            showAlert("Ge�ersiz Giri�", "L�tfen hem ara� ID'sini se�in hem de bak�m durumunu belirleyin.", Alert.AlertType.INFORMATION);
            return;
        }

        try {
            int aracID = Integer.parseInt(aracIDText);

            String sql = "UPDATE ara�lar SET bak�m� = ? WHERE ara�ID = ?";

            try {
                checkAndReconnect();
                PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
                sorguifadesi.setString(1, yeniBak�m);
                sorguifadesi.setInt(2, aracID);
                int rowsUpdated = sorguifadesi.executeUpdate();

                if (rowsUpdated > 0) {
                    showAlert("Ba�ar�l�", "Ara� bak�m durumu ba�ar�yla g�ncellendi.", Alert.AlertType.CONFIRMATION);
                    s�ln_ar�ID_lbl.setText("L�tfen ID se�in");
                    ara�_bak�m_cmbx.getSelectionModel().clearSelection();
                    Ara�lar�Getir(t�mara�lar_view);
                } else {
                    showAlert("Ba�ar�s�z", "G�ncelleme s�ras�nda bir hata olu�tu.", Alert.AlertType.ERROR);
                }

                sorguifadesi.close();
            } catch (SQLException e) {
                e.printStackTrace();
                showAlert("Veritaban� Hatas�", "Veritaban� i�lemi s�ras�nda bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        } catch (NumberFormatException e) {
            showAlert("Ge�ersiz ID", "L�tfen ge�erli bir ara� ID'si se�in.", Alert.AlertType.INFORMATION);
        	}
    }

    @FXML
    void drm_ony_Click(ActionEvent event) {
    	checkAndReconnect();
    	String aracIDText = s�ln_ar�ID_lbl.getText();
        String yeniDurum = ara�_durum_cmbx.getValue();

        if (aracIDText.isEmpty() || yeniDurum == null || aracIDText.equals("L�tfen ID se�in")) {
            showAlert("Ge�ersiz Giri�", "L�tfen hem ara� ID'sini se�in hem de durumu belirleyin.", Alert.AlertType.INFORMATION);
            return;
        }

        try {
            int aracID = Integer.parseInt(aracIDText);

            String sql = "UPDATE ara�lar SET durum = ? WHERE ara�ID = ?";

            try {
                checkAndReconnect();
                PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
                sorguifadesi.setString(1, yeniDurum);
                sorguifadesi.setInt(2, aracID);
                int rowsUpdated = sorguifadesi.executeUpdate();

                if (rowsUpdated > 0) {
                    showAlert("Ba�ar�l�", "Ara� durumu ba�ar�yla g�ncellendi.", Alert.AlertType.CONFIRMATION);
                    s�ln_ar�ID_lbl.setText("L�tfen ID se�in");
                    ara�_durum_cmbx.getSelectionModel().clearSelection();
                    Ara�lar�Getir(t�mara�lar_view);
                } else {
                    showAlert("Ba�ar�s�z", "G�ncelleme s�ras�nda bir hata olu�tu.", Alert.AlertType.ERROR);
                }

                sorguifadesi.close();
            } catch (SQLException e) {
                e.printStackTrace();
                showAlert("Veritaban� Hatas�", "Veritaban� i�lemi s�ras�nda bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        } catch (NumberFormatException e) {
            showAlert("Ge�ersiz ID", "L�tfen ge�erli bir ara� ID'si se�in.", Alert.AlertType.INFORMATION);
        }
    }
    
    @FXML
    void ar�sil_Click(ActionEvent event) {
    	checkAndReconnect();
    	String aracIDText = s�ln_ar�ID_lbl.getText();

        if (aracIDText.isEmpty()) {
            showAlert("Ge�ersiz Giri�", "L�tfen ara� ID'sini se�in.", Alert.AlertType.INFORMATION);
            return;
        }

        int aracID = Integer.parseInt(aracIDText);

        String sql = "DELETE FROM ara�lar WHERE ara�ID = ?";

        try {
            checkAndReconnect();
            PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
            sorguifadesi.setInt(1, aracID);
            int rowsDeleted = sorguifadesi.executeUpdate();

            if (rowsDeleted > 0) {
                showAlert("Ba�ar�l�", "Ara� ba�ar�yla silindi.", Alert.AlertType.CONFIRMATION);
                s�ln_ar�ID_lbl.setText("L�tfen ID se�in");
                Ara�lar�Getir(t�mara�lar_view);
            } else {
                showAlert("Ba�ar�s�z", "Silme i�lemi s�ras�nda bir hata olu�tu.", Alert.AlertType.ERROR);
            }

            sorguifadesi.close();
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Veritaban� Hatas�", "Veritaban� i�lemi s�ras�nda bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    void Id_iptl_Click(ActionEvent event) {
    	ara�_durum_cmbx.getSelectionModel().clearSelection();
        ara�_bak�m_cmbx.getSelectionModel().clearSelection();
    }
    
    @FXML
    void lst_update_Click(ActionEvent event) {
    	Ara�lar�Getir(t�mara�lar_view);
    }
    
    @FXML
    void st�_st�yap_Click(ActionEvent event) {
    	checkAndReconnect();
        String m��teriID = st�_m�trID_lbl.getText();
        String �r�nID = st�_�rnID_lbl.getText();
        String aracID = st�_ar�ID_lbl.getText();
        String �of�rID = st�_�frID_lbl.getText();
        String miktarStr = st�_�rnst�_txt.getText();

        if (m��teriID.isEmpty() || �r�nID.isEmpty() || aracID.isEmpty() || �of�rID.isEmpty() || miktarStr.isEmpty()) {
            showAlert("Eksik Bilgi", "L�tfen t�m bilgileri doldurun.", Alert.AlertType.WARNING);
            return;
        }

        BigDecimal miktar;
        try {
            miktar = new BigDecimal(miktarStr);
        } catch (NumberFormatException e) {
            showAlert("Ge�ersiz Miktar", "L�tfen ge�erli bir miktar girin.", Alert.AlertType.WARNING);
            return;
        }

        try {
            String sql = "SELECT kiloba��_fiyat, toplam_kg FROM �r�nler WHERE �r�nID = ?";
            PreparedStatement ps = baglanti.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(�r�nID));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                BigDecimal kgFiyat = rs.getBigDecimal("kiloba��_fiyat");
                BigDecimal toplamKg = rs.getBigDecimal("toplam_kg");

                if (toplamKg.compareTo(miktar) < 0) {
                    showAlert("Yetersiz Stok", "Yeterli miktarda �r�n bulunmamaktad�r.", Alert.AlertType.WARNING);
                    return;
                }

                BigDecimal toplamFiyat = kgFiyat.multiply(miktar);
                String insertSql = "INSERT INTO satislar (m��teriID, �r�nID, miktar, toplam_fiyat, ara�ID, �of�rID) VALUES (?, ?, ?, ?, ?, ?)";
                ps = baglanti.prepareStatement(insertSql);
                ps.setInt(1, Integer.parseInt(m��teriID));
                ps.setInt(2, Integer.parseInt(�r�nID));
                ps.setBigDecimal(3, miktar);
                ps.setBigDecimal(4, toplamFiyat);
                ps.setInt(5, Integer.parseInt(aracID));
                ps.setInt(6, Integer.parseInt(�of�rID));
                ps.executeUpdate();

                String updateSql = "UPDATE �r�nler SET toplam_kg = toplam_kg - ? WHERE �r�nID = ?";
                ps = baglanti.prepareStatement(updateSql);
                ps.setBigDecimal(1, miktar);
                ps.setInt(2, Integer.parseInt(�r�nID));
                ps.executeUpdate();

                showAlert("Ba�ar�l�", "Sat�� i�lemi ba�ar�yla ger�ekle�tirildi.", Alert.AlertType.INFORMATION);
                �r�nleriListele(); // �r�n listesini g�ncelle
                satislariGetir(st�_Sat��lar_view); // Sat�� listesini g�ncelle
            }
        } catch (SQLException e) {
            showAlert("Veritaban� Hatas�", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    private void showAlert(String title, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void Ara�lar�Getir(TableView<Ara�lar> tablo) {
        String sql = "SELECT a.ara�ID, a.plaka, a.marka, a.y�l, a.ara�_tipi, a.durum, a.km, a.bak�m�, a.yak�t_t�r�, s.�of�rID, s.ad AS �of�r_ad� FROM ara�lar a JOIN �of�rler s ON a.�of�rID = s.�of�rID";
        ObservableList<Ara�lar> ara�Listesi = FXCollections.observableArrayList();
        try {
            baglanti = Veritaban�Util.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();
            while (getirilen.next()) {
                Soforler sofor = new Soforler(
                    getirilen.getInt("�of�rID"),
                    getirilen.getString("�of�r_ad�"),
                    null, null, null, null
                );

                ara�Listesi.add(new Ara�lar(
                    getirilen.getInt("ara�ID"),
                    getirilen.getString("plaka"),
                    getirilen.getString("marka"),
                    getirilen.getString("y�l"),
                    getirilen.getString("ara�_tipi"),
                    getirilen.getString("durum"),
                    getirilen.getString("km"),
                    getirilen.getString("bak�m�"),
                    getirilen.getString("yak�t_t�r�"),
                    sofor
                ));
            }

            Col_ar�Id.setCellValueFactory(new PropertyValueFactory<>("ara�ID"));
            Col_ar�Plaka.setCellValueFactory(new PropertyValueFactory<>("plaka"));
            Col_ar�Marka.setCellValueFactory(new PropertyValueFactory<>("marka"));
            Col_ar�Y�l.setCellValueFactory(new PropertyValueFactory<>("y�l"));
            Col_ar�Ara�Tipi.setCellValueFactory(new PropertyValueFactory<>("ara�_tipi"));
            Col_ar�Durum.setCellValueFactory(new PropertyValueFactory<>("durum"));
            Col_ar�Km.setCellValueFactory(new PropertyValueFactory<>("km"));
            Col_ar�Bak�m.setCellValueFactory(new PropertyValueFactory<>("bak�m�"));
            Col_ar�Yak�tT�r�.setCellValueFactory(new PropertyValueFactory<>("yak�t_t�r�"));
            Col_ar��frAd�.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get�of�rID().getAd()));

            tablo.setItems(ara�Listesi);
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Ara�lar� Getirme K�sm�nda Veritaban� Hatas�", "Veritaban� i�lemi s�ras�nda bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
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

    
    public void Ara�lar�Listele() {
        String sql = "SELECT a.ara�ID, a.plaka, a.marka, a.y�l, a.ara�_tipi, a.durum, a.km, a.bak�m�, a.yak�t_t�r�, s.�of�rID, s.ad AS �of�r_ad� FROM ara�lar a JOIN �of�rler s ON a.�of�rID = s.�of�rID";
        ObservableList<Ara�lar> ara�List = FXCollections.observableArrayList();
        try {
            baglanti = Veritaban�Util.Baglan(); 
            sorguifadesi = baglanti.prepareStatement(sql);
            ResultSet getirilen = sorguifadesi.executeQuery();
            while (getirilen.next()) {
                Soforler sofor = new Soforler(
                    getirilen.getInt("�of�rID"),
                    getirilen.getString("�of�r_ad�"),
                    null, null, null, null 
                );
                
                ara�List.add(new Ara�lar(
                    getirilen.getInt("ara�ID"),
                    getirilen.getString("plaka"),
                    getirilen.getString("marka"),
                    getirilen.getString("y�l"),
                    getirilen.getString("ara�_tipi"),
                    getirilen.getString("durum"),
                    getirilen.getString("km"),
                    getirilen.getString("bak�m�"),
                    getirilen.getString("yak�t_t�r�"),
                    sofor 
                ));
            }
            Col_�frar�_ID.setCellValueFactory(new PropertyValueFactory<>("ara�ID"));
            Col_�frar�_plaka.setCellValueFactory(new PropertyValueFactory<>("plaka"));
            Col_�frar�_marka.setCellValueFactory(new PropertyValueFactory<>("marka"));
            Col_�frar�_y�l.setCellValueFactory(new PropertyValueFactory<>("y�l"));
            Col_�frar�_tipi.setCellValueFactory(new PropertyValueFactory<>("ara�_tipi"));
            Col_�frar�_durum.setCellValueFactory(new PropertyValueFactory<>("durum"));
            Col_�frar�_km.setCellValueFactory(new PropertyValueFactory<>("km"));
            Col_�frar�_bkm.setCellValueFactory(new PropertyValueFactory<>("bak�m�"));
            Col_�frar�_yktt�r.setCellValueFactory(new PropertyValueFactory<>("yak�t_t�r�"));
            Col_�frar�Ad�.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get�of�rID().getAd()));

            �fr_ar�_view.setItems(ara�List);
        } catch (SQLException e) {
            showAlert("Ara�lar� Listeleme K�sm�nda Veritaban� Hatas�", "Veritaban� i�lemi s�ras�nda bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
        } finally {
            try {
                if (getirilen != null) getirilen.close();
                if (sorguifadesi != null) sorguifadesi.close();
                if (baglanti != null) baglanti.close();
            } catch (SQLException e) {
                showAlert("Kaynaklar� Kapama Hatas�", "Kaynaklar� kapat�rken bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        }
    }


    
    public void M��terileriGetir(TableView<Musteriler> tablo) {
    	checkAndReconnect();
    	
        sql = "SELECT * FROM m��teriler";
        ObservableList<Musteriler> m�trList = FXCollections.observableArrayList();
        try {
            sorguifadesi = baglanti.prepareStatement(sql);
            ResultSet getirilen = sorguifadesi.executeQuery();
            while (getirilen.next()) {
                m�trList.add(new Musteriler(
                    getirilen.getInt("m��teriID"),
                    getirilen.getString("ad"),
                    getirilen.getString("soyad"),
                    getirilen.getString("tel_no"),
                    getirilen.getString("email"),
                    getirilen.getTimestamp("kay�t_tarihi")
                ));
            }
            Col_m�trId.setCellValueFactory(new PropertyValueFactory<>("m��teriID"));
            Col_m�trAd.setCellValueFactory(new PropertyValueFactory<>("ad"));
            Col_m�trSoyad.setCellValueFactory(new PropertyValueFactory<>("soyad"));
            Col_m�trTel.setCellValueFactory(new PropertyValueFactory<>("tel_no"));
            Col_m�trEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            Col_m�trTarih.setCellValueFactory(new PropertyValueFactory<>("kay�t_tarihi"));
            
            tablo.setItems(m�trList);
        } catch (SQLException e) {
        	e.printStackTrace();
            showAlert("M��terileri Getirme K�sm�nda Veritaban� Hatas�", "Veritaban� i�lemi s�ras�nda bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    public void musteriListele() {
        String sql = "SELECT * FROM m��teriler";
        ObservableList<Musteriler> m�trList = FXCollections.observableArrayList();

        try {
            sorguifadesi = baglanti.prepareStatement(sql);
            ResultSet getirilen = sorguifadesi.executeQuery();

            while (getirilen.next()) {
                m�trList.add(new Musteriler(
                    getirilen.getInt("m��teriID"),
                    getirilen.getString("ad"),
                    getirilen.getString("soyad"),
                    getirilen.getString("tel_no"),
                    getirilen.getString("email"),
                    getirilen.getTimestamp("kay�t_tarihi")
                ));
            }

            Col_st�m�tr_ID.setCellValueFactory(new PropertyValueFactory<>("m��teriID"));
            Col_st�m�tr_ad.setCellValueFactory(new PropertyValueFactory<>("ad"));
            Col_st�m�tr_soyad.setCellValueFactory(new PropertyValueFactory<>("soyad"));
            Col_st�m�tr_tel.setCellValueFactory(new PropertyValueFactory<>("tel_no"));
            Col_st�m�tr_email.setCellValueFactory(new PropertyValueFactory<>("email"));
            Col_st�m�tr_tarih.setCellValueFactory(new PropertyValueFactory<>("kay�t_tarihi"));

            st�_m��teriler_view.setItems(m�trList);
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Listeleme K�sm�nda Veritaban� Hatas�", "Veritaban� i�lemi s�ras�nda bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    private void Sat�slarAr�Listele() {
        ObservableList<Ara�lar> ara�List = FXCollections.observableArrayList();
        String sql = "SELECT a.ara�ID, a.plaka, a.marka, a.y�l, a.ara�_tipi, a.durum, a.km, a.bak�m�, a.yak�t_t�r�, s.ad AS �of�r_ad� " +
                     "FROM ara�lar a " +
                     "LEFT JOIN �of�rler s ON a.�of�rID = s.�of�rID " +
                     "WHERE a.durum = 'aktif'";

        try {
            baglanti = Veritaban�Util.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();

            while (getirilen.next()) {
                ara�List.add(new Ara�lar(
                    getirilen.getInt("ara�ID"),
                    getirilen.getString("plaka"),
                    getirilen.getString("marka"),
                    getirilen.getString("y�l"),
                    getirilen.getString("ara�_tipi"),
                    getirilen.getString("durum"),
                    getirilen.getString("km"),
                    getirilen.getString("bak�m�"),
                    getirilen.getString("yak�t_t�r�"),
                    new Soforler(0, getirilen.getString("�of�r_ad�"), null, null, null, null)
                ));
            }

            Col_st�_ar�ID.setCellValueFactory(new PropertyValueFactory<>("ara�ID"));
            Col_st�_ar�Marka.setCellValueFactory(new PropertyValueFactory<>("marka"));
            Col_st�_ar�Km.setCellValueFactory(new PropertyValueFactory<>("km"));
            Col_st�_ar�Bak�m.setCellValueFactory(new PropertyValueFactory<>("bak�m�"));
            Col_st�_ar�Yak�t.setCellValueFactory(new PropertyValueFactory<>("yak�t_t�r�"));
            Col_st�_ar��of�rad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get�of�rID().getAd()));

            st�_ar�_view.setItems(ara�List);
        } catch (SQLException e) {
            showAlert("Veritaban� Hatas�", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    private void Sat�slar�frlrListele() {
        ObservableList<Soforler> �of�rList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM �of�rler WHERE durumu = 'aktif'";

        try {
            baglanti = Veritaban�Util.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();

            while (getirilen.next()) {
                �of�rList.add(new Soforler(
                        getirilen.getInt("�of�rID"),
                        getirilen.getString("ad"),
                        getirilen.getString("soyad"),
                        getirilen.getString("tel_no"),
                        getirilen.getTimestamp("kay�t_tarihi"),
                        getirilen.getString("durumu")
                ));
            }

            Col_st�_�frID.setCellValueFactory(new PropertyValueFactory<>("�of�rID"));
            Col_st�_�frad�.setCellValueFactory(new PropertyValueFactory<>("ad"));
            Col_st�_�frsoyad.setCellValueFactory(new PropertyValueFactory<>("soyad"));
            Col_st�_�frtel.setCellValueFactory(new PropertyValueFactory<>("tel_no"));
            Col_st�_�frtarih.setCellValueFactory(new PropertyValueFactory<>("kay�t_tarihi"));

            st�_�fr_view.setItems(�of�rList);
        } catch (SQLException e) {
            showAlert("Veritaban� Hatas�", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    public void �r�nleriGetir(TableView<Urunler> tablo) {
        sql = "SELECT * FROM �r�nler";
        ObservableList<Urunler> �r�nList = FXCollections.observableArrayList();
        try {
            sorguifadesi = baglanti.prepareStatement(sql);
            ResultSet getirilen = sorguifadesi.executeQuery();
            while (getirilen.next()) {
                �r�nList.add(new Urunler(
                    getirilen.getInt("�r�nID"),
                    getirilen.getString("�r�n_ad�"),
                    getirilen.getBigDecimal("kiloba��_fiyat"),
                    getirilen.getBigDecimal("toplam_kg"),
                    getirilen.getString("�r�n_durumu"),
                    getirilen.getTimestamp("kay�t_tarihi")
                ));
            }
            Col_�r�nID.setCellValueFactory(new PropertyValueFactory<>("�r�nID"));
            Col_�r�nAd.setCellValueFactory(new PropertyValueFactory<>("�r�n_ad�"));
            Col_kgfiyat.setCellValueFactory(new PropertyValueFactory<>("kiloba��_fiyat"));
            Col_tplmkg.setCellValueFactory(new PropertyValueFactory<>("toplam_kg"));
            Col_�r�nDurum.setCellValueFactory(new PropertyValueFactory<>("�r�n_durumu"));
            Col_�r�ntarih.setCellValueFactory(new PropertyValueFactory<>("kay�t_tarihi"));

            tablo.setItems(�r�nList);
        } catch (SQLException e) {
            showAlert("�r�nleri Getirme K�sm�nda Veritaban� Hatas�", "Veritaban� i�lemi s�ras�nda bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    public void �r�nleriListele() {
        sql = "SELECT * FROM �r�nler";
        ObservableList<Urunler> �r�nList = FXCollections.observableArrayList();
        try {
            sorguifadesi = baglanti.prepareStatement(sql);
            ResultSet getirilen = sorguifadesi.executeQuery();
            while (getirilen.next()) {
                �r�nList.add(new Urunler(
                    getirilen.getInt("�r�nID"),
                    getirilen.getString("�r�n_ad�"),
                    getirilen.getBigDecimal("kiloba��_fiyat"),
                    getirilen.getBigDecimal("toplam_kg"),
                    getirilen.getString("�r�n_durumu"),
                    getirilen.getTimestamp("kay�t_tarihi")
                ));
            }
            Col_st��rn_ID.setCellValueFactory(new PropertyValueFactory<>("�r�nID"));
            Col_st��rn_ad.setCellValueFactory(new PropertyValueFactory<>("�r�n_ad�"));
            Col_st��rn_kgfiyat.setCellValueFactory(new PropertyValueFactory<>("kiloba��_fiyat"));
            Col_st��rn_mevcut.setCellValueFactory(new PropertyValueFactory<>("toplam_kg"));
            Col_st��rn_durum.setCellValueFactory(new PropertyValueFactory<>("�r�n_durumu"));
            Col_st��rn_tarih.setCellValueFactory(new PropertyValueFactory<>("kay�t_tarihi"));
            
            st�_�r�nler_view.setItems(�r�nList);
        } catch (SQLException e) {
            showAlert("�r�nleri Listele K�sm�nda Veritaban� Hatas�", "Veritaban� i�lemi s�ras�nda bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    public void �of�rleriGetir(TableView<Soforler> tablo) {
        sql = "SELECT * FROM �of�rler";
        ObservableList<Soforler> �of�rList = FXCollections.observableArrayList();
        try {
            baglanti = Veritaban�Util.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            ResultSet getirilen = sorguifadesi.executeQuery();
            while (getirilen.next()) {
                �of�rList.add(new Soforler(
                    getirilen.getInt("�of�rID"),
                    getirilen.getString("ad"),
                    getirilen.getString("soyad"),
                    getirilen.getString("tel_no"),
                    getirilen.getTimestamp("kay�t_tarihi"),
                    getirilen.getString("durumu")
                ));
            }
            Col_�fr_ID.setCellValueFactory(new PropertyValueFactory<>("�of�rID"));
            Col_�fr_ad.setCellValueFactory(new PropertyValueFactory<>("ad"));
            Col_�fr_soyad.setCellValueFactory(new PropertyValueFactory<>("soyad"));
            Col_�fr_telno.setCellValueFactory(new PropertyValueFactory<>("tel_no"));
            Col_�fr_kyttarih.setCellValueFactory(new PropertyValueFactory<>("kay�t_tarihi"));
            Col_�fr_durumu.setCellValueFactory(new PropertyValueFactory<>("durumu"));

            tablo.setItems(�of�rList);
        } catch (SQLException e) {
            showAlert("�of�rleri Getirme K�sm�nda Veritaban� Hatas�", "Veritaban� i�lemi s�ras�nda bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
        } finally {
            try {
                if (getirilen != null) getirilen.close();
                if (sorguifadesi != null) sorguifadesi.close();
                if (baglanti != null) baglanti.close();
            } catch (SQLException e) {
                showAlert("Kaynaklar� Kapama Hatas�", "Kaynaklar� kapat�rken bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        }
    }

    public void �of�rleriListele() {
        String sql = "SELECT * FROM �of�rler";
        ObservableList<Soforler> soforList = FXCollections.observableArrayList();
        try {
            baglanti = Veritaban�Util.Baglan(); 
            sorguifadesi = baglanti.prepareStatement(sql);
            ResultSet getirilen = sorguifadesi.executeQuery();
            while (getirilen.next()) {
                soforList.add(new Soforler(
                    getirilen.getInt("�of�rID"),
                    getirilen.getString("ad"),
                    getirilen.getString("soyad"),
                    getirilen.getString("tel_no"),
                    getirilen.getTimestamp("kay�t_tarihi"),
                    getirilen.getString("durumu")
                ));
            }
            Col_k�k�fr_ID.setCellValueFactory(new PropertyValueFactory<>("�of�rID"));
            Col_k�k�fr_Ad�.setCellValueFactory(new PropertyValueFactory<>("ad"));
            Col_k�k�fr_Soyad�.setCellValueFactory(new PropertyValueFactory<>("soyad"));
            Col_k�k�fr_Tarih.setCellValueFactory(new PropertyValueFactory<>("kay�t_tarihi"));
            Col_k�k�fr_Durum.setCellValueFactory(new PropertyValueFactory<>("durumu"));

            k�k_�fr_view.setItems(soforList);
        } catch (SQLException e) {
            showAlert("�of�rleri Listele K�sm�nda Veritaban� Hatas�", "Veritaban� i�lemi s�ras�nda bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
        } finally {
            try {
                if (sorguifadesi != null) sorguifadesi.close();
                if (baglanti != null) baglanti.close();
            } catch (SQLException e) {
                showAlert("Kaynaklar� Kapama Hatas�", "Kaynaklar� kapat�rken bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        }
    }
    
    private void satislariGetir(TableView<Satislar> tablo) {
    	 String sql = "SELECT s.*, u.�r�n_ad� AS �r�n_ad� FROM satislar s JOIN �r�nler u ON s.�r�nID = u.�r�nID";
    	    ObservableList<Satislar> satisList = FXCollections.observableArrayList();
    	    try {
    	        baglanti = Veritaban�Util.Baglan();
    	        sorguifadesi = baglanti.prepareStatement(sql);
    	        ResultSet getirilen = sorguifadesi.executeQuery();
    	        while (getirilen.next()) {
    	            Urunler urun = new Urunler(getirilen.getInt("�r�nID"), getirilen.getString("�r�n_ad�"), null, null, null, null);
    	            Musteriler musteri = new Musteriler(getirilen.getInt("m��teriID"), null, null, null, null, null);
    	            Ara�lar ara� = new Ara�lar(getirilen.getInt("ara�ID"), null, null, null, null, null, null, null, null, null);
    	            Soforler sofor = new Soforler(getirilen.getInt("�of�rID"), null, null, null, null, null);

    	            satisList.add(new Satislar(
    	                getirilen.getInt("sat��ID"),
    	                urun,
    	                musteri,
    	                ara�,
    	                sofor,
    	                getirilen.getBigDecimal("miktar"),
    	                getirilen.getBigDecimal("toplam_fiyat"),
    	                getirilen.getTimestamp("sat��_tarihi"),
    	                getirilen.getString("�deme_durumu")
    	            ));
    	        }
    	        Col_st�_ID.setCellValueFactory(new PropertyValueFactory<>("sat��ID"));
    	        Col_st�_ad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get�r�nID().get�r�n_ad�()));
    	        Col_st�_m�tID.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getM��teriID().getM��teriID() + ""));
    	        Col_st�_miktar.setCellValueFactory(new PropertyValueFactory<>("miktar"));
    	        Col_st�_topkazan�.setCellValueFactory(new PropertyValueFactory<>("toplam_fiyat"));
    	        Col_st�_tarih.setCellValueFactory(new PropertyValueFactory<>("sat��_tarihi"));
    	        Col_st�_�dnmdurum.setCellValueFactory(new PropertyValueFactory<>("�deme_durumu"));

    	        tablo.setItems(satisList);
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	        showAlert("Sat��lar� Getirme K�sm�nda Veritaban� Hatas�", "Veritaban� i�lemi s�ras�nda bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
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
        String sql = "SELECT s.*, u.�r�n_ad� AS �r�n_ad�, m.ad AS m��teri_ad, m.soyad AS m��teri_soyad " +
                     "FROM satislar s " +
                     "JOIN �r�nler u ON s.�r�nID = u.�r�nID " +
                     "JOIN m��teriler m ON s.m��teriID = m.m��teriID " +
                     "WHERE s.�deme_durumu = '�denmedi'";
        ObservableList<Satislar> satisList = FXCollections.observableArrayList();
        try {
            baglanti = Veritaban�Util.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();
            while (getirilen.next()) {
                Urunler urun = new Urunler(getirilen.getInt("�r�nID"), getirilen.getString("�r�n_ad�"), null, null, null, null);
                Musteriler musteri = new Musteriler(getirilen.getInt("m��teriID"), getirilen.getString("m��teri_ad"), getirilen.getString("m��teri_soyad"), null, null, null);
                Ara�lar ara� = new Ara�lar(getirilen.getInt("ara�ID"), null, null, null, null, null, null, null, null, null);
                Soforler sofor = new Soforler(getirilen.getInt("�of�rID"), null, null, null, null, null);

                satisList.add(new Satislar(
                    getirilen.getInt("sat��ID"),
                    urun,
                    musteri,
                    ara�,
                    sofor,
                    getirilen.getBigDecimal("miktar"),
                    getirilen.getBigDecimal("toplam_fiyat"),
                    getirilen.getTimestamp("sat��_tarihi"),
                    getirilen.getString("�deme_durumu")
                ));
            }
            Col_�dnmyn_ID.setCellValueFactory(new PropertyValueFactory<>("sat��ID"));
            Col_�dnmyn_m�trad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getM��teriID().getAd()));
            Col_�dnmyn_m�trsoyad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getM��teriID().getSoyad()));
            Col_�dnmyn_�r�nad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get�r�nID().get�r�n_ad�()));
            Col_�dnmyn_�r�nmik.setCellValueFactory(new PropertyValueFactory<>("miktar"));
            Col_�dnmyn_�r�nfyt.setCellValueFactory(new PropertyValueFactory<>("toplam_fiyat"));
            Col_�dnmyn_durum.setCellValueFactory(new PropertyValueFactory<>("�deme_durumu"));

            �dnmemi�_st�_view.setItems(satisList);
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Sat��lar� Getirme K�sm�nda Veritaban� Hatas�", "Veritaban� i�lemi s�ras�nda bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
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
    	//Fonksiyonlar�n �a�r� Noktas�
    	Ara�lar�Getir(t�mara�lar_view);
    	Ara�lar�Listele();
    	M��terileriGetir(m��teriler_view);
    	musteriListele();
    	�r�nleriGetir(�r�nler_view);
    	�r�nleriListele();
    	�of�rleriGetir(�fr_view);
    	�of�rleriListele();
    	satislariGetir(st�_Sat��lar_view); 
    	Sat�slarAr�Listele();
    	Sat�slar�frlrListele();
    	odemeDurumuListesi();
    	
    	//Home ekran�
    	  gunlukSatis();
          d�nk�Satis();
          son7gunSatis();
          buAySatis();
          toplamSatis();
          toplamSofor();
          toplamMusteri();
          toplamArac();
          son10Satis();
          son10Odeme();
         
    	//benim fake labellerim
    	s�ln_�fr_fakelbl.textProperty().bind(s�ln_�fr_lbl.textProperty());
    	
    	//Verim i�in Manuel eventler
    	m��teriler_view.setOnMouseClicked((MouseEvent event) -> {
            Musteriler selectedMusteri = m��teriler_view.getSelectionModel().getSelectedItem();
            if (selectedMusteri != null) {
                s�lnm�tr_lbl.setText(String.valueOf(selectedMusteri.getM��teriID()));
                // �ste�e ba�l� ek i�lemler burada yap�labilir.
            }
        });
    	t�mara�lar_view.setOnMouseClicked((MouseEvent event) -> {
            Ara�lar selectedAra� = t�mara�lar_view.getSelectionModel().getSelectedItem();
            if (selectedAra� != null) {
            	ar�ekle_plaka_txt.setText(selectedAra�.getPlaka());
                ar�ekle_marka_txt.setText(selectedAra�.getMarka());
                ar�ekle_y�l_txt.setText(selectedAra�.getY�l());
                ar�ekle_ara�tipi_txt.setText(selectedAra�.getAra�_tipi());
                ar�ekle_durum_txt.setText(selectedAra�.getDurum());
                ar�ekle_km_txt.setText(selectedAra�.getKm());
                ar�ekle_bak�m_txt.setText(selectedAra�.getBak�m�());
                ar�ekle_yak�tt�r�_txt.setText(selectedAra�.getYak�t_t�r�());
                s�ln_ar�ID_lbl.setText(String.valueOf(selectedAra�.getAra�ID()));
                g�ncelleGrafik(selectedAra�.getAra�ID());
            }
        });
    	k�k_�fr_view.setOnMouseClicked((MouseEvent event) -> {
            Soforler selectedSofor = k�k_�fr_view.getSelectionModel().getSelectedItem();
            if (selectedSofor != null) {
                s�ln_�frID_lbl.setText(String.valueOf(selectedSofor.get�of�rID()));
            }
        });
    	 �r�nler_view.setOnMouseClicked(event -> {
             Urunler selectedUrun = �r�nler_view.getSelectionModel().getSelectedItem();
             if (selectedUrun != null) {
                 �rnsec_lbl.setText(String.valueOf(selectedUrun.get�r�nID()));
                 updt_�rnad_txt.setText(selectedUrun.get�r�n_ad�());
                 updt_kgfiyat_txt.setText(String.valueOf(selectedUrun.getKiloba��_fiyat()));
                 updt_tplmkg_txt.setText(String.valueOf(selectedUrun.getToplam_kg()));
                 updt_�rndrm_txt.setText(selectedUrun.get�r�n_durumu());
             }
         });
    	 �fr_view.setOnMouseClicked((MouseEvent event) -> {
    	        if (event.getClickCount() > 0) {
    	            Soforler se�ilen�of�r = �fr_view.getSelectionModel().getSelectedItem();
    	            if (se�ilen�of�r != null) {
    	                s�ln_�fr_lbl.setText(String.valueOf(se�ilen�of�r.get�of�rID()));
    	            }
    	        }
    	    });
    	 �fr_ar�_view.setOnMouseClicked((MouseEvent event) -> {
    	        if (event.getClickCount() > 0) {
    	            Ara�lar se�ilenAra� = �fr_ar�_view.getSelectionModel().getSelectedItem();
    	            if (se�ilenAra� != null) {
    	            	s�ln_�frar�ID_lbl.setText(String.valueOf(se�ilenAra�.getAra�ID()));
    	            } 
    	        }
    	    });
    	 �dnmemi�_st�_view.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
             if (newValue != null) {
                 �dmedrmu_lbl.setText(String.valueOf(newValue.getSat��ID()));
             }
         });
    	 st�_m��teriler_view.setOnMouseClicked(this::m��teriSe�);
         st�_�r�nler_view.setOnMouseClicked(this::�r�nSe�);
         st�_ar�_view.setOnMouseClicked(this::sat�slararacSe�);
         st�_�fr_view.setOnMouseClicked(this::sat�slar�of�rSe�);
    	
    	 // ComboBox'lara De�erler Atama.
    	 ara�_durum_cmbx.setItems(FXCollections.observableArrayList("aktif", "inaktif"));
    	 ara�_bak�m_cmbx.setItems(FXCollections.observableArrayList("var", "yok"));
    	 
    }
    
    private void gunlukSatis() {
        String sql = "SELECT SUM(toplam_fiyat) AS gunluk_satis FROM satislar WHERE DATE(sat��_tarihi) = CURDATE()";
        try {
            baglanti = Veritaban�Util.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();
            if (getirilen.next()) {
                bgn_st�_lbl.setText(getirilen.getBigDecimal("gunluk_satis").toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (getirilen != null) getirilen.close(); if (sorguifadesi != null) sorguifadesi.close(); if (baglanti != null) baglanti.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
    
    private void d�nk�Satis() {
        checkAndReconnect();
        String sql = "SELECT SUM(toplam_fiyat) AS toplam FROM satislar WHERE DATE(sat��_tarihi) = CURDATE() - INTERVAL 1 DAY";
        try {
            baglanti = Veritaban�Util.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();
            if (getirilen.next()) {
                BigDecimal toplam = getirilen.getBigDecimal("toplam");
                if (toplam == null) {
                    toplam = BigDecimal.ZERO;
                }
                d�n_st�_lbl.setText(toplam.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Veritaban� Hatas�", "D�nk� sat��lar� getirirken bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
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
        String sql = "SELECT SUM(toplam_fiyat) AS son7gun_satis FROM satislar WHERE DATE(sat��_tarihi) >= CURDATE() - INTERVAL 7 DAY";
        try {
            baglanti = Veritaban�Util.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();
            if (getirilen.next()) {
                sn7_st�_lbl.setText(getirilen.getBigDecimal("son7gun_satis").toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (getirilen != null) getirilen.close(); if (sorguifadesi != null) sorguifadesi.close(); if (baglanti != null) baglanti.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
    
    private void buAySatis() {
        String sql = "SELECT SUM(toplam_fiyat) AS buay_satis FROM satislar WHERE MONTH(sat��_tarihi) = MONTH(CURDATE()) AND YEAR(sat��_tarihi) = YEAR(CURDATE())";
        try {
            baglanti = Veritaban�Util.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();
            if (getirilen.next()) {
                buay_st�_lbl.setText(getirilen.getBigDecimal("buay_satis").toString());
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
            baglanti = Veritaban�Util.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();
            if (getirilen.next()) {
                tplm_st�_lbl.setText(getirilen.getBigDecimal("toplam_satis").toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (getirilen != null) getirilen.close(); if (sorguifadesi != null) sorguifadesi.close(); if (baglanti != null) baglanti.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
    
    private void toplamSofor() {
        String sql = "SELECT COUNT(*) AS toplam_sofor FROM �of�rler";
        try {
            baglanti = Veritaban�Util.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();
            if (getirilen.next()) {
                tplm_�of�r_lbl.setText(getirilen.getString("toplam_sofor"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (getirilen != null) getirilen.close(); if (sorguifadesi != null) sorguifadesi.close(); if (baglanti != null) baglanti.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
    
    private void toplamMusteri() {
        String sql = "SELECT COUNT(*) AS toplam_musteri FROM m��teriler";
        try {
            baglanti = Veritaban�Util.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();
            if (getirilen.next()) {
                tplm_m�tr_lbl.setText(getirilen.getString("toplam_musteri"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (getirilen != null) getirilen.close(); if (sorguifadesi != null) sorguifadesi.close(); if (baglanti != null) baglanti.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
    
    private void toplamArac() {
        String sql = "SELECT COUNT(*) AS toplam_arac FROM ara�lar";
        try {
            baglanti = Veritaban�Util.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();
            if (getirilen.next()) {
                tplm_ara�_lbl.setText(getirilen.getString("toplam_arac"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (getirilen != null) getirilen.close(); if (sorguifadesi != null) sorguifadesi.close(); if (baglanti != null) baglanti.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
    
    private void son10Satis() {
        String sql = "SELECT s.*, u.�r�n_ad�, m.ad AS m��teri_ad FROM satislar s JOIN �r�nler u ON s.�r�nID = u.�r�nID JOIN m��teriler m ON s.m��teriID = m.m��teriID ORDER BY s.sat��_tarihi DESC LIMIT 10";
        ObservableList<Satislar> satisList = FXCollections.observableArrayList();
        try {
            baglanti = Veritaban�Util.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();
            while (getirilen.next()) {
                Urunler urun = new Urunler(getirilen.getInt("�r�nID"), getirilen.getString("�r�n_ad�"), null, null, null, null);
                Musteriler musteri = new Musteriler(getirilen.getInt("m��teriID"), getirilen.getString("m��teri_ad"), null, null, null, null);
                Ara�lar arac = new Ara�lar(getirilen.getInt("ara�ID"), null, null, null, null, null, null, null, null, null);
                Soforler sofor = new Soforler(getirilen.getInt("�of�rID"), null, null, null, null, null);

                satisList.add(new Satislar(
                    getirilen.getInt("sat��ID"),
                    urun,
                    musteri,
                    arac,
                    sofor,
                    getirilen.getBigDecimal("miktar"),
                    getirilen.getBigDecimal("toplam_fiyat"),
                    getirilen.getTimestamp("sat��_tarihi"),
                    getirilen.getString("�deme_durumu")
                ));
            }
            Col_son10sat��_ID.setCellValueFactory(new PropertyValueFactory<>("sat��ID"));
            Col_son10sat��_tarih.setCellValueFactory(new PropertyValueFactory<>("sat��_tarihi"));
            Col_son10sat��_m��teri.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getM��teriID().getAd()));
            Col_son10sat��_�r�n.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get�r�nID().get�r�n_ad�()));
            Col_son10sat��_miktar.setCellValueFactory(new PropertyValueFactory<>("miktar"));
            Col_son10sat��_tutar.setCellValueFactory(new PropertyValueFactory<>("toplam_fiyat"));

            Son10Sat��_tblview.setItems(satisList);
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Veritaban� Hatas�", e.getMessage(), Alert.AlertType.ERROR);
        } finally {
            try { if (getirilen != null) getirilen.close(); if (sorguifadesi != null) sorguifadesi.close(); if (baglanti != null) baglanti.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
    
    private void son10Odeme() {
        String sql = "SELECT o.odeme_id, o.�deme_tarihi, m.ad AS musteri_ad, m.soyad AS musteri_soyad, u.�r�n_ad�, s.toplam_fiyat, s.sat��ID, u.�r�nID, m.m��teriID " +
                	 "FROM odemeler o " +
                	 "JOIN satislar s ON o.sat��_id = s.sat��ID " +
                	 "JOIN �r�nler u ON s.�r�nID = u.�r�nID " +
                   	 "JOIN m��teriler m ON s.m��teriID = m.m��teriID " +
                	 "ORDER BY o.�deme_tarihi DESC " +
                	 "LIMIT 10";
        ObservableList<Odeme> odemeList = FXCollections.observableArrayList();
        try {
            baglanti = Veritaban�Util.Baglan();
            sorguifadesi = baglanti.prepareStatement(sql);
            getirilen = sorguifadesi.executeQuery();
            while (getirilen.next()) {
                Satislar satis = new Satislar(getirilen.getInt("sat��ID"), null, null, null, null, null, getirilen.getBigDecimal("toplam_fiyat"), null, null);
                Urunler urun = new Urunler(getirilen.getInt("�r�nID"), getirilen.getString("�r�n_ad�"), null, null, null, null);
                Musteriler musteri = new Musteriler(getirilen.getInt("m��teriID"), getirilen.getString("musteri_ad"), getirilen.getString("musteri_soyad"), null, null, null);

                odemeList.add(new Odeme(
                    getirilen.getInt("odeme_id"),
                    getirilen.getTimestamp("�deme_tarihi"),
                    satis,
                    urun,
                    musteri
                ));
            }

            Col_son10�deme_tarih.setCellValueFactory(new PropertyValueFactory<>("�deme_tarihi"));
            Col_son10�deme_m��teriad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getM��teri_id().getAd()));
            Col_son10�deme_m��terisoyad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getM��teri_id().getSoyad()));
            Col_son10�deme_�r�nad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get�r�n_id().get�r�n_ad�()));
            Col_son10�deme_tutar.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSat��_id().getToplam_fiyat().toString()));

            Son10�deme_tblview.setItems(odemeList);
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Veritaban� Hatas�", "�demeleri listelerken bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
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


   
    //GRAF�K VE SE� EVENTLER�
    private void g�ncelleGrafik(int ara�ID) {
        String sql = "SELECT y�l, km FROM ara�lar WHERE ara�ID = ?";
        try {
            baglanti = Veritaban�Util.Baglan();
            PreparedStatement sorguifadesi = baglanti.prepareStatement(sql);
            sorguifadesi.setInt(1, ara�ID);
            ResultSet getirilen = sorguifadesi.executeQuery();

            NumberAxis xAxis = new NumberAxis();
            NumberAxis yAxis = new NumberAxis();
            xAxis.setLabel("Y�l");
            yAxis.setLabel("Kilometre");

            xAxis.setAutoRanging(false);
            yAxis.setAutoRanging(false);

            xAxis.setLowerBound(0);
            yAxis.setLowerBound(0);

            ar�kul_grafik.getXAxis().setAutoRanging(true);
            ar�kul_grafik.getYAxis().setAutoRanging(true);
            
            ar�kul_grafik.setTitle("Ara� Kullan�m�");
            ar�kul_grafik.getXAxis().setLabel("Y�l");
            ar�kul_grafik.getYAxis().setLabel("Kilometre");

            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName("Ara� ID: " + ara�ID);

            series.getData().add(new XYChart.Data<>("0", 0));

            while (getirilen.next()) {
                String y�l = getirilen.getString("y�l");
                int km = getirilen.getInt("km");
                series.getData().add(new XYChart.Data<>(y�l, km));
            }

            ar�kul_grafik.getData().clear();
            ar�kul_grafik.getData().add(series);

            getirilen.close();
            sorguifadesi.close();
            baglanti.close();
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Veritaban� Hatas�", "Veritaban� i�lemi s�ras�nda bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    private void m��teriSe�(MouseEvent event) {
        Musteriler se�ilenM��teri = st�_m��teriler_view.getSelectionModel().getSelectedItem();
        if (se�ilenM��teri != null) {
            st�_m�trID_lbl.setText(String.valueOf(se�ilenM��teri.getM��teriID()));
        }
    }
    
    @FXML
    private void �r�nSe�(MouseEvent event) {
        Urunler se�ilen�r�n = st�_�r�nler_view.getSelectionModel().getSelectedItem();
        if (se�ilen�r�n != null) {
            st�_�rnID_lbl.setText(String.valueOf(se�ilen�r�n.get�r�nID()));
        }
    }
    
    private void sat�slararacSe�(MouseEvent event) {
        Ara�lar selectedAra� = st�_ar�_view.getSelectionModel().getSelectedItem();
        if (selectedAra� != null) {
            st�_ar�ID_lbl.setText(String.valueOf(selectedAra�.getAra�ID()));
        }
    }
    
    private void sat�slar�of�rSe�(MouseEvent event) {
        Soforler selectedSofor = st�_�fr_view.getSelectionModel().getSelectedItem();
        if (selectedSofor != null) {
            st�_�frID_lbl.setText(String.valueOf(selectedSofor.get�of�rID()));
        }
    }

	public void setUserInfo(String username) {
		// TODO Auto-generated method stub
		
	}

}
