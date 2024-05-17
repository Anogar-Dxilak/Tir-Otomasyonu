package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;
import com.MySQL.util.VeritabanýUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Form1Controller {
	
	public Form1Controller() {
		baglanti=VeritabanýUtil.Baglan();
	}
	
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
    private Hyperlink adm_link;

    @FXML
    private Button lgn_btn;

    @FXML
    private PasswordField pswd_txt;

    @FXML
    private Label usr_lbl;

    @FXML
    private TextField usr_txt;

    Connection baglanti = null;
    PreparedStatement sorguifadesi = null;
    ResultSet getirilen = null;
    String sql;
    
    @FXML
    void AdminFormGec(ActionEvent event) {
    	 try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Form2.fxml"));
             Parent root = loader.load();

             Stage stage = new Stage();
             stage.setTitle("Admin Giriþ Panel");
             stage.setScene(new Scene(root));
             stage.show();

             Stage currentStage = (Stage) adm_link.getScene().getWindow();
             currentStage.close();
         } catch (Exception e) {
             e.printStackTrace();
             showAlert("Hata", "Admin Paneline geçiþte bir hata oluþtu: " + e.getMessage(), Alert.AlertType.ERROR);
         }
    }

    @FXML
    void lgn_btn_Click(ActionEvent event) {
    	checkAndReconnect();
    	String username = usr_txt.getText();
        String password = pswd_txt.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Hata", "Lütfen kullanýcý adý ve þifre girin.", Alert.AlertType.INFORMATION);
            return;
        }

        sql = "SELECT * FROM kullanýcýlar WHERE kullanýcý_adý = ? AND þifre = ?";

        try {
            sorguifadesi = baglanti.prepareStatement(sql);
            sorguifadesi.setString(1, username);
            sorguifadesi.setString(2, password);
            getirilen = sorguifadesi.executeQuery();

            if (getirilen.next()) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Form3.fxml"));
                Parent root = loader.load();

                Form3Controller Form3Controller = loader.getController();
                Form3Controller.setUserInfo(username);

                Stage stage = new Stage();
                stage.setTitle("HomeScreen");
                stage.setScene(new Scene(root));
                stage.show();

                Stage currentStage = (Stage) lgn_btn.getScene().getWindow();
                currentStage.close();
            } else {
                showAlert("Hata", "Geçersiz kullanýcý adý veya þifre.", Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Hata", "Veritabaný baðlantý hatasý: " + e.getMessage(), Alert.AlertType.ERROR);
        } finally {
            try {
                if (getirilen != null) getirilen.close();
                if (sorguifadesi != null) sorguifadesi.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private void showAlert(String title, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        
    }

}
