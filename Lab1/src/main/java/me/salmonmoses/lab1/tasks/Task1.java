package me.salmonmoses.lab1.tasks;

import me.salmonmoses.lab1.Prompts;
import me.salmonmoses.lab1.Segment;
import me.salmonmoses.lab1.Task;

public class Task1 implements Task {
	@Override
	public String getName() {
		return "Задача з відрізками";
	}

	@Override
	public void execute() {
		double a = Prompts.promptDouble("a = ");
		double b = Prompts.promptDouble("b = ");
		double alpha = Prompts.promptDouble("alpha = ");
		double beta = Prompts.promptDouble("beta = ");

		Segment ab = new Segment(a, b);
		Segment alphaBeta = new Segment(alpha, beta);

		double probability;
		if (ab.contains(alphaBeta)) {
			probability = alphaBeta.length() / ab.length();
		} else if (ab.includedIn(alphaBeta)) {
			probability = ab.length();
		} else {
			probability = ab.intersection(alphaBeta)
			                .map(intersection -> intersection.length() / alphaBeta.length())
			                .orElse(0.0);
		}
		System.out.println("Ймовірність = " + probability);
	}
}
