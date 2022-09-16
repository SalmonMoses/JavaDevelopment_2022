package me.salmonmoses.lab6.views;

import javax.swing.*;
import java.awt.*;

public class FirstFormView extends JFrame {

	private final CircleComponent circle;
	private final JTextField radiusInputTextField;

	public FirstFormView(String title) {
		super(title);

		createMenu();

		JPanel root = new JPanel();
		BoxLayout rootLayout = new BoxLayout(root, BoxLayout.Y_AXIS);
		root.setLayout(rootLayout);
		circle = new CircleComponent(Color.RED, Color.BLUE);
		circle.setPreferredSize(new Dimension(200, 200));
		root.add(circle);

		JPanel radiusFieldPanel = new JPanel(new FlowLayout());
		final JLabel rEqualLabel = new JLabel("r = ");
		rEqualLabel.setFont(new Font("Cambria Math", Font.ITALIC, 16));
		radiusFieldPanel.add(rEqualLabel);

		radiusInputTextField = new JTextField("0.0");
		radiusInputTextField.setColumns(13);
		radiusFieldPanel.add(radiusInputTextField);
		root.add(radiusFieldPanel);

		JButton nextButton = new JButton("���������");
		nextButton.addActionListener(e -> openSecondFrame());
		root.add(nextButton);

		add(root);
	}

	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();

		JMenu appMenu = new JMenu("��������");

		JMenuItem changeCircleColor = new JMenuItem("������ ���� �����");
		changeCircleColor.addActionListener(e -> circle.switchColor());

		JMenuItem evaluate = new JMenuItem("���������");
		evaluate.addActionListener(e -> openSecondFrame());

		JMenuItem exit = new JMenuItem("�����");
		exit.addActionListener(e -> System.exit(0));

		JMenu editMenu = new JMenu("������");
		editMenu.add(new JMenuItem("��������"));
		editMenu.add(new JMenuItem("��������"));

		appMenu.add(changeCircleColor);
		appMenu.add(evaluate);
		appMenu.add(exit);

		menuBar.add(appMenu);
		menuBar.add(editMenu);
		setJMenuBar(menuBar);
	}

	private void openSecondFrame() {
		try {
			double radius = Double.parseDouble(radiusInputTextField.getText());
			SecondFormView secondFormView = new SecondFormView("Second form", radius);
			secondFormView.pack();
			secondFormView.setVisible(true);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this,
			                              "����� ������� ���� ������",
			                              "�������!",
			                              JOptionPane.ERROR_MESSAGE);
		}
	}
}
