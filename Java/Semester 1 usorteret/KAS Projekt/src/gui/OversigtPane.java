package gui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Booking_hotel;
import model.Booking_konference;
import model.Deltager;
import model.Hotel;
import model.Konference;
import model.Ledsager;
import model.Udflugt;
import storage.Storage;
import controller.Controller;

public class OversigtPane extends GridPane {

	private ComboBox<Konference> cbxKonference;
	//private ListView<String> lvwDeltagere;
	private Deltager deltager;
	private Booking_konference booking;
	private Label lblKonference, lblHoteller, lblUdflugter, lblDeltagere;
	private Label lblNavnPaaDeltager, lblForedragsHolder, lblLedsagere, lblTotalPris;
	private TextField txfNavnPaaDeltager, txfForedragsHolder, txfTotalPris;
	private ListView lvwKonference, lvwHoteller, lvwUdflugter, lvwLedsagere, lvwDeltagere;

	public OversigtPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);
		
		GridPane deltagerPane = new GridPane();
		this.add(deltagerPane, 0, 0);
		deltagerPane.setGridLinesVisible(false);
		deltagerPane.setPadding(new Insets(10));
		deltagerPane.setHgap(10);
		deltagerPane.setVgap(10);
		deltagerPane.setStyle("-fx-border-color: black");
		
		GridPane udflugtPane = new GridPane();
		this.add(udflugtPane, 1, 0);
		udflugtPane.setGridLinesVisible(false);
		udflugtPane.setPadding(new Insets(10));
		udflugtPane.setHgap(10);
		udflugtPane.setVgap(10);
		udflugtPane.setStyle("-fx-border-color: black");
		
		GridPane hotelPane = new GridPane();
		this.add(hotelPane, 2, 0);
		hotelPane.setGridLinesVisible(false);
		hotelPane.setPadding(new Insets(10));
		hotelPane.setHgap(10);
		hotelPane.setVgap(10);
		hotelPane.setStyle("-fx-border-color: black");

		
		//---Konference + Deltagere--------------

		lblKonference = new Label("Alle deltagere for hver konference:");
		deltagerPane.add(lblKonference, 0, 0);
		cbxKonference = new ComboBox<>();
		deltagerPane.add(cbxKonference, 1, 0);
		
		cbxKonference.setPromptText("Konference");
		cbxKonference.getItems().addAll(Controller.getKonferencer());
		
		lblDeltagere = new Label("Deltagere:");
		deltagerPane.add(lblDeltagere, 0, 1);
		
		lvwDeltagere = new ListView();
		deltagerPane.add(lvwDeltagere, 0, 2, 2, 3);
		lvwDeltagere.setPrefWidth(200);
		lvwDeltagere.setPrefHeight(230);
		
		

		//---Udflugter---------------------------

		lblUdflugter = new Label("Udflugter og ledsagere til hver konference:");
		udflugtPane.add(lblUdflugter, 0, 0);
		
		lblUdflugter = new Label("Udflugter:");
		udflugtPane.add(lblUdflugter, 0, 3);
		
		lvwUdflugter = new ListView();
		udflugtPane.add(lvwUdflugter, 0, 4, 2, 1);
		lvwUdflugter.setPrefWidth(200);
		lvwUdflugter.setPrefHeight(80);

		
		lblLedsagere = new Label("Ledsagere:");
		udflugtPane.add(lblLedsagere, 0, 6);

		lvwLedsagere = new ListView();
		udflugtPane.add(lvwLedsagere, 0, 7, 2, 1);
		lvwLedsagere.setPrefWidth(200);
		lvwLedsagere.setPrefHeight(80);
		
		//---Ledsagere---------------------------
		
		lblHoteller = new Label("Deltagere og ledsagere til hver hotel for hver konference:");
		hotelPane.add(lblHoteller, 0, 0);

		lblLedsagere = new Label("Hoteller:");
		hotelPane.add(lblLedsagere, 0, 4);
		
		lvwHoteller = new ListView();
		hotelPane.add(lvwHoteller, 0, 5, 2, 1);
		lvwHoteller.setPrefWidth(200);
		lvwHoteller.setPrefHeight(100);

		
		/**
		 * ComboBox-action: skifter indholdet i alle ListViews
		 */
		cbxKonference.setOnAction(event -> this.chooseKonference());
		
		
	}
	
	private void selectedDeltagerChanged() {
		this.updateControls();
	}

	private void chooseKonference() {
		Konference konference = cbxKonference.getSelectionModel().getSelectedItem();

		// ---Deltagere-ListView----------------------------------------

		ArrayList<String> tmpDeltagere = new ArrayList<>();

		for (Booking_konference d : konference.getBooking_konferencer()) {
			tmpDeltagere.add(d.getDeltager().getNavn());
		}

		lvwDeltagere.getItems().setAll(tmpDeltagere);

		// ---Udflugter-ListView----------------------------------------

		ArrayList<String> tmpUdflugter = new ArrayList<>();

		for (Udflugt u : konference.getUdflugter()) {
			tmpUdflugter.add(u.getNavn());
		}

		lvwUdflugter.getItems().setAll(tmpUdflugter);

		// ---Ledsagere-ListView----------------------------------------

		ArrayList<String> tmpLedsagere = new ArrayList<>();

		for (Udflugt u : konference.getUdflugter()) {
			// TODO Skal ledsager indgå flere gange, hvis denne deltager i flere udflugter
			for (Ledsager l : u.getLedsager()) {
				tmpLedsagere.add(l.getNavn());
			}
		}

		lvwLedsagere.getItems().setAll(tmpLedsagere);

		// ---Hoteller-ListView----------------------------------------

		ArrayList<String> tmpHoteller = new ArrayList<>();

		for (Hotel h : konference.getHoteller()) {
			tmpHoteller.add(h.getNavn());
		}

		lvwHoteller.getItems().setAll(tmpHoteller);

	}

	public void updateControls() {
		//Deltager deltager = lvwDeltagere.getSelectionModel().getSelectedItem();
		if (deltager != null) {
			booking.totalPris();
		}
		cbxKonference.getItems().clear();
		ArrayList<Konference> tempKonference = new ArrayList<>();
		for (Konference kk : Controller.getKonferencer()) {
			tempKonference.add(kk);
		}
		cbxKonference.getItems().addAll(tempKonference);
	}

}
