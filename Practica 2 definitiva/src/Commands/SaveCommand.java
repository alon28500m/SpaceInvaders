package Commands;


import java.util.Scanner;

import Juego.Game;

public class SaveCommand extends Command{
Scanner in;
	public SaveCommand(Scanner input, String fileName) {
		super("save", "s", fileName, "Saves the state of the game in a file.");
		in = input;
	}

	@Override
	public boolean execute(Game game) {

		
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		SaveCommand save;
		if ((commandWords[0].equals(this.name)) || (commandWords[0].equals(this.shortName))) {
			save = new SaveCommand( in, commandWords[1]);
			return save;
		}
		System.out.println("Game successfully saved in file "+ commandWords[1]+".dat. Use the load command to reload it");
		return null;
	}
	
}
