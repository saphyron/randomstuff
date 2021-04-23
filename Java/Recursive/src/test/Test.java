package test;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;

public class Test extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	private GraphicsContext gc;
	
	private int screenWidth = 1366;;
	private int screenHeight = 760;
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Canvas");
		final Canvas canvas = new Canvas(screenWidth, screenHeight);
		gc = canvas.getGraphicsContext2D();

		drawTree(660, 650, 100, 30);

		StackPane root = new StackPane();
		


		root.getChildren().add(canvas);

		primaryStage.setScene(new Scene(root, screenWidth, screenHeight));
		primaryStage.show();
		
	}
	private Random rand;
	
	private int angleDifuse; 
	private double lenShortener;
	private int linesStrokedCounter;
	private boolean colorMagic;
    private String getRandomHexString(int numchars){
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < numchars){
            sb.append(Integer.toHexString(r.nextInt()));
        }

        return sb.toString().substring(0, numchars);
    }
	
	private void initTree(double x0, double y0, double len, double angle){
		
		if (len < 20)
			return;
	
		linesStrokedCounter++;
		
		double x1 = x0 + len * Math.cos(Math.toRadians(angle));
		double y1 = y0 - len * Math.sin(Math.toRadians(angle));
		
		double x2 = x0 + len * Math.cos(Math.toRadians(angle + 90));
		double y2 = y0 - len * Math.sin(Math.toRadians(angle + 90));
		
		if (colorMagic)
			gc.setStroke(Color.web("" + getRandomHexString(6)));
		
		
		gc.strokeLine(x0, y0, x1, y1);
		gc.strokeLine(x0, y0, x2, y2);
		
		initTree(x1, y1, len * lenShortener, angle - (angleDifuse));
		initTree(x2, y2, len * lenShortener, angle + (angleDifuse));
		
		

	}
	
	private void drawTree(double x0, double y0, double len, double angle){
		

		angleDifuse = 12; // max 20
		lenShortener = 0.90; 
		colorMagic = true;
		
		linesStrokedCounter = 0;
		initTree(x0, y0, len, angle);
		System.out.println("Lines stroke amount: " + linesStrokedCounter);
		
		
		
	}
	}