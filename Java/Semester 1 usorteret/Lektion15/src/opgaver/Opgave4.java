package opgaver;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Opgave4 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Tæl op/ned");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	private TextField txfName1;

	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);



		// add a button to the pane
		Button btnPlus = new Button("+");
		pane.add(btnPlus, 2, 0);
		GridPane.setMargin(btnPlus, new Insets(10, 10, 0, 10));
		
		// add a label to the pane (at col=0, row=0)
		Label lblName = new Label("Number:");
		pane.add(lblName, 0, 1);

		// add a text field to the pane

		txfName1 = new TextField("50");
		pane.add(txfName1, 1, 1);

		// add a button to the pane
		Button btnMinus = new Button("-");
		pane.add(btnMinus, 2, 2);
		GridPane.setMargin(btnMinus, new Insets(10, 10, 0, 10));

		// connect a method to the button
		btnPlus.setOnAction(event -> this.btnPlusAction());
		
		// connect a method to the button
		btnMinus.setOnAction(event -> this.btnMinusAction());
	}

	private void btnPlusAction() {
		String talPlusString = "";
		int talPlus = Integer.parseInt(txfName1.getText().trim());
		talPlus = talPlus + 1;
		talPlusString = Integer.toString(talPlus);
		txfName1.setText(talPlusString);
	}
	
	private void btnMinusAction() {
		String talMinusString = "";
		int talMinus = Integer.parseInt(txfName1.getText().trim());
		talMinus = talMinus - 1;
		talMinusString = Integer.toString(talMinus);
		txfName1.setText(talMinusString);
	}

}
