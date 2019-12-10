package Commands;

import java.util.Scanner;

import Juego.Game;

public class ShootCommand extends Command {
	Scanner in;
	public ShootCommand(Scanner input, String commandText) {
		super("shoot", "s", commandText, "The player shoots a missile");
		in = input;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		boolean keepGoing = true;
		if(getCommandText().contentEquals("supermissile")) {
			if(!game.getSuperMissile())
			{
				keepGoing = false;
				System.out.println("Error, no supermissile");
			}
			game.shootSuper();
		}
		else
			game.shootMissile();
		return keepGoing;
	}

	@Override
	public Command parse(String[] commandWords) {
		ShootCommand shoot;
		if ((commandWords[0].equals(this.name)) || (commandWords[0].equals(this.shortName))) {
			shoot = new ShootCommand(in, commandWords[1]);
			return shoot;
		} else
			return null;
	}

}
