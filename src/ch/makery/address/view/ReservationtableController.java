package ch.makery.address.view;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
public class ReservationtableController implements Initializable{

	@FXML
	private TableView<Reservation> table;
	@FXML
	private TableColumn<Reservation,String> name;
	@FXML
	private TableColumn<Reservation,String> cardnbr;
	@FXML
	private TableColumn<Reservation,String> from;
	@FXML
	private TableColumn<Reservation,String> to;
	@FXML
	private TableColumn<Reservation,String> contact;
	@FXML
	private TableColumn<Reservation,String> trainname;
	@FXML
	private TableColumn<Reservation,String> trainnbr;
	@FXML
	private TableColumn<Reservation,String> date;
	@FXML
	private TableColumn<Reservation,Float> amount;
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
	public ObservableList<Reservation> getreserveesList(){
		ObservableList<Reservation> reserveList = FXCollections.observableArrayList();

		Connection conn = getConnection();
		String query = "Select * from paiment order by depart";
		Statement stat;
		ResultSet results;

		try {
			stat=conn.createStatement();
			results = stat.executeQuery(query);
			Reservation reservation;
			while(results.next()) {
				reservation = new Reservation(results.getString("name"),results.getString("cardNBR"),results.getString("depart"),results.getString("arrivee"),results.getString("tele"),results.getString("trainName"),results.getString("trainNumnber"),results.getString("datedepart"),results.getFloat("amount"));
				reserveList.add(reservation);
			}


		}catch(Exception e) {
			e.printStackTrace();
		}
		return reserveList;

	}
    @FXML
	public void showhlist() {
		ObservableList<Reservation> reservelist = getreserveesList();

		name.setCellValueFactory(cellData -> cellData.getValue().nameproperty());
		cardnbr.setCellValueFactory(cellData -> cellData.getValue().cardnbrproperty());
		from.setCellValueFactory(cellData -> cellData.getValue().departproperty());
		to.setCellValueFactory(cellData ->  cellData.getValue().arriveeproperty());
		contact.setCellValueFactory(cellData -> cellData.getValue().contactproperty());
		trainname.setCellValueFactory(cellData -> cellData.getValue().trainnameproperty());
		trainnbr.setCellValueFactory(cellData -> cellData.getValue().trainnbrproperty());
		date.setCellValueFactory(cellData -> cellData.getValue().dateproperty());
		amount.setCellValueFactory(cellData -> cellData.getValue().amountproperty().asObject());

		table.setItems(reservelist);
	}
    @FXML
    public void back(ActionEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("LogingDashboard.fxml"));
		mystage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("LoginDashboard.css").toExternalForm());
		mystage.setScene(scene);
		mystage.setResizable(false);
		mystage.show();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		showhlist();

	}

}
