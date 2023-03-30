package ch.makery.address.view;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FirstpageController {

	private Stage mystage;
	private Scene scene;
	private Parent root;

	@FXML
	public void switchToMenupage(ActionEvent event) throws IOException  {
		root = FXMLLoader.load(getClass().getResource("userDashboard.fxml"));
		mystage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("userDashboard.css").toExternalForm());
		mystage.setScene(scene);
		mystage.setResizable(false);
		mystage.show();
	}


}

