package ch.makery.address.view;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;

import connect.Connectiondb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class paimentController {
	@FXML
	private Label amount;
	@FXML
	private TextField nameoncard;
	@FXML
	private TextField cardnbr;
	@FXML
	private TextField Edate;
	@FXML
	private TextField securcode;
	@FXML
	private Stage stage;
	private Scene scene;
	private Parent root;

	private int idtrain;
	private int nbrplaces;
	private String name;
	private String from;
	private String to;
	private String tele;
	private String trainName;
	private String trainNumnber;
	private String departdate;

	public void paimentinit(float amountprix,int iddec,int places,String name,String from,String to,String tele,String trainName,String trainNumnber,String departdate){
		amount.setText(""+amountprix);
		idtrain=iddec;
		nbrplaces=places;
		this.name=name;
		this.from=from;
		this.to=to;
		this.tele=tele;
		this.trainName=trainName;
		this.trainNumnber=trainNumnber;
		this.departdate=departdate;
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

	public void pay(ActionEvent event) throws IOException {
		float prix = Float.parseFloat(amount.getText());
		String namecard = nameoncard.getText();
		String cardnumber = cardnbr.getText();
		String dateE = Edate.getText();           //  MM/YYYY format
		String Scode = securcode.getText();

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(" Confirmation");
		alert.setContentText("Confirm your booking ?");
		if(alert.showAndWait().get()==ButtonType.OK) {

			String sql  = "insert into paiment (name,amount,nameoncard,cardNBR,Expirydate,SecurityCode,depart,arrivee,tele,trainName,trainNumnber,datedepart) values ('"+name+"',"+prix+",'"+namecard+"','"+cardnumber+"','"+dateE+"','"+Scode+"','"+from+"','"+to+"','"+tele+"','"+trainName+"','"+trainNumnber+"','"+departdate+"')";
			String query2 = "update horaires set nombreplace=nombreplace-"+nbrplaces+" where id="+idtrain+";";
			Connection conn = getconnection();
        	Statement stat1;
        	Statement stat2;
            try {
            	stat1= conn.createStatement();
            	stat1.executeUpdate(sql);
            	stat2=conn.createStatement();
            	stat2.executeUpdate(query2);
            	System.out.println("Paiment OK !");

             }catch(Exception ex) {
            	 ex.printStackTrace();
             }
            Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle(" Done");
    		alert2.setContentText("Booked Successfully");
    		if(alert2.showAndWait().get()==ButtonType.OK) {

    			root = FXMLLoader.load(getClass().getResource("RecherchePage.fxml"));
        		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        		scene = new Scene(root);
        		scene.getStylesheets().add(getClass().getResource("RecherchePage.css").toExternalForm());
        		stage.setScene(scene);
        		stage.setResizable(false);
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
 		stage.setResizable(false);
 		stage.show();

     }
}


