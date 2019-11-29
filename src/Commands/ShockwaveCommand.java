package Commands;

import Juego.Game;

public class ShockwaveCommand extends NoParamsCommand{

	public ShockwaveCommand() {
		super("shockwave", "w", "", "shock[W]ave: causes the UCM-Ship to release a shock wave.\n");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		boolean keepGoing = true;
		
		if(!game.GetPlayer())
		{
			keepGoing = false;
			System.out.println("Error, no shockwaves left:(");
		}
		else
			game.damageAllShips();
		
		return keepGoing;
	}

	@Override
	public Command parse(String[] commandWords) {
		ShockwaveCommand wave;
		if((commandWords[0].contentEquals(this.name))||(commandWords[0].contentEquals(this.shortName))) {
			wave = new ShockwaveCommand();
			return wave;
		}
		else
			return null;
	}

}
