package Commands;

import java.util.Random;
import java.util.Scanner;

import Juego.Board;
import Juego.Game;
import Juego.Level;
import Printer.BoardPrinter;
import Printer.GamePrinter;


public class ResetCommand extends NoParamsCommand{
Scanner in;
Board board;
GamePrinter print;
Random rand;
	public ResetCommand() {
		super("reset", "r", "", "[R]eset: starts a new game.\n");
		in = new Scanner(System.in);
	}

	@Override
	public boolean execute(Game game) {
		Level d = Level.EASY;
		System.out.println("Choose a dificulty(0 - easy, 1 - hard, 2 - insane)");
		int temp_dif = in.nextInt();
		if(temp_dif == 1)
			d = Level.HARD;
		else if(temp_dif == 2)
			d = Level.INSANE;
	
		game = new Game(d, rand);
		print = new BoardPrinter(game);
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		ResetCommand reset;
		if((commandWords[0].contentEquals(this.name))||(commandWords[0].contentEquals(this.shortName))) {
			reset = new ResetCommand();
			return reset;
		}
		else
			return null;
	}

}
