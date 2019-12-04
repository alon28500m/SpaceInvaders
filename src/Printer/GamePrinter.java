package Printer;

import Juego.Game;

public abstract class GamePrinter {
	Game game;
	public GamePrinter(Game game) {
		this.game = game;
	}
	public abstract GamePrinter setGame(Game game2);
	public abstract String toString();
}
