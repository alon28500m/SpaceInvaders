package Elements;

import Juego.Game;

public class Destroyer extends AlienShip {
	public static final int points = 5;

	private Bomb bomb;
	private boolean hasBomb;

	public Destroyer(Game game, int X, int Y) {
		super(game, X, Y, 2);
		bomb = null;
		hasBomb = false;
	}

	@Override
	public void computerAction() {
		if (!hasBomb) {
			double prob = game.getLevel().getShootFrequency();
			double rand = game.getRand().nextDouble();

			if (rand <= prob) {
				bomb = new Bomb(game, this.x, this.y + 1, 1);
				game.addObject(bomb);
			}
		}
	}

	@Override
	public void onDelete() {
		game.delete(this.x, this.y);
		game.receivePoints(points);
	}

	public String toString() {
		return " !<" + shield + ">!";
	}

}
