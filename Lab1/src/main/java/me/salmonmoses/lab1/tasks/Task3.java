package me.salmonmoses.lab1.tasks;

import me.salmonmoses.lab1.MatrixUtils;
import me.salmonmoses.lab1.Prompts;
import me.salmonmoses.lab1.Task;

import java.io.IOException;

public class Task3 implements Task {
	@Override
	public String getName() {
		return "Віднімання в матриці";
	}

	@Override
	public void execute() {
		try {
			int matrixSize = Prompts.promptInt("Введіть розмір матриці: ");
			double[][] matrix = Prompts.promptMatrix("Введіть матрицю: ", matrixSize, matrixSize);
			MatrixUtils.printMatrix(matrix);
			int k = Prompts.promptInt("k = ");
			if (k > matrixSize) {
				System.out.println("k повинен бути менше за розмір матриці!");
			} else if (k <= 0) {
				System.out.println("k повинен бути більше 0!");
			}
			for (int i = 0; i < matrixSize; ++i) {
				matrix[i][k - 1] -= matrix[i][i];
			}
			System.out.println("Результат: ");
			MatrixUtils.printMatrix(matrix);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
