package Elements;

import Juego.Game;

public abstract class Ship extends GameElement{

	public Ship(Game game, int X, int Y, int lives) {
		super(game, X, Y, lives);
	}
	public abstract void computerAction();

	public abstract void onDelete();

	public abstract void move();

	public abstract String toString();
}
