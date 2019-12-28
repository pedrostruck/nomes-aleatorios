package br.com.struck;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NamesGenerator {
	private static final FileController fc = new FileController();
	private final static Random generator = new Random();
	private final static long quantity = 100;

	public static void main(String[] args) throws IOException {
		ArrayList<String> list = getMultipleNamesAsList(quantity);
		Sorter.sortList(list);
		printList(list);
	}
	
	private static ArrayList<String> getMultipleNamesAsList(long quantity) {
		ArrayList<String> names = new ArrayList<>();
		for(long i = 0; i < quantity; i++) {
			names.add(getRandomName());
		}
		return names;
	}
	
	private static String getRandomName() {
		StringBuilder name = new StringBuilder();
		name.append(getFirstName());
		name.append(getSurname());
		return name.toString();
	}
	
	private static String getSurname() {
		String firstSurname = getRandomStringFromFile(ArquivosEnum.SN.nome());
		String secondSurname;
		do {
			secondSurname = getRandomStringFromFile(ArquivosEnum.SN.nome());
		} while (firstSurname.equals(secondSurname));
		return " " + firstSurname + " " + secondSurname;
	}

	private static String getFirstName() {
		return generator.nextBoolean() ? getRandomStringFromFile(ArquivosEnum.MASC.nome())
						: getRandomStringFromFile(ArquivosEnum.FEM.nome());
	}

	private static void printList(List<String> list) {
		for (String s : list) {
			System.out.println(s);
		}
	}

	private static String getRandomStringFromFile(String filename) {
		int numberOfLines;
		try {
			numberOfLines = fc.getNumberOfLinesFromFile(filename);
			return fc.getLineFromFile(filename, getRandomNumberInRange(1, numberOfLines));
		} catch (IOException e) {
			e.printStackTrace();
			return "IOException";
		}
	}

	public static int getRandomNumberInRange(int min, int max) {
		return generator.nextInt((max - min) + 1);
	}

}
