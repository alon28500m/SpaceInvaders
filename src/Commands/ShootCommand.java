package Commands;

import java.util.Scanner;

import Juego.Game;

public class ShootCommand extends Command {
	Scanner in;
	private int type;

	public ShootCommand(Scanner input, String commandText) {
		super("shoot", "s", commandText, "The player shoots a missile");
		in = input;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		boolean keepGoing = true;
		if (type == 1) {
			game.shootMissile();
		} 
		else if(type == 2){
			game.shootSuper();
		}
		return keepGoing;
	}

	@Override
	public Command parse(String[] commandWords) {
		Command com = null;
	 if (commandWords.length > 1) {
         if (matchCommandName(commandWords[0])) {
         	try {
         	type = Integer.parseInt(commandWords[1]);
            
                 if (type == 1) {
                     
                     com = this;
                 }
                 else if (type == 2) {
                     
                     com = this;
                 }
         	}
                 catch (NumberFormatException e)  {
                     throw new NumberFormatException("Please make sure that the last parameter is a number");
                 }
             
         }
	 }
	 return com;
	}
}
