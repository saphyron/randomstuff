package opgaver;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Opgave2 extends Application{

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Ombyt navne");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	private TextField txfName1;
	private TextField txfName2;

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
		//Label lblName = new Label("Name:");
		//pane.add(lblName, 0, 0);

		// add a text field to the pane

		txfName1 = new TextField();
		pane.add(txfName1, 0, 0);

		txfName2 = new TextField();
		pane.add(txfName2, 0, 1);

		// add a button to the pane
		Button btnOmbyt = new Button("Ombyt");
		pane.add(btnOmbyt, 0, 2);
		GridPane.setMargin(btnOmbyt, new Insets(10, 10, 0, 10));

		// connect a method to the button
		btnOmbyt.setOnAction(event -> this.btnOmbytAction());
	}

	private void btnOmbytAction() {
		String name3 = "";
		String name1 = txfName1.getText().trim();
		String name2 = txfName2.getText().trim();
		name3 = name1;
		txfName1.setText(name2);
		txfName2.setText(name3);

	}

}
