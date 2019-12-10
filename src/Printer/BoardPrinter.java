package Printer;

import Juego.Game;



public class BoardPrinter extends GamePrinter {
	private int numRows;
	private int numCols;
	String[][] board;
	final String space = " ";
	
	public BoardPrinter(int cols, int rows){
		this.numRows = rows;
		this.numCols = cols;
	}
	public BoardPrinter(Game game) {
		// TODO Auto-generated constructor stub
	}
	private void encodeGame(Game game) {
		board = new String[numRows][numCols];
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numCols; j++) {
				board[i][j] =  game.positionToString(i, j);
			}
		}
	}
	@Override
	public String toString(Game game) {
		encodeGame(game);
		int cellSize = 7;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		
		String rowDelimiter = MyStringUtils.repeat(hDelimiter, (numCols * (cellSize + 1)) - 1);
		String margin = MyStringUtils.repeat(space, marginSize);
		String lineDelimiter = String.format("%n%s%s%n", margin + space, rowDelimiter);
		
		StringBuilder str = new StringBuilder();
		//
		//
		//AÑADIMOS LA INFO DE LA PARTIDA AL TABLERO
		str.append(game.infoToString());
		//
		//
		//
		str.append(lineDelimiter);
		
		for(int i=0; i<numRows; i++) {
				str.append(margin).append(vDelimiter);
				for (int j = 0; j < numCols; j++) {
					str.append( MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
				}
				str.append(lineDelimiter);
		}
		return str.toString();
	}

	@Override
	public GamePrinter parse(String name) {
		if (name.equalsIgnoreCase("formattedprinter"))
			return new BoardPrinter(Game.DIM_X, Game.DIM_Y);
		else 
			return null;
	}

	@Override
	public String helpText() {
		return "BoardPrinter: pinta el tablero.";
	}
	@Override
	public GamePrinter setGame(Game game) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
