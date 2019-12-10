package Juego;

import java.util.Random;

import Elements.Carrier;
import Elements.Destroyer;
import Elements.ExplosiveShip;
import Elements.GameElement;
import Elements.UCMShip;

public class Game implements IPlayerController {
	public final static int DIM_X = 9;
	public final static int DIM_Y = 8;
	private int currentCycle;
	private Random rand;
	private Level level;
	Board board;
	private UCMShip player;
	private boolean doExit;
	private BoardInitializer initializer;

	public Game(Level gameLevel, Random random) {
		rand = random;
		level = gameLevel;
		initializer = new BoardInitializer();
		initGame();
		doExit = false;
	}

	public Random getRand() {
		return this.rand;
	}

	public void initGame() {
		currentCycle = 0;
		player = new UCMShip(this, DIM_Y - 1, DIM_X/2, 3);
		board = initializer.initialize(this, level);
		board.add(player);
	}

	public boolean getSuperMissile() {
		return player.getSupermisil();
	}

	public Level getLevel() {
		return level;
	}

	public void reset() {
		initGame();
	}

	public void addObject(GameElement object) {
		board.add(object);
	}

	public String positionToString(int i, int j) {
		return board.toString(i,j);
	}

	public boolean isFinished() {
		return playerWins() || aliensWin() || doExit;
	}

	public boolean aliensWin() {
		return !player.isAlive() || board.haveLanded();
	}

	private boolean playerWins() {
		return board.allDead();
	}

	public void update() {
		board.computerAction();
		board.update();
		setCurrentCycle(getCurrentCycle() + 1);
	}

	public boolean isOnBoard(int X, int Y) {
		return X < DIM_X && Y < DIM_Y;
	}

	public void exit() {
		doExit = true;
	}

	public String infoToString() {
		String out = "";
		out += "Ufo: U, x, y, 1";
		out += "Carrier ship: C;x,y;2;" + level.getNumCyclesToMoveOneCell() ;
		out += "Ufo: U;x;y;shield";
		out += "Carrier ship: C;x,y;shield;" + level.getNumCyclesToMoveOneCell() + Carrier.getDir();
		out += "Destroyer: D;x,y;shield;" + level.getNumCyclesToMoveOneCell();Destroyer.getDir();
		out += "Explosive ship: E;x,y;shield;" + level.getNumCyclesToMoveOneCell();ExplosiveShip.getDir();
		out += "Bomb: B;x,y";
		out += "Missile: M;x,y";
		out += "Supermissile: X;x,y";
		out += "UCMShip (player): P;x,y;shield;"+ player.getPoints() + player.getShockwave() + player.getSupermisil();
		return out; 
	}

	public String getWinnerMessage() {
		if (playerWins())
			return "Player win!";
		else if (aliensWin())
			return "Aliens win!";
		else if (doExit)
			return "Player exits the game";
		else
			return "This should not happen";
	}

	public boolean GetPlayer() {
		return player.getShockwave();
	}
	// TODO implement the methods of the IPlayerController interface

	public void StopPlaying() {
		doExit = true;
	}

	public void delete(int X, int Y) {
		board.delete(X, Y);
	}

	@Override
	public boolean MovePlayer(boolean isMovementLeft, int speed) {
		boolean ok = false;
		player.setDir(isMovementLeft);
		player.setSpeed(speed);
		player.move();
		ok = true;
		return ok;
	}

	public boolean shootSuper() {
		player.shootSuper();
		return true;
	}
	@Override
	public boolean shootMissile() {
		player.computerAction();
		return true;
	}
	

	@Override
	public boolean shockWave() {
		boolean ok = false;
		if (player.getShockwave()) {
			board.damageAll();
			ok = true;
		}
		return ok;
	}

	@Override
	public void receivePoints(int points) {
		player.setPoints(points);
	}

	@Override
	public void enableShockWave() {
		player.setShockwave(false);
	}

	@Override
	public void enableMissile() {
		player.enableMisil();
	}

	public int getCurrentCycle() {
		return currentCycle;
	}

	public void setCurrentCycle(int currentCycle) {
		this.currentCycle = currentCycle;
	}

	public void damageAllShips() {
		board.damageAll();
	}

	public void explosiveCarrier(int X, int Y) {
		board.explosiveCarrier(X, Y);
	}

	public void explode(int X, int Y) {
		board.explode(X, Y);
	}

	public boolean damage(int X, int Y, int amount) {
		 return board.damage(X, Y, amount);
	}
	public boolean checkCollision(int X, int Y) {
		return board.checkCollision(X,Y);
	}
	public int getScore() {
		return player.getPoints();
	}

	public int getShield() {
		return player.getShield();
	}

	public boolean getSchockwave() {
		return player.getShockwave();
	}

	public boolean buySuperMissile() {
		boolean ok = false;
		if (player.getPoints() > 20) {
			ok = true;
			player.setSupermisil(ok);
		}
		return ok;
	
	}
}


