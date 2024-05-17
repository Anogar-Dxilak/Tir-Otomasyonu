package application;


import java.io.IOException;
import java.net.URL;
import java.sql.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ResourceBundle;
import com.MySQL.util.VeritabanýUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class Kayit_FormuController {
	
	public Kayit_FormuController() {
		baglanti=VeritabanýUtil.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TableView<Kullanýcýlar> user_table;

    @FXML
    private TableColumn<Kullanýcýlar, String> AdCol;

    @FXML
    private TableColumn<Kullanýcýlar, Integer> IDCol;

    @FXML
    private TableColumn<Kullanýcýlar, String> RolCol;

    @FXML
    private TableColumn<Kullanýcýlar, String> SoyadCol;

    @FXML
    private TableColumn<Kullanýcýlar, String> UsrnmCol;
    
    @FXML
    private TableColumn<Kullanýcýlar, Timestamp> kayýttarihiCol;

    @FXML
    private RadioButton admin_radio;

    @FXML
    private Button down_btn;
    
    @FXML
    private Hyperlink anasyf_dön_link;

    @FXML
    private TextField eposta_txt;

    @FXML
    private Label id_lbl;

    @FXML
    private Button iptl_btn;

    @FXML
    private Button kick_btn;

    @FXML
    private Button kyt_btn;

    @FXML
    private TextField name_txt;

    @FXML
    private TextField pswd_txt;

    @FXML
    private Button ref_btn;

    @FXML
    private ToggleGroup rol_seçimi;

    @FXML
    private TextField soyad_txt;

    @FXML
    private TextField tel_txt;

    @FXML
    private Button tmzl_btn;

    @FXML
    private Button up_btn;

    @FXML
    private RadioButton usesr_radio;

    @FXML
    private TextField usrname_txt;
	
    Connection baglanti=null;
    PreparedStatement sorguifadesi=null;
    ResultSet getirilen=null;
    String sql;
    
    @FXML
    void anasyf_dön_Click(ActionEvent event) {
    	try {
            // Form3.fxml dosyasýný yükle
            Parent form3Parent = FXMLLoader.load(getClass().getResource("Form3.fxml"));
            Scene form3Scene = new Scene(form3Parent);

            // Mevcut sahneyi al
            Stage window = (Stage) anasyf_dön_link.getScene().getWindow();

            // Yeni sahneyi ayarla ve göster
            window.setScene(form3Scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Hata", "Anasayfaya dönüþte bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    	
    
    @FXML
    void clear_Click(ActionEvent event) {
    	id_lbl.setText("Seçilen");
    }

    @FXML
    void down_Click(ActionEvent event) {
    	 String userIdText = id_lbl.getText();
    	    if (userIdText == null || userIdText.trim().isEmpty()) {
    	    	showAlert("Hata", "Lütfen tablodan birini seçin.", Alert.AlertType.INFORMATION);
    	        return;
    	    }

    	    try {
    	        int userId = Integer.parseInt(userIdText.trim());

    	        String sql = "UPDATE kullanýcýlar SET rolü = 'kullanýcý' WHERE kullanýcýID = ?";

    	        try (PreparedStatement pstmt = baglanti.prepareStatement(sql)) {
    	            pstmt.setInt(1, userId); 
    	            int affectedRows = pstmt.executeUpdate(); 

    	            if (affectedRows > 0) {
    	                System.out.println("Kullanýcýnýn rolü baþarýyla düþürüldü.");
    	                clear_Click(event);
    	            } else {
    	                System.out.println("Rol düþürme iþlemi baþarýsýz oldu. Lütfen tekrar deneyin.");
    	            }
    	        }
    	    } catch (NumberFormatException e) {
    	    	showAlert("Hata", "Lütfen tablodan birini seçin.", Alert.AlertType.INFORMATION);
    	    } catch (SQLException e) {
    	    	showAlert("Veritabaný Hatasý", "Veritabaný iþlemi sýrasýnda bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
    	    }
    	    KullanýcýlarýGetir(user_table);
    }
        

    @FXML
    void ipt_Click(ActionEvent event) {
    	    usrname_txt.setText("");
    	    pswd_txt.setText("");
    	    eposta_txt.setText("");
    	    name_txt.setText("");
    	    soyad_txt.setText("");
    	    tel_txt.setText("");
    }

    @FXML
    void kick_Click(ActionEvent event) {
    	 String userIdText = id_lbl.getText();
    	    if (userIdText == null || userIdText.trim().isEmpty()) {
    	    	showAlert("", "Lütfen bir kullanýcý seçiniz.", Alert.AlertType.INFORMATION);
    	        return;
    	    }

    	    try {
    	        int userId = Integer.parseInt(userIdText.trim());

    	        String sql = "DELETE FROM kullanýcýlar WHERE kullanýcýID = ?";

    	        try (PreparedStatement pstmt = baglanti.prepareStatement(sql)) {
    	            pstmt.setInt(1, userId);
    	            int affectedRows = pstmt.executeUpdate();

    	            if (affectedRows > 0) {
    	                System.out.println("Kullanýcý baþarýyla veritabanýndan silindi.");
    	                clear_Click(event);
    	            } else {
    	                showAlert("Hata","Kullanýcý silme iþlemi baþarýsýz oldu. Lütfen tekrar deneyin.", Alert.AlertType.ERROR);
    	            }
    	        }
    	    } catch (NumberFormatException e) {
    	    	 showAlert("Hata", "Lütfen tablodan birini seçin.", Alert.AlertType.INFORMATION);
    	    } catch (SQLException e) {
    	    	 showAlert("Veritabaný Hatasý", "Veritabaný iþlemi sýrasýnda bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
    	    }
    	    KullanýcýlarýGetir(user_table);
    }

    @FXML
    void kyt_Click(ActionEvent event) {
        if (usrname_txt.getText().isEmpty() || pswd_txt.getText().isEmpty() || eposta_txt.getText().isEmpty() || 
                name_txt.getText().isEmpty() || soyad_txt.getText().isEmpty() || tel_txt.getText().isEmpty()) {
                showAlert("Hata", "Lütfen tüm alanlarý doldurun.", Alert.AlertType.INFORMATION);
                return;
            }

            String sql = "INSERT INTO kullanýcýlar (kullanýcý_adý, þifre, ad, soyad, eposta, tel_no, rolü) VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pstmt = baglanti.prepareStatement(sql)) {
                pstmt.setString(1, usrname_txt.getText());
                pstmt.setString(2, pswd_txt.getText());
                pstmt.setString(3, name_txt.getText());
                pstmt.setString(4, soyad_txt.getText());
                pstmt.setString(5, eposta_txt.getText());
                pstmt.setString(6, tel_txt.getText());
                pstmt.setString(7, admin_radio.isSelected() ? "admin" : "kullanýcý"); // Rol bilgisini RadioButton'dan al

                int affectedRows = pstmt.executeUpdate();

                if (affectedRows > 0) {
                    showAlert("Baþarýlý", "Kullanýcý baþarýyla eklendi.", Alert.AlertType.INFORMATION);
                } else {
                    showAlert("Hata", "Kullanýcý eklenemedi. Lütfen tekrar deneyin.", Alert.AlertType.ERROR);
                }
            } catch (SQLException e) {
                showAlert("Veritabaný Hatasý", "Veritabaný iþlemi sýrasýnda bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
            }
    }

    @FXML
    void reflesh_Click(ActionEvent event) {
    	KullanýcýlarýGetir(user_table);
    }

    @FXML
    void up_Click(ActionEvent event) {
    	String userIdText = id_lbl.getText();
        if (userIdText == null || userIdText.trim().isEmpty()) {
            System.out.println("Lütfen bir kullanýcý seçiniz.");
            return;
        }

        try {
            int userId = Integer.parseInt(userIdText.trim());

            
            String sql = "UPDATE kullanýcýlar SET rolü = 'admin' WHERE kullanýcýID = ?";

            try (PreparedStatement pstmt = baglanti.prepareStatement(sql)) {
                pstmt.setInt(1, userId); 
                int affectedRows = pstmt.executeUpdate();

                if (affectedRows > 0) {
                    System.out.println("Kullanýcýnýn rolü baþarýyla yükseltildi.");
                    clear_Click(event);
                } else {
                    System.out.println("Rol yükseltme iþlemi baþarýsýz oldu. Lütfen tekrar deneyin.");
                }
            }
        } catch (NumberFormatException e) {
        	showAlert("Hata", "Lütfen tablodan birini seçin.", Alert.AlertType.INFORMATION);
        } catch (SQLException e) {
        	showAlert("Veritabaný Hatasý", "Veritabaný iþlemi sýrasýnda bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
        KullanýcýlarýGetir(user_table);
    }
    
    @FXML
    void Selecteduser(MouseEvent event) {
        Kullanýcýlar selectedUser = user_table.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            id_lbl.setText(String.valueOf(selectedUser.getKullanýcýID()));
        }
    }
    
    private void showAlert(String title, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    public void KullanýcýlarýGetir(TableView<Kullanýcýlar> tablo) {
    	sql="select * from kullanýcýlar";
    	ObservableList<Kullanýcýlar> usrlist=FXCollections.observableArrayList();
    	try {
    		sorguifadesi=baglanti.prepareStatement(sql);
    		ResultSet getirilen=sorguifadesi.executeQuery();
    		while(getirilen.next()) {
    			usrlist.add(new Kullanýcýlar(getirilen.getInt("kullanýcýID"), getirilen.getString("kullanýcý_adý"), getirilen.getString("þifre"), getirilen.getString("ad"), getirilen.getString("soyad"), getirilen.getString("eposta"), getirilen.getString("tel_no"), getirilen.getString("rolü"), getirilen.getTimestamp("kayýt_tarihi")));
    		}
    		
    		IDCol.setCellValueFactory(new PropertyValueFactory<>("kullanýcýID"));
    		UsrnmCol.setCellValueFactory(new PropertyValueFactory<>("kullanýcý_adý"));
    		AdCol.setCellValueFactory(new PropertyValueFactory<>("ad"));
    		SoyadCol.setCellValueFactory(new PropertyValueFactory<>("soyad"));
    		RolCol.setCellValueFactory(new PropertyValueFactory<>("rolü"));
    		kayýttarihiCol.setCellValueFactory(new PropertyValueFactory<>("kayýt_tarihi"));
    		user_table.setItems(usrlist);
    	} catch (Exception e) {
    		System.out.println(e.getMessage().toString());
    	}
    	
    }
    
    @FXML
    void initialize() {
    	KullanýcýlarýGetir(user_table);
    }

}
