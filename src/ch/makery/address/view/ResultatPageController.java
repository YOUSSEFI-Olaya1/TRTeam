package ch.makery.address.view;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import ch.makery.address.model.*;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class ResultatPageController {
	@FXML
	private Label ville1;
	@FXML
	private Label ville2;
	@FXML
	private Label datelabel;
	@FXML
	private TableView<Voyage> Htable;
	@FXML
	private TableColumn<Voyage,String> depart;
	@FXML
	private TableColumn<Voyage,String> arrive;
	@FXML
	private TableColumn<Voyage,String> numtrain;
	@FXML
	private TableColumn<Voyage,String> Hdepart;
	@FXML
	private TableColumn<Voyage,String> Harrive;
	@FXML
	private TableColumn<Voyage,Integer> nbrplace;
	@FXML
	private TableColumn<Voyage,Float> prix;
	@FXML
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
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
     public ObservableList<Voyage> getvalue(String[] villes,LocalDate date){
        	ObservableList<Voyage> voyageListrecherche = FXCollections.observableArrayList();

            String depart = villes[0];
            String arrivee = villes[1];

            ville1.setText(villes[0]);
            ville2.setText(villes[1]);
            datelabel.setText(""+date);
        	Connection conn = getconnection();
        	Statement stat;
        	ResultSet results;

        			ville1.setText(depart);
                    ville2.setText(arrivee);
                 String query ="SELECT * from horaires where depart = '"+depart+"' and arrive = '"+arrivee+"' and datedepart='"+date+"'";


                 try {
                	stat= conn.createStatement();
                	results = stat.executeQuery(query);

                	Voyage voyage;
                	while(results.next()) {
                		voyage = new Voyage(results.getInt("id"),results.getString("depart"),results.getString("arrive"),results.getString("numtrain"),results.getString("Hdepart"),results.getString("Harrive"),results.getInt("nombreplace"),results.getFloat("prix"),results.getString("Nomdutrain"),date);
                		voyageListrecherche.add(voyage);
                	}

                 }catch(Exception ex) {
                	 ex.printStackTrace();
                 }

               return voyageListrecherche;

        }
	@FXML
        public void showhorairesrecherche(String[] villes,LocalDate date) {
    		ObservableList<Voyage> voyagelist = getvalue(villes,date);

    		depart.setCellValueFactory(cellData -> cellData.getValue().departproperty());
    		arrive.setCellValueFactory(cellData -> cellData.getValue().arriveproperty());
    		numtrain.setCellValueFactory(cellData -> cellData.getValue().numtrainproperty());
    		Hdepart.setCellValueFactory(cellData ->  cellData.getValue().Hdepartproperty());
    		Harrive.setCellValueFactory(cellData -> cellData.getValue().Harriveproperty());
    		nbrplace.setCellValueFactory(cellData -> cellData.getValue().nbrplaceproperty().asObject());
    		prix.setCellValueFactory(cellData -> cellData.getValue().prixproperty().asObject());

    		Htable.setItems(voyagelist);
    	}
	public void retourner(ActionEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("RecherchePage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("RecherchePage.css").toExternalForm());
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	public Voyage getvoyage(){
		if (Htable.getSelectionModel().getSelectedItem() != null) {
			Voyage selectedVoyage = Htable.getSelectionModel().getSelectedItem();
			return selectedVoyage;

	    }
		return null;
	}
	public void reserver(ActionEvent event) throws IOException {
		Voyage selectedVoyage = getvoyage();
		if(selectedVoyage==null) {
			Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle(" Errer");
    		alert.setContentText("Select a travel !");
    		alert.showAndWait();
		}
		else {
			FXMLLoader loader =new FXMLLoader(getClass().getResource("ReservationPage.fxml"));
		    root = loader.load();


            ReservationPage reservationController = loader.getController();
            reservationController.getinfos(selectedVoyage);

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("ReservationPage.css").toExternalForm());
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();

		}
	}


}
