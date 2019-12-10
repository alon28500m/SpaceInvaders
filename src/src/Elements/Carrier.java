package Elements;


import Juego.Game;

public class Carrier extends AlienShip{
	
	double explode;
	public Carrier(Game game, int X, int Y) {
		super(game, X, Y, 2);
		isLeft = true;
		moveDown = false;
		explode = 0.05;
		// TODO Auto-generated constructor stub
	}
	
	
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

		
}



