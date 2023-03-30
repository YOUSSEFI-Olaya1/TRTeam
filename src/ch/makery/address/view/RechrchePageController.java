package ch.makery.address.view;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import ch.makery.address.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class RechrchePageController {
	@FXML
	private TextField departsearch;
    @FXML
	private TextField arrivesearch;
    @FXML
    private DatePicker datesearch;

    private Stage stage;
	private Scene scene;
	private Parent root;


        @FXML
	public void rechercher(ActionEvent event) throws IOException{
        	String arrivee = arrivesearch.getText();
		    String depart = departsearch.getText();
		    LocalDate date =  datesearch.getValue();  //localDate

		    if(arrivee.isEmpty() || depart.isEmpty() || date==null){
		    	Alert alert = new Alert(AlertType.WARNING);
        		alert.setTitle(" Errer");
        		alert.setContentText("Voyer remplire tous les champs");
        		alert.showAndWait();
		    }
		    else{

		    String[] villes= {depart,arrivee};


		    FXMLLoader loader =new FXMLLoader(getClass().getResource("RechercheResultat.fxml"));
		    root = loader.load();

		    ResultatPageController controllerrc = loader.getController();
		    ObservableList<Voyage> listv = controllerrc.getvalue(villes,date);
		    if(listv.size()==0) {
		    	Alert alert = new Alert(AlertType.WARNING);
        		alert.setTitle("error");
        		alert.setContentText("Aucun voyage ne correspond à votre recherche!");
        		alert.showAndWait();
		    }
		    else {
		    controllerrc.showhorairesrecherche(villes,date);

		  //root = FXMLLoader.load(getClass().getResource("RechercheHohaires.fxml"));
		    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("Resultats.css").toExternalForm());
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
