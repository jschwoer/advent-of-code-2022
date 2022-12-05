package de.jatech.adventofcode.day05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.jatech.adventofcode.common.Utils;

public class Day05Part2Test {
	@Test
	void testPuzzle() throws Exception {
		final List<String> list = Utils.readLinesFromFile("day05/input_example.txt");

		final String result = Day05Part2.solvePuzzle(list);

		assertEquals("MCD", result);
	}
}
