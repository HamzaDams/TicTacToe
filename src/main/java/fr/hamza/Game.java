package fr.hamza;

public interface Game {
	/**
	 * Permet de lancer une partie
	 */
	public void lancerPartie();

	/**
	 * Permet de d'init le premier joueur
	 * 
	 * @return Joueur
	 */
	public Joueur setRandomFirstPlayer();

	/**
	 * Test si il y a un gagnant
	 */
	public boolean checkIfGagnant();

	/**
	 * Met fin a la partie
	 */
	public void turnEnd();

	/**
	 * Nouveau tour
	 */
	public void newTurn();

	/**
	 * Affiche la grille
	 */
	public void afficherGrille();

	/**
	 * Propose au joueur de jouer
	 */
	public void askPlayerToPlay();

	/**
	 * Verif les coordonées
	 */
	public boolean checkCoords(String coord);

	/**
	 * Switch de joueur
	 */
	public void changePlayer();
}
