package Elements;

import Juego.Game;

public class Missile extends Weapon{

	public Missile(Game game, int X, int Y, int lives) {
		super(game, X, Y, lives);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		game.delete(x, y);
	}

	@Override
	public void move() {
		y++;
		if(y > Game.DIM_Y) {
			onDelete();
		}
	}

	@Override
	public String toString() {
		return "^";
	}

}
