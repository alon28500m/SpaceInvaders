package Elements;

import Juego.Game;

public class Bomb extends Weapon{

	public Bomb(Game game, int X, int Y, int lives) {
		super(game, X, Y, lives);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		game.delete(this.x, this.y);
	}

	@Override
	public void move() {
		y--;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
