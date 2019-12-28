package br.com.struck;

import java.util.ArrayList;

public class NamesGenerator {
	private static final FileController fc = new FileController();
	private static Randomness aleatorio = new Randomness();

	public ArrayList<String> getMultipleNamesAsList(long quantity) {
		ArrayList<String> names = new ArrayList<>();
		for (long i = 0; i < quantity; i++) {
			names.add(getRandomFullName());
		}
		return names;
	}

	public String getRandomFullName() {
		StringBuilder name = new StringBuilder();
		name.append(getFirstName());
		name.append(getSurname());
		return name.toString();
	}

	public String getFirstName() {
		return aleatorio.flipACoin() ? fc.getRandomStringFromFile(ArquivosEnum.MASC.nome())
						: fc.getRandomStringFromFile(ArquivosEnum.FEM.nome());
	}

	public String getSurname() {
		String firstSurname = fc.getRandomStringFromFile(ArquivosEnum.SN.nome());
		String secondSurname;
		do {
			secondSurname = fc.getRandomStringFromFile(ArquivosEnum.SN.nome());
		} while (firstSurname.equals(secondSurname));
		return " " + firstSurname + " " + secondSurname;
	}

}
