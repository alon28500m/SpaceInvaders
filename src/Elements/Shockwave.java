package Elements;

import Juego.Game;

public class Shockwave extends Weapon{

	public Shockwave(Game game, int X, int Y, int lives) {
		super(game, X, Y, lives);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		game.enableShockWave();
		game.delete(x, y);
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	public boolean performAttack() {
		game.damageAllShips();
		return true;
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean recieveBombAttack(int amount) {
		return false;
	}
	public boolean recieveMissileAttack(int amount) {
		return false;
	}
	public boolean recieveShockwaveAttack(int amount) {
		return false;
	}
}
