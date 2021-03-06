package opgave;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PersonInformation extends Stage {
	public PersonInformation(String title, Stage owner) {
		this.initOwner(owner);
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setMinHeight(100);
		this.setMinWidth(200);
		this.setResizable(false);

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}
	
	private TextField txfName;
	private TextField txfTitle;
	private CheckBox checkBox;
	private ListView<Person> lvwPersons;
	private Person actuelPerson = null;

	private final Controller controller = new Controller();

	private void initContent(GridPane pane) {

		// pane.setGridLinesVisible(true);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		Label lblName = new Label("Name:");
		pane.add(lblName, 0, 0);

		Label lblTitle = new Label("Title:");
		pane.add(lblTitle, 0, 1);

		checkBox = new CheckBox();
		checkBox.setText("Senior");
		pane.add(checkBox, 1, 2);

		txfName = new TextField();
		pane.add(txfName, 1, 0);

		txfTitle = new TextField();
		pane.add(txfTitle, 1, 1);
		
		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 2, 2);
		btnCancel.setOnAction(event -> this.controller.cancelAction());

		Button btnAdd = new Button("OK");
		pane.add(btnAdd, 3, 2);
		btnAdd.setOnAction(event -> this.controller.addThisAction());
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

		private void addThisAction() {
			String name = txfName.getText().trim();
			String title = txfTitle.getText().trim();
			if (name.length() > 0 && title.length() > 0) {
				actuelPerson = new Person(name, title, checkBox.isSelected());
				//persons.add(actuelPerson);
				//lvwPersons.getItems().setAll(persons);
				PersonInformation.this.hide();
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Add person");
				alert.setHeaderText("No named typed");
				alert.setContentText("Type the name of the person");
				alert.show();
				// wait for the modal dialog to close
			}
		}
		
		private void cancelAction() {
			txfTitle.clear();
			txfTitle.requestFocus();
			txfName.clear();
			actuelPerson = null;
			PersonInformation.this.hide();
		}
		
		

	}
	public Person getPerson() {
		return actuelPerson;
	}

}