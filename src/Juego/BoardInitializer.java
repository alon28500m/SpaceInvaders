package Juego;

import Elements.Carrier;
import Elements.Destroyer;
import Elements.Ufo;

public class BoardInitializer {
	private Level level;
	private Board board;
	private Game game;

	public Board initialize(Game game, Level level) {
		this.level = level;
		this.game = game;
		board = new Board(Game.DIM_X, Game.DIM_Y);
		initializeUfo();
		initializeCarrierShips();
		initializeDestroyers();
		return board;
	}

	private void initializeUfo() {
			board.elements[board.getcurrentElements()] = new Ufo( game);
			board.add(board.elements[board.getcurrentElements()]);
		}

	private void initializeCarrierShips() {
			for(int i = board.getcurrentElements(); i < level.getNumCarrierShips() + board.getcurrentElements(); i++) {
				board.elements[i] = new Carrier(game, i%level.getNumCarrierShipsPerRow(),Game.DIM_Y- 1 - i/level.getNumCarrierShipsPerRow()); ;
				board.add(board.elements[i]);
			}
	}

	private void initializeDestroyers() {
		for(int i = board.getcurrentElements(); i < level.getNumDestroyersPerRow() + board.getcurrentElements(); i++) {
			board.elements[i] = new Destroyer(game, i%level.getNumDestroyersPerRow(),Game.DIM_Y- 1 - i/level.getNumDestroyersPerRow()); ;
			board.add(board.elements[i]);
		}
	}
}