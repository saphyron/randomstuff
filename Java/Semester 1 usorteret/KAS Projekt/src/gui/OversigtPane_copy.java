package gui;

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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class OversigtPane_copy extends GridPane {
	
	private ChoiceBox cbxKonference, cbxHoteller, cbxUdflugter;
	private Label lblKonference, lblHoteller, lblUdflugter;
	private Label lblDeltagere;
	private Label lblNavnPaaDeltager, lblForedragsHolder;
	private TextField txfNavnPaaDeltager, txfForedragsHolder;
	private ListView lvwKonference, lvwHoteller, lvwUdflugter;
	
	public OversigtPane_copy() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);
		
		GridPane konferencePane = new GridPane();
		this.add(konferencePane, 0, 0);
		konferencePane.setGridLinesVisible(false);
		konferencePane.setPadding(new Insets(10));
		konferencePane.setHgap(10);
		konferencePane.setVgap(10);
		konferencePane.setStyle("-fx-border-color: black");
		
		GridPane hotelPane = new GridPane();
		this.add(hotelPane, 1, 0);
		hotelPane.setGridLinesVisible(false);
		hotelPane.setPadding(new Insets(10));
		hotelPane.setHgap(10);
		hotelPane.setVgap(10);
		hotelPane.setStyle("-fx-border-color: black");
		
		GridPane udflugtsPane = new GridPane();
		this.add(udflugtsPane, 2, 0);
		udflugtsPane.setGridLinesVisible(false);
		udflugtsPane.setPadding(new Insets(10));
		udflugtsPane.setHgap(10);
		udflugtsPane.setVgap(10);
		udflugtsPane.setStyle("-fx-border-color: black");
		
		//---------------------------------------
		
		lblKonference = new Label("Konference:");
		konferencePane.add(lblKonference, 0, 0);
		cbxKonference = new ChoiceBox();
		konferencePane.add(cbxKonference, 1, 0);
		
		lblDeltagere = new Label("Deltagere:");
		konferencePane.add(lblDeltagere, 0, 1);
		lvwKonference = new ListView();
		konferencePane.add(lvwKonference, 0, 2, 2, 3);
		lvwKonference.setPrefWidth(200);
		lvwKonference.setPrefHeight(200);
		
		lblNavnPaaDeltager = new Label("Navn:");
		konferencePane.add(lblNavnPaaDeltager, 3, 2);
		txfNavnPaaDeltager = new TextField();
		konferencePane.add(txfNavnPaaDeltager, 4, 2);
		
		//---------------------------------------
		
		lblHoteller = new Label("Hoteller:");
		hotelPane.add(lblHoteller, 0, 0);
		cbxHoteller = new ChoiceBox();
		hotelPane.add(cbxHoteller, 1, 0);
		
		//---------------------------------------
		
		lblUdflugter = new Label("Udflugter:");
		udflugtsPane.add(lblUdflugter, 0, 0);
		cbxUdflugter = new ChoiceBox();
		udflugtsPane.add(cbxUdflugter, 1, 0);
	}

}
