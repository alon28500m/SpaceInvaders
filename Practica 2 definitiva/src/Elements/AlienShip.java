package Elements;

import Juego.Game;

public abstract class AlienShip extends EnemyShip {
	static boolean isLeft;
	static int moveDown;

	public AlienShip(Game game, int X, int Y, int lives) {
		super(game, X, Y, lives);
		isLeft = true;
		moveDown = 0;
		// TODO Auto-generated constructor stub
	}

	public abstract void computerAction();

	public abstract void onDelete();

	public static boolean getDir() {
		return isLeft;
	}

	public boolean setDir(boolean dir) {
		return isLeft = dir;
	}

	public void move() {
		if(moveDown > 0) {
			y++;
			moveDown--;
		}
		else {
				if(isLeft) {
					
					if(x - 1<  0){
						moveDown = game.alienCount();	
					}
					x--;
				}
				else if(!isLeft) {
					
					if((x + 1 > Game.DIM_X )) {
						moveDown = game.alienCount();
						
					}
					x++;
				}
		}	
	}

	public abstract String toString();

	public boolean allDead() {
		if (game.getcurrentElements() == 0)
			return true;
		else
			return false;
	}

	public boolean haveLanded() {
		return y == 0;
	}

	public boolean recieveBombAttack(int amount) {
		return false;
	}

	public boolean recieveMissileAttack(int amount) {
		getDamage(amount);
		return true;
	}

	public boolean recieveShockwaveAttack(int amount) {
		getDamage(amount);
		return true;
	}
}
