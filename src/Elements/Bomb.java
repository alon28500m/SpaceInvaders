package Elements;

import Juego.Game;

public class Bomb extends Weapon{

	public Bomb(Game game, int X, int Y, int lives) {
		super(game, X, Y, lives);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void computerAction() {
		if(game.checkCollision(x, y - 1))
			this.onDelete();
	}

	@Override
	public void onDelete() {
		game.delete(this.x, this.y);
	}

	@Override
	public void move() {
		y++;
		if(y == 0)
			this.onDelete();
	}

	@Override
	public String toString() {
	return " ! " ;
	}
	public boolean performAttack() {
		boolean done = false;
		if(game.checkCollision(x, y - 1)) {
			game.damage(x, y - 1, 1);
			done = true;
		}	
		return done;
	}
	public boolean recieveBombAttack(int amount) {
		return false;
	}
	public boolean recieveMissileAttack(int amount) {
		this.onDelete();
		return true;
	}
	public boolean recieveShockwaveAttack(int amount) {
		this.onDelete();
		return true;
	}
	
}
