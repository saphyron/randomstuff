package opgave;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Opgave3 extends Application {
	
	private ListView<Person> lvwPersons;
	private PersonInformation personVindue;
	private final Controller controller = new Controller();
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Person administration");
		GridPane pane = new GridPane();
		this.initContent(pane);

		personVindue = new PersonInformation("Add a new Person", stage);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
		
	}

	// -------------------------------------------------------------------------

	


	private void initContent(GridPane pane) {

		// pane.setGridLinesVisible(true);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		lvwPersons = new ListView<Person>();
		pane.add(lvwPersons, 1, 3);
		lvwPersons.setPrefWidth(200);
		lvwPersons.setPrefHeight(200);
		lvwPersons.getItems().setAll(controller.persons);

		Button btnAdd = new Button("Add Person");
		pane.add(btnAdd, 2, 2);
		btnAdd.setOnAction(event -> this.controller.addAction());

	}

	private class Controller {
		private ArrayList<Person> persons;

		public Controller() {
			initPersons();
		}

		private void initPersons() {
			persons = new ArrayList<Person>();
		}
		

		// -------------------------------------------------------------------------
		// Button actions

		private void addAction() {
			personVindue.showAndWait();
			if (personVindue.getPerson() != null) {
				persons.add(personVindue.getPerson());
				lvwPersons.getItems().setAll(persons);
			}
		}
	}

}
