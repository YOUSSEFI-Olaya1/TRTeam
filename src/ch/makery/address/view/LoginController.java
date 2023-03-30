package ch.makery.address.view;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import connect.Connectiondb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	private Button loginbutton;
	@FXML
	private TextField email;
	@FXML
	private PasswordField password;
	@FXML
	private Parent root;
	@FXML
	private Scene scene;
	@FXML
	private Stage stage;
	public String[] data() {
		String emaillog = email.getText();
		String passwrdlog = password.getText();
		if(emaillog.isEmpty() || passwrdlog.isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Champ(s) vide(s)");
			alert.setContentText("Voyez entez votre Email at Votre mot de passe");
			alert.showAndWait();
			return null;
		}
		else {
		String[] infologin= {emaillog,passwrdlog};
		return infologin;
		}
	}
	public Connection dbConnection() {
		Connection conn =null;

		try {
			conn =Connectiondb.connect();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void show(ActionEvent event) throws IOException{
		if(data()!=null) {

		String[] infolog = data();

		Connection conn = dbConnection();
		Statement stat;
		ResultSet results;
		String sqlq ="Select * from login where email ='"+infolog[0]+"'";
		String passwrd =null;
		String emaildb=null;
        try {
		stat = conn.createStatement();
		results=stat.executeQuery(sqlq);
		while(results.next()) {
			passwrd = results.getString("password");
			emaildb = results.getString("email");
    	}
        }
        catch(Exception ex) {
        	ex.printStackTrace();
        }
        if(!passwrd.equals(infolog[1]) || emaildb==null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("Email ou mot de pass invalide(s)!");
			alert.showAndWait();
		}
		else {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("LogingDashboard.fxml"));
		root=loader.load();
/*
        ConnectedController controller2 = loader.getController();
        controller2.putemail(emaildb);
        */


      //root = FXMLLoader.load(getClass().getResource("Connectionsucces.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("LoginDashboard.css").toExternalForm());
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		}
		}

	}
	public void retourner(ActionEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("userDashboard.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("userDashboard.css").toExternalForm());
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

}
