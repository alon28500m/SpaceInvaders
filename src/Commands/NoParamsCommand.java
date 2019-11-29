package Commands;

import Juego.Game;

public abstract class NoParamsCommand extends Command{

	public NoParamsCommand(String name, String shortName, String commandText, String helpText) {
		super(name, shortName, commandText, helpText);
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract boolean execute(Game game);
	@Override
	public abstract Command parse(String[] commandWords);

}
