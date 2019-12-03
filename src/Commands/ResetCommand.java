package Commands;

import java.util.Random;
import java.util.Scanner;

import Juego.Game;
import Juego.Level;
import Printer.GamePrinter;


public class ResetCommand extends NoParamsCommand{
Scanner in;
GamePrinter print;
	public ResetCommand(Scanner input) {
		super("reset", "r", "", "[R]eset: starts a new game.\n");
		in = input;
	}

	@Override
	public boolean execute(Game game) {
		Level d = Level.EASY;
		System.out.println("Choose a dificulty(0 - easy, 1 - hard, 2 - insane");
		int temp_dif = in.nextInt();
		if(temp_dif == 1)
			d = Level.HARD;
		else if(temp_dif == 2)
			d = Level.INSANE;
		
		System.out.println("Choose a new seed: ");
		Random seed;
		game = new Game(d, seed);
		print = new GamePrinter(game);
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		ResetCommand reset;
		if((commandWords[0].contentEquals(this.name))||(commandWords[0].contentEquals(this.shortName))) {
			reset = new ResetCommand(in);
			return reset;
		}
		else
			return null;
		
	}

}
