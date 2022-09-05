package me.salmonmoses.lab1.parser;

import java.util.HashSet;
import java.util.Set;

public class LetterUtils {
	private static final Set<String> vowels = new HashSet<>();

	static {
		vowels.add("\u0430");
		vowels.add("\u044f");
		vowels.add("\u0456");
		vowels.add("\u0438");
		vowels.add("\u0457");
		vowels.add("\u0435");
		vowels.add("\u0454");
		vowels.add("\u0443");
		vowels.add("\u044e");
		vowels.add("\u043e");
	}

	public static boolean isVowel(String testedChar) {
		return vowels.contains(testedChar);
	}
}
