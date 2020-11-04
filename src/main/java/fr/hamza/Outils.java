package fr.hamza;

import java.util.Scanner;

public class Outils {
	static Scanner scanner = new Scanner(System.in);

	protected final static void clearConsole() {
		for (int i = 0; i < 50; ++i)
			System.out.println();
	}
}
