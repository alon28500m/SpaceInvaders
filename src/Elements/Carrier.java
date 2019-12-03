package Elements;


import Juego.Game;

public class Carrier extends AlienShip{
	boolean isLeft;
	boolean moveDown;
	double explode;
	public Carrier(Game game, int X, int Y) {
		super(game, X, Y, 2);
		this.isLeft = true;
		this.moveDown = false;
		explode = 0.05;
		// TODO Auto-generated constructor stub
	}
	
	public boolean getDir() {return isLeft;}
	public boolean setDir(boolean dir) {return this.isLeft = dir;}
	
	@Override
	public void computerAction() {
		double rand = game.getRand().nextDouble(); 
		if(explode >= rand)
			game.explosiveCarrier(this.x, this.y);
	}

	@Override
	public void onDelete() {
		game.delete(this.x, this.y);
	}

	@Override
	public String toString() {
		return "-<" + shield + ">-";
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

		
}



