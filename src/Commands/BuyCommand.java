package Commands;

import java.util.Scanner;

import Juego.Game;

public class BuyCommand extends Command{
	Scanner in;
	public BuyCommand(Scanner input, String commandText) {
		super("buy", "b", commandText, "[B]uy: Gets a supermissile in exchange of points");
		in = input;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		boolean keepGoing = true;
		if(getCommandText().contentEquals("supermissile")) {
			if(!game.buySuperMissile())
			{
				keepGoing = false;
				System.out.println("Error, not enough points:(");
			}
		}
		return keepGoing;
	}

	@Override
	public Command parse(String[] commandWords) {
		BuyCommand buy;
		if ((commandWords[0].equals(this.name))||(commandWords[0].equals(this.shortName))) {
			 buy = new BuyCommand(in,commandWords[1]);
			 return buy;
		}
		else
			return null;
	}
}
