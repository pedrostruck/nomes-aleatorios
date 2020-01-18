package br.com.struck.util;

public class MascaraUtil {

	public static String getCpfComMascara(String cpfSemMascara) {
		StringBuilder cpfComMascara = new StringBuilder();
		cpfComMascara.append(cpfSemMascara.substring(0, 3));
		cpfComMascara.append(".");
		cpfComMascara.append(cpfSemMascara.substring(3, 6));
		cpfComMascara.append(".");
		cpfComMascara.append(cpfSemMascara.substring(6, 9));
		cpfComMascara.append("-");
		cpfComMascara.append(cpfSemMascara.substring(9));
		return cpfComMascara.toString();
	}
}
