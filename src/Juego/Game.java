package Juego;

import java.util.Random;

import Elements.ExplosiveShip;
import Elements.GameElement;
import Elements.SuperMissile;
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
	}
	public Random getRand() {return this.rand;}
	public void initGame() {
		currentCycle = 0;
		board = initializer.initialize(this, level);
		player = new UCMShip( this, DIM_X / 2, DIM_Y - 1, 3);
		board.add(player);
	}

	public Random getRandom() {
		return rand;
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

	public String positionToString( int X, int Y ) {
		return board.toString( X,Y);
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
		return null;/* game-state string to be printed with the board */
	}
	
	public String getWinnerMessage () {
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
	
		@Override
		public boolean shootMissile() {
			player.computerAction();
			return false;
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
			player.setShockwave(true);
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
			int idx = findElement(X,Y);
			ExplosiveShip explosive = new ExplosiveShip(this, X, Y, 1);
			if(idx != -1)
					board.elements[idx] = explosive;
		}
		public void explode(int X, int Y) {
			for(int i = 0; i < 9; i++) {
				board.damage(findElement(X-i%3-1,Y-i/3+1));
			}
		}
		public int findElement(int X, int Y) {
			return board.find(X, Y);
		}
		
	}