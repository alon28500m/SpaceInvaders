package Elements;

import Juego.Game;

public class ExplosiveShip extends AlienShip{
	
	public ExplosiveShip(Game game, int X, int Y, int lives) {
		super(game, X, Y, lives);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void computerAction() {
		
			
	}

	@Override
	public void onDelete() {
		game.explode(x, y);
		game.delete(x, y);
	}

	@Override
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

	@Override
	public String toString() {
		return "*<n>*";
	}

}
