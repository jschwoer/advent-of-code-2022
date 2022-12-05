package de.jatech.adventofcode.day05;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.jatech.adventofcode.common.Utils;

public class Day05Part2 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day05/input.txt");

		final String result = solvePuzzle(input);

		System.out.println("Result: " + result);
	}

	static String solvePuzzle(final List<String> input) {
		String result = "";

		List<Stack<String>> stacks = new ArrayList<>();

		int numberOfStacks = -1;
		int startOffset = -1;
		for (String line : input) {
			startOffset++;
			String trimmed = line.trim();

			if (Character.isDigit(trimmed.charAt(trimmed.length() - 1))) {
				numberOfStacks = Integer.parseInt(trimmed.substring(trimmed.lastIndexOf(' ') + 1));
				break;
			}
		}

		for (int count = 0; count < numberOfStacks; count++) {
			stacks.add(new Stack<String>());
		}

		for (int idx = startOffset - 1; idx >= 0; idx--) {
			String line = input.get(idx);

			for (int stackIdx = 0; stackIdx < numberOfStacks; stackIdx++) {
				Stack<String> stack = stacks.get(stackIdx);

				String crate = line.substring(stackIdx * 4 + 1, stackIdx * 4 + 2);
				if (!crate.isBlank()) {
					stack.push(crate);
				}
			}
		}

		Pattern pattern = Pattern.compile("move (\\d+) from (\\d+) to (\\d+)");
		for (String line : input.subList(startOffset + 1, input.size())) {
			Matcher matcher = pattern.matcher(line);
			if (matcher.matches()) {
				int amount = Integer.parseInt(matcher.group(1));
				int from = Integer.parseInt(matcher.group(2)) - 1;
				int to = Integer.parseInt(matcher.group(3)) - 1;

				List<String> subList = new ArrayList<>();
				for (int count = 0; count < amount; count++) {
					subList.add(stacks.get(from).pop());
				}
				Collections.reverse(subList);

				for (int count = 0; count < amount; count++) {
					stacks.get(to).add(subList.get(count));
				}
			}
		}

		for (Stack<String> stack : stacks) {
			result += stack.peek();
		}

		return result;
	}
}
