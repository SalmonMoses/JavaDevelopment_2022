package me.salmonmoses.lab1;

import java.util.Arrays;

public class MatrixUtils {
	public static void printMatrix(double[][] matrix) {
		System.out.print('[');
		for (int i = 0; i < matrix.length; ++i) {
			System.out.print(Arrays.toString(matrix[i]));
			if (i != matrix.length - 1) {
				System.out.println();
			}
		}
		System.out.println(']');
	}
}
