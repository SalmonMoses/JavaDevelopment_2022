package me.salmonmoses.lab6.views;

import javax.swing.*;
import java.awt.*;
import java.text.MessageFormat;

public class SecondFormView extends JFrame {
	private final double radius;

	public SecondFormView(String title, double radius) {
		super(title);

		this.radius = radius;

		JPanel root = new JPanel(new BorderLayout());
		root.setPreferredSize(new Dimension(200, 200));
		JPanel answersPanel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(answersPanel, BoxLayout.Y_AXIS);
		answersPanel.setLayout(boxLayout);

		Font mathFont = new Font("Cambria Math", Font.ITALIC, 16);
		JLabel lengthLabel = new JLabel(MessageFormat.format("l = {0}", getLength()));
		lengthLabel.setFont(mathFont);
		JLabel areaLabel = new JLabel(MessageFormat.format("S = {0}", getArea()));
		areaLabel.setFont(mathFont);

		JButton exitButton = new JButton("Вийти");
		exitButton.addActionListener(e -> System.exit(0));

		answersPanel.add(lengthLabel);
		answersPanel.add(areaLabel);
		answersPanel.add(exitButton);

		root.add(answersPanel, BorderLayout.CENTER);

		add(root);
	}

	private double getLength() {
		return 2 * radius * Math.PI;
	}

	private double getArea() {
		return radius * radius * Math.PI;
	}
}
