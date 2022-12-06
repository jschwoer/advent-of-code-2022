package de.jatech.adventofcode.day06;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import de.jatech.adventofcode.common.Utils;

public class Day06Part2 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day06/input.txt");

		final int result = Day06Part2.solvePuzzle(input.get(0));

		System.out.println("Result: " + result);
	}

	static int solvePuzzle(final String input) {
		return Day06Part1.solvePuzzle(input, 14);
	}
}
