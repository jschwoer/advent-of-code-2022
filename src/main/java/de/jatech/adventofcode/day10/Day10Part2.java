package de.jatech.adventofcode.day10;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import de.jatech.adventofcode.common.Utils;

public class Day10Part2 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day10/input.txt");

		final int result = solvePuzzle(input);

		System.out.println("Result: " + result);
	}

	static int cycle = 0;
	static int sum = 0;
	private static int registerX = 1;

	static int solvePuzzle(final List<String> input) {
		for (String line : input) {
			String[] parts = line.split(" ");
			String instruction = parts[0];

			switch (instruction) {
				case "noop": {
					incCycle();
					break;
				}
				case "addx": {
					int value = Integer.parseInt(parts[1]);
					incCycle();
					incCycle();
					registerX += value;
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + instruction);
			}
		}
		return sum;
	}

	static void incCycle() {
		cycle++;
		cycle = cycle % 40;

		if (registerX == cycle - 2 || registerX == cycle - 1 || registerX == cycle) {
			System.out.print("#");
		} else {
			System.out.print(".");
		}

		if (cycle % 40 == 0) {
			System.out.println();
		}
	}
}
