package Printer;

import Juego.Game;

public abstract class GamePrinter {
	public GamePrinter() {};
	public abstract GamePrinter setGame(Game game);
	public abstract String toString(Game game);
	public GamePrinter parse(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	public String helpText() {
		// TODO Auto-generated method stub
		return null;
	}
}
