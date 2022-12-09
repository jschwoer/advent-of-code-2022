package de.jatech.adventofcode.day08;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import de.jatech.adventofcode.common.Utils;

public class Day08Part2 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day08/input.txt");

		final int result = solvePuzzle(input);

		System.out.println("Result: " + result);
	}

	static int solvePuzzle(final List<String> input) {
		int result = 0;

		int numberOfCols = input.get(0).length();
		int numberOfRows = input.size();
		int[][] treeMap = new int[numberOfRows][numberOfCols];

		for (int rowIdx = 0; rowIdx < input.size(); rowIdx++) {
			String line = input.get(rowIdx);
			for (int colIdx = 0; colIdx < line.length(); colIdx++) {
				treeMap[rowIdx][colIdx] = Integer.parseInt("" + line.charAt(colIdx));
			}
		}

		int maxScore = 0;
		int score = 1;
		for (int rowIdx = 0; rowIdx < numberOfRows; rowIdx++) {
			for (int colIdx = 0; colIdx < numberOfCols; colIdx++) {
				int height = treeMap[rowIdx][colIdx];
				int up = treesVisibleUp(treeMap, rowIdx, colIdx);
				int left = treesVisibleLeft(treeMap, rowIdx, colIdx);
				int right = treesVisibleRight(treeMap, rowIdx, colIdx);
				int down = treesVisibleDown(treeMap, rowIdx, colIdx);
				
				score = up * down * left * right;
				maxScore = Math.max(score, maxScore);
			}
		}

		return maxScore;
	}

	private static int treesVisibleUp(int[][] treeMap, int row, int col) {
		int count = 0;
		int height = treeMap[row][col];
		for (int rowIdx = row - 1; rowIdx >= 0; rowIdx--) {
			if (treeMap[rowIdx][col] >= height) {
				count++;
				break;
			} else {
				count++;
			}
		}
		return count;
	}

	private static int treesVisibleDown(int[][] treeMap, int row, int col) {
		int count = 0;
		int height = treeMap[row][col];
		for (int rowIdx = row + 1; rowIdx < treeMap.length; rowIdx++) {
			if (treeMap[rowIdx][col] >= height) {
				count++;
				break;
			} else {
				count++;
			}
		}
		return count;
	}

	private static int treesVisibleLeft(int[][] treeMap, int row, int col) {
		int count = 0;
		int height = treeMap[row][col];
		for (int colIdx = col - 1; colIdx >= 0; colIdx--) {
			if (treeMap[row][colIdx] >= height) {
				count++;
				break;
			} else {
				count++;
			}
		}
		return count;
	}

	private static int treesVisibleRight(int[][] treeMap, int row, int col) {
		int count = 0;
		int height = treeMap[row][col];
		for (int colIdx = col + 1; colIdx < treeMap[row].length; colIdx++) {
			if (treeMap[row][colIdx] >= height) {
				count++;
				break;
			} else {
				count++;
			}
		}
		return count;
	}
}
