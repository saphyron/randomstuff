package gui;

import java.util.ArrayList;
import java.util.Optional;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Hotel;
import model.Serviceydelse;

public class OpretHotelPane extends GridPane {

	private ListView<Hotel> lvwHoteller;
	private ListView<Serviceydelse> lvwOprettetServiceydelser;
	private Label lblTilknyttetServiceYdelser, lblHoteller, lblenkeltvaerelse, lbldobbeltvaerelse;
	private Button btnOpret, btnSlet, btnOpdater, btnOpretServiceydelse, btnSletYedelse;

	private TextField txfenkeltvaerelse, txfdobbeltvaerelse;
	private TextArea txfTilknyttetServiceYdelser;

	public OpretHotelPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		lbldobbeltvaerelse = new Label("Pris enkeltværelse:");
		this.add(lbldobbeltvaerelse, 2, 2, 3, 1);

		txfenkeltvaerelse = new TextField();
		this.add(txfenkeltvaerelse, 3, 2);
		txfenkeltvaerelse.setPrefWidth(200);

		lblenkeltvaerelse = new Label("Pris dobbeltværelse:");
		this.add(lblenkeltvaerelse, 2, 3, 3, 1);

		txfdobbeltvaerelse = new TextField();
		this.add(txfdobbeltvaerelse, 3, 3);
		txfdobbeltvaerelse.setPrefWidth(200);

		lblHoteller = new Label("Hoteller:");
		this.add(lblHoteller, 0, 1, 3, 1);

		lvwHoteller = new ListView<>();
		this.add(lvwHoteller, 0, 2, 2, 4);
		lvwHoteller.setPrefWidth(200);
		lvwHoteller.setPrefHeight(200);
		lvwHoteller.getItems().addAll(Controller.getHotel());
		ChangeListener<Hotel> listener = (ov, oldEmployee, newEmployee) -> this.selectedHotelChanged();
		lvwHoteller.getSelectionModel().selectedItemProperty().addListener(listener);

		lblTilknyttetServiceYdelser = new Label("Tilknyttet Yedelser:");
		this.add(lblTilknyttetServiceYdelser, 2, 5);

		txfTilknyttetServiceYdelser = new TextArea();
		this.add(txfTilknyttetServiceYdelser, 3, 5);
		txfTilknyttetServiceYdelser.setPrefWidth(200);
		txfTilknyttetServiceYdelser.setPrefHeight(50);

		lblTilknyttetServiceYdelser = new Label("Oprettet Yedelser:");
		this.add(lblTilknyttetServiceYdelser, 4, 2);

		lvwOprettetServiceydelser = new ListView<>();
		this.add(lvwOprettetServiceydelser, 5, 2, 2, 4);
		lvwOprettetServiceydelser.setPrefWidth(200);
		lvwOprettetServiceydelser.setPrefHeight(200);
		lvwOprettetServiceydelser.getItems().addAll(Controller.getServiceydelse());

		HBox hbxButtons = new HBox(40);
		this.add(hbxButtons, 0, 6, 3, 1);
		hbxButtons.setPadding(new Insets(10, 0, 0, 0));
		hbxButtons.setAlignment(Pos.BASELINE_CENTER);

		btnOpret = new Button("Opret");
		hbxButtons.getChildren().add(btnOpret);
		btnOpret.setOnAction(event -> this.opretHotelAction());

		btnSlet = new Button("Slet");
		hbxButtons.getChildren().add(btnSlet);
		btnSlet.setOnAction(event -> this.sletHotelAction());

		btnOpdater = new Button("Opdater");
		hbxButtons.getChildren().add(btnOpdater);
		btnOpdater.setOnAction(event -> this.opdaterHotelAction());

		HBox hbxButtonsService = new HBox(40);
		this.add(hbxButtonsService, 5, 6, 2, 1);
		hbxButtonsService.setPadding(new Insets(10, 0, 0, 0));
		hbxButtonsService.setAlignment(Pos.BASELINE_CENTER);

		btnSletYedelse = new Button("Slet Ydelse");
		hbxButtonsService.getChildren().add(btnSletYedelse);
		btnSletYedelse.setOnAction(event -> this.sletYdelseAction());

		btnOpretServiceydelse = new Button("Opret Service");
		hbxButtonsService.getChildren().add(btnOpretServiceydelse);
		btnOpretServiceydelse.setOnAction(event -> this.opretServiceAction());
	}

	private ArrayList<Hotel> initAllEmpList() {
		ArrayList<Hotel> list = new ArrayList<>();
		for (Hotel hotel : Controller.getHotel()) {
			list.add(hotel);
		}
		return list;
	}

	private ArrayList<Serviceydelse> initAllServiceList() {
		ArrayList<Serviceydelse> list = new ArrayList<>();
		for (Serviceydelse serviceydelse : Controller.getServiceydelse()) {
			list.add(serviceydelse);
		}
		return list;
	}

	// ------------------------------------------------------------------------------------------

	private void opretHotelAction() {
		OpretHotelWindow dia = new OpretHotelWindow("Opret Hotel");
		dia.showAndWait();

		lvwHoteller.getItems().setAll(this.initAllEmpList());
		this.updateControls();

	}

	private void sletHotelAction() {
		Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();
		if (hotel == null) {
			return;
		}

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Slet Hotel");
		// alert.setContentText("Are you sure?");
		alert.setHeaderText("Er du sikker?");
		Optional<ButtonType> result = alert.showAndWait();

		// Wait for the modal dialog to close

		if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
			Controller.deleteHotel(hotel);
			lvwHoteller.getItems().setAll(this.initAllEmpList());
			this.updateControls();
		}

	}

	private void opdaterHotelAction() {
		Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();
		if (hotel == null) {
			return;
		}

		OpretHotelWindow dia = new OpretHotelWindow("Update Employee", hotel);
		dia.showAndWait();

		// Wait for the modal dialog to close

		int selectIndex = lvwHoteller.getSelectionModel().getSelectedIndex();
		lvwHoteller.getItems().setAll(this.initAllEmpList());
		lvwHoteller.getSelectionModel().select(selectIndex);
	}

	// ------------------------------------------------------------------------------------------

	private void selectedHotelChanged() {
		this.updateControls();
	}

	public void updateControls() {
		Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();
		if (hotel != null) {
			txfTilknyttetServiceYdelser.clear();
			txfenkeltvaerelse.setText("" + hotel.getEnkeltvaerelse());
			txfdobbeltvaerelse.setText("" + hotel.getDobbeltvaerelse());
			StringBuilder sb = new StringBuilder();
			System.out.println(hotel.getServiceydelse().size());
			for (Serviceydelse element : hotel.getServiceydelse()) {
				sb.append(element + "\n");

			}
			txfTilknyttetServiceYdelser.setText(sb.toString());
		} else {
			txfenkeltvaerelse.clear();
			txfdobbeltvaerelse.clear();

		}
	}

	// ---Serviceydelser---------------------------------------------------------------------------------------

	private void opretServiceAction() {
		OpretServiceydelseWindow dia = new OpretServiceydelseWindow("Opret Serviceydelse");
		dia.showAndWait();

		lvwOprettetServiceydelser.getItems().setAll(this.initAllServiceList());
		this.updateControls();

	}

	private void sletYdelseAction() {
		Serviceydelse serviceydelse = lvwOprettetServiceydelser.getSelectionModel().getSelectedItem();
		if (serviceydelse == null) {
			return;
		}

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Slet Serviceydelse");
		// alert.setContentText("Are you sure?");
		alert.setHeaderText("Er du sikker?");
		Optional<ButtonType> result = alert.showAndWait();

		// Wait for the modal dialog to close

		if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
			Controller.deleteServiceydelse(serviceydelse);
			lvwOprettetServiceydelser.getItems().setAll(this.initAllServiceList());
			this.updateControls();
		}

	}
	
	

}
