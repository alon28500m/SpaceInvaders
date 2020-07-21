package Commands;

import java.util.Scanner;

import Juego.Game;

public class MoveCommand extends Command {
	Scanner in;
	private boolean dir;
	int speed;

	public MoveCommand(Scanner input, String commandText, boolean direction) {
		super("move", "m", commandText, "[M]ove <left|right><1|2>: causes the UCM-Ship to move as indicated.");
		in = input;
	}

	@Override
	public boolean execute(Game game) {
		game.MovePlayer(speed, dir);
		return true;

	}

	@Override
	public Command parse(String[] commandWords) {
		MoveCommand move = null;
		if ((commandWords[0].equals(this.name)) || (commandWords[0].equals(this.shortName))) {
			speed = Integer.parseInt(commandWords[2]);
			if(commandWords[1].equals("right")||commandWords[1].equals("r")) {
				dir = false;
				move = this;
			}
			else if(commandWords[1].equals("left")||commandWords[1].equals("l")) {
				dir = true;
				move = this;
			}
			return move;
		} else
			return null;
	}

}
