package gui;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import application.Prisliste;
import application.Produkt;
import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.scene.control.TextField;

public class OpretPrisogPrislistePane extends GridPane {
	
	private ComboBox<Prisliste> cmbVælgPrisliste;
	private TextField txfOpretPris, txfStandardPris;
	private Controller controller = Controller.getSingletonIntance();
	private ComboBox<Produkt> cbbProdukter;
	private Label lblInfo;
	private TextField txfSerilation;
	
	public OpretPrisogPrislistePane() {

		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);
		
		// -----------------------
		
		Text titelOpretPrisliste = new Text("Opret ny prisliste");
		titelOpretPrisliste.setStyle("-fx-font-size: 20;");
		this.add(titelOpretPrisliste, 0, 0);
		
		HBox hbxOpretPrisliste = new HBox(5);
		
		Button btnOpretPrisliste = new Button("Opret");
		btnOpretPrisliste.setOnAction(event -> opretNyPrisliste());
		
		txfOpretPris = new TextField();
		hbxOpretPrisliste.getChildren().addAll(txfOpretPris,
				btnOpretPrisliste);
		
		this.add(hbxOpretPrisliste, 0, 1);
		
		Separator separator = new Separator();
		this.add(separator, 0, 2, 2, 1);
		
		// -----------------------------
		
		Text titelOpretPris = new Text("Opret ny pris");
		titelOpretPris.setStyle("-fx-font-size: 20;");
		
		this.add(titelOpretPris, 0, 3);
		
		cmbVælgPrisliste = new ComboBox<Prisliste>(); 
		cmbVælgPrisliste.setMaxWidth(Double.MAX_VALUE);
		cmbVælgPrisliste.getItems().clear();
		cmbVælgPrisliste.getItems().addAll(controller.getPrislister());
		
		cbbProdukter = new ComboBox<Produkt>();
		HBox hbxProdukt = new HBox(5);
		hbxProdukt.getChildren().addAll(new Label("Produkt:"), cbbProdukter);
		this.add(hbxProdukt, 0, 4, 2, 1);
		HBox hbxPrisliste = new HBox(5);
		hbxPrisliste.getChildren().addAll(new Label("Prisliste:"), cmbVælgPrisliste);
		this.add(hbxPrisliste, 0, 5);	
		HBox hbxDndsætStdPris = new HBox(5);
		txfStandardPris = new TextField();
		hbxDndsætStdPris.getChildren().addAll(new Label("stk pris:"), txfStandardPris);
		this.add(hbxDndsætStdPris, 0, 6);
		
		Button btnOpretNyPris = new Button("Opret ny pris");
		btnOpretNyPris.setOnAction(event -> opretNyPris());
		this.add(btnOpretNyPris, 0, 7);
		
		Separator separator2 = new Separator();
		this.add(separator2, 0, 8, 2, 1);
		
		Text titelOpretProdukt = new Text("Serialization");
		titelOpretProdukt.setStyle("-fx-font-size: 20;");
        this.add(titelOpretProdukt, 0, 10);
        final FileChooser fileChooser = new FileChooser();
        final Button btnOpenFile = new Button("Vælg .ser fil");
        
        btnOpenFile.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    File file = fileChooser.showOpenDialog(null);
                    if (file != null) {
                    	txfSerilation.setText(file.getAbsolutePath());
                    }
                }
            });
        
        txfSerilation = new TextField();
        
        HBox hbxSerialization = new HBox(5);
        hbxSerialization.getChildren().addAll(txfSerilation, btnOpenFile);
        this.add(hbxSerialization, 0, 11);
        
        Button btnLoadSerialization = new Button("Load!");
        btnLoadSerialization.setOnAction(event -> LoadSerialization());
        this.add(btnLoadSerialization, 0, 12);
        
    	lblInfo = new Label("");
		this.add(lblInfo, 0, 13, 2, 1);
		
	}
	public void updateControls() {
		List<Produkt> alleProdukter = controller.getProdukter();
		Collections.sort(alleProdukter);
		cbbProdukter.getItems().clear();
		cbbProdukter.getItems().addAll(alleProdukter);
	}
	
	private void opretNyPrisliste() {
		try {
			controller.createPrisliste(txfOpretPris.getText());	
		}
		catch (Exception e) {
			lblInfo.setTextFill(Color.RED);
			lblInfo.setText("Ukendt fejl kan ikke oprette ny prisliste");
		}
		cmbVælgPrisliste.getItems().clear();
		cmbVælgPrisliste.getItems().addAll(controller.getPrislister());
	}
	
	private void opretNyPris() {
		String strPris = txfStandardPris.getText();
		Prisliste markeredePrisliste = cmbVælgPrisliste.getSelectionModel().getSelectedItem();
		Produkt markeredeProdukt = cbbProdukter.getSelectionModel().getSelectedItem();
		
		if (markeredePrisliste == null) {
			return;
		}
		if (markeredeProdukt == null) {
			return;
		}
		double pris;
		try {
			pris = Double.parseDouble(strPris);
		} catch (Exception e) {
			lblInfo.setTextFill(Color.RED);
			lblInfo.setText("Kan ikke double parse " + strPris);
			return;
		}
		try {
			controller.createPris(pris, markeredeProdukt, markeredePrisliste);
		}catch (IllegalArgumentException e) {
			lblInfo.setTextFill(Color.RED);
			lblInfo.setText(e.getMessage());
		}
	}
	
	public void LoadSerialization() {
		try {
			controller.loadSerialFile(txfSerilation.getText());
		}
	  catch (IOException e) {
		  	lblInfo.setTextFill(Color.RED);
		  	lblInfo.setText("Korrupt fil!");
	        return;
	     } catch (ClassNotFoundException e) {
			lblInfo.setTextFill(Color.RED);
			lblInfo.setText("Korrupt fil!");
	        return;
	     }
		
	  	lblInfo.setTextFill(Color.GREEN);
	  	lblInfo.setText("Prisliste tilføjet fra fil!");
	  	txfSerilation.setText("");
	}
	
}