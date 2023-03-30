package ch.makery.address.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginDashboardController {
	private Stage mystage;
	private Scene scene;
	private Parent root;

	@FXML
	public void modifier(ActionEvent event) throws IOException  {
		FXMLLoader loader =new FXMLLoader(getClass().getResource("trainmodif.fxml"));
	    root = loader.load();

	    TrainModifController modifController = loader.getController();
        modifController.showdata();

		mystage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("trainModif.css").toExternalForm());
		mystage.setScene(scene);
		mystage.setResizable(false);
		mystage.show();
	}
	@FXML
	public void reservation(ActionEvent event) throws IOException  {
		root = FXMLLoader.load(getClass().getResource("Reservationtable.fxml"));
		mystage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("Reservationtable.css").toExternalForm());
		mystage.setScene(scene);
		mystage.setResizable(false);
		mystage.show();
	}
	@FXML
	public void deconnection(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
		mystage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("LoginPage.css").toExternalForm());
		mystage.setScene(scene);
		mystage.setResizable(false);
		mystage.show();
	}
	@FXML
	public void AnnancesManegement(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("gestionAnnances.fxml"));
		mystage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("gestionAnnances.css").toExternalForm());
		mystage.setScene(scene);
		mystage.setResizable(false);
		mystage.show();
	}

}
