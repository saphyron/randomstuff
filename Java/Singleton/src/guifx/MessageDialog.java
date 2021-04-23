package guifx;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MessageDialog extends Stage
{
    public MessageDialog(String title, Stage owner)
    {
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

    // -------------------------------------------------------------------------

    private Label lblMessage;

    private void initContent(GridPane pane)
    {
//        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setVgap(20);

        lblMessage = new Label();
        pane.add(lblMessage, 0, 0);
        GridPane.setHalignment(lblMessage, HPos.CENTER);
        GridPane.setHgrow(lblMessage, Priority.ALWAYS);

        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 1);
        GridPane.setHalignment(btnOK, HPos.CENTER);
        btnOK.setOnAction(event -> this.okAction());
    }

    // -------------------------------------------------------------------------

    public void initMessage(String text)
    {
        lblMessage.setText(text);
    }

    // -------------------------------------------------------------------------
    // Button action

    private void okAction()
    {
        this.hide();
    }

}
