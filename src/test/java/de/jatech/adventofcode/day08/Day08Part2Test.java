package de.jatech.adventofcode.day08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.jatech.adventofcode.common.Utils;
import de.jatech.adventofcode.day08.Day08Part2;

public class Day08Part2Test {
	@Test
	void testPuzzle() throws Exception {
		final List<String> list = Utils.readLinesFromFile("day08/input_example.txt");

		assertEquals(8, Day08Part2.solvePuzzle(list));
	}
}
