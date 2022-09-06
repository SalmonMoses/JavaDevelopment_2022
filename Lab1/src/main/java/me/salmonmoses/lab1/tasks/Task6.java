package me.salmonmoses.lab1.tasks;

import me.salmonmoses.lab1.Prompts;
import me.salmonmoses.lab1.Task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 implements Task {
	private static final Pattern housePattern = Pattern.compile(
			"(?<=\\s|^)((Д|д)ім)(?=\\s|$)", Pattern.MULTILINE);

	@Override
	public String getName() {
		return "Замінити \"дім\" на \"будинок\"";
	}

	@Override
	public void execute() {
		String inputText = Prompts.promptDefault("Введіть текст: ");
		final Matcher textMatcher = housePattern.matcher(inputText);
		final String replaced = textMatcher.replaceAll(result -> {
			String changed = result.group().replaceAll("дім", "будинок");
			changed = changed.replaceAll("Дім", "Будинок");
			return changed;
		});
		System.out.println(replaced);
	}
}
