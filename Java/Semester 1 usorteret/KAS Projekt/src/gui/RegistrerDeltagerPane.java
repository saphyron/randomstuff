package gui;

import java.util.ArrayList;
import java.util.Optional;

import javafx.beans.value.ChangeListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import model.Booking_hotel;
import model.Booking_konference;
import model.Deltager;
import model.Konference;
import model.Ledsager;
import model.Serviceydelse;
import model.Udflugt;
import model.Hotel;
import controller.Controller;
import storage.Storage;

public class RegistrerDeltagerPane extends GridPane {

	private ListView<Udflugt> lvwLedsagerInformation;
	private ObservableList<Udflugt> lvwLedsagerSelected;
	private ObservableList<Serviceydelse> lvwOvernatningSelected;
	private ListView<Serviceydelse> lvwOvernatningsOensker;
	private Label lblDeltagerInformation, lblLedsagerInformation, lblOvernatningsOensker;
	private Label lblDeltagernavn, lblAddresse, lblBy, lblLand, lblTlfNummer, lblAnkomstDato;
	private Label lblAfrejseDato, lblFirmaNavn, lblFirmaTlfNummer, lblForedragsHolder;
	private Label lblReserverHotel, lblMedtagLedsager, lblKonferencer;
	private Label lblLedsagerNavn, lblMuligeUdflugter, lblHoteller, lblMuligeServiceYdelser, lblTotalPris;
	private TextField txfDeltagernavn, txfAddresse, txfBy, txfFirmaTlfNummer, txfLand, txfTlfNummer, txfAnkomstDato,
			txfAfrejseDato, txfFirmaNavn, txfLedsagerNavn, txfTotalPris;
	private CheckBox chbForedragsHolder, chbLedsager, chbOvernatning;
	private Button btnTilmeld, btnAfmeld, btnOpdater;
	private LocalDate dato = LocalDate.of(2019, 5, 18);
	private ComboBox<Hotel> cbxHoteller;
	private ComboBox<Konference> cbxKonferencer;
	private Deltager deltager;
	private Ledsager ledsager;
	private Serviceydelse serviceydelse;
	private Udflugt udflugt;
	private Booking_konference booking;
	private Konference konference;
	private ArrayList<Konference> chosenKonference;
	private Booking_hotel booking_hotel;
	private Hotel hotel;
	private LocalDate ankomstdato;
	private LocalDate afrejsedato;

	public RegistrerDeltagerPane() {

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

		GridPane ledsagerPane = new GridPane();
		this.add(ledsagerPane, 1, 0);
		ledsagerPane.setGridLinesVisible(false);
		ledsagerPane.setPadding(new Insets(10));
		ledsagerPane.setHgap(10);
		ledsagerPane.setVgap(10);
		ledsagerPane.setStyle("-fx-border-color: black");

		GridPane overnatningsOenskerPane = new GridPane();
		this.add(overnatningsOenskerPane, 2, 0);
		overnatningsOenskerPane.setGridLinesVisible(false);
		overnatningsOenskerPane.setPadding(new Insets(10));
		overnatningsOenskerPane.setHgap(10);
		overnatningsOenskerPane.setVgap(10);
		overnatningsOenskerPane.setStyle("-fx-border-color: black");

		// ---------------------------------------

		lblDeltagerInformation = new Label("DeltagerInformation:");
		deltagerPane.add(lblDeltagerInformation, 0, 0, 4, 1);

		lblKonferencer = new Label("Konferencer:");
		deltagerPane.add(lblKonferencer, 0, 1);
		cbxKonferencer = new ComboBox<>();
		deltagerPane.add(cbxKonferencer, 1, 1);

		lblTotalPris = new Label("Total Pris:");
		deltagerPane.add(lblTotalPris, 2, 1);
		txfTotalPris = new TextField();
		deltagerPane.add(txfTotalPris, 3, 1);

		cbxKonferencer.setPromptText("Konferencer");
		cbxKonferencer.getItems().addAll(Controller.getKonferencer());
		cbxKonferencer.setOnAction(event -> this.chooseKonference());

		lblDeltagernavn = new Label("Deltagernavn:");
		deltagerPane.add(lblDeltagernavn, 0, 2);
		lblAddresse = new Label("Adresse:");
		deltagerPane.add(lblAddresse, 2, 2);
		lblBy = new Label("By:");
		deltagerPane.add(lblBy, 0, 3);
		lblLand = new Label("Land:");
		deltagerPane.add(lblLand, 2, 3);
		lblAnkomstDato = new Label("Andkomstdato:");
		deltagerPane.add(lblAnkomstDato, 0, 4);
		lblAfrejseDato = new Label("Afrejsedato:");
		deltagerPane.add(lblAfrejseDato, 2, 4);
		lblTlfNummer = new Label("Tlf.nr:");
		deltagerPane.add(lblTlfNummer, 0, 5);
		lblForedragsHolder = new Label("Foredragsholder:");
		deltagerPane.add(lblForedragsHolder, 2, 5);
		lblFirmaNavn = new Label("Firmanavn:");
		deltagerPane.add(lblFirmaNavn, 0, 6);
		lblFirmaTlfNummer = new Label("Firma tlf.nr:");
		deltagerPane.add(lblFirmaTlfNummer, 2, 6);

		txfDeltagernavn = new TextField();
		deltagerPane.add(txfDeltagernavn, 1, 2);
		txfAddresse = new TextField();
		deltagerPane.add(txfAddresse, 3, 2);
		txfBy = new TextField();
		deltagerPane.add(txfBy, 1, 3);
		txfLand = new TextField();
		deltagerPane.add(txfLand, 3, 3);
		txfAnkomstDato = new TextField();
		deltagerPane.add(txfAnkomstDato, 1, 4);
		txfAfrejseDato = new TextField();
		deltagerPane.add(txfAfrejseDato, 3, 4);
		txfTlfNummer = new TextField();
		deltagerPane.add(txfTlfNummer, 1, 5);
		chbForedragsHolder = new CheckBox();
		deltagerPane.add(chbForedragsHolder, 3, 5);
		txfFirmaNavn = new TextField();
		deltagerPane.add(txfFirmaNavn, 1, 6);
		txfFirmaTlfNummer = new TextField();
		deltagerPane.add(txfFirmaTlfNummer, 3, 6);

		lblReserverHotel = new Label("Reserver Hotel?");
		deltagerPane.add(lblReserverHotel, 2, 7);
		lblMedtagLedsager = new Label("Medtag Ledsager?");
		deltagerPane.add(lblMedtagLedsager, 0, 7);
		chbLedsager = new CheckBox();
		deltagerPane.add(chbLedsager, 1, 7);
		chbOvernatning = new CheckBox();
		deltagerPane.add(chbOvernatning, 3, 7);

		chbLedsager.setOnAction(event -> {
			if (chbLedsager.isSelected()) {
				txfLedsagerNavn.setDisable(false);
				lvwLedsagerInformation.setDisable(false);
			} else {
				txfLedsagerNavn.setDisable(true);
				lvwLedsagerInformation.setDisable(true);
			}
		});

		chbOvernatning.setOnAction(event -> {
			if (chbOvernatning.isSelected()) {
				cbxHoteller.setDisable(false);
				lvwOvernatningsOensker.setDisable(false);
			} else {
				cbxHoteller.setDisable(true);
				lvwOvernatningsOensker.setDisable(true);
			}
		});

		// ---------------------------------------

		lblLedsagerInformation = new Label("LedsagerInformation:");
		ledsagerPane.add(lblLedsagerInformation, 0, 0, 3, 1);

		lblLedsagerNavn = new Label("Navn:");
		ledsagerPane.add(lblLedsagerNavn, 0, 1);
		txfLedsagerNavn = new TextField();
		ledsagerPane.add(txfLedsagerNavn, 1, 1);
		txfLedsagerNavn.setDisable(true);

		lblMuligeUdflugter = new Label("Mulige Udflugter");
		ledsagerPane.add(lblMuligeUdflugter, 0, 2, 3, 1);
		lvwLedsagerInformation = new ListView<>();
		ledsagerPane.add(lvwLedsagerInformation, 0, 3, 3, 4);
		lvwLedsagerInformation.setPrefWidth(200);
		lvwLedsagerInformation.setPrefHeight(200);
		// lvwLedsagerInformation.getItems().setAll(Controller.getUdflugt());

		lvwLedsagerInformation.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		lvwLedsagerInformation.getSelectionModel().selectedItemProperty().addListener((obs, ov, nv) -> {
			lvwLedsagerSelected = lvwLedsagerInformation.getSelectionModel().getSelectedItems();
		});
		lvwLedsagerInformation.setDisable(true);

		// ---------------------------------------

		lblOvernatningsOensker = new Label("Overnatningsønsker:");
		overnatningsOenskerPane.add(lblOvernatningsOensker, 0, 0, 3, 1);

		lblHoteller = new Label("Hoteller:");
		overnatningsOenskerPane.add(lblHoteller, 0, 1);
		cbxHoteller = new ComboBox<>();
		overnatningsOenskerPane.add(cbxHoteller, 1, 1);
		cbxHoteller.setDisable(true);

		cbxHoteller.setPromptText("Hoteller");
		cbxHoteller.setOnAction(event -> this.chooseHotel());

		lblMuligeServiceYdelser = new Label("Mulige Serviceydelser");
		overnatningsOenskerPane.add(lblMuligeServiceYdelser, 0, 2, 3, 1);
		lvwOvernatningsOensker = new ListView<>();
		overnatningsOenskerPane.add(lvwOvernatningsOensker, 0, 3, 3, 4);
		lvwOvernatningsOensker.setPrefWidth(200);
		lvwOvernatningsOensker.setPrefHeight(200);
		// lvwOvernatningsOensker.getItems().setAll(Controller.getServiceydelse());
		lvwOvernatningsOensker.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		lvwOvernatningsOensker.getSelectionModel().selectedItemProperty().addListener((obs, ov, nv) -> {
			lvwOvernatningSelected = lvwOvernatningsOensker.getSelectionModel().getSelectedItems();
		});
		lvwLedsagerInformation.setDisable(true);
		lvwOvernatningsOensker.setDisable(true);

		HBox hbxButtons = new HBox(40);
		this.add(hbxButtons, 0, 1, 3, 1);
		hbxButtons.setPadding(new Insets(10, 0, 0, 0));
		hbxButtons.setAlignment(Pos.BASELINE_CENTER);

		btnTilmeld = new Button("Tilmeld");
		hbxButtons.getChildren().add(btnTilmeld);
		btnTilmeld.setOnAction(event -> this.TilmeldDeltagerAction());

		btnAfmeld = new Button("Afmeld");
		hbxButtons.getChildren().add(btnAfmeld);
		btnAfmeld.setOnAction(event -> this.AfmeldDeltagerAction());

		btnOpdater = new Button("Opdater");
		hbxButtons.getChildren().add(btnOpdater);
		btnOpdater.setOnAction(event -> this.opdaterDeltagerAction());

	}

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

	private void TilmeldDeltagerAction() {
		String deltagerNavn = txfDeltagernavn.getText().trim();
		if (deltagerNavn.length() != 0) {
			LocalDate slutdato = LocalDate.parse(txfAfrejseDato.getText().trim(), formatter);
			LocalDate startdato = LocalDate.parse(txfAnkomstDato.getText().trim(), formatter);
			Hotel tempHotelValg = cbxHoteller.getSelectionModel().getSelectedItem();
			Booking_hotel hotelValg = new Booking_hotel(tempHotelValg);
			Konference konferenceValg = cbxKonferencer.getSelectionModel().getSelectedItem();

			Deltager deltager = Controller.createDeltager(txfDeltagernavn.getText().trim(),
					txfTlfNummer.getText().trim(), txfAddresse.getText().trim(), txfBy.getText().trim(),
					txfLand.getText().trim(), chbForedragsHolder.isSelected());
			Controller.createBookingKonference(startdato, slutdato, hotelValg, deltager, konferenceValg);
			if (chbLedsager.isSelected()) {
				Udflugt udflugtValg = lvwLedsagerInformation.getSelectionModel().getSelectedItem();
				ledsager = new Ledsager(txfLedsagerNavn.getText().trim());
				ledsager.addUdflugt(udflugtValg);
				deltager.setLedsager(ledsager);
			}
			if (chbOvernatning.isSelected()) {
				Serviceydelse serviceYdelseValg = lvwOvernatningsOensker.getSelectionModel().getSelectedItem();
				hotelValg.addServiceydelse(serviceYdelseValg);

			}
			System.out.println(Controller.getDeltager());
			double ledsagerpris = 0;
			double værelsesPris = 0;
			double serviceYdelsePris = 0;
			double konferencePris = 0;
			double pris = 0;
			double daysBetween = ChronoUnit.DAYS.between(startdato, slutdato.plusDays(1));

			if (deltager.getLedsager() != null) {
				ledsagerpris = deltager.getLedsager().totalUdflugtspris();
			} else {
				ledsagerpris = 0;
			}

			// hotelværeslespris

			if (hotelValg.getHotel() != null) {
				if (deltager.getLedsager() != null) {
					værelsesPris = hotelValg.getHotel().getDobbeltvaerelse() * (daysBetween - 1);
				} else {
					værelsesPris = hotelValg.getHotel().getEnkeltvaerelse() * (daysBetween - 1);
				}

				// ydelsespris

				for (int i = 0; i < hotelValg.getServiceydelser().size(); i++) {
					if (hotelValg.getServiceydelser() != null) {
						serviceYdelsePris += hotelValg.getServiceydelser().get(i).getYdelsespris() * (daysBetween - 1);
					} else {
						serviceYdelsePris = 0;
					}
				}
			}

			double daysBetweenKonference = ChronoUnit.DAYS.between(startdato, slutdato.plusDays(1));

			if (deltager.getForedragsholder() == true) {
				konferencePris = 0;
			} else {

				konferencePris = konferenceValg.getPris() * daysBetweenKonference;
			}

			pris = ledsagerpris + værelsesPris + serviceYdelsePris + konferencePris;

			txfTotalPris.setText("" + pris);

			clearFields();
		}
	}

	private void AfmeldDeltagerAction() {
		String deltagerNavn = "";
		deltagerNavn = txfDeltagernavn.getText().trim();
		if (deltager.getNavn() == deltagerNavn) {
			Controller.deleteDeltager(deltager);
		}
		clearFields();
	}

	private void opdaterDeltagerAction() {
		String deltagerNavn = "";
		deltagerNavn = txfDeltagernavn.getText().trim();
		if (deltager.getNavn() == deltagerNavn) {
			Controller.updateDeltager(deltager, txfDeltagernavn.getText().trim(), txfTlfNummer.getText().trim(),
					txfAddresse.getText().trim(), txfBy.getText().trim(), txfLand.getText().trim(),
					chbForedragsHolder.isSelected());
		}
		clearFields();
	}

	private void clearFields() {
		txfDeltagernavn.clear();
		txfTlfNummer.clear();
		txfAddresse.clear();
		txfBy.clear();
		txfLand.clear();
		chbForedragsHolder.setSelected(false);
		chbLedsager.setSelected(false);
		chbOvernatning.setSelected(false);
		txfFirmaTlfNummer.clear();
		txfAfrejseDato.clear();
		txfAnkomstDato.clear();
		txfFirmaNavn.clear();
		txfLedsagerNavn.clear();
	}

	private void chooseKonference() {
		Konference konference = cbxKonferencer.getSelectionModel().getSelectedItem();

		// ---Udflugter-ListView----------------------------------------

		ArrayList<Udflugt> tempUdflugt = new ArrayList<>();
		for (Udflugt u : konference.getUdflugter()) {
			tempUdflugt.add(u);
		}

		lvwLedsagerInformation.getItems().setAll(tempUdflugt);
	}

	private void chooseHotel() {
		Hotel hoteller = cbxHoteller.getSelectionModel().getSelectedItem();

		// ---Serviceydelser-ListView----------------------------------------
		System.out.println(Controller.getServiceydelse());
		ArrayList<Serviceydelse> tempService = new ArrayList<>();

		for (Serviceydelse j : hoteller.getServiceydelse()) {
			tempService.add(j);
		}

		lvwOvernatningsOensker.getItems().setAll(tempService);

	}

	public void updateControls() {
		cbxHoteller.getItems().clear();
		cbxKonferencer.getItems().clear();

		ArrayList<Hotel> tempHoteller = new ArrayList<>();
		for (Hotel h : Controller.getHotel()) {
			tempHoteller.add(h);
		}
		cbxHoteller.getItems().addAll(tempHoteller);
		// cbxHoteller.getItems().addAll(Controller.getHotel());

		ArrayList<Konference> tempKonferencer = new ArrayList<>();
		for (Konference k : Controller.getKonferencer()) {
			tempKonferencer.add(k);
		}

		cbxKonferencer.getItems().addAll(tempKonferencer);
	}

}
