package Elements;

import Juego.Game;

public class Destroyer extends AlienShip{
	public static final int points = 5;
	
	private Bomb bomb;
	public Destroyer(Game game, int X, int Y, int lives) {
		super(game, X, Y, lives);
		bomb = null;
	}

	@Override
	public void computerAction() {
		double prob = game.getLevel().getShootFrequency();
		double rand = game.getRand().nextDouble(); 
		
		if(rand <= prob && (bomb.equals(null)))
		{	
			bomb = new Bomb(game, this.x, this.y, 1);
			game.addObject(bomb);
		}
	}

	@Override
	public void onDelete() {
		game.delete(this.x, this.y);
		game.receivePoints(points);
	}

	@Override
	public void move() {
		this.x++;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
