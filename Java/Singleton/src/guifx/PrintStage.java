package guifx;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Company;
import model.Employee;
import storage.Storage;

public class PrintStage extends Stage
{
    public PrintStage(Stage owner)
    {
        this.initOwner(owner);
        this.initModality(Modality.APPLICATION_MODAL);

        this.setTitle("Print");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);

        this.setX(owner.getX() + 100);
        this.setY(owner.getY() + 50);
    }

    // -------------------------------------------------------------------------

    private Label lbl;
    private TextArea txa;

    private void initContent(GridPane pane)
    {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        lbl = new Label();
        pane.add(lbl, 0, 0);

        txa = new TextArea();
        pane.add(txa, 0, 1);
        txa.setPrefWidth(250);
        txa.setPrefRowCount(10);
        txa.setEditable(false);
        txa.setFocusTraversable(false);

        Button btnClose = new Button("Close");
        pane.add(btnClose, 0, 2);
        GridPane.setHalignment(btnClose, HPos.RIGHT);
        btnClose.setOnAction(event -> this.hide());
    }

    // -------------------------------------------------------------------------

    public void showEmployees()
    {
        lbl.setText("All Employees:");

        StringBuilder sb = new StringBuilder();
        for (Employee emp : Storage.getEmployees()) {
            Company company = emp.getCompany();
            if (company != null) {
                sb.append(emp + " - at " + emp.getCompany().getName() + "\n");
            }
            else {
                sb.append(emp + "\n");
            }
        }
        txa.setText(sb.toString());
    }

    public void showCompanies()
    {
        lbl.setText("All Companies:");

        StringBuilder sb = new StringBuilder();
        for (Company company : Storage.getCompanies()) {
            sb.append(company + "\n");
        }
        txa.setText(sb.toString());
    }

}
