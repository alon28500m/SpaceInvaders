package Elements;

import Juego.Game;

public class SuperMissile extends Weapon{
	private int cost;
	public SuperMissile(Game game, int X, int Y) {
		super(game, X, Y, 2);
		cost = 20;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void computerAction() {
		if(game.damage(x, y + 1, shield))
			this.onDelete();
	}

	@Override
	public void onDelete() {
		game.delete(x, y);
		
	}

	@Override
	public void move() {
		y++;		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "^";
	}

	public int getCost() {
		return cost;
	}

}
