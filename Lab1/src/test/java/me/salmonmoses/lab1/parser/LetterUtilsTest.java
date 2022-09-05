package me.salmonmoses.lab1.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LetterUtilsTest {

	@Test
	void isVowel() {
		assertTrue(LetterUtils.isVowel("у"));
		assertTrue(LetterUtils.isVowel("і"));
		assertTrue(LetterUtils.isVowel("ї"));
		assertTrue(LetterUtils.isVowel("а"));
		assertFalse(LetterUtils.isVowel("д"));
		assertFalse(LetterUtils.isVowel("й"));
	}
}