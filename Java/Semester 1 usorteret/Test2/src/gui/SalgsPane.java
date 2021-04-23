package gui;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import application.Betallingsmetode;
import application.Kunde;
import application.Pris;
import application.Prisliste;
import application.ProduktType;
import application.Kvittering;
import application.KvitteringsLinje;
import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.TextField;

public class SalgsPane extends GridPane {
	
	private Controller controller = Controller.getSingletonIntance();
	private ComboBox<Betallingsmetode> cmbVælgBetalling;
	private ComboBox<Comparator<Pris>> cmbVælgComparator;
	private ComboBox<Prisliste> cmbVælgPrisliste;
	private ComboBox<ProduktType> cmbVælgProduktType; 
	private ListView<Pris> lsvPriser;
	private ListView<KvitteringsLinje> lsvKvittering;
	private TextField txfAntalPris, txfKundenr;
	private Label lblInfo, lblNettoPrisVærdi, lblKunde; 
	private VBox vbxProduktInfo;
	private CheckBox chbErStuderende, chbErGæst, chbErErhverv;
	
	public SalgsPane() {
		
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);
		
		Region[] regions = new Region[20];
		
		for (int i = 0; i < regions.length; i++) {
			regions[i] =  new Region();
			HBox.setHgrow(regions[i], Priority.ALWAYS);
		}
	
		// ----------------------
		this.add(new Label("Prisliste:"), 0, 0);
		cmbVælgPrisliste = new ComboBox<Prisliste>(); 
		cmbVælgPrisliste.setMaxWidth(Double.MAX_VALUE);
		cmbVælgPrisliste.getItems().addAll(controller.getPrislister());
		cmbVælgPrisliste.setOnAction(event -> updateProduktTypeUdfraPrisliste());
		this.add(cmbVælgPrisliste, 1, 0);
		// -----------------------
		this.add(new Label("Produkt type:"), 0, 1);
		cmbVælgProduktType = new ComboBox<ProduktType>(); 
		cmbVælgProduktType.setMaxWidth(Double.MAX_VALUE);
		cmbVælgProduktType.setDisable(true);
		cmbVælgProduktType.setOnAction(event -> visPriser());
		this.add(cmbVælgProduktType, 1, 1);
		//------------------------
		this.add(new Label("Sorter efter:"), 0, 2);
		cmbVælgComparator = new ComboBox<Comparator<Pris>>(); 
		cmbVælgComparator.setMaxWidth(Double.MAX_VALUE);
		cmbVælgComparator.getItems().addAll(controller.getComparators());
		cmbVælgComparator.setOnAction(event -> updateCompatator());
		if (cmbVælgComparator.getItems().size() > 0) {
			cmbVælgComparator.getSelectionModel().select(0);
			updateCompatator();
		}
		this.add(cmbVælgComparator, 1, 2);
		
		// ------------------------
		lsvPriser = new ListView<Pris>();
		lsvPriser.setOnMouseClicked(event -> printPrisInfo());
		this.add(lsvPriser, 0, 3, 2, 1);
		// -----------------
		
		txfAntalPris = new TextField();
		this.add(txfAntalPris, 0, 4);
		txfAntalPris.setPromptText("antal");
		txfAntalPris.setPrefWidth(50.0);
		
		//---------------------
		
		Button btnTilføjTilKvittering = new Button("Tilføj");
		btnTilføjTilKvittering.setOnAction(event -> tilføjPrisTilKviterring());
		this.add(btnTilføjTilKvittering, 1, 4);
		
		// ----------------
	
		lblInfo = new Label();
		this.add(lblInfo, 0, 5, 4, 1);
		
		// --------
		
		vbxProduktInfo = new VBox(8); // spacing = 8
		vbxProduktInfo.setStyle("-fx-padding: 5;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" +
		"-fx-border-radius: 5;" + "-fx-border-color: black;");
		vbxProduktInfo.setMinWidth(130.0);
		vbxProduktInfo.setMaxWidth(130.0);
		
		
		this.add(vbxProduktInfo, 3, 0, 1, 4);
		
		// ---------
	 	
	 	HBox hboxTest = new HBox(5);
	 	chbErGæst = new CheckBox();
	 	chbErGæst.setSelected(true);
	 	chbErGæst.setOnAction(event -> søgKunde(0));
	 	chbErStuderende = new CheckBox();
	 	chbErStuderende.setOnAction(event -> setGæstSomStuderende());
	 	chbErErhverv = new CheckBox();
	 	chbErErhverv.setOnAction(event -> setGæstSomErhverv());
	 	hboxTest.getChildren().addAll(new Label("Gæst?"), chbErGæst, regions[0], new Label("Studerende?"),
	 			chbErStuderende, regions[1], new Label("Erhverv?"), chbErErhverv);
	 	this.add(hboxTest, 4, 0,2 ,1);
	 	
		//----------
	 	
	 	HBox hboxTest2 = new HBox(5);
	 	txfKundenr = new TextField();
	 	txfKundenr.setPromptText("Kunde nr");
	 	txfKundenr.setPrefWidth(105.0);
	 	hboxTest2.setAlignment(Pos.CENTER);
	 	Button btnSøg = new Button("Søg");
	 	btnSøg.setOnAction(event -> søgKunde());
	 	lblKunde = new Label("Kunde: ???");
	 	
	 	hboxTest2.getChildren().addAll(txfKundenr, btnSøg, lblKunde, regions[2]);
	 	
	 	this.add(hboxTest2, 4, 1,2 ,1);
	 	
		//----------
		
		Button btnSpcialAftalPris = new Button("Specialpris⬈");
		Button btnFjernKvitteringsLinje = new Button("Fjern");
	 	
		HBox hbxKvitteringBtns = new HBox(5);
		hbxKvitteringBtns.getChildren().addAll(btnSpcialAftalPris, regions[3], btnFjernKvitteringsLinje);
		btnSpcialAftalPris.setOnAction(event -> speicalAftalPris());
		btnFjernKvitteringsLinje.setOnAction(event -> fjernKvitteringsLinje());
		this.add(hbxKvitteringBtns, 4, 2, 2, 1); 
		
	 	//-----------
		
		lsvKvittering = new ListView<KvitteringsLinje>();
		lsvKvittering.setPrefWidth(300.0);
		this.add(lsvKvittering, 4, 3, 2, 1);
		
		//--------
		
		HBox bhxNettoPris = new HBox(5.0);
		cmbVælgBetalling = new ComboBox<Betallingsmetode>();
		cmbVælgBetalling.getItems().addAll(controller.getBetallingsmetoder());
		if (cmbVælgBetalling.getItems().size() > 0) {
			cmbVælgBetalling.getSelectionModel().select(0);
			updateCompatator();
		}
		
		lblNettoPrisVærdi = new Label("0 kr");
		
		bhxNettoPris.getChildren().addAll(regions[4], new Label("Nettopris: "),  lblNettoPrisVærdi);
		bhxNettoPris.setAlignment(Pos.CENTER);
		this.add(bhxNettoPris, 4, 4,2,1);
		
		// -------

		HBox bhxBetal = new HBox(5.0);
		Button btnBetal = new Button("Betal"); 
		btnBetal.setOnAction(event -> betal());
		bhxBetal.getChildren().addAll(cmbVælgBetalling, regions[5],  btnBetal);
		
		this.add(bhxBetal, 4, 5, 2, 1);
		
		resetInfoBox();
		søgKunde(0);
	}
	
	

	private void setGæstSomErhverv() {
		if (currentKunde == null) {
			return;
		}
		if (currentKunde.getKundeNr() != 0) {
			return;
		}
		txfKundenr.setText("");
		currentKunde.setErErhverv(chbErErhverv.isSelected());
		chbErStuderende.setSelected(currentKunde.getIsStudent());
		printNettoPris();
	}

	private void setGæstSomStuderende() {
		if (currentKunde == null) {
			return;
		}
		if (currentKunde.getKundeNr() != 0) {
			return;
		}
		currentKunde.setStudent(chbErStuderende.isSelected());
		chbErErhverv.setSelected(currentKunde.isErhverv());
		
		printNettoPris();
	}

	private void søgKunde(int kundeNr) {
		
		currentKunde = controller.søgKunde(kundeNr);
		
		if (currentKunde == null) {
			lblInfo.setStyle("");
			lblInfo.setTextFill(Color.RED);
			lblInfo.setText("Kunde nummer " + kundeNr +" ikke fundet");
			return;
		}
			chbErStuderende.setSelected(currentKunde.getIsStudent());
		 	chbErErhverv.setSelected(currentKunde.isErhverv());
		
		if (kundeNr == 0) { 
			chbErStuderende.setDisable(false);
			chbErErhverv.setDisable(false);
			chbErGæst.setDisable(true);
			chbErGæst.setSelected(true);
			
			txfKundenr.setText("");
			txfKundenr.setPromptText("Kunde nr.");
		}
		else {
			chbErStuderende.setDisable(true);
			chbErErhverv.setDisable(true);
			chbErGæst.setDisable(false);
			chbErGæst.setSelected(false);
		}
		
		lblKunde.setText("Kunde: " + currentKunde.getNavn());
		
		if (currentKvittering == null) {
			currentKvittering = new Kvittering(currentKunde);
		}
		
		currentKvittering.setKunde(currentKunde);
		lblInfo.setText("");
	}
	private void søgKunde() {
		int kundeNr;
		
		try {
			kundeNr = Integer.parseInt(txfKundenr.getText());
		}
		catch (Exception numberForException) { 
			lblInfo.setText("Ugyligt tal for kundenummer");
			return;
		}
		søgKunde(kundeNr);
		printNettoPris();
	}

	private Prisliste currentPrisliste;
	private Kvittering currentKvittering;
	private Kunde currentKunde;
	
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
	
	private void printPrisInfo() {
		Pris markeredePris = lsvPriser.getSelectionModel().getSelectedItem();
		if (markeredePris == null) {
			return;
		}
		vbxProduktInfo.getChildren().clear();
		Label lblProduktTitel = new Label("Produkt:");
		lblProduktTitel.setStyle("-fx-font-weight: bold");
		lblProduktTitel.setWrapText(true);
		vbxProduktInfo.getChildren().add(lblProduktTitel);
		Label lblProdukt = new Label(markeredePris.getProdukt().toString());
		lblProdukt.setWrapText(true);
		vbxProduktInfo.getChildren().add(lblProdukt);
		String[][] produktInfo = markeredePris.getProdukt().getAttributter();
		for (int i = 0; i < produktInfo.length; i++) {
			Label lblProduktAttribut = new Label(produktInfo[i][0] + ":");
			lblProduktAttribut.setStyle("-fx-font-weight: bold");
			lblProduktAttribut.setWrapText(true);
			vbxProduktInfo.getChildren().add(lblProduktAttribut);
			Label lblProduktAttributVærdi = new Label(produktInfo[i][1]);
			lblProduktAttributVærdi.setWrapText(true);
			vbxProduktInfo.getChildren().add(lblProduktAttributVærdi);
		}
	}
	
	private void speicalAftalPris() {
		
		KvitteringsLinje markeredeKvitteringsLinje = lsvKvittering.getSelectionModel().getSelectedItem();
		
		if (markeredeKvitteringsLinje == null) {
			lblInfo.setTextFill(Color.RED);
			lblInfo.setText("Vælg en kvitteringslinje");
			return;
		}
		
		SpecialAftalPrisWindow specialAftalPrisWindow = new SpecialAftalPrisWindow(markeredeKvitteringsLinje);
		specialAftalPrisWindow.showAndWait();
		
		try {
			lsvKvittering.getItems().clear();
			lsvKvittering.getItems().addAll(currentKvittering.getKvitteringsLinjer());
		}
		catch (Exception e) {
			lblInfo.setText("kan ikke fremvise kvittering, metode speicalAftalPris()");
		}

		printNettoPris();
		
	}
	
	private void fjernKvitteringsLinje() {
		
		if (currentKvittering == null) {
			return;
		}
		KvitteringsLinje markeredeKvitteringsLinje = lsvKvittering.getSelectionModel().getSelectedItem();
		if (markeredeKvitteringsLinje == null) {
			lblInfo.setTextFill(Color.RED);
			lblInfo.setText("Vælg en kvitteringslinje");
			return;
		}
		currentKvittering.removeKvitteringsLinje(markeredeKvitteringsLinje);
		lsvKvittering.getItems().clear();
		lsvKvittering.getItems().addAll(currentKvittering.getKvitteringsLinjer());
		printNettoPris();
		
	}

	private void visPriser() {
		
		if (currentPrisliste == null) {
			return;
		}
		ProduktType valgtProduktType = cmbVælgProduktType.getSelectionModel().getSelectedItem();
		if (valgtProduktType == null) {
			return;
		}
		lsvPriser.getItems().clear();
		try {
			List<Pris> priser = currentPrisliste.getTreeMapPriser().get(valgtProduktType);
			Collections.sort(priser);
			lsvPriser.getItems().addAll(priser);
		}
		catch (Exception e) {
			lblInfo.setTextFill(Color.RED);
			lblInfo.setText("kan ikke fremvise priser fra " + lsvPriser);
		}
	}
	
	private void updateProduktTypeUdfraPrisliste() {
			currentPrisliste = cmbVælgPrisliste.getSelectionModel().getSelectedItem();
			if (currentPrisliste == null) {
				return;
			}
			try {	
			cmbVælgProduktType.getItems().clear();
			
			Set<ProduktType> produktTyper = currentPrisliste.getTreeMapPriser().keySet();
			
			cmbVælgProduktType.getItems().addAll(produktTyper);
			cmbVælgProduktType.setDisable(false);
			lsvPriser.getItems().clear();
		}
		catch (Exception e) {
			
			lblInfo.setTextFill(Color.RED);
			lblInfo.setText("Fejl i updateProdukt");
			
		}
	}
	
	private void updateCompatator() {
		Comparator<Pris> comparator = cmbVælgComparator.getSelectionModel().getSelectedItem();
		controller.setComparatorOnPriser(comparator);
		if (cmbVælgProduktType.getSelectionModel().getSelectedItem() != null) {
			visPriser();
		}
	}
	
	private void tilføjPrisTilKviterring() {
		Pris valgtePris = lsvPriser.getSelectionModel().getSelectedItem();
		if (valgtePris == null) {
			lblInfo.setTextFill(Color.RED);
			lblInfo.setText("Vælg en pris");
			return;
		}
		String strAntalPris = txfAntalPris.getText();
		Integer antal;
		try {
			antal = Integer.parseInt(strAntalPris);
		}
		catch (NumberFormatException e) {
			lblInfo.setTextFill(Color.RED);
			lblInfo.setText("Ugyldigt antal for priser");
			return;
		}
		if (currentKvittering == null) {
			currentKvittering = controller.createKvittering(controller.createKundeGæst(false));
		}
		try {
			currentKvittering.addKvitteringsLinje(valgtePris, antal);	
		}
		catch (IllegalArgumentException e) {
			lblInfo.setTextFill(Color.RED);
			lblInfo.setText(e.getMessage());
			return;
		}
		lsvKvittering.getItems().clear();
		lsvKvittering.getItems().addAll(currentKvittering.getKvitteringsLinjer());
		
		txfAntalPris.setText("");
		lblInfo.setText("");
		printNettoPris();
		
	}
	
	public void betal() {
		if (currentKvittering == null) {
			return;
		}
		if (currentKvittering.getKvitteringsLinjer().size() == 0) {
			return;
		}
		if (currentKunde == null) {
			return;
		}
		try {
			controller.betalKvittering(cmbVælgBetalling.getValue(), currentKvittering);
		}
		catch (IllegalArgumentException e) {
			lblInfo.setTextFill(Color.RED);
			lblInfo.setText(e.getMessage());
			return;
		}
		
		currentKvittering = new Kvittering(currentKunde);
		lsvKvittering.getItems().clear();
		printPrisInfo();
		lblInfo.setTextFill(Color.GREEN);
		lblInfo.setText("Kvittering betalt og gemt");
		lblNettoPrisVærdi.setText("0 kr");
	}

	public void updateControls() {
		cmbVælgPrisliste.getItems().clear();
		cmbVælgPrisliste.getItems().addAll(controller.getPrislister());
		cmbVælgProduktType.getItems().clear();
		lsvPriser.getItems().clear();
		resetInfoBox();
		if (currentKvittering != null) {
			currentKvittering.clear();
		}
		lsvKvittering.getItems().clear();
		lblNettoPrisVærdi.setText("0 kr");
	}
	
	public void resetInfoBox() {
		
		vbxProduktInfo.getChildren().clear();
		
		Label lblInfobox = new Label("Infobox");
		lblInfobox.setStyle("-fx-font-weight: bold");
		
		vbxProduktInfo.getChildren().add(lblInfobox);
		
	}
}
