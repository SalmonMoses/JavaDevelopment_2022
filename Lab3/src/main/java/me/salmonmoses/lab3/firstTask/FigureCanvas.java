package me.salmonmoses.lab3.firstTask;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.util.function.Consumer;

public class FigureCanvas extends VBox {
	private String caption;
	private Consumer<GraphicsContext> drawingFunction;

	public FigureCanvas(String caption, Consumer<GraphicsContext> drawingFunction) {
		super();

		this.caption = caption;
		this.drawingFunction = drawingFunction;

		Canvas canvas = new Canvas(200, 200);
		drawingFunction.accept(canvas.getGraphicsContext2D());

		Label captionLabel = new Label();
		captionLabel.setText(caption);
		captionLabel.setAlignment(Pos.BASELINE_CENTER);
		captionLabel.setFont(Font.font("Segoe UI", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 16.0));
		captionLabel.setTextFill(Color.GREEN);

		getChildren().addAll(canvas, captionLabel);
	}


}
