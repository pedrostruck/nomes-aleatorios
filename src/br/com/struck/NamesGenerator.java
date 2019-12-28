package br.com.struck;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NamesGenerator {
	private static final FileController fc = new FileController();
	private final static Random generator = new Random();
	private static String maleFirstNames = "firstnames-br-m.txt";
	private static String femaleFirstNames = "firstnames-br-f.txt";
	private static String lastnames = "lastnames-br.txt";
	private static String firstName;
	private static String lastName;
	private static List<String> names = new ArrayList<>();
	private final static long quantity = 100;

	//INSERT INTO `TB_ESTUDANTE` VALUES 
	//(1,'A-Bomb',0)
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder("INSERT INTO `TB_ESTUDANTE` VALUES ");
		String id;
		for (int i = 0; i < quantity; i++) {
			id = String.valueOf(i+1);
			if (i%2 == 0) {
				firstName = getRandomStringFromFile(maleFirstNames);
			} else {
				firstName = getRandomStringFromFile(femaleFirstNames);
			}
			lastName = getRandomStringFromFile(lastnames);
			sb.append("\n(");
			sb.append(id);
			sb.append(",'");
			sb.append(firstName);
			sb.append(" ");
			sb.append(lastName);
			if (i == quantity - 1) {
				sb.append("',0);");	
			} else {
				sb.append("', 0),");
			}
		}
		names.add(sb.toString());
		printList(names);
	}

	private static void printList(List<String> list) {
		for (String s : list) {
			System.out.println(s);
		}
	}

	private static String getRandomStringFromFile(String filename) throws IOException {
		int numberOfLines = fc.getNumberOfLinesFromFile(filename);
		return fc.getLineFromFile(filename, getRandomNumberInRange(1, numberOfLines));
	}

	public static int getRandomNumberInRange(int min, int max) {
		return generator.nextInt((max - min) + 1);
	}

}
