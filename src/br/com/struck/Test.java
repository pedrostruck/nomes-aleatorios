package br.com.struck;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Test {
	private final static Random generator = new Random();
	private final static FileController fc = new FileController();
	private static int numbersQuantity = 10000;
	private static double min = 0.90;
	private static double max = 1000.0;
	private static double stepsize = 0;
	private final static double decimalPart = 10000 * stepsize;
	static List<String> list = new ArrayList<>();

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		long endTime;
		String outputFile = fc.getOutputName("text.txt");

		createList();
//		sortList(list);
		printList(list);
		fc.writeToFile(outputFile, list);
		endTime = System.currentTimeMillis();
		System.out.println(
				"Time elapsed (s): " + ((endTime - startTime) / 1000.0));
	}

	private static void createList() {
		for (int i = 0; i < numbersQuantity; i++) {
			list.add(String.valueOf(getRandomIntegerInRange(1, 249)));
		}
	}

	@SuppressWarnings("unchecked")
	private static void sortList(List<String> list) {
		Comparator<? super Double> c = null;
		list.sort((Comparator<? super String>) c);
	}

	private static void printList(List<String> list) {
		for (String s : list) {
			System.out.println(s);
		}
	}

	public static double getRandomNumberInRange(double min, double max) {
		return (generator.nextInt((int) ((max - min) * decimalPart + 1))
				+ min * decimalPart) / decimalPart;
	}

	private static Integer getRandomIntegerInRange(Integer min, Integer max) {
		return generator.nextInt((max - min) + 1) + min;
	}
}
