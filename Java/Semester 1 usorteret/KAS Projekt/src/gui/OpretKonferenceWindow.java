package gui;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Hotel;
import model.Konference;
import model.Serviceydelse;
import model.Udflugt;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

//import application.controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import controller.*;
import java.time.LocalDate;

public class OpretKonferenceWindow extends Stage {
	
	private Konference konference;
	
	public OpretKonferenceWindow(String title, Konference konference) {
		this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.konference = konference;
        
        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }
	

    private TextField txfKonferenceNavn, txfPris, txfStartdato, txfSlutdato, txfFrist; 
	
    private Label lblKonferenceNavn, lblPris, lblStartdato, lblSlutdato, lblSpaceButtom, lblError, lblFrist;
    
    private ComboBox<Hotel> cbbHoteller;
    private ComboBox<Udflugt> cbbUdflugter;
	
    private void initContent(GridPane pane) {
    	
    	pane.setPadding(new Insets(10));
        pane.setHgap(14);
        pane.setVgap(14);
        pane.setGridLinesVisible(false);
        
        Label lblKonferenceNavn = new Label("Konference navn:");
        pane.add(lblKonferenceNavn, 0, 0);

        txfKonferenceNavn = new TextField();
        pane.add(txfKonferenceNavn, 0, 1);
        txfKonferenceNavn.setPrefWidth(200);

        Label lblPris = new Label("Pris:");
        pane.add(lblPris, 0, 2);

        txfPris = new TextField();
        pane.add(txfPris, 0, 3);

        Label lblStartdato = new Label("Ankomstdato:");
        pane.add(lblStartdato, 0, 4);

        txfStartdato = new TextField();
        pane.add(txfStartdato, 0, 5);
        txfStartdato.setPrefWidth(200);

        Label lblSlutdato = new Label("Afrejsedato:");
        pane.add(lblSlutdato, 0, 6);

        txfSlutdato = new TextField();
        pane.add(txfSlutdato, 0, 7);
        
        Label lblFrist = new Label("Sï¿½t Tilmeldingsfrist:");
        pane.add(lblFrist, 0, 8);

        txfFrist = new TextField();
        pane.add(txfFrist, 0, 9);
        
        Label lblHoteller = new Label("Hoteller:");
        pane.add(lblHoteller, 0, 10);
        
        cbbHoteller = new ComboBox<>();
		pane.add(cbbHoteller, 0, 11);
		cbbHoteller.getItems().addAll(Controller.getHotel());
		cbbHoteller.setDisable(false);
		
		Label lblUdflugt = new Label("Udflugter:");
        pane.add(lblUdflugt, 0, 12);
		
		cbbUdflugter = new ComboBox<>();
		pane.add(cbbUdflugter, 0, 13);
		cbbUdflugter.getItems().addAll(Controller.getUdflugt());
		cbbUdflugter.setDisable(false);

        //space
        Label lblSpaceButtom = new Label("");
        pane.add(lblSpaceButtom, 0, 9);
        
        
        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 14);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 14);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());

        //TODO Error-handling
        lblError = new Label();
        pane.add(lblError, 0, 12);
        lblError.setStyle("-fx-text-fill: red");
        
        this.initControls();

    }

    //TODO Aner ikke hvad den gï¿½r
    private void initControls() {
        if (konference != null) {
            txfKonferenceNavn.setText(konference.getNavn()); 
            txfPris.setText("" + konference.getPris()); 
            txfStartdato.setText("" + konference.getStartdato()); 
            txfSlutdato.setText("" + konference.getSlutdato());
            txfFrist.setText("" + konference.getTilmeldingsfrist());
        } else {
            txfKonferenceNavn.clear(); 
            txfPris.clear();
            txfStartdato.clear();
            txfSlutdato.clear();
        }
    }

    private void cancelAction() {
        this.hide();
    }
    
    private void okAction() {
    	
    	//konferencenavn
    	 
        String konferencenavn = txfKonferenceNavn.getText().trim();
        
        Udflugt udflugt = cbbUdflugter.getSelectionModel().getSelectedItem(); 
        
        if (konferencenavn.length() == 0) {
            lblError.setText("Name is empty");
            return;
        }
        
        
        //pris

        double pris = -1;
        try {
            pris = Double.parseDouble(txfPris.getText().trim());
        } catch (NumberFormatException ex) {
            // do nothing
        }
        if (pris < 0) {
            lblError.setText("Pris skal vï¿½re et positivt tal");
            return;
        }
        
        
        //startdato
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        LocalDate startdato = LocalDate.parse(txfStartdato.getText().trim(), formatter);
        System.out.println(startdato);
        System.out.println(txfStartdato);
        if (startdato == null) {
        	//TODO Hvordan laver man try-catch, hvis man ikke indtaster datoen i det rigtige format
            lblError.setText("Startdato is empty");
            return;
        }


        //slutdato
        
        LocalDate slutdato = LocalDate.parse(txfSlutdato.getText().trim(), formatter);
        if (slutdato == null) {
        	//TODO Hvordan laver man try-catch, hvis man ikke indtaster datoen i det rigtige format
            lblError.setText("Slutdato is empty");
            return;
        }

        
        //tilmeldingsfrist
        
        LocalDate tilmeldingsfrist = LocalDate.parse(txfFrist.getText().trim(), formatter);
        if (tilmeldingsfrist == null) {
        	//TODO Hvordan laver man try-catch, hvis man ikke indtaster datoen i det rigtige format
            lblError.setText("Slutdato is empty");
            return;
        }

        
        // Call controller methods
        
        //todo tilknythotel til konference
        // Virker ikke korrekt løb tør for tid og tålmodighed
        
        
        //det her virker tror vi
        if (konference != null) {
            Controller.updateKonference(konference, konferencenavn, pris, startdato, slutdato, 
            		tilmeldingsfrist);
        } else {
            Controller.createKonference(konferencenavn, pris, startdato, slutdato, tilmeldingsfrist);
        }

        konference.addUdflugt(udflugt);
        
        this.hide();
    }
    
   
        

}
