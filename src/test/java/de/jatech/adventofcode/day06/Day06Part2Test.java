package de.jatech.adventofcode.day06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Day06Part2Test {
	@Test
	void testPuzzle() throws Exception {
//		final List<String> list = Utils.readLinesFromFile("day06/input_example.txt");

		assertEquals(19, Day06Part2.solvePuzzle("mjqjpqmgbljsphdztnvjfqwrcgsmlb"));
		assertEquals(23, Day06Part2.solvePuzzle("bvwbjplbgvbhsrlpgdmjqwftvncz"));
		assertEquals(23, Day06Part2.solvePuzzle("nppdvjthqldpwncqszvftbrmjlhg"));
		assertEquals(29, Day06Part2.solvePuzzle("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"));
		assertEquals(26, Day06Part2.solvePuzzle("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"));
	}
}
