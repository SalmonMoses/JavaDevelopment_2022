package me.salmonmoses;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.plaf.IconUIResource;
import java.awt.*;

public class OrderView extends JFrame {

	private static final String[] cities;

	private JTextField nameTextField;
	private JComboBox<String> cityComboBox;
	private JTextField phoneTextField;
	private JTextField emailTextField;

	private JCheckBox mailingCheckBox;

	private JButton submitButton;

	static {
		cities = new String[]{
				"Київ",
				"Вінниця",
				"Дніпро",
				"Донецьк",
				"Житомир",
				"Запоріжжя",
				"Івано-Франківськ",
				"Кропівницький",
				"Луганськ",
				"Луцьк",
				"Львів",
				"Миколаїв",
				"Одеса",
				"Полтава",
				"Рівне",
				"Суми",
				"Тернопіль",
				"Харків",
				"Херсон",
				"Хмельницький",
				"Черкаси",
				"Чернівці",
				"Чернігів",
				"Інше"
		};
	}

	public OrderView() {
		super("Оформлення замовлення");

		final BorderLayout borderLayout = new BorderLayout(0, 8);
		final JPanel root = new JPanel(borderLayout);

		final JPanel header = createHeader();
		header.setOpaque(false);
		root.add(header, BorderLayout.NORTH);

		final JPanel form = createForm();
		form.setOpaque(false);
		root.add(form, BorderLayout.CENTER);

		final JPanel footer = createFooter();
		footer.setOpaque(false);
		root.add(footer, BorderLayout.SOUTH);

		root.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
		root.setBackground(new Color(0xC0F6A8));
		add(root);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pack();
	}

	private static JPanel createHeader() {
		final JPanel header = new JPanel();
		final BoxLayout headerLayout = new BoxLayout(header, BoxLayout.X_AXIS);
		header.setLayout(headerLayout);

		final JPanel titles = new JPanel();
		titles.setOpaque(false);
		final BoxLayout titlesLayout = new BoxLayout(titles, BoxLayout.Y_AXIS);
		titles.setLayout(titlesLayout);

		final JLabel title = new JLabel("Оформлення замовлення");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Comic Sans", Font.ITALIC, 18));
		title.setForeground(new Color(0x047d06));
		titles.add(title);

		final JLabel subtitle = new JLabel("Контактні дані");
		subtitle.setHorizontalAlignment(SwingConstants.CENTER);
		subtitle.setFont(new Font("Comic Sans", Font.BOLD, 14));
		titles.add(subtitle);

		final JSeparator separator = new JSeparator();
		separator.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, new Color(0x014f02), Color.GRAY));
		titles.add(separator);

		header.add(titles);

		final ImageIcon logoIcon = new ImageIcon(OrderView.class.getResource("/images/logo.png"));
		final JLabel logo = new JLabel(new ImageIcon(logoIcon.getImage()
		                                                     .getScaledInstance(48, 48, Image.SCALE_SMOOTH)));
		header.add(logo);

		return header;
	}

	private JPanel createForm() {
		final JPanel form = new JPanel();
		form.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(2, 4, 2, 4);
		constraints.anchor = GridBagConstraints.WEST;

		final JLabel nameLabel = makeLabel("Прізвище та ім'я");
		constraints.fill = GridBagConstraints.HORIZONTAL;
		form.add(nameLabel, constraints);
		nameTextField = new JTextField("", 30);
		constraints.fill = GridBagConstraints.NONE;
		constraints.gridx = 1;
		constraints.gridwidth = 2;
		form.add(nameTextField, constraints);

		final JLabel cityLabel = makeLabel("Місто");
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		form.add(cityLabel, constraints);
		cityComboBox = new JComboBox<>(cities);
		cityComboBox.setSelectedIndex(0);
		constraints.fill = GridBagConstraints.NONE;
		constraints.gridx = 1;
		constraints.gridwidth = 2;
		form.add(cityComboBox, constraints);

		final JLabel phoneLabel = makeLabel("Телефон");
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		form.add(phoneLabel, constraints);
		phoneTextField = new JTextField("", 20);
		constraints.fill = GridBagConstraints.NONE;
		constraints.gridx = 1;
		constraints.gridwidth = 2;
		form.add(phoneTextField, constraints);

		final JLabel emailLabel = makeLabel("E-Mail");
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		form.add(emailLabel, constraints);
		emailTextField = new JTextField("", 20);
		constraints.fill = GridBagConstraints.NONE;
		constraints.gridx = 1;
		constraints.gridwidth = 2;
		form.add(emailTextField, constraints);

		return form;
	}

	private JPanel createFooter() {
		JPanel footer = new JPanel();
		final BoxLayout footerLayout = new BoxLayout(footer, BoxLayout.Y_AXIS);
		footer.setLayout(footerLayout);

		JPanel mailingCheckBoxPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		mailingCheckBoxPanel.setOpaque(false);
		mailingCheckBox = new JCheckBox("Я хочу отримувати розсилку інтернет-магазину To4ka");
		mailingCheckBox.setOpaque(false);
		mailingCheckBoxPanel.add(mailingCheckBox);
		footer.add(mailingCheckBoxPanel);

		JPanel submitButtonPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		submitButtonPanel.setOpaque(false);
		submitButton = new JButton("ОК");
		submitButton.setAlignmentX(-1.0f);
		submitButton.setEnabled(false);
		submitButton.setFont(new Font("Comic Sans", Font.BOLD, 14));
		submitButton.setBackground(Color.LIGHT_GRAY);
		final Dimension buttonOriginalSize = submitButton.getPreferredSize();
		submitButton.setPreferredSize(new Dimension(buttonOriginalSize.width * 2,
		                                            buttonOriginalSize.height * 11 / 10));
//		submitButton.setBorder(BorderFactory.createCompoundBorder(
//				BorderFactory.createLineBorder(Color.BLUE, 1),
//				BorderFactory.createSoftBevelBorder(BevelBorder.RAISED,
//				                                Color.BLUE,
//				                                Color.GRAY)));
		submitButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.BLUE, Color.BLACK,
		                                                       Color.BLUE, Color.BLACK));
		submitButtonPanel.add(submitButton);
		footer.add(submitButtonPanel);

		return footer;
	}

	private JLabel makeLabel(String text) {
		final JLabel label = new JLabel(text);
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		return label;
	}

	public JTextField getNameTextField() {
		return nameTextField;
	}

	public JComboBox<String> getCityComboBox() {
		return cityComboBox;
	}

	public JTextField getPhoneTextField() {
		return phoneTextField;
	}

	public JTextField getEmailTextField() {
		return emailTextField;
	}

	public JCheckBox getMailingCheckBox() {
		return mailingCheckBox;
	}

	public JButton getSubmitButton() {
		return submitButton;
	}
}
