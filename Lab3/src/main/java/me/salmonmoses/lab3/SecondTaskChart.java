package me.salmonmoses.lab3;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class SecondTaskChart extends BorderPane {
	public SecondTaskChart() {
		super();

		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> chart = new BarChart<>(xAxis, yAxis);
		chart.setTitle("Вивчення студентами мов програмування");
		xAxis.setLabel("Мова");
		xAxis.setLabel("Кількість студентів");

		final XYChart.Series<String, Number> group = new XYChart.Series<>();
		group.setName("Група");
		group.getData().add(new XYChart.Data<>("Java", 9));
		group.getData().add(new XYChart.Data<>("Rust", 3));
		group.getData().add(new XYChart.Data<>("Go", 5));
		group.getData().add(new XYChart.Data<>("C++", 10));
		group.getData().add(new XYChart.Data<>("JavaScript", 15));
		group.getData().add(new XYChart.Data<>("Swift", 4));
		group.getData().add(new XYChart.Data<>("Erlang", 6));

		group.getData().forEach(data -> data.nodeProperty().addListener((ov, oldNode, node) -> {
			if (node != null) {
				displayLabelForData(data);
			}
		}));

		chart.getData().add(group);

		setCenter(chart);
	}

	private void displayLabelForData(XYChart.Data<String, Number> data) {
		final Node node = data.getNode();
		final Text dataText = new Text(data.getYValue() + "");
		dataText.setFont(Font.font("Segoe UI", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 18));
		dataText.setFill(Color.BLUE);
		node.parentProperty().addListener((ov, oldParent, parent) -> {
			Group parentGroup = (Group) parent;
			parentGroup.getChildren().add(dataText);
		});

		node.boundsInParentProperty().addListener((ov, oldBounds, bounds) -> {
			dataText.setLayoutX(
					Math.round(
							bounds.getMinX() + bounds.getWidth() / 2 - dataText.prefWidth(-1) / 2
					)
			);
			dataText.setLayoutY(
					Math.round(
							bounds.getMinY() - dataText.prefHeight(-1) * 0.5
					)
			);
		});
	}
}
