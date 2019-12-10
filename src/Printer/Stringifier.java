package Printer;

import Juego.Game;

public class Stringifier extends GamePrinter {

	
		public Stringifier(Game game) {
		// TODO Auto-generated constructor stub
	}

		public String toString(Game game) {
			String out = "";
			out += "- - - Space Invaders 2 - - - /n";
			out += "/n";
			out += "Number of cycles: " + game.getCurrentCycle();
			out += game.getLevel();
			out += game.infoToString();
			return out;
		}

		@Override
		public GamePrinter setGame(Game game2) {
			Stringifier strfier = new Stringifier(game2);
			return strfier;
		}
}
