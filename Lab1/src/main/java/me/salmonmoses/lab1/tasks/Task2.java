package me.salmonmoses.lab1.tasks;

import me.salmonmoses.lab1.Prompts;
import me.salmonmoses.lab1.Task;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Random;

public class Task2 implements Task {
	@Override
	public String getName() {
		return "Знайти найближче середнє арифметичне";
	}

	@Override
	public void execute() {
		final int arrayLength = Prompts.promptInt("Введіть розмір масиву: ");
		if (arrayLength <= 0) {
			System.out.println("Розмір масиву має бути більше 0!");
			return;
		}
		final double x = Prompts.promptDouble("x = ");
		final double[] numbers = generateArray(arrayLength, 1, 10);
		System.out.println("Масив: " + Arrays.toString(numbers));
		double first = 0.0;
		double second = 0.0;
		double closestAverage = Double.POSITIVE_INFINITY;
		for (int i = 0; i < arrayLength; ++i) {
			for (int j = i + 1; j < arrayLength; ++j) {
				double average = (numbers[i] + numbers[j]) / 2;
				if (Math.abs(x - average) < Math.abs(x - closestAverage)) {
					first = numbers[i];
					second = numbers[j];
					closestAverage = average;
				}
			}
		}
		final String resultMessage = MessageFormat.format("Пара чисел ({0}, {1}), з середнім {2}", first, second,
		                                                  closestAverage);
		System.out.println(resultMessage);
	}

	private double[] generateArray(int size, double lowest, double highest) {
		double[] array = new double[size];
		Random r = new Random(System.currentTimeMillis());
		for (int i = 0; i < size; ++i) {
			array[i] = r.nextDouble(lowest, highest);
		}
		return array;
	}
}
