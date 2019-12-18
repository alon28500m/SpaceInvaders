  package Commands;

import java.util.Scanner;

import Juego.Game;
import Printer.PrinterTypes;
import Printer.Stringifier;

public class StringifyCommand extends Command {
	private static final String PROMPT = ">";
	private static final String unknownCommandMsg = "Error. The command does not exist";
	Stringifier printer;
	Scanner in;
	PrinterTypes generator;

	public StringifyCommand(Stringifier stringer, Scanner input) {
		super("stringify", "str", "", "Stringifies the state of the game");
		printer = stringer;
		in = input;
	}

	@Override
	public boolean execute(Game game) {
		boolean keepGoing = false;
		System.out.println(printer);
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
		keepGoing = true;
		return keepGoing;
	}

	@Override
	public Command parse(String[] commandWords) {
		StringifyCommand stringify;
		if ((commandWords[0].equals(this.name)) || (commandWords[0].equals(this.shortName))) {
			stringify = new StringifyCommand(printer, in);
			return stringify;
		} 
		else
			return null;
	}

}
