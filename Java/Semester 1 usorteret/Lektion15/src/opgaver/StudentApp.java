package opgaver;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StudentApp extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Administrer studerende");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private TextField txfName;
	private TextField txfAge;
	private CheckBox chkActive;
	private TextArea txAInf;

	private Button btnAdd;
	private Button btnAge;
	private Button btnSave;
	private Button btnGet;
	private Button btnDelete;

	private Student studerende = null;

	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);

		txAInf = new TextArea();
		txAInf.setEditable(false);
		txAInf.setPrefWidth(200);
		txAInf.setPrefHeight(60);
		pane.add(txAInf, 0, 0, 5, 1);

		Label lblName = new Label("Navn");
		pane.add(lblName, 0, 1);
		Label lblAge = new Label("Alder");
		pane.add(lblAge, 0, 2);
		Label lblActive = new Label("Aktiv");
		pane.add(lblActive, 0, 3);

		txfName = new TextField();
		pane.add(txfName, 1, 1, 4, 1);
		
		txfAge = new TextField();
		pane.add(txfAge, 1, 2, 3, 1);
		

		chkActive = new CheckBox();
		pane.add(chkActive, 1, 3);

		// add a buttons to the pane
		btnAge = new Button("Fødselsdag");
		pane.add(btnAge, 4, 2);
		
		btnAdd = new Button("Opret");
		pane.add(btnAdd, 0, 5);
		btnAge.setDisable(true);
		btnSave = new Button("Gem");
		btnSave.setDisable(true);
		pane.add(btnSave, 1, 5);
		btnGet = new Button("Hent");
		btnGet.setDisable(true);
		pane.add(btnGet, 2, 5);
		btnDelete = new Button("Slet");
		pane.add(btnDelete, 3, 5);
		btnDelete.setDisable(true);

		// connect a method to the button

		btnAdd.setOnAction(event -> this.addAction());
		btnSave.setOnAction(event -> this.saveAction());
		btnGet.setOnAction(event -> this.getAction());
		btnDelete.setOnAction(event -> this.deleteAction());
		btnAge.setOnAction(event -> this.ageAction());

	}

	private void addAction() {
		if (studerende == null) {
			studerende = new Student(txfName.getText().trim(), Integer.parseInt(txfAge.getText().trim()), chkActive.isSelected());
			clearFields();
			txAInf.setText(getDescription());
			btnGet.setDisable(false);
			btnAdd.setDisable(true);

		}

	}
	
	private void ageAction() {
		if (studerende != null) {
			studerende.increaseAge();
			txfAge.setText("" + studerende.getAge());
		}
	}

	private void saveAction() {
		if (studerende != null) {
			studerende.setName(txfName.getText().trim());
			studerende.setActive(chkActive.isSelected());
			studerende.setAge(studerende.getAge());
			clearFields();
			txAInf.setText(getDescription());
			txfAge.setDisable(true);
			btnSave.setDisable(true);
			btnDelete.setDisable(true);
			btnGet.setDisable(false);

		}

	}

	private void getAction() {
		if (studerende != null) {
			txfName.setText(studerende.getName());
			chkActive.setSelected(studerende.isActive());
			txfAge.setText("" + studerende.getAge());
			txAInf.setText(getDescription());
			btnAge.setDisable(false);
			btnSave.setDisable(false);
			btnDelete.setDisable(false);
			btnGet.setDisable(true);

		}

	}

	private void deleteAction() {
		if (studerende != null) {
			studerende = null;
			clearFields();
			txAInf.clear();
			btnDelete.setDisable(true);
			btnSave.setDisable(true);
			btnGet.setDisable(true);
			btnAdd.setDisable(false);

		}

	}

	private void clearFields() {
		txfName.clear();
		txfAge.clear();
		chkActive.setSelected(false);
	}

	private String getDescription() {
		String result = "Ingen studerende gemt";
		if (studerende != null) {
			result = studerende.toString();
		}
		return result;
	}

}
