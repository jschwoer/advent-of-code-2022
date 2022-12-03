package de.jatech.adventofcode.day03;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import de.jatech.adventofcode.common.Utils;

public class Day03Part2 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day03/input.txt");

		final int count = solvePuzzle(input);

		System.out.println("Result: " + count);
	}

	static int solvePuzzle(final List<String> input) {
		int result = 0;

//	    Lowercase item types a through z have priorities 1 through 26.
//	    Uppercase item types A through Z have priorities 27 through 52.

		for (int idx = 0; idx < input.size() / 3; idx++) {
			String s1 = input.get(idx * 3);
			String s2 = input.get(idx * 3 + 1);
			String s3 = input.get(idx * 3 + 2);

			for (int charIdx = 0; charIdx < s1.length(); charIdx++) {
				char currentChar = s1.charAt(charIdx);
				if (s2.indexOf(currentChar) != -1 && s3.indexOf(currentChar) != -1) {
					if (Character.isUpperCase(currentChar)) {
						result += currentChar - 38;
					} else {
						result += currentChar - 96;
					}
					break;
				}
			}
		}

		return result;
	}
}
