package br.com.struck.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.struck.NamesGenerator;
import br.com.struck.enums.FrequenciaEscolarEnum;
import br.com.struck.enums.NivelEnsinoEnum;

public class RandomGenerator {

	private final static Random random = new Random();
	private final static NamesGenerator ng = new NamesGenerator();
	private static List<String> matriculas = new ArrayList<>();
	private static List<String> cpfs = new ArrayList<>();

	public String getRandomNumeroMatricula() {
		String matricula;
		do {
			matricula = String.valueOf(getRandomIntInRange(0, 999999));
		} while (isMatriculaRepetida(matricula));
		matriculas.add(matricula);
		return matricula;
	}

	private boolean isMatriculaRepetida(String matricula) {
		return matriculas.contains(matricula);
	}

	public int getRandomIntInRange(int min, int max) {
		return random.nextInt((max - min) + 1);
	}

	public Double getRandomDoubleInRange(double min, double max) {
		double randomDouble = random.nextDouble();
		return min + (randomDouble * (max - min));
	}

	public boolean flipACoin() {
		return random.nextBoolean();
	}

	public String getRandomFullName() {
		return ng.getRandomFullName();
	}

	public String getRandomFemaleName() {
		return ng.getRandomFemaleName();
	}

	public String getRandomNivelEnsino() {
		return getRandomEnum(NivelEnsinoEnum.class).value();
	}

	public Double getRandomPercentualFrequenciaEscolar() {
		return getRandomEnum(FrequenciaEscolarEnum.class).value();
	}

	public LocalDate getRandomBirthDate() {
		int minDay = (int) LocalDate.of(2002, 1, 1).toEpochDay();
		int maxDay = (int) LocalDate.of(2009, 12, 31).toEpochDay();
		long randomDay = minDay + random.nextInt(maxDay - minDay);
		return LocalDate.ofEpochDay(randomDay);
	}

	public String getRandomCpf() {
		StringBuilder sb = new StringBuilder();
		do {
			for (int i = 0; i < 11; i++) {
				sb.append(String.valueOf(getRandomIntInRange(0, 9)));
			}
		} while (cpfs.contains(sb.toString()));
		cpfs.add(sb.toString());
		return MascaraUtil.getCpfComMascara(sb.toString());
	}

	public static <T extends Enum<?>> T getRandomEnum(Class<T> clazz) {
		int x = random.nextInt(clazz.getEnumConstants().length);
		return clazz.getEnumConstants()[x];
	}

}
