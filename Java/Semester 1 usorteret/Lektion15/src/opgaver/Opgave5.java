package opgaver;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Opgave5 extends Application{

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Converter Temperatur");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	private TextField txfCelsius;
	private TextField txfFahrenheit;

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
		Label lblName = new Label("Celsius:");
		pane.add(lblName, 0, 0);
		
		Label lblName2 = new Label("Fahrenheit:");
		pane.add(lblName2, 1, 0);

		// add a text field to the pane

		txfCelsius = new TextField();
		pane.add(txfCelsius, 0, 1);

		txfFahrenheit = new TextField();
		pane.add(txfFahrenheit, 1, 1);

		// add a button to the pane
		Button btnConvert = new Button("Convert");
		pane.add(btnConvert, 0, 2);
		GridPane.setMargin(btnConvert, new Insets(10, 10, 0, 10));

		// connect a method to the button
		btnConvert.setOnAction(event -> this.btnConvertAction());
	}

	private void btnConvertAction() {
		if (txfCelsius.getText().trim().length() == 0 && txfFahrenheit.getText().trim().length() != 0) {
			String talCelsiusPlus = "";
			double talCelsius = Double.parseDouble(txfFahrenheit.getText().trim());
			talCelsius = (talCelsius - 32) / 1.8;
			talCelsiusPlus = Double.toString(talCelsius);
			txfCelsius.setText(talCelsiusPlus);
		} else if (txfFahrenheit.getText().trim().length() == 0 && txfCelsius.getText().trim().length() != 0){
			String talFahrenheitPlus = "";
			double talFahrenheit = Double.parseDouble(txfCelsius.getText().trim());
			talFahrenheit = 1.8 * talFahrenheit + 32;
			talFahrenheitPlus = Double.toString(talFahrenheit);
			txfFahrenheit.setText(talFahrenheitPlus);
		}

	}

}
