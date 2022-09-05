package me.salmonmoses.lab1.tasks;

import me.salmonmoses.lab1.Prompts;
import me.salmonmoses.lab1.Task;
import me.salmonmoses.lab1.parser.UkrainianWellsoundnessProcessor;

import java.io.BufferedWriter;
import java.io.IOException;

public class Task5 implements Task {
	private final BufferedWriter bufferedWriter;

	public Task5(BufferedWriter bufferedWriter) {
		this.bufferedWriter = bufferedWriter;
	}

	@Override
	public String getName() {
		return "Замінити \"дім\" на \"будинок\"";
	}

	@Override
	public void execute() {
		String inputText = Prompts.prompt("Введіть текст: ");
		final String processedText = new UkrainianWellsoundnessProcessor(inputText).process();
		try {
			this.bufferedWriter.write(processedText);
			this.bufferedWriter.write("\n");
			this.bufferedWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
