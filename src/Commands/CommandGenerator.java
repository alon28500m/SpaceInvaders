package Commands;

import java.util.Scanner;

public class CommandGenerator {
	static Scanner input;
	private static Command[] availableCommands = { new ListCommand(), new HelpCommand(), new ResetCommand(input),
			new ExitCommand(), new UpdateCommand(), new MoveCommand(input, null), new ShockwaveCommand(), new BuyCommand(input, null), new ShootCommand(input, null) };

	public static Command parseCommand(String[] commandWords) {
		boolean found = false;
		int i = 0;
		Command command = null;
		while (( i < 9)&&(!found)) {
			if(availableCommands[i].parse(commandWords) != null) {
				found = true; 
				command = availableCommands[i].parse(commandWords);
			}
			else 
				i++; 
		}
		return command;	
	}
	
	public static String commandHelp() {
		String str = "";
		for(int i = 0; i < 7; i++) {
			str += availableCommands[i].helpText();
		}
		return str;
	}
}
