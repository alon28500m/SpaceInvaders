package Juego;

import java.util.Scanner;

import Commands.Command;
import Commands.CommandGenerator;
import Exceptions.CommandExecuteException;
import Exceptions.CommandParseException;
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

		PrinterTypes enumerado = PrinterTypes.BOARDPRINTER;
		printer = enumerado.getObject(game);

		game.initGame();
		

		System.out.println(printer.toString(game));
		while (!game.isFinished()) {
			System.out.print(PROMPT);
			String[] words = in.nextLine().trim().split("\\s+");
			//try {
				Command command = CommandGenerator.parseCommand(words);
				if (command != null) {
					if (command.execute(game)) {
						System.out.println(printer.toString(game));// printear despues del update
						game.update();
					}
				} 
				else
					System.out.println(unknownCommandMsg);
			//}
			//catch (CommandParseException | CommandExecuteException | NumberFormatException | FileContentsException ex) {
			//	System.out.format(ex.getMessage()) + "%n %n";
			//}
		}
		System.out.println(game.getWinnerMessage());
	}

}