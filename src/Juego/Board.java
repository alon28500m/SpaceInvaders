package Juego;


import Elements.GameElement;
import Elements.Ship;
import Elements.SuperMissile;


public class Board {
	Level level;
	protected GameElement elements[];
	private int currentElements;

	public Board(int width, int height) {
		currentElements = width * height;
	}
	public Board(Game game, int X, int Y, int lives) {
		
		elements = new GameElement[currentElements];
		for (int i = 0; i < currentElements; i++) {
			elements[i] = null;
		}
	}

	public void add(GameElement gameElement) {
			elements[currentElements] = gameElement;
		currentElements++;
	}

	public void update() {
		int moveCount = 0;
		for(int i = 0; i < currentElements; i++) {
			elements[i].computerAction();
			if(moveCount == 0) {
				moveCount = level.getNumCyclesToMoveOneCell();
				elements[i].move();
				moveCount--;
			}
			
		}

	}

	public void computerAction() {
// TODO implement
	}
	public int getCurrentElements() {return currentElements;}

	public String toString( int X, int Y ) {
		String out = "";
		out = elements[getIndex(X,Y)].toString();
		return out;
	}
	
	private GameElement getObjectAt ( int X, int Y) {
		return elements[getIndex(X,Y)];
	}
	
	private int getIndex( int X, int Y ) {
		int idx = -1;
		for (int i = 0; i < currentElements; i++) {
			if((elements[i].getX() == X)&&(elements[i].getY()==Y)) {
				idx = i; 
				break;
			}
		}
		return idx;
	// TODO implement
	}
	
	private void remove(GameElement gameElement) {
			int i = 0;
			i = getIndex(gameElement.getX(), gameElement.getY());
			while ( i < currentElements) {
				elements[i] = elements[i+1];
				i++;
			}
			currentElements--;
	}
	
	public int getcurrentElements() {
			return currentElements;
	}

	public void removeDead() {

	}
	public void delete(int X, int Y) {
		this.remove(this.getObjectAt(X, Y));
	}
	public void damageAll() {
		for(int i = 0; i < currentElements; i++) {
			elements[i].decreaseShield();
			if(!elements[i].isAlive()) {
				remove(elements[i]);
				i--;
			}
		}
	}
	public boolean allDead() {
		return currentElements == 0;
	}
	public boolean haveLanded() {
		boolean ok = false;
		for(int i = 0; i < currentElements; i++) {
			if(elements[i] instanceof Ship) {
				ok = elements[i].getY() == 0;
				break;
			}
		}
		return ok;
	}
	public int find(int X, int Y) {
		int idx = -1;
		for(int i = 0; i < currentElements; i++) {
			if((elements[i].getX()==X)&&(elements[i].getY()==Y)) {
				idx = i;
				break;
			}			
		}
		return idx;
	}
	public void damage(int idx) {
		elements[idx].decreaseShield();
		
	}
}