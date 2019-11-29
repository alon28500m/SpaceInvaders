package Elements;

import Juego.Board;
import Juego.Game;

public abstract class AlienShip extends EnemyShip{
	boolean isLeft;
	boolean moveDown;
	Board board; 

	public AlienShip(Game game, int X, int Y, int lives) {
		super(game, X, Y, lives);
		this.isLeft = true;
		this.moveDown = false;
		// TODO Auto-generated constructor stub
	}
	public abstract void computerAction();

	public abstract void onDelete();

	public void move() {
		if((x<8)&&(x>0)&&(!moveDown)) {
			if(isLeft == true)
				x--;
			else
				x++;	
		}
		else {
			y--;
			isLeft = !isLeft;
			moveDown = false;
		}
	}

	public abstract String toString();
	
	public boolean allDead() {
		if(board.getcurrentElements() == 0)
			return true;
		else 
			return false;
	}
	public boolean haveLanded() {
		return y == 0;
	}
}
