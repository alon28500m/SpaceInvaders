package Commands;

import java.util.Scanner;

import Juego.Game;

public class MoveCommand extends Command{
Scanner in;
	public MoveCommand(Scanner input) {
		super("move","m", "<left|right><1|2>", "[M]ove <left|right><1|2>: causes the UCM-Ship to move as indicated.");
		in = input;
	}

	@Override
	public boolean execute(Game game) {
		boolean keepGoing = true;
		String dir = in.next().toLowerCase();
		boolean isMovementLeft = false;
		if(dir.equals("left") || dir.equals("l"))
			isMovementLeft = true;
		else if(dir.equals("right") || dir.equals("r"))
			isMovementLeft = false;

		int speed = in.nextInt();
		game.MovePlayer(isMovementLeft, speed);
		
		return keepGoing;
	}

	@Override
	public Command parse(String[] commandWords) {
		MoveCommand move;
		if ((commandWords[0].equals(this.name))||(commandWords[0].equals(this.shortName))) {
			 move = new MoveCommand(in);
			return move;
		}
		else
			return null;
	}

}
