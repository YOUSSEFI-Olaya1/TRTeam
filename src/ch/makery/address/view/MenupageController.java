package ch.makery.address.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenupageController {
	private Stage mystage;
	private Scene scene;
	private Parent root;

	@FXML
	public void Recherchepage(ActionEvent event) throws IOException  {
		root = FXMLLoader.load(getClass().getResource("RecherchePage.fxml"));
		mystage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("RecherchePage.css").toExternalForm());
		mystage.setScene(scene);
		mystage.setResizable(false);
		mystage.show();
	}
	public void horairesPage(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("HorairesPages.fxml"));
		mystage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("HorairesPage.css").toExternalForm());
		mystage.setScene(scene);
		mystage.setResizable(false);
		mystage.show();
	}
	public void ReservatioPage(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("ReservationPage.FXML"));
		mystage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("ReservationPage.css").toExternalForm());
		mystage.setScene(scene);
		mystage.setResizable(false);
		mystage.show();
	}
	public void LogingPage(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("LoginPage.FXML"));
		mystage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("LoginPage.css").toExternalForm());
		mystage.setScene(scene);
		mystage.setResizable(false);
		mystage.show();
	}
	public void AnnancePages(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("UserAnnances.FXML"));
		mystage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("UserAnnances.css").toExternalForm());
		mystage.setScene(scene);
		mystage.setResizable(false);
		mystage.show();
	}

}
