package br.com.struck.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileController {

	private static Randomness aleatorio = new Randomness();

	public List<String> getLinesFromFileAsList(String filename) {
		List<String> list = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(
							new InputStreamReader(new FileInputStream(new File(filename)), "UTF8"));
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

	public List<String> getLinesFromFilesAsList(List<String> filenames) {
		List<String> list = new ArrayList<>();
		try {
			for (String filename : filenames) {
				BufferedReader br = new BufferedReader(
								new InputStreamReader(
												new FileInputStream(new File(filename)),
													"UTF8"));
				String line;
				while ((line = br.readLine()) != null) {
					list.add(line.trim());
				}
				br.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void writeStringListToFile(String filename, List<String> list) {
		try {
			Files.write(Paths.get(filename + "_output.txt"), list, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getOutputName(String filename) {
		return filename.substring(0, filename.lastIndexOf("."));
	}

	public int getNumberOfLinesFromFile(String filename) {
		BufferedReader br;
		int numberOfLines = 0;
		try {
			br = new BufferedReader(
							new InputStreamReader(new FileInputStream(new File(filename)), "UTF8"));
			while (br.readLine() != null) {
				numberOfLines++;
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return numberOfLines;
	}

	public String getLineFromFile(String filename, int lineNumber) {
		String toReturn = "";
		try {
			toReturn = Files.readAllLines(Paths.get(filename)).get(lineNumber);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return toReturn;
	}

	public String getRandomStringFromFile(String filename) {
		int numberOfLines;
		numberOfLines = getNumberOfLinesFromFile(filename);
		return getLineFromFile(filename, aleatorio.getRandomNumberInRange(1, numberOfLines));
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
