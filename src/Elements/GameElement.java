package Elements;

import Juego.Game;

public abstract class GameElement implements IAttack {
	protected int x;
	protected int y;
	protected int shield;
	protected Game game;

	public GameElement(Game game, int X, int Y, int lives) {
		this.x = X;
		this.y = Y;
		this.game = game;
		shield = lives;
	}

	public int getX() { return this.x;}
	public int getY() { return this.y;}
	public int setX(int X) {
		return this.x = X;
	}
	public int setY(int Y) {
		return this.y = Y;
	}
	
	public boolean isAlive() {
		return shield > 0;
	}
	
	public void initElement(GameElement element) {
		if(element.getClass().equals(Missile.class))
			game.shootMissile();
		
	}
	public int getShield() {
		return this.shield;
	}
	

	public boolean isOnPosition( int X, int Y ) {
		return this.x == X && y == Y;
	}

	public void getDamage(int damage) {
		shield = (damage >= shield ? 0 : shield - damage);
	}

	public boolean isOut() {
		return !game.isOnBoard( this.x, this.y);
	}

	public abstract void computerAction();

	public abstract void onDelete();

	public abstract void move();

	public abstract String toString();
}
