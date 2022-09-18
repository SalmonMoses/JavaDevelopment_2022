package me.salmonmoses;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.Set;

public class OrderController {
	private OrderModel model;

	private OrderView view;

	public OrderController(OrderModel model, OrderView view) {
		this.model = model;
		this.view = view;
	}

	public void start() {
		initModelListeners();
		initViewListeners();
		view.setVisible(true);
	}

	private void attemptAccept() {
		OrderModelVerifier verifier = new OrderModelVerifier();
		Set<OrderModelVerifier.Error> errors = verifier.verify(model);
		if (!errors.isEmpty()) {
			StringBuilder errorBuilder = new StringBuilder();
			if (errors.contains(OrderModelVerifier.Error.INVALID_NAME)) {
				errorBuilder.append("Неправильно введене ім'я\n");
			}
			if (errors.contains(OrderModelVerifier.Error.INVALID_PHONE)) {
				errorBuilder.append("Неправильно введений телефонний номер\n");
			}
			if (errors.contains(OrderModelVerifier.Error.INVALID_EMAIL)) {
				errorBuilder.append("Неправильно введена пошта\n");
			}
			JOptionPane.showMessageDialog(view,
			                              errorBuilder.toString(),
			                              "Помилка!",
			                              JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showOptionDialog(view,
			                             "З вами зв'яжуться!",
			                             "Дякуємо за замовлення",
			                             JOptionPane.DEFAULT_OPTION,
			                             JOptionPane.PLAIN_MESSAGE,
			                             null,
			                             new String[]{"Добре"},
			                             "Добре");
		}
	}

	private void initModelListeners() {
		model.wantsMailing.addListener(wantsMailing -> view.getSubmitButton().setEnabled(wantsMailing));
	}

	private void initViewListeners() {
		view.getNameTextField().getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				model.setName(view.getNameTextField().getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				model.setName(view.getNameTextField().getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});

		view.getCityComboBox()
		    .addActionListener(e -> model.setCity((String) view.getCityComboBox().getSelectedItem()));

		view.getPhoneTextField().getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				model.setNumber(view.getPhoneTextField().getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				model.setNumber(view.getPhoneTextField().getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});

		view.getEmailTextField().getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				model.setEmail(view.getEmailTextField().getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				model.setEmail(view.getEmailTextField().getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});

		view.getMailingCheckBox().addActionListener(e -> {
			model.wantsMailing.setValue(view.getMailingCheckBox().isSelected());
		});

		view.getSubmitButton().addActionListener(e -> attemptAccept());
	}
}
