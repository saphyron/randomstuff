package gui;

import java.time.LocalDate;
import application.Betallingsmetode;
import application.Kvittering;
import application.KvitteringsLinje;
import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;

public class RegnskabsPane extends GridPane {

	private Controller controller = Controller.getSingletonIntance();
	private ListView<Kvittering> lsvKvitteringer;
	private ListView<KvitteringsLinje> lsvProduktListe;
	private Button btnHentRegnskab, btnHentAlleRegnskab;
	private DatePicker datoFra, datoTil;
	private HBox hBoxKundeInfo, hBoxSalgsInfo, hBoxSalgsStatus;
	private TextField txtKundeNavn, txtKundeNr, txtSalgsDato, txtSalgsTid;
	private TextField txtBetalingsMetode, txtBetalingsStatus, txtNettoPris;
	private TextField txtIsStudent, txtisErhverv;
	private TextField txtAntalKlip, txtAntalKlippekort;

	private Label lblSum;
	private Label lblSolgtePrisers;
	private Label lblMestSolgePris;

	public RegnskabsPane() {

		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		// -----------------------

		datoFra = new DatePicker();
		datoFra.setMinWidth(211.5);
		this.add(datoFra, 0, 0);
		datoTil = new DatePicker();
		datoTil.setMinWidth(211.5);
		this.add(datoTil, 0, 1);
		lsvKvitteringer = new ListView<Kvittering>();
		this.add(lsvKvitteringer, 0, 2);
		btnHentAlleRegnskab = new Button("Hent alle Regnskaber");
		btnHentRegnskab = new Button("Hent Regnskab for Periode");
		
		btnHentAlleRegnskab.setMinWidth(211.5);
		btnHentRegnskab.setMinWidth(211.5);
		this.add(btnHentAlleRegnskab, 0, 3);
		this.add(btnHentRegnskab, 0, 4);
		lsvKvitteringer.setMinHeight(255);
		lsvKvitteringer.setMinWidth(211.5);
		lsvKvitteringer.setOnMouseClicked(event -> hentKundeInformation());
		btnHentAlleRegnskab.setOnAction(event -> hentRegnskab());
		btnHentRegnskab.setOnAction(event -> hentRegnskabPeriode());

		// -----------------------

		Label lblProduktListe = new Label("Produkt Liste: ");
		this.add(lblProduktListe, 1, 0);
		lsvProduktListe = new ListView<KvitteringsLinje>();
		this.add(lsvProduktListe, 1, 2);

		// -----------------------row

		VBox vBoxKundeData = new VBox();
		Label lblKundeInformation = new Label("Kunde Information: ");
		this.add(vBoxKundeData, 3, 1, 1, 11);
		hBoxKundeInfo = new HBox();
		txtKundeNavn = new TextField();
		txtKundeNavn.setPromptText("Kunde Navn: ");
		txtKundeNavn.setEditable(false);
		txtKundeNavn.setMouseTransparent(true);
		txtKundeNavn.setFocusTraversable(false);
		txtKundeNr = new TextField();
		txtKundeNr.setPromptText("Kunde Nummer: ");
		txtKundeNr.setEditable(false);
		txtKundeNr.setMouseTransparent(true);
		txtKundeNr.setFocusTraversable(false);
		hBoxKundeInfo.getChildren().addAll(txtKundeNavn, txtKundeNr);
		HBox hBoxKundeType = new HBox();
		txtIsStudent = new TextField();
		txtIsStudent.setPromptText("Student: ");
		txtIsStudent.setEditable(false);
		txtIsStudent.setMouseTransparent(true);
		txtIsStudent.setFocusTraversable(false);
		txtisErhverv = new TextField();
		txtisErhverv.setPromptText("Erhverv: ");
		txtisErhverv.setEditable(false);
		txtisErhverv.setMouseTransparent(true);
		txtisErhverv.setFocusTraversable(false);
		hBoxKundeType.getChildren().addAll(txtIsStudent, txtisErhverv);

		Label lblSalgsInformation = new Label("Salgs Information: ");
		hBoxSalgsInfo = new HBox();
		txtSalgsDato = new TextField();
		txtSalgsDato.setPromptText("Salgs Dato: ");
		txtSalgsDato.setEditable(false);
		txtSalgsDato.setMouseTransparent(true);
		txtSalgsDato.setFocusTraversable(false);
		txtSalgsTid = new TextField();
		txtSalgsTid.setPromptText("Salgs Tidspunkt: ");
		txtSalgsTid.setEditable(false);
		txtSalgsTid.setMouseTransparent(true);
		txtSalgsTid.setFocusTraversable(false);
		hBoxSalgsInfo.getChildren().addAll(txtSalgsDato, txtSalgsTid);

		Label lblBetalingsInformation = new Label("Betalings Information: ");
		hBoxSalgsStatus = new HBox();
		txtBetalingsMetode = new TextField();
		txtBetalingsMetode.setPromptText("Betalings Metode: ");
		txtBetalingsMetode.setEditable(false);
		txtBetalingsMetode.setMouseTransparent(true);
		txtBetalingsMetode.setFocusTraversable(false);
		txtBetalingsStatus = new TextField();
		txtBetalingsStatus.setPromptText("Betalings Status: ");
		txtBetalingsStatus.setEditable(false);
		txtBetalingsStatus.setMouseTransparent(true);
		txtBetalingsStatus.setFocusTraversable(false);
		hBoxSalgsStatus.getChildren().addAll(txtBetalingsMetode, txtBetalingsStatus);

		Label lblNettoPris = new Label("Pris af salg: ");
		txtNettoPris = new TextField();
		txtNettoPris.setPromptText("Netto Pris: ");
		txtNettoPris.setEditable(false);
		txtNettoPris.setMouseTransparent(true);
		txtNettoPris.setFocusTraversable(false);
		Label lblKlippekort = new Label("Klippekort: ");
		HBox hBoxKlippeKort = new HBox();
		txtAntalKlippekort = new TextField();
		txtAntalKlippekort.setPromptText("Antal Klippekort: ");
		txtAntalKlippekort.setEditable(false);
		txtAntalKlippekort.setMouseTransparent(true);
		txtAntalKlippekort.setFocusTraversable(false);
		txtAntalKlip = new TextField();
		txtAntalKlip.setPromptText("Antal Klip: ");
		txtAntalKlip.setEditable(false);
		txtAntalKlip.setMouseTransparent(true);
		txtAntalKlip.setFocusTraversable(false);
		hBoxKlippeKort.getChildren().addAll(txtAntalKlippekort, txtAntalKlip);
		
		lblSum = new Label("");
		lblSolgtePrisers = new Label("");
		lblMestSolgePris = new Label("");
		
		vBoxKundeData.getChildren().addAll(lblKundeInformation, hBoxKundeInfo, hBoxKundeType,
				lblSalgsInformation, hBoxSalgsInfo, lblBetalingsInformation, hBoxSalgsStatus, 
				lblNettoPris, txtNettoPris, lblKlippekort, hBoxKlippeKort,
				new Label("Sum (efter moms):"), lblSum,
				new Label("Antal Solgte priser:"), lblSolgtePrisers,
				new Label("Mest solgte Pris:"), lblMestSolgePris);
		
		

	}
	
	private void UdregnIndtjenesteEfterMoms() {
		lblSum.setText("" + controller.UdregnIndtjenesteEfterMoms());
	}
	
	private void AntalSolgtePriser() {
		lblSolgtePrisers.setText(""+controller.getAntalPriserSolg());
	}
	
	private void MestSolgtePrir() {
		lblMestSolgePris.setText(controller.mestSolgtePris());
	}
	
	private void hentRegnskab() {
		lsvKvitteringer.getItems().clear();
		lsvKvitteringer.getItems().addAll(controller.getBetalingsKvitteringer());

		double antalKlippekort = 0.00;
		double nettoPris = 0.00;
		double antalKlip = 0.00;
		
		for (Kvittering kt : controller.getBetalingsKvitteringer()) {
			if(kt.getBetallingsmetode().equals(Betallingsmetode.KLIPPEKORT)) {
				antalKlippekort++;
				nettoPris += kt.getNettoPris();
			}
		}
		antalKlip = nettoPris / 25;
		String klippekort = "" + antalKlippekort;
		String klip = "" + antalKlip;
		
		txtAntalKlip.clear();
		txtAntalKlippekort.clear();
		txtAntalKlip.setText(klip);
		txtAntalKlippekort.setText(klippekort);

	}

	private void hentRegnskabPeriode() {
		lsvKvitteringer.getItems().clear();
		LocalDate ldDatoFra = datoFra.getValue();
		LocalDate ldDatoTil = datoTil.getValue();
		if (ldDatoFra == null || ldDatoTil == null) {
			return;
		}
		for (Kvittering kvittering : controller.getBetalingsKvitteringer()) {
			if (kvittering.getDatoForBetalling().isBefore(ldDatoTil)
					&& kvittering.getDatoForBetalling().isAfter(ldDatoFra)) {
				lsvKvitteringer.getItems().add(kvittering);
			}
		}
	}

	private void hentKundeInformation() {
		Kvittering kvittering = lsvKvitteringer.getSelectionModel().getSelectedItem();
		if (kvittering == null) {
			return;
		}
		
		
		String navn = kvittering.getKunde().getNavn();
		String kundeNr = "" + kvittering.getKunde().getKundeNr();
		String dato = kvittering.getDatoForBetalling().toString();
		String tid = kvittering.getTidForBetalling().toString();
		String metode = kvittering.getBetallingsmetode().toString();
		String status = "Ja";
		String nettoPris = "" + kvittering.getNettoPris();
		String student = "" + kvittering.getKunde().getIsStudent();
		String erhverv = "" + kvittering.getKunde().isErhverv();


		lsvProduktListe.getItems().clear();
		txtKundeNavn.clear();
		txtKundeNr.clear();
		txtSalgsDato.clear();
		txtSalgsTid.clear();
		txtBetalingsMetode.clear();
		txtBetalingsStatus.clear();
		txtNettoPris.clear();
		txtIsStudent.clear();
		txtisErhverv.clear();

		lsvProduktListe.getItems().addAll(kvittering.getKvitteringsLinjer());
		txtKundeNavn.setText(navn);
		txtKundeNr.setText(kundeNr);
		txtSalgsDato.setText(dato);
		txtSalgsTid.setText(tid);
		txtBetalingsMetode.setText(metode);
		txtBetalingsStatus.setText(status);
		txtNettoPris.setText(nettoPris);
		txtIsStudent.setText(student);
		txtisErhverv.setText(erhverv);

	}

	public void updateControls() {
		 UdregnIndtjenesteEfterMoms();
		 AntalSolgtePriser();
		 MestSolgtePrir();
	}
}
