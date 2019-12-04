package Elements;

import Juego.Game;

public class Missile extends Weapon{

	public Missile(Game game, int X, int Y, int lives) {
		super(game, X, Y, lives);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void computerAction() {
		if(performAttack())
			this.onDelete();
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
	public boolean performAttack() {
		boolean done = false;
		if(game.checkCollision(x, y + 1)) {
			done = game.damage(x, y - 1, 1);
			
		}	
		return done;
	}
	public boolean recieveBombAttack(int amount) {
		this.onDelete();
		return true;
	}
	public boolean recieveMissileAttack(int amount) {
		return false;
	}
	public boolean recieveShockwaveAttack(int amount) {
		return false;
	}
}
