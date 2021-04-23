package guifx;

import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Employee;
import service.Service;
import storage.Storage;

public class EmployeePane extends GridPane
{
    private TextField txfName, txfWage, txfCompany, txfSalary;
    private ListView<Employee> lvwEmployees;

    public EmployeePane()
    {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblComp = new Label("Employees");
        this.add(lblComp, 0, 0);

        lvwEmployees = new ListView<>();
        this.add(lvwEmployees, 0, 1, 1, 5);
        lvwEmployees.setPrefWidth(200);
        lvwEmployees.setPrefHeight(200);
        lvwEmployees.getItems().setAll(this.initAllEmpList());
        ChangeListener<Employee> listener =
            (ov, oldEmployee, newEmployee) -> this.selectedEmployeeChanged();
        lvwEmployees.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblName = new Label("Name:");
        this.add(lblName, 1, 1);

        txfName = new TextField();
        this.add(txfName, 2, 1);
        txfName.setPrefWidth(200);
        txfName.setEditable(false);

        Label lblWage = new Label("Hourly Wage:");
        this.add(lblWage, 1, 2);

        txfWage = new TextField();
        this.add(txfWage, 2, 2);
        txfWage.setEditable(false);

        Label lblCompany = new Label("Company:");
        this.add(lblCompany, 1, 3);

        txfCompany = new TextField();
        this.add(txfCompany, 2, 3);
        txfCompany.setEditable(false);

        Label lblSalary = new Label("Weekly Salary:");
        this.add(lblSalary, 1, 4);

        txfSalary = new TextField();
        this.add(txfSalary, 2, 4);
        txfSalary.setEditable(false);

        HBox hbxButtons = new HBox(40);
        this.add(hbxButtons, 0, 6, 3, 1);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnCreate = new Button("Create");
        hbxButtons.getChildren().add(btnCreate);
        btnCreate.setOnAction(event -> this.createAction());

        Button btnUpdate = new Button("Update");
        hbxButtons.getChildren().add(btnUpdate);
        btnUpdate.setOnAction(event -> this.updateAction());

        Button btnDelete = new Button("Delete");
        hbxButtons.getChildren().add(btnDelete);
        btnDelete.setOnAction(event -> this.deleteAction());

        if (lvwEmployees.getItems().size() > 0) {
            lvwEmployees.getSelectionModel().select(0);
        }
    }

    private ArrayList<Employee> initAllEmpList()
    {
        ArrayList<Employee> list = new ArrayList<>();
        for (Employee emp : Storage.getEmployees()) {
            list.add(emp);
        }
        return list;
    }

    // -------------------------------------------------------------------------

    private void createAction()
    {
        EmployeeDialog dia = new EmployeeDialog("Create Employee");
        dia.showAndWait();

        // Wait for the modal dialog to close

        lvwEmployees.getItems().setAll(this.initAllEmpList());
        this.updateControls();
    }

    private void updateAction()
    {
        Employee employee = lvwEmployees.getSelectionModel().getSelectedItem();
        if (employee == null)
            return;

        EmployeeDialog dia = new EmployeeDialog("Update Employee", employee);
        dia.showAndWait();

        // Wait for the modal dialog to close

        int selectIndex = lvwEmployees.getSelectionModel().getSelectedIndex();
        lvwEmployees.getItems().setAll(this.initAllEmpList());
        lvwEmployees.getSelectionModel().select(selectIndex);
    }

    private void deleteAction()
    {
        Employee employee = lvwEmployees.getSelectionModel().getSelectedItem();
        if (employee == null)
            return;

        Stage owner = (Stage) this.getScene().getWindow();
        ConfirmDialog dialog = new ConfirmDialog("Delete Employee", owner);
        dialog.initMessage("Are you sure?");
        dialog.showAndWait();

        // Wait for the modal dialog to close

        if (dialog.isConfirmed()) {
            Service.deleteEmployee(employee);
            lvwEmployees.getItems().setAll(this.initAllEmpList());
            this.updateControls();
        }
    }

    // -------------------------------------------------------------------------

    private void selectedEmployeeChanged()
    {
        this.updateControls();
    }

    public void updateControls()
    {
        Employee employee = lvwEmployees.getSelectionModel().getSelectedItem();
        if (employee != null) {
            txfName.setText(employee.getName());
            txfWage.setText("kr " + employee.getWage());
            if (employee.getCompany() != null) {
                txfCompany.setText("" + employee.getCompany());
                txfSalary.setText("kr " + employee.weeklySalary());
            }
            else {
                txfCompany.clear();
                txfSalary.clear();
            }
        }
        else {
            txfName.clear();
            txfWage.clear();
            txfCompany.clear();
            txfSalary.clear();
        }
    }

}
