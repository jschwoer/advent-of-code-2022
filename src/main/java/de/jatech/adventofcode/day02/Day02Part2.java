package de.jatech.adventofcode.day02;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import de.jatech.adventofcode.common.Utils;

public class Day02Part2 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day02/input.txt");

		final int count = solvePuzzle(input);

		System.out.println("Result: " + count);
	}

	static int solvePuzzle(final List<String> input) {
		int result = 0;

//		Rock defeats Scissors, Scissors defeats Paper, and Paper defeats Rock
//		A for Rock, B for Paper, and C for Scissors
//		X for Rock, Y for Paper, and Z for Scissors

		for (String s : input) {
			String[] decisions = s.split(" ");
			String opponent = decisions[0];
			String expectedOutcome = decisions[1];

			String selectedShape = calculateShape(opponent, expectedOutcome);

			int win = 6;
			int draw = 3;

			if (isDraw(selectedShape, opponent)) {
				result = result + draw + getShapeValue(selectedShape);
			} else if (selectedShape.equals("X") && opponent.equals("C")
					|| selectedShape.equals("Z") && opponent.equals("B")) {
				result = result + win + getShapeValue(selectedShape);
			} else if (selectedShape.equals("Y") && opponent.equals("A")) {
				result = result + win + getShapeValue(selectedShape);
			} else {
				result += getShapeValue(selectedShape);
			}
		}
		return result;
	}

	private static String calculateShape(final String opponent, final String expectedOutcome) {
		// X means you need to lose, Y means you need to end the round in a draw, and Z
		// means you need to win
		// Rock defeats Scissors, Scissors defeats Paper, and Paper defeats Rock
		if (expectedOutcome.equals("Y")) {
			if (opponent.equals("A")) {
				return "X";
			} else if (opponent.equals("B")) {
				return "Y";
			} else if (opponent.equals("C")) {
				return "Z";
			}
		} else if (expectedOutcome.equals("X")) {
			// loose
			if (opponent.equals("A")) {
				return "Z";
			} else if (opponent.equals("B")) {
				return "X";
			} else if (opponent.equals("C")) {
				return "Y";
			}
		} else if (expectedOutcome.equals("Z")) {
			// win
			if (opponent.equals("A")) {
				return "Y";
			} else if (opponent.equals("B")) {
				return "Z";
			} else if (opponent.equals("C")) {
				return "X";
			}
		}
		throw new IllegalArgumentException(opponent + ", " + expectedOutcome);
	}

	private static int getShapeValue(final String me) {
		switch (me) {
			case "X":
				return 1;
			case "Y":
				return 2;
			case "Z":
				return 3;
		}
		throw new IllegalArgumentException("Unexpected value: " + me);
	}

	private static boolean isDraw(final String me, final String opponent) {
		return me.charAt(0) - opponent.charAt(0) == 23;
	}
}
