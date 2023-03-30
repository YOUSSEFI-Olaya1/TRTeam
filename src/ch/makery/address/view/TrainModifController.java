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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TrainModifController {
	@FXML private TableView<Voyage> Table;
	@FXML private TableColumn<Voyage,Integer> Id1;
	@FXML private TableColumn<Voyage,String> NomDuTrain1;
	@FXML private TableColumn<Voyage,String> Source1;
	@FXML private TableColumn<Voyage,String> Destination1;
	@FXML private TableColumn<Voyage,String> HeureD1;
	@FXML private TableColumn<Voyage,String> HeureA1;
	@FXML private TableColumn<Voyage,Float> Montant1;
	@FXML private TableColumn <Voyage,Integer>Places_Vides1;
	@FXML private TableColumn<Voyage,String> numtrain;

    @FXML private TextField txt_Id;
    @FXML private TextField txt_NomDuTrain;
    @FXML private TextField txt_Source;
    @FXML private TextField txt_Destination;
    @FXML private TextField txt_HeureD;
    @FXML private TextField txt_HeureA;
    @FXML private TextField txt_Montant;
    @FXML private TextField txt_Places_Vides;
    @FXML private String numtrainAnn;

    @FXML
    private Stage stage;
    @FXML
	private Scene scene;
    @FXML
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
    public ObservableList<Voyage> ViewData(){
		ObservableList<Voyage> data=FXCollections.observableArrayList();
			Connection con = getConnection();
			String sql ="SELECT * FROM horaires";
			Statement stat;
			ResultSet rs;
			Voyage trn;
			try{
				stat=con.createStatement();
			    rs =stat.executeQuery(sql);
			while(rs.next())
			{
				trn=new Voyage(rs.getInt("Id"),rs.getString("depart"),rs.getString("arrive"),rs.getString("numtrain"),rs.getString("Hdepart"),rs.getString("Harrive"),rs.getInt("nombreplace"),rs.getInt("prix"),rs.getString("NomDuTrain"));
				data.add(trn);
			}
			}catch(Exception e){
				e.printStackTrace();
		}
			return data;
	}

	public void showdata(){
		ObservableList<Voyage> List=ViewData();

        Id1.setCellValueFactory(cellData -> cellData.getValue().idproperty().asObject());
        NomDuTrain1.setCellValueFactory(cellData -> cellData.getValue().nomtrainproperty());
		Source1.setCellValueFactory(cellData -> cellData.getValue().departproperty());
		Destination1.setCellValueFactory(cellData -> cellData.getValue().arriveproperty());
		numtrain.setCellValueFactory(cellData -> cellData.getValue().numtrainproperty());
		HeureD1.setCellValueFactory(cellData ->  cellData.getValue().Hdepartproperty());
		HeureA1.setCellValueFactory(cellData -> cellData.getValue().Harriveproperty());
		Places_Vides1.setCellValueFactory(cellData -> cellData.getValue().nbrplaceproperty().asObject());
		Montant1.setCellValueFactory(cellData -> cellData.getValue().prixproperty().asObject());

		/*
		Id1.setCellValueFactory(new PropertyValueFactory <Voyage,Integer>("Id"));
		NomDuTrain1.setCellValueFactory(new PropertyValueFactory <Voyage,String>("Tran name"));
		Source1.setCellValueFactory(new PropertyValueFactory <Voyage,String>("Source"));
		Destination1.setCellValueFactory(new PropertyValueFactory <Voyage,String>("Destination"));
		HeureD1.setCellValueFactory(new PropertyValueFactory <Voyage,String>("HeurD"));
		HeureA1.setCellValueFactory(new PropertyValueFactory <Voyage,String>("HeurA"));
		Montant1.setCellValueFactory(new PropertyValueFactory <Voyage,Float>("montant"));
		Places_Vides1.setCellValueFactory(new PropertyValueFactory <Voyage,Integer>("places"));
		numtrain.setCellValueFactory(new PropertyValueFactory <Voyage,String>("N° train"));
		*/
		Table.setItems(List);
	}
	public void insertRecord(){
		String query="INSERT INTO Horaires VALUES("+txt_Id.getText()+",'"+txt_NomDuTrain.getText()+"','"+txt_Source.getText()+"','"+txt_Destination.getText()+"','"+txt_HeureD.getText()+"','"+txt_HeureA.getText()+"',"+txt_Places_Vides.getText()+","+txt_Montant.getText()+");";
		executeQuery(query);
		showdata();
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
	    private void handleMouseAction(MouseEvent event) {
		 Voyage trn = Table.getSelectionModel().getSelectedItem();
		 txt_Id.setText(""+trn.idproperty().getValue());
		 txt_NomDuTrain.setText(""+trn.nomtrainproperty().getValue());
		 txt_Source.setText(""+trn.departproperty().getValue());
		 txt_Destination.setText(""+trn.arriveproperty().getValue());
		 txt_HeureD.setText(""+trn.Hdepartproperty().getValue());
		 txt_Montant.setText(""+trn.prixproperty().getValue());
		 txt_HeureA.setText(""+trn.Harriveproperty().getValue());
		 txt_Places_Vides.setText(""+trn.nbrplaceproperty().getValue());
		 numtrainAnn = ""+trn.numtrainproperty().getValue();
	    }

	 public void updateRecord(){
		 String query="UPDATE horaires SET Nomdutrain='"+txt_NomDuTrain.getText()+"',depart='"+txt_Source.getText()+"',arrive='"+txt_Destination.getText()+"',Hdepart='"+txt_HeureD.getText()+"',Harrive='"+txt_HeureA.getText()+"',prix="+txt_Montant.getText()+",nombreplace="+txt_Places_Vides.getText()+" WHERE id="+txt_Id.getText()+";";
		 executeQuery(query);
		 System.out.println("OK update");
		 showdata();
		 }
	 public void deleteRecord(){
		 String query="DELETE FROM horaires WHERE id="+txt_Id.getText()+"";
		 Alert alert=new Alert(AlertType.CONFIRMATION);
		 alert.setTitle("Confirmation");
		 alert.setContentText("Etes Vous Sur De Suprimer Cette Ligne");
		Optional <ButtonType> result= alert.showAndWait();
		if(result.get()==ButtonType.OK)
		{executeQuery(query);
		 showdata();
		 }
		else if(result.get()==ButtonType.CANCEL){ showdata();}

	}
	 public void retourner(ActionEvent event) throws IOException {

 		root = FXMLLoader.load(getClass().getResource("LogingDashboard.fxml"));
 		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
 		scene = new Scene(root);
 		scene.getStylesheets().add(getClass().getResource("LoginDashboard.css").toExternalForm());
 		stage.setScene(scene);
 		stage.setResizable(false);
 		stage.show();
 	}

	 public Voyage getvoyage(){
			if (Table.getSelectionModel().getSelectedItem() != null) {
				Voyage selectedVoyage = Table.getSelectionModel().getSelectedItem();
				return selectedVoyage;

		    }
			return null;
		}



	 public void addannance(ActionEvent event) throws IOException {
			Voyage selectedVoyage= getvoyage();

             if(selectedVoyage==null) {
            	 Alert alert = new Alert(AlertType.WARNING);
         		alert.setTitle(" Errer");
         		alert.setContentText("Select a travel !");
         		alert.showAndWait();
             }
             else {

			FXMLLoader loaderann =new FXMLLoader(getClass().getResource("AnnancesAdd.fxml"));

		    root = loaderann.load();


			    addAnnancesController anncController = loaderann.getController();
	            anncController.getinfos(selectedVoyage);

	            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("annaceAdd.css").toExternalForm());
				stage.setScene(scene);
				stage.setResizable(false);
				stage.show();
             }

			}
/*
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		showdata();
		// TODO Auto-generated method stub

	}
	*/
}
