package Printer;

import Juego.Game;

public class Stringifier extends GamePrinter {

	
		public Stringifier(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

		public String toString() {
			String out = "";
			out += "- - - Space Invaders 2 - - - /n";
			out += "/n";
			out += "Number of cycles: " + game.getCurrentCycle();
			out += game.getLevel();
			out += game.infoElements();
			return out;
		}
}
