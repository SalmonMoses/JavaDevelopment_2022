package me.salmonmoses.lab6;

import me.salmonmoses.lab6.views.FirstFormView;

import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new FirstFormView("Lab 6");
		frame.pack();
		frame.setVisible(true);
	}
}