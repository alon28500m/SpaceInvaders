import Juego.Game;

public class BoardPrinter extends GamePrinter {
int rows = 8, columns = 9;
	
	private int cellSize = 7;
	private String space = " ";
	private String vDelimiter = "|";
	private String hDelimiter = "-";
	
	private Game game;
	
	public BoardPrinter(){
		
	}
	
	public String toString()
	{
		String out = "";
		
		out += "Score: " + game.getScore() + "\n" ; 
		out += "Shield: " + game.getShield() + "\n";
		out += "ShockWave: " + (game.getSchockwave() ? "YES" : "NO") + "\n";
		out += "Cycle number: " + game.getCurrentCycle() + "\n";
		//aliens remaining
		
		
		
		out += "\n" + " " + MyStringUtils.repeat(hDelimiter, (7+1)*columns) + "\n"; 
		
		for (int j = 0; j < rows; j++) 
		{
			out += vDelimiter;
			for (int i = 0; i < columns; i++) 
			{
				String cur_cell = game.printElement(i, j);
				
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
}
