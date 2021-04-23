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
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import model.Bil;
import model.Booking;
import model.Lift;
import model.Stjerner;
import storage.Storage;

public class App extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	// Opgave 10
	@Override
	public void init() {
		Controller.initStorage();
		Controller.createAnbefaling(Stjerner.TO, "Han koerer for hurtigt!");
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Samkoersel");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	// Attributes

	private Label lblUdbudteLift, lblpassager, lblopsamlingssted, lblopsamlingstid, lblbookinger;
	private TextField txtdatoPaaLift, txtpassager, txtopsamlingssted, txtopsamlingstid, txtbookinger;
	private Button btVisLift, btOpretBooking;
	private ListView<Booking> lvwBookings;
	private ListView<Lift> lvwListAfLift;
	private Lift lift;
	private Bil bil;
	private Booking booking;

	// -------------------------------------------------------------------------

	// Opgave 11
	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setStyle("-fx-border-color: black");

		lblUdbudteLift = new Label("Udbudte lift paa dato:");
		pane.add(lblUdbudteLift, 0, 0);
		lblUdbudteLift.setPrefWidth(125);
		txtdatoPaaLift = new TextField();
		pane.add(txtdatoPaaLift, 1, 0);
		btVisLift = new Button("Vis lift");
		pane.add(btVisLift, 2, 0);
		btVisLift.setPrefWidth(50);
		btVisLift.setOnAction(event -> getLift());

		lvwListAfLift = new ListView();
		pane.add(lvwListAfLift, 0, 1, 4, 7);
		lvwListAfLift.setPrefWidth(200);

		lblpassager = new Label("Passager:");
		pane.add(lblpassager, 4, 2);
		txtpassager = new TextField();
		pane.add(txtpassager, 5, 2);

		lblopsamlingssted = new Label("Opsamlingssted:");
		pane.add(lblopsamlingssted, 4, 3);
		txtopsamlingssted = new TextField();
		pane.add(txtopsamlingssted, 5, 3);
		lblopsamlingssted.setPrefWidth(100);

		lblopsamlingstid = new Label("Opsamlings tid:");
		pane.add(lblopsamlingstid, 4, 4);
		txtopsamlingstid = new TextField();
		pane.add(txtopsamlingstid, 5, 4);

		btOpretBooking = new Button("Opret Booking");
		pane.add(btOpretBooking, 5, 5);
		btOpretBooking.setOnAction(event -> createBooking());

		lblbookinger = new Label("Bookinger:");
		pane.add(lblbookinger, 4, 6);
		lvwBookings = new ListView();
		pane.add(lvwBookings, 4, 7, 2, 1);
		lvwBookings.setPrefWidth(200);
		lvwBookings.getItems().setAll(Storage.getBooking());

	}

	private void getLift() {
		LocalDateTime liftTidspunkt = LocalDateTime.parse(txtdatoPaaLift.getText().trim(), formatter2);
		for (int i = 0; i < bil.getLs().size(); i++) {
			if (bil.getLs().get(i).getTidspunkt() == liftTidspunkt) {
				ArrayList<Lift> tempLift = new ArrayList<>();
				for (int j = 0; j < bil.getLs().size(); j++) {
					tempLift.add(bil.getLs().get(j));
				}
				lvwListAfLift.getItems().setAll(tempLift);	
			}
		}
		
			
	}

	DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;
	DateTimeFormatter formatter2 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

	private void createBooking() {
		String passagerNavn = txtpassager.getText().trim();
		String opsamlingssted = txtopsamlingssted.getText().trim();
		LocalTime opsamlingstid = LocalTime.parse(txtopsamlingstid.getText().trim(), formatter);
		if (passagerNavn.length() != 0 && opsamlingssted.length() != 0) {
			Booking bookinger = Controller.createBooking(passagerNavn, opsamlingssted, opsamlingstid,
					lvwListAfLift.getSelectionModel().getSelectedItem());

		}
		lvwBookings.getItems().setAll(Storage.getBooking());
		clearFields();
	}

	private void clearFields() {
		txtpassager.clear();
		txtopsamlingssted.clear();
		txtopsamlingstid.clear();
	}

}
