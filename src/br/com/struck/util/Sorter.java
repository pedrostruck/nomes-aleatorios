package br.com.struck.util;

import java.util.Comparator;
import java.util.List;

public class Sorter {

	@SuppressWarnings("unchecked")
	public static void sortList(List<String> list) {
		Comparator<? super Double> c = null;
		list.sort((Comparator<? super String>) c);
	}

}
