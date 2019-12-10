package Commands;

import Juego.Game;

public class ListCommand extends NoParamsCommand {

	public ListCommand() {
		super("list", "l", "", "[L]ist: displays the list of ship types in the game.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		boolean keepGoing = true;
		System.out.println(
				"-<x>-: Points: 5 - Damage: 0 - Resistence: 2\n" +
				"!<x>!: Points: 10 - Damage: 1 - Resistence: 1\n" +
				"<(+)>: Points: 25 - Damage: 0 - Resistence: 1\n" +
				"/-^-\\: Damage: 1 - Resistence: 3\n"
				);
				keepGoing = false;
		return keepGoing;
	}

	@Override
	public Command parse(String[] commandWords) {
		ListCommand list;
		if ((commandWords[0].equals(this.name))||(commandWords[0].equals(this.shortName))) {
			 list = new ListCommand();
			return list;
		}
		else
			return null;
	}

}
