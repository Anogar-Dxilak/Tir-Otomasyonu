package application;


import java.io.IOException;
import java.net.URL;
import java.sql.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ResourceBundle;
import com.MySQL.util.Veritaban�Util;
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
		baglanti=Veritaban�Util.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TableView<Kullan�c�lar> user_table;

    @FXML
    private TableColumn<Kullan�c�lar, String> AdCol;

    @FXML
    private TableColumn<Kullan�c�lar, Integer> IDCol;

    @FXML
    private TableColumn<Kullan�c�lar, String> RolCol;

    @FXML
    private TableColumn<Kullan�c�lar, String> SoyadCol;

    @FXML
    private TableColumn<Kullan�c�lar, String> UsrnmCol;
    
    @FXML
    private TableColumn<Kullan�c�lar, Timestamp> kay�ttarihiCol;

    @FXML
    private RadioButton admin_radio;

    @FXML
    private Button down_btn;
    
    @FXML
    private Hyperlink anasyf_d�n_link;

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
    private ToggleGroup rol_se�imi;

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
    void anasyf_d�n_Click(ActionEvent event) {
    	try {
            // Form3.fxml dosyas�n� y�kle
            Parent form3Parent = FXMLLoader.load(getClass().getResource("Form3.fxml"));
            Scene form3Scene = new Scene(form3Parent);

            // Mevcut sahneyi al
            Stage window = (Stage) anasyf_d�n_link.getScene().getWindow();

            // Yeni sahneyi ayarla ve g�ster
            window.setScene(form3Scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Hata", "Anasayfaya d�n��te bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    	
    
    @FXML
    void clear_Click(ActionEvent event) {
    	id_lbl.setText("Se�ilen");
    }

    @FXML
    void down_Click(ActionEvent event) {
    	 String userIdText = id_lbl.getText();
    	    if (userIdText == null || userIdText.trim().isEmpty()) {
    	    	showAlert("Hata", "L�tfen tablodan birini se�in.", Alert.AlertType.INFORMATION);
    	        return;
    	    }

    	    try {
    	        int userId = Integer.parseInt(userIdText.trim());

    	        String sql = "UPDATE kullan�c�lar SET rol� = 'kullan�c�' WHERE kullan�c�ID = ?";

    	        try (PreparedStatement pstmt = baglanti.prepareStatement(sql)) {
    	            pstmt.setInt(1, userId); 
    	            int affectedRows = pstmt.executeUpdate(); 

    	            if (affectedRows > 0) {
    	                System.out.println("Kullan�c�n�n rol� ba�ar�yla d���r�ld�.");
    	                clear_Click(event);
    	            } else {
    	                System.out.println("Rol d���rme i�lemi ba�ar�s�z oldu. L�tfen tekrar deneyin.");
    	            }
    	        }
    	    } catch (NumberFormatException e) {
    	    	showAlert("Hata", "L�tfen tablodan birini se�in.", Alert.AlertType.INFORMATION);
    	    } catch (SQLException e) {
    	    	showAlert("Veritaban� Hatas�", "Veritaban� i�lemi s�ras�nda bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
    	    }
    	    Kullan�c�lar�Getir(user_table);
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
    	    	showAlert("", "L�tfen bir kullan�c� se�iniz.", Alert.AlertType.INFORMATION);
    	        return;
    	    }

    	    try {
    	        int userId = Integer.parseInt(userIdText.trim());

    	        String sql = "DELETE FROM kullan�c�lar WHERE kullan�c�ID = ?";

    	        try (PreparedStatement pstmt = baglanti.prepareStatement(sql)) {
    	            pstmt.setInt(1, userId);
    	            int affectedRows = pstmt.executeUpdate();

    	            if (affectedRows > 0) {
    	                System.out.println("Kullan�c� ba�ar�yla veritaban�ndan silindi.");
    	                clear_Click(event);
    	            } else {
    	                showAlert("Hata","Kullan�c� silme i�lemi ba�ar�s�z oldu. L�tfen tekrar deneyin.", Alert.AlertType.ERROR);
    	            }
    	        }
    	    } catch (NumberFormatException e) {
    	    	 showAlert("Hata", "L�tfen tablodan birini se�in.", Alert.AlertType.INFORMATION);
    	    } catch (SQLException e) {
    	    	 showAlert("Veritaban� Hatas�", "Veritaban� i�lemi s�ras�nda bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
    	    }
    	    Kullan�c�lar�Getir(user_table);
    }

    @FXML
    void kyt_Click(ActionEvent event) {
        if (usrname_txt.getText().isEmpty() || pswd_txt.getText().isEmpty() || eposta_txt.getText().isEmpty() || 
                name_txt.getText().isEmpty() || soyad_txt.getText().isEmpty() || tel_txt.getText().isEmpty()) {
                showAlert("Hata", "L�tfen t�m alanlar� doldurun.", Alert.AlertType.INFORMATION);
                return;
            }

            String sql = "INSERT INTO kullan�c�lar (kullan�c�_ad�, �ifre, ad, soyad, eposta, tel_no, rol�) VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pstmt = baglanti.prepareStatement(sql)) {
                pstmt.setString(1, usrname_txt.getText());
                pstmt.setString(2, pswd_txt.getText());
                pstmt.setString(3, name_txt.getText());
                pstmt.setString(4, soyad_txt.getText());
                pstmt.setString(5, eposta_txt.getText());
                pstmt.setString(6, tel_txt.getText());
                pstmt.setString(7, admin_radio.isSelected() ? "admin" : "kullan�c�"); // Rol bilgisini RadioButton'dan al

                int affectedRows = pstmt.executeUpdate();

                if (affectedRows > 0) {
                    showAlert("Ba�ar�l�", "Kullan�c� ba�ar�yla eklendi.", Alert.AlertType.INFORMATION);
                } else {
                    showAlert("Hata", "Kullan�c� eklenemedi. L�tfen tekrar deneyin.", Alert.AlertType.ERROR);
                }
            } catch (SQLException e) {
                showAlert("Veritaban� Hatas�", "Veritaban� i�lemi s�ras�nda bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
            }
    }

    @FXML
    void reflesh_Click(ActionEvent event) {
    	Kullan�c�lar�Getir(user_table);
    }

    @FXML
    void up_Click(ActionEvent event) {
    	String userIdText = id_lbl.getText();
        if (userIdText == null || userIdText.trim().isEmpty()) {
            System.out.println("L�tfen bir kullan�c� se�iniz.");
            return;
        }

        try {
            int userId = Integer.parseInt(userIdText.trim());

            
            String sql = "UPDATE kullan�c�lar SET rol� = 'admin' WHERE kullan�c�ID = ?";

            try (PreparedStatement pstmt = baglanti.prepareStatement(sql)) {
                pstmt.setInt(1, userId); 
                int affectedRows = pstmt.executeUpdate();

                if (affectedRows > 0) {
                    System.out.println("Kullan�c�n�n rol� ba�ar�yla y�kseltildi.");
                    clear_Click(event);
                } else {
                    System.out.println("Rol y�kseltme i�lemi ba�ar�s�z oldu. L�tfen tekrar deneyin.");
                }
            }
        } catch (NumberFormatException e) {
        	showAlert("Hata", "L�tfen tablodan birini se�in.", Alert.AlertType.INFORMATION);
        } catch (SQLException e) {
        	showAlert("Veritaban� Hatas�", "Veritaban� i�lemi s�ras�nda bir hata olu�tu: " + e.getMessage(), Alert.AlertType.ERROR);
        }
        Kullan�c�lar�Getir(user_table);
    }
    
    @FXML
    void Selecteduser(MouseEvent event) {
        Kullan�c�lar selectedUser = user_table.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            id_lbl.setText(String.valueOf(selectedUser.getKullan�c�ID()));
        }
    }
    
    private void showAlert(String title, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    public void Kullan�c�lar�Getir(TableView<Kullan�c�lar> tablo) {
    	sql="select * from kullan�c�lar";
    	ObservableList<Kullan�c�lar> usrlist=FXCollections.observableArrayList();
    	try {
    		sorguifadesi=baglanti.prepareStatement(sql);
    		ResultSet getirilen=sorguifadesi.executeQuery();
    		while(getirilen.next()) {
    			usrlist.add(new Kullan�c�lar(getirilen.getInt("kullan�c�ID"), getirilen.getString("kullan�c�_ad�"), getirilen.getString("�ifre"), getirilen.getString("ad"), getirilen.getString("soyad"), getirilen.getString("eposta"), getirilen.getString("tel_no"), getirilen.getString("rol�"), getirilen.getTimestamp("kay�t_tarihi")));
    		}
    		
    		IDCol.setCellValueFactory(new PropertyValueFactory<>("kullan�c�ID"));
    		UsrnmCol.setCellValueFactory(new PropertyValueFactory<>("kullan�c�_ad�"));
    		AdCol.setCellValueFactory(new PropertyValueFactory<>("ad"));
    		SoyadCol.setCellValueFactory(new PropertyValueFactory<>("soyad"));
    		RolCol.setCellValueFactory(new PropertyValueFactory<>("rol�"));
    		kay�ttarihiCol.setCellValueFactory(new PropertyValueFactory<>("kay�t_tarihi"));
    		user_table.setItems(usrlist);
    	} catch (Exception e) {
    		System.out.println(e.getMessage().toString());
    	}
    	
    }
    
    @FXML
    void initialize() {
    	Kullan�c�lar�Getir(user_table);
    }

}
