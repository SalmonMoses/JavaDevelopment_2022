package me.salmonmoses.lab1.parser;

public class UkrainianWellsoundnessProcessor {
	private final String input;

	public UkrainianWellsoundnessProcessor(String input) {
		this.input = input;
	}

	public String process() {
		String[] tokens = input.split(" ");
		for (int i = 1; i < tokens.length; ++i) { // we don't need to check first word, as it is not affected by rules
			String token = getPureWord(tokens[i]);
			if (token.equalsIgnoreCase("\u0456")
					|| token.equalsIgnoreCase("\u0442\u0430")
					|| token.equalsIgnoreCase("\u0439")) {
				String prevWord = getPureWord(tokens[i - 1]);
				final String prevWordLastLetter = prevWord.substring(prevWord.length() - 1);
				final boolean isPrevLetterVowel = LetterUtils.isVowel(prevWordLastLetter);
				boolean isNextLetterVowel = true;
				if (i < tokens.length - 1) {
					String nextWord = getPureWord(tokens[i + 1]);
					final String nextWordFirstLetter = nextWord.substring(0, 1);
					isNextLetterVowel = LetterUtils.isVowel(nextWordFirstLetter);
				}
				if (!isPrevLetterVowel) {
					tokens[i] = "\u0456";
				} else if (!isNextLetterVowel) {
					tokens[i] = "\u0442\u0430";
				} else {
					tokens[i] = "\u0439";
				}
			}
		}
		return String.join(" ", tokens);
	}

	private String getPureWord(String src) {
		return src.replaceAll("[,.!?\\-:; \t\n]", "");
	}
}
