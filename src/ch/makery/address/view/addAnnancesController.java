package ch.makery.address.view;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import ch.makery.address.model.*;
import ch.makery.address.view.*;
import connect.Connectiondb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class addAnnancesController {
	@FXML
	private Label Trainname;
	@FXML
	private Label Trainnbr;
	@FXML
	private Label from;
	@FXML
	private Label to;
	@FXML
	private Label Hdepart;
	@FXML
	private Label Harrivee;
    @FXML
	private ChoiceBox<String> causes;
    @FXML
    private TextField duration;
/*
	@FXML
	private int id;
	*/

	@FXML
	private Stage stage;
	private Scene scene;
	private Parent root;

	private ArrayList<String> cause = new  ArrayList<String>(Arrays.asList("Une accident","Des travaux","Retard au depart"));
    private ObservableList<String> list = FXCollections.observableArrayList(cause);


	public void getinfos(Voyage selectedVoyage) {
		from.setText(selectedVoyage.departproperty().getValue());
        to.setText(selectedVoyage.arriveproperty().getValue());
        Trainname.setText(selectedVoyage.nomtrainproperty().getValue());
        Trainnbr.setText(selectedVoyage.numtrainproperty().getValue());
        Hdepart.setText(selectedVoyage.Hdepartproperty().getValue());
        Harrivee.setText(selectedVoyage.Harriveproperty().getValue());
       // id=selectedVoyage.idproperty().getValue();

        causes.setItems(list);



	}

	@FXML
    public void cancel(ActionEvent event) throws IOException {
		FXMLLoader loader =new FXMLLoader(getClass().getResource("trainmodif.fxml"));
	    root = loader.load();

	    TrainModifController modifController = loader.getController();
        modifController.showdata();

		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("trainModif.css").toExternalForm());
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();

	    }


    @FXML
	public Connection getConnection() {
		Connection conn=null;
		try {
			conn=Connectiondb.connect();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}


    private void executeQuery(String query) {
		Connection con = getConnection();
		Statement st;
		try{
			st = con.createStatement();
			st.executeUpdate(query);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	@FXML
	public void Add(ActionEvent event) throws IOException {
		if(duration.getText()=="" ||causes.getValue()=="") {
			Alert alert = new Alert(AlertType.WARNING);
     		alert.setTitle(" Errer");
     		alert.setContentText("Add the duration and the reason of the daley !");
     		alert.showAndWait();
		}
		else {
			String query="INSERT INTO annance (trainName,trainnbr,depart,arrive,Hdepart,Harrive,cause,duration) VALUES('"+Trainname.getText()+"','"+Trainnbr.getText()+"','"+from.getText()+"','"+to.getText()+"','"+Hdepart.getText()+"','"+Harrivee.getText()+"','"+causes.getValue()+"','"+duration.getText()+"');";
			executeQuery(query);

			FXMLLoader loader =new FXMLLoader(getClass().getResource("trainmodif.fxml"));
		    root = loader.load();

		    TrainModifController modifController = loader.getController();
	        modifController.showdata();

			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("trainModif.css").toExternalForm());
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();

		}
	}


}
