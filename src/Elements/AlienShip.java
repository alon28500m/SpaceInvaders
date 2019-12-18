package Elements;

import Juego.Game;

public abstract class AlienShip extends EnemyShip {
	static boolean isLeft;
	static boolean moveDown;
	protected boolean hasMovedDown;

	public AlienShip(Game game, int X, int Y, int lives) {
		super(game, X, Y, lives);
		isLeft = true;
		moveDown = false;
		hasMovedDown = false;
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
		if((x<Game.DIM_X + 1)&&(x > -1)){
			if(!moveDown) {
				if((x == Game.DIM_X )||(x== 0)&& !hasMovedDown) {
					moveDown = true;
				}
				else if(isLeft) {
					x--;
					hasMovedDown = false;
				}
				else if(!isLeft) {
					x++;
					hasMovedDown = false;
				}
			}
			else if(moveDown){
				isLeft = !isLeft;
				
				game.MovedDown();
				moveDown = false;
				hasMovedDown = true;
			}
			else if(haveLanded())
				game.aliensWin();
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
