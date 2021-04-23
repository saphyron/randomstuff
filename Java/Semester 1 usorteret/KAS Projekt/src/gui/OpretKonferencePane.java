package gui;

import java.util.ArrayList;
import java.util.Optional;

import controller.Controller;
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
import model.Hotel;
import model.Konference;
import model.Serviceydelse;
import model.Udflugt;

public class OpretKonferencePane extends GridPane {

	private ListView<Konference> lvwOprettetKonferencer; 
	private ListView<Udflugt> lvwTilknyttetUdflugter;
	private Label lblOprettetKonferencer, lblTilknyttetUdflugter;
	private Konference konference;
	private Udflugt udflugt;
	private Button btnOpretKonf, btnSletKonf, btnOpdaterKonf, btnOpretUdf, btnSletUdf, btnOpdaterUdf;

	
	public OpretKonferencePane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		//--Opret-Konference-----------------------------------
		
		lblOprettetKonferencer = new Label("Oprettede konferencer:");
		this.add(lblOprettetKonferencer, 0, 0, 3, 1);

		lvwOprettetKonferencer = new ListView<>();
		this.add(lvwOprettetKonferencer, 0, 1, 3, 4);
		lvwOprettetKonferencer.setPrefWidth(200);
		lvwOprettetKonferencer.setPrefHeight(200);
		lvwOprettetKonferencer.getItems().setAll(Controller.getKonferencer());

		//--Tilknyt-Udflugter-------------------------------------		
		
		lblTilknyttetUdflugter = new Label("Oprettede udflugter til konferencen:");
		this.add(lblTilknyttetUdflugter, 5, 1);

		
		lvwTilknyttetUdflugter = new ListView<>();

		this.add(lvwTilknyttetUdflugter, 5, 2, 4, 2);
		lvwTilknyttetUdflugter.setPrefWidth(200);
		lvwTilknyttetUdflugter.setPrefHeight(150);
		lvwTilknyttetUdflugter.getItems().setAll(Controller.getUdflugt());

		//--Buttons-for-"Opret konferencer"--------------------------------
	
		HBox hbxBtnKonf = new HBox(30);
		this.add(hbxBtnKonf, 0, 5, 3, 1);
		hbxBtnKonf.setPadding(new Insets(10, 0, 0, 0));
		hbxBtnKonf.setAlignment(Pos.BASELINE_CENTER);

		btnOpretKonf = new Button("Opret");
		hbxBtnKonf.getChildren().add(btnOpretKonf);
		btnOpretKonf.setOnAction(event -> this.opretKonferenceAction());

		btnSletKonf = new Button("Slet");
		hbxBtnKonf.getChildren().add(btnSletKonf);
		btnSletKonf.setOnAction(event -> this.sletKonferenceAction());

		btnOpdaterKonf = new Button("Opdater");
		hbxBtnKonf.getChildren().add(btnOpdaterKonf);
		btnOpdaterKonf.setOnAction(event -> this.opdaterKonferenceAction());


		//--Buttons-for-"Opret udflugt"----------------------------------
		
		HBox hbxBtnUdf = new HBox(30);
		this.add(hbxBtnUdf, 5, 5, 3, 1);
		hbxBtnUdf.setPadding(new Insets(10, 0, 0, 0));
		hbxBtnUdf.setAlignment(Pos.BASELINE_CENTER);

		btnOpretUdf = new Button("Opret");
		hbxBtnUdf.getChildren().add(btnOpretUdf);
		btnOpretUdf.setOnAction(event -> this.opretUdflugtAction());

		btnSletUdf = new Button("Slet(Virker ikke)");
		hbxBtnUdf.getChildren().add(btnSletUdf);
		btnSletUdf.setOnAction(event -> this.sletUdflugtAction());

		btnOpdaterUdf = new Button("Opdater");
		hbxBtnUdf.getChildren().add(btnOpdaterUdf);
		btnOpdaterUdf.setOnAction(event -> this.opdaterUdflugtAction());

		
		//--Buttons-for-"Tilknyt hoteller"--------------------------------
		
		HBox hbxBtnHotel = new HBox(30);
		this.add(hbxBtnHotel, 11, 5, 3, 1);
		hbxBtnHotel.setPadding(new Insets(10, 0, 0, 0));
		hbxBtnHotel.setAlignment(Pos.BASELINE_CENTER);
		

//		ChangeListener<Udflugt> listenerU = (ov, oldUdflugt, newUdflugt) -> this.selectedCompanyChanged();
//		lvwTilknyttetUdflugter.getSelectionModel().selectedItemProperty().addListener(listenerU);

		
		
	}


	//--Button-actions-"Oprettede Konferecer"---------------------------------

	private void opretKonferenceAction() {
		OpretKonferenceWindow dia = new OpretKonferenceWindow("Opret Konference", konference);
		dia.showAndWait();

		//viser toString() for alle Konference-objekterne i lvwOprettetKonferencer
		
		lvwOprettetKonferencer.getItems().setAll(Controller.getKonferencer());
		int index = lvwOprettetKonferencer.getItems().size() - 1;
		lvwOprettetKonferencer.getSelectionModel().select(index);

	}

	private void sletKonferenceAction() {
		
		konference = lvwOprettetKonferencer.getSelectionModel().getSelectedItem();
		if (konference == null) {
			return;
		}

		
		if (konference.getBooking_konferencer().size() > 0) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Delete Company");
			// alert.setContentText("Are you sure?");
			alert.setHeaderText("Are you sure?");
			Optional<ButtonType> result = alert.showAndWait();

			if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
				Controller.deleteKonference(konference);
				lvwOprettetKonferencer.getItems().setAll(Controller.getKonferencer());
//				this.updateControls();
			}

		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Delete Company");
			alert.setHeaderText("Can't delete a company that has emlpoyees");
			// wait for the modal dialog to close
			alert.show();
		}


	}
	

	private void opdaterKonferenceAction() {
		
		konference = lvwOprettetKonferencer.getSelectionModel().getSelectedItem();
		if (konference == null) {
			return;
		}

		OpretKonferenceWindow dia = new OpretKonferenceWindow("Opdater konference", konference);
		dia.showAndWait();

		// Wait for the modal dialog to close
		
		int selectIndex = lvwOprettetKonferencer.getSelectionModel().getSelectedIndex();
		lvwOprettetKonferencer.getItems().setAll(Controller.getKonferencer());
		lvwOprettetKonferencer.getSelectionModel().select(selectIndex);		
		
	}
	
	
	//--Button-actions-"Opret Udflugt"---------------------------------
	

	private void opretUdflugtAction() {
		
		OpretUdflugtWindow dia = new OpretUdflugtWindow("Opret udflugt", udflugt);
		dia.showAndWait();

		//viser toString() for alle Konference-objekterne i lvwOprettetKonferencer
		
		lvwTilknyttetUdflugter.getItems().setAll(Controller.getUdflugt());
		int index = lvwTilknyttetUdflugter.getItems().size() - 1;
		lvwTilknyttetUdflugter.getSelectionModel().select(index);
		
		System.out.println(Controller.getUdflugt());
	}

	private void opdaterUdflugtAction() {

		Udflugt udflugt = lvwTilknyttetUdflugter.getSelectionModel().getSelectedItem();
		if (udflugt == null) {
			return;
		}

		OpretUdflugtWindow dia = new OpretUdflugtWindow("Opdater konference", udflugt);
		dia.showAndWait();

		// Wait for the modal dialog to close
		
		lvwTilknyttetUdflugter.getItems().setAll(Controller.getUdflugt());
		int index = lvwTilknyttetUdflugter.getItems().size() - 1;
		lvwTilknyttetUdflugter.getSelectionModel().select(index);
			
	}


	private void sletUdflugtAction() {

		udflugt = lvwTilknyttetUdflugter.getSelectionModel().getSelectedItem();
		System.out.println(udflugt);
		if (udflugt == null) {
			return;
		}
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Slet udflugt");
		// alert.setContentText("Are you sure?");
		alert.setHeaderText("Er du sikker?");
		Optional<ButtonType> result = alert.showAndWait();

		// Wait for the modal dialog to close

		if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
			konference.removeUdflugt(udflugt);
			lvwTilknyttetUdflugter.getSelectionModel().clearSelection();
			lvwTilknyttetUdflugter.getItems().setAll(konference.getUdflugter());
		}
		
		
	}
	
	
//	private void selectedCompanyChanged() {
//		this.updateControls();
//	}
//
//	public void updateControls() {
//		Udflugt udflugt = lvwTilknyttetUdflugter.getSelectionModel().getSelectedItem();
//		
//	}
	
	
	//--Button-actions-"Tilknyt hoteller"---------------------------------

	




}
