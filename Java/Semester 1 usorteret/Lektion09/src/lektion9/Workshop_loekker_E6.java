package lektion9;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Workshop_loekker_E6 extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        GridPane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Loops");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane initContent()
    {
        GridPane pane = new GridPane();
        Canvas canvas = new Canvas(200, 200);
        pane.add(canvas, 0, 0);
        //this.drawShapes(canvas.getGraphicsContext2D());
        return pane;
    }

    // ------------------------------------------------------------------------
/*
    private void drawShapes(GraphicsContext gc)
    {
    	int y1 = 160; // Starter i (x,y1)
    	int y2 = 165; // Slutter i (x,y2)
    	String s = "0"; // String
    	String n = "5"; // String
    	String g = "10"; // String
    	
        for (int i = 0; i < 11; i++) {
        	if (i % 5 == 0) {
        		int x = 10 + i * 15;
            	gc.strokeLine(x, 157.5, x, 167.5);
            	
            	}
            	
        	}
        	int x = 10 + i * 15;
        	gc.strokeLine(x, y1, x, y2);
        }
        gc.strokeLine(2, 162.5, 170, 162.5);
        gc.strokeLine(165, 160, 170, 162.5);
        gc.strokeLine(165, 165, 170, 162.5);
    }
    */

}
