package Printer;
import Juego.Board;
import Juego.Game;

public class BoardPrinter extends GamePrinter {
int rows = 8, columns = 9;
	Board board;
	private int cellSize = 7;
	private String space = " ";
	private String vDelimiter = "|";
	private String hDelimiter = "-";
	
	public BoardPrinter(Game game, Board tablero){
		super(game);
		board = tablero;
	}
	
	public String toString()
	{
		String out = "";
		
		out += game.infoToString();
		
		
		
		out += "\n" + " " + MyStringUtils.repeat(hDelimiter, (7+1)*columns) + "\n"; 
		
		for (int j = 0; j < rows; j++) 
		{
			out += vDelimiter;
			for (int i = 0; i < columns; i++) 
			{
				String cur_cell = game.positionToString(i, j);
				
				if(cur_cell == null)
					out += MyStringUtils.repeat(space, cellSize);
				else
					out += MyStringUtils.centre(cur_cell, cellSize);
				
				out += vDelimiter;
			}
			out += "\n" + " " + MyStringUtils.repeat(hDelimiter, (7+1)*columns) + "\n";
		}
		
		return out;
	}

	@Override
	public GamePrinter setGame(Game game2) {
		BoardPrinter boardPrinter = new BoardPrinter(game2, board);
		return boardPrinter;
		
	}
}
