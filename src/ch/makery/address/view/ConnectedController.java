package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ConnectedController {

	@FXML
	private Label email;


	public void putemail(String emailinfo) {
		email.setText(emailinfo);
	}


}
