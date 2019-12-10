package Elements;

import Juego.Game;

public abstract class EnemyShip extends Ship {

	public EnemyShip(Game game, int X, int Y, int lives) {
		super(game, X, Y, lives);
		// TODO Auto-generated constructor stub
	}
	
	public abstract void computerAction();

	public abstract void onDelete();

	public abstract void move();

	public abstract String toString();
}
