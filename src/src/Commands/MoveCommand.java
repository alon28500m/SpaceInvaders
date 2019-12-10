package Commands;

import java.util.Scanner;

import Exceptions.CommandParseException;
import Juego.Game;

public class MoveCommand extends Command{
Scanner in;

	public MoveCommand(Scanner input, String commandText) {
		super("move","m", commandText, "[M]ove <left(-)|right(+)><1|2>: causes the UCM-Ship to move as indicated.");
		in = input;
	}

	@Override
	public boolean execute(Game game)  {
		boolean keepGoing = true;
		try {
			int aux = Integer.parseInt(getCommandText());
			boolean isLeft = false;
			int speed = Math.abs(aux);
			if(aux  < 0) {
				isLeft = true;
			}
			game.MovePlayer(isLeft, speed);
		}
		catch(CommandParseException exc) {
			System.out.println(super.incorrectArgsMsg);
		}
		return keepGoing;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException{
		try {
			MoveCommand move;
			if ((commandWords[0].equals(this.name))||(commandWords[0].equals(this.shortName))) {
					move = new MoveCommand(in, commandWords[1]);
					return move;
			}
			else
				return null;
		}
		catch(CommandParseException e) {
			e = new CommandParseException(Command.incorrectArgsMsg);
			
		}
	}

}
