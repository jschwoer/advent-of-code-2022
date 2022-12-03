package de.jatech.adventofcode.day03;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import de.jatech.adventofcode.common.Utils;

public class Day03Part1 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day03/input.txt");

		final int count = solvePuzzle(input);

		System.out.println("Result: " + count);
	}

	static int solvePuzzle(final List<String> input) {
		int result = 0;

//	    Lowercase item types a through z have priorities 1 through 26.
//	    Uppercase item types A through Z have priorities 27 through 52.

		for (String s : input) {
			String part1 = s.substring(0, s.length() / 2);
			String part2 = s.substring(s.length() / 2);

			for (int idx = 0; idx < part1.length(); idx++) {
				if (part2.indexOf(part1.charAt(idx)) != -1) {
					if (Character.isUpperCase(part1.charAt(idx))) {
						result += part1.charAt(idx) - 38;
					} else {
						result += part1.charAt(idx) - 96;
					}
					break;
				}
			}
		}

		return result;
	}
}
