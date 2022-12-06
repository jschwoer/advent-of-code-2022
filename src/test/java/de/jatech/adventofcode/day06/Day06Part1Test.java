package de.jatech.adventofcode.day06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Day06Part1Test {
	@Test
	void testPuzzle() throws Exception {
//		final List<String> list = Utils.readLinesFromFile("day06/input_example.txt");

		assertEquals(7, Day06Part1.solvePuzzle("mjqjpqmgbljsphdztnvjfqwrcgsmlb"));
		assertEquals(5, Day06Part1.solvePuzzle("bvwbjplbgvbhsrlpgdmjqwftvncz"));
		assertEquals(6, Day06Part1.solvePuzzle("nppdvjthqldpwncqszvftbrmjlhg"));
		assertEquals(10, Day06Part1.solvePuzzle("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"));
		assertEquals(11, Day06Part1.solvePuzzle("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"));
	}
}
