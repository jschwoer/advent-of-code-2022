package de.jatech.adventofcode.day07;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.jatech.adventofcode.common.Utils;

public class Day07Part1 {
	public static void main(final String[] args) throws IOException, URISyntaxException {
		final List<String> input = Utils.readLinesFromFile("day07/input.txt");

		final int result = solvePuzzle(input);

		System.out.println("Result: " + result);
	}

	static int solvePuzzle(final List<String> input) {
		int result = -1;

		Collection<MyDirectory> allDirectories = new ArrayList<>();
		MyDirectory rootDirectory = new MyDirectory(null, "/");
		allDirectories.add(rootDirectory);
		MyDirectory currenDirectory = null;
		for (int idx = 0; idx < input.size(); idx++) {
			String line = input.get(idx);

			if (line.startsWith("$")) {
				String command = line.substring("$ ".length());

				if (command.startsWith("cd ")) {
					String target = command.substring("cd ".length());
					switch (target) {
						case "/":
							currenDirectory = rootDirectory;
							break;
						case "..":
							currenDirectory = currenDirectory.parent;
							break;
						default:
							currenDirectory = currenDirectory.directories.get(target);
					}
				} else if (command.startsWith("ls")) {
					int dirIdx = idx;
					while (input.size() > dirIdx + 1 && !input.get(dirIdx + 1).startsWith("$")) {
						dirIdx++;
						String lsOutput = input.get(dirIdx);
						if (lsOutput.startsWith("dir ")) {
							String name = lsOutput.substring("dir ".length());
							if (!currenDirectory.directories.containsKey(name)) {
								MyDirectory directory = new MyDirectory(currenDirectory, name);
								currenDirectory.directories.put(name, directory);
								allDirectories.add(directory);
							}
						} else {
							String[] fileParts = lsOutput.split(" ");
							MyFile myFile = new MyFile(fileParts[1], Integer.parseInt(fileParts[0]));
							currenDirectory.files.add(myFile);
						}

					}

					idx = dirIdx;
				}
			}
		}

		for (MyDirectory directory : allDirectories)
		{
			System.out.println(directory.name + ": " + directorySize(directory));
		}

		result = allDirectories.stream().mapToInt(Day07Part1::directorySize).filter(i -> i <= 100000).sum();

		System.out.println(result);
		return result;
	}

	static int directorySize(MyDirectory startDirectory) {
		int result = startDirectory.files.stream().mapToInt(f -> f.size).sum();
		result += startDirectory.directories.values().stream().mapToInt(Day07Part1::directorySize).sum();
		return result;
	}

	static class MyDirectory {
		String name;
		MyDirectory parent = null;
		Map<String, MyDirectory> directories = new HashMap<>();
		List<MyFile> files = new ArrayList<>();

		public MyDirectory(MyDirectory parent, String name) {
			this.parent = parent;
			this.name = name;
		}
	}

	static class MyFile {
		String name;
		int size;

		public MyFile(String name, int size) {
			this.name = name;
			this.size = size;
		}

		@Override
		public String toString() {
			return "MyFile [name=" + name + ", size=" + size + "]";
		}
	}
}
