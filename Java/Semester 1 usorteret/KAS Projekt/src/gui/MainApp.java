package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
		stage.setTitle("KAS Projekt");
		BorderPane pane = new BorderPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private void initContent(BorderPane pane) {
		TabPane tabPane = new TabPane();
		this.initTabPane(tabPane);
		pane.setCenter(tabPane);
	}
	
	private void initTabPane(TabPane tabPane) {
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

		//"Opret Konference"-tab
		
		Tab tabOpretKonference = new Tab("Opret Konference");
		tabPane.getTabs().add(tabOpretKonference);

		OpretKonferencePane opretKonferencePane = new OpretKonferencePane();
		tabOpretKonference.setContent(opretKonferencePane);

		
		//"Opret Hotel"-tab
		
		Tab tabOpretHotel = new Tab("Opret Hotel");
		tabPane.getTabs().add(tabOpretHotel);

		OpretHotelPane opretHotelPane = new OpretHotelPane();
		tabOpretHotel.setContent(opretHotelPane);
		
		//"Registrer Deltager"
		
		Tab tabRegistrerDeltager = new Tab("Registrer Deltager");
		tabPane.getTabs().add(tabRegistrerDeltager);

		RegistrerDeltagerPane registrerDeltagerPane = new RegistrerDeltagerPane();
		tabRegistrerDeltager.setContent(registrerDeltagerPane);
		tabRegistrerDeltager.setOnSelectionChanged(event -> registrerDeltagerPane.updateControls());
		
		//"Oversigt"
		// Virker ikke korrekt løb tør for tid og tålmodighed
		
		Tab tabOversigt = new Tab("Oversigt");
		tabPane.getTabs().add(tabOversigt);

		OversigtPane oversigtPane = new OversigtPane();
		tabOversigt.setContent(oversigtPane);
		tabOversigt.setOnSelectionChanged(event -> oversigtPane.updateControls());
	}
	
	//TODO Hvilken fane skal "opret udflugter" høre under
	
}
