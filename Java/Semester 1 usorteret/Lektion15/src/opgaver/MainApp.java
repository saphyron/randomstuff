package opgaver;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("John's Awesome GUI");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private TextField txfName;

	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);

		// add a label to the pane (at col=0, row=0)
		Label lblName = new Label("Name:");
		pane.add(lblName, 0, 0);

		// add a text field to the pane
		// (at col=1, row=0, extending 2 columns and 1 row)
		txfName = new TextField();
		pane.add(txfName, 1, 0, 2, 1);

		// add a button to the pane (at col=1, row=1)
		Button btnUpperCase = new Button("Upper Case");
		pane.add(btnUpperCase, 1, 1);
		GridPane.setMargin(btnUpperCase, new Insets(10, 10, 0, 10));

		// connect a method to the button
		btnUpperCase.setOnAction(event -> this.upperCaseAction());

		// add a button to the pane (at col=2, row=1)
		Button btnLowerCase = new Button("Lower Case");
		pane.add(btnLowerCase, 2, 1);
		GridPane.setMargin(btnLowerCase, new Insets(10, 10, 0, 10));

		// connect a method to the button
		btnLowerCase.setOnAction(event -> this.lowerCaseAction());
	}

	// -----------------------------------------------------
	// Button actions

	private void upperCaseAction() {
		String name = txfName.getText().trim();
		txfName.setText(name.toUpperCase());

	}

	private void lowerCaseAction() {
		String name = txfName.getText().trim();
		txfName.setText(name.toLowerCase());
	}

}
