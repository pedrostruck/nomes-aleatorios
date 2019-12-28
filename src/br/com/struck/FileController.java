package br.com.struck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileController {
	public List<String> readFromFile(String filename) throws IOException {
		List<String> list = new ArrayList<>();
		File fileURL = new File(filename);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileURL), "UTF8"));

		String line;
		while ((line = br.readLine()) != null) {
			line = line.trim();
			if (!list.contains(line)) {
				list.add(line);
			}
		}
		br.close();
		return list;
	}

	public void writeToFile(String filename, List<String> list) {
		Charset utf8 = StandardCharsets.UTF_8;
		try {
			Files.write(Paths.get(filename + "_output.txt"), list, utf8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getOutputName(String filename) {
		return filename = filename.substring(0, filename.lastIndexOf("."));
	}

	public int getNumberOfLinesFromFile(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filename)), "UTF8"));
		int numberOfLines = 0;
		while (br.readLine() != null) {
			numberOfLines++;
		}
		br.close();
		return numberOfLines;
	}

	public String getLineFromFile(String filename, int lineNumber) throws IOException {
		return Files.readAllLines(Paths.get(filename)).get(lineNumber);
	}
}
