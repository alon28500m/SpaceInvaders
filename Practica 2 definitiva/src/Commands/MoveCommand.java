package Commands;

import java.util.Scanner;


import Juego.Game;

public class MoveCommand extends Command{
Scanner in;
private isLeft;
	public MoveCommand(Scanner input, String commandText) {
		super("move","m", commandText, "[M]ove <left|right><1|2>: causes the UCM-Ship to move as indicated.");
		in = input;
		isLeft = true;
	}

	@Override
	public boolean execute(Game game)  {
		boolean keepGoing = true;
			int aux = Integer.parseInt(getCommandText());
			int speed = Math.abs(aux);
			game.MovePlayer(isLeft, speed);
		
		return keepGoing;
	}

	@Override
	public Command parse(String[] commandWords) {
		
			MoveCommand move;
			if ((commandWords[0].equals(this.name))||(commandWords[0].equals(this.shortName))) {
					move = new MoveCommand(in, commandWords[2]);
					if(commandWords[1] == "left") {
						isLeft = true;
					}
					else if (commandWords[1] == "right") {
						isLeft = false;
					}
					return move;
			}
			else
				return null;
	}

}
