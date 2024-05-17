package application;

import java.net.URL;
import java.util.ResourceBundle;
import com.MySQL.util.Veritaban�Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.sql.*;

public class Form2Controller {
	
	public Form2Controller() {
		baglanti=Veritaban�Util.Baglan();
	}

    @FXML
    private Button lgn_btn;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Hyperlink link;

    @FXML
    private Label pswd_lbl;

    @FXML
    private PasswordField pswd_txt;

    @FXML
    private Label usr_lbl;

    @FXML
    private TextField usr_txt;
    
    Connection baglanti=null;
    PreparedStatement sorguifadesi=null;
    ResultSet getirilen=null;
    String sql;
    
    @FXML
    void backtologin_Click(ActionEvent event) {
    	   try {
               Parent root = FXMLLoader.load(getClass().getResource("Form1.fxml"));
               Stage stage = new Stage();
               stage.setTitle("Giri� Ekran�");
               stage.setScene(new Scene(root));
               stage.show();

               Stage currentStage = (Stage) link.getScene().getWindow();
               currentStage.close();
           } catch (Exception e) {
               e.printStackTrace();
               showAlert("Hata", "Giri� ekran�na d�n��te bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
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
    void kyt_formgec(ActionEvent event) {
    	String username = usr_txt.getText();
        String password = pswd_txt.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Hata", "L�tfen kullan�c� ad� ve �ifre girin.", Alert.AlertType.INFORMATION);
            return;
        }

        sql = "SELECT * FROM kullan�c�lar WHERE kullan�c�_ad� = ? AND �ifre = ? AND rol� = 'admin'";

        try {
            sorguifadesi = baglanti.prepareStatement(sql);
            sorguifadesi.setString(1, username);
            sorguifadesi.setString(2, password);
            getirilen = sorguifadesi.executeQuery();

            if (getirilen.next()) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Kay�t_Formu.fxml"));
                Parent root = loader.load();

                Stage stage = new Stage();
                stage.setTitle("Kay�t Formu");
                stage.setScene(new Scene(root));
                stage.show();

                Stage currentStage = (Stage) lgn_btn.getScene().getWindow();
                currentStage.close();
            } else {
                showAlert("Hata", "Ge�ersiz kullan�c� ad� veya �ifre ya da rol�n�z admin de�il.", Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Hata", "Veritaban� ba�lant� hatas�: " + e.getMessage(), Alert.AlertType.ERROR);
        } finally {
            try {
                if (getirilen != null) getirilen.close();
                if (sorguifadesi != null) getirilen.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void initialize() {
        
    }

}
