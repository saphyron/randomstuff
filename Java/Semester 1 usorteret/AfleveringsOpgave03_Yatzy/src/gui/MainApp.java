package gui;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Yatzy;

public class MainApp extends Application {
	public static void main(String[] args) {
		Application.launch(args);
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

	// Shows the face values of the 5 dice.
	private TextField[] txfValues = new TextField[5];
	// Shows the hold status of the 5 dice.
	private CheckBox[] chbHolds = new CheckBox[5];
	// Shows the results previously selected .
	// For free results (results not set yet), the results
	// corresponding to the actual face values of the 5 dice are shown.
	private TextField[] txfResults = new TextField[15];
	private boolean[] test = new boolean[5];
	// Shows the number of times the dice has been rolled.
	private Label lblRolled;
	private Button btnRoll;

	private int rolled;
	private int sumSum01 = 0;
	private int sumSum02 = 0;
	private int sumBonus = 0;
	private int sumTotal = 0;

	private TextField txfSum01 = new TextField();
	private TextField txfBonus01 = new TextField();
	private TextField txfSum02 = new TextField();
	private TextField txfTotal01 = new TextField();
	private int[] tempResults = new int[15];

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);

		// ---------------------------------------------------------------------

		GridPane dicePane = new GridPane();
		pane.add(dicePane, 0, 0);
		dicePane.setGridLinesVisible(false);
		dicePane.setPadding(new Insets(10));
		dicePane.setHgap(10);
		dicePane.setVgap(10);
		dicePane.setStyle("-fx-border-color: black");

		// Kode til at lave Dice Throw TextFields
		int y = 75;
		int values = 5;
		for (int i = 0; i < values; i++) {
			TextField Field = new TextField();
			dicePane.add(Field, i, 0);
			txfValues[i] = Field;
			Field.setPrefWidth(y);
			Field.setPrefHeight(y);
		}
		
		// Kode til at lave CheckBox Holds
		for (int i = 0; i < values; i++) {
			CheckBox check = new CheckBox("Hold");
			dicePane.add(check, i, 1);
			chbHolds[i] = check;
		}
		
		// Kode til at lave Roll Knap
		btnRoll = new Button("Roll");
		dicePane.add(btnRoll, 3, 2);
		btnRoll.setPrefWidth(y);
		btnRoll.setPrefHeight(50);
		lblRolled = new Label("Rolled: " + this.rolled);
		dicePane.add(lblRolled, 4, 2);
		btnRoll.setOnAction(event -> btnRollAction());

		// ---------------------------------------------------------------------

		GridPane scorePane = new GridPane();
		pane.add(scorePane, 0, 1);
		scorePane.setGridLinesVisible(false);
		scorePane.setPadding(new Insets(10));
		scorePane.setVgap(5);
		scorePane.setHgap(10);
		scorePane.setStyle("-fx-border-color: black");
		int w = 50; // width of the text fields

		// Kode for at lave txfResult TextFields
		for (int i = 0; i < 15; i++) {
			TextField field2 = new TextField();
			scorePane.add(field2, 1, i + 1);
			txfResults[i] = field2;
			field2.setPrefWidth(w);
			field2.setOnMouseClicked(event -> this.chooseFieldAction(event));
		}
		// Slut med txfResult TextFields

		// Kode for at lave labels til resultaterne
		Label lblTxt01 = new Label("1-s");
		scorePane.add(lblTxt01, 0, 1);
		Label lblTxt02 = new Label("2-s");
		scorePane.add(lblTxt02, 0, 2);
		Label lblTxt03 = new Label("3-s");
		scorePane.add(lblTxt03, 0, 3);
		Label lblTxt04 = new Label("4-s");
		scorePane.add(lblTxt04, 0, 4);
		Label lblTxt05 = new Label("5-s");
		scorePane.add(lblTxt05, 0, 5);
		Label lblTxt06 = new Label("6-s");
		scorePane.add(lblTxt06, 0, 6);
		Label lblTxt07 = new Label("One pair");
		scorePane.add(lblTxt07, 0, 7);
		Label lblTxt08 = new Label("Two pair");
		scorePane.add(lblTxt08, 0, 8);
		Label lblTxt09 = new Label("Three Same");
		scorePane.add(lblTxt09, 0, 9);
		Label lblTxt10 = new Label("Four Same");
		scorePane.add(lblTxt10, 0, 10);
		Label lblTxt11 = new Label("Full House");
		scorePane.add(lblTxt11, 0, 11);
		Label lblTxt12 = new Label("Small Straight");
		scorePane.add(lblTxt12, 0, 12);
		Label lblTxt13 = new Label("Large Straight");
		scorePane.add(lblTxt13, 0, 13);
		Label lblTxt14 = new Label("Chance");
		scorePane.add(lblTxt14, 0, 14);
		Label lblTxt15 = new Label("Yatzy");
		scorePane.add(lblTxt15, 0, 15);
		// Slut med Labels
		
		// Kode for at lave Labels/TextField til Sum og Bonus
		Label lblTxtSum01 = new Label("Sum:");
		scorePane.add(lblTxtSum01, 2, 6);
		scorePane.add(txfSum01, 3, 6);
		txfSum01.setPrefWidth(w);
		
		Label lblTxtBonus01 = new Label("Bonus:");
		scorePane.add(lblTxtBonus01, 4, 6);
		scorePane.add(txfBonus01, 5, 6);
		txfBonus01.setPrefWidth(w);
		// Slut med Sum og Bonus

		// Kode for at lave Labels/TextFields til Sum og Total
		Label lblTxtSum02 = new Label("Sum:");
		scorePane.add(lblTxtSum02, 2, 15);
		scorePane.add(txfSum02, 3, 15);
		txfSum02.setPrefWidth(w);

		Label lblTxtTotal01 = new Label("Total:");
		scorePane.add(lblTxtTotal01, 4, 15);
		scorePane.add(txfTotal01, 5, 15);
		txfTotal01.setPrefWidth(w);
		// Slut med Sum og Total

	}

	// -------------------------------------------------------------------------

	private Yatzy dice = new Yatzy();

	// Kode til at Hold CheckBox Event Action
	private void btnHoldCheck() {
		for (int i = 0; i < txfValues.length; i++) {
			if (chbHolds[i].isSelected()) {
				test[i] = true;
			} else if (!chbHolds[i].isSelected()) {
				test[i] = false;
			}
		}
	}
	// Slut med Hold CheckBox Event Action
	
	// Kode til at Roll Knap Event Action
	private void btnRollAction() {
		btnHoldCheck();
		dice.throwDice(test);
		lblRolled.setText("Rolled: " + dice.getThrowCount());
		int[] temp = dice.getValues();
		for (int i = 0; i < txfValues.length; i++) {
			if (!this.test[i]) {
				txfValues[i].setText("" + temp[i]);
			}

		}
		// Kode til at Få vist resultat i txfResult når man har rolled 3 gange
		System.out.println();
		if (dice.getThrowCount() == 3) {
			btnRoll.setDisable(true);
			tempResults = dice.getResults();
			for (int i = 0; i < 15; i++) {
				if (!txfResults[i].isDisabled())
					txfResults[i].setText("" + tempResults[i]);
			}
		}

	}
	// Slut med Roll Knap Event Action

	// Kode til at vælge et Felt Event Action
	public void chooseFieldAction(Event event) {
		if (dice.getThrowCount() == 3) { // Kode for at sørge for man ikke kan vølge et Felt før man har rolled 3 gange
			TextField txt = (TextField) event.getSource();
			txt.setDisable(true);
			for (int i = 0; i < txfValues.length; i++) { // Kode for at clear de felter der ikke blev valgt
				txfValues[i].setText(null);
			}
			for (int i = 0; i < txfResults.length; i++) { //Kode for at ikke kunne overskrive de felter der er blevet valgt
				if (!txfResults[i].isDisabled())
					txfResults[i].setText(null);
			}
			dice.resetThrowCount(); // Kode for at reset hvor mange kast man har lavet
			for (int i = 0; i < chbHolds.length; i++) { // Kode for at reset CheckBox Holds
				chbHolds[i].setSelected(false);
				test[i] = false;
			}
			btnRoll.setDisable(false); // Kode for at kunne rolle igen
			lblRolled.setText("Rolled: " + dice.getThrowCount()); // Kode for at omskrive label der viser hvor mange rolls man har lavet

			if (txt == txfResults[0] || txt == txfResults[1] || txt == txfResults[2] || txt == txfResults[3] // Kode for at sørge for bestemte Felter addes til Sum
					|| txt == txfResults[4] || txt == txfResults[5]) {
				sumSum01 = sumSum01 + Integer.parseInt(txt.getText());
			} else if (txt == txfResults[6] || txt == txfResults[7] || txt == txfResults[8] || txt == txfResults[9] // Kode for at sørge for andre bestemte felter addes til Sum2
					|| txt == txfResults[10] || txt == txfResults[11] || txt == txfResults[12] || txt == txfResults[13]
					|| txt == txfResults[14]) {
				sumSum02 = sumSum02 + Integer.parseInt(txt.getText());
			}

			if (sumSum01 >= 63) { // Kode til at give Bonus
				sumBonus = 50;
			} else {
				sumBonus = 0;
			}
			
			sumTotal = sumSum01 + sumSum02 + sumBonus; // Kode til at udregne total
			
			// Kode til at skrive i felterne deres værdi.
			txfSum01.setText("" + sumSum01);
			txfSum02.setText("" + sumSum02);
			txfBonus01.setText("" + sumBonus);
			txfTotal01.setText("" + sumTotal);
		}
		
	}
}
