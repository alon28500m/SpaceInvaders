package Commands;

import Juego.Game;

public class HelpCommand extends NoParamsCommand{

	public HelpCommand() {
		super("help", "h", "", "[H]elp: prints this help message.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		boolean ok = false;
			System.out.print(CommandGenerator.commandHelp());
			ok = true;
		return ok;
	}

	@Override
	public Command parse(String[] commandWords) {
		HelpCommand help;
		if ((commandWords[0].equals(this.name))||(commandWords[0].equals(this.shortName))) {
			 help = new HelpCommand();
			return help;
		}
		else
			return null;
	}

}
