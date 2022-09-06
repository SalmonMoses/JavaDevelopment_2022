package me.salmonmoses.lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Prompts {
	public static String prompt(String promptText) {
		System.out.print(promptText);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
		try {
			return bufferedReader.readLine();
		} catch (IOException e) {
			System.out.println("Something wrong happened with your terminal!");
			e.printStackTrace();
		}
		return "";
	}

	public static String promptDefault(String promptText) {
		System.out.print(promptText);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			return bufferedReader.readLine();
		} catch (IOException e) {
			System.out.println("Something wrong happened with your terminal!");
			e.printStackTrace();
		}
		return "";
	}

	public static int promptInt(String promptText) {
		String userInput = prompt(promptText);
		return Integer.parseInt(userInput);
	}

	public static double promptDouble(String promptText) {
		String userInput = prompt(promptText);
		return Double.parseDouble(userInput);
	}

	public static double[][] promptMatrix(String promptText, int width, int height) throws IOException {
		if (width <= 0 || height <= 0) {
			throw new IllegalArgumentException("Розмір матриці повинен бути більший від 0");
		}
		int area = width * height;
		double[] linearMatrix = new double[area];
		int elementsLeft = area;
		int elementsEntered = 0;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(promptText);
		do {
			String promptInput = bufferedReader.readLine();
			double[] enteredNumbers = Arrays.stream(promptInput.split(" "))
			                                .mapToDouble(Double::parseDouble)
			                                .toArray();
			int copyingLength = Math.min(enteredNumbers.length, elementsLeft);
			System.arraycopy(enteredNumbers, 0, linearMatrix, elementsEntered, copyingLength);
			elementsLeft -= copyingLength;
			elementsEntered += copyingLength;
		} while (elementsLeft > 0);
		double[][] matrix = new double[height][width];
		for (int i = 0; i < height; ++i) {
			System.arraycopy(linearMatrix, i * width, matrix[i], 0, width);
		}
		return matrix;
	}
}
