package me.salmonmoses.lab2;

import me.salmonmoses.core.InvalidContainerSizeException;
import me.salmonmoses.core.Prompts;

import java.io.IOException;
import java.text.MessageFormat;

public class Main {
	record MaxElementInfo(int index, int value) {
	}

	public static void main(String[] args) {
		int arraySize = Prompts.promptInt("Введіть розмір масиву: ");
		int[] array = new int[0];
		try {
			array = Prompts.promptArray("Введіть масив: ", arraySize);
		} catch (IOException e) {
			System.err.println("Щось не так з вводом:");
			e.printStackTrace();
			System.exit(0);
		} catch (InvalidContainerSizeException e) {
			System.err.println("Невірний розмір масиву!");
			System.exit(0);
		}
		MaxElementInfo maxElementInfo = null;
		try {
			maxElementInfo = findMaxValidElement(array);
		} catch (NoValidElementsException e) {
			System.err.println("В масиві нема чисел, що діляться на 3!");
			System.exit(0);
		}
		System.out.println(MessageFormat.format("Максимальне число - число {0} під номером {1}", maxElementInfo.value,
		                                        maxElementInfo.index));
	}

	private static MaxElementInfo findMaxValidElement(int[] array) throws NoValidElementsException {
		boolean foundValidElement = false;
		int maxElement = Integer.MIN_VALUE;
		int maxElementNumber = 0;
		for (int i = 0; i < array.length; ++i) {
			int currentNum = array[i];
			if (currentNum % 3 == 0) {
				foundValidElement = true;
				if (currentNum > maxElement) {
					maxElementNumber = i;
					maxElement = currentNum;
				}
			}
		}
		if (!foundValidElement) {
			throw new NoValidElementsException("Не знайдені числа, що діляться на 3!");
		}
		return new MaxElementInfo(maxElementNumber, maxElement);
	}
}
