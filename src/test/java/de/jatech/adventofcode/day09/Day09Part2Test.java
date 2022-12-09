package de.jatech.adventofcode.day09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.jatech.adventofcode.common.Utils;

public class Day09Part2Test {
	@Test
	void testPuzzle() throws Exception {
		final List<String> list = Utils.readLinesFromFile("day09/input_example2.txt");

		assertEquals(36, Day09Part2.solvePuzzle(list));
	}
}
