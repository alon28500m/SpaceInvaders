package Commands;

import java.util.Scanner;

import Juego.Game;

public class ShootCommand extends Command {
	Scanner in;
	public ShootCommand(Scanner input) {
		super("shoot", "s", "<supermissile>", "The player shoots a missile");
		in = input;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		boolean keepGoing = true;
		String arg = in.next();
		if(arg.contentEquals("supermissile")) {
			if(!game.getSuperMissile())
			{
				keepGoing = false;
				System.out.println("Error, no supermissile");
			}
		}
		else
			game.shootMissile();
		return keepGoing;
	}

	@Override
	public Command parse(String[] commandWords) {
		// TODO Auto-generated method stub
		return null;
	}

}
