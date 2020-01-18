package br.com.struck;

import java.util.ArrayList;

import br.com.struck.enums.ArquivosEnum;
import br.com.struck.util.FileController;
import br.com.struck.util.RandomGenerator;

public class NamesGenerator {
	private static final FileController fc = new FileController();
	private static RandomGenerator random = new RandomGenerator();

	public ArrayList<String> getMultipleNamesAsList(long quantity) {
		ArrayList<String> names = new ArrayList<>();
		for (long i = 0; i < quantity; i++) {
			names.add(getRandomFullName());
		}
		return names;
	}

	public String getRandomFullName() {
		StringBuilder name = new StringBuilder();
		name.append(getFirstName()).append(getSurnames());
		return name.toString();
	}

	public String getRandomFemaleName() {
		StringBuilder name = new StringBuilder();
		name.append(getFirstNameFemale()).append(getSurnames());
		return name.toString();
	}

	public String getFirstName() {
		return random.flipACoin() ? fc.getRandomStringFromFile(ArquivosEnum.MASC.nome())
						: fc.getRandomStringFromFile(ArquivosEnum.FEM.nome());
	}

	public String getFirstNameFemale() {
		return fc.getRandomStringFromFile(ArquivosEnum.FEM.nome());
	}

	public String getSurnames() {
		String firstSurname = fc.getRandomStringFromFile(ArquivosEnum.SN.nome());
		String secondSurname = getDifferentSurname(firstSurname);
		return " " + firstSurname + " " + secondSurname;
	}

	public String getDifferentSurname(String firstSurname) {
		String otherSurname;
		do {
			otherSurname = fc.getRandomStringFromFile(ArquivosEnum.SN.nome());
		} while (firstSurname.equals(otherSurname));
		return otherSurname;
	}

}
