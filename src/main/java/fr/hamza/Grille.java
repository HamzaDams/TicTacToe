package fr.hamza;

class Grille {

	public char[][] values;

	/**
	 * Les coordonées sont liées à un tableau à deux dimensions
	 */
	public Grille() {
		this.values = new char[][] { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
	}

	/**
	 * Quand le tableau et rempli
	 */
	public boolean isFull() {
		int total = 0;
		for (char[] line : values) {
			for (char symbole : line) {
				if (symbole != ' ')
					total++;
			}
		}
		return total == 9;
	}

	/**
	 * Place un symbole a une coordonnee
	 */
	public void setSymbolAt(int x, int y, char symbole) {
		if (getSymbolAt(x, y) == ' ')
			this.values[x][y] = symbole;
	}

	/**
	 * Recupere le symbole sur une position donnée
	 */
	public char getSymbolAt(int x, int y) {
		return this.values[x][y];
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("  ┌─1─┬─2─┬─3─┐").append(System.lineSeparator());
		builder.append("1 │ ").append(getSymbolAt(0, 0)).append(" │ ").append(getSymbolAt(1, 0)).append(" │ ")
				.append(getSymbolAt(2, 0)).append(" │").append(System.lineSeparator());
		builder.append("  ├───┼───┼───┤").append(System.lineSeparator());
		builder.append("2 │ ").append(getSymbolAt(0, 1)).append(" │ ").append(getSymbolAt(1, 1)).append(" │ ")
				.append(getSymbolAt(2, 1)).append(" │").append(System.lineSeparator());
		builder.append("  ├───┼───┼───┤").append(System.lineSeparator());
		builder.append("3 │ ").append(getSymbolAt(0, 2)).append(" │ ").append(getSymbolAt(1, 2)).append(" │ ")
				.append(getSymbolAt(2, 2)).append(" │").append(System.lineSeparator());
		builder.append("  └───┴───┴───┘").append(System.lineSeparator());

		return builder.toString();
	}

}