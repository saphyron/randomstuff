package opgave;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Opgave1_Opgave2 extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Person administration");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private TextField txfName;
	private TextField txfTitle;
	private CheckBox checkBox;
	private ListView<Person> lvwPersons;

	private final Controller controller = new Controller();

	private void initContent(GridPane pane) {

		//pane.setGridLinesVisible(true);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		Label lblName = new Label("Name:");
		pane.add(lblName, 0, 0);
		
		Label lblTitle = new Label("Title:");
		pane.add(lblTitle, 0, 1);

		Label lblPersons = new Label("Persons:");
		pane.add(lblPersons, 0, 3);
		GridPane.setValignment(lblPersons, VPos.TOP);
		
		checkBox = new CheckBox();
		checkBox.setText("Senior");
		pane.add(checkBox, 1, 2);

		txfName = new TextField();
		pane.add(txfName, 1, 0);
		
		txfTitle = new TextField();
		pane.add(txfTitle, 1, 1);

		lvwPersons = new ListView<Person>();
		pane.add(lvwPersons, 1, 3);
		lvwPersons.setPrefWidth(200);
		lvwPersons.setPrefHeight(200);
		lvwPersons.getItems().setAll(controller.persons);

		ChangeListener<Person> listener = (ov, oldPerson, newPerson) -> this.controller.personsItemSelected();
		lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);

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
		// Selected item changed in lvwPersons

		private void personsItemSelected() {
			Person selected = lvwPersons.getSelectionModel().getSelectedItem();
			if (selected != null) {
				txfName.setText(selected.toString());
			} else {
				txfName.clear();
			}
		}

		// -------------------------------------------------------------------------
		// Button actions

		private void addAction() {
			String name = txfName.getText().trim();
			String title = txfTitle.getText().trim();
			if (name.length() > 0) {
				Person p = new Person(name, title, checkBox.isSelected());
				persons.add(p);
				lvwPersons.getItems().setAll(persons);
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Add person");
				alert.setHeaderText("No named typed");
				alert.setContentText("Type the name of the person");
				alert.show();
				// wait for the modal dialog to close
			}
		}
	}

}
