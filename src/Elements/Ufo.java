package Elements;

import Juego.Game;


public class Ufo extends EnemyShip {
private static final int points = 25;
	public Ufo(Game game) {
		super(game, 7, 8, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void computerAction() {
		double rand = game.getRand().nextDouble();
		double prob = game.getLevel().getUfoFrequency();
		if(rand <= prob)
			new Ufo(game);
		
	}

	@Override
	public void onDelete() {
		game.delete(this.x, this.y);
	}

	@Override
	public void move() {
		x--;
		
	}

	@Override
	public String toString() {
		return "<(+)>";
	}
	public int getPoints() {return Ufo.points;}
}
