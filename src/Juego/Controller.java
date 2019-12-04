package Juego;

import java.util.Random;
import java.util.Scanner;

import Commands.Command;
import Commands.CommandGenerator;
import Printer.BoardPrinter;
import Printer.GamePrinter;

public class Controller {
	GamePrinter printer;
	Game game;
	Level level;
	Scanner in;
	private static final String unknownCommandMsg = "Error. The command does not exist";
	public Controller(Readable input, BoardPrinter print) {
		in = new Scanner(input);
		printer = print;
	}
	public void execute() {
		while (!game.isFinished()) {
			System.out.println(PROMPT);
			String[] words = in.nextLine().toLowerCase().trim().split("\\s+");
			Command command = CommandGenerator.parseCommand(words);
			if (command != null)
				if (command.execute(game))
					System.out.println(printer);
				else
					System.out.format(unknownCommandMsg);
		}
	}
}
