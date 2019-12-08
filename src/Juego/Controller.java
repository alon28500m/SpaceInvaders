package Juego;


import java.util.Scanner;

import Commands.Command;
import Commands.CommandGenerator;
import Printer.GamePrinter;
import Printer.PrinterTypes;

public class Controller {
	GamePrinter printer;
	PrinterTypes generator;
	Game game;
	Scanner in;
	private static final String unknownCommandMsg = "Error. The command does not exist";
	private static final String PROMPT = ">";
	public Controller(Game game) {
		this.game = game;
		in = new Scanner(System.in);
	}
	public void execute() {
		printer = PrinterTypes.BOARDPRINTER.getObject(game);
		System.out.println(printer);
		while (!game.isFinished()) {
			System.out.println(PROMPT);
			String[] words = in.nextLine().toLowerCase().trim().split("\\s+");
			Command command = CommandGenerator.parseCommand(words);
			if (command != null)
				if (command.execute(game)) {
					System.out.println(printer);
					game.update();
				}
				else
					System.out.format(unknownCommandMsg);
		}
	}
}
