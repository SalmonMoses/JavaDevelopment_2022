package me.salmonmoses.lab1.tasks;

import me.salmonmoses.lab1.MatrixUtils;
import me.salmonmoses.lab1.Prompts;
import me.salmonmoses.lab1.Task;

import java.io.IOException;

public class Task4 implements Task {
	private record Coordinates(int i, int j) {
	}

	@Override
	public String getName() {
		return "Двовимірні масиви";
	}

	@Override
	public void execute() {
		try {
			int width = Prompts.promptInt("Введіть ширину матриці: ");
			int height = Prompts.promptInt("Введіть висоту матриці: ");
			double[][] matrix = Prompts.promptMatrix("Введіть матрицю: ", width, height);
			MatrixUtils.printMatrix(matrix);
			int k = Prompts.promptInt("k = ");

			Coordinates maxElementCoordinates = new Coordinates(0, 0);
			for (int i = 0; i < height; ++i) {
				for (int j = 0; j < width; ++j) {
					if (matrix[i][j] > matrix[maxElementCoordinates.i][maxElementCoordinates.j]) {
						maxElementCoordinates = new Coordinates(i, j);
					}
				}
			}

			for (int i = 0; i < maxElementCoordinates.i(); ++i) {
				if (i % 2 != 0) {
					continue;
				}
				for (int j = 0; j < maxElementCoordinates.j(); ++j) {
					if (j % 2 == 1) {
						matrix[i][j] *= k;
					}
				}
			}

			System.out.println("Результат: ");
			MatrixUtils.printMatrix(matrix);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
