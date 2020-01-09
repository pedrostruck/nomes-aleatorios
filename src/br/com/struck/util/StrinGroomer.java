package br.com.struck.util;

import java.util.ArrayList;
import java.util.List;

import br.com.struck.FileController;
import br.com.struck.Sorter;

public class StrinGroomer {

	private static final FileController fc = new FileController();
	private static final String arquivo1 = "a-fem.txt";
	private static final String arquivo2 = "nomes-femininos.txt";
	
	public static void main(String[] args) {
		List<List<String>> listas = new ArrayList<>();
		listas.add(fc.getLinesFromFile(arquivo1));
		listas.add(fc.getLinesFromFile(arquivo2));
		List<String> finalList = new ArrayList<>();
		for (List<String> l : listas) {
			for (String s : l) {
				if (!finalList.contains(s)) {
					finalList.add(s);
				}
			}
		}
		Sorter.sortList(finalList);
		fc.writeStringListToFile("f", finalList);
	}
}
