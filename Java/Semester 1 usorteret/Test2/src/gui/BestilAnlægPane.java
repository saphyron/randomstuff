package gui;

import application.Kunde;
import application.Kvittering;
import application.KvitteringsLinje;
import application.Pris;
import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.control.TextField;

public class BestilAnlægPane extends GridPane {

	private Controller controller = Controller.getSingletonIntance();
	private ListView<Pris> lsvPriser;
	private DatePicker dtpBookingDato;
	private ListView<KvitteringsLinje> lsvKvittering;
	private Label lblNettoPrisVærdi;
	private TextField txfAntalPris; 
	private Kvittering currentKvittering;
	private Kunde kunde;
	private Label lblKunde;
	private TextField txfKundenr;
	private Button btnFjernKvitteringsLinje;
	private Label lblInfo;
	
	public BestilAnlægPane() {
		
		Region[] regions = new Region[20];
		for (int i = 0; i < regions.length; i++) {
			regions[i] =  new Region();
			HBox.setHgrow(regions[i], Priority.ALWAYS);
		} 
		
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		// -----------------------
		// Produktlinje
		// -----------------------

		lsvPriser = new ListView<Pris>();
		this.add(lsvPriser, 0, 0,1,3);
		

		
		txfAntalPris = new TextField();
		txfAntalPris.setPromptText("antal");
		txfAntalPris.setPrefWidth(50.0);
		
		HBox hbxTilføjPrisTilKvittering = new HBox(5);
		Button btnTilføj = new Button("Tilføj");
		btnTilføj.setOnAction(event -> tilføjPrisTilKvitting());
		hbxTilføjPrisTilKvittering.getChildren().addAll(txfAntalPris, btnTilføj);
		
		this.add(hbxTilføjPrisTilKvittering, 0, 3);
		
		// --------------------------------------
		
		HBox hboxTest2 = new HBox(5);
	 	txfKundenr = new TextField();
	 	txfKundenr.setPromptText("Kunde nr");
	 	txfKundenr.setPrefWidth(105.0);
	 	hboxTest2.setAlignment(Pos.CENTER);
	 	Button btnSøg = new Button("Søg");
	 	btnSøg.setOnAction(event -> søgKunde());
	 	lblKunde = new Label("Kunde: ???");
	 	
	 	hboxTest2.getChildren().addAll(txfKundenr, btnSøg, lblKunde, regions[0]);
	 	this.add(hboxTest2, 3, 0);
	 	
	 	//-----------------------
	 	
		Button btnSpecialAftalPris = new Button("Special pris⬈");
		btnSpecialAftalPris.setOnAction(event -> speicalAftalPris());
		btnFjernKvitteringsLinje = new Button("Fjern");
	 	
		HBox hbxKvitteringBtns = new HBox(5);
		hbxKvitteringBtns.getChildren().addAll(btnSpecialAftalPris, regions[1], btnFjernKvitteringsLinje);
		
		//btnSpcialAftalPris.setOnAction(event -> setPrisForKvitteringslinje());
		btnFjernKvitteringsLinje.setOnAction(event -> fjernKvitteringsLinje());
		this.add(hbxKvitteringBtns, 3, 1, 1, 1); 
		
		lsvKvittering = new ListView<KvitteringsLinje>();
		lsvKvittering.setPrefWidth(300.0);
		this.add(lsvKvittering, 3, 2, 1, 1);
		
		//-------
		
		HBox bhxNettoPris = new HBox(5.0);
		lblNettoPrisVærdi = new Label("0 kr");
		
		bhxNettoPris.getChildren().addAll(regions[2], new Label("Nettopris: "),  lblNettoPrisVærdi);
		bhxNettoPris.setAlignment(Pos.CENTER);
		this.add(bhxNettoPris, 3, 3);
		
		HBox bhxBetal = new HBox(5.0);
		Button btnBetal = new Button("Lej anlæg"); 
		btnBetal.setOnAction(event -> tilføjUbetaltKvittering());
		
		dtpBookingDato = new DatePicker();
		
		
		bhxBetal.getChildren().addAll(dtpBookingDato, regions[3],  btnBetal);
		this.add(bhxBetal, 3, 4);
		lblInfo = new Label();
		this.add(lblInfo, 0, 6);
	}
	
	public void tilføjUbetaltKvittering() {
		
		if (currentKvittering == null) {
			return;
		}
		if (currentKvittering.getKvitteringsLinjer().size() == 0) {
			return;
		}
		if (kunde == null) {
			return;
		}
		if (dtpBookingDato.getValue() == null) {
			return;
		}
		try {
			currentKvittering.setSenestBetallingsDato(dtpBookingDato.getValue());	
		}
		catch (IllegalArgumentException e) {
			lblInfo.setText(e.getMessage());
		}
		
		controller.addUbetaltKvitteringer(currentKvittering);
		currentKvittering = new Kvittering(kunde);
		lsvKvittering.getItems().clear();
		dtpBookingDato.getEditor().clear();
		printNettoPris();
	}

	private void tilføjPrisTilKvitting() {
			
		Pris valgtePris = lsvPriser.getSelectionModel().getSelectedItem();
			
		if (valgtePris == null) {
			lblInfo.setText("Vælg en pris");
			return;
		}
		
		lsvPriser.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, null, null)));
		
		String strAntalPris = txfAntalPris.getText();
		Integer antal;
		try {
			antal = Integer.parseInt(strAntalPris);
		}
		catch (NumberFormatException e) {
			txfAntalPris.setStyle("-fx-text-box-border: red ;");
			return;
		}
		
		if (currentKvittering == null) {
			lblInfo.setText("ingen kvittering");
			return;
		}
		try {
			currentKvittering.addKvitteringsLinje(valgtePris, antal);	
		}
		catch (IllegalArgumentException e) {
			lblInfo.setText(e.getMessage());
			return;
		}
		lsvKvittering.getItems().clear();
		lsvKvittering.getItems().addAll(currentKvittering.getKvitteringsLinjer());
		
		//txfAntalPris.setText("");
		txfAntalPris.setStyle("fx-text-box-border: lightgrey ;");
		//lblErr.setText("");
		printNettoPris();
		
	}


	public void updateControls() {
		lsvPriser.getItems().clear();
		lsvPriser.getItems().addAll(controller.getAnlægProdukter());
	}
	
	private void speicalAftalPris() {
		
		KvitteringsLinje markeredeKvitteringsLinje = lsvKvittering.getSelectionModel().getSelectedItem();
		
		if (markeredeKvitteringsLinje == null) {
			//lsvPriser.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
			lblInfo.setText("Vælg en pris");
			return;
		}
		
		SpecialAftalPrisWindow specialAftalPrisWindow = new SpecialAftalPrisWindow(markeredeKvitteringsLinje);
		specialAftalPrisWindow.showAndWait();
		
		try {
			lsvKvittering.getItems().clear();
			lsvKvittering.getItems().addAll(currentKvittering.getKvitteringsLinjer());
		}
		catch (Exception e) {
			System.out.println("kan ikke fremvise kvittering, metode speicalAftalPris()");
		}

		printNettoPris();
		
	}
	
private void søgKunde(int kundeNr) {
		
	kunde = controller.søgKunde(kundeNr);
		
		if (kunde == null) {
			lblInfo.setText("kunde er null");
			return;
		}
		
				
		lblKunde.setText("Kunde: " + kunde.getNavn());
		
		if (currentKvittering == null) {
			currentKvittering = new Kvittering(kunde);
		}
		
		currentKvittering.setKunde(kunde);
	}
	private void søgKunde() {
		int kundeNr;
		
		try {
			kundeNr = Integer.parseInt(txfKundenr.getText());
		}
		catch (Exception e) { // fix rigtige exception
			lblInfo.setText("Ugyldig tal i textfield");
			return;
		}
		søgKunde(kundeNr);
		printNettoPris();
	}
	
	private void fjernKvitteringsLinje() {
		
		if (currentKvittering == null) {
			return;
		}
		KvitteringsLinje markeredeKvitteringsLinje = lsvKvittering.getSelectionModel().getSelectedItem();
		if (markeredeKvitteringsLinje == null) {
			System.out.println("Vælg en pris");
			return;
		}
		currentKvittering.removeKvitteringsLinje(markeredeKvitteringsLinje);
		lsvKvittering.getItems().clear();
		lsvKvittering.getItems().addAll(currentKvittering.getKvitteringsLinjer());
		printNettoPris();
		
	}
	
	public void printNettoPris() {
		if (currentKvittering == null) {
			return;
		}
		
		String nettoPris = ""+currentKvittering.getNettoPris();
		String rabatType = currentKvittering.getKunde().getRabatType();
		
		if (!rabatType.equals("")) {
			nettoPris += " (" + rabatType + ")";
		}
		
		lblNettoPrisVærdi.setText(nettoPris);
	}
	
}
