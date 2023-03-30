package ch.makery.address.view;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import ch.makery.address.model.*;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AnnancesManagementController implements Initializable{

	@FXML
	private TableView<Annance> table;
	@FXML
	private TableColumn<Annance,String> trainname;
	@FXML
	private TableColumn<Annance,String> trainnbr;
	@FXML
	private TableColumn<Annance,String> from;
	@FXML
	private TableColumn<Annance,String> to;
	@FXML
	private TableColumn<Annance,String> departh;
	@FXML
	private TableColumn<Annance,String> arrivalh;
	@FXML
	private TableColumn<Annance,String> duration;
	@FXML
	private TableColumn<Annance,String> reason;

	@FXML
	private Stage stage;
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
	public ObservableList<Annance> getAnnancesList(){
		ObservableList<Annance> annanceList = FXCollections.observableArrayList();

		Connection conn = getConnection();
		String query = "Select * from annance order by id desc";
		Statement stat;
		ResultSet results;

		try {
			stat=conn.createStatement();
			results = stat.executeQuery(query);
			Annance annance;
			while(results.next()) {
				annance = new Annance(results.getInt("id"),results.getString("depart"),results.getString("arrive"),results.getString("trainnbr"),results.getString("trainName"),results.getString("Hdepart"),results.getString("Harrive"),results.getString("cause"),results.getString("duration"));
				annanceList.add(annance);
			}


		}catch(Exception e) {
			e.printStackTrace();
		}
		return annanceList;

	}

	@FXML
    public void show() {
    	ObservableList<Annance> annanceList = getAnnancesList();

		from.setCellValueFactory(cellData -> cellData.getValue().departProperty());
		to.setCellValueFactory(cellData -> cellData.getValue().arriveeProperty());
		trainname.setCellValueFactory(cellData -> cellData.getValue().nomtrainproperty());
		trainnbr.setCellValueFactory(cellData ->  cellData.getValue().numtrainproperty());
		departh.setCellValueFactory(cellData -> cellData.getValue().Hdepartproperty());
		arrivalh.setCellValueFactory(cellData -> cellData.getValue().Harriveproperty());
		reason.setCellValueFactory(cellData -> cellData.getValue().reasonproperty());
		duration.setCellValueFactory(cellData -> cellData.getValue().durationproperty());
		table.setItems(annanceList);

    }

	@FXML
	public void back(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("LogingDashboard.fxml"));
 		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
 		scene = new Scene(root);
 		scene.getStylesheets().add(getClass().getResource("LoginDashboard.css").toExternalForm());
 		stage.setScene(scene);
 		stage.setResizable(false);
 		stage.show();
	}

	public Annance getAnnance(){
		if (table.getSelectionModel().getSelectedItem() != null) {
			Annance selectedAnnance = table.getSelectionModel().getSelectedItem();
			return selectedAnnance;

	    }
		return null;
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
	public void delete(ActionEvent event) throws IOException{
		Annance selectedAnnance = getAnnance();
		if(selectedAnnance==null) {
			Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle(" Errer");
    		alert.setContentText("Select an Announcement !");
    		alert.showAndWait();
		}
		else {
			String query="DELETE FROM annance WHERE id="+selectedAnnance.idProperty().intValue()+"";
			 Alert alert=new Alert(AlertType.CONFIRMATION);
			 alert.setTitle("Confirmation");
			 alert.setContentText("Do you want to delete this annancement");
			Optional <ButtonType> result= alert.showAndWait();
			if(result.get()==ButtonType.OK)
			{executeQuery(query);
			 show();
			 }
			else if(result.get()==ButtonType.CANCEL){ show();}
		}
	}



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		show();
	}




}
