package Commands;

import java.util.Scanner;

import Juego.Game;

public class MoveCommand extends Command{
Scanner in;

	public MoveCommand(Scanner input, String commandText) {
		super("move","m", commandText, "[M]ove <left|right><1|2>: causes the UCM-Ship to move as indicated.");
		in = input;
	}

	@Override
	public boolean execute(Game game) {
		boolean keepGoing = true;
		
		
		return keepGoing;
	}

	@Override
	public Command parse(String[] commandWords) {
		MoveCommand move;
		if ((commandWords[0].equals(this.name))||(commandWords[0].equals(this.shortName))) {
			if(commandWords[1].equals("left")||commandWords[1].equals("l")) {
				move = new MoveCommand(in,"left "+commandWords[2]);
				return move;
			}
			else {
				move = new MoveCommand(in, "right "+commandWords[2]);
				return move;
			}
		}
		else
			return null;
		
	}

}
