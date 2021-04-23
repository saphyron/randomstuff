
package loekker;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Loekker extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		GridPane root = initContent();
		Scene scene = new Scene(root);

		stage.setTitle("Loops");
		stage.setScene(scene);
		stage.show();
	}
	
	private GridPane initContent() {
		GridPane pane = new GridPane();
		Canvas canvas = new Canvas(200, 200);
		pane.add(canvas, 0, 0);
		drawShapes(canvas.getGraphicsContext2D());
		return pane;
	}
	
	// ------------------------------------------------------------------------

	
	private void drawShapes(GraphicsContext gc) {
		int x = 20;
		int y = 100;
		int r = 10;

		while (r < 100) {
			gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
			r = r + 10;
			x = x + 10;
		}
	}
	

	/*
	 private void drawShapes(GraphicsContext gc) { 
	 	String s = "Datamatikker";
	 	int i = 0; int y = 0;
	 
	 	while (i <=s.length() ) { 
	 		gc.fillText(s.substring(0, i), 20, y); 
	 		i++; 
	 		y = y +15; 
	 	} 
	 }
	 */
}
