package gui;

import application.Betallingsmetode;
import application.Kvittering;
import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

public class AfleverAnlægPane extends GridPane {
	
	private Controller controller = Controller.getSingletonIntance();
	private ListView<Kvittering> lstUbetalteKvitteringer;
	private ComboBox<Betallingsmetode> cmbVælgBetalling = new ComboBox<Betallingsmetode>();
	
	public AfleverAnlægPane() {

		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);
		// -----------------------
		
		this.add(new Label("Ubetalte kvitteringer"), 0, 0);
		
		lstUbetalteKvitteringer = new ListView<Kvittering>();
		
		lstUbetalteKvitteringer.getItems().addAll(controller.getUbetalteKvitteringer());
		this.add(lstUbetalteKvitteringer, 0, 1);
		
		cmbVælgBetalling = new ComboBox<Betallingsmetode>();
		cmbVælgBetalling.getItems().addAll(controller.getBetallingsmetoder());
		if (cmbVælgBetalling.getItems().size() > 0) {
			cmbVælgBetalling.getSelectionModel().select(0);
		}
		this.add(cmbVælgBetalling, 1, 2);
		
		Button btnBetalOgAfl = new Button("Betal og aflever");
		btnBetalOgAfl.setOnAction(event -> betalOgAfl());
		this.add(btnBetalOgAfl, 2, 2);
		
	} 

	private void betalOgAfl() {
		Kvittering markeredeKvit = lstUbetalteKvitteringer.getSelectionModel().getSelectedItem();
		
		if (markeredeKvit  == null) {
			return;
		}
		
		controller.betalKvittering(cmbVælgBetalling.getSelectionModel().getSelectedItem(), markeredeKvit);
		controller.removeUbetaltKvitteringer(markeredeKvit);
		lstUbetalteKvitteringer.getItems().clear();
		lstUbetalteKvitteringer.getItems().addAll(controller.getUbetalteKvitteringer());
	}

	public void updateControls() {
		lstUbetalteKvitteringer.getItems().clear();
		lstUbetalteKvitteringer.getItems().addAll(controller.getUbetalteKvitteringer());
	}

}