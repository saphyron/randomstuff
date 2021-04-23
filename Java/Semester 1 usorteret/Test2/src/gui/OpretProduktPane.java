package gui;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import application.ProduktType;
import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;

public class OpretProduktPane extends GridPane {
	
	private TextField txfProduktnavn, txfProduktType;
	private Controller controller = Controller.getSingletonIntance();
	private ComboBox<ProduktType> cbbProduktTyper;
	private ComboBox<ProduktOprettelse> cbbVælgOprretlse;
	private ProduktOprettelse produktOprettelse;
	private Label lblInfo;
	
	private TextField[] txfAttributter = new TextField[] {
			new TextField(""), 
			new TextField(""),
			new TextField("")
	};
	
	private Label[] lblAttributter = new Label[] {
			new Label("Attribut #1"), 
			new Label("Attribut #2"),
			new Label("Attribut #3")
	};
	
	public OpretProduktPane() {

		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);
		
		Region[] regions = new Region[20];
		
		for (int i = 0; i < regions.length; i++) {
			regions[i] =  new Region();
			HBox.setHgrow(regions[i], Priority.ALWAYS);
		}
		
		// -----------------------
		Text titelOpretProdukt = new Text("Opret produkt");
		titelOpretProdukt.setStyle("-fx-font-size: 20;");
		this.add(titelOpretProdukt, 0, 0);
		txfProduktnavn = new TextField();
		cbbVælgOprretlse = new ComboBox<ProduktOprettelse>();
		cbbVælgOprretlse.setPrefWidth(170.0);
		cbbVælgOprretlse.getItems().addAll(List.of(
				new OpretAlkohol(),
				new OpretAndet(),
				new OpretAnlæg(),
				new OpretKulsyre(),
				new OpretRundvisning(),
				new OpretSampakning()
				));
		
		cbbVælgOprretlse.setOnAction(event -> opdaterLabels());
		if (cbbVælgOprretlse.getItems().size() > 0) {
			cbbVælgOprretlse.getSelectionModel().select(0);
			opdaterLabels();
		}
		HBox hbxProduktKlasse = new HBox(5);
		hbxProduktKlasse.getChildren().addAll(new Label("Produkt klasse:"), regions[0], cbbVælgOprretlse);
		
		HBox hbxProduktNavn = new HBox(5);
		hbxProduktNavn.getChildren().addAll(new Label("Produkt navn"), regions[1], txfProduktnavn);
		HBox hbxAttribut1 = new HBox(5);
		lblAttributter[0].setMinWidth(100.0);
		hbxAttribut1.getChildren().addAll(lblAttributter[0], regions[2], txfAttributter[0]);
		HBox hbxAttribut2 = new HBox(5);
		hbxAttribut2.getChildren().addAll(lblAttributter[1], regions[3], txfAttributter[1]);
		HBox hbxAttribut3 = new HBox(5);
		hbxAttribut3.getChildren().addAll(lblAttributter[2], regions[4], txfAttributter[2]);		
		HBox hbxProduktType = new HBox(5);
		cbbProduktTyper = new ComboBox<ProduktType>();
		cbbProduktTyper.setPrefWidth(170.0);
		cbbProduktTyper.getItems().addAll(controller.getProduktTyper());
		hbxProduktType.getChildren().addAll(new Label("Produkt type"), regions[5], cbbProduktTyper);		
		
		hbxProduktKlasse.setAlignment(Pos.CENTER);
		hbxProduktNavn.setAlignment(Pos.CENTER);
		hbxAttribut1.setAlignment(Pos.CENTER);
		hbxAttribut2.setAlignment(Pos.CENTER);
		hbxAttribut3.setAlignment(Pos.CENTER);
		hbxProduktType.setAlignment(Pos.CENTER);
		this.add(hbxProduktKlasse, 0, 1);
		this.add(hbxProduktNavn, 0, 2);
		this.add(hbxAttribut1, 0, 3);
		this.add(hbxAttribut2, 0, 4);
		this.add(hbxAttribut3, 0, 5);
		this.add(hbxProduktType, 0, 6);
		
		HBox hbxOpretProdukt = new HBox(5.0);
		Button btnOpretProdukt = new Button("Opret produkt!");
		btnOpretProdukt.setPrefWidth(170);
		btnOpretProdukt.setOnAction(event -> opretProdukt());
		hbxOpretProdukt.getChildren().addAll(regions[6], btnOpretProdukt);

		this.add(hbxOpretProdukt, 0, 7);
		lblInfo = new Label();
		this.add(lblInfo, 0, 8, 2, 1);
		
		// -----------------
		
		Text titelOpretProdukttype = new Text("Opret produkttype");
		titelOpretProdukttype.setStyle("-fx-font-size: 20;");
		this.add(titelOpretProdukttype, 2, 0);
		
		HBox hbxProduktype = new HBox(5);
		
		txfProduktType = new TextField();
		Label produktType = new Label("Produktype:");
		produktType.setMinWidth(100);
		hbxProduktype.getChildren().addAll(produktType, regions[7], txfProduktType);
		this.add(hbxProduktype, 2, 1);
		Button btnOpretProduktType = new Button("Opret ny produkttype"); 
		btnOpretProduktType.setOnAction(event -> opretProduktType());
		HBox hbxOpretProdukttype = new HBox(5.0);
		hbxOpretProdukttype.setAlignment(Pos.CENTER);
		hbxOpretProdukttype.getChildren().addAll(regions[8], btnOpretProduktType);
		btnOpretProdukt.setOnAction(event -> opretProdukt());
		btnOpretProdukt.setPrefWidth(170);
		this.add(hbxOpretProdukttype, 2, 2);
	}
	
	private void opretProduktType() {
		try {
			controller.createProduktType(txfProduktType.getText());	
		}
		catch (IllegalArgumentException e) {
			lblInfo.setTextFill(Color.RED);
			lblInfo.setText("ugyldigt produkttype navn");
			return;
		}
		
		lblInfo.setTextFill(Color.GREEN);
		lblInfo.setText("Produkttype " +txfProduktType.getText() + " oprettet!");
		txfProduktType.setText("");
		
		cbbProduktTyper.getItems().clear();
		cbbProduktTyper.getItems().addAll(controller.getProduktTyper());
		
	}

	private void opdaterLabels() {
		produktOprettelse = cbbVælgOprretlse.getSelectionModel().getSelectedItem();
	
		if (produktOprettelse == null) {
			return;
		}
		txfAttributter[0].setText("");
		txfAttributter[1].setText("");
		txfAttributter[2].setText("");
		produktOprettelse.opdaterTxfogLbl();
	}

	private void opretProdukt() {
		
		if (produktOprettelse == null) {
			return;
		}
		
		produktOprettelse.opretProdukt();
		
	}
	public void updateControls() {}
	public void clearTextfields() {
		txfProduktnavn.setText("");
		for (TextField textfield : txfAttributter) {
			textfield.setText("");
		}
	}
	
	interface ProduktOprettelse {
		void opdaterTxfogLbl();
		void opretProdukt();
    }
	
    class OpretAlkohol implements ProduktOprettelse {

		@Override
		public void opdaterTxfogLbl() {
			lblAttributter[0].setText("AlkoholProcent");
			lblAttributter[1].setText("Volume");
			lblAttributter[2].setText("Pant");
			
			txfAttributter[0].setPromptText("fx. 6.2");
			txfAttributter[1].setPromptText("fx. 0.60");
			txfAttributter[2].setPromptText("fx. 2.0");

			lblAttributter[0].setVisible(true);
			lblAttributter[1].setVisible(true);
			lblAttributter[2].setVisible(true);
		
			txfAttributter[0].setVisible(true);
			txfAttributter[1].setVisible(true);
			txfAttributter[2].setVisible(true);
		}
		@Override
		public void opretProdukt() {
			
			if (produktOprettelse == null) {
				return;
			}
			
			ProduktType markeredeProduktType = cbbProduktTyper.getSelectionModel().getSelectedItem();
			
			if (markeredeProduktType == null) {
				lblInfo.setTextFill(Color.RED);
				lblInfo.setText("fejl - vælg et produkttype");
				return;
			}
			
			try {
			controller.createAlkohol(
					txfProduktnavn.getText(),
					Double.parseDouble(txfAttributter[0].getText()),
					Double.parseDouble(txfAttributter[1].getText()),
					Double.parseDouble(txfAttributter[2].getText()),
					markeredeProduktType
					);
			}
			catch (Exception e) {
				lblInfo.setTextFill(Color.RED);
				lblInfo.setText("kan ikke oprette " + toString() + " "+ e.getMessage());
				return;
			}
			lblInfo.setTextFill(Color.GREEN);
			lblInfo.setText("Alkohol oprettet i systemet");
			clearTextfields();
		}
		public String toString() {
			return "Alkohol";
		}

    }
    
    class OpretAndet implements ProduktOprettelse {

		@Override
		public void opdaterTxfogLbl() {
			lblAttributter[0].setVisible(true);
			lblAttributter[1].setVisible(false);
			lblAttributter[2].setVisible(false);
			
			lblAttributter[0].setText("Bekrivelse");

			txfAttributter[0].setPromptText("fx. et oktoberfest krus");
			
			txfAttributter[0].setVisible(true);
			txfAttributter[1].setVisible(false);
			txfAttributter[2].setVisible(false);
		}
		@Override
		public void opretProdukt() {
			
			if (produktOprettelse == null) {
				return;
			}
			
			ProduktType markeredeProduktType = cbbProduktTyper.getSelectionModel().getSelectedItem();
			
			if (markeredeProduktType == null) {
				lblInfo.setTextFill(Color.RED);
				lblInfo.setText("fejl - vælg et produkttype");
				return;
			}
			
			try {
				controller.createAndet(
						txfProduktnavn.getText(),
						markeredeProduktType,
						txfAttributter[0].getText()
				);
			}
			
			catch (Exception e) {
				lblInfo.setTextFill(Color.RED);
				lblInfo.setText("kan ikke oprette " + toString() + " - " + e.getMessage());
				return;
			}
			lblInfo.setTextFill(Color.GREEN);
			lblInfo.setText("Andet oprettet i systemet");
			clearTextfields();

		}
		public String toString() {
			return "Andet";
		}

    }
    
    class OpretSampakning implements ProduktOprettelse {
		@Override
		public void opdaterTxfogLbl() {
			lblAttributter[0].setText("Antal øl");
			lblAttributter[1].setText("Antal glass");
			
			txfAttributter[0].setPromptText("fx. 4");
			txfAttributter[1].setPromptText("fx 2");
			
			
			lblAttributter[0].setVisible(true);
			lblAttributter[1].setVisible(true);
			lblAttributter[2].setVisible(false);
			
		
			txfAttributter[0].setVisible(true);
			txfAttributter[1].setVisible(true);
			txfAttributter[2].setVisible(false);
		}
		@Override
		public void opretProdukt() {
			if (produktOprettelse == null) {
				return;
			}
			
			ProduktType markeredeProduktType = cbbProduktTyper.getSelectionModel().getSelectedItem();
			
			if (markeredeProduktType == null) {
				lblInfo.setTextFill(Color.RED);
				lblInfo.setText("fejl - vælg et produkttype");
				return;
			}
			
			try {
				controller.createSampakning(
						txfProduktnavn.getText(),
						Integer.parseInt(txfAttributter[0].getText()),
						Integer.parseInt(txfAttributter[1].getText()),
						markeredeProduktType
				);
			}
			
			catch (Exception e) {
				lblInfo.setTextFill(Color.RED);
				lblInfo.setText("kan ikke oprette " + toString() + " - " + e.getMessage());
				return;
			}
			lblInfo.setTextFill(Color.GREEN);
			lblInfo.setText(toString() + " oprettet i systemet");
			clearTextfields();
			
		}
		public String toString() {
			return "Sampakning";
		}
    }
    
    class OpretAnlæg implements ProduktOprettelse {
		@Override
		public void opdaterTxfogLbl() {
			lblAttributter[0].setText("Dato:");
			
			txfAttributter[0].setPromptText("fx. 2019-11-11");
			
			lblAttributter[0].setVisible(true);
			lblAttributter[1].setVisible(false);
			lblAttributter[2].setVisible(false);
		
			txfAttributter[0].setVisible(true);
			txfAttributter[1].setVisible(false);
			txfAttributter[2].setVisible(false);
		}
		@Override
		public void opretProdukt() {
			
			if (produktOprettelse == null) {
				return;
			}
			
			ProduktType markeredeProduktType = cbbProduktTyper.getSelectionModel().getSelectedItem();
			
			if (markeredeProduktType == null) {
				lblInfo.setTextFill(Color.RED);
				lblInfo.setText("fejl - vælg et produkttype");
				return;
			}
			
			try {
				controller.createAndet(
						txfProduktnavn.getText(),
						markeredeProduktType,
						txfAttributter[0].getText()
				);
			}
			
			catch (Exception e) {
				lblInfo.setTextFill(Color.RED);
				lblInfo.setText("kan ikke oprette " + toString() + " - " + e.getMessage());
				return;
			}
			lblInfo.setTextFill(Color.GREEN);
			lblInfo.setText("Anlæg oprettet i systemet");
			clearTextfields();

		}
		public String toString() {
			return "Anlæg";
		}
    }
    
    class OpretRundvisning implements ProduktOprettelse {
		@Override
		public void opdaterTxfogLbl() {
			lblAttributter[0].setText("Dato:");
			lblAttributter[1].setText("Tid:");
			txfAttributter[0].setPromptText("fx. 2019-11-11");
			txfAttributter[1].setPromptText("fx. 14:20");
			
			lblAttributter[0].setVisible(true);
			lblAttributter[1].setVisible(true);
			lblAttributter[2].setVisible(false);
			
			txfAttributter[0].setVisible(true);
			txfAttributter[1].setVisible(true);
			txfAttributter[2].setVisible(false);
		}
		@Override
		public void opretProdukt() {
			
			if (produktOprettelse == null) {
				return;
			}
			
			ProduktType markeredeProduktType = cbbProduktTyper.getSelectionModel().getSelectedItem();
			
			if (markeredeProduktType == null) {
				lblInfo.setTextFill(Color.RED);
				lblInfo.setText("fejl - vælg et produkttype");
				return;
			}
			
			try {
				controller.createRundvisning(txfProduktnavn.getText(),
						LocalDate.parse(txfAttributter[0].getText()),
						LocalTime.parse(txfAttributter[1].getText()),
						markeredeProduktType);
				
				
			}
			
			catch (Exception e) {
				lblInfo.setTextFill(Color.RED);
				lblInfo.setText("kan ikke oprette " + toString() + " - " + e.getMessage());
				return;
			}
			lblInfo.setTextFill(Color.GREEN);
			lblInfo.setText("Rundvisning oprettet i systemet");
			clearTextfields();

		}
		public String toString() {
			return "Rundvisning";
		}
    }
    
    class OpretKulsyre implements ProduktOprettelse {
		@Override
		public void opdaterTxfogLbl() {	
			
			lblAttributter[0].setText("Vægt:");
			lblAttributter[1].setText("Pant:");
			
			txfAttributter[0].setPromptText("fx. 2.5");
			txfAttributter[1].setPromptText("fx. 50.0");
			
			lblAttributter[0].setVisible(true);
			lblAttributter[1].setVisible(true);
			lblAttributter[2].setVisible(false);
			
		
			txfAttributter[0].setVisible(true);
			txfAttributter[1].setVisible(true);
			txfAttributter[2].setVisible(false);
		}
		@Override
		public void opretProdukt() {
			
			if (produktOprettelse == null) {
				return;
			}
			
			ProduktType markeredeProduktType = cbbProduktTyper.getSelectionModel().getSelectedItem();
			
			if (markeredeProduktType == null) {
				lblInfo.setTextFill(Color.RED);
				lblInfo.setText("fejl - vælg et produkttype");
				return;
			}
			
			try {
				controller.createKulsyre(txfProduktnavn.getText(),
						Double.parseDouble(txfAttributter[0].getText()),
						Double.parseDouble(txfAttributter[1].getText()),
						markeredeProduktType);
			}
			
			catch (Exception e) {
				lblInfo.setTextFill(Color.RED);
				lblInfo.setText("kan ikke oprette " + toString() + " - " + e.getMessage());
				return;
			}
			lblInfo.setTextFill(Color.GREEN);
			lblInfo.setText("Kulsyre oprettet i systemet");
			clearTextfields();

		}
		public String toString() {
			return "Kulsyre";
		}
    }

}