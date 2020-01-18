package br.com.struck.util;

import java.util.Random;

public class Randomness {

	final static Random random = new Random();

	public int getRandomNumberInRange(int min, int max) {
		return random.nextInt((max - min) + 1);
	}

	public boolean flipACoin() {
		return random.nextBoolean();
	}

}
