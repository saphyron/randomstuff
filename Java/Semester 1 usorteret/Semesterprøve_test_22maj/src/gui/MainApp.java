package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
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
import java.util.ArrayList;
import application.Invalideplads;
import application.Parkeringshus;
import application.Parkeringsplads;
import application.Bil;
import application.EnumBilmærke;
import storage.Storage;

public class MainApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void init() {
		Controller.initStorage();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Yatzy");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	// -------------------------------------------------------------------------
	
	// Attributes
	
	private Label lblparkeringshuse, lbloptagnepladser, lblbilmednummer;
	private ListView<Parkeringshus> lvwParkeringshuse;
	private ListView<Bil> lvwOptagnePladser;
	private TextField txtOpretBil;

	// -------------------------------------------------------------------------

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setStyle("-fx-border-color: black");
		
		lblparkeringshuse = new Label("Parkeringshuse");
		pane.add(lblparkeringshuse, 0, 0);
		lbloptagnepladser = new Label("Optagne pladser");
		pane.add(lbloptagnepladser, 4, 0);
		
		lvwParkeringshuse = new ListView<>();
		pane.add(lvwParkeringshuse, 0, 1);
		lvwParkeringshuse.setPrefWidth(200);
		lvwParkeringshuse.setPrefHeight(200);
		lvwParkeringshuse.getItems().addAll(Controller.getParkeringshus());
		
		lvwOptagnePladser = new ListView<>();
		pane.add(lvwOptagnePladser, 4, 1);
		lvwOptagnePladser.setPrefWidth(200);
		lvwOptagnePladser.setPrefHeight(200);
		lvwOptagnePladser.getItems().addAll(Controller.getBil());
		
		lblbilmednummer = new Label("Opret bil med nummer");
		pane.add(lblbilmednummer, 0, 2);
		
		
		
	}
	
	
}
