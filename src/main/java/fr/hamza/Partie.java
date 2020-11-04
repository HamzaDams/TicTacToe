package fr.hamza;

import java.util.Arrays;
import java.util.List;

public class Partie implements Game {
	Grille grille;
	Joueur joueurX;
	Joueur joueurO;
	Joueur currentPlayer;

	public void lancerPartie() {
		grille = new Grille();
		joueurX = new Joueur(new Symbole('X'));
		joueurO = new Joueur(new Symbole('O'));
		currentPlayer = this.setRandomFirstPlayer();
		this.newTurn();
	}

	public boolean checkIfGagnant() {
		return false;
	}

	public void turnEnd() {
		// check si y'a un gagnant

		if (this.isWon() != null) {
			WinCondition win = isWon();

			Outils.clearConsole();
			this.afficherGrille();
			System.out.println("Le joueur " + win.symbol + " a gagné sur la " + win.endroit + " !");
		} else if (this.grille.isFull()) {

			Outils.clearConsole();
			this.afficherGrille();
			System.out.println("La grille est pleine! Egalité !");
		} else {
			this.newTurn();
		}
	}

	public void newTurn() {
		Outils.clearConsole();
		this.afficherGrille();
		this.askPlayerToPlay();
		this.changePlayer();
		this.turnEnd();
	}

	public void askPlayerToPlay() {
		System.out.println("Eh joue joueur " + currentPlayer.symbole.symbole + " :");
		System.out.println("Rentre les coordonées séparées par une girvule foubon : ");
		String coordsString = Outils.scanner.nextLine();
		String[] coords = coordsString.split(",");
		int coordonéesBnnes = 0;
		if (coords.length == 2) {
			for (String coord : coords) {
				if (this.checkCoords(coord)) {
					coordonéesBnnes++;
				} else {
					System.out.println("dla merde");
				}
			}
		}
		if (coordonéesBnnes == 2) {
			this.grille.setSymbolAt(Integer.parseInt(coords[0]) - 1, Integer.parseInt(coords[1]) - 1,
					this.currentPlayer.symbole.symbole);
		} else {
			this.askPlayerToPlay();
		}
	}

	public Joueur setRandomFirstPlayer() {
		int chiffreRandom = (int) (Math.random() * 2);
		if (chiffreRandom == 0) {
			return joueurO;
		} else {
			return joueurX;
		}
	}

	public void afficherGrille() {
		System.out.println(this.grille.toString());
	}

	public boolean checkCoords(String coord) {

		if (coord.matches(".*\\d+.*")) {
			int chiffre = Integer.parseInt(coord);
			if (chiffre >= 1 && chiffre <= 3) {
				return true;
			}
		}
		return false;
	}

	public void changePlayer() {
		this.currentPlayer = this.currentPlayer.symbole.symbole == 'X' ? this.joueurO : this.joueurX;
	}

	private WinCondition isWon() {
		char c00 = grille.getSymbolAt(0, 0);
		char c10 = grille.getSymbolAt(1, 0);
		char c20 = grille.getSymbolAt(2, 0);
		char c01 = grille.getSymbolAt(0, 1);
		char c11 = grille.getSymbolAt(1, 1);
		char c21 = grille.getSymbolAt(2, 1);
		char c02 = grille.getSymbolAt(0, 2);
		char c12 = grille.getSymbolAt(1, 2);
		char c22 = grille.getSymbolAt(2, 2);
		boolean line1Condition = c00 != ' ' && c00 == c10 && c10 == c20;
		boolean line2Condition = c01 != ' ' && c01 == c11 && c11 == c21;
		boolean line3Condition = c02 != ' ' && c02 == c12 && c12 == c22;
		WinCondition line1 = new WinCondition(line1Condition, "première ligne", c00);
		WinCondition line2 = new WinCondition(line2Condition, "seconde ligne", c01);
		WinCondition line3 = new WinCondition(line3Condition, "troisième ligne", c02);

		boolean col1Condition = c00 != ' ' && c00 == c01 && c01 == c02;
		boolean col2Condition = c10 != ' ' && c10 == c11 && c11 == c12;
		boolean col3Condition = c20 != ' ' && c20 == c21 && c21 == c22;
		WinCondition col1 = new WinCondition(col1Condition, "première colonne", c00);
		WinCondition col2 = new WinCondition(col2Condition, "seconde colonne", c10);
		WinCondition col3 = new WinCondition(col3Condition, "troisième colonne", c20);

		boolean diag1Condition = c00 != ' ' && c00 == c11 && c11 == c22;
		boolean diag2Condition = c20 != ' ' && c20 == c11 && c11 == c02;
		WinCondition diag1 = new WinCondition(diag1Condition, "diagonale 1", c00);
		WinCondition diag2 = new WinCondition(diag2Condition, "diagonale 2", c20);

		List<WinCondition> conditions = Arrays.asList(line1, line2, line3, col1, col2, col3, diag1, diag2);
		for (WinCondition winCondition : conditions) {
			if (winCondition.condition == true)
				return winCondition;
		}

		return null;

	}

}