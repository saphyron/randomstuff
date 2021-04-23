package example1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MainApp extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        Pane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }

    private Pane initContent()
    {
        Pane pane = new Pane();
        pane.setPrefSize(400, 400);
        this.drawShapes(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(Pane pane)
    {
    	//TODO her ændres koden så den passer til den tegning du vil lave
    	// Lige nu tegnes blå cirkel med sort kant og radius 30 med centrum 70,70
        Circle circle = new Circle(70, 70, 30);
        pane.getChildren().add(circle);
        circle.setFill(Color.CORNFLOWERBLUE);
        circle.setStroke(Color.BLACK);
        
        Circle circle2 = new Circle(60, 60 ,45);
        pane.getChildren().add(circle2);
        circle2.setFill(null);
        circle2.setStroke(Color.BLUE);
    }
}
