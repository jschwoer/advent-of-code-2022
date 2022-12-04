package de.jatech.adventofcode.day04;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import de.jatech.adventofcode.common.Utils;

public class Day04Part1 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day04/input.txt");

		final int count = solvePuzzle(input);

		System.out.println("Result: " + count);
	}

	static int solvePuzzle(final List<String> input) {
		int result = 0;

		for (String s : input) {
			String[] parts = s.split(",");
			String sections1String = parts[0];
			String sections2String = parts[1];

			int[] sections1 = sectionPair(sections1String);
			int[] sections2 = sectionPair(sections2String);

			if (sections1[0] >= sections2[0] && sections1[1] <= sections2[1]
					|| sections2[0] >= sections1[0] && sections2[1] <= sections1[1]) {
				result++;
			}
		}

		return result;
	}

	private static int[] sectionPair(final String sections) {
		String[] split = sections.split("-");
		return new int[] { Integer.parseInt(split[0]), Integer.parseInt(split[1]) };
	}
}
