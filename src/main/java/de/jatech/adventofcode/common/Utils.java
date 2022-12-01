package de.jatech.adventofcode.common;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

	public static List<String> readLinesFromFile(final String inputName) throws IOException, URISyntaxException {
		final List<String> allLines = Files
				.readAllLines(Paths.get(Utils.class.getClassLoader().getResource(inputName).toURI()));
		return allLines;
	}

	public static List<Integer> readListInt(final String inputName) throws IOException, URISyntaxException {
		final List<String> allLines = readLinesFromFile(inputName);
		return allLines.stream().map(Integer::parseInt).collect(Collectors.toList());
	}

}
