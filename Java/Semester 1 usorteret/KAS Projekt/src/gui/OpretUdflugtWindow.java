package gui;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Konference;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import controller.*;
import java.time.LocalDate;

public class OpretUdflugtWindow extends Stage {
	
	private Udflugt udflugt;
	private Konference konference;
	
	public OpretUdflugtWindow(String title, Udflugt udflugt) {
		this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.udflugt = udflugt;
        
        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }
	
	//--Constructor-til-at-opdatere-udflugter
	
	public OpretUdflugtWindow(String title, Konference konference, Udflugt udflugt) {
		this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.konference = konference;
        this.udflugt = udflugt;
        
        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }
	
	
	
    private TextField txfDato, txfPris, txfUdflugtNavn, txfFrist; 
    private Label lblKonferenceNavn, lblPris, lblStartdato, lblSlutdato, lblSpaceButtom, lblError, lblFrist;
	private boolean frokost;

    private void initContent(GridPane pane) {
    	
    	System.out.println("UdflugtsWindow: " + konference);
    	
    	pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        //--Udflugt-navn---------------------------------
        
        Label lblUdflugtNavn = new Label("Udflugt navn:");
        pane.add(lblUdflugtNavn, 0, 0);

        txfUdflugtNavn = new TextField();
        pane.add(txfUdflugtNavn, 0, 1);
        txfUdflugtNavn.setPrefWidth(200);

        //--Pris-------------------------------------------
        
        Label lblPris = new Label("Pris:");
        pane.add(lblPris, 0, 2);

        txfPris = new TextField();
        pane.add(txfPris, 0, 3);

        //--Dato--------------------------------------------
        
        Label lblDato = new Label("Dato:");
        pane.add(lblDato, 0, 4);

        txfDato = new TextField();
        pane.add(txfDato, 0, 5);
        txfDato.setPrefWidth(200);

        
        //--Space--------------------------------------------
        Label lblSpaceButtom = new Label("");
        pane.add(lblSpaceButtom, 0, 9);
        
        
        //--Button-actions-----------------------------------
        
        
        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 10);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 10);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());

        //TODO Error-handling
        lblError = new Label();
        pane.add(lblError, 0, 5);
        lblError.setStyle("-fx-text-fill: red");
        
        
		//--CheckBox-for-frokost---------------------------------
		CheckBox checkBox = new CheckBox();
		checkBox.setText("Frokost");
		pane.add(checkBox, 0, 8);
		
		checkBox.setOnAction(event -> {
			if (checkBox.isSelected()) {
				frokost = true;	
			}else {
				frokost = false;
			}
		});

        
        this.initControls();

    }


	//TODO Aner ikke hvad den gør
    private void initControls() {
        if (udflugt != null) {
            txfUdflugtNavn.setText(udflugt.getNavn()); 
            txfPris.setText("" + udflugt.getPris()); 
            txfDato.setText("" + udflugt.getDato());
        } else {
            txfUdflugtNavn.clear(); 
            txfPris.clear();
        }
    }

    private void cancelAction() {
        this.hide();
    }
    
    private void okAction() {
    	
    	//konferencenavn
    	System.out.println("hello");
    	
        String navn = txfUdflugtNavn.getText().trim();
        if (navn.length() == 0) {
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
            lblError.setText("Pris skal være et positivt tal");
            return;
        }
        
        //startdato
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        LocalDate dato = LocalDate.parse(txfDato.getText().trim(), formatter);
        if (dato == null) {
        	//TODO Hvordan laver man try-catch, hvis man ikke indtaster datoen i det rigtige format
            lblError.setText("Dato is empty");
            return;
        }
        
        // Call controller methods
        
        if (udflugt != null) {
        	System.out.println("Hej");
        	Controller.updateUdflugt(udflugt, navn, pris, dato, frokost);
        } else {
        	System.out.println("Hej");
//        	udflugt = new Udflugt(navn, pris, dato, frokost);
            Controller.createUdflugt(navn, pris, dato, frokost);
        }

        this.hide();
    }
        

}
