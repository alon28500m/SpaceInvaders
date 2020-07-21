package Juego;

import Elements.Carrier;
import Elements.Destroyer;
import Elements.ExplosiveShip;
import Elements.GameElement;

import Elements.Ship;

public class Board {
	protected GameElement elements[];
	private int currentElements;
	Game game;

	public Board(int width, int height) {
		currentElements = 0;
		elements = new GameElement[width * height];
		for (int i = 1; i < width * height; i++) {
			elements[i] = null;
		}
	}

	public void add(GameElement gameElement) {
		elements[currentElements] = gameElement;
		currentElements++;
	}

	public void update() {

		for (int i = 0; i < currentElements; i++) {
			elements[i].move();
		}
	}

	public void computerAction() {
		for (int i = 0; i < currentElements; i++) {// esto es así?
			elements[i].computerAction();
		}
	}

	public int getCurrentElements() {
		return currentElements;
	}

	public String toString(int X, int Y) {
		String out = "";
		if (getIndex(X, Y) > -1)
			out = elements[getIndex(X, Y)].toString();
		return out;
	}

	private GameElement getObjectAt(int X, int Y) {
		return elements[getIndex(X, Y)];
	}

	private int getIndex(int X, int Y) {
		int idx = -1;
		for (int i = 0; i < currentElements; i++) {
			if ((elements[i].getX() == X) && (elements[i].getY() == Y)) {
				idx = i;
				break;
			}
		}
		return idx;
	}

	private void remove(GameElement gameElement) {
		int i = 0;
		i = getIndex(gameElement.getX(), gameElement.getY());
		while (i < currentElements) {
			elements[i] = elements[i + 1];
			i++;
		}
		currentElements--;
	}

	public void removeDead() {
		for (int i = 0; i < currentElements; i++) {
			if (elements[i].getShield() <= 0) {
				elements[i].onDelete();
			}
		}
	}

	public void delete(int X, int Y) {
		this.remove(this.getObjectAt(X, Y));
	}

	public void damageAll() {
		for (int i = 0; i < currentElements; i++) {
			elements[i].getDamage(1);
			if (!elements[i].isAlive()) {
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
		for (int i = 0; i < currentElements; i++) {
			if (elements[i] instanceof Ship) {
				ok = elements[i].getY() == 0;
				break;
			}
		}
		return ok;
	}

	public boolean damageMissile(int X, int Y, int amount) {
		boolean couldHit = false;
		couldHit = elements[getIndex(X, Y - 1)].receiveMissileAttack(amount);
		return couldHit;
	}

	public boolean damageBomb(int X, int Y, int amount) {
		boolean couldHit = false;
		couldHit = elements[getIndex(X, Y - 1)].receiveBombAttack(amount);
		return couldHit;
	}

	public void damageWave(int X, int Y) {
		for (int i = 0; i < currentElements; i++) {
			elements[i].receiveShockWaveAttack(1);
		}
	}

	public void damage(int X, int Y, int amount) {
		elements[getIndex(X, Y)].getDamage(amount);
	}

	public void explode(int X, int Y) {
		for (int i = 0; i < 9; i++) {
			damage(X - i % 3 - 1, Y - i / 3 + 1, 1);
		}

	}

	public void explosiveCarrier(int X, int Y) {
		int idx = getIndex(X, Y);
		ExplosiveShip explosive = new ExplosiveShip(game, X, Y, 1);
		if (idx != -1)
			elements[idx] = explosive;
	}

	public boolean checkCollision(int X, int Y) {
		boolean hasHit = false;
		if (getIndex(X, Y) != -1) {
			hasHit = true;
		}
		return hasHit;
	}

	public int alienCount() {
		int num = 0;
		for (int i = 0; i < currentElements; i++) {
			if (isAlienShip(i))
				num++;
		}
		return num;
	}

	public boolean isAlienShip(int idx) {
		boolean itIs = false;
		if (elements[idx] instanceof Carrier || elements[idx] instanceof Destroyer
				|| elements[idx] instanceof ExplosiveShip)
			itIs = true;
		return itIs;
	}
}