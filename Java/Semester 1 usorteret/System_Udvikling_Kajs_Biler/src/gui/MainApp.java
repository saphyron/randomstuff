package gui;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class MainApp extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Kaj's Biler");
		GridPane pane = new GridPane();
		this.initContent(pane);

		udlejBilWindow = new UdlejBilGui("Udlej Biler", stage);
		opretBilWindow = new OpretBilGui("Opret Biler", stage);
		reserverGruppeGui = new ReserverGruppeGui("Udlej Biler", stage);
		opretKundeGui = new OpretKundeGui("Udlej Biler", stage);
		sletKundeGui = new SletKundeGui("Udlej Biler", stage);
		kundeDetaljerGui = new KundeDetaljerGui("Udlej Biler", stage);
		opretFirmaGui = new OpretFirmaGui("Udlej Biler", stage);
		sletFirmaGui = new SletFirmaGui("Udlej Biler", stage);
		firmaDetaljerGui = new FirmaDetaljerGui("Udlej Biler", stage);
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();

	}
	
	private UdlejBilGui udlejBilWindow;
	private OpretBilGui opretBilWindow;
	private ReserverGruppeGui reserverGruppeGui;
	private OpretKundeGui opretKundeGui;
	private SletKundeGui sletKundeGui;
	private KundeDetaljerGui kundeDetaljerGui;
	private OpretFirmaGui opretFirmaGui;
	private SletFirmaGui sletFirmaGui;
	private FirmaDetaljerGui firmaDetaljerGui;
	private Label lblBiler, lblKajsBiler, lblPrivatKunder, lblErhvervsKunder;
	private ListView lvwBiler, lvwPrivatKunder, lvwErhvervsKunder;
	private Button btnOpretBil, btnUdlejBil, btnReserverGruppe;
	
	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		
		// - - - - Overskrift - - - - - - - - - 
		
		lblKajsBiler = new Label("Kaj's Biler");
		pane.add(lblKajsBiler, 1, 0);
		
		// - - - - Panes - - - - - - - - - 

		
		GridPane bilerPane = new GridPane();
		pane.add(bilerPane, 0, 1);
		bilerPane.setGridLinesVisible(false);
		bilerPane.setPadding(new Insets(10));
		bilerPane.setHgap(10);
		bilerPane.setVgap(10);
		bilerPane.setStyle("-fx-border-color: black");
		
		GridPane kundePane = new GridPane();
		pane.add(kundePane, 1, 1);
		kundePane.setGridLinesVisible(false);
		kundePane.setPadding(new Insets(10));
		kundePane.setHgap(10);
		kundePane.setVgap(10);
		kundePane.setStyle("-fx-border-color: black");
		
		GridPane ErhvervsPane = new GridPane();
		pane.add(ErhvervsPane, 2, 1);
		ErhvervsPane.setGridLinesVisible(false);
		ErhvervsPane.setPadding(new Insets(10));
		ErhvervsPane.setHgap(10);
		ErhvervsPane.setVgap(10);
		ErhvervsPane.setStyle("-fx-border-color: black");
		
		// - - - - Biler Pane - - - - - - - - - 
		
		lblBiler = new Label("Biler");
		bilerPane.add(lblBiler, 0, 0);
		
		lvwBiler = new ListView();
		bilerPane.add(lvwBiler, 0, 1, 2, 4);
		
		HBox hbxButtonsBiler = new HBox(40);
		bilerPane.add(hbxButtonsBiler, 0, 5);
		hbxButtonsBiler.setPadding(new Insets(10, 0, 0, 0));
		hbxButtonsBiler.setAlignment(Pos.BASELINE_CENTER);
		
		btnOpretBil = new Button("Opret Bil");
		hbxButtonsBiler.getChildren().add(btnOpretBil);
		btnOpretBil.setOnAction(event -> this.opretBilAction());
		
		btnUdlejBil = new Button("Udlej Bil");
		hbxButtonsBiler.getChildren().add(btnUdlejBil);
		btnUdlejBil.setOnAction(event -> this.udlejBilAction());
		
		btnReserverGruppe = new Button("Reserver Gruppe");
		hbxButtonsBiler.getChildren().add(btnReserverGruppe);
		btnReserverGruppe.setOnAction(event -> this.reserverGruppeAction());
		
		
		
		// - - - - Kunde Pane - - - - - - - - - 
		
		lblPrivatKunder = new Label("Privats Kunder");
		kundePane.add(lblPrivatKunder, 0, 0);
		
		lvwPrivatKunder = new ListView();
		kundePane.add(lvwPrivatKunder, 0, 1, 2, 4);

		// - - - - Erhvervs Pane - - - - - - - - - 

		lblErhvervsKunder = new Label("Erhvervs Kunder");
		ErhvervsPane.add(lblErhvervsKunder, 0, 0);
		
		lvwErhvervsKunder = new ListView();
		ErhvervsPane.add(lvwErhvervsKunder, 0, 1, 2, 4);

	}
	
	public void opretBilAction() {
		opretBilWindow.showAndWait();
	}
	
	public void udlejBilAction() {
		udlejBilWindow.showAndWait();
	}
	
	public void reserverGruppeAction() {
		reserverGruppeGui.showAndWait();
	}
	
	public void opretKundeAction() {
		opretKundeGui.showAndWait();
	}
	
	public void sletKundeAction() {
		sletKundeGui.showAndWait();
	}
	
	public void kundeDetaljerAction() {
		kundeDetaljerGui.showAndWait();
	}
	
	public void opretFirmaAction() {
		opretFirmaGui.showAndWait();
	}
	
	public void sletFirmaAction() {
		sletFirmaGui.showAndWait();
	}
	
	public void firmaDetaljerAction() {
		firmaDetaljerGui.showAndWait();
	}

}
