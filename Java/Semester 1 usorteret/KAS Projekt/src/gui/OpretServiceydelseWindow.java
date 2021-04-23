package gui;

import controller.Controller;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Hotel;

public class OpretServiceydelseWindow extends Stage {

	public OpretServiceydelseWindow(String title, Hotel hotel) {
		initStyle(StageStyle.UTILITY);
		initModality(Modality.APPLICATION_MODAL);
		setResizable(false);

		setTitle(title);
		GridPane pane = new GridPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		setScene(scene);
	}

	public OpretServiceydelseWindow(String title) {
		this(title, null);
	}

	// -------------------------------------------------------------------------

	private TextField txfNavn, txfPris;

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

		Label lblPris = new Label("Pris");
		pane.add(lblPris, 0, 2);

		txfPris = new TextField();
		pane.add(txfPris, 1, 2);
		txfPris.setPrefWidth(200);

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 7);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setOnAction(event -> cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 1, 7);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setOnAction(event -> okAction());

	}

	// ---Action-Button----------------------------------------------------------------

	private void cancelAction() {
		hide();
	}

	private void okAction() {
		String navn = txfNavn.getText().trim();
		double pris = Double.parseDouble(txfPris.getText().trim());

		Controller.createServiceydelse(navn, pris);
		hide();
	}
}
