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

	private static Randomness aleatorio = new Randomness();

	public List<String> getLinesFromFile(String filename) {
		List<String> list = new ArrayList<>();
		try {
			File fileURL = new File(filename);
			BufferedReader br = new BufferedReader(
							new InputStreamReader(new FileInputStream(fileURL), "UTF8"));
			String line;
			while ((line = br.readLine()) != null) {
				list.add(line.trim());
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void writeStringListToFile(String filename, List<String> list) {
		Charset utf8 = StandardCharsets.UTF_8;
		try {
			Files.write(Paths.get(filename + "_output.txt"), list, utf8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getOutputName(String filename) {
		return filename.substring(0, filename.lastIndexOf("."));
	}

	public int getNumberOfLinesFromFile(String filename) throws IOException {
		BufferedReader br = new BufferedReader(
						new InputStreamReader(new FileInputStream(new File(filename)), "UTF8"));
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

	public String getRandomStringFromFile(String filename) {
		int numberOfLines;
		try {
			numberOfLines = getNumberOfLinesFromFile(filename);
			return getLineFromFile(filename, aleatorio.getRandomNumberInRange(1, numberOfLines));
		} catch (IOException e) {
			e.printStackTrace();
			return "IOException";
		}
	}

	public void trimFile(String filename) {
		try {
			BufferedReader br = new BufferedReader(
							new InputStreamReader(new FileInputStream(new File(filename)), "UTF8"));
			String str;
			while ((str = br.readLine().trim()) != null) {
				System.out.println(str);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
