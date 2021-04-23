package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Hotel;
import model.Serviceydelse;

public class OpretHotelWindow extends Stage {
	private Hotel hotel;

	public OpretHotelWindow(String title, Hotel hotel) {
		initStyle(StageStyle.UTILITY);
		initModality(Modality.APPLICATION_MODAL);
		setResizable(false);
		this.hotel = hotel;

		setTitle(title);
		GridPane pane = new GridPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		setScene(scene);
	}

	public OpretHotelWindow(String title) {
		this(title, null);
	}

	// -------------------------------------------------------------------------

	private TextField txfNavn, txfPrisEnkeltVaerelse, txfPrisDobbeltVaerelse;
	private ComboBox<Serviceydelse> cbbServiceydelser;
	private CheckBox chbServiceydelser;
	private Label lblError;

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		Label lblNavn = new Label("Navn");
		pane.add(lblNavn, 0, 1);

		txfNavn = new TextField();
		pane.add(txfNavn, 1, 1);
		txfNavn.setPrefWidth(200);

		Label lblPrisEnkeltVaerelse = new Label("Pris enkeltvaerelse");
		pane.add(lblPrisEnkeltVaerelse, 0, 2);

		txfPrisEnkeltVaerelse = new TextField();
		pane.add(txfPrisEnkeltVaerelse, 1, 2);
		txfPrisEnkeltVaerelse.setPrefWidth(200);

		Label lblPrisDobbeltVaerelse = new Label("Pris dobbeltvaerelse");
		pane.add(lblPrisDobbeltVaerelse, 0, 3);

		txfPrisDobbeltVaerelse = new TextField();
		pane.add(txfPrisDobbeltVaerelse, 1, 3);
		txfPrisDobbeltVaerelse.setPrefWidth(200);

		chbServiceydelser = new CheckBox("Ekstra Service");
		pane.add(chbServiceydelser, 0, 4);
		ChangeListener<Boolean> listener = (ov, oldValue, newValue) -> selectedchbServiceydelserChanged(newValue);
		chbServiceydelser.selectedProperty().addListener(listener);

		cbbServiceydelser = new ComboBox<>();
		pane.add(cbbServiceydelser, 0, 5);
		cbbServiceydelser.getItems().addAll(Controller.getServiceydelse());
		cbbServiceydelser.setDisable(true);

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 7);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setOnAction(event -> cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 1, 7);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setOnAction(event -> okAction());

		lblError = new Label();
		pane.add(lblError, 0, 8);
		lblError.setStyle("-fx-text-fill: red");

	}

	// ----------------------------------------------------------------------

	// -----------------------------------------------------------------------

	private void cancelAction() {
		hide();
	}

	private void okAction() {
		String navn = txfNavn.getText().trim();
		double PrisEnkelt = Double.parseDouble(txfPrisEnkeltVaerelse.getText().trim());
		double PrisDobble = Double.parseDouble(txfPrisDobbeltVaerelse.getText().trim());

		Serviceydelse newServiceydelse = cbbServiceydelser.getSelectionModel().getSelectedItem();
		boolean chbServiceydelserIsSelected = chbServiceydelser.isSelected();

		if (navn.length() == 0 || PrisEnkelt == 0 || PrisDobble == 0) {
			lblError.setText("Information mangler");
			return;
		}
		if (hotel != null) {

			Controller.updateHotel(hotel, navn, PrisDobble, PrisEnkelt);
			if (chbServiceydelserIsSelected) {
				Controller.addServiceToHotel(newServiceydelse, hotel);
			}

		} else {
			if (chbServiceydelserIsSelected) {
				Controller.createHotel(newServiceydelse, navn, PrisDobble, PrisEnkelt);
			} else {
				Controller.createHotel(navn, PrisDobble, PrisEnkelt);
			}
		}
		this.hide();
	}

	private void selectedchbServiceydelserChanged(boolean checked) {
		cbbServiceydelser.setDisable(!checked);
	}

}
