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
		Controller controller = Controller.getSingletonIntance();
		controller.init();
	}
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Aarhus Bryghus");
		BorderPane pane = new BorderPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setHeight(500);
		stage.setWidth(800);
		
		stage.show();
	}

	private void initContent(BorderPane pane) {
		TabPane tabPane = new TabPane();
		this.initTabPane(tabPane);
		pane.setCenter(tabPane);
	}

	private void initTabPane(TabPane tabPane) {
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

		Tab tab01 = new Tab("Salg");
		Tab tab02 = new Tab("Bestil anlæg");
		Tab tab03 = new Tab("Regnskab");
		Tab tab04 = new Tab("Opret kunde");
		Tab tab05 = new Tab("Opret pris");
		Tab tab06 = new Tab("Opret produkt");
		Tab tab07 = new Tab("Aflever anlæg");
		
		SalgsPane salgsPane = new SalgsPane();
		BestilAnlægPane rsvPane = new BestilAnlægPane();
		RegnskabsPane rskPane = new RegnskabsPane();
		OpretKunde opretKundePane = new OpretKunde();
		OpretPrisogPrislistePane opretPrisogPrislistePane = new OpretPrisogPrislistePane();
		OpretProduktPane opretProduktPane = new OpretProduktPane();
		AfleverAnlægPane afleverAnlægPane = new AfleverAnlægPane();
		
		tab01.setContent(salgsPane);
		tab02.setContent(rsvPane);
		tab03.setContent(rskPane);
		tab04.setContent(opretKundePane);
		tab05.setContent(opretPrisogPrislistePane);
		tab06.setContent(opretProduktPane);
		tab07.setContent(afleverAnlægPane);
		//initialisere alle fanerne

		tabPane.getTabs().add(tab01);
		tabPane.getTabs().add(tab02);
		tabPane.getTabs().add(tab03);
		tabPane.getTabs().add(tab04);
		tabPane.getTabs().add(tab05);
		tabPane.getTabs().add(tab06);
		tabPane.getTabs().add(tab07);
		
		tab01.setOnSelectionChanged(event -> salgsPane.updateControls());
		tab02.setOnSelectionChanged(event -> rsvPane.updateControls());
		tab03.setOnSelectionChanged(event -> rskPane.updateControls());
		tab04.setOnSelectionChanged(event -> opretKundePane.updateControls());
		tab05.setOnSelectionChanged(event -> opretPrisogPrislistePane.updateControls());
		tab06.setOnSelectionChanged(event -> opretProduktPane.updateControls());
		tab07.setOnSelectionChanged(event -> afleverAnlægPane.updateControls());
	
	}
}
