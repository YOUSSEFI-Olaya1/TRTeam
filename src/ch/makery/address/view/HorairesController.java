package ch.makery.address.view;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import ch.makery.address.model.*;
import ch.makery.address.view.*;
import connect.Connectiondb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class HorairesController implements Initializable{
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
	private TableColumn<Voyage,String> date;
	@FXML
	private TableColumn<Voyage,Float> prix;
    @FXML
    private Stage mystage;
	private Scene scene;
	private Parent root;

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
	@FXML
	public ObservableList<Voyage> getvoyagesList(){
		ObservableList<Voyage> voyageList = FXCollections.observableArrayList();

		Connection conn = getConnection();
		String query = "Select * from horaires order by depart";
		Statement stat;
		ResultSet results;

		try {
			stat=conn.createStatement();
			results = stat.executeQuery(query);
			Voyage voyage;
			while(results.next()) {
				voyage = new Voyage(results.getInt("id"), results.getString("depart"),results.getString("arrive"),results.getString("numtrain"),results.getString("Hdepart"),results.getString("Harrive"),results.getInt("nombreplace"),results.getFloat("prix"),results.getString("Nomdutrain"),results.getDate("datedepart").toLocalDate());
			    voyageList.add(voyage);
			}


		}catch(Exception e) {
			e.printStackTrace();
		}
		return voyageList;

	}

	@FXML
	public void showhoraires() {
		ObservableList<Voyage> voyagelist = getvoyagesList();

		depart.setCellValueFactory(cellData -> cellData.getValue().departproperty());
		arrive.setCellValueFactory(cellData -> cellData.getValue().arriveproperty());
		numtrain.setCellValueFactory(cellData -> cellData.getValue().nomtrainproperty());
		Hdepart.setCellValueFactory(cellData ->  cellData.getValue().Hdepartproperty());
		Harrive.setCellValueFactory(cellData -> cellData.getValue().Harriveproperty());
		nbrplace.setCellValueFactory(cellData -> cellData.getValue().nbrplaceproperty().asObject());
        date.setCellValueFactory(cellData -> cellData.getValue().departDateProperty().asString());
		prix.setCellValueFactory(cellData -> cellData.getValue().prixproperty().asObject());

		Htable.setItems(voyagelist);
	}
	public void retourner(ActionEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("userDashboard.fxml"));
		mystage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("userDashboard.css").toExternalForm());
		mystage.setScene(scene);
		mystage.setResizable(false);
		mystage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		showhoraires();
		}

}
