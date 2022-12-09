package de.jatech.adventofcode.day08;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import de.jatech.adventofcode.common.Utils;

public class Day08Part1 {
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

		for (int rowIdx = 0; rowIdx < numberOfRows; rowIdx++) {
			for (int colIdx = 0; colIdx < numberOfCols; colIdx++) {
				int height = treeMap[rowIdx][colIdx];
				if (isVisibleFromTop(treeMap, rowIdx, colIdx) || isVisibleFromBottom(treeMap, rowIdx, colIdx)
						|| isVisibleFromLeft(treeMap, rowIdx, colIdx) || isVisibleFromRight(treeMap, rowIdx, colIdx)) {
					result++;
				}
			}
		}

		return result;
	}

	private static boolean isVisibleFromTop(int[][] treeMap, int row, int col) {
		boolean visible = true;
		int height = treeMap[row][col];
		for (int rowIdx = row - 1; rowIdx >= 0; rowIdx--) {
			if (treeMap[rowIdx][col] >= height) {
				visible = false;
				break;
			}
		}
		return visible;
	}

	private static boolean isVisibleFromBottom(int[][] treeMap, int row, int col) {
		boolean visible = true;
		int height = treeMap[row][col];
		for (int rowIdx = row + 1; rowIdx < treeMap.length; rowIdx++) {
			if (treeMap[rowIdx][col] >= height) {
				visible = false;
				break;
			}
		}
		return visible;
	}

	private static boolean isVisibleFromLeft(int[][] treeMap, int row, int col) {
		boolean visible = true;
		int height = treeMap[row][col];
		for (int colIdx = col - 1; colIdx >= 0; colIdx--) {
			if (treeMap[row][colIdx] >= height) {
				visible = false;
				break;
			}
		}
		return visible;
	}

	private static boolean isVisibleFromRight(int[][] treeMap, int row, int col) {
		boolean visible = true;
		int height = treeMap[row][col];
		for (int colIdx = col + 1; colIdx < treeMap[row].length; colIdx++) {
			if (treeMap[row][colIdx] >= height) {
				visible = false;
				break;
			}
		}
		return visible;
	}
}
