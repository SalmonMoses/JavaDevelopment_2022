package me.salmonmoses.lab1;

import me.salmonmoses.lab1.tasks.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
		Task[] tasks = new Task[]{new Task1(), new Task2(), new Task3(), new Task4(), new Task5(bufferedWriter), new Task6()};
		System.out.println(formatMenu(tasks));
		int taskNumber;
		do {
			taskNumber = Prompts.promptInt("Введіть номер завдання (або 0 щоби вийти): ");
			if (taskNumber > tasks.length || taskNumber < 0) {
				System.out.println("Невірний номер завдання!");
				continue;
			}
			if (taskNumber == 0) {
				break;
			}
			tasks[taskNumber - 1].execute();
		} while (true);
		System.out.println("До побачення!");
		try {
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String formatMenu(Task[] tasks) {
		return IntStream
				.range(0, tasks.length)
				.mapToObj(i -> MessageFormat.format("{0}. {1}", i + 1, tasks[i].getName()))
				.collect(Collectors.joining("\n"));
	}
}
