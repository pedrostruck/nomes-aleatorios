package br.com.struck;

import java.util.ArrayList;
import java.util.List;

public class Runner {

	private static NamesGenerator ng = new NamesGenerator();

	public static void main(String[] args) {
		long quantity = 100;
		ArrayList<String> list = ng.getMultipleNamesAsList(quantity);
		Sorter.sortList(list);
		printList(list);
	}

	private static void printList(List<String> list) {
		for (String s : list) {
			System.out.println(s);
		}
	}
}
