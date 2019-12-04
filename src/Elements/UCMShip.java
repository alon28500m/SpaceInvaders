package Elements;

import Juego.Game;

public class UCMShip extends Ship{
	private boolean shockwave;
	private Weapon misil; // ??????
	private boolean supermisil;
	private int points;
	private boolean isLeft;
	private int speed;
	public UCMShip(Game game, int X, int Y, int lives) {
		super(game, X, Y, lives);
		shockwave = false;
		misil = null;
		points = 0;
		isLeft = false;
		setSpeed(0);
		setSupermisil(false);
		// TODO Auto-generated constructor stub
	}
	public boolean getShockwave() {return this.shockwave;}
	public boolean setShockwave(boolean wave) {return shockwave = wave;}
	
	public void shootSuper() {
		if(misil.equals(null)) {
			misil = new SuperMissile(game, this.x, this.y);
			game.addObject(misil);
		}
	}
	public void shootMissile() {
		if(misil.equals(null)) {
			misil = new Missile(game, this.x, this.y, 1);
			game.addObject(misil);
		}
	}
	@Override
	public void computerAction() {
		
	}

	@Override
	public void onDelete() {
		game.delete(this.x, this.y);
		
	}

	@Override
	public void move() {
		if((this.x < 8)&&(this.x > 0)) {
			if(isLeft)
				x -= speed;
				if(x < 0)
					x = 0;
			else
				x += speed;
				if(x > 8)
					x = 8;
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	public void enableMisil() {this.misil = null;}
	public void setPoints(int p) {this.points += p;}
	public int getPoints() {return this.points;}
	public void incrementX(int value) {this.x += value;}
	public void decrementX(int value) {this.x -= value;}
		// TODO Auto-generated method stub
	public void setX(int value) {this.x = value;}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void setDir(boolean dir) { this.isLeft = dir;}
	
	public boolean getSupermisil() {
		return supermisil;
	}
	public void setSupermisil(boolean supermisil) {
		this.supermisil = supermisil;
	}
	public boolean recieveBombAttack(int amount) {
		getDamage(amount);
		return true;
	}
	public boolean recieveMissileAttack(int amount) {
		return false;
	}
	public boolean recieveShockwaveAttack(int amount) {
		return false;
	}
}

