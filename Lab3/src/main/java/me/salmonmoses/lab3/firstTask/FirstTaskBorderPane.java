package me.salmonmoses.lab3.firstTask;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;

public class FirstTaskBorderPane extends BorderPane {
	public FirstTaskBorderPane() {
		super();

		setPadding(new Insets(20.0f));

		FigureCanvas triangle = new FigureCanvas("Зелений трикутник", gc -> {
			gc.setFill(Color.GREEN);
			gc.fillPolygon(new double[]{100, 0, 200}, new double[]{0.0, 200.0, 200.0}, 3);
		});
		FigureCanvas square = new FigureCanvas("Градієнтний квадрат", gc -> {
			gc.setFill(new LinearGradient(0, 0,
			                              200, 200,
			                              false, CycleMethod.REPEAT,
			                              new Stop(0, Color.GREEN), new Stop(1, Color.RED)));
			gc.fillRect(0, 0, 200, 200);
		});
		FigureCanvas circle = new FigureCanvas("Червоне коло", gc -> {
			gc.setStroke(Color.RED);
			gc.strokeOval(0, 0, 200, 200);
		});
		HBox shapesHBox = new HBox(triangle, square, circle);
		shapesHBox.setSpacing(16);
		setCenter(shapesHBox);

		Label programmerInfoLabel = new Label();
		programmerInfoLabel.setText("© Mykhailo Melamed, 2022");
		programmerInfoLabel.setFont(Font.font("Segoe UI"));
		programmerInfoLabel.prefHeightProperty().bind(prefWidthProperty());
		programmerInfoLabel.setAlignment(Pos.BOTTOM_RIGHT);

		AnchorPane infoLabelAnchor = new AnchorPane(programmerInfoLabel);
		infoLabelAnchor.setRightAnchor(programmerInfoLabel, 4.0);
		infoLabelAnchor.setTopAnchor(programmerInfoLabel, 4.0);
		setBottom(infoLabelAnchor);
	}
}
