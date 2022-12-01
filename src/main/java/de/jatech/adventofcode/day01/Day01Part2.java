package de.jatech.adventofcode.day01;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.jatech.adventofcode.common.Utils;

public class Day01Part2 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day01/input.txt");

		final int count = solvePuzzle(input);

		System.out.println("Result: " + count);
	}

	static int solvePuzzle(final List<String> input) {
		List<Integer> calories = new ArrayList<>();

		int sum = 0;
		for (String s : input) {
			if (s.isBlank()) {
				calories.add(sum);
				sum = 0;
			} else {
				sum += Integer.parseInt(s);
			}
		}
		calories.add(sum);

		Collections.sort(calories, Collections.reverseOrder());

		return calories.get(0) + calories.get(1) + calories.get(2);
	}
}
