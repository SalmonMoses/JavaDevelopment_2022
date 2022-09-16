package me.salmonmoses.lab3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import me.salmonmoses.lab3.firstTask.FirstTaskBorderPane;

public class Lab3Application extends Application {
	@Override
	public void start(Stage stage) {
		Button firstTaskButton = new Button("Task 1");
		firstTaskButton.setFont(Font.font("Segoe UI"));
		firstTaskButton.setOnMouseClicked(e -> openWindow(new FirstTaskBorderPane(), "Task 1"));

		Button secondTaskButton = new Button("Task 2");
		secondTaskButton.setFont(Font.font("Segoe UI"));
		secondTaskButton.setOnMouseClicked(e -> openWindow(new SecondTaskChart(), "Task 2"));

		VBox buttons = new VBox(firstTaskButton, secondTaskButton);
		buttons.setSpacing(8.0);
		buttons.setAlignment(Pos.BASELINE_CENTER);

		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(20.0));
		borderPane.setCenter(buttons);

		Scene scene = new Scene(borderPane);
		stage.setTitle("Lab 3");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

	public void openWindow(Parent root, String title) {
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle(title);
		stage.setScene(scene);
		stage.show();
	}
}