package me.salmonmoses.lab6.views;

import javax.swing.*;
import java.awt.*;

public class CircleComponent extends JComponent {

	private enum CircleMode {
		FILLED,
		CIRCLE,
		DELETED
	}
	private Color color;
	private Color altColor;

	private CircleMode mode = CircleMode.FILLED;

	public CircleComponent(Color color, Color altColor) {
		this.color = color;
		this.altColor = altColor;

		final JPopupMenu popupMenu = new JPopupMenu();
		final JMenuItem switchColors = new JMenuItem("Перефарбувати");
		switchColors.addActionListener(e -> switchColor());
		final JMenuItem delete = new JMenuItem("Видалити");
		delete.addActionListener(e -> {
			mode = CircleMode.DELETED;
			repaint();
		});
		final JMenuItem switchToCircle = new JMenuItem("Коло");
		switchToCircle.addActionListener(e -> {
			mode = CircleMode.CIRCLE;
			repaint();
		});
		popupMenu.add(switchColors);
		popupMenu.add(delete);
		popupMenu.add(switchToCircle);
		setComponentPopupMenu(popupMenu);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(color);
		switch (mode) {
			case CIRCLE -> g.drawOval(0, 0, getWidth(), getHeight());
			case FILLED -> g.fillOval(0, 0, getWidth(), getHeight());
		}
	}

	public void switchColor() {
		Color tmp = this.color;
		this.color = this.altColor;
		this.altColor = tmp;
		repaint();
	}
}
