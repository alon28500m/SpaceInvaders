package Commands;

import Juego.Game;

public class UpdateCommand extends NoParamsCommand{

	public UpdateCommand() {
		super("none", "n", "", "[N]one: skips one cycle.\n");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		UpdateCommand update;
		if ((commandWords[0].equals(this.name))||(commandWords[0].equals(this.shortName))) {
			 update = new UpdateCommand();
			return update;
		}
		else
			return null;
	}

}
