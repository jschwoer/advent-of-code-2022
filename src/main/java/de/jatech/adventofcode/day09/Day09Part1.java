package de.jatech.adventofcode.day09;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.jatech.adventofcode.common.Utils;

public class Day09Part1 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day09/input.txt");

		final int result = solvePuzzle(input);

		System.out.println("Result: " + result);
	}

	static int solvePuzzle(final List<String> input) {
		Point start = new Point(0, 0);
		Point head = start;
		Point tail = start;

		Set<Point> visitedPoints = new HashSet<>();
		visitedPoints.add(start);

		for (String line : input) {
			String[] parts = line.split(" ");
			String direction = parts[0];
			int steps = Integer.parseInt(parts[1]);

			for (int step = 0; step < steps; step++) {
				switch (direction) {
					case "R": {
						head = new Point(head.x + 1, head.y);
						tail = moveTail(direction, head, tail);
						break;
					}
					case "L": {
						head = new Point(head.x - 1, head.y);
						tail = moveTail(direction, head, tail);
						break;
					}
					case "U": {
						head = new Point(head.x, head.y + 1);
						tail = moveTail(direction, head, tail);
						break;
					}
					case "D": {
						head = new Point(head.x, head.y - 1);
						tail = moveTail(direction, head, tail);
						break;
					}
				}

				visitedPoints.add(tail);
			}
		}

		for (Point p : visitedPoints) {
			System.out.println(p);
		}

		return visitedPoints.size();
	}

	private static Point moveTail(String direction, Point head, Point tail) {
		if ((Math.abs(head.x - tail.x) <= 1) && (Math.abs(head.y - tail.y) <= 1)) {
			return tail;
		}

		switch (direction) {
			case "R":
				return new Point(head.x - 1, head.y);
			case "L":
				return new Point(head.x + 1, head.y);
			case "U":
				return new Point(head.x, head.y - 1);
			case "D":
				return new Point(head.x, head.y + 1);
			default:
				throw new IllegalArgumentException("Unkown direction: " + direction);
		}
	}

	public record Point(int x, int y) {
	}
}
