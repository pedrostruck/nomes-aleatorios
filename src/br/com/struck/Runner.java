package br.com.struck;

import java.util.ArrayList;
import java.util.List;

import br.com.struck.util.Sorter;

public class Runner {

	private static NamesGenerator ng = new NamesGenerator();

	public static void main(String[] args) {
		ArrayList<String> list = ng.getMultipleNamesAsList(Long.valueOf(args[0]));
		Sorter.sortList(list);
		printList(list);
	}

	private static void printList(List<String> list) {
		for (String s : list) {
			System.out.println(s);
		}
	}
}
