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
			for(int i = 0; i < level.getNumCarrierShips(); i++) {
				board.elements[i+board.getcurrentElements()] = new Carrier(game, i % level.getNumCarrierShipsPerRow(), 1 + i/level.getNumCarrierShipsPerRow());
				board.add(board.elements[i]);
			}
	}

	private void initializeDestroyers() {
		for(int i = 0; i < level.getNumDestroyersPerRow(); i++) {
			board.elements[i + board.getcurrentElements()] = new Destroyer(game, i%level.getNumDestroyersPerRow(),Game.DIM_Y- 1 - i/level.getNumDestroyersPerRow()); ;
			board.add(board.elements[i]);
		}
	}
}