package de.jatech.adventofcode.day02;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import de.jatech.adventofcode.common.Utils;

public class Day02Part1 {
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
			String me = decisions[1];

			int win = 6;
			int draw = 3;

			if (isDraw(me, opponent)) {
				result = result + draw + getShapeValue(me);
			} else if (me.equals("X") && opponent.equals("C") || me.equals("Z") && opponent.equals("B")) {
				result = result + win + getShapeValue(me);
			} else if (me.equals("Y") && opponent.equals("A")) {
				result = result + win + getShapeValue(me);
			} else {
				result += getShapeValue(me);
			}
		}
		return result;
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
