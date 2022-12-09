package de.jatech.adventofcode.day09;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.crypto.KeyGenerator;

import de.jatech.adventofcode.common.Utils;

public class Day09Part2 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day09/input.txt");

		final int result = solvePuzzle(input);

		System.out.println("Result: " + result);
	}

	static int solvePuzzle(final List<String> input) {
		Point start = new Point(0, 0);

		int numberOfKnots = 10;
		List<Point> rope = new ArrayList<>(numberOfKnots);
		for (int idx = 0; idx < numberOfKnots; idx++) {
			rope.add(start);
		}

		Set<Point> visitedPoints = new HashSet<>();
		visitedPoints.add(start);

		for (String line : input) {
			String[] parts = line.split(" ");
			String direction = parts[0];
			int steps = Integer.parseInt(parts[1]);

			for (int step = 0; step < steps; step++) {
				Point head = rope.get(0);
				switch (direction) {
					case "R": {
						head = new Point(head.x + 1, head.y);
						break;
					}
					case "L": {
						head = new Point(head.x - 1, head.y);
						break;
					}
					case "U": {
						head = new Point(head.x, head.y + 1);
						break;
					}
					case "D": {
						head = new Point(head.x, head.y - 1);
						break;
					}
				}
				rope.set(0, head);

				for (int knotIdx = 0; knotIdx <= numberOfKnots - 2; knotIdx++) {
					Point knot1 = rope.get(knotIdx);
					Point knot2 = rope.get(knotIdx + 1);
					Point newKnotPos = moveTail(direction, knot1, knot2);
					rope.set(knotIdx + 1, newKnotPos);

					// printRope(rope);
				}

				visitedPoints.add(rope.get(numberOfKnots - 1));

				// printRope(rope);
			}
		}

		return visitedPoints.size();
	}

	private static void printRope(List<Point> rope) {
		System.out.println("\n");
		for (int y = 5; y >= 0; y--) {
			String line = "";
			for (int x = 0; x <= 5; x++) {
				int knotNumber = rope.indexOf(new Point(x, y));
				if (knotNumber == -1) {
					line = line + ".";
				} else {
					line = line + knotNumber;
				}
			}
			System.out.println(line);
		}
	}

	private static Point moveTail(String direction, Point head, Point tail) {
		int deltaX = head.x - tail.x;
		int deltaY = head.y - tail.y;

		if ((Math.abs(deltaX) <= 1) && (Math.abs(deltaY) <= 1)) {
			return tail;
		}

		int newX = tail.x;
		int newY = tail.y;
		if (Math.abs(deltaX) > 0) {
			int dir = deltaX > 0 ? 1 : -1;
			newX = tail.x + dir;
		}
		if (Math.abs(deltaY) > 0) {
			int dir = deltaY > 0 ? 1 : -1;
			newY = tail.y + dir;
		}

		return new Point(newX, newY);
	}

	public record Point(int x, int y) {
	}
}
