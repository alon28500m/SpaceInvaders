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
	return false;
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
