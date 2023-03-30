package ch.makery.address.view;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import ch.makery.address.model.*;
import connect.Connectiondb;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class ReservationPage {
	@FXML
	private TextField Name;
	@FXML
	private TextField phone;
	@FXML
	private TextField numbrplaces;
	@FXML
	private Label depart;
	@FXML
	private Label arrivee;
	@FXML
	private Label trainname;
	@FXML
	private Label departdate;
	@FXML
	private Label trainNumber;
	@FXML
	private Label totalprice;
	@FXML
	private Label price;
	@FXML
	private Label id;

	@FXML
	private Stage stage;
	private Scene scene;
	private Parent root;

	public void getinfos(Voyage selectedVoyage) {
         depart.setText(selectedVoyage.departproperty().getValue());
         arrivee.setText(selectedVoyage.arriveproperty().getValue());
         trainname.setText(selectedVoyage.nomtrainproperty().getValue());
         trainNumber.setText(selectedVoyage.numtrainproperty().getValue());
         departdate.setText(selectedVoyage.departDateProperty().getValue().toString());
         price.setText(selectedVoyage.prixproperty().getValue().toString());
         id.setText(selectedVoyage.idproperty().getValue().toString());
	}
	public Connection getconnection() {

    	Connection conn=null;
    	try {
    	conn =Connectiondb.connect();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return conn;
    }

     @FXML
	public void booking(ActionEvent event) throws IOException {

		String name = Name.getText();
		String phonenumbr = phone.getText();
		int nbrplaces = Integer.parseInt(numbrplaces.getText());
        float prix=Float.parseFloat(price.getText());
        int iddec = Integer.parseInt(id.getText());
        float total = prix*nbrplaces;
        String from = depart.getText();
        String to = arrivee.getText();
        String trainName = trainname.getText();
        String trainnumber= trainNumber.getText();
        String tele =phone.getText();
        String datedepart=departdate.getText();
        totalprice.setText(String.valueOf(total));
        if(nbrplaces>6) {
        	Alert alert1 = new Alert(AlertType.WARNING);
    		alert1.setTitle("Error");
    		alert1.setContentText("You can book at max 6 places");

        }
        else {
        Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(" Confirmation");
		alert.setContentText("Confirmer votre reservation");

		if(alert.showAndWait().get()==ButtonType.OK) {
			Connection conn = getconnection();
        	Statement stat1;
            String query1 = "insert into bookings (name,phone,source,destination,datedepart,seats,amount) values ('"+name+"','"+phonenumbr+"','"+depart.getText()+"','"+arrivee.getText()+"','"+departdate.getText()+"',"+nbrplaces+","+total+");";
            try {
            	stat1= conn.createStatement();

            	stat1.executeUpdate(query1);
            	System.out.println("OK !");

             }catch(Exception ex) {
            	 ex.printStackTrace();
             }
            FXMLLoader loader =new FXMLLoader(getClass().getResource("PaimentPage.fxml"));
		    root = loader.load();


            paimentController paimentcontroller = loader.getController();
            paimentcontroller.paimentinit(total,iddec , nbrplaces,name,from,to,tele,trainName,trainnumber,datedepart);

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("PaimentPage.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		}
        }
	}
	public void cancel(ActionEvent event) throws IOException {
   	 root = FXMLLoader.load(getClass().getResource("RecherchePage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("RecherchePage.css").toExternalForm());
		stage.setScene(scene);
		stage.show();

    }

}
