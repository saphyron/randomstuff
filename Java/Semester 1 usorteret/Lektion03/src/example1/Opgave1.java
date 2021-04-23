package example1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Opgave1 extends Application
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
    	/*
    	 * 
    	int xvalue = 100;
    	Color changecolor = Color.YELLOW;
    	
    	Circle circle = new Circle(70 + xvalue, 70, 35);
    	pane.getChildren().add(circle);
    	circle.setFill(Color.BEIGE);
    	circle.setStroke(Color.BLACK);
    	
    	Rectangle rect = new Rectangle(110 + xvalue, 110, 20, 40);
    	pane.getChildren().add(rect);
    	rect.setFill(null);
    	rect.setStroke(Color.BLACK);
    	
    	Line line = new Line(150 + xvalue, 150, 100, 70);
    	pane.getChildren().add(line);
    	
    	line.setStroke(changecolor);
    	rect.setFill(changecolor);
    	circle.setFill(changecolor);
    	
    	
    	Circle sun = new Circle(200, 40, 35);
    	pane.getChildren().add(sun);
    	sun.setFill(Color.YELLOW);
    	sun.setStroke(Color.BLACK);
    	
    	Polygon roof = new Polygon(150, 50, 100, 100, 200, 100);
    	pane.getChildren().add(roof);
    	roof.setFill(Color.GREEN);
    	
    	Rectangle wall = new Rectangle(110, 100, 80, 90);
    	pane.getChildren().add(wall);
    	wall.setFill(Color.RED);
    	
    	Line ground = new Line(40, 190, 400, 190);
    	pane.getChildren().add(ground);
    	
    	Rectangle window = new Rectangle(120, 110, 20, 20);
    	pane.getChildren().add(window);
    	window.setFill(Color.BLACK);
    	
    	Rectangle tree = new Rectangle(250, 90, 30, 100);
    	pane.getChildren().add(tree);
    	tree.setFill(Color.BROWN);
    	tree.setStroke(Color.BLACK);
    	
    	Circle treetop = new Circle(265, 85, 25);
    	pane.getChildren().add(treetop);
    	treetop.setFill(Color.GREEN);
    	
    	*/
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
}