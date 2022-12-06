package de.jatech.adventofcode.day06;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import de.jatech.adventofcode.common.Utils;

public class Day06Part1 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day06/input.txt");

		final int result = solvePuzzle(input.get(0));

		System.out.println("Result: " + result);
	}

	static int solvePuzzle(final String input) {
		return solvePuzzle(input, 4);
	}

	static int solvePuzzle(final String input, final int markerLength) {
		int result = -1;
		System.out.println("------------");

		for (int idx = 0; idx < input.length() - markerLength - 1; idx++) {
			String marker = input.substring(idx, idx + markerLength);
			System.out.println(marker);

			if (marker.chars().distinct().count() == markerLength) {
				result = idx + markerLength;
				break;
			}
		}
		return result;
	}
}
