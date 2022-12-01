package de.jatech.adventofcode.day01;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import de.jatech.adventofcode.common.Utils;

public class Day01Part1 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day01/input.txt");

		for (final String s : input) {
			System.out.println(s);
		}

		final int count = solvePuzzle(input);

		System.out.println("Result: " + count);
	}

	static int solvePuzzle(final List<String> input) {
		int result = 0;

		int sum = 0;
		for (String s : input) {
			if (s.isBlank()) {
				if (sum > result) {
					result = sum;
				}
				sum = 0;
			} else {
				int i = Integer.parseInt(s);
				sum += i;
			}
		}

		return sum > result ? sum : result;
	}
}
