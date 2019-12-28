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

public class Trimmer {

	private static List<String> filenames = new ArrayList<String>();
	private static List<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		filenames.add("lastnames-br.txt");
		for (String filename : filenames) {
			try {
				readFromFile(filename);
				writeToFile(list, filename);
			} catch (IOException e) {
				e.printStackTrace();
			}
			list.clear();
		}
	}

	private static void readFromFile(String filename) throws IOException {
		File fileURL = new File(filename);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileURL), "UTF8"));

		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			list.add(line.trim());
		}
		br.close();
	}

	private static void writeToFile(List<String> list, String filename) {
		Charset utf8 = StandardCharsets.UTF_8;
		try {
			Files.write(Paths.get(filename + "_new.txt"), list, utf8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
