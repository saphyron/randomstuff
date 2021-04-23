package javafxTemplates;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloWorldOneClass extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		primaryStage.setTitle("Canvas");
		
        StackPane root = new StackPane();
        
        root.getChildren().add(new Label("Hello World!"));
        
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
		
		primaryStage.show();

	}

}