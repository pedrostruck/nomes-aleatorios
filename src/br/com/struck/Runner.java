package br.com.struck;

import java.util.ArrayList;
import java.util.List;

import br.com.struck.util.QueryGenerator;

public class Runner {

	private static EstudanteGenerator eg = new EstudanteGenerator();
	private static QueryGenerator qg = new QueryGenerator();

	public static void main(String[] args) {
		ArrayList<Estudante> estudantes = eg.getRandomEstudantes(args[0], args[1], args[2],
						Long.valueOf(args[3]));
		ArrayList<String> queryValues = new ArrayList<>();
		for (Estudante estudante : estudantes) {
			if (!isLastEstudanteFromList(estudante, estudantes)) {
				queryValues.add(qg.getValueLine(estudante));
			} else {
				String line = qg.getValueLine(estudante);
				line = line.substring(0, line.lastIndexOf(","));
				line = line + ";";
				queryValues.add(line);
			}
		}
		printList(queryValues);
	}

	private static boolean isLastEstudanteFromList(Estudante e, ArrayList<Estudante> l) {
		return e.equals(l.get(l.size() - 1));
	}

	private static void printList(List<String> list) {
		for (String s : list) {
			System.out.println(s);
		}
	}
}
