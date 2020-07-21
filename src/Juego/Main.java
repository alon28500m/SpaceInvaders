

//save command y files
// revisar update
//Como usar printerTypes en stringifier



package Juego;

import java.util.Random;


public class Main {
	public static void main(String[] args) {
		int seed = 0;
		Level dif = Level.INSANE;
		Random rand;
		if(args.length > 0) {
			dif = Level.StringToLevel(args[0]);
			if(args.length > 1)
				seed = Integer.parseInt(args[1]);
			else
				System.out.println("You may choose a seed as well in the arguments");
			// añadir excepcion
		}
		else
			System.out.println("You should define the arguments to chose dificulty and seed");
		rand = new Random(seed);
		Game game = new Game(dif, rand);
		Controller ctlr = new Controller(game);
		ctlr.execute(); 
	}
}

