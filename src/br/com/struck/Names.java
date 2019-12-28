package br.com.struck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Names {
	private static List<String> filenames = new ArrayList<String>();

	public static void main(String[] args) {
		filenames.add("a.txt");
		for (String filename : filenames) {
			try {
				readFromFile(filename);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void readFromFile(String filename) throws IOException {
		File file = new File(filename);
		FileReader fr;

		fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
		fr.close();
	}
}
