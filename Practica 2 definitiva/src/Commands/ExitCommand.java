package Commands;

import Juego.Game;

public class ExitCommand extends NoParamsCommand{

	public ExitCommand() {
		super("exit", "e", "", "[E]xit: terminates the program.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		game.StopPlaying();;
		System.out.println("GAME OVER\nPlayer exit");
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		ExitCommand exit;
		if ((commandWords[0].equals(this.name))||(commandWords[0].equals(this.shortName))) {
			 exit = new ExitCommand();
			return exit;
		}
		else
			return null;
	}
}
